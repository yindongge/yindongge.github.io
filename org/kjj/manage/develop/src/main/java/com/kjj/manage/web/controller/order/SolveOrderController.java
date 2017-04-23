package com.kjj.manage.web.controller.order;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.order.OrgOrderLog;
import com.kjj.commserver.entity.order.OrgSolveOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderLogConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderLogVo;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.order.aide.OrgSolveOrderQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderLogService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgSolveOrderService;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/solveOrder")
public class SolveOrderController {

	@Resource
	private OrgSolveOrderService orgSolveOrderService;
	
	@Resource
	private OrgOrderService orgOrderService;
	
	@Resource
	private OrgOrderLogService orgOrderLogService;
	
	@Resource
	private OrgCouponRecordService orgCouponRecordService;
	
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model, PageReq pageReq,OrgSolveOrderQuery query){
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		query.setShopIds(admin.getShopIds());
		model.addAttribute("query", query);
		pageReq.setSort(new Sort(Direction.DESC,"t.id"));
		Page<OrgSolveOrder> page = orgSolveOrderService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		
		return "solveOrder/list";
	}
	
	@RequestMapping(value = "/detail/{id}", method = { RequestMethod.GET })
	public String detail(Model model,@PathVariable Integer id){
		OrgSolveOrder orgSolveOrder = orgSolveOrderService.queryById(id);
		model.addAttribute("orgSolveOrder", orgSolveOrder);
		
		OrgOrderVo orderVo = (OrgOrderVo) orgOrderService.queryVoById(orgSolveOrder.getOrderId());
		orderVo.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orgSolveOrder.getOrderId()));
		model.addAttribute("order", orderVo);
		
		//订单日志
		List<OrgOrderLog> listOrderLog = orgOrderLogService.query4AdminByOrderId(orgSolveOrder.getOrderId());
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
		
		OrgCouponRecord couponRecord = orgCouponRecordService.queryById(orgSolveOrder.getOrderId());
		model.addAttribute("couponRecord", couponRecord);
		
		return "solveOrder/detail";
	}

}
