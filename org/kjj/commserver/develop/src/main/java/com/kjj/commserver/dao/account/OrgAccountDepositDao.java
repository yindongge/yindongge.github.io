package com.kjj.commserver.dao.account;

import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.core.dao.BaseDao;

public interface OrgAccountDepositDao extends BaseDao<OrgAccountDeposit, Integer> {
	
	OrgAccountDeposit selectById4Update(Integer id);
}