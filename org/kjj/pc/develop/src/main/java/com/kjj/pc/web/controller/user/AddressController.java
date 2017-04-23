package com.kjj.pc.web.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.aide.OrgUserAddressVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUserAddressService;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Resource
	private OrgUserAddressService orgUserAddressService;
	
	@Resource
	private OrgShopService orgShopService;
	
	@Resource
	private OrgShopSendRangeService orgShopSendRangeService;
	
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public Map<String,Object> add(HttpSession session,OrgUserAddress orgUserAddress) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		orgUserAddress.setUserId(user.getOrgUsers().getUserId());
		orgUserAddress.setShopId(user.getOrgShop().getShopId());
		
		if (orgUserAddressService.queryCount(orgUserAddress) > 15) {
			result.put("code", HttpStatusCode.CODE_ERROR);
		} else {
			orgUserAddressService.add(orgUserAddress);
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			//回显
			result.put("orgUserAddress",  orgUserAddressService.queryVoById(orgUserAddress.getAddressId()));
		}
		
		return result;
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model){
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		List<OrgUserAddress> listUserAddress =  orgUserAddressService.getByUser(user);
		//配送范围
		List<OrgShopSendRange> listSendRange = orgShopSendRangeService.queryListByShopId(user.getOrgShop().getShopId());
		
		model.addAttribute("listUserAddress", listUserAddress);
		model.addAttribute("listSendRange",listSendRange);
		return "address/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{addressId}", method = { RequestMethod.GET,RequestMethod.POST })
	public int delete(HttpSession session, @PathVariable Integer addressId) {
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		//校验
		if (addressId != null && orgUserAddressService.queryById(addressId).getUserId().equals(user.getOrgUsers().getUserId())) {
			orgUserAddressService.deleteById(addressId);
			return HttpStatusCode.CODE_SUCCESS;
		}else{
			return HttpStatusCode.CODE_ERROR;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/editInit/{addressId}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> editInit(HttpSession session, @PathVariable Integer addressId) {
		Map<String,Object> result = new HashMap<String,Object>();
		
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		//校验
		if (addressId != null && orgUserAddressService.queryById(addressId).getUserId().equals(user.getOrgUsers().getUserId())) {
			OrgUserAddressVo orgUserAddress = orgUserAddressService.queryVoById(addressId);
			orgUserAddress.setListSendRange(orgShopSendRangeService.queryListByShopId(orgUserAddress.getShopId()));
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			result.put("orgUserAddress", orgUserAddress);
		}else{
			result.put("code", HttpStatusCode.CODE_ERROR);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.POST })
	public Map<String,Object> edit(HttpSession session,OrgUserAddress orgUserAddress){
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		//校验
		if (orgUserAddress != null && orgUserAddress.getAddressId() > 0){
			OrgUserAddress old = orgUserAddressService.queryById(orgUserAddress.getAddressId());
		    if(old.getUserId().equals(user.getOrgUsers().getUserId())){
		    	orgUserAddress.setShopId(old.getShopId());
				orgUserAddressService.update(orgUserAddress);
				result.put("code", HttpStatusCode.CODE_SUCCESS);
				//回显
				result.put("orgUserAddress", orgUserAddressService.queryVoById(orgUserAddress.getAddressId()));
		    }else{
		    	result.put("code", HttpStatusCode.CODE_ERROR);
		    }
		} else {
			result.put("code", HttpStatusCode.CODE_ERROR);
		}
		return result;
	}
}
