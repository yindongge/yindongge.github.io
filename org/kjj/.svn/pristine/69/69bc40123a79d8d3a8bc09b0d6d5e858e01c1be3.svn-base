package com.kjj.pc.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.user.OrgUserLogin;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUserLoginService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.pc.constant.CookieConstant;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.CookieUtil;
import com.kjj.pc.util.IpAddressUtil;

public class RemembermeInterceptor implements HandlerInterceptor{
	
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgUserLoginService orgUserLoginService;
	@Resource
	private OrgCartService orgCartService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgShopPageService orgShopPageService;

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		//String requestPath = request.getServletPath();
		//System.out.println("RemberMeInterceptor requestPath="+requestPath);
		
		OrgUsersSession userSession = (OrgUsersSession)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		
		if(userSession == null){
			userSession = new OrgUsersSession(OrgUsersConstant.SOURCE_PC);
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
						orgUsersService.updateLogin(userSession, user, IpAddressUtil.getIpAddress(request));
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
		
		if(userSession.getOrgShop() == null && userSession.isShopCheck()){
			//选择店铺
			String userShop = CookieUtil.getCookieValue(request, CookieConstant.COOKIE_USER_SHOP);
			if(StringUtils.isNotBlank(userShop)){
				OrgShop shop = orgShopService.queryVoById4Session(Integer.parseInt(userShop));
				if(shop.getStatus() != OrgShopConstant.STATUS_HIDE){
					userSession.setOrgShop(shop);
					request.getSession().setAttribute(SessionConstant.SESSION_USER, userSession);
				}else{
					userSession.setShopCheck(false);
				}
			}else{
				userSession.setShopCheck(false);
			}
		}
		
		request.getSession().setAttribute(SessionConstant.SESSION_USER, userSession);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}

}
