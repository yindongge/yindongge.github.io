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
		if(result){
			logger.info("WechatPush orderId="+orgOrder.getOrderId()+"success");
		}else{
			logger.error("WechatPush orderId="+orgOrder.getOrderId()+"fail");
		}
		return result;
	}

}
