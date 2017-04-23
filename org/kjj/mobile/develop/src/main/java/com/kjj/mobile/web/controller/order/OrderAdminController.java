package com.kjj.mobile.web.controller.order;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.system.OrgAdminUser;
import com.kjj.commserver.entity.system.aide.OrgAdminUserQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.system.OrgAdminUserService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.ExceptionUtil;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/orderAdmin")
public class OrderAdminController {
	
	/** 日志记录 */
	protected static final Log logger = LogFactory.getLog(OrderAdminController.class);
	
	public static final int CODE_ERROR_DEPOSIT = 500;
	
	@Resource
	private OrgOrderService orgOrderService; 
	
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@Resource
	private OrgAdminUserService orgAdminUserService;
	
	@Resource
	private OrgUsersService orgUsersService;
	
	
	
	@RequestMapping(value = "/detail4Admin/{orderId}", method = {RequestMethod.GET,RequestMethod.POST })
	public String detail4Admin(HttpSession session,Model model, @PathVariable Integer orderId,HttpServletRequest request,HttpServletResponse response ) {
		//后台校验
		if (orderId == null) {
			logger.error("未获得到订单编号");
			model.addAttribute("desc","未获得到订单编号");
			return "order/errorInfo";
		}
		
		String ua = request.getHeader("user-agent").toLowerCase();
		if (ua.indexOf("micromessenger") < 0) {
			// 不是微信浏览器
			logger.error("不是微信浏览器");
			model.addAttribute("desc","请用微信扫码打开此页面");
			return "order/errorInfo";
		}

		//到session中查询用户openId
		 String openId = (String) session.getAttribute(SessionConstant.SESSION_OPEN_ID);
		 if(StringUtils.isBlank(openId)){
			 logger.error("没有获取到openId");
			 model.addAttribute("desc","请先关注快捷键商城微信公众号:kjjhomefw");
			 return "order/errorInfo";
		 }
		//根据openId查询用户信息
		OrgUsersQuery orgUsersQuery = new OrgUsersQuery();
		orgUsersQuery.setOpenId(openId);
		OrgUsers orgUser = orgUsersService.queryOne(orgUsersQuery);
		if(orgUser==null){
			logger.error("未获得到该用户");
			model.addAttribute("desc","请注册并登录快捷键商城");
			return "order/errorInfo";
		}
		OrgAdminUserQuery orgAdminUserQuery = new OrgAdminUserQuery();
		String mobilePhone = orgUser.getMobilePhone();
		if(StringUtils.isBlank(mobilePhone)){
			logger.error("该用户没有用户表维护手机号");
			model.addAttribute("desc","请维护您的手机号");
			return "order/errorInfo";
		}
		orgAdminUserQuery.setMobile(mobilePhone);
		OrgAdminUser orgAdminUser=null;
		try {
			orgAdminUser = orgAdminUserService.queryOne(orgAdminUserQuery);
		} catch (Exception e) {
			logger.error(ExceptionUtil.getStackMsg(e));
			logger.error("该管理员可能维护了多个手机号");
			model.addAttribute("desc","该管理员可能维护了多个手机号");
			return "order/errorInfo";
		}
		//获得订单
		OrgOrderVo order = (OrgOrderVo)orgOrderService.queryVoById(orderId);
		if (order == null) {
			logger.error("未获得到订单信息");
			model.addAttribute("desc","系统未获得到订单信息");
			return "order/errorInfo";
		}
		//订单商品
		order.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orderId));
		model.addAttribute("order",order);
		if(orgAdminUser==null && order.getUserId().equals(orgUser.getUserId())){
			logger.info("访问者为该订单普通用户，有订单权限，展示订单页面");
			return "order/detail";
		}
		if(orgAdminUser==null && ! order.getUserId().equals(orgUser.getUserId())){
			logger.error("该管理员没有维护和用户表一样的手机号，或该用户不是管理员也没有订单权限");
			model.addAttribute("desc","您没有查看权限");
			return "order/errorInfo";
		}
		OrgAdminUserSession orgAdminUserSession = new OrgAdminUserSession();
		orgAdminUserSession.setOrgAdminUser(orgAdminUser);
		session.setAttribute(SessionConstant.SESSION_ADMIN, orgAdminUserSession);
		return "order/detail4Admin";
	}
	
	@ResponseBody
	@RequestMapping(value = "/confirm", method = { RequestMethod.POST })
	public Map<String,Object> confirm(Integer orderId,String logDetail,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		if(orgOrderService.updateConfirm(orderId,logDetail,admin)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！订单状态已改变，请刷新");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendOrTake", method = { RequestMethod.POST })
	public Map<String,Object> sendOrTake(Integer orderId,String logDetail,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgOrderService.updateSendOrTake(orderId,logDetail,admin)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！订单状态已改变，请刷新");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/finish", method = { RequestMethod.POST })
	public Map<String,Object> finish(Integer orderId,String logDetail,String takeCode,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgOrderService.updateFinish(orderId,logDetail,takeCode,admin)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！订单状态已改变，请刷新");
		}
		return result;
	}
	
	
}
