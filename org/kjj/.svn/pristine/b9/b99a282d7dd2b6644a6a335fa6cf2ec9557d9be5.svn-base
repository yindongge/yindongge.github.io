package com.kjj.pc.web.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.user.OrgEnterprise;
import com.kjj.commserver.entity.user.OrgEnterpriseEasyInvitation;
import com.kjj.commserver.entity.user.OrgEnterpriseInvitation;
import com.kjj.commserver.entity.user.OrgEnterpriseUser;
import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseEasyInvitationQuery;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseInvitationConstant;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseUserVo;
import com.kjj.commserver.entity.user.aide.OrgUserActiveQuery;
import com.kjj.commserver.entity.user.aide.OrgUserLevelConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.user.OrgEnterpriseEasyInvitationService;
import com.kjj.commserver.service.user.OrgEnterpriseInvitationService;
import com.kjj.commserver.service.user.OrgEnterpriseService;
import com.kjj.commserver.service.user.OrgEnterpriseUserService;
import com.kjj.commserver.service.user.OrgUserActiveService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/security")
public class SecurityController {
	
	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgAreaService orgAreaService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgUserActiveService orgUserActiveService;
	@Resource
	private OrgEnterpriseService orgEnterpriseService;
	@Resource
	private OrgEnterpriseInvitationService orgEnterpriseInvitationService;
	@Resource
	private OrgAccountDepositService orgAccountDepositService;
	@Resource
	private OrgEnterpriseUserService orgEnterpriseUserService;
	@Resource
	private OrgEnterpriseEasyInvitationService orgEnterpriseEasyInvitationService;
		
	@RequestMapping(value = "/desc", method = {RequestMethod.GET,RequestMethod.POST })
	public String security(Model model,HttpSession session, String log_detail) {
		OrgUsersSession userSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		OrgEnterprise enterprise = null;
		// 如果用户类型是企业
		if(userSession.getOrgUsers().getLevelType().equals(OrgUserLevelConstant.LEVEL_TYPE_ENTERPRISE)){
			enterprise = orgEnterpriseService.queryByUserId(userSession.getOrgUsers().getUserId());
			model.addAttribute("enterprise", enterprise);
		} else {
			model.addAttribute("enterprise", new OrgEnterprise());
		}
		
		OrgAccountDeposit accountDeposit = orgAccountDepositService.queryById(userSession.getOrgUsers().getUserId());
		model.addAttribute("accountDeposit",accountDeposit);
		
		if(null != enterprise) {
			// 统一邀请码
			OrgEnterpriseEasyInvitationQuery query = new OrgEnterpriseEasyInvitationQuery();
			query.setEnterpriseId(enterprise.getEnterpriseId());
			List<OrgEnterpriseEasyInvitation> invitationList = orgEnterpriseEasyInvitationService.queryList(query);
			
			if(invitationList.size() > 0){
				OrgEnterpriseEasyInvitation easyInvitation = invitationList.get(invitationList.size() - 1);
				
				model.addAttribute("easyInvitation", easyInvitation);
				
				Date today = new Date();
				if(today.getTime() >= easyInvitation.getStartTime().getTime() && today.getTime() <= easyInvitation.getEndTime().getTime() && easyInvitation.getRest().intValue() > 0){
					model.addAttribute("easyInvitationStatus", "有效");
				} else {
					model.addAttribute("easyInvitationStatus", "无效");
				}
			}
			
		}
		
		
		return "security/desc";
	}
	
	@RequestMapping(value = "/findPasswordInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String findPasswordInit() {
		return "password/find";
	}
	
