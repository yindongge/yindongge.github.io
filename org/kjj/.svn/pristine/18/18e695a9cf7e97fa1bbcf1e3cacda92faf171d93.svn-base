package com.kjj.pc.web.controller.order;

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

import com.kjj.commserver.entity.order.OrgRefundOrder;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgRefundOrderService;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/refund")
public class RefundController {
	@Resource
	private OrgRefundOrderService orgRefundOrderService;
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session,OrgRefundOrderQuery query,PageReq pageReq) {
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		pageReq.setSort(new Sort(Direction.DESC,"t.refund_order_id"));
		Page<OrgRefundOrder> page = orgRefundOrderService.queryPageList4User(user, query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "refund/list";
	}
	
	@RequestMapping(value = "/detail/{refundOrderId}", method = { RequestMethod.GET,RequestMethod.POST})
	public String detail(HttpSession session,Model model,@PathVariable Integer refundOrderId){
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		//后台校验
		if (refundOrderId == null) {
			return "error/error";
		}
		
		OrgRefundOrder refundOrder = orgRefundOrderService.queryVoById(refundOrderId);
		
		//后台校验
		if (!refundOrder.getUserId().equals( user.getOrgUsers().getUserId())) {
			return "error/error";
		}
		
		model.addAttribute("refundOrder", refundOrder);
		
		return "refund/detail";
	}
}
