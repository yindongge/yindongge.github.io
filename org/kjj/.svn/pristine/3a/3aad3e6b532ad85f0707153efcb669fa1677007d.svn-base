package com.kjj.mobile.web.controller.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.aide.OrgUserAddressQuery;
import com.kjj.commserver.entity.user.aide.OrgUserAddressVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUserAddressService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.BackUrlConstant;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Resource
	private OrgUserAddressService orgUserAddressService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgShopSendRangeService orgShopSendRangeService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session,OrgUserAddressQuery query) {
		OrgUsersSession usersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		List<OrgUserAddress> listAddressVaild = orgUserAddressService.getListVaildByUser(usersSession);
		List<OrgUserAddress> listAddressInvaild = orgUserAddressService.getListInvaildByUser(usersSession);
		model.addAttribute("listAddressVaild", listAddressVaild);
		model.addAttribute("listAddressInvaild", listAddressInvaild);
		return "address/list";
	}
	
	@RequestMapping(value = "/selectSend/{addressId}", method = {RequestMethod.GET,RequestMethod.POST })
	public String selectSend(Model model,HttpSession session,@PathVariable Integer addressId) {
		OrgUsersSession orgUsersSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		String backUrl = (String)session.getAttribute(SessionConstant.SESSION_BACK_URL);
		OrgUserAddress orgUserAddress = orgUserAddressService.queryVoById(addressId);
		orgUsersService.updateUserAddress4Send(orgUsersSession, orgUserAddress);
		session.setAttribute(SessionConstant.SESSION_USER, orgUsersSession);
		if(StringUtils.isNotBlank(backUrl) && !"/address/list".equals(backUrl)){
			return "redirect:"+backUrl;
		}else{
			return "redirect:"+BackUrlConstant.URL_HOME;
		}
	}
	
	@RequestMapping(value = "/addOrEditInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addOrEditInit(Model model,HttpSession session,OrgUserAddressVo orgUserAddress) {
		if(orgUserAddress.getAddressId() != null){
			//编辑
			orgUserAddress = orgUserAddressService.queryVoById(orgUserAddress.getAddressId());
		}
		model.addAttribute("userAddress",orgUserAddress);
		return "address/addOrEdit";
	}
	
	@RequestMapping(value = "/addOrEditReinit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addOrEditReinit(Model model,HttpSession session,OrgUserAddressVo orgUserAddress) {
		model.addAttribute("userAddress",orgUserAddress);
		return "address/addOrEdit";
	}
	
	@RequestMapping(value = "/addOrEdit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addOrEdit(Model model,HttpSession session,OrgUserAddress orgUserAddress) {
		OrgUsersSession orgUsersSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		String backUrl = (String)session.getAttribute(SessionConstant.SESSION_BACK_URL);
		String tel = orgUserAddress.getTel();
		tel=StringUtils.trimToEmpty(tel);
		orgUserAddress.setTel(tel);
		if(orgUserAddress.getAddressId() == null){
			orgUserAddress.setUserId(orgUsersSession.getOrgUsers().getUserId());
			orgUserAddress.setShopId(orgShopSendRangeService.queryById(orgUserAddress.getSendRangeId()).getShopId());
			orgUserAddressService.add(orgUserAddress);
		}else{
			orgUserAddress.setShopId(orgShopSendRangeService.queryById(orgUserAddress.getSendRangeId()).getShopId());
			orgUserAddressService.update(orgUserAddress);
		}
		//修改默认送货地址
		orgUsersService.updateUserAddress4Send(orgUsersSession, orgUserAddressService.queryVoById(orgUserAddress.getAddressId()));
		session.setAttribute(SessionConstant.SESSION_USER, orgUsersSession);
		if(StringUtils.isNotBlank(backUrl)){
			return "redirect:"+backUrl;
		}else{
			return "redirect:"+BackUrlConstant.URL_HOME;
		}
	}
}
