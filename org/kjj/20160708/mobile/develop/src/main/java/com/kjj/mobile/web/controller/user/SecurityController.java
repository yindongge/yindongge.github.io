package com.kjj.mobile.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.user.OrgUserActiveService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/security")
public class SecurityController {
	
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgUserActiveService orgUserActiveService;
	
	@RequestMapping(value = "/center", method = {RequestMethod.GET,RequestMethod.POST })
	public String security() {
		return "security/center";
	}
	
	@RequestMapping(value = "/passwordInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String passwordInit() {
		return "security/password";
	}
	
	@ResponseBody
	@RequestMapping(value = "/password")
	public Map<String,Object> password(HttpSession session,String oldPassword,OrgUsers orgUsers,Model model){
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession userSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgUsers user = orgUsersService.queryById(userSession.getOrgUsers().getUserId());
		if (!user.getPassword().equals(oldPassword)){
			mapResult.put("code",HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "验证码错误!");
		}else{
			orgUsers.setUserId(userSession.getOrgUsers().getUserId());
			orgUsersService.updateByIdSelective(orgUsers);
			userSession.getOrgUsers().setPassword(orgUsers.getPassword());
			session.setAttribute(SessionConstant.SESSION_USER, userSession);
			mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		}
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendIdentityCode")
	public int sendIdentityCode(String mobilePhone){
		orgUserActiveService.addRegisterCodeByMobilePhone(mobilePhone);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	@RequestMapping(value = "/bindMobileInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String bindMobileInit() {
		return "security/bindMobile";
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
		
		OrgUsersSession oldUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//和原手机号一致
		if(orgUsers.getMobilePhone().equals(oldUsersSession.getOrgUsers().getMobilePhone())){
			mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
			return mapResult;
		}
		
		if(orgUsersService.queryByLoginName(orgUsers.getMobilePhone()) != null){
			mapResult.put("code",HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "该手机已经被注册!");
			return mapResult;
		}
		
		OrgUsers oldUser = orgUsersService.queryById(oldUsersSession.getOrgUsers().getUserId());
		oldUser.setMobilePhone(orgUsers.getMobilePhone());
		orgUsersService.updateByIdSelective(oldUser);
		oldUsersSession.getOrgUsers().setMobilePhone(orgUsers.getMobilePhone());
		session.setAttribute(SessionConstant.SESSION_USER, oldUsersSession);
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
	
	@RequestMapping(value = "/findPwdInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String findPwdInit() {
		return "security/findPwdInit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyPhone")
	public Map<String,Object> verifyPhone(HttpSession session,HttpServletRequest request,String phoneNo,String identifyCode) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersQuery query=new OrgUsersQuery();
		query.setMobilePhone(phoneNo);
		OrgUsers orgUsers = orgUsersService.queryOne(query);
		mapResult.put("code",HttpStatusCode.CODE_ERROR);
		if(orgUsers==null){
			mapResult.put("desc","手机号不存在！");
		}else{
			OrgUserActive  orgUserActive =  orgUserActiveService.queryLastByMobilePhone(phoneNo);
			if(orgUserActive==null||!orgUserActive.getVcode().equals(identifyCode)){
				mapResult.put("desc", "验证码错误!");
			}else if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 3600000){
				//验证码过期
				mapResult.put("desc", "验证码过期!");
			}else{
				mapResult.put("code",HttpStatusCode.CODE_SUCCESS);				
			}
			
		}
		return mapResult;
	}
	@ResponseBody
	@RequestMapping(value = "/updatePwd")
	public Map<String,Object> updatePwd(HttpSession session,HttpServletRequest request,String phoneNo,String password) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersQuery query=new OrgUsersQuery();
		query.setMobilePhone(phoneNo);
		OrgUsers orgUsers = orgUsersService.queryOne(query);
		//md5加密
//		String passwordMd5 = new MD5().getMD5ofStr(password);
//		orgUsers.setPassword(passwordMd5);
		orgUsers.setPassword(password);
		orgUsersService.updateByIdSelective(orgUsers);
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
	
	@RequestMapping(value="/bindNewPhone",method = {RequestMethod.GET,RequestMethod.POST})
	public String bindNewPhone(Model model,HttpSession session){
		return "security/newPhone";
	}
	
	@RequestMapping(value="/verifyOldPhone",method = {RequestMethod.GET,RequestMethod.POST})
	public String verifyOldPhone(Model model,HttpSession session){
		return "security/verifyPhone";
	}
}
