package com.kjj.commserver.service.swap.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.swap.Org_RX_order;
import com.kjj.commserver.entity.swap.Org_RX_order_goods;
import com.kjj.commserver.entity.swap.aide.Org_RX_orderConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.exception.swap.RxException;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.swap.RxOrderService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.CommServerPropertiesUtil;
import com.kjj.commserver.util.HttpClientUtil;

@Service
public class RxOrderServiceImpl implements RxOrderService{
	
	/** 日志记录 */
	protected static final Log logger = LogFactory.getLog(RxOrderServiceImpl.class);
	
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgUsersService orgUsersService;

	@Override
	public boolean add(OrgUsersSession orgUsersSession,OrgOrder orgOrder,List<OrgOrderGoods> listGoods) {
		//转换瑞星订单
		Org_RX_order rx_order = setRxOrder(orgUsersSession,orgOrder);
		//转换瑞星订单商品
		List<Org_RX_order_goods> listRxGoods = setListRxOrderGoods(orgUsersSession,listGoods);
		//生成订单
		boolean result = add(rx_order,listRxGoods);
		if(!result){
			throw new RxException("ruixing add order fail orderId = " + orgOrder.getOrderId());
		}
		return false;
	}
	
	/**
	 * 转换瑞星订单
	 * @param orgUsersSession
	 * @param orgOrder
	 * @return
	 */
	private Org_RX_order setRxOrder(OrgUsersSession orgUsersSession,OrgOrder orgOrder){
		Org_RX_order rx_order = new Org_RX_order();
		rx_order.setDocno(String.valueOf(orgOrder.getOrderId()));
		rx_order.setShpno(orgUsersSession.getOrgShop().getShopCode());
		rx_order.setVipno(orgUsersSession.getOrgUsers().getMobilePhone());
		//实收金额=应收-优惠(不包含配送费)
		rx_order.setSlamt(orgOrder.getAccounts());
		//优惠
		rx_order.setDisamt(orgOrder.getDiscount());
		//配送
		rx_order.setPsamt(orgOrder.getSendMoney());
		//状态预订单
		rx_order.setStatus(0);
		return rx_order;
	}
	
	/**
	 * 转换瑞星订单商品
	 * @param orgUsersSession
	 * @param listGoods
	 * @return
	 */
	private List<Org_RX_order_goods> setListRxOrderGoods(OrgUsersSession orgUsersSession,List<OrgOrderGoods> listGoods){
		List<Org_RX_order_goods> listRXGoods = new ArrayList<Org_RX_order_goods>();
		Org_RX_order_goods rx_order_goods = null;
		for(OrgOrderGoods orderGoods:listGoods){
			rx_order_goods = new Org_RX_order_goods();
			rx_order_goods.setDocno(String.valueOf(orderGoods.getOrderId()));
			rx_order_goods.setPluno(orderGoods.getGoodsSn());
			//销售数量
			rx_order_goods.setQty(orderGoods.getAmount());
			//应销单价
			rx_order_goods.setSlprc(orderGoods.getUnitAccounts());
			//实销单价
			rx_order_goods.setAbsslprc(orderGoods.getUnitPrice());
			//销售毛额
			rx_order_goods.setSlamt(orderGoods.getUnitAccounts().multiply(BigDecimal.valueOf(orderGoods.getAmount())));
			//销售净额
			rx_order_goods.setSlnet(orderGoods.getUnitPrice().multiply(BigDecimal.valueOf(orderGoods.getAmount())));
			//折扣折让
			rx_order_goods.setDisamt(rx_order_goods.getSlamt().subtract(rx_order_goods.getSlnet()));
			rx_order_goods.setSno(orderGoods.getId());
			rx_order_goods.setShpno(orgUsersSession.getOrgShop().getShopCode());
			listRXGoods.add(rx_order_goods);
		}
		return listRXGoods;
	}
	
	/**
	 * 生成瑞星订单和明细
	 * @param rx_order
	 * @param listRxGoods
	 * @return
	 */
	private boolean add(Org_RX_order rx_order,List<Org_RX_order_goods> listRxGoods){
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		Gson gson = new Gson();
		String order = gson.toJson(rx_order);
		String goods = gson.toJson(listRxGoods);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("order",order);
		params.put("goods",goods);
		String strResult = null;
		try {
			strResult = util.getResponseBodyAsString(CommServerPropertiesUtil.getProperty("rxservice.url")+"/order/add", params);
		} catch (Exception e) {
		}
		if(strResult!=null){
			result = strResult.contains("200");
			
		}
		//日志
		if(result){
			logger.info("RxOrder add success ="+params);
		}else{
			logger.error("RxOrder add fail ="+params);
		}
		return result;
	}

	@Override
	public boolean deleteByOrderId(Integer orderId) {
		boolean result = false;
		result =  updateStatusByOrderId(String.valueOf(orderId),Org_RX_orderConstant.RX_ORDER_STATUS_DELETE);
		if(!result){
			throw new RxException("ruixing cancel order fail orderId = " + orderId);
		}
		return result;
	}
	
	@Override
	public boolean updateFinishByOrderId(Integer orderId) {
		boolean result = false;
		result =  updateStatusByOrderId(String.valueOf(orderId),Org_RX_orderConstant.RX_ORDER_STATUS_FINISH);
		if(!result){
			throw new RxException("ruixing finish order fail orderId = " + orderId);
		}
		return result;
	}
	
	/**
	 * 远程订单修改
	 * @param orderId
	 * @param status 状态 1.订单完成2.订单删除
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	private boolean updateStatusByOrderId(String orderId,String status) {
		boolean  result = false;
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		Map params = new HashMap();
		params.put("docno",orderId);
		params.put("status",status);
		String strResult = null;
		try {
			strResult = util.getResponseBodyAsString(CommServerPropertiesUtil.getProperty("rxservice.url")+"/order/update", params);
		} catch (Exception e) {
		}
		if(strResult!=null){
			result = strResult.contains("200");
		}
		//日志
		if(result){
			logger.info("RxOrder updateStatus success ="+params);
		}else{
			logger.error("RxOrder updateStatus fail ="+params);
		}
		return result;
	}

}
