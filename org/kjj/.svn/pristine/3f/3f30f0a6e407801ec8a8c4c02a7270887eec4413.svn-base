package com.kjj.commserver.service.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgRefundOrder;
import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgRefundOrderService extends BaseService<OrgRefundOrder, Integer> {

	/**
	 * 根据ID查询退款单并锁定
	 * @param returnOrderId
	 * @return
	 */
	OrgRefundOrder lockQueryById(Integer refundOrderId);
	
	/**
	 * 订单生成退款单
	 * @param order
	 */
	void addByOrder(OrgOrder order);
	
	/**
	 * 用户查询退款单分页
	 * @param orgUsersSession
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgRefundOrder> queryPageList4User(OrgUsersSession orgUsersSession,OrgRefundOrderQuery query,Pageable pageable);
	
	/**
	 * 如果为退货添加退款单
	 * @param returnOrder
	 * @return
	 */
	void addByReturnOrder(OrgReturnOrder returnOrder);
	
	/**
	 * 管理员查询退款单分页
	 * @param orgUsersSession
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgRefundOrder> queryPageList4Admin(OrgAdminUserSession admin,OrgRefundOrderQuery query,Pageable pageable);
	/**
	 * 管理员修改退款备注信息
	 * @param orgUsersSession
	 * @param query
	 * @param pageable
	 * @return
	 */
	boolean updateFinish(OrgRefundOrder orgRefundOrder);
}