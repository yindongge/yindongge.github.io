package com.kjj.commserver.service.swap.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.service.swap.WechatPushService;
import com.kjj.commserver.util.CommServerPropertiesUtil;
import com.kjj.commserver.util.HttpClientUtil;

@Service
public class WechatPushServiceImpl implements WechatPushService {
	
	/** 日志记录 */
	protected static final Log logger = LogFactory.getLog(WechatPushService.class);

	@Override
	public boolean addPushOrder(OrgOrder orgOrder) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/"+orgOrder.getOrderId());
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		//日志
		logger.info("*******************addPushOrder start ********************************");
		if(result){
			logger.info("WechatPush orderId="+orgOrder.getOrderId()+"success");
		}else{
			logger.error("WechatPush orderId="+orgOrder.getOrderId()+"fail");
		}
		logger.info("*******************addPushOrder end ********************************");
		return result;
	}

	@Override
	public boolean confirmForDelivery(String orderId) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/confirmForDelivery/" + orderId);
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		//日志
		logger.info("*******************confirmForDelivery start ********************************");
		if(result){
			logger.info("WechatPush orderId=" + orderId + "success");
		}else{
			logger.error("WechatPush orderId=" + orderId + "fail");
		}
		logger.info("*******************confirmForDelivery start ********************************");
		return result;
	}

	@Override
	public boolean confirmForGoShop(String orderId) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/confirmForGoShop/" + orderId);
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		//日志
		logger.info("*******************confirmForGoShop start ********************************");
		if(result){
			logger.info("WechatPush orderId=" + orderId + "success");
		}else{
			logger.error("WechatPush orderId=" + orderId + "fail");
		}
		logger.info("*******************confirmForGoShop start ********************************");
		return result;
	}

	@Override
	public boolean shipmentForDelivery(String orderId) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/shipmentForDelivery/" + orderId);
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		//日志
		logger.info("*******************shipmentForDelivery start ********************************");
		if(result){
			logger.info("WechatPush orderId=" + orderId + "success");
		}else{
			logger.error("WechatPush orderId=" + orderId + "fail");
		}
		logger.info("*******************shipmentForDelivery start ********************************");
		return result;
	}

	@Override
	public boolean shipmentForGoShop(String orderId) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/shipmentForGoShop/" + orderId);
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		//日志
		logger.info("*******************shipmentForGoShop start ********************************");
		if(result){
			logger.info("WechatPush orderId=" + orderId + "success");
		}else{
			logger.error("WechatPush orderId=" + orderId + "fail");
		}
		logger.info("*******************shipmentForGoShop start ********************************");
		return result;
	}

	@Override
	public boolean confirmReceipt(String orderId) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/confirmReceipt/" + orderId);
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		logger.info("*******************confirmReceipt start ********************************");
		if(result){
			logger.info("WechatPush orderId=" + orderId + "success");
		}else{
			logger.error("WechatPush orderId=" + orderId + "fail");
		}
		logger.info("*******************confirmReceipt start ********************************");
		return result;
	}

	@Override
	public boolean cancelOrder(String orderId) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/cancelOrder/" + orderId);
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		//日志
		logger.info("*******************cancelOrder start ********************************");
		if(result){
			logger.info("WechatPush orderId=" + orderId + "success");
		}else{
			logger.error("WechatPush orderId=" + orderId + "fail");
		}
		logger.info("*******************cancelOrder start ********************************");
		return result;
	}

	@Override
	public boolean refundSuccess(String orderId) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/refundSuccess/" + orderId);
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		//日志
		logger.info("*******************refundSuccess start ********************************");
		if(result){
			logger.info("WechatPush orderId=" + orderId + "success");
		}else{
			logger.error("WechatPush orderId=" + orderId + "fail");
		}
		logger.info("*******************refundSuccess start ********************************");
		return result;
	}

	@Override
	public boolean refundSuccess2(String refundOrderId) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		String strResult = null;
		try {
			strResult = util.setGetRequest(CommServerPropertiesUtil.getProperty("messagepush.url")+"/push/refundSuccess2/" + refundOrderId);
		} catch (Exception e) {
		}
		if(strResult != null){
			result = strResult.contains("success");
		}
		//日志
		logger.info("*******************refundSuccess start ********************************");
		if(result){
			logger.info("WechatPush refundOrderId=" + refundOrderId + "success");
		}else{
			logger.error("WechatPush refundOrderId=" + refundOrderId + "fail");
		}
		logger.info("*******************refundSuccess start ********************************");
		return result;
	}

}
