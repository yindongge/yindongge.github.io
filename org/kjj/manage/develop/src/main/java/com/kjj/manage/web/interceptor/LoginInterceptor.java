package com.kjj.manage.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.system.OrgAdminShopService;
import com.kjj.commserver.service.system.OrgAdminUserService;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PathUtil;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Resource
	private OrgAdminUserService orgAdminUserService;
	@Resource
	private OrgAdminShopService orgAdminShopService;

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String basePath = PathUtil.getBasePath(request);
		//String requestPath = request.getServletPath();
		//System.out.println("LoginInterceptor requestPath="+requestPath);
		OrgAdminUserSession adminSession = (OrgAdminUserSession)request.getSession().getAttribute(SessionConstant.SESSION_ADMIN);
		if(adminSession == null){
			response.sendRedirect(basePath);
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
