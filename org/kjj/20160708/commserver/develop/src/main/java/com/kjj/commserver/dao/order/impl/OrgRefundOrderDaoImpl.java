package com.kjj.commserver.dao.order.impl;

import com.kjj.commserver.dao.order.OrgRefundOrderDao;
import com.kjj.commserver.entity.order.OrgRefundOrder;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgRefundOrderDaoImpl extends BaseDaoImpl<OrgRefundOrder, Integer> implements OrgRefundOrderDao {

	private static final String SQL_ID_SELECT_4UPDATE = "selectByPrimaryKey4Update";

	@Override
	public OrgRefundOrder selectById4Update(Integer returnOrderId) {
		return selectById(returnOrderId,SQL_ID_SELECT_4UPDATE);
	}
}