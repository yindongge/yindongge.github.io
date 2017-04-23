package com.kjj.manage.web.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.OrgOrderLog;
import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.commserver.entity.order.OrgReturnOrderImg;
import com.kjj.commserver.entity.order.OrgReturnOrderLog;
import com.kjj.commserver.entity.order.aide.OrgOrderLogConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderLogVo;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderLogVo;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderLogService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgRefundOrderService;
import com.kjj.commserver.service.order.OrgReturnOrderImgService;
import com.kjj.commserver.service.order.OrgReturnOrderLogService;
import com.kjj.commserver.service.order.OrgReturnOrderService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/return")
public class ReturnController {
	
	@Resource
	private OrgReturnOrderService orgReturnOrderService;
	@Resource
	private OrgRefundOrderService orgRefundOrderService;
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgReturnOrderLogService orgReturnOrderLogService;
	@Resource
	OrgReturnOrderImgService orgReturnOrderImgService;
	@Resource
	OrgOrderLogService orgOrderLogService;
	
	
	@RequestMapping(value = "/addInit/{orderId}", method = { RequestMethod.GET})
	public String addInit(Model model,HttpSession session, @PathVariable Integer orderId) {
		
		OrgOrder order = orgOrderService.queryById(orderId);
		model.addAttribute("order",order);
		
		List<OrgOrderGoods> listOrderGoods = orgOrderGoodsService.query4ReturnByOrderId(orderId);
		model.addAttribute("listOrderGoods",listOrderGoods);
		OrgShopVo  shop = orgShopService.queryVoById(order.getShopId());
		model.addAttribute("shop",shop);
		//联系方式
		String returnTel = "";
		if(StringUtils.isNotBlank(order.getConsigneeMobile())){
			returnTel = order.getConsigneeMobile();
		}else if(StringUtils.isNotBlank(order.getConsigneeTel())){
			returnTel = order.getConsigneeTel();
		}
		model.addAttribute("returnTel",returnTel);
		
		return "return/add";
	}
	
	
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public String add(Model model,HttpSession session,OrgReturnOrder returnOrder) {
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		OrgOrderGoods orderGoods = orgOrderGoodsService.queryVoById(returnOrder.getOrderGoodsId());
		OrgOrder order = orgOrderService.queryById(orderGoods.getOrderId());
		
		returnOrder.setOrderId(order.getOrderId());
		returnOrder.setOrderSerialNo(order.getSerialNo());
		returnOrder.setUserId(order.getUserId());
		returnOrder.setShopId(order.getShopId());
		returnOrder.setGoodsId(orderGoods.getGoodsId());
		returnOrder.setGoodsSn(orderGoods.getGoodsSn());
		returnOrder.setReturnStyle(OrgReturnOrderConstant.RETURN_STYLE_RETURN);
		returnOrder.setTakeStyle(OrgReturnOrderConstant.TAKE_STYLE_TAKE);
		orgReturnOrderService.addByAdmin(returnOrder,admin);
		
		return "redirect:/return/list";
	}
	
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session,OrgReturnOrderQuery query, PageReq pageReq) {
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		query.setShopIds(admin.getShopIds());
		
		//退货订单列表
		pageReq.setPageSize(10);
		pageReq.setSort(new Sort(Direction.DESC,"t.return_order_id"));
		Page<OrgReturnOrder> page = orgReturnOrderService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "return/list";
	}
	
	@RequestMapping(value = "/detail/{returnOrderId}", method = { RequestMethod.GET })
	public String detail(Model model,@PathVariable Integer returnOrderId){
		
		OrgReturnOrder orgReturnOrder = orgReturnOrderService.queryById(returnOrderId);
		model.addAttribute("orgReturnOrder", orgReturnOrder);
		
		//退换货图片
		List<OrgReturnOrderImg> listReturnorderimg = orgReturnOrderImgService.queryByReturnOrderId(returnOrderId);
		model.addAttribute("listReturnorderimg", listReturnorderimg);
		
		//退换货订单日志
		List<OrgReturnOrderLog> listReturnOrderLog = orgReturnOrderLogService.queryByReturnOrderId(orgReturnOrder.getReturnOrderId());
		OrgReturnOrderLogVo reOrderlogVo = null;
		for(OrgReturnOrderLog log : listReturnOrderLog){
			reOrderlogVo = (OrgReturnOrderLogVo)log;
			if(reOrderlogVo.getLogSource() == OrgOrderLogConstant.SOURCE_USER){
				reOrderlogVo.setAdminName("用户");
			}else if(reOrderlogVo.getLogSource() == OrgOrderLogConstant.SOURCE_SYSTEM){
				reOrderlogVo.setAdminName("系统");
			}
		}
		model.addAttribute("listReturnOrderLog", listReturnOrderLog);
		
		OrgOrder order = orgOrderService.queryById(orgReturnOrder.getOrderId());
		model.addAttribute("order", order);
		
		OrgOrderGoods orderGoods = orgOrderGoodsService.queryVoById(orgReturnOrder.getOrderGoodsId());
		model.addAttribute("orderGoods", orderGoods);
		
		//订单日志
		List<OrgOrderLog> listOrderLog = orgOrderLogService.query4AdminByOrderId(orgReturnOrder.getOrderId());
		model.addAttribute("listOrderLog", listOrderLog);
		
		//确认订单的日志
		OrgOrderLog confirmLog = null;
		//取消订单的日志
		OrgOrderLog sendLog = null;
		OrgOrderLogVo logVo = null;
		for(OrgOrderLog log : listOrderLog){
			logVo = (OrgOrderLogVo)log;
			if(logVo.getLogSource()== OrgOrderLogConstant.SOURCE_USER){
				logVo.setAdminName("用户");
			}else if(logVo.getLogSource() == OrgOrderLogConstant.SOURCE_SYSTEM){
				logVo.setAdminName("系统");
			}
			//添加日志链
			if(log.getLogType() == OrgOrderLogConstant.TYPE_ADMIN_CONFIRE || log.getLogType() == OrgOrderLogConstant.TYPE_SYSTEM_CONFIRE){
				confirmLog = log;
			}else if(log.getLogType() == OrgOrderLogConstant.TYPE_ADMIN_SEND){
				sendLog = log;
			}
		}
		model.addAttribute("confirmLog", confirmLog);
		model.addAttribute("sendLog", sendLog);
		
		return "return/detail";
	}
	@ResponseBody
	@RequestMapping(value = "/approve", method = { RequestMethod.POST })
	public Map<String, Object> approve(Integer returnOrderId,String logDetail,HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgReturnOrderService.updateApprove(returnOrderId,logDetail,admin)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！退货单状态已改变，请刷新");
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/refuse", method = { RequestMethod.POST })
	public Map<String, Object> refuse(Integer returnOrderId,String logDetail,String reply,HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgReturnOrderService.updateRefuse(returnOrderId,logDetail,admin,reply)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			}else{
				result.put("desc", "非法操作！退货单状态已改变，请刷新");
			}
			return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/fail", method = { RequestMethod.POST })
	public Map<String, Object> fail(Integer returnOrderId,String logDetail,String reply,HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgReturnOrderService.updateFail(returnOrderId,logDetail,admin,reply)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			}else{
				result.put("desc", "非法操作！退货单状态已改变，请刷新");
			}
			return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/finish", method = { RequestMethod.POST })
	public Map<String, Object> finish(OrgReturnOrder orgReturnOrder,String logDetail,HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgReturnOrderService.updateFinish(orgReturnOrder,logDetail,admin)){
				result.put("code", HttpStatusCode.CODE_SUCCESS);
			}else{
				result.put("desc", "非法操作！退货单状态已改变，请刷新");
			}
			return result;
	}
	@ResponseBody
	@RequestMapping(value = "/remark", method = { RequestMethod.POST })
	public Map<String, Object> remark(Integer returnOrderId,String logDetail,HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		orgReturnOrderService.updateRemark(returnOrderId,logDetail,admin);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}
