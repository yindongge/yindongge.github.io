package com.kjj.pc.web.controller.discount;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordConstant;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/coupon")
public class CouponController {

	@Resource
	private OrgCouponRecordService orgCouponRecordService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session,OrgCouponRecordQuery query,PageReq pageReq){
		
		if(query.getStatus() == null){
			query.setStatus(OrgCouponRecordConstant.STATUS_UNUSED);
		}
		
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		query.setUserId(user.getOrgUsers().getUserId());
		
		Page<OrgCouponRecord> page = orgCouponRecordService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "coupon/list";
	}
}
