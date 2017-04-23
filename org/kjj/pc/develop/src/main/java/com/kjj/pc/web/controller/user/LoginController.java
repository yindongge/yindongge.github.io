package com.kjj.pc.web.controller.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.user.OrgUserLogin;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.user.OrgUserLoginService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.pc.constant.CookieConstant;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.CookieUtil;
import com.kjj.pc.util.IpAddressUtil;
import com.kjj.pc.util.PathUtil;

@Controller
public class LoginController {
	
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgCartService orgCartService;
	@Resource
	private OrgUserLoginService orgUserLoginService;
	
	@RequestMapping(value="/loginInit",method = { RequestMethod.GET})
	public String loginInit(){
		return "login/login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/login")
	public Map<String,Object> login(HttpServletRequest request,HttpServletResponse response,HttpSession session,
			String username,String password,String identifyCode,boolean rememberMe){
		
		Map<String,Object> mapResult = new HashMap<String,Object>();

		OrgUsersSession oldUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		String identifyCodeSession  = (String)session.getAttribute(SessionConstant.SESSION_IDENTITY_CODE);

		if(identifyCodeSession != null){
			//开始验证登录
			if (StringUtils.isBlank(identifyCode) || !identifyCodeSession.equals(identifyCode.toUpperCase())) {
				final int CODE_ERROR_IDENTITY = 401;
				mapResult.put("code",CODE_ERROR_IDENTITY);
				mapResult.put("desc", "验证码错误!");
				return mapResult;
			} else {
				session.removeAttribute(SessionConstant.SESSION_IDENTITY_CODE);
			}
		}
		
		//查询用户
		if (StringUtils.isBlank(username)) {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "用户名不能为空!");
			return mapResult;
		}
		
		if (StringUtils.isBlank(password)) {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "密码不能为空!");
			return mapResult;
		}
		
		OrgUsers orgUsers = orgUsersService.queryByLoginName(username);
		
		if (orgUsers == null || !orgUsers.getPassword().equals(password)) {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "用户名或密码错误!");
			return mapResult;
		} else if (orgUsers.getStatus() == OrgUsersConstant.STATUS_INVALID) {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "用户已被锁定!");
			return mapResult;
		} else {
			//用户登录
			orgUsersService.updateLogin(oldUsersSession,orgUsers,IpAddressUtil.getIpAddress(request));
			
			//判断该用户是否启用自动登录
			if(rememberMe){
				//添加用户到自动登录
				String uuid = UUID.randomUUID().toString();
				OrgUserLogin orgUserLogin = new OrgUserLogin();
				orgUserLogin.setLoginip(orgUsers.getLastIp());
				orgUserLogin.setRememberKey(uuid);
				orgUserLogin.setUserid(orgUsers.getUserId());
				orgUserLoginService.add(orgUserLogin);
				CookieUtil.addCookieDefaultAge(response, CookieConstant.COOKIE_USER_KEY, uuid);
			}
			mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
			//登录跳转
			String url = (String)session.getAttribute(SessionConstant.SESSION_BACK_URL);
			if(StringUtils.isBlank(url)){
				url = PathUtil.getBasePath(request);
			}
			mapResult.put("url", url);
			session.removeAttribute(SessionConstant.SESSION_BACK_URL);
			session.setAttribute(SessionConstant.SESSION_USER, oldUsersSession);
			//数量
			session.setAttribute(SessionConstant.SESSION_CART_COUNT, orgCartService.getCountByUser(oldUsersSession));
		}
		return mapResult;
	}
	
	@RequestMapping(value="/logout",method = { RequestMethod.GET})
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.removeAttribute(SessionConstant.SESSION_USER);
		session.removeAttribute(SessionConstant.SESSION_CART_COUNT);
		CookieUtil.removeCookie(response, CookieConstant.COOKIE_USER_KEY);
		return "login/login";
	}
	
}
