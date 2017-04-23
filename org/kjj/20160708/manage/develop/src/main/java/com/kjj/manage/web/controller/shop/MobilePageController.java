package com.kjj.manage.web.controller.shop;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgMobilePage;
import com.kjj.commserver.entity.shop.OrgMobilePageBanner;
import com.kjj.commserver.entity.shop.OrgMobilePageModule;
import com.kjj.commserver.entity.shop.OrgMobilePageModuleGoods;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageBannerForm;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageModuleGoodsQuery;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageModuleVo;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopQuery;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgMobilePageBannerService;
import com.kjj.commserver.service.shop.OrgMobilePageModuleGoodsService;
import com.kjj.commserver.service.shop.OrgMobilePageModuleService;
import com.kjj.commserver.service.shop.OrgMobilePageService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.util.UUIDUtils;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/mobilePage")
public class MobilePageController {

	@Resource
	private OrgMobilePageService orgMobilePageService;
	@Resource
	private OrgAreaService orgAreaService;
	@Resource
	private OrgMobilePageBannerService orgMobilePageBannerService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgMobilePageModuleService orgMobilePageModuleService;
	@Resource
	private OrgMobilePageModuleGoodsService orgMobilePageModuleGoodsService;
	@Resource
	private OrgProductItemService orgProductItemService;
	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgBrandService orgBrandService;

