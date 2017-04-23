package com.kjj.commserver.service.account;

import java.math.BigDecimal;

import com.kjj.commserver.entity.account.OrgAccountDepositRecords;
import com.kjj.core.service.BaseService;

public interface OrgAccountDepositRecordsService extends BaseService<OrgAccountDepositRecords, Integer> {
	/**
	 * 查询会员冻结操作时对可用不可提现账户的欠款,在解冻时使用
	 * @param user_id
	 * @return
	 */
	BigDecimal queryOweOfAllowance(Integer userId);
}