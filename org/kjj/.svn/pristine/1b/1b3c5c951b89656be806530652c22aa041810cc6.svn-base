package com.kjj.manage.web.controller.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgTouchPage;
import com.kjj.commserver.entity.shop.OrgTouchPageBanner;
import com.kjj.commserver.entity.shop.aide.OrgShopQuery;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageQuery;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.shop.OrgTouchPageBannerService;
import com.kjj.commserver.service.shop.OrgTouchPageService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.MultipartFileUploadUtil;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/touchPage")
public class TouchPageController {
	@Resource
	private OrgTouchPageService  orgTouchPageService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgAreaService orgAreaService;
	@Resource
	private OrgTouchPageBannerService orgTouchPageBannerService;
	/**
	 * 触摸屏店铺首页列表
	 * 
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String pageList(Model model, PageReq pageReq, OrgTouchPageQuery query) {
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
		Page<OrgTouchPage> page = orgTouchPageService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);// 保留查询条件

		return "touchPage/touchPageList";
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String addTouchPage(Model model) {
		// 获得省
		List<OrgArea> listProvince = orgAreaService.queryListProvince();
		model.addAttribute("listProvince", listProvince);
		return "touchPage/touchPageAdd";
	}
	
	@RequestMapping(value = "/saveTouchPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveTouchPage(Model model, OrgTouchPage orgTouchPage, PageReq pageReq) {
		orgTouchPageService.addTouchPage(orgTouchPage);
		OrgTouchPage page = orgTouchPageService.queryOne(orgTouchPage);
		model.addAttribute("page", page);
		return "redirect:/touchPage/bannerList?pageId="+page.getId();
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
	public Map<String, Object> pageIsOnly(OrgTouchPageQuery query, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer pageId = null;
		if (null != query.getId()) {// 修改时处理
			pageId = query.getId();
			query.setId(null);
		}

		List<OrgTouchPage> list = orgTouchPageService.queryList(query);
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
				OrgTouchPage p = (OrgTouchPage) list.get(0);
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
	public Map<String, Object> deleteTouchPage(Integer pageId, Model model, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		orgTouchPageService.deleteTouchPageById(pageId);
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
	public String editTouchPage(Integer pageId, Model model) {
		// 获取移动店铺首页
		OrgTouchPage page = orgTouchPageService.queryById(pageId);
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

		return "touchPage/touchPageEdit";
	}
	
	@RequestMapping(value = "/updateTouchPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateTouchPage(Model model, OrgTouchPage orgTouchPage, HttpServletRequest request, PageReq pageReq) {
		if (null != orgTouchPage.getStatus()) {
			orgTouchPageService.updateTouchPageByIdSelective(orgTouchPage);
		}
		// 获取移动店铺首页
		OrgTouchPage page = orgTouchPageService.queryById(orgTouchPage.getId());
		model.addAttribute("page", page);
		// 获取移动门店banner
		List<OrgTouchPageBanner> bannerList = orgTouchPageBannerService.queryByPageId(orgTouchPage.getId());
		model.addAttribute("blist", bannerList);
		return "touchPage/bannerPage";
	}
	
	/*
	 * 轮播图list
	 */
	@RequestMapping(value = "/bannerList", method = { RequestMethod.GET, RequestMethod.POST })
	public String bannerList(Model model, OrgTouchPageBanner orgTouchPageBanner) {
		// 获取移动店铺首页
		OrgTouchPage page = orgTouchPageService.queryById(orgTouchPageBanner.getPageId());
		model.addAttribute("page", page);
		// 获取移动门店banner
		List<OrgTouchPageBanner> bannerList = orgTouchPageBannerService.queryByPageId(orgTouchPageBanner.getPageId());
		model.addAttribute("blist", bannerList);
		return "touchPage/bannerPage";
	}
	
	/**
	 * 轮播图片详情
	 */
	@RequestMapping(value = "/bannerDetail/{pageId}/{id}" , method = {RequestMethod.GET,RequestMethod.POST}) 
	public String editBanner(Model model,@PathVariable Integer pageId,@PathVariable Integer id){
		OrgTouchPageBanner pageBanner = null;
		if(id != null && id != 0){
			pageBanner = orgTouchPageBannerService.queryVoById(id);
		}else{
			pageBanner = new OrgTouchPageBanner();
			pageBanner.setPageId(pageId);
		}
		model.addAttribute("banner", pageBanner);
		return "touchPage/editBanner";
	}
	
	// 删除轮播图
	@ResponseBody
	@RequestMapping(value = "/deleteBanner/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public Integer deleteBanner(Model model, @PathVariable Integer id) {
		orgTouchPageBannerService.deleteById(id);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadPicture", method = { RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> uploadPicture( MultipartFile file ){
		String imagePath = MultipartFileUploadUtil.fileUpload(file, ImageConstant.SHOP_PAGE);
        Map<String, Object> result = new HashMap<String, Object>();
        //保存到数据库的图片路径
        result.put("picUrlForSave", imagePath);
        //前台访问图片路径
        String picUrlForShow = ImageConstant.IMAGE_BASE_URL + imagePath;
        result.put("picUrlForShow", picUrlForShow);
        result.put("status", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveBanner", method = { RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> saveBanner(Model model,OrgTouchPageBanner orgTouchPageBanner){
		Map<String, Object> result = new HashMap<String, Object>();
		if(orgTouchPageBanner.getId() == null){
			Integer maxOrder = orgTouchPageBannerService.selectMaxOrder(orgTouchPageBanner.getPageId());
			if(maxOrder == null){
				maxOrder = 0;
			}
			maxOrder = maxOrder+1;
			orgTouchPageBanner.setImageOrder(maxOrder.byteValue());
		}
		orgTouchPageBannerService.save(orgTouchPageBanner);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveImageOrder", method = { RequestMethod.GET,RequestMethod.POST})
	public Integer saveImageOrder(Model model,Integer pageId,String ids){
		String[] idArr = ids.split(",");
		Byte curOrder = 0;
		OrgTouchPageBanner orgTouchPageBanner = null;
		List<OrgTouchPageBanner> list = new ArrayList<OrgTouchPageBanner>();
		for(int i=0;i<idArr.length;i++){
			orgTouchPageBanner = new OrgTouchPageBanner();
			curOrder = (byte)(i+1);
			orgTouchPageBanner.setId(Integer.parseInt(idArr[i]));
			orgTouchPageBanner.setImageOrder(curOrder);
			list.add(orgTouchPageBanner);
		}
		orgTouchPageBannerService.updateInBatch(list);
		return HttpStatusCode.CODE_SUCCESS;
	}
}
