package com.kjj.mobile.web.controller.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.BackUrlConstant;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgUsersService orgUsersService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session) {
		OrgLocation orgLocation = (OrgLocation)session.getAttribute(SessionConstant.SESSION_LOCATION);
		List<OrgShop> listShop = orgShopService.queryNearbyShopList(orgLocation);
		Map<String,List<OrgShop>> mapCounty = orgShopService.getCountyGroupByShopList(listShop);
		model.addAttribute("mapCounty", mapCounty);
		if(CollectionUtils.isNotEmpty(listShop)){
			model.addAttribute("nearbyShop", listShop.get(0));
		}
		return "shop/list";
	}
	
	@RequestMapping(value = "/selectTake/{shopId}", method = {RequestMethod.GET,RequestMethod.POST })
	public String selectTake(Model model,HttpSession session,@PathVariable Integer shopId) {
		OrgUsersSession orgUsersSession = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		String backUrl = (String)session.getAttribute(SessionConstant.SESSION_BACK_URL);
		OrgShop orgShop = orgShopService.queryVoById(shopId);
		orgUsersService.updateUserShop4Take(orgUsersSession, orgShop);
		session.setAttribute(SessionConstant.SESSION_USER, orgUsersSession);
		if(StringUtils.isNotBlank(backUrl) && !"/address/list".equals(backUrl)){
			return "redirect:"+backUrl;
		}else{
			return "redirect:"+BackUrlConstant.URL_HOME;
		}
	}
	
	@RequestMapping(value = "/detail", method = {RequestMethod.GET,RequestMethod.POST })
	public String detail(Model model,HttpSession session,Integer shopId,String distance) {
		OrgShop shop = orgShopService.queryById(shopId);
		model.addAttribute("shop", shop);
		model.addAttribute("distance", distance);
		return "shop/detail";
	}
}
