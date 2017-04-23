package com.kjj.touch.web.controller.home;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgShopPage;
import com.kjj.commserver.entity.shop.OrgShopPageFloor;
import com.kjj.commserver.entity.shop.OrgTouchPage;
import com.kjj.commserver.entity.shop.OrgTouchPageBanner;
import com.kjj.commserver.entity.shop.aide.OrgShopPageConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopPageQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageBannerQuery;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageConstant;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgShopPageFloorService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.shop.OrgTouchPageBannerService;
import com.kjj.commserver.service.shop.OrgTouchPageService;
import com.kjj.touch.constant.SessionConstant;
import com.kjj.touch.util.CookieUTF8Util;

@Controller
public class HomeController {

	@Resource
	private OrgShopService orgShopService;
	
	@Resource
	private OrgShopPageService orgShopPageService;
	
	@Resource
	private OrgShopPageFloorService orgShopPageFloorService;
	
	@Resource
	private OrgTouchPageService orgTouchPageService; 
	
	@Resource
	private OrgAreaService orgAreaService; 
	
	@Resource
	private OrgTouchPageBannerService orgTouchPageBannerService;

	@RequestMapping(value = { "/", "/home" })
	public String index(Model model, HttpServletRequest request, HttpSession session, @RequestParam(value = "shopId", defaultValue = "3") String shopId) {

		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);

		// 从cookie取门店id
		String shopCookie = CookieUTF8Util.getCookieValue(request, "shop");
		if (null != shopCookie) {
			shopId = shopCookie;
		}
		Integer shopIdInt = Integer.parseInt(shopId);
		// 获得当前店铺
		OrgShop orgShop = orgShopService.queryVoById(shopIdInt);
		model.addAttribute("shop", orgShop);
		
		// 获得当前店铺首页列表
		OrgShopPageQuery orgShopPageQuery = new OrgShopPageQuery();
		orgShopPageQuery.setShopId(shopIdInt);
		orgShopPageQuery.setIsactive(OrgShopPageConstant.STATUS_ACTIVE);
		List<OrgShopPage> orgShopPageList = orgShopPageService.queryList(orgShopPageQuery);
		// 获得第一个可用的店铺首页
		Integer pageId = null;
		OrgShopPage osp = null;
		if (CollectionUtils.isNotEmpty(orgShopPageList)) {
			osp = orgShopPageList.get(0);
			pageId = orgShopPageList.get(0).getId();
		} else {
			// 使用默认页面
			String areacode = StringUtils.substring(orgShop.getAreaCode(), 0, 4) + "00";
			orgShopPageQuery.setShopId(Integer.parseInt(areacode));
			osp = orgShopPageService.queryOne(orgShopPageQuery);
			pageId = osp.getId();
		}
		if(null == orgUsersSession){
			orgUsersSession = new OrgUsersSession(OrgUsersConstant.SOURCE_PC);
			orgUsersSession.setOrgShop(orgShop);
			request.getSession().setAttribute(SessionConstant.SESSION_USER, orgUsersSession);
		}
		((OrgShopVo)(orgUsersSession.getOrgShop())).setShopSearch(osp == null ? null : osp.getShopSearch());
		
		OrgShopPageFloorQuery orgShopPageFloorQuery = new OrgShopPageFloorQuery();
		orgShopPageFloorQuery.setPageid(pageId);
		List<OrgShopPageFloor> floorList = orgShopPageFloorService.queryList(orgShopPageFloorQuery);
		// 向floorlist里面增加商品列表
		floorList = orgShopPageFloorService.addCommonProductList(orgUsersSession, floorList);
		model.addAttribute("floorList", floorList);

		// 轮播图列表操作
		OrgTouchPageBannerQuery query = new OrgTouchPageBannerQuery();
		// 按照店铺查询轮播图
		query.setAreaCode(orgShop.getAreaCode());
		query.setShopId(orgShop.getShopId());
		query.setStatus(OrgTouchPageConstant.STATUS);

