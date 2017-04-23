package com.kjj.mobile.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.PathUtil;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgShopService orgShopService;

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		String basePath = PathUtil.getBasePath(request);
		String requestPath = request.getServletPath();
		//System.out.println("LoginInterceptor requestPath="+requestPath);
		OrgUsersSession userSession = (OrgUsersSession)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		if( userSession == null ||  !userSession.isLogin()){
			//重定向页面
			String parm = request.getQueryString();
			if(StringUtils.isBlank(parm)){
				request.getSession().setAttribute(SessionConstant.SESSION_LOGIN_BACK_URL, requestPath);
			}else{
				request.getSession().setAttribute(SessionConstant.SESSION_LOGIN_BACK_URL, requestPath+"?"+parm);
			}
			response.sendRedirect(basePath+"/loginInit");
			return false;
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
