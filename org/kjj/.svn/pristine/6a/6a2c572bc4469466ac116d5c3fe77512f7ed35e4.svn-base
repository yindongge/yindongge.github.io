package com.kjj.commserver.service.account;

import java.util.Map;

import com.kjj.commserver.entity.account.OrgAccountDepositApply;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyForm;
import com.kjj.core.service.BaseService;

public interface OrgAccountDepositApplyService extends BaseService<OrgAccountDepositApply, Integer> {
	/**
	 * 添加单个申请
	 * @param depositApply
	 */
	void addOneApply(OrgAccountDepositApplyForm depositApply);
	
	/**
	 * 执行申请，修改状态
	 * @param apply
	 * @param resultMap
	 */
	void updateStatus(OrgAccountDepositApply apply, Map<String, Object> resultMap);
	
	/**
	 * 添加批量充值
	 * @param depositApply
	 */
	void addBatchApply(OrgAccountDepositApplyForm depositApply);
	
}