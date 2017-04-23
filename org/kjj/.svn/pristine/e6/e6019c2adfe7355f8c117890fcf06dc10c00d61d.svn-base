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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.commserver.entity.user.OrgUserLogin;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.user.OrgUserActiveService;
import com.kjj.commserver.service.user.OrgUserLoginService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.CookieConstant;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.CookieUtil;
import com.kjj.mobile.util.IpAddressUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Resource
	private OrgArticleService orgArticleService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgUserActiveService orgUserActiveService;
	@Resource
	private OrgCartService orgCartService;
	@Resource
	private OrgUserLoginService orgUserLoginService;

	@RequestMapping(value = "/init")
	public String init(Model model) {
		return "register/register";
	}
	
	@RequestMapping(value = "/agreements")
	public String agreements(Model model) {
		return "register/agreements";
	}
	
	@ResponseBody
	@RequestMapping(value = "/register")
	public Map<String,Object> register(HttpSession session,HttpServletRequest request, HttpServletResponse response, OrgUsers orgUsers,String verifycode) {
		
		Map<String,Object> mapResult = new HashMap<String,Object>();
		final int CODE_ERROR_IDENTITY = 401;
		
		if (StringUtils.isBlank(verifycode) || verifycode.length() != 4) {
			mapResult.put("code",CODE_ERROR_IDENTITY);
			mapResult.put("desc", "验证码错误!");
			return mapResult;
		}else{
			
			OrgUserActive  orgUserActive =  orgUserActiveService.queryLastByMobilePhone(orgUsers.getMobilePhone());
			if( orgUserActive == null){
				mapResult.put("code",CODE_ERROR_IDENTITY);
				mapResult.put("desc", "验证码错误!");
				return mapResult;
			}else{
				if(orgUserActive.getVcode().equals(verifycode)){
					//判断是否过期 目前三十分钟过期
					if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 30 * 60 * 1000){
						//验证码过期
						mapResult.put("code",CODE_ERROR_IDENTITY);
						mapResult.put("desc", "验证码过期!");
						return mapResult;
					}
				}else{
					mapResult.put("code",CODE_ERROR_IDENTITY);
					mapResult.put("desc", "验证码错误!");
					return mapResult;
				}
			}
		}
		
		if(orgUsersService.queryByLoginName(orgUsers.getMobilePhone()) != null){
			mapResult.put("code",HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "该手机已经被注册!");
			return mapResult;
		}
		
		String openId  = (String)session.getAttribute(SessionConstant.SESSION_OPEN_ID);
		if(StringUtils.isNotBlank(openId)){
			orgUsers.setOpenId(openId);
		}
		//新增用户
		OrgUsersSession oldUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//session中内容添加
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
		//去掉空格
		String mobilePhone = orgUsers.getMobilePhone();
		mobilePhone = StringUtils.trimToEmpty(mobilePhone);
		orgUsers.setMobilePhone(mobilePhone);
		orgUsersService.add(orgUsers);
		//查询其他信息
		orgUsers = orgUsersService.queryVoById(orgUsers.getUserId());
		//用户登录
		orgUsersService.updateLogin(oldUsersSession,orgUsers,IpAddressUtil.getIpAddress(request));
		
		//添加用户到自动登录
		String uuid = UUID.randomUUID().toString();
		OrgUserLogin orgUserLogin = new OrgUserLogin();
		orgUserLogin.setLoginip(orgUsers.getLastIp());
		orgUserLogin.setRememberKey(uuid);
		orgUserLogin.setUserid(orgUsers.getUserId());
		orgUserLoginService.add(orgUserLogin);
		CookieUtil.addCookieDefaultAge(response, CookieConstant.COOKIE_USER_KEY, uuid);
		
		session.setAttribute(SessionConstant.SESSION_USER, oldUsersSession);
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		//登录跳转
		mapResult.put("url", (String)session.getAttribute(SessionConstant.SESSION_LOGIN_BACK_URL));
		session.removeAttribute(SessionConstant.SESSION_LOGIN_BACK_URL);
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkUser")
	public int checkUser(String mobilePhone){
		OrgUsers user = orgUsersService.queryByLoginName(mobilePhone);
		if(user != null){
			return HttpStatusCode.CODE_ERROR;
		}else{
			return HttpStatusCode.CODE_SUCCESS;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendRegisterCode")
	public int sendRegisterCode(String mobilePhone){
		orgUserActiveService.addRegisterCodeByMobilePhone(mobilePhone);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	@RequestMapping(value = "/bindMobileInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String bindMobileInit() {
		return "register/bindMobile";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bindMobile")
	public Map<String,Object> bindMobile(HttpSession session,HttpServletRequest request,OrgUsers orgUsers,String verifycode) {
		
		Map<String,Object> mapResult = new HashMap<String,Object>();
		final int CODE_ERROR_IDENTITY = 401;
		
		if (StringUtils.isBlank(verifycode) || verifycode.length() != 4) {
			mapResult.put("code",CODE_ERROR_IDENTITY);
			mapResult.put("desc", "验证码错误!");
			return mapResult;
		}else{
			
			OrgUserActive  orgUserActive =  orgUserActiveService.queryLastByMobilePhone(orgUsers.getMobilePhone());
			if( orgUserActive == null){
				mapResult.put("code",CODE_ERROR_IDENTITY);
				mapResult.put("desc", "验证码错误!");
				return mapResult;
			}else{
				if(orgUserActive.getVcode().equals(verifycode)){
					//判断是否过期 目前三十分钟过期
					if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 30 * 60 * 1000){
						//验证码过期
						mapResult.put("code",CODE_ERROR_IDENTITY);
						mapResult.put("desc", "验证码过期!");
						return mapResult;
					}
				}else{
					mapResult.put("code",CODE_ERROR_IDENTITY);
					mapResult.put("desc", "验证码错误!");
					return mapResult;
				}
			}
		}
		
		if(orgUsersService.queryByLoginName(orgUsers.getMobilePhone()) != null){
			mapResult.put("code",HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "该手机已经被注册!");
			return mapResult;
		}
		
		OrgUsersSession oldUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgUsers oldUser = orgUsersService.queryById(oldUsersSession.getOrgUsers().getUserId());
		oldUser.setMobilePhone(orgUsers.getMobilePhone());
		orgUsersService.updateByIdSelective(oldUser);
		oldUsersSession.getOrgUsers().setMobilePhone(orgUsers.getMobilePhone());
		session.setAttribute(SessionConstant.SESSION_USER, oldUsersSession);
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
}
