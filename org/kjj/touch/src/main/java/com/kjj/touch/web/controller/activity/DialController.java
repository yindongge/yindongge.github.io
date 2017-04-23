package com.kjj.touch.web.controller.activity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.kjj.commserver.entity.activity.OrgActivity;
import com.kjj.commserver.entity.activity.OrgActivityShop;
import com.kjj.commserver.entity.activity.aide.OrgActivityShopQuery;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.activity.OrgActivityDialitemService;
import com.kjj.commserver.service.activity.OrgActivityService;
import com.kjj.commserver.service.activity.OrgActivityShopService;
import com.kjj.commserver.util.ExceptionUtil;
import com.kjj.touch.constant.SessionConstant;

@Controller
@RequestMapping("/dial")
public class DialController {
		
	protected static final Log logger = LogFactory.getLog(DialController.class);
	
	@Resource
	private OrgActivityService orgActivityService;
	
	@Resource
	private OrgActivityShopService orgActivityShopService;
	
	@Resource
	private OrgActivityDialitemService orgActivityDialitemService;


	@RequestMapping(value = "/draw", method = {RequestMethod.GET,RequestMethod.POST })
	public String draw(Model model,HttpSession session,HttpServletRequest request) {
		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		OrgShop orgShop = orgUsersSession.getOrgShop();
		OrgActivityShopQuery orgActivityShopQuery = new OrgActivityShopQuery();
		orgActivityShopQuery.setShopId(orgShop.getShopId());
		orgActivityShopQuery.setTimeFlg(true);
		OrgActivityShop orgActivityShop;
		try {
			orgActivityShop = orgActivityShopService.queryOne(orgActivityShopQuery);
			if(orgActivityShop==null){
				logger.info("没有活动");
				return "redirect:/";
			}
			OrgActivity orgActivity = orgActivityService.queryVoById(orgActivityShop.getActivityId());			
			model.addAttribute("orgActivity", orgActivity);
			Gson gson=new Gson();
			model.addAttribute("orgActivityJson",gson.toJson(orgActivity));
		} catch (Exception e) {
			logger.error("查询到多个转盘活动");
			logger.error(ExceptionUtil.getStackMsg(e));
			return "redirect:/";
		}  
		return "/activity/dial";
	}
		
}
