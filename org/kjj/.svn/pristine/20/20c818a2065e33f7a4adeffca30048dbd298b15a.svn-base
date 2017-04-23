package com.kjj.touch.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.touch.constant.SessionConstant;
import com.kjj.touch.util.CookieUTF8Util;
import com.kjj.touch.util.PathUtil;


public class AllRoundInterceptor extends HandlerInterceptorAdapter {

	@Resource
	OrgShopService orgShopService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object arg) throws Exception {
		String shopId = CookieUTF8Util.getCookieValue(request, "shop");
		OrgShop orgShop=null;
		if(StringUtils.isNotBlank(shopId)){
			orgShop = orgShopService.queryVoById(Integer.parseInt(shopId));
		}
		
//		String backUrl = CookieUTF8Util.getCookieValue(request, SessionConstant.SESSION_BACK_URL);
		String backUrl = (String)request.getSession().getAttribute(SessionConstant.SESSION_BACK_URL);
		String requestPath = request.getServletPath();
		if(StringUtils.isBlank(shopId) || orgShop==null){
			if(StringUtils.isBlank(backUrl)){
				String parm = request.getQueryString();
				if(StringUtils.isBlank(parm)){
//					CookieUTF8Util.addCookieDefaultAge(response, SessionConstant.SESSION_BACK_URL, requestPath);
					request.getSession().setAttribute(SessionConstant.SESSION_BACK_URL, requestPath);
				}else{
//					CookieUTF8Util.addCookieDefaultAge(response, SessionConstant.SESSION_BACK_URL, requestPath+"?"+parm);
					request.getSession().setAttribute(SessionConstant.SESSION_BACK_URL, requestPath+"?"+parm);
				}
			}
			//返回首页
			String basePath = PathUtil.getBasePath(request);
			response.sendRedirect(basePath);
			return false;
		}else{
			if(StringUtils.equals(requestPath, backUrl)){
				request.getSession().setAttribute(SessionConstant.SESSION_BACK_URL, "");
			}
			OrgUsersSession userSession = (OrgUsersSession)request.getSession().getAttribute(SessionConstant.SESSION_USER);
			if(userSession == null){
//				userSession = new OrgUsersSession(OrgUsersConstant.SOURCE_TOUCH);
				userSession = new OrgUsersSession(OrgUsersConstant.SOURCE_PC);
				userSession.setOrgShop(orgShop);
				request.getSession().setAttribute(SessionConstant.SESSION_USER, userSession);
			}
			return true;
		}
		
	}

}
