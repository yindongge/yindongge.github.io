package com.kjj.commserver.dao.order;

import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.core.dao.BaseDao;

public interface OrgReturnOrderDao extends BaseDao<OrgReturnOrder, Integer> {

	/**
	 * 根据ID查询退货单并锁定
	 * @param returnOrderId
	 * @return
	 */
	OrgReturnOrder selectById4Update(Integer returnOrderId);
}