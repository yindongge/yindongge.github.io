package com.kjj.commserver.service.discount;

import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgReachCouponOrder;
import com.kjj.core.service.BaseService;

public interface OrgReachCouponOrderService extends BaseService<OrgReachCouponOrder, Integer> {
	
	/**
	 * 批量添加订单赠送优惠券记录
	 * @param orderId
	 * @param mapReachCoupon
	 */
	void addInBatch(Integer orderId,Map<Integer, Integer> mapReachCoupon);

	/**
	 * 按照订单号查询赠送优惠券
	 * @param orderId
	 * @return
	 */
	List<OrgReachCouponOrder> queryListByOrderId(Integer orderId);
}