	/**
	 * 移动店铺首页列表
	 * 
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String pageList(Model model, PageReq pageReq, OrgMobilePageQuery query) {
		pageReq.setPageSize(10);
		if (!"".equals(query.getShopNameLike()) && null != query.getShopNameLike()) {
			OrgShopQuery shopQuery = new OrgShopQuery();
			shopQuery.setCodeOrNameLike(query.getShopNameLike());
			List<OrgShop> shopList = orgShopService.queryList(shopQuery);
			if (shopList.size() == 0) {
				query.setFlag("flag");
			}
		}
		// 区域搜索条件
		Page<OrgMobilePage> page = orgMobilePageService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);// 保留查询条件

		return "mobilePage/mobilePageList";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String addMobilePage(Model model) {
		// 获得省
		List<OrgArea> listProvince = orgAreaService.queryListProvince();
		model.addAttribute("listProvince", listProvince);
		return "mobilePage/mobilePageAdd";
	}

	@RequestMapping(value = "/saveMobilePage", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveMobilePage(Model model, OrgMobilePage orgMobilePage, PageReq pageReq) {
		orgMobilePageService.addMobilePage(orgMobilePage);
		OrgMobilePage page = orgMobilePageService.queryOne(orgMobilePage);
		model.addAttribute("page", page);
		return "redirect:/mobilePage/updateMobilePage?id=" + page.getId();
	}

	/**
	 * 验证移动店铺首页是否唯一
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pageIsOnly", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> pageIsOnly(OrgMobilePageQuery query, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer pageId = null;
		if (null != query.getId()) {// 修改时处理
			pageId = query.getId();
		}

		List<OrgMobilePage> list = orgMobilePageService.queryList(query);
		// 新建时有重复记录
		if (null == pageId && list.size() > 0) {
			map.put("code", HttpStatusCode.CODE_ERROR);
			return map;
		}

		// 修改时有重复记录
		if (null != pageId) {
			if (list.size() > 1) {
				map.put("code", HttpStatusCode.CODE_ERROR);
				return map;
			}
			if (list.size() == 1) {
				OrgMobilePage p = (OrgMobilePage) list.get(0);
				if (!pageId.toString().equals(p.getId().toString())) {
					map.put("code", HttpStatusCode.CODE_ERROR);
					return map;
				}
			}
		}
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/**
	 * 删除移动店铺首页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> deleteMobilePage(Integer pageId, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		orgMobilePageService.deleteMobilePageById(pageId);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/**
	 * 修改移动店铺首页
	 * 
	 * @param pageId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String editMobilePage(Integer pageId, Model model) {
		// 获取移动店铺首页
		OrgMobilePage page = orgMobilePageService.queryById(pageId);
		model.addAttribute("page", page);

		// 展现区域或店铺
		if (null != page.getShopId()) {
			OrgShop shop = orgShopService.queryById(page.getShopId());
			model.addAttribute("shop", shop);

			OrgArea area = orgAreaService.queryById(shop.getAreaCode());
			List<OrgArea> listProvince = orgAreaService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
			model.addAttribute("listProvince", listProvince);

			// 县
			OrgArea city = orgAreaService.queryById(area.getParentCode());
			OrgArea province = orgAreaService.queryById(city.getParentCode());
			model.addAttribute("provinceCode", province.getCode());
			model.addAttribute("cityCode", city.getCode());
			model.addAttribute("countryCode", area.getCode());

			List<OrgArea> listCity = orgAreaService.queryListByParentCode(province.getCode());
			model.addAttribute("listCity", listCity);

			List<OrgArea> listCountry = orgAreaService.queryListByParentCode(city.getCode());
			model.addAttribute("listCountry", listCountry);
		} else if (!"".equals(page.getAreaCode())) {
			OrgArea area = orgAreaService.queryById(page.getAreaCode());
			List<OrgArea> listProvince = orgAreaService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
			model.addAttribute("listProvince", listProvince);

			if (area.getLevel() == 1) {
				// 省
				model.addAttribute("provinceCode", area.getCode());
				List<OrgArea> listCity = orgAreaService.queryListByParentCode(area.getCode());
				model.addAttribute("listCity", listCity);
			} else if (area.getLevel() == 2) {
				// 市
				OrgArea province = orgAreaService.queryById(area.getParentCode());
				model.addAttribute("provinceCode", province.getCode());
				model.addAttribute("cityCode", area.getCode());

				List<OrgArea> listCity = orgAreaService.queryListByParentCode(province.getCode());
				model.addAttribute("listCity", listCity);

				List<OrgArea> listCountry = orgAreaService.queryListByParentCode(area.getCode());
				model.addAttribute("listCountry", listCountry);
			} else if (area.getLevel() == 3) {
				// 县
				OrgArea city = orgAreaService.queryById(area.getParentCode());
				OrgArea province = orgAreaService.queryById(city.getParentCode());
				model.addAttribute("provinceCode", province.getCode());
				model.addAttribute("cityCode", city.getCode());
				model.addAttribute("countryCode", area.getCode());

				List<OrgArea> listCity = orgAreaService.queryListByParentCode(province.getCode());
				model.addAttribute("listCity", listCity);

				List<OrgArea> listCountry = orgAreaService.queryListByParentCode(city.getCode());
				model.addAttribute("listCountry", listCountry);
			}
		}

		return "mobilePage/mobilePageEdit";
	}

	@RequestMapping(value = "/updateMobilePage", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateMobilePage(Model model, OrgMobilePage orgMobilePage, HttpServletRequest request, PageReq pageReq) {
		if (null != orgMobilePage.getStatus()) {
			orgMobilePageService.updateMobilePageByIdSelective(orgMobilePage);
		}
		// 获取移动店铺首页
		OrgMobilePage page = orgMobilePageService.queryById(orgMobilePage.getId());
		model.addAttribute("page", page);
		// 获取移动门店banner
		List<OrgMobilePageBanner> bannerList = orgMobilePageBannerService.queryByPageId(orgMobilePage.getId());
		model.addAttribute("blist", bannerList);
		return "mobilePage/bannerPage";
	}

	/*
	 * 添加新的轮播图
	 */
	@RequestMapping(value = "/AddNewBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public String AddNewBanner(Model model, String pageId, HttpServletRequest request, PageReq pageReq) {
		// 获取移动店铺首页
		OrgMobilePage page = orgMobilePageService.queryById(Integer.parseInt(pageId));
		model.addAttribute("page", page);
		return "mobilePage/continueAddBanner";
	}

