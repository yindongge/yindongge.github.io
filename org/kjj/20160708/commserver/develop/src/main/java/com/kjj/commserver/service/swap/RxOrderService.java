package com.kjj.commserver.service.swap;

import java.util.List;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;

public interface RxOrderService {
	
	/**
	 * 瑞星系统生成订单及订单明细
	 * @param orgUsersSession session中user
	 * @param orgOrder 订单
	 * @param listGoods 订单商品
	 * @return
	 */
	boolean add(OrgUsersSession orgUsersSession,OrgOrder orgOrder,List<OrgOrderGoods> listGoods);
	
	/**
	 * 删除瑞星订单
	 * @param orderId
	 * @return
	 */
	boolean deleteByOrderId(Integer orderId);
	
	/**
	 * 瑞星订单完成
	 * @param orderId
	 * @return
	 */
	boolean updateFinishByOrderId(Integer orderId);
}
