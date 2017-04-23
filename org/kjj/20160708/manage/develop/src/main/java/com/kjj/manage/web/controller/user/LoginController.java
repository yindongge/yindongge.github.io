package com.kjj.manage.web.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.system.OrgAdminUser;
import com.kjj.commserver.entity.system.aide.OrgAdminUserConstant;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.system.aide.OrgModelVo;
import com.kjj.commserver.service.system.OrgAdminShopService;
import com.kjj.commserver.service.system.OrgAdminUserService;
import com.kjj.commserver.service.system.OrgModelService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.IpAddressUtil;
import com.kjj.manage.util.PageReq;

@Controller
public class LoginController {

	@Resource
	OrgAdminUserService orgAdminUserService;
	@Resource
	OrgAdminShopService orgAdminShopService;
	@Resource
	OrgModelService orgModelService;
	
	@RequestMapping(value = "/", method = { RequestMethod.GET,RequestMethod.POST })
	public String loginInit() {
		return "login/login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> login(HttpServletRequest request,HttpSession session,Model model, PageReq pageReq,String loginName,String password) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		
		if(StringUtils.isBlank(loginName)){
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "用户名不能为空!");
			return mapResult;
		}
		
		if (StringUtils.isBlank(password)) {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "密码不能为空!");
			return mapResult;
		}
		
		OrgAdminUser adminUser = orgAdminUserService.queryByMobile(loginName);

		if( adminUser == null || !password.equals(adminUser.getPassword())){
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "用户名或密码错误!");
			return mapResult;
		}else if (adminUser.getStatus() == OrgAdminUserConstant.STATUS_INVALID) {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "用户已被锁定!");
			return mapResult;
		}else{
			adminUser.setLastIp(IpAddressUtil.getIpAddress(request));
			adminUser.setLastLogin(new Date());
			orgAdminUserService.updateByIdSelective(adminUser);
			OrgAdminUserSession adminSession = new OrgAdminUserSession();
			adminSession.setOrgAdminUser(adminUser);
			//店铺权限
			adminSession.setShopIds(orgAdminShopService.queryShopIdsByUserId(adminUser.getUserId()));
			session.setAttribute(SessionConstant.SESSION_ADMIN, adminSession);
			//菜单
			session.setAttribute(SessionConstant.SESSION_ADMIN_MODEL, orgModelService.queryMapByUserId(adminUser.getUserId()));
			mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
			return mapResult;
		}
	}
	
	@RequestMapping(value="/logout",method = { RequestMethod.GET})
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.removeAttribute(SessionConstant.SESSION_ADMIN);
		session.removeAttribute(SessionConstant.SESSION_ADMIN_MODEL);
		return "login/login";
	}
	
	@RequestMapping(value ="/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(Model model,HttpSession session){		
		
		@SuppressWarnings("unchecked")
		Map<Integer,OrgModelVo> mapModel = (Map<Integer,OrgModelVo>)session.getAttribute(SessionConstant.SESSION_ADMIN_MODEL);
		
		if(MapUtils.isNotEmpty(mapModel)){
			Iterator<Map.Entry<Integer,OrgModelVo>> it = mapModel.entrySet().iterator();
			if (it.hasNext()) {
				OrgModelVo  modelOne = it.next().getValue();
				model.addAttribute("left", "/page/left?modelid="+modelOne.getModelid());
				
				if(CollectionUtils.isNotEmpty(modelOne.getModelList())){
					model.addAttribute("right", modelOne.getModelList().get(0).getUrl());
				}
			}
		}
		return "page/index";	
	}
}
