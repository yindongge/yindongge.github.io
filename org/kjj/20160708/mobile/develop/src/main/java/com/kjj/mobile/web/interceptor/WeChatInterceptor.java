package com.kjj.mobile.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.entity.user.OrgUserLogin;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.user.OrgUserLoginService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.CookieConstant;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.CookieUTF8Util;
import com.kjj.mobile.util.CookieUtil;
import com.kjj.mobile.util.IpAddressUtil;
import com.kjj.mobile.util.PathUtil;
import com.kjj.mobile.util.WeChatUtil;

public class WeChatInterceptor implements HandlerInterceptor{
	
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgCartService orgCartService;
	@Resource
	private OrgUserLoginService orgUserLoginService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		String basePath = PathUtil.getBasePath(request);
		String requestPath = request.getServletPath();
		//System.out.println("WeChatInterceptor requestPath="+requestPath);
		
		OrgUsersSession userSession = (OrgUsersSession)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		
		if(userSession == null){
			userSession = new OrgUsersSession(OrgUsersConstant.SOURCE_MOBILE);
		}	
		
		if(!userSession.isLogin() && userSession.isRemembermeCheck()){
			//自动登录
			String userKey = CookieUtil.getCookieValue(request, CookieConstant.COOKIE_USER_KEY);
			if(StringUtils.isNotBlank(userKey)){
				//给用户自动登录
				OrgUserLogin userLogin = orgUserLoginService.queryByRememberKey(userKey);
				
				if(userLogin != null){
					OrgUsers user = orgUsersService.queryVoById(userLogin.getUserid());
					//用户存在且不为锁定状态
					if(user != null && user.getStatus() != OrgUsersConstant.STATUS_INVALID){
						orgUsersService.updateMobileLogin(userSession, user, IpAddressUtil.getIpAddress(request));
						//数量
						request.getSession().setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(userSession));
					}
				}else{
					userSession.setRemembermeCheck(false);
				}
			}else{
				userSession.setRemembermeCheck(false);
			}
		}
		
		request.getSession().setAttribute(SessionConstant.SESSION_USER, userSession);
		
		//定位
		OrgLocation location = (OrgLocation)request.getSession().getAttribute(SessionConstant.SESSION_LOCATION);
		if(location == null){
			//定位历史
			String localHistory = CookieUTF8Util.getCookieValue(request, CookieConstant.COOKIE_LOCAL_HISTORY);
			if(StringUtils.isNotBlank(localHistory)){
				location = orgUsersService.getLastLocalHistory(localHistory);
				request.getSession().setAttribute(SessionConstant.SESSION_LOCATION,location);
			}
		}
		
		//判断浏览器是否微信
		String openIdSession = (String)request.getSession().getAttribute(SessionConstant.SESSION_OPEN_ID);
		if(StringUtils.isEmpty(openIdSession)){
			String ua = request.getHeader("user-agent").toLowerCase();
			if (ua.indexOf("micromessenger") < 0) {
				// 不是微信浏览器
				return true;
			}
		}
		
		if(requestPath.startsWith("/getOpenId")){
			//微信转发请求
			String code = request.getParameter("code");
			String openId = WeChatUtil.getOpenid(code);
			request.getSession().setAttribute(SessionConstant.SESSION_OPEN_ID, openId);
			//重定向页面
			response.sendRedirect(basePath+requestPath.replace("/getOpenId", ""));
			return false;
		}else{
			if(StringUtils.isEmpty(openIdSession)){
				//重定向重新获取openId
				response.sendRedirect(WeChatUtil.getRedirectUrl(basePath,requestPath));
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}
