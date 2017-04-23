package com.kjj.commserver.dao.account.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.account.OrgAccountDepositRecordsDao;
import com.kjj.commserver.entity.account.OrgAccountDepositRecords;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgAccountDepositRecordsDaoImpl extends BaseDaoImpl<OrgAccountDepositRecords, Integer> implements OrgAccountDepositRecordsDao {

	private static final String SQL_ID_OWE_OF_ALLOWANCE = "selectOweOfAllowance";
	
	
	@Override
	public BigDecimal queryOweOfAllowance(Integer userId) {
		BigDecimal amount = new BigDecimal(0.00);
		OrgAccountDepositRecords query = new OrgAccountDepositRecords();
		query.setUserId(userId);
		Long seq = selectCount(query, SQL_ID_OWE_OF_ALLOWANCE);
		// 负数代表解冻的总额小于冻结的总额,需要解冻时优先放入可用不可提现账户类型中
		if(seq < 0){
			BigDecimal temp = new BigDecimal(seq.longValue());
			
			amount = temp.multiply(new BigDecimal(-1));// 转成正数
		}
		return amount;
	}
}