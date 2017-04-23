package com.kjj.mobile.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.PathUtil;

public class PositionInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		String basePath = PathUtil.getBasePath(request);
		String requestPath = request.getServletPath();
		//System.out.println("PositionInterceptor requestPath="+requestPath);
		OrgLocation location = (OrgLocation)request.getSession().getAttribute(SessionConstant.SESSION_LOCATION);
		
		if(location == null){
			//重定向页面
			String parm = request.getQueryString();
			if(StringUtils.isBlank(parm)){
				request.getSession().setAttribute(SessionConstant.SESSION_BACK_URL, requestPath);
			}else{
				request.getSession().setAttribute(SessionConstant.SESSION_BACK_URL, requestPath+"?"+parm);
			}
			response.sendRedirect(basePath+"/position/init");
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
