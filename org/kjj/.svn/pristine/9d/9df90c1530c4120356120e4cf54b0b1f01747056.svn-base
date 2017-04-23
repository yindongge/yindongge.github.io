package com.kjj.commserver.service.swap.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.commserver.entity.swap.Org_RX_return_order;
import com.kjj.commserver.exception.swap.RxException;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.swap.RxReturnOrderService;
import com.kjj.commserver.util.CommServerPropertiesUtil;
import com.kjj.commserver.util.HttpClientUtil;

@Service
public class RxReturnOrderServiceImpl implements RxReturnOrderService {
	
	@Resource
	private OrgShopService orgShopService;

	@Override
	public boolean add(OrgReturnOrder orgReturnOrder) {
		boolean result = false;
		//转换瑞星退货单
		Org_RX_return_order org_RX_return_order = setRxReturnOrder(orgReturnOrder);
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		Gson gson = new Gson();
		String return_order = gson.toJson(org_RX_return_order);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("return_order",return_order);
		String strResult = null;
		try {
			strResult = util.getResponseBodyAsString(CommServerPropertiesUtil.getProperty("rxservice.url")+"/order/addReturn", params);
		} catch (Exception e) {
		}
		if (strResult != null) {
			result = strResult.contains("200");
		}
		if(!result){
			throw new RxException("ruixing add return order fail returnOrderId = " + orgReturnOrder.getReturnOrderId() + ";orderId = " + orgReturnOrder.getOrderId());
		}
		return result;
	}
	
	/**
	 * 转换瑞星退货单
	 * @param orgUsersSession
	 * @param orgOrder
	 * @return
	 */
	private Org_RX_return_order setRxReturnOrder(OrgReturnOrder orgReturnOrder){
		//远程数据库数据修改
		Org_RX_return_order org_RX_return_order = new Org_RX_return_order();
		org_RX_return_order.setDocno(String.valueOf(orgReturnOrder.getReturnOrderId()));
		org_RX_return_order.setDoc21no(String.valueOf(orgReturnOrder.getOrderId()));
		org_RX_return_order.setPluno(orgReturnOrder.getGoodsSn());
		org_RX_return_order.setQty(orgReturnOrder.getAmount());
		org_RX_return_order.setAbsslprc(orgReturnOrder.getReturnUnitPrice());
		org_RX_return_order.setSlnet(orgReturnOrder.getReturnMoney().subtract(orgReturnOrder.getReturnSendMoney()));
		org_RX_return_order.setPsamt(orgReturnOrder.getReturnSendMoney());
		org_RX_return_order.setShpno(orgShopService.queryById(orgReturnOrder.getShopId()).getShopCode());
		return org_RX_return_order;
	}

}
