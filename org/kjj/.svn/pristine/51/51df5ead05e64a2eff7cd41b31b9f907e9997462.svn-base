package com.kjj.commserver.service.account.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.account.OrgAccountDepositDao;
import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.account.OrgAccountDepositRecords;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositQuery;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsQuery;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositTransferForm;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositVo;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersVo;
import com.kjj.commserver.service.account.OrgAccountDepositRecordsService;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.DateFormatUtil;
import com.kjj.commserver.util.MD5;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAccountDepositServiceImpl extends BaseServiceImpl<OrgAccountDeposit, Integer> implements OrgAccountDepositService {
    @Resource
    private OrgAccountDepositDao orgAccountDepositDao;
    
    @Resource
    private OrgUsersService orgUsersService;
    
    @Resource
    private OrgAccountDepositRecordsService orgAccountDepositRecordsService;

    @Override
    protected BaseDao<OrgAccountDeposit, Integer> getBaseDao() {
        return orgAccountDepositDao;
    }
    
	@Override
	public void addDeposit(OrgUsers user) {
		OrgAccountDeposit oad = new OrgAccountDeposit();
		oad.setUserId(user.getUserId());
		oad.setUserCode(user.getUserCode());
		oad.setFundAmount(new BigDecimal(0.00));
		oad.setAllowanceAmount(new BigDecimal(0.00));
		oad.setFrozenAmount(new BigDecimal(0.00));
		oad.setStatus(OrgAccountDepositConstant.STATUS_VALID);
		oad.setLockLevel(OrgAccountDepositConstant.LOCK_LEVEL_SYSTEM);
		oad.setErrorNum(0);
		add(oad);
	}

	@Override
	public void updateDeposit(
			OrgAccountDepositRecords depositRecord,Map<String, Object> resultCode) {

		OrgAccountDeposit oad = orgAccountDepositDao.selectById4Update(depositRecord.getUserId());
		BigDecimal zero = new BigDecimal(0.00);
		boolean isValid = false;
		// 判断可用可提现金额是否满足
		if(oad.getFundAmount().add(depositRecord.getFundAmount()).compareTo(zero) == -1){
			resultCode.put("code", OrgAccountDepositConstant.FAIL_REASON_NOT_ENOUGH);
			// amount为扣款接口使用,取得当前可用金额
			resultCode.put("amount", oad.getFundAmount().add(oad.getAllowanceAmount()));
			isValid = true;
		}
		
	    // 判断可用不可提现金额是否满足
		if(oad.getAllowanceAmount().add(depositRecord.getAllowanceAmount()).compareTo(zero) == -1){
			resultCode.put("code", OrgAccountDepositConstant.FAIL_REASON_NOT_ENOUGH);
			// amount为扣款接口使用,取得当前可用金额
			resultCode.put("amount", oad.getFundAmount().add(oad.getAllowanceAmount()));
			isValid = true;
		}
		
		// 判断冻结金额是否满足
		if(oad.getFrozenAmount().add(depositRecord.getFrozenAmount()).compareTo(zero) == -1){
			resultCode.put("code", OrgAccountDepositConstant.FAIL_REASON_NOT_ENOUGH);
			isValid = true;
		}
		// 通过验证,继续执行
		if(isValid == false) {
			OrgAccountDeposit updateEnity = new OrgAccountDeposit();
			updateEnity.setUserId(oad.getUserId());
			updateEnity.setFundAmount(oad.getFundAmount().add(depositRecord.getFundAmount()));
			updateEnity.setAllowanceAmount(oad.getAllowanceAmount().add(depositRecord.getAllowanceAmount()));
			updateEnity.setFrozenAmount(oad.getFrozenAmount().add(depositRecord.getFrozenAmount()));
			
			updateByIdSelective(updateEnity);
			
			orgAccountDepositRecordsService.add(depositRecord);
			// amount为扣款接口使用,取得当前可用金额
			resultCode.put("amount", updateEnity.getFundAmount().add(updateEnity.getAllowanceAmount()));
			
			resultCode.put("code", "200"); // 成功
		}
	}

	@Override
	public OrgAccountDepositVo queryVoById4Pay(Integer userId) {
		OrgAccountDepositVo accountDepositVo = queryVoById(userId);
		if(accountDepositVo == null || StringUtils.isBlank(accountDepositVo.getPayPassword())){
			return null;
		}else{
			accountDepositVo.setCanUseAmount(accountDepositVo.getFundAmount().add(accountDepositVo.getAllowanceAmount()));
			return accountDepositVo;
		}
	}
	
	public Map<String, Object> queryUserAccount(String userCode){
		Map<String, Object> resultCode = null;
		
		// 执行通用校验
		resultCode = commonInParameterValidate(userCode);
		if(null != commonInParameterValidate(userCode)){
			return resultCode;
		}
		
		resultCode = new HashMap<String, Object>();
		resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
		// 通过通用方法获取账户列表
		List<OrgAccountDepositVo> adList = queryAccount(userCode);
		
		// 当查询记录为空或者查询记录大于1时，返回账户不存在
		if(null == adList || adList.size() == 0 || adList.size() > 1){
			resultCode.put("status", OrgAccountDepositConstant.ACCOUNT_STATUS_INVALID);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		
		OrgAccountDepositVo accountDeposit = adList.get(0);
		
		// 返回用户编码，外部系统可能用手机号查询,本接口返回用户编码 
		resultCode.put("userCode", accountDeposit.getUserCode());
		
		List<OrgUsersVo> userList = orgUsersService.queryDiscountAndPoint(accountDeposit.getUserId());
		
		// 返回用户折扣和消费积分,折扣默认100.00,消费积分默认为0
		resultCode.put("discount", 100.00);
		resultCode.put("points", 0);
		
		if(userList.size() > 0){
			OrgUsersVo ou = userList.get(0);
			resultCode.put("discount", ou.getDiscount());
			resultCode.put("points", ou.getPayPoints());
		}
		
		// 默认账户状态为正常,金额0.00
		resultCode.put("status", OrgAccountDepositConstant.ACCOUNT_STATUS_NORMAL);
		// 当前账户可用金额 = 可用可提现金额+可用不可提现金额
		resultCode.put("amount", accountDeposit.getFundAmount().add(accountDeposit.getAllowanceAmount()));
		
		
		
		// 判读账户状态是否锁定
		if(accountDeposit.getStatus().equals(OrgAccountDepositConstant.STATUS_INVALID)){
			resultCode.put("status", OrgAccountDepositConstant.ACCOUNT_STATUS_LOCK);
		}
		
		// 判读账户支付密码是否为空
		if(null == accountDeposit.getPayPassword()){
			resultCode.put("status", OrgAccountDepositConstant.ACCOUNT_STATUS_NOPASSWORD);
		}
		
		return resultCode;
	}
	
	public Map<String, Object> updateAddOrder(Byte origin, String userCode, BigDecimal amount, String password, String sc){
		Map<String, Object> resultCode = null;
		
		// 输入参数校验
		// 执行通用校验
		resultCode = commonInParameterValidate(userCode);
		if(null != commonInParameterValidate(userCode)){
			return resultCode;
		}
		
		resultCode = new HashMap<String, Object>();
		resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
		// 扣款金额为空，或者0.00、负数
		if(null == amount || amount.compareTo(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT) != 1){
			resultCode.put("status", OrgAccountDepositConstant.GLOBAL_STATUS_PARAMETERERROR);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		
		//商城订单可不判断密码
		if(origin != OrgAccountDepositRecordsConstant.ORIGIN_ONLINE_SHOP || StringUtils.isNotBlank(password)){
			// 密码为空，或者长度不等于6
			if(null == password || password.length() != 6){
				resultCode.put("status", OrgAccountDepositConstant.GLOBAL_STATUS_PARAMETERERROR);
				resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
				return resultCode;
			}
		}
		
		// sc为空
		if(null == sc){
			resultCode.put("status", OrgAccountDepositConstant.GLOBAL_STATUS_PARAMETERERROR);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		} else {
			// sc如果在流水表中存在，则不允许操作，否则将影响退款
			OrgAccountDepositRecordsQuery rquery = new OrgAccountDepositRecordsQuery();
			rquery.setServiceCode(sc);
			List<OrgAccountDepositRecords> recordList = orgAccountDepositRecordsService.queryList(rquery);
			if(recordList.size() > 0){
				resultCode.put("status", OrgAccountDepositConstant.CHARGE_STATUS_SC_EXIST);
				resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
				return resultCode;
			}
		}
		
		
		// 通过通用方法获取账户列表
		List<OrgAccountDepositVo> adList = queryAccount(userCode);
		
		// 当查询记录为空或者查询记录大于1时，返回账户不存在
		if(null == adList || adList.size() == 0 || adList.size() > 1){
			resultCode.put("status", OrgAccountDepositConstant.CHARGE_STATUS_INVALID);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		
		OrgAccountDepositVo accountDeposit = adList.get(0);
		
		// 默认账户状态为正常,金额0.00
		resultCode.put("status", OrgAccountDepositConstant.CHARGE_STATUS_SUCCESS);
		BigDecimal total = accountDeposit.getFundAmount().add(accountDeposit.getAllowanceAmount());
		resultCode.put("amount", total);
				
		// 判读账户支付密码是否为空
		if(null == accountDeposit.getPayPassword()){
			resultCode.put("status", OrgAccountDepositConstant.CHARGE_STATUS_NOPASSWORD);
			return resultCode;
		}
		
		// 判读账户状态是否锁定
		if(accountDeposit.getStatus().equals(OrgAccountDepositConstant.STATUS_INVALID)){
			resultCode.put("status", OrgAccountDepositConstant.CHARGE_STATUS_LOCK);
			return resultCode;
		}
		
		//商城订单可不判断密码
		if(origin != OrgAccountDepositRecordsConstant.ORIGIN_ONLINE_SHOP || StringUtils.isNotBlank(password)){
		    // 判断支付密码是否正确 
			MD5 md5 = new MD5();
			String encryptPassword = md5.getMD5ofStr(password);
			
			OrgAccountDeposit updateAD = new OrgAccountDeposit();
			updateAD.setUserId(accountDeposit.getUserId());
			
			if(!accountDeposit.getPayPassword().equals(encryptPassword)){
				// 将错误次数加1，判断是否累计三次
				updateAD.setErrorNum(accountDeposit.getErrorNum()+1);
				
				int cen = updateAD.getErrorNum();
				if(cen >= 3){
					updateAD.setStatus(OrgAccountDepositConstant.STATUS_INVALID);
				}
				updateByIdSelective(updateAD);
				
				resultCode.put("status", OrgAccountDepositConstant.CHARGE_STATUS_PASSWORDERROR);
				return resultCode;
			}
			// 密码验证通过后，将错误次数清零
			if(accountDeposit.getErrorNum() != 0) {
				updateAD.setErrorNum(0);
				updateByIdSelective(updateAD);
			}
		}
				
		// 构造账户流水
		OrgAccountDepositRecords depositRecord = new OrgAccountDepositRecords();
		depositRecord.setUserId(accountDeposit.getUserId());
		depositRecord.setCreateTime(new Date());
		depositRecord.setOrigin(origin);
		depositRecord.setServiceCode(sc);
		depositRecord.setType(OrgAccountDepositApplyConstant.TYPE_CONSUME);// 类型-消费
		
		// 各种金额在流水表中计算完成 amount
		if(amount.compareTo(accountDeposit.getAllowanceAmount()) != 1){ // 扣款小于或者等于可用不可提现金额
			depositRecord.setAllowanceAmount(amount.multiply(new BigDecimal(-1)));
			depositRecord.setFundAmount(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			
		} else { // 扣款大于可用不可提现金额
			depositRecord.setAllowanceAmount(accountDeposit.getAllowanceAmount().multiply(new BigDecimal(-1)));
			depositRecord.setFundAmount(amount.subtract(accountDeposit.getAllowanceAmount()).multiply(new BigDecimal(-1)));
		}
		depositRecord.setFrozenAmount(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);

		updateDeposit(depositRecord, resultCode);
		
		if(OrgAccountDepositConstant.FAIL_REASON_NOT_ENOUGH.equals(resultCode.get("code").toString())){
			resultCode.remove("code"); // 移出code键，amount已经在resultCode中
			resultCode.put("status", OrgAccountDepositConstant.CHARGE_STATUS_NOTENOUGH);
			return resultCode;
		}
		
		resultCode.remove("code"); // 移出code键，amount已经在resultCode中
		
		return resultCode;
	}
	
	public Map<String, Object> updateAddRefund(Byte origin, String userCode, BigDecimal amount, String sc, String qc){
		Map<String, Object> resultCode = null;
		
		// 输入参数校验
		// 执行通用校验
		resultCode = commonInParameterValidate(userCode);
		if(null != commonInParameterValidate(userCode)){
			return resultCode;
		}
		
		resultCode = new HashMap<String, Object>();
		resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
		// 扣款金额为空，或者0.00、负数
		if(null == amount || amount.compareTo(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT) != 1){
			resultCode.put("status", OrgAccountDepositConstant.GLOBAL_STATUS_PARAMETERERROR);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		
		// 服务号是否为空
		if(null == sc){
			resultCode.put("status", OrgAccountDepositConstant.GLOBAL_STATUS_PARAMETERERROR);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		
		// 通过通用方法获取账户列表
		List<OrgAccountDepositVo> adList = queryAccount(userCode);
		
		// 当查询记录为空或者查询记录大于1时，返回账户不存在
		if(null == adList || adList.size() == 0 || adList.size() > 1){
			resultCode.put("status", OrgAccountDepositConstant.REFUND_STATUS_INVALID);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		
		OrgAccountDepositVo accountDeposit = adList.get(0);
		
		// 默认账户状态为正常,金额0.00
		resultCode.put("status", OrgAccountDepositConstant.REFUND_STATUS_SUCCESS);
		BigDecimal total = accountDeposit.getFundAmount().add(accountDeposit.getAllowanceAmount());
		resultCode.put("amount", total);
		
		OrgAccountDepositRecords dr = null;
		OrgAccountDepositRecordsQuery rquery = new OrgAccountDepositRecordsQuery();
		
		// 以用户Id,类型和服务号来确定消费记录，避免有人恶意退款
		rquery.setType(OrgAccountDepositApplyConstant.TYPE_CONSUME);
		rquery.setServiceCode(sc);
		rquery.setUserId(accountDeposit.getUserId()); 
		List<OrgAccountDepositRecords> recordList = orgAccountDepositRecordsService.queryList(rquery);
		if(null == recordList || recordList.size() == 0){
			resultCode.put("status", OrgAccountDepositConstant.REFUND_STATUS_SCERROR);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		dr = recordList.get(0);
		
		// 退款金额大于消费金额
		System.out.println((dr.getFundAmount().add(dr.getAllowanceAmount())).multiply(new BigDecimal(-1)));
		if(amount.compareTo((dr.getFundAmount().add(dr.getAllowanceAmount())).multiply(new BigDecimal(-1))) == 1){ 
			resultCode.put("status", OrgAccountDepositConstant.REFUND_STATUS_NOTENOUGH);
			return resultCode;
		}
		
		// 构造账户流水
		OrgAccountDepositRecords depositRecord = new OrgAccountDepositRecords();
		depositRecord.setUserId(accountDeposit.getUserId());
		depositRecord.setCreateTime(new Date());
		depositRecord.setOrigin(origin);// 来源-瑞星
		depositRecord.setServiceCode(sc);
		if(null != qc){
			depositRecord.setQuitCode(qc);
		}
		depositRecord.setType(OrgAccountDepositApplyConstant.TYPE_REFOUND);// 类型-退款
		
		// 取得历史发生的退款记录
		rquery.setType(OrgAccountDepositApplyConstant.TYPE_REFOUND); // 退款
		rquery.setServiceCode(sc);
		rquery.setUserId(accountDeposit.getUserId()); 
		recordList = orgAccountDepositRecordsService.queryList(rquery);
		
		BigDecimal refoundedTotal = new BigDecimal(0.00); // 已经发生的退款总金额
		BigDecimal foundRefoundedTotal = new BigDecimal(0.00); // 可用可提现账户退款总金额,为退款准备
		BigDecimal allowanceRefoundedTotal = new BigDecimal(0.00); // 可用不可提现账户退款总金额,为退款准备
		
		for(OrgAccountDepositRecords oadr : recordList){
			refoundedTotal = refoundedTotal.add(oadr.getFundAmount()).add(oadr.getAllowanceAmount());
			foundRefoundedTotal = foundRefoundedTotal.add(oadr.getFundAmount()); 
			allowanceRefoundedTotal = allowanceRefoundedTotal.add(oadr.getAllowanceAmount());
		}
		
		// 扣款金额大于可退款金额(消费总额-已经发生的退款总额)
		if(amount.compareTo(dr.getFundAmount().add(dr.getAllowanceAmount()).multiply(new BigDecimal(-1)).subtract(refoundedTotal)) == 1){
			resultCode.put("status", OrgAccountDepositConstant.REFUND_STATUS_MORETHANLAST);
			return resultCode;
		}
		
		// 各种金额在流水表中计算完成 amount
		BigDecimal allowanceDifference = dr.getAllowanceAmount().add(allowanceRefoundedTotal); // 可用不可以提现账户可退款的金额
		boolean finish = false;
		// 负数代表账户出大于入，还有可退的金额，1代表退款错误，0代表没有在可用不可以提现账户中扣款或已经退完所有可用不可提现账户的金额
		if(allowanceDifference.compareTo(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT) == -1){
			if(amount.compareTo(allowanceDifference.multiply(new BigDecimal(-1))) <= 0){
				depositRecord.setAllowanceAmount(amount);
				depositRecord.setFundAmount(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
				finish = true;
			} else {
				depositRecord.setAllowanceAmount(allowanceDifference.multiply(new BigDecimal(-1)));
				depositRecord.setFundAmount(amount.add(allowanceDifference));
				finish = true;
			}
			depositRecord.setFrozenAmount(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
		}
		
		BigDecimal foundDifference = dr.getFundAmount().add(foundRefoundedTotal); // 可用可提现账户可退款的金额
		// 1代表退款错误，0代表没有在可用不可以提现账户中扣款
		if(finish == false && foundDifference.compareTo(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT) == -1){
			depositRecord.setFundAmount(amount);
			depositRecord.setAllowanceAmount(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			depositRecord.setFrozenAmount(OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
		}
		
		updateDeposit(depositRecord, resultCode);
		
		if(OrgAccountDepositConstant.FAIL_REASON_NOT_ENOUGH.equals(resultCode.get("code").toString())){
			resultCode.remove("code"); // 移出code键，amount已经在resultCode中
			resultCode.put("status", OrgAccountDepositConstant.CHARGE_STATUS_NOTENOUGH);
			return resultCode;
		}
		
		resultCode.remove("code"); // 移出code键，amount已经在resultCode中
		
		return resultCode;
	}
	
	/**
	 * 通用验证方法-入参校验
	 * @param userCode
	 * @return
	 */
	private Map<String, Object> commonInParameterValidate(String userCode){
		Map<String, Object> resultCode = null;
		// 会员代码参数为空时
		if(StringUtils.isBlank(userCode)){
			resultCode = new HashMap<String, Object>();
			resultCode.put("status", OrgAccountDepositConstant.GLOBAL_STATUS_PARAMETERERROR);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		
		// 输入参数目前为11位的手机号,13为的会员编码,不接受其他长度的参数
		if(userCode.length() != 11 && userCode.length() != 13){
			resultCode = new HashMap<String, Object>();
			resultCode.put("status", OrgAccountDepositConstant.GLOBAL_STATUS_PARAMETERERROR);
			resultCode.put("amount", OrgAccountDepositConstant.GLOBAL_DEFAULT_AMOUNT);
			return resultCode;
		}
		
		return resultCode;
	}
	
	/**
	 * 查询会员账户
	 * @param userCode
	 * @return
	 */
	private List<OrgAccountDepositVo> queryAccount(String userCode){

		OrgAccountDepositQuery query = new OrgAccountDepositQuery();
		List<OrgAccountDepositVo> adList = null;
		
		if(userCode.length() == 11){ // 手机号
			query.setMobilePhone(userCode);
			adList = queryList(query);
		} else if(userCode.length() == 13){ // 会员编码
			query.setUserCode(userCode);
			adList = queryList(query);
		}
		return adList;
	}

	@Override
	public Map<String, Object> updateByAllowanceTransfer(Byte origin, Integer userId,
			BigDecimal transferAmount, List<OrgAccountDepositTransferForm> transfers) {
		Map<String, Object> resultCode = new HashMap<String, Object>();
		BigDecimal outAccountAmount = new BigDecimal(0.00); // 支出账户余额
		
		// 开始转账之前，对支出账户做验证
		OrgAccountDeposit account = orgAccountDepositDao.selectById(userId);
		// 可用不可提现账户余额少于转账总金额,提示余额不足
		if(account.getAllowanceAmount().compareTo(transferAmount) == -1){
			resultCode.put("code", OrgAccountDepositConstant.FAIL_REASON_NOT_ENOUGH);
			return resultCode;
		}
		
		BigDecimal zero = new BigDecimal(0.00); // 通用变量
		
		for(OrgAccountDepositTransferForm adt : transfers){
			// 构造支出账户流水
			OrgAccountDepositRecords depositRecordOut = new OrgAccountDepositRecords();
			
			// 构造收入账户流水
			OrgAccountDepositRecords depositRecordIn = new OrgAccountDepositRecords();
			
			StringBuffer serviceCode = new StringBuffer();
			serviceCode.append(OrgAccountDepositConstant.SERVICE_CODE_ENTERPRISE_TRANSFER_PREFIX)
					.append(DateFormatUtil.getDateTimeNumber())
					.append("U")
					.append(adt.getUserId());

			depositRecordOut.setUserId(userId);
			depositRecordOut.setCreateTime(new Date());
			depositRecordOut.setOrigin(origin);
			depositRecordOut.setServiceCode(serviceCode.toString());
			depositRecordOut.setType(OrgAccountDepositApplyConstant.TYPE_MANUAL_TRANSFER); // 类型-转账
			depositRecordOut.setFundAmount(zero);
			depositRecordOut.setFrozenAmount(zero);
			depositRecordOut.setAllowanceAmount(adt.getAmount().multiply(new BigDecimal(-1))); // 减少可用不可提现账户金额
			depositRecordOut.setTraderId(adt.getUserId());// 转账交易人
			
			updateDeposit(depositRecordOut, resultCode);
			
			if(OrgAccountDepositConstant.FAIL_REASON_NOT_ENOUGH.equals(resultCode.get("code").toString())){
				return resultCode;
			}
			outAccountAmount = (BigDecimal)resultCode.get("amount");
			
			depositRecordIn.setUserId(adt.getUserId());
			depositRecordIn.setCreateTime(new Date());
			depositRecordIn.setOrigin(origin);
			depositRecordIn.setServiceCode(serviceCode.append("I").toString()); // 收入账户末尾为"I",In的首字母
			depositRecordIn.setType(OrgAccountDepositApplyConstant.TYPE_MANUAL_TRANSFER); // 类型-转账
			depositRecordIn.setFundAmount(zero);
			depositRecordIn.setFrozenAmount(zero);
			depositRecordIn.setAllowanceAmount(adt.getAmount()); // 增加可用不可提现账户金额
			depositRecordIn.setTraderId(userId); // 转账交易人
			
			updateDeposit(depositRecordIn, resultCode);
			
			// 提取用户手机号
			OrgUsers usr = orgUsersService.queryById(adt.getUserId());
			adt.setMobilePhone(usr.getMobilePhone());
			
			adt.setBalance((BigDecimal)resultCode.get("amount")); // 将收入账户的账户余额记录下来
		}
		resultCode.put("outAccountAmount", outAccountAmount);
		
		return resultCode;
	}
	
	
}