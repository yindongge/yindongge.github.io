package com.kjj.pc.web.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgShopPageImg;
import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopImgConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopPageImgService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.pc.constant.CookieConstant;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.CookieUTF8Util;
import com.kjj.pc.util.CookieUtil;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgShopPageService orgShopPageService;
	@Resource
	private OrgShopSendRangeService orgShopSendRangeService;
	@Resource
	private OrgShopPageImgService orgShopPageImgService;
	
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
	public Map<String,Object> select(Model model,HttpSession session,HttpServletRequest request, HttpServletResponse response, @PathVariable Integer shopId) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgShop shop = orgShopService.queryVoById4Session(shopId);
		orgUsersSession.setOrgShop(shop);
		CookieUtil.addCookieDefaultAge(response, CookieConstant.COOKIE_USER_SHOP, String.valueOf(shopId));
		String shopIdStr = CookieUTF8Util.getCookieValue(request, CookieConstant.COOKIE_USER_SHOP_HISTORY);
		if(null == shopIdStr || !shopIdStr.contains(shop.getShopName())){
			CookieUTF8Util.addCookieDefaultAge(response, CookieConstant.COOKIE_USER_SHOP_HISTORY, shopIdStr+":"+String.valueOf(shopId)+"-"+shop.getShopName());
		}
		session.setAttribute(SessionConstant.SESSION_USER, orgUsersSession);
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS );
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/location", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> location(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session,OrgLocation orgLocation) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		List<OrgShop> listShop = orgShopService.queryNearbyShopList(orgLocation);
		OrgShopPageImg osi = null;
		String shopIdStr = CookieUTF8Util.getCookieValue(request, CookieConstant.COOKIE_USER_SHOP_HISTORY);//在判断店铺隐藏时从cookie中移除
		for(OrgShop os : listShop){
			osi = orgShopPageImgService.queryImgByType(os.getShopId(),OrgShopImgConstant.SHOP_IMG_TYPE_ICON);
			OrgShopVo vo = (OrgShopVo) os;
			if(System.currentTimeMillis() - vo.getCreateTime().getTime()<15 * 24 * 60 * 60 * 1000){
				vo.setIsNew(true);
			}
			if(osi != null){
				vo.setImgUrl(osi.getPageImg());
			}
		}
		
		OrgShopQuery query = new OrgShopQuery();
		query.setStatus(OrgShopConstant.STATUS_HIDE);
		List<OrgShop> listHideShop = orgShopService.queryList(query);
		for(OrgShop os : listHideShop){
			if(null != shopIdStr && shopIdStr.contains(":"+os.getShopId().toString()+"-"+os.getShopName())){
				shopIdStr = shopIdStr.replace(":"+os.getShopId().toString()+"-"+os.getShopName(), "");
				CookieUTF8Util.addCookieDefaultAge(response, CookieConstant.COOKIE_USER_SHOP_HISTORY, shopIdStr);
			}
		}
		
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS );
		mapResult.put("listShop", listShop);
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value="/sendRange",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> sendRange(Model model,Integer shopId,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		List<OrgShopSendRange> sendRangeList = orgShopSendRangeService.queryListByShopId(shopId);
		map.put("sendRangeList", sendRangeList);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
}
