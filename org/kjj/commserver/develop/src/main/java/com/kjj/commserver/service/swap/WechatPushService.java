package com.kjj.commserver.service.swap;

import com.kjj.commserver.entity.order.OrgOrder;

public interface WechatPushService {
	/**
	 * 微信推送订单给店员
	 * @param orgOrder
	 * @return
	 */
	boolean addPushOrder(OrgOrder orgOrder);
	
	/**
	 * 微信通知需要送货的会员，订单已经被确认
	 * @param orderId
	 * @return
	 */
	boolean confirmForDelivery(String orderId);
	
	/**
	 * 微信通知自提的会员，订单已经被确认
	 * @param orderId
	 * @return
	 */
	boolean confirmForGoShop(String orderId);
	
	/**
	 * 微信通知需要送货的会员，订单已经发货
	 * @param orderId
	 * @return
	 */
	boolean shipmentForDelivery(String orderId);
	
	/**
	 * 微信通知自提的会员，订单已经发货
	 * @param orderId
	 * @return
	 */
	boolean shipmentForGoShop(String orderId);
	
	/**
	 * 微信通知会员，订单已经被确认收货
	 * @param orderId
	 * @return
	 */
	boolean confirmReceipt(String orderId);
	
	/**
	 * 微信通知会员，订单取消成功
	 * @param orderId
	 * @return
	 */
	boolean cancelOrder(String orderId);
	
	/**
	 * 微信通知会员，订单退款成功
	 * @param orderId
	 * @return
	 */
	boolean refundSuccess(String orderId);
	
	/**
	 * 微信通知会员，订单退款成功
	 * @param refundOrderId
	 * @return
	 */
	boolean refundSuccess2(String refundOrderId);
	
}
