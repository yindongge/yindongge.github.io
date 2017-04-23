package com.kjj.commserver.dao.order;

import com.kjj.commserver.entity.order.OrgRefundOrder;
import com.kjj.core.dao.BaseDao;

public interface OrgRefundOrderDao extends BaseDao<OrgRefundOrder, Integer> {

	/**
	 * 根据ID查询退款单并锁定
	 * @param returnOrderId
	 * @return
	 */
	OrgRefundOrder selectById4Update(Integer returnOrderId);
}