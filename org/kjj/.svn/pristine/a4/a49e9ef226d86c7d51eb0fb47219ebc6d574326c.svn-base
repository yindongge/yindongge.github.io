package com.kjj.mobile.web.controller.account;

import java.util.HashMap;
import java.util.Map;

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

import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.user.OrgUserActiveService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.MD5;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/accountDeposit")
public class AccountDepositController {
	
	@Resource
	private OrgAccountDepositService orgAccountDepositService;
	
	@Resource
	private OrgUsersService orgUsersService;
	
	@Resource
	private OrgUserActiveService orgUserActiveService;
	
	MD5 md5 = new MD5();
	
	
	@RequestMapping(value = "/center", method = { RequestMethod.GET, RequestMethod.POST })
	public String center(HttpSession session, HttpServletResponse response, Model model) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgAccountDeposit orgAccountDeposit = orgAccountDepositService.queryById(orgUsersSession.getOrgUsers().getUserId());
		if(StringUtils.isEmpty(orgAccountDeposit.getPayPassword())){
			model.addAttribute("flg",0);
		}else{
			model.addAttribute("flg",1);
		}
		model.addAttribute("orgAccountDeposit",orgAccountDeposit);			
		return "accountDeposit/center";
	}
	@RequestMapping(value = "/setPwd", method = { RequestMethod.GET, RequestMethod.POST })
	public String setPwd(HttpSession session, HttpServletResponse response, Model model) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		String phoneNo=orgUsersSession.getOrgUsers().getMobilePhone();
		if(StringUtils.isEmpty(phoneNo)){
			//手机号在session中不存在时从数据库获取（绑定手机号后，不用重新登录）
			OrgUsers orgUsers = orgUsersService.queryById(orgUsersSession.getOrgUsers().getUserId());
			phoneNo=orgUsers.getMobilePhone();
			if(StringUtils.isEmpty(phoneNo)){
				return "redirect:/security/bindMobileInit";				
			}else{
				model.addAttribute("phoneNo",phoneNo);
				return "accountDeposit/setPwd";
			}
		}
		model.addAttribute("phoneNo",phoneNo);
		return "accountDeposit/setPwd";
	}
	@RequestMapping(value = "/updatePwd", method = { RequestMethod.GET, RequestMethod.POST })
	public String updatePwd(HttpSession session, HttpServletResponse response, Model model) {
		return "accountDeposit/updatePwd";
	}
	@RequestMapping(value = "/findPwd", method = { RequestMethod.GET, RequestMethod.POST })
	public String findPwd(HttpSession session, HttpServletResponse response, Model model) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		model.addAttribute("phoneNo",orgUsersSession.getOrgUsers().getMobilePhone());
		return "accountDeposit/findPwd";
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyOldPwd")
	public Map<String,Object> verifyOldPwd(HttpSession session,HttpServletRequest request,String password) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgAccountDeposit orgAccountDeposit = orgAccountDepositService.queryById(orgUsersSession.getOrgUsers().getUserId());
		if(orgAccountDeposit.getPayPassword().equals(md5.getMD5ofStr(password))){
			mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		}else{
			mapResult.put("code",HttpStatusCode.CODE_ERROR);
			mapResult.put("desc","原密码不正确！");
		}
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyPhone")
	public Map<String,Object> verifyPhone(HttpSession session,HttpServletRequest request,String phoneNo,String identifyCode) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersQuery query=new OrgUsersQuery();
		query.setMobilePhone(phoneNo);
		mapResult.put("code",HttpStatusCode.CODE_ERROR);
		OrgUserActive  orgUserActive =  orgUserActiveService.queryLastByMobilePhone(phoneNo);
		if(orgUserActive==null||!orgUserActive.getVcode().equals(identifyCode)){
			mapResult.put("desc", "验证码错误!");
		}else if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 3600000){
			//验证码过期
			mapResult.put("desc", "验证码过期!");
		}else{
			mapResult.put("code",HttpStatusCode.CODE_SUCCESS);				
		}
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updatePwdData")
	public Map<String,Object> updatePwdData(HttpSession session,HttpServletRequest request,String password) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgAccountDeposit orgAccountDeposit = orgAccountDepositService.queryById(orgUsersSession.getOrgUsers().getUserId());
		orgAccountDeposit.setPayPassword(md5.getMD5ofStr(password));
		int flg = orgAccountDepositService.updateByIdSelective(orgAccountDeposit);
		if(flg>0){
			mapResult.put("code",HttpStatusCode.CODE_SUCCESS);			
		}
		return mapResult;
	}
}

