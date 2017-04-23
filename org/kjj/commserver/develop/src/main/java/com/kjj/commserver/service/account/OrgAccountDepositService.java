package com.kjj.commserver.service.account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.account.OrgAccountDepositRecords;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositTransferForm;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositVo;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.core.service.BaseService;

public interface OrgAccountDepositService extends BaseService<OrgAccountDeposit, Integer> {
	
	/**
	 * 修改账户
	 * @param depositRecord
	 */
	void updateDeposit(OrgAccountDepositRecords depositRecord,Map<String, Object> resultCode);
	
	/**
	 * 创建会员时初始化会员账户
	 * @param user
	 */
	void addDeposit(OrgUsers user);
	
	/**
	 * 查询账户(无密码返回null)
	 * @param userId
	 * @return
	 */
	OrgAccountDepositVo queryVoById4Pay(Integer userId);
	
	/**
	 * 查询接口
	 * @param userCode
	 * @return
	 */
	Map<String, Object> queryUserAccount(String userCode);
	
	/**
	 * 扣款接口
	 * @param origin
	 * @param userCode
	 * @param amount
	 * @param sc
	 * @return
	 */
	Map<String, Object> updateAddOrder(Byte origin, String userCode, BigDecimal amount, String password, String sc);
	
	/**
	 * 退款接口
	 * @param origin
	 * @param userCode
	 * @param amount
	 * @param sc
	 * @param qc
	 * @return
	 */
	Map<String, Object> updateAddRefund(Byte origin, String userCode, BigDecimal amount, String sc, String qc);
	
	/**
	 * 批量转账--企业会员使用
	 * @param origin
	 * @param userCode
	 * @param transfers
	 * @return
	 */
	Map<String, Object> updateByAllowanceTransfer(Byte origin, Integer userId, BigDecimal transferAmount, List<OrgAccountDepositTransferForm> transfers);

}