	/*
	 * 保存新增的轮播图
	 */
	@ResponseBody
	@RequestMapping(value = "/saveMobileBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> saveMobileBanner(Model model, OrgMobilePageBanner orgMobilePageBanner) {
		Map<String, Object> map = new HashMap<String, Object>();
		orgMobilePageBannerService.addBanner(orgMobilePageBanner);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/*
	 * 编辑轮播图
	 */
	@RequestMapping(value = "/editBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public String editBanner(Model model, Integer id, HttpServletRequest request, PageReq pageReq) {
		// 获取移动店铺首页
		OrgMobilePageBanner banner = orgMobilePageBannerService.queryVoById(id);
		model.addAttribute("banner", banner);
		return "mobilePage/editBanner";
	}

	/*
	 * 更新轮播图信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updateMobileBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> updateMobileBanner(Model model, OrgMobilePageBanner orgMobilePageBanner) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(orgMobilePageBanner.getBannerImg().contains("imgBase")){
			orgMobilePageBanner.setBannerImg(orgMobilePageBanner.getBannerImg().split("imgBase")[1]);
		}
		orgMobilePageBannerService.updateBannerByIdSelective(orgMobilePageBanner);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/**
	 * 删除轮播图
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> deleteBanner(Integer id, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		orgMobilePageBannerService.deleteBannerById(id);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/*
	 * 轮播图list
	 */
	@RequestMapping(value = "/bannerList", method = { RequestMethod.GET, RequestMethod.POST })
	public String bannerList(Model model, OrgMobilePageBanner orgMobilePageBanner) {
		// 获取移动店铺首页
		OrgMobilePage page = orgMobilePageService.queryById(orgMobilePageBanner.getPageId());
		model.addAttribute("page", page);
		// 获取移动门店banner
		List<OrgMobilePageBanner> bannerList = orgMobilePageBannerService.queryByPageId(orgMobilePageBanner.getPageId());
		model.addAttribute("blist", bannerList);
		return "mobilePage/bannerPage";
	}

	@ResponseBody
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public Map<String, Object> uploadImage(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		if (!file.isEmpty()) {
			String filenName = UUIDUtils.create() + "_.jpg";
			File targetFile = new File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.SHOP_PAGE, filenName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}

			try {
				file.transferTo(targetFile);
				mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
				mapResult.put("url", ImageConstant.IMAGE_BASE_URL + ImageConstant.SHOP_PAGE + filenName);
				mapResult.put("returnImgUrl", ImageConstant.SHOP_PAGE + filenName);
			} catch (Exception e) {
				mapResult.put("code", HttpStatusCode.CODE_ERROR);
			}

		} else {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
		}
		return mapResult;
	}

