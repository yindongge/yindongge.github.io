package com.kjj.mobile.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUserLevelConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.user.OrgEnterpriseInvitationService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
	
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgEnterpriseInvitationService orgEnterpriseInvitationService;
	
	@RequestMapping(value = "/invitationInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String invitationInit(Model model,HttpSession session) {
		
		OrgUsersSession usersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		if(usersSession.getOrgUsers().getLevelType() != OrgUserLevelConstant.LEVEL_TYPE_USER){
			model.addAttribute("info", "已绑定用户不可再次绑定");
		}
		return "enterprise/invitation";
	}

	@ResponseBody
	@RequestMapping(value = "/useInvitation", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> useInvitation(HttpSession session,HttpServletResponse response,String realName, String invitationCode){
		Map<String, Object> result = new HashMap<String, Object>();	
		
		OrgUsersSession  userSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		// 更改用户会员信息
		OrgUsers users = userSession.getOrgUsers();
		if(StringUtils.isNotBlank(realName)){
			users.setRealname(realName);
		}
		
		if(StringUtils.isBlank(invitationCode) || !orgEnterpriseInvitationService.updateInvitation(invitationCode, users)){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		
		// 重置会话内用户信息
		userSession.setOrgUsers(orgUsersService.queryVoById(users.getUserId()));
	    session.setAttribute(SessionConstant.SESSION_USER, userSession);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}
