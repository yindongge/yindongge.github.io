package com.kjj.pc.web.controller.user;

import java.util.HashMap;
import java.util.List;
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

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.user.OrgEnterpriseInvitationService;
import com.kjj.commserver.service.user.OrgEnterpriseService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgAreaService orgAreaService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgEnterpriseService orgEnterpriseService;
	@Resource
	private OrgEnterpriseInvitationService orgEnterpriseInvitationService;
	
	
	@RequestMapping(value = "/desc", method = {RequestMethod.GET,RequestMethod.POST })
	public String desc(Model model,HttpSession session) {
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		List<OrgArea> listProvince = orgAreaService.queryListProvince();
		model.addAttribute("province", listProvince);
		//获取一级列表
		if(user.getOrgUsers().getAddressnow() !=null && !user.getOrgUsers().getAddressnow().equals("-1")){
			//获取下一级列表
			List<OrgArea> listCityNow = orgAreaService.queryListByParentCode(user.getOrgUsers().getAddressnow().substring(0, 2)+"0000");
			List<OrgArea> listAreaNow = orgAreaService.queryListByParentCode(user.getOrgUsers().getAddressnow().substring(0, 4)+"00");
			
			model.addAttribute("cityNow", listCityNow);
			model.addAttribute("areaNow", listAreaNow);
		}
		
		if(user.getOrgUsers().getAddresshome() !=null && !user.getOrgUsers().getAddresshome().equals("-1")){
			//获取下一级列表
			List<OrgArea> listCityHome = orgAreaService.queryListByParentCode(user.getOrgUsers().getAddresshome().substring(0, 2)+"0000");
			List<OrgArea> listAreaHome = orgAreaService.queryListByParentCode(user.getOrgUsers().getAddresshome().substring(0, 4)+"00");
			
			model.addAttribute("cityHome", listCityHome);
			model.addAttribute("areaHome", listAreaHome);
		}
		List<OrgClass> classType = orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("classType", classType);
		return "user/desc";
	}
		
	@ResponseBody
	@RequestMapping(value = "/edit", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> edit(HttpSession session,HttpServletRequest request,HttpServletResponse response,OrgUsers orgUsers) {
		OrgUsersSession userSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> result = new HashMap<String,Object>();
		
		if (!userSession.getOrgUsers().getUserId().equals(orgUsers.getUserId())) {
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "您没有此权限！");
			return result;
		}
		
		if (StringUtils.isBlank(orgUsers.getUserName()) || orgUsers.getUserName().length() < 4 || orgUsers.getUserName().length() > 20) {
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "用户名应为4~20个字符！");
			return result;
		}
		
		if (orgUsersService.queryByLoginName(orgUsers.getUserName()) != null && !orgUsers.getUserName().equals(userSession.getOrgUsers().getUserName())) {
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "用户名已有人使用!请换一个名称");
			return result;
		}
		
		if(StringUtils.isBlank(orgUsers.getAddressdesc()) || orgUsers.getAddressdesc().length() > 100){
			final int CODE_ERROR_ADDRESS_OVER = 402;
			result.put("code",CODE_ERROR_ADDRESS_OVER);
			result.put("desc", "用户地址长度不超过100字符长度！");
			return result;
		}
		
		//成功处理
	    String p = request.getParameter("now11");
	    String now1 = request.getParameter("now1");
	    String now = request.getParameter("now");
	    String addressnow = "";
		if (!p.equals("-1")) {
			addressnow = p;
		} else if (!now1.equals("-1")) {
			addressnow = now1;
		} else if (!now.equals("-1")) {
			addressnow = now;
		} else {
			addressnow = "-1";
		}
	    orgUsers.setAddressnow(addressnow);
	    
	    String d = request.getParameter("hom11");
	    String hom1 = request.getParameter("hom1");
	    String hom = request.getParameter("hom");
	    String addresshome = "";
		if (!d.equals("-1")) {
			addresshome = d;
		} else if (!hom1.equals("-1")) {
			addresshome = hom1;
		} else if (!hom.equals("-1")) {
			addresshome = hom;
		} else {
			addresshome = "-1";
		}
	    orgUsers.setAddresshome(addresshome);
	    orgUsersService.updateByIdSelective(orgUsers);
	    userSession.setOrgUsers(orgUsersService.queryVoById(orgUsers.getUserId()));
	    session.setAttribute(SessionConstant.SESSION_USER, userSession);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}
