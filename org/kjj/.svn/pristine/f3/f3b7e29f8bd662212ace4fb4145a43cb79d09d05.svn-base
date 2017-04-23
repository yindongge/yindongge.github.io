package com.kjj.mobile.web.controller.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgMobilePage;
import com.kjj.commserver.entity.shop.OrgMobilePageBanner;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageBannerQuery;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageConstant;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgMobilePageBannerService;
import com.kjj.commserver.service.shop.OrgMobilePageService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.BackUrlConstant;
import com.kjj.mobile.constant.CookieConstant;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.CookieUtil;
import com.kjj.mobile.util.PageReq;

@Controller
public class HomeController {

	@Resource
	private OrgShopPageService orgShopPageService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgProductItemService orgProductItemService;
	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgMobilePageBannerService orgMobilePageBannerService;
	@Resource
	private OrgMobilePageService orgMobilePageService;
	@Resource
	private OrgAreaService orgAreaService;

	@RequestMapping(value = { "/", "/wehome" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model, HttpSession session, HttpServletRequest request) {
		// 跳转页面
		session.setAttribute(SessionConstant.SESSION_BACK_URL, BackUrlConstant.URL_HOME);
		// 引导页
		String leadme = CookieUtil.getCookieValue(request, CookieConstant.COOKIE_LEAD_ME);
		if (StringUtils.isNotBlank(leadme)) {
			model.addAttribute("leadme", leadme);
		}

		// 轮播图列表操作
		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		OrgMobilePageBannerQuery query = new OrgMobilePageBannerQuery();
		// 按照店铺查询轮播图
		query.setAreaCode(orgUsersSession.getOrgShop().getAreaCode());
		query.setShopId(orgUsersSession.getOrgShop().getShopId());
		query.setStatus(OrgMobilePageConstant.STATUS);

		OrgMobilePageQuery mobilePageQuery = new OrgMobilePageQuery();
		mobilePageQuery.setAreaCode(orgUsersSession.getOrgShop().getAreaCode());
		mobilePageQuery.setShopId(orgUsersSession.getOrgShop().getShopId());
		mobilePageQuery.setStatus(OrgMobilePageConstant.STATUS);
		Long count = orgMobilePageService.queryCount(mobilePageQuery);
		if (count == 0) {// 移动店铺首页不存在
			OrgArea area = orgAreaService.queryById(orgUsersSession.getOrgShop().getAreaCode());// 店铺的区划   即是县的code
			OrgArea city = orgAreaService.queryById(area.getParentCode());// 店铺所属  市区
			mobilePageQuery.setShopId(null);

			OrgMobilePageQuery cityQuery = new OrgMobilePageQuery();
			cityQuery.setAreaCode(area.getParentCode());
			cityQuery.setShopId(null);
			cityQuery.setStatus(OrgMobilePageConstant.STATUS);

			OrgMobilePageQuery provinceQuery = new OrgMobilePageQuery();
			provinceQuery.setAreaCode(city.getParentCode());
			provinceQuery.setShopId(null);
			provinceQuery.setStatus(OrgMobilePageConstant.STATUS);

			if (null != orgMobilePageService.queryByAreaCodeShopId(mobilePageQuery)) {// 店铺的上级首页存在    县
				query.setShopId(null);
				List<OrgMobilePageBanner> bannerList = orgMobilePageBannerService.queryBannerList(query);
				model.addAttribute("bannerList", bannerList);
				return "home/index";
			} else if (null != orgMobilePageService.queryByAreaCodeShopId(cityQuery)) {// 店铺的市级首页存在    市
				query.setAreaCode(city.getCode());
				query.setShopId(null);
				List<OrgMobilePageBanner> bannerList = orgMobilePageBannerService.queryBannerList(query);
				model.addAttribute("bannerList", bannerList);
				return "home/index";
			} else if (null != orgMobilePageService.queryByAreaCodeShopId(provinceQuery)) {// 店铺的省级首页存在   省
				query.setAreaCode(city.getParentCode());
				query.setShopId(null);
				List<OrgMobilePageBanner> bannerList = orgMobilePageBannerService.queryBannerList(query);
				model.addAttribute("bannerList", bannerList);
				return "home/index";
			}
			mobilePageQuery.setAreaCode("");
			mobilePageQuery.setShopId(null);
			mobilePageQuery.setStatus(OrgMobilePageConstant.STATUS);
			OrgMobilePage page = orgMobilePageService.queryByAreaCodeShopId(mobilePageQuery);
			if (null != page) {// 全部店铺首页存在
				OrgMobilePageBannerQuery banerQuery = new OrgMobilePageBannerQuery();
				banerQuery.setPageId(page.getId());
				List<OrgMobilePageBanner> bannerList = orgMobilePageBannerService.queryBannerList(banerQuery);
				model.addAttribute("bannerList", bannerList);
				return "home/index";
			}
		}

		List<OrgMobilePageBanner> bannerList = orgMobilePageBannerService.queryBannerList(query);
		model.addAttribute("bannerList", bannerList);
		return "home/index";
	}

	@ResponseBody
	@RequestMapping(value = "/recommend", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> recommend(Model model, HttpSession session, PageReq pageReq, OrgProductItemQuery query) {
		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);

		Map<String, Object> result = new HashMap<String, Object>();
		query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		query.setIsShowZeroInventoryFlg(true);
		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		Sort sort = new Sort(Direction.DESC, "oir.id");
		pageReq.setSort(sort);
		Page<OrgProductItemAll> page = orgProductItemService.queryPageList4Recommend(orgUsersSession, query, pageReq);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("page", page);
		return result;
	}

}
