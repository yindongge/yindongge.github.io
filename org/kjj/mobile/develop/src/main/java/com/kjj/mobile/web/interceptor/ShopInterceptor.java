package com.kjj.mobile.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.SessionConstant;

public class ShopInterceptor implements HandlerInterceptor{
	
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgShopService orgShopService;

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		//String requestPath = request.getServletPath();
		//System.out.println("ShopInterceptor requestPath="+requestPath);
		
		OrgUsersSession userSession = (OrgUsersSession)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		if(userSession == null || userSession.getOrgShop() == null){
			if(userSession == null){
				userSession = new OrgUsersSession(OrgUsersConstant.SOURCE_MOBILE);
			}
			//没有店铺用户设置默认店铺
			orgUsersService.updateUserShop4Take(userSession,orgShopService.queryNearbyShop((OrgLocation)request.getSession().getAttribute(SessionConstant.SESSION_LOCATION)));
			request.getSession().setAttribute(SessionConstant.SESSION_USER, userSession);
			return true;
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