	/*
	 * 轮播图排序
	 */
	@ResponseBody
	@RequestMapping(value = "/bannerOrder", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> bannerOrder(Model model, Integer clickId, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		OrgMobilePageBanner orgClickBanner = orgMobilePageBannerService.queryById(clickId);
		OrgMobilePageBanner orgBanner = orgMobilePageBannerService.queryById(id);
		Integer tmp = null;
		tmp = clickId;
		clickId = id;
		id = tmp;
		
		OrgMobilePageBannerForm  orgClickBannerForm = new OrgMobilePageBannerForm();
		orgClickBannerForm.setId(clickId);
		orgClickBannerForm.setBannerImg(orgClickBanner.getBannerImg());
		orgClickBannerForm.setBannerUrl(orgClickBanner.getBannerUrl());
		orgClickBannerForm.setBgColor(orgClickBanner.getBgColor());
		orgClickBannerForm.setTitle(orgClickBanner.getTitle());
		orgClickBannerForm.setPageId(orgClickBanner.getPageId());
		
		OrgMobilePageBannerForm  orgBannerForm = new OrgMobilePageBannerForm();
		orgBannerForm.setId(id);
		orgBannerForm.setBannerImg(orgBanner.getBannerImg());
		orgBannerForm.setBannerUrl(orgBanner.getBannerUrl());
		orgBannerForm.setBgColor(orgBanner.getBgColor());
		orgBannerForm.setTitle(orgBanner.getTitle());
		orgBannerForm.setPageId(orgBanner.getPageId());
		
		orgClickBannerForm.setNewId(clickId);
		// ①先把另一个orgBanner的id改为-1，然后再更新orgClickBanner的id用newID
		orgBannerForm.setNewId(-1);// 更新orgClickBanner时，先把orgBanner的id置为-1
		orgMobilePageBannerService.updateId(orgBannerForm);
		orgMobilePageBannerService.updateId(orgClickBannerForm);

		// ②然后再用newID去更新orgNowBanner
		OrgMobilePageBanner orgNowBanner = orgMobilePageBannerService.queryById(-1);
		OrgMobilePageBannerForm  orgNowBannerForm = new OrgMobilePageBannerForm();
		
		orgNowBannerForm.setId(orgNowBanner.getId());
		orgNowBannerForm.setBannerImg(orgNowBanner.getBannerImg());
		orgNowBannerForm.setBannerUrl(orgNowBanner.getBannerUrl());
		orgNowBannerForm.setBgColor(orgNowBanner.getBgColor());
		orgNowBannerForm.setTitle(orgNowBanner.getTitle());
		orgNowBannerForm.setPageId(orgNowBanner.getPageId());
		
		orgNowBannerForm.setNewId(id);
		orgMobilePageBannerService.updateId(orgNowBannerForm);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/*
	 * 模块区页面
	 */
	@RequestMapping(value = "/modulePage", method = { RequestMethod.GET, RequestMethod.POST })
	public String modulePage(Model model, Integer pageId) {
		OrgMobilePage page = orgMobilePageService.queryById(pageId);
		model.addAttribute("page", page);
		// 获取移动门店模块区
		List<OrgMobilePageModule> list = orgMobilePageModuleService.queryByPageId(pageId);
		List<OrgMobilePageModuleVo> moduleList = new ArrayList<OrgMobilePageModuleVo>();
		OrgMobilePageModuleGoodsQuery query = null;
		Long count = null;
		for (OrgMobilePageModule orgModule : list) {
			OrgMobilePageModuleVo orgModuleVo = (OrgMobilePageModuleVo) orgModule;
			query = new OrgMobilePageModuleGoodsQuery();
			query.setModuleId(orgModule.getId());
			count = orgMobilePageModuleGoodsService.queryCount(query);
			orgModuleVo.setCount(count);
			moduleList.add(orgModuleVo);
		}
		model.addAttribute("moduleList", moduleList);
		model.addAttribute("size", moduleList.size());
		return "mobilePage/modulePage";
	}

	/*
	 * 添加新的模块区
	 */
	@RequestMapping(value = "/AddNewModule", method = { RequestMethod.GET, RequestMethod.POST })
	public String AddNewModule(Model model, Integer pageId, HttpServletRequest request, PageReq pageReq) {
		// 获取移动店铺首页
		OrgMobilePage page = orgMobilePageService.queryById(pageId);
		model.addAttribute("page", page);
		return "mobilePage/continueAddModule";
	}

	/*
	 * 保存新增的模块区
	 */
	@ResponseBody
	@RequestMapping(value = "/saveMobileModel", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> saveMobileModel(Model model, OrgMobilePageModule orgMobilePageModule) {
		Map<String, Object> map = new HashMap<String, Object>();
		Long moduleOrder = orgMobilePageModuleService.queryMaxOrder();
		if (null == moduleOrder) {
			moduleOrder = (long) 0;
		}
		orgMobilePageModule.setModuleOrder((byte) (moduleOrder + 1));
		orgMobilePageModuleService.addModule(orgMobilePageModule);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/*
	 * 更新模块区信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updateModel", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> updateModel(Model model, OrgMobilePageModule orgMobilePageModule) {
		Map<String, Object> map = new HashMap<String, Object>();
		orgMobilePageModuleService.updateModuleByIdSelective(orgMobilePageModule);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/**
	 * 删除模块区信息
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteModule", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> deleteModuel(Integer id, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		orgMobilePageModuleService.deleteModuleById(id);
		OrgMobilePageModuleGoodsQuery query = new OrgMobilePageModuleGoodsQuery();
		query.setModuleId(id);
		orgMobilePageModuleGoodsService.deleteGoodsByModuleId(query);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/*
	 * 模块区排序
	 */
	@ResponseBody
	@RequestMapping(value = "/moduleOrder", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> moduleOrder(Model model, Integer clickId, Integer id, Integer clickOrderId, Integer orderId) {
		Map<String, Object> map = new HashMap<String, Object>();

		OrgMobilePageModule clickModule = orgMobilePageModuleService.queryById(clickId);
		OrgMobilePageModule module = orgMobilePageModuleService.queryById(id);

		Integer tmp = null;
		tmp = clickOrderId;
		clickOrderId = orderId;
		orderId = tmp;

		clickModule.setModuleOrder(clickOrderId.byteValue());
		module.setModuleOrder(orderId.byteValue());

		orgMobilePageModuleService.updateModuleByIdSelective(clickModule);
		orgMobilePageModuleService.updateModuleByIdSelective(module);

		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/*
	 * 商品列表
	 */
	@RequestMapping(value = "/itemList", method = { RequestMethod.GET, RequestMethod.POST })
	public String itemList(OrgProductItemQuery query, Model model, HttpServletRequest request, PageReq pageReq) {
		// 获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);
		// 获取品牌
		if (query.getSuperClassId() != null) {
			List<OrgBrand> listBrand = orgBrandService.queryAllBrandByClass(query.getSuperClassId());
			model.addAttribute("listBrand", listBrand);
		}
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		Page<OrgProductItem> page = orgProductItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "mobilePage/moduleGoodsList";
	}

	/*
	 * 向模块区添加商品
	 */
	@ResponseBody
	@RequestMapping(value = "/addGoods", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> addGoods(OrgMobilePageModuleGoods module, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		orgMobilePageModuleGoodsService.addGoods(module);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}

	/*
	 * 删除模块区商品
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteGoods", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> deleteGoods(OrgMobilePageModuleGoodsQuery query, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		orgMobilePageModuleGoodsService.deleteGoods(query);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
}
