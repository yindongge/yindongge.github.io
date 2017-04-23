package com.kjj.commserver.service.account.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.account.OrgAccountDepositApplyDao;
import com.kjj.commserver.entity.account.OrgAccountDepositApply;
import com.kjj.commserver.entity.account.OrgAccountDepositRecords;
import com.kjj.commserver.entity.account.OrgAccountGroupUser;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyForm;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountGroupUserVo;
import com.kjj.commserver.service.account.OrgAccountDepositApplyService;
import com.kjj.commserver.service.account.OrgAccountDepositRecordsService;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.account.OrgAccountGroupUserService;
import com.kjj.commserver.util.DateFormatUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAccountDepositApplyServiceImpl extends BaseServiceImpl<OrgAccountDepositApply, Integer> implements OrgAccountDepositApplyService {
    @Resource
    private OrgAccountDepositApplyDao orgAccountDepositApplyDao;
    
    @Resource
	private OrgAccountDepositRecordsService orgAccountDepositRecordsService;
    
    @Resource 
    private OrgAccountDepositService orgAccountDepositService;
    
    @Resource
	private OrgAccountGroupUserService orgAccountGroupUserService;

    @Override
    protected BaseDao<OrgAccountDepositApply, Integer> getBaseDao() {
        return orgAccountDepositApplyDao;
    }

	@Override
	public void addOneApply(OrgAccountDepositApplyForm depositApply) {
		//两位字母开始+10位数字编码；字母格式-商城SC、车帮CB；字编码格式由两位年份+两位月份+两位日期+四位0001开始的数字自增；
		//例如-SC1603300001，四位自增不满足时升级编码格式。
		StringBuffer applyCode = new StringBuffer();
		applyCode.append(OrgAccountDepositApplyConstant.APPLY_CODE_PREFIX_SHOP)
				.append(DateFormatUtil.getDateNumber())
				.append(orgAccountDepositApplyDao.queryApplyCodeSeq());
		depositApply.setApplyCode(applyCode.toString());
		
		BigDecimal zero = new BigDecimal(0.00);
		
		if("1".equals(depositApply.getDepositType())){
			depositApply.setFundAmount(depositApply.getAmount());
			System.out.println(depositApply.getAmount().multiply(new BigDecimal(-1)));
			depositApply.setAllowanceAmount(zero);
			depositApply.setFrozenAmount(zero);
		} else if("2".equals(depositApply.getDepositType())){
			depositApply.setAllowanceAmount(depositApply.getAmount());
			depositApply.setFundAmount(zero);
			depositApply.setFrozenAmount(zero);
		} else if("3".equals(depositApply.getDepositType())){
			depositApply.setFrozenAmount(depositApply.getAmount());
			depositApply.setFundAmount(zero);
			depositApply.setAllowanceAmount(zero);
		}
		depositApply.setCreateTime(new Date());// 创建时间
		depositApply.setStatus(OrgAccountDepositApplyConstant.STATUS_DEAL_WAIT);// 状态-待处理
		depositApply.setSource(OrgAccountDepositApplyConstant.SOURCE_SHOP_PC_MANAGE); // 发起-商城后台
		
		super.add(depositApply);
	}

	@Override
	public void updateStatus(OrgAccountDepositApply apply, Map<String, Object> resultMap) {
		OrgAccountDepositRecords depositRecord = new OrgAccountDepositRecords();
		
		depositRecord.setUserId(apply.getUserId());
		depositRecord.setComment(apply.getApplyComment());
		depositRecord.setCreateTime(new Date());
		depositRecord.setOrigin(OrgAccountDepositRecordsConstant.ORIGIN_ONLINE_SHOP);// 来源-线上
		depositRecord.setReason(apply.getReason());
		depositRecord.setServiceCode(apply.getApplyCode());
		depositRecord.setType(apply.getType());

		
		// 复杂业务逻辑
		BigDecimal zero = new BigDecimal(0.00);
		if(apply.getType().equals(OrgAccountDepositApplyConstant.TYPE_MANUAL_ADD)) { // 手动增加
			depositRecord.setFundAmount(apply.getFundAmount());
			depositRecord.setAllowanceAmount(apply.getAllowanceAmount());
			depositRecord.setFrozenAmount(apply.getFrozenAmount());
		} else if(apply.getType().equals(OrgAccountDepositApplyConstant.TYPE_MANUAL_DEC)) {  // 手动减少
			if(apply.getFundAmount().compareTo(zero) != 0) {
				depositRecord.setFundAmount(apply.getFundAmount().multiply(new BigDecimal(-1)));
				depositRecord.setAllowanceAmount(zero);
				depositRecord.setFrozenAmount(zero);
			}
			if(apply.getAllowanceAmount().compareTo(zero) != 0) {
				depositRecord.setAllowanceAmount(apply.getAllowanceAmount().multiply(new BigDecimal(-1)));
				depositRecord.setFundAmount(zero);
				depositRecord.setFrozenAmount(zero);
			}
			if(apply.getFrozenAmount().compareTo(zero) != 0) {
				depositRecord.setFrozenAmount(apply.getFrozenAmount().multiply(new BigDecimal(-1)));
				depositRecord.setFundAmount(zero);
				depositRecord.setAllowanceAmount(zero);
			}
		} else if(apply.getType().equals(OrgAccountDepositApplyConstant.TYPE_MANUAL_UNFROZEN)) { // 解冻
			depositRecord.setFrozenAmount(apply.getFrozenAmount().multiply(new BigDecimal(-1)));
			
			// 解冻时要先根据可用不可提现账户的冻结总额来解冻
			BigDecimal oweOfAllowance = orgAccountDepositRecordsService.queryOweOfAllowance(apply.getUserId());
			if(oweOfAllowance.compareTo(zero) == 0){
				depositRecord.setFundAmount(apply.getFrozenAmount());
				depositRecord.setAllowanceAmount(zero);
			} else {
				if(oweOfAllowance.compareTo(apply.getFrozenAmount()) == 1){ //  欠:500 款:300
					depositRecord.setAllowanceAmount(apply.getFrozenAmount());
					depositRecord.setFundAmount(zero);
				} else { // 欠:500 款:800
					depositRecord.setAllowanceAmount(oweOfAllowance);
					depositRecord.setFundAmount(apply.getFrozenAmount().subtract(oweOfAllowance));
				}
			}
		} else if(apply.getType().equals(OrgAccountDepositApplyConstant.TYPE_MANUAL_FROZEN)) { // 冻结
			if(apply.getFundAmount().compareTo(zero) != 0) {
				depositRecord.setFundAmount(apply.getFundAmount().multiply(new BigDecimal(-1)));
				depositRecord.setAllowanceAmount(zero);
				depositRecord.setFrozenAmount(apply.getFundAmount());
			}
			if(apply.getAllowanceAmount().compareTo(zero) != 0) {
				depositRecord.setAllowanceAmount(apply.getAllowanceAmount().multiply(new BigDecimal(-1)));
				depositRecord.setFundAmount(zero);
				depositRecord.setFrozenAmount(apply.getAllowanceAmount());
			}
		}
		
		orgAccountDepositService.updateDeposit(depositRecord, resultMap);
		
		// 余额不足产生的失败
		OrgAccountDepositApply updateApply = new OrgAccountDepositApply();
		if(OrgAccountDepositConstant.FAIL_REASON_NOT_ENOUGH.equals(resultMap.get("code").toString())){
			updateApply.setStatus(OrgAccountDepositApplyConstant.STATUS_DEAL_FAIL);
		} else {
			updateApply.setStatus(OrgAccountDepositApplyConstant.STATUS_DEAL_SUCCESS);
		}
		updateApply.setId(apply.getId());
		updateApply.setCheckTime(apply.getCheckTime());
		updateApply.setCheckId(apply.getCheckId());
		updateApply.setCheckName(apply.getCheckName());
		updateApply.setCheckComment(apply.getCheckComment());
		super.updateByIdSelective(updateApply);
	}

	@Override
	public void addBatchApply(OrgAccountDepositApplyForm depositApply) {
		OrgAccountGroupUser query = new OrgAccountGroupUser();
		query.setGroupId(depositApply.getGroupId());
		List<OrgAccountGroupUserVo> userList = orgAccountGroupUserService.queryList(query);
		
		List<OrgAccountDepositApply> applyAddList = new ArrayList<OrgAccountDepositApply>();
		
		BigDecimal zero = new BigDecimal(0.00);
		String batchCode = DateFormatUtil.getDateTimeNumber(); // 批次号
	
		for(OrgAccountGroupUserVo user : userList){
			OrgAccountDepositApply apply = new OrgAccountDepositApply();
			
			apply.setUserId(user.getUserId());
			apply.setUserName(user.getUserName());
			apply.setAllowanceAmount(depositApply.getAmount());
			apply.setFundAmount(zero);
			apply.setFrozenAmount(zero);
			
			apply.setCreateTime(new Date());// 创建时间
			apply.setStatus(OrgAccountDepositApplyConstant.STATUS_DEAL_SUCCESS);// 状态-成功,不成功也不会被保存
			apply.setSource(OrgAccountDepositApplyConstant.SOURCE_SHOP_PC_MANAGE); // 发起-商城后台
			apply.setType(OrgAccountDepositApplyConstant.TYPE_MANUAL_ADD);// 类型-手动增加
			apply.setApplyComment(depositApply.getApplyComment());// 申请备注
			if(null != depositApply.getPayStyle()){ // 支付方式
				apply.setPayStyle(depositApply.getPayStyle());
			}
			if(null != depositApply.getBankName()){ // 银行名称
				apply.setBankName(depositApply.getBankName());
			}
			if(null != depositApply.getPaymentCode()){ // 支付账号
				apply.setPaymentCode(depositApply.getPaymentCode());
			}
			StringBuffer applyCode = new StringBuffer();
			applyCode.append(OrgAccountDepositApplyConstant.APPLY_CODE_PREFIX_SHOP)
					.append(DateFormatUtil.getDateNumber())
					.append(orgAccountDepositApplyDao.queryApplyCodeSeq());
			apply.setApplyCode(applyCode.toString());// 申请编号
			apply.setBatchCode(batchCode); // 批次号
			apply.setCreateId(depositApply.getCreateId()); // 创建人Id
			apply.setCreateName(depositApply.getCreateName()); // 创建人名称
			
			applyAddList.add(apply);
			
			OrgAccountDepositRecords depositRecord = new OrgAccountDepositRecords();
			
			depositRecord.setUserId(apply.getUserId());
			depositRecord.setComment(apply.getApplyComment());
			depositRecord.setCreateTime(new Date());
			depositRecord.setOrigin(OrgAccountDepositRecordsConstant.ORIGIN_ONLINE_SHOP);// 来源-线上

			depositRecord.setServiceCode(apply.getApplyCode());
			depositRecord.setType(apply.getType());
			
			depositRecord.setFundAmount(zero);
			depositRecord.setAllowanceAmount(apply.getAllowanceAmount());
			depositRecord.setFrozenAmount(zero);
			
			orgAccountDepositService.updateDeposit(depositRecord, new HashMap<String, Object>());
		}
		super.addInBatch(applyAddList); // 如果没报错，批量保存申请
	}
}