package com.kjj.commserver.dao.account.impl;

import com.kjj.commserver.dao.account.OrgAccountDepositDao;
import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgAccountDepositDaoImpl extends BaseDaoImpl<OrgAccountDeposit, Integer> implements OrgAccountDepositDao {

	private static final String SQL_ID_SELECT_4UPDATE = "selectByPrimaryKey4Update";
	
	@Override
	public OrgAccountDeposit selectById4Update(Integer id) {
		return selectById(id,SQL_ID_SELECT_4UPDATE);
	}
}