package com.kjj.pc.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUserLoginService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PathUtil;

public class ShopInterceptor implements HandlerInterceptor{
	
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgUserLoginService orgUserLoginService;
	@Resource
	private OrgCartService orgCartService;

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		String basePath = PathUtil.getBasePath(request);
		String requestPath = request.getServletPath();
		//System.out.println("ShopInterceptor requestPath="+requestPath);
		
		OrgUsersSession userSession = (OrgUsersSession)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		
		if(userSession == null){
			userSession = new OrgUsersSession(OrgUsersConstant.SOURCE_PC);
		}
		
		String backUrl =  (String) request.getSession().getAttribute(SessionConstant.SESSION_BACK_URL);
		if(userSession.getOrgShop() == null){
			//重定向页面
			if(StringUtils.isBlank(backUrl)){
				String parm = request.getQueryString();
				if(StringUtils.isBlank(parm)){
					request.getSession().setAttribute(SessionConstant.SESSION_BACK_URL, requestPath);
				}else{
					request.getSession().setAttribute(SessionConstant.SESSION_BACK_URL, requestPath+"?"+parm);
				}
			}
			//返回首页
			response.sendRedirect(basePath);
			return false;
		}else{
			if(StringUtils.equals(requestPath, backUrl)){
				request.getSession().setAttribute(SessionConstant.SESSION_BACK_URL, "");
			}
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}

}