		OrgTouchPageQuery touchPageQuery = new OrgTouchPageQuery();
		touchPageQuery.setAreaCode(orgUsersSession.getOrgShop().getAreaCode());
		touchPageQuery.setShopId(orgUsersSession.getOrgShop().getShopId());
		touchPageQuery.setStatus(OrgTouchPageConstant.STATUS);
		Long count = orgTouchPageService.queryCount(touchPageQuery);
		if (count == 0) {// 移动店铺首页不存在
			OrgArea area = orgAreaService.queryById(orgUsersSession.getOrgShop().getAreaCode());// 店铺的区划  即是县的code
			OrgArea city = orgAreaService.queryById(area.getParentCode());// 店铺所属  市区
			touchPageQuery.setShopId(null);

			OrgTouchPageQuery cityQuery = new OrgTouchPageQuery();
			cityQuery.setAreaCode(area.getParentCode());
			cityQuery.setShopId(null);
			cityQuery.setStatus(OrgTouchPageConstant.STATUS);

			OrgTouchPageQuery provinceQuery = new OrgTouchPageQuery();
			provinceQuery.setAreaCode(city.getParentCode());
			provinceQuery.setShopId(null);
			provinceQuery.setStatus(OrgTouchPageConstant.STATUS);

			if (null != orgTouchPageService.queryByAreaCodeShopId(touchPageQuery)) {// 店铺的上级首页存在  县
				query.setShopId(null);
				List<OrgTouchPageBanner> bannerList = orgTouchPageBannerService.queryBannerList(query);
				model.addAttribute("bannerList", bannerList);
				return "home/index";
			} else if (null != orgTouchPageService.queryByAreaCodeShopId(cityQuery)) {// 店铺的市级首页存在  市
				query.setAreaCode(city.getCode());
				query.setShopId(null);
				List<OrgTouchPageBanner> bannerList = orgTouchPageBannerService.queryBannerList(query);
				model.addAttribute("bannerList", bannerList);
				return "home/index";
			} else if (null != orgTouchPageService.queryByAreaCodeShopId(provinceQuery)) {// 店铺的省级首页存在 省
				query.setAreaCode(city.getParentCode());
				query.setShopId(null);
				List<OrgTouchPageBanner> bannerList = orgTouchPageBannerService.queryBannerList(query);
				model.addAttribute("bannerList", bannerList);
				return "home/index";
			}
			touchPageQuery.setAreaCode("");
			touchPageQuery.setShopId(null);
			touchPageQuery.setStatus(OrgTouchPageConstant.STATUS);
			OrgTouchPage page = orgTouchPageService.queryByAreaCodeShopId(touchPageQuery);
			if (null != page) {// 全部店铺首页存在
				OrgTouchPageBannerQuery banerQuery = new OrgTouchPageBannerQuery();
				banerQuery.setPageId(page.getId());
				List<OrgTouchPageBanner> bannerList = orgTouchPageBannerService.queryBannerList(banerQuery);
				model.addAttribute("bannerList", bannerList);
				return "home/index";
			}
		}

		List<OrgTouchPageBanner> bannerList = orgTouchPageBannerService.queryBannerList(query);
		model.addAttribute("bannerList", bannerList);

		return "/home/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getShopList", method = { RequestMethod.GET,RequestMethod.POST })
	public List<OrgShop> getShopList(){
		List<OrgShop> shopList = orgShopService.queryList(new OrgShopQuery());
		return shopList;
	}
	

	
	@RequestMapping(value = "/member", method = { RequestMethod.GET,RequestMethod.POST })
	public String member(Model model, HttpServletRequest request){
		//从cookie取门店id
		String shopId = "";
		String shopCookie = CookieUTF8Util.getCookieValue(request, "shop");
		if(null != shopCookie){
			shopId = shopCookie;
			OrgShop orgShop = orgShopService.queryVoById(Integer.parseInt(shopId));
			model.addAttribute("shop", orgShop);
		}
		
		return "member";
	}
	
	@RequestMapping(value = "/newbieHelp", method = { RequestMethod.GET,RequestMethod.POST })
	public String newbieHelp(Model model, HttpServletRequest request){
		String shopId = "";
		String shopCookie = CookieUTF8Util.getCookieValue(request, "shop");
		if(null != shopCookie){
			shopId = shopCookie;
			OrgShop orgShop = orgShopService.queryVoById(Integer.parseInt(shopId));
			model.addAttribute("shop", orgShop);
		}
		return "newbieHelp";
	}
}