	@ResponseBody
	@RequestMapping(value = "/findPassword")
	public Map<String,Object> findPassword(HttpSession session,HttpServletRequest request,OrgUsers orgUsers,String verifycode) {
		
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
		
		OrgUsers userOld = orgUsersService.queryByLoginName(orgUsers.getMobilePhone());
		if(userOld == null){
			mapResult.put("code",HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "该用户不存在!");
			return mapResult;
		}
		//修改密码
		orgUsers.setUserId(userOld.getUserId());
		orgUsersService.updateByIdSelective(orgUsers);
		//用户登录
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/editPassword", method = {RequestMethod.GET,RequestMethod.POST })
	public Boolean editPassword(Model model,HttpSession session, HttpServletResponse response,String oldPassword,OrgUsers orgUsers) {
		OrgUsersSession userSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Boolean flg=true;
		if (!userSession.getOrgUsers().getPassword().equals(oldPassword)
				|| !userSession.getOrgUsers().getUserId().equals(orgUsers.getUserId())){
			flg=false;
		}
		return flg; 
	}
	
	@ResponseBody
	@RequestMapping(value = "/editUserName", method = {RequestMethod.GET,RequestMethod.POST })
	public Boolean editUserName(HttpSession session,HttpServletResponse response,OrgUsers orgUsers){
		
		OrgUsersSession  userSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Boolean flg=true;
		//用户名唯一性验证
		if(StringUtils.isBlank(orgUsers.getUserName()) 
				|| (orgUsersService.queryByLoginName(orgUsers.getUserName()) != null &&
				!orgUsers.getUserName().equals(userSession.getOrgUsers().getUserName()))
				|| !userSession.getOrgUsers().getUserId().equals(orgUsers.getUserId())){
			flg=false;
		}
		return flg;
	}
	
	@RequestMapping(value = "/updatePassword", method = {RequestMethod.GET,RequestMethod.POST })
	public String updatePassword(Model model,HttpSession session, String log_detail) {
		return "security/updatePassword";
	}
	
	@RequestMapping(value = "/updateUserName", method = {RequestMethod.GET,RequestMethod.POST })
	public String updateUserName(Model model,HttpSession session, String log_detail) {
		return "security/updateUserName";
	}
	
	@RequestMapping(value = "/bindPhone", method = {RequestMethod.GET,RequestMethod.POST })
	public String bindPhone(Model model,HttpSession session, String log_detail) {
		return "security/bindPhone";
	}
	
	@RequestMapping(value="/verifyOldPhone",method = {RequestMethod.GET,RequestMethod.POST})
	public String verifyOldPhone(Model model,HttpSession session){
		return "security/verifyOldPhone";
	}

	@ResponseBody
	@RequestMapping(value = "/verifyPhoneCode", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> verifyOldPhone(HttpSession session,String verifycode,String mobilePhone){
		Map<String,Object> map = new HashMap<String,Object>();
		OrgUserActiveQuery query =new OrgUserActiveQuery();
		query.setPhone(mobilePhone);
		query.setVcode(verifycode);
		OrgUserActive orgUserActive = orgUserActiveService.queryOne(query);
		if(orgUserActive==null){
			map.put("code", HttpStatusCode.CODE_ERROR);
			map.put("desc", "验证码不存在");
			return map;
		}else{
			if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 1800000){
				map.put("code", HttpStatusCode.CODE_ERROR);
				map.put("desc", "验证码已过期");
				return map;
			}
		}
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
	
	@RequestMapping(value="/bindNewMobilePhone", method = {RequestMethod.GET,RequestMethod.POST })
	public String bindNewPhone(Model model,HttpSession session){
		return "security/bindNewPhone";
	}
	
	@RequestMapping(value = "/updateUserNameData", method = {RequestMethod.GET,RequestMethod.POST })
	public String updateUserNameData(Model model,HttpSession session,OrgUsers orgUsers, String log_detail) {
		OrgUsersSession  userSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgUsersService.updateByIdSelective(orgUsers);
		userSession.getOrgUsers().setUserName(orgUsers.getUserName());
		session.setAttribute(SessionConstant.SESSION_USER, userSession);
		return "redirect:/security/desc";
	}
	@RequestMapping(value = "/updatePasswordData", method = {RequestMethod.GET,RequestMethod.POST })
	public String updatePasswordData(Model model,HttpSession session,OrgUsers orgUsers, String log_detail) {
		OrgUsersSession  userSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgUsersService.updateByIdSelective(orgUsers);
		userSession.getOrgUsers().setPassword(orgUsers.getPassword());
		session.setAttribute(SessionConstant.SESSION_USER, userSession);
		return "redirect:/security/desc";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bindPhoneData", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> bindPhoneData(Model model,HttpSession session,OrgUsers orgUsers,String verifycode,String log_detail) {
		OrgUsersSession  userSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		OrgUserActiveQuery query = new OrgUserActiveQuery();
		query.setPhone(orgUsers.getMobilePhone());
		query.setVcode(verifycode);
		OrgUserActive orgUserActive = orgUserActiveService.queryOne(query);
		if (orgUserActive == null) {
				 map.put("code", HttpStatusCode.CODE_ERROR);
				 map.put("desc", "验证码错误");
				 return map;
		} else {
			if (System.currentTimeMillis()- orgUserActive.getCreatetime().getTime() > 1800000) {
				map.put("code", HttpStatusCode.CODE_ERROR);
				map.put("desc", "验证码已过期");
				return map;
			}
		}
		
		final int CODE = 401;
		OrgUsers users = orgUsersService.queryByLoginName(orgUsers.getMobilePhone());
		if(null != users){
			map.put("code", CODE);
			map.put("desc", "该手机已被注册");
			return map;
		}
		
		orgUsersService.updateByIdSelective(orgUsers);
		userSession.getOrgUsers().setMobilePhone(orgUsers.getMobilePhone());
		session.setAttribute(SessionConstant.SESSION_USER, userSession);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyPhone", method = {RequestMethod.GET,RequestMethod.POST })
	public Boolean verifyPhone(HttpSession session,HttpServletResponse response,OrgUsersQuery query){
		Boolean flg=true;
		long count = orgUsersService.queryCount(query);
		if(count!=0l){
			flg=false;
		}
		return flg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyCode", method = {RequestMethod.GET,RequestMethod.POST })
	public Boolean verifyCode(HttpSession session,String verifycode,String mobilePhone){
		Boolean flg=true;
		OrgUserActiveQuery query =new OrgUserActiveQuery();
		query.setPhone(mobilePhone);
		query.setVcode(verifycode);
		OrgUserActive orgUserActive = orgUserActiveService.queryOne(query);
		if(orgUserActive==null){
			flg=false;
		}else{
			if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 1800000){
				flg=false;
			}
		}
		return flg;
	}
	
	/**
	 * 获取企业的邀请码
	 * @param session
	 * @param response
	 * @param enterpriseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/showInvitation", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> showInvitation(HttpSession session,HttpServletResponse response,Integer enterpriseId){
		Map<String, Object> result = new HashMap<String, Object>();	

		OrgEnterpriseInvitation query = new OrgEnterpriseInvitation();
		query.setEnterpriseId(enterpriseId);
		query.setStatus(OrgEnterpriseInvitationConstant.INVITATION_STATUS_NO_USE); // 未被使用的
		
		List<OrgEnterpriseInvitation> invitationList = orgEnterpriseInvitationService.queryList(query);
		
		query.setStatus(OrgEnterpriseInvitationConstant.INVITATION_STATUS_USEED); // 已经使用的
		
		StringBuffer sb = new StringBuffer();
		for(OrgEnterpriseInvitation code : invitationList){
			sb.append(code.getInvitationCode()).append(",");
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length()-1);
		}
		result.put("codeItems", sb.toString());
		result.put("useNums", orgEnterpriseInvitationService.queryCount(query));
		result.put("no_useNums", invitationList.size());
		
		
		return result;
	}
	
	/**
	 * 生成50个企业邀请码
	 * @param session
	 * @param response
	 * @param enterpriseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/createInvitation", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> createInvitation(HttpSession session,HttpServletResponse response,Integer enterpriseId){
		Map<String, Object> result = new HashMap<String, Object>();	

		orgEnterpriseInvitationService.addInvitationOfEnterprise(enterpriseId);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		
		return result;
	}
	
	/**
	 * 准备使用企业邀请码
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/preUseInvitationCode", method = {RequestMethod.GET,RequestMethod.POST })
	public String preUseInvitationCode(Model model,HttpSession session) {
		
		return "security/useInvitation";
	}
	
	@ResponseBody
	@RequestMapping(value = "/useInvitation", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> useInvitation(HttpSession session,HttpServletResponse response,String realName, String invitationCode){
		Map<String, Object> result = new HashMap<String, Object>();	
		
		OrgUsersSession  userSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		// 更改用户会员信息
		OrgUsers users = userSession.getOrgUsers();
		if(StringUtils.isNotBlank(realName)){
			users.setRealname(realName);
		}
		
		
		if(StringUtils.isBlank(invitationCode) || !orgEnterpriseInvitationService.updateInvitation(invitationCode, users)){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		
		// 重置会话内用户信息
		userSession.setOrgUsers(orgUsersService.queryVoById(users.getUserId()));
	    session.setAttribute(SessionConstant.SESSION_USER, userSession);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value = "/bindEmail", method = {RequestMethod.GET,RequestMethod.POST })
	public String bindEmail(Model model,HttpSession session, String log_detail) {
		return "security/bindEmail";
	}
	
	/*校验输入的验证码是否存在和过期*/
	@ResponseBody
	@RequestMapping(value = "/verifyEmailCode", method = {RequestMethod.GET,RequestMethod.POST })
	public Boolean verifyEmailCode(HttpSession session,String verifycode,String email){
		Boolean flg=true;
		OrgUserActiveQuery query = new OrgUserActiveQuery();
		query.setEmail(email);
		query.setVcode(verifycode);
		OrgUserActive orgUserActive = orgUserActiveService.queryOne(query);
		if(orgUserActive==null){
			flg=false;
		}else{
			if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 1800000){
				flg=false;
			}
		}
		return flg;
	}
	
	/*验证email是否被绑定*/
	@ResponseBody
	@RequestMapping(value = "/verifyEmail", method = {RequestMethod.GET,RequestMethod.POST })
	public Boolean verifyEmail(HttpSession session,HttpServletResponse response,OrgUsersQuery query){
		Boolean flg=true;
		long count = orgUsersService.queryCount(query);
		if(count!=0l){
			flg=false;
		}
		return flg;
	}
	
	/*发送邮件验证码*/
	@ResponseBody
	@RequestMapping(value = "/sendEmailCode", method = {RequestMethod.GET,RequestMethod.POST })
	public int sendEmailCode(HttpSession session,String email){
		OrgUsersSession  userSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		if(null == userSession.getOrgUsers()){
		if(null != orgUsersService.queryByLoginName(email)){
			orgUserActiveService.addBindCodeByEmai(email,orgUsersService.queryByLoginName(email).getUserName());
		}else{
			orgUserActiveService.addBindCodeByEmai(email,"");
		}
		return HttpStatusCode.CODE_SUCCESS;
		}
		String orgUsersName = userSession.getOrgUsers().getUserName();
		orgUserActiveService.addBindCodeByEmai(email,orgUsersName);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	/*绑定邮箱*/
	@ResponseBody
	@RequestMapping(value = "/bindEmailData", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> bindEmailData(Model model,HttpSession session,OrgUsers orgUsers,String verifycode, String log_detail) {
		OrgUsersSession  userSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		OrgUserActiveQuery query = new OrgUserActiveQuery();
		query.setEmail(orgUsers.getEmail());
		query.setVcode(verifycode);
		OrgUserActive orgUserActive = orgUserActiveService.queryOne(query);
		if(orgUserActive==null){
				map.put("code",HttpStatusCode.CODE_ERROR);
				map.put("desc", "验证码错误");
				return map;
		}else{
			if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 1800000){
				map.put("code",HttpStatusCode.CODE_ERROR);
				map.put("desc", "验证码已过期");
				return map;
			}
		}
		
		final int CODE = 401;
		if(null != orgUsersService.queryByLoginName(orgUsers.getEmail())){
			map.put("code", CODE);
			map.put("desc", "该邮箱已被绑定");
			return map;
		}
		
		orgUsersService.updateByIdSelective(orgUsers);
		userSession.getOrgUsers().setEmail(orgUsers.getEmail());//重定向到desc页面的时候放新的邮箱
		session.setAttribute(SessionConstant.SESSION_USER, userSession);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
	
	@RequestMapping(value="/verifyOldEmail",method = {RequestMethod.GET,RequestMethod.POST})
	public String verifyMail(Model model,HttpSession session, String log_detail){
		return "security/verifyOldEmail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyEmailData", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> verifyEmailData(HttpSession session,String verifycode,String email){
		Map<String,Object> map = new HashMap<String,Object>();
		OrgUserActiveQuery query = new OrgUserActiveQuery();
		query.setEmail(email);
		query.setVcode(verifycode);
		OrgUserActive orgUserActive = orgUserActiveService.queryOne(query);
		if(orgUserActive==null){
			map.put("code", HttpStatusCode.CODE_ERROR);
			map.put("desc","验证码错误");
			return map;
		}else{
			if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 1800000){
				map.put("code", HttpStatusCode.CODE_ERROR);
				map.put("desc","验证码过期");
				return map;
			}
		}
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
	
	@RequestMapping(value = "/bindNewEmail", method = {RequestMethod.GET,RequestMethod.POST })
	public String bindNewEmail(HttpSession session,Model model,String log_detail){
		return "security/bindNewEmail";
	}
	 
	@ResponseBody
	@RequestMapping(value = "/verifyEmailOrPhone", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> verifyEmailOrPhone(HttpSession session,String verifycode,String mobileOrEmail){
		Map<String,Object> map = new HashMap<String,Object>();
		OrgUserActiveQuery query = new OrgUserActiveQuery();
		OrgUsers userOld =null;
		if(mobileOrEmail.contains("@")){
			query.setEmail(mobileOrEmail);
		    userOld = orgUsersService.queryByLoginName(mobileOrEmail);
			if(userOld == null){
				final int  CODE_ERROR_NOUSER=410;
				map.put("code",CODE_ERROR_NOUSER);
				map.put("desc", "该用户不存在!");
				return map;
			}
		}else{
			query.setPhone(mobileOrEmail);
			userOld = orgUsersService.queryByLoginName(mobileOrEmail);
			if(userOld == null){
				final  int  CODE_ERROR_NOUSER=410;
				map.put("code",CODE_ERROR_NOUSER);
				map.put("desc", "该用户不存在!");
				return map;
			}
		}
		query.setVcode(verifycode);
		OrgUserActive orgUserActive = orgUserActiveService.queryOne(query);
		if(orgUserActive == null){
			map.put("code", HttpStatusCode.CODE_ERROR);
			map.put("desc", "验证码错误");
			return map;
		}else{
			if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 1800000){
				map.put("code", HttpStatusCode.CODE_ERROR);
				map.put("desc", "验证码过期");
				return map;
			}
		}
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		session.setAttribute(SessionConstant.SESSION_USER_ID, userOld.getUserId());
		return map;
	}
	
	@RequestMapping(value = "/verifySuccess", method = {RequestMethod.GET,RequestMethod.POST })
	public String setNewPassword(HttpSession session,Model model,HttpServletRequest request, String log_detail){
		return "password/setNewPassword";
	}
	
	@ResponseBody
	@RequestMapping(value = "/resetPassword", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> setNewPassword(HttpSession session,OrgUsers orgUsers,String mobileOrEmail){
		Map<String, Object> map = new HashMap<String,Object>();
		 Integer userId = (Integer) session.getAttribute(SessionConstant.SESSION_USER_ID);
		//修改密码
		orgUsers.setUserId(userId);
		orgUsersService.updateByIdSelective(orgUsers);
		map.put("code",HttpStatusCode.CODE_SUCCESS);
		return map;
	}
	
	/**
	 * 企业关联会员列表-维护(解除关联、修改姓名)
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/enterpriseUserList", method = { RequestMethod.GET,RequestMethod.POST })
	public String enterpriseUserList(HttpSession session,Model model,PageReq pageReq,OrgEnterpriseUser query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.id"));
		if(50 > pageReq.getPageSize()) {
			pageReq.setPageSize(50);
		}
		model.addAttribute("enterpriseId",query.getEnterpriseId());
		
		
		Page<OrgEnterpriseUserVo> page = orgEnterpriseUserService.queryPageList(query, pageReq);
		model.addAttribute("page",page);
		
		return "security/enterpriseUserList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/changeRealName", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> changeRealName(OrgEnterpriseUser entity){
		Map<String, Object> map = new HashMap<String,Object>();
		orgEnterpriseUserService.updateByIdSelective(entity);
		map.put("code",HttpStatusCode.CODE_SUCCESS);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteUserOfEnterprise", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> deleteUserOfEnterprise(Integer id){
		Map<String, Object> map = new HashMap<String,Object>();
		
		orgEnterpriseUserService.deleteById(id);
		
		map.put("code",HttpStatusCode.CODE_SUCCESS);
		return map;
	}
}


