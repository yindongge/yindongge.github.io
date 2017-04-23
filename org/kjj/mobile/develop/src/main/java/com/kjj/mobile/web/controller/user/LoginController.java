package com.kjj.mobile.web.controller.user;

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
import com.kjj.mobile.constant.CookieConstant;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.CookieUtil;
import com.kjj.mobile.util.IpAddressUtil;

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
			String loginName,String password,String identifyCode){
		
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
		loginName = StringUtils.trimToEmpty(loginName);
		//查询用户
		if (StringUtils.isBlank(loginName)) {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "账号不能为空!");
			return mapResult;
		}
		
		if (StringUtils.isBlank(password)) {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "密码不能为空!");
			return mapResult;
		}
		
		OrgUsers orgUsers = orgUsersService.queryByLoginName(loginName);
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
			//微信openId
			String openId  = (String)session.getAttribute(SessionConstant.SESSION_OPEN_ID);
			if(StringUtils.isNotBlank(openId)){
				orgUsers.setOpenId(openId);
			}
			
			if(oldUsersSession != null ){
				if(oldUsersSession.getOrgUsers() != null){
					//设置用户默认配送方式
					orgUsers.setLastSendStyle(oldUsersSession.getOrgUsers().getLastSendStyle());
				}
				if(oldUsersSession.getOrgShop() != null){
					//设置用户默认自提店铺
					orgUsers.setServiceId(oldUsersSession.getOrgShop().getShopId().shortValue());
				}
			}
			
			orgUsersService.updateMobileLogin(oldUsersSession,orgUsers,IpAddressUtil.getIpAddress(request));
			
			//添加用户到自动登录
			String uuid = UUID.randomUUID().toString();
			OrgUserLogin orgUserLogin = new OrgUserLogin();
			orgUserLogin.setLoginip(orgUsers.getLastIp());
			orgUserLogin.setRememberKey(uuid);
			orgUserLogin.setUserid(orgUsers.getUserId());
			orgUserLoginService.add(orgUserLogin);
			CookieUtil.addCookieDefaultAge(response, CookieConstant.COOKIE_USER_KEY, uuid);
			
			mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
			//登录跳转
			mapResult.put("url", (String)session.getAttribute(SessionConstant.SESSION_LOGIN_BACK_URL));
			session.removeAttribute(SessionConstant.SESSION_LOGIN_BACK_URL);
			session.setAttribute(SessionConstant.SESSION_USER, oldUsersSession);
			//数量
			session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(oldUsersSession));
		}
		return mapResult;
	}
	
	@RequestMapping(value="/logout",method = { RequestMethod.GET})
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.removeAttribute(SessionConstant.SESSION_USER);
		session.removeAttribute(SessionConstant.SESSION_CART_COUNT);
		session.removeAttribute(SessionConstant.SESSION_ORDER_FORM);
		CookieUtil.removeCookie(response, CookieConstant.COOKIE_USER_KEY);
		CookieUtil.removeCookie(response, CookieConstant.COOKIE_LEAD_ME);
		CookieUtil.removeCookie(response, CookieConstant.COOKIE_LEAD_ME_ORDER);
		return "login/login";
	}
	
}
