package com.kjj.pc.web.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.pc.constant.CookieConstant;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.CookieUtil;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgShopPageService orgShopPageService;
	
	@ResponseBody
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> list(Model model,HttpSession session) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		List<OrgShop> listShop = orgShopService.queryListAllShow();
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS );
		mapResult.put("listShop", listShop);
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/select/{shopId}", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> select(Model model,HttpSession session, HttpServletResponse response, @PathVariable Integer shopId) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgShop shop = orgShopService.queryVoById4Session(shopId);
		orgUsersSession.setOrgShop(shop);
		CookieUtil.addCookieDefaultAge(response, CookieConstant.COOKIE_USER_SHOP, String.valueOf(shopId));
		session.setAttribute(SessionConstant.SESSION_USER, orgUsersSession);
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS );
		return mapResult;
	}
}
