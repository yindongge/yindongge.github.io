package com.kjj.pc.web.controller.order;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.pc.constant.SessionConstant;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@RequestMapping(value = "/payInit", method = { RequestMethod.POST,RequestMethod.GET })
	public String payInit(HttpSession session, Model model,Integer orderId) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//后台校验
		if (orderId == null) {
			return "error/error";
		}
		
		OrgOrderVo order = (OrgOrderVo)orgOrderService.queryVoById(orderId);
		//订单商品
		order.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orderId));
		
		if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			return "error/error";
		}
		
		if(order.getPayStyle() != OrgOrderConstant.PAY_STYLE_ONLINE || order.getPayStatus() == OrgOrderConstant.PAY_STATUS_PAID){
			return "error/error";
		}
		
		model.addAttribute("order",order);
		return "pay/online";
	}
}
