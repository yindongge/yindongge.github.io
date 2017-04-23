package com.kjj.mobile.web.controller.discount;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderForm;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.mobile.constant.SessionConstant;


@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	@Resource
	private OrgCouponRecordService orgCouponRecordService;
	
	@RequestMapping(value = "/select", method = { RequestMethod.GET,RequestMethod.POST })
	public String selectCouponRecord(HttpSession session,OrgOrderForm orgOrderForm){
		OrgOrderForm orderFormSession  = (OrgOrderForm)session.getAttribute(SessionConstant.SESSION_ORDER_FORM);
		//session失效
		if(orderFormSession == null ){
			return "redirect:/cart/list";
		}
		if(orgOrderForm != null){
			orderFormSession.setTakeDate(orgOrderForm.getTakeDate());
			orderFormSession.setSendDate(orgOrderForm.getSendDate());
			orderFormSession.setSendTimeStart(orgOrderForm.getSendTimeStart());
			orderFormSession.setSendTimeEnd(orgOrderForm.getSendTimeEnd());
			orderFormSession.setConsigneeMobile(orgOrderForm.getConsigneeMobile());
			orderFormSession.setPayStyle(orgOrderForm.getPayStyle());
			orderFormSession.setUseDeposit(orgOrderForm.getUseDeposit());
			orderFormSession.setRemark(orgOrderForm.getRemark());
		}
		session.setAttribute(SessionConstant.SESSION_ORDER_FORM,orderFormSession);
		return "coupon/select";
	}
	
	@RequestMapping(value = {"/list","/welist"}, method = { RequestMethod.GET,RequestMethod.POST })
	public String selectCouponRecordList(Model model,HttpSession session,OrgCouponRecordQuery query){
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		query.setUserId(user.getOrgUsers().getUserId());
		if(query.getStatusCanUse() == null){
			query.setStatusCanUse(true); 
		}
		long countCanUse = orgCouponRecordService.queryCountCanUseByUserId(user.getOrgUsers().getUserId());
		long countCanNotUse = orgCouponRecordService.queryCountCanNotUseByUserId(user.getOrgUsers().getUserId());
		List<OrgCouponRecord> list = orgCouponRecordService.queryListWithShop(query);
		model.addAttribute("list", list);
		model.addAttribute("countCanUse", countCanUse);
		model.addAttribute("countCanNotUse", countCanNotUse);
		model.addAttribute("query", query);
		return "coupon/list";		
	}
	
	
}
