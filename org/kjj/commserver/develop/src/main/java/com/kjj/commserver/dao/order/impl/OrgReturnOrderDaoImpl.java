package com.kjj.commserver.dao.order.impl;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.order.OrgReturnOrderDao;
import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgReturnOrderDaoImpl extends BaseDaoImpl<OrgReturnOrder, Integer> implements OrgReturnOrderDao {

	private static final String SQL_ID_SELECT_4UPDATE = "selectByPrimaryKey4Update";

	@Override
	public OrgReturnOrder selectById4Update(Integer returnOrderId) {
		return selectById(returnOrderId,SQL_ID_SELECT_4UPDATE);
	}
}