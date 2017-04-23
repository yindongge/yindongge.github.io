package com.kjj.manage.web.controller.shop;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgBusinessArea;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgShopPageImg;
import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopForm;
import com.kjj.commserver.entity.shop.aide.OrgShopImgConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopImgForm;
import com.kjj.commserver.entity.shop.aide.OrgShopPageImgQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopPageImgVo;
import com.kjj.commserver.entity.shop.aide.OrgShopQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgBusinessAreaService;
import com.kjj.commserver.service.shop.OrgShopPageImgService;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.shop.OrgShopServiceService;
import com.kjj.commserver.service.system.OrgAdminShopService;
import com.kjj.commserver.util.UUIDUtils;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Resource
	private OrgShopService shopService;
	
	@Resource
	private OrgAreaService orgAreaService;
	
	@Resource
	private OrgBusinessAreaService orgBusinessAreaService;
	
	@Resource
	private OrgShopServiceService orgShopServiceService;
	
    @Resource
	private OrgShopSendRangeService orgShopSendRangeService;
    
    @Resource
	private OrgAdminShopService orgAdminShopService;
    
    @Resource
    private OrgShopPageImgService orgShopPageImgService;
   
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,OrgShopQuery query,PageReq pageReq){
		//省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		if(StringUtils.isNotBlank(query.getProvinceCode()) && !"-1".equals(query.getProvinceCode())){
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(query.getProvinceCode());
			model.addAttribute("listCity",listCity);
			query.setAreaCodeLike(query.getProvinceCode());
		}
		
		//市
		if(StringUtils.isNotBlank(query.getCityCode()) && !"-1".equals(query.getCityCode())){
			List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(query.getCityCode());
			model.addAttribute("listCounty",listCounty);
			query.setAreaCodeLike(query.getCityCode());
		}
		
		//县
		if(StringUtils.isNotBlank(query.getCountyCode()) && !"-1".equals(query.getCountyCode())){
			query.setAreaCodeLike(query.getCountyCode());
		}
		
		pageReq.setSort(new Sort(Direction.DESC,"t.shop_id"));
		Page<OrgShop> page = shopService.selectPageListView(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "shop/list";
	}
	@ResponseBody
	@RequestMapping(value = "/hide/{shopId}", method = { RequestMethod.GET,RequestMethod.POST })
	public int hide(@PathVariable Integer shopId) {
		shopService.updateHide(shopId);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	@ResponseBody
	@RequestMapping(value = "/show/{shopId}", method = { RequestMethod.GET,RequestMethod.POST })
	public int show(@PathVariable Integer shopId) {
		shopService.updateShow(shopId);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	@RequestMapping(value = "/addInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(Model model) {
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		//商圈列表(所有)
		List<OrgBusinessArea> listBusinessArea =  orgBusinessAreaService.queryList(null);
		model.addAttribute("listBusinessArea",listBusinessArea);
		List<com.kjj.commserver.entity.shop.OrgShopService> listShopService = orgShopServiceService.queryAll();
		model.addAttribute("listShopService",listShopService);
		return "shop/add";
	}
	
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public String add(OrgShopForm shopForm,OrgShopImgForm shopImgForm){
		//24小时营业
		if(shopForm.isFullTime()){
			shopForm.setIsFullTime(OrgShopConstant.IS_FULL_TIME_TRUE);
		}else{
			shopForm.setIsFullTime(OrgShopConstant.IS_FULL_TIME_FALSE);
		}
		if(!"-1".equals(shopForm.getCountyCode())){
			//选择到县
			shopForm.setAreaCode(shopForm.getCountyCode());
		
		}else if(!"-1".equals(shopForm.getCityCode())){
			//选择到市
			shopForm.setAreaCode(shopForm.getCityCode());
		}else{
			//选择到省
			shopForm.setAreaCode(shopForm.getProvinceCode());
		}
		
		shopService.add(shopForm);
		
		OrgShopQuery query = new OrgShopQuery();
		query.setShopName(shopForm.getShopName());
		OrgShop shop = shopService.queryOne(query);
		
		OrgShopPageImg shopImg = new OrgShopPageImg();
		if(StringUtils.isNotBlank(shopImgForm.getPageImgIcon())){
			shopImg.setShopId(shop.getShopId());
			shopImg.setType(OrgShopImgConstant.SHOP_IMG_TYPE_ICON);
			shopImg.setPageImg(shopImgForm.getPageImgIcon());
			orgShopPageImgService.add(shopImg);
		}
		if(StringUtils.isNoneBlank(shopImgForm.getPageImgInterior1())){
			shopImg.setShopId(shop.getShopId());
			shopImg.setType(OrgShopImgConstant.SHOP_IMG_TYPE_INTERIOR);
			shopImg.setPageImg(shopImgForm.getPageImgInterior1());
			orgShopPageImgService.add(shopImg);
		}
		if(StringUtils.isNoneBlank(shopImgForm.getPageImgInterior2())){
			shopImg.setShopId(shop.getShopId());
			shopImg.setType(OrgShopImgConstant.SHOP_IMG_TYPE_INTERIOR);
			shopImg.setPageImg(shopImgForm.getPageImgInterior2());
			orgShopPageImgService.add(shopImg);
		}
		if(StringUtils.isNoneBlank(shopImgForm.getPageImgOutDoor1())){
			shopImg.setShopId(shop.getShopId());
			shopImg.setType(OrgShopImgConstant.SHOP_IMG_TYPE_OUTDOOR);
			shopImg.setPageImg(shopImgForm.getPageImgOutDoor1());
			orgShopPageImgService.add(shopImg);
		}
		if(StringUtils.isNoneBlank(shopImgForm.getPageImgOutDoor2())){
			shopImg.setShopId(shop.getShopId());
			shopImg.setType(OrgShopImgConstant.SHOP_IMG_TYPE_OUTDOOR);
			shopImg.setPageImg(shopImgForm.getPageImgOutDoor2());
			orgShopPageImgService.add(shopImg);
		}
		if(StringUtils.isNoneBlank(shopImgForm.getPageImgImgMapPc())){
			shopImg.setShopId(shop.getShopId());
			shopImg.setType(OrgShopImgConstant.SHOP_IMG_TYPE_IMG_MAP);
			shopImg.setPageImg(shopImgForm.getPageImgImgMapPc());
			shopImg.setDevice(OrgShopImgConstant.SHOP_IMG_DEVICE_PC);
			orgShopPageImgService.add(shopImg);
		}
		if(StringUtils.isNoneBlank(shopImgForm.getPageImgImgMapMobile())){
			shopImg.setShopId(shop.getShopId());
			shopImg.setType(OrgShopImgConstant.SHOP_IMG_TYPE_IMG_MAP);
			shopImg.setPageImg(shopImgForm.getPageImgImgMapMobile());
			shopImg.setDevice(OrgShopImgConstant.SHOP_IMG_DEVICE_WECHAT);
			orgShopPageImgService.add(shopImg);
		}
		return "redirect:/shop/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/addShopCode", method = { RequestMethod.POST })
	public Map<String, Object> addShopCode(String shopCode,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		long count = shopService.queryCountByShopCode(shopCode);
		if(count == 0){
			result.put("valid",true);
		}else{
			result.put("valid",false);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/editShopCode", method = { RequestMethod.POST })
	public Map<String, Object> editShopCode(String shopCode,Integer shopId) {
		Map<String, Object> result = new HashMap<String, Object>();
		OrgShop shop = shopService.queryById(shopId);
		if(shopCode.equals(shop.getShopCode())){
			result.put("valid",true);
		}else{ 
			long count = shopService.queryCountByShopCode(shopCode);
			if(count == 0){
				result.put("valid",true);
			}else{
				result.put("valid",false);
			}
		}
		return result;
	}
	@RequestMapping(value = "/editInit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editInit(@PathVariable Integer id, Model model) {
		
		OrgShop shop = shopService.queryViewVoById(id);
		model.addAttribute("shop", shop);
		
		// 连接字符串
		
		//24小时营业
		model.addAttribute("fullTime",shop.getIsFullTime() == OrgShopConstant.IS_FULL_TIME_TRUE ? true : false);
		
		//配送
		List<OrgShopSendRange> sendRangeList = orgShopSendRangeService.queryListByShopId(id);
		model.addAttribute("sendRangeList",sendRangeList);
		
		//服务
		List<com.kjj.commserver.entity.shop.OrgShopService> listShopService =  orgShopServiceService.queryAll();
		model.addAttribute("listShopService",listShopService);
		
		OrgArea area = orgAreaService.queryById(shop.getAreaCode());
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		if(area.getLevel() == 1){
			//省
			model.addAttribute("provinceCode",area.getCode());
			
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(area.getCode());
			model.addAttribute("listCity",listCity);
		}else if(area.getLevel() == 2){
			//市
			OrgArea province = orgAreaService.queryById(area.getParentCode());
			model.addAttribute("provinceCode",province.getCode());
			model.addAttribute("cityCode",area.getCode());
			
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
			model.addAttribute("listCity",listCity);
			
			List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(area.getCode());
			model.addAttribute("listCounty",listCounty);
		}else if(area.getLevel() == 3){
			//县
			OrgArea city = orgAreaService.queryById(area.getParentCode());
			OrgArea province = orgAreaService.queryById(city.getParentCode());
			model.addAttribute("provinceCode",province.getCode());
			model.addAttribute("cityCode",city.getCode());
			model.addAttribute("countyCode",area.getCode());
			
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
			model.addAttribute("listCity",listCity);
			
			List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(city.getCode());
			model.addAttribute("listCounty",listCounty);
		}
		
		//商圈列表
		List<OrgBusinessArea> listBusinessArea =  orgBusinessAreaService.queryListByAreaCodeLike(orgAreaService.getSearchCode(shop.getAreaCode()));
		model.addAttribute("listBusinessArea",listBusinessArea);
		
		//店铺图片
		OrgShopPageImgQuery query = new OrgShopPageImgQuery();
		query.setShopId(shop.getShopId());
		List<OrgShopPageImgVo> shopImgList = orgShopPageImgService.queryList(query);
		List<OrgShopPageImgVo> tmpImgInteriorList = new ArrayList<OrgShopPageImgVo>();
		List<OrgShopPageImgVo> tmpImgOutdoorList = new ArrayList<OrgShopPageImgVo>();
		if(shopImgList.size()>0){
			for(OrgShopPageImgVo vo :shopImgList){
				if(vo.getType().equals(OrgShopImgConstant.SHOP_IMG_TYPE_ICON)){
					model.addAttribute("pageImgIcon", vo);
				}else if(vo.getType().equals(OrgShopImgConstant.SHOP_IMG_TYPE_IMG_MAP) && vo.getDevice().equals(OrgShopImgConstant.SHOP_IMG_DEVICE_PC)){
					model.addAttribute("pageImgImgMapPc", vo);
				}else if(vo.getType().equals(OrgShopImgConstant.SHOP_IMG_TYPE_IMG_MAP) && vo.getDevice().equals(OrgShopImgConstant.SHOP_IMG_DEVICE_WECHAT)){
					model.addAttribute("pageImgImgMapMobile", vo);
				}else if(vo.getType().equals(OrgShopImgConstant.SHOP_IMG_TYPE_INTERIOR)){
					tmpImgInteriorList.add(vo);
				}else if(vo.getType().equals(OrgShopImgConstant.SHOP_IMG_TYPE_OUTDOOR)){
					tmpImgOutdoorList.add(vo);
				}
			}
			if(tmpImgInteriorList.size()>0){
				if(tmpImgInteriorList.size() == 1){
					model.addAttribute("pageImgInterior1",tmpImgInteriorList.get(0));
				}else{
					model.addAttribute("pageImgInterior1",tmpImgInteriorList.get(0));
					model.addAttribute("pageImgInterior2",tmpImgInteriorList.get(1));
				}
			}
			if(tmpImgOutdoorList.size()>0){
				if(tmpImgOutdoorList.size() == 1){
					model.addAttribute("pageImgOutDoor1",tmpImgOutdoorList.get(0));
				}else{
					model.addAttribute("pageImgOutDoor1",tmpImgOutdoorList.get(0));
					model.addAttribute("pageImgOutDoor2",tmpImgOutdoorList.get(1));
				}
			}
		}
		model.addAttribute("shopImgList", shopImgList);
		return "shop/edit";
	}
	
	@RequestMapping(value = "/edit", method = {  RequestMethod.GET,RequestMethod.POST })
	public String edit(OrgShopForm shopForm,OrgShopImgForm shopImgForm){
		
		//24小时营业
		if(shopForm.isFullTime()){
			shopForm.setIsFullTime(OrgShopConstant.IS_FULL_TIME_TRUE);
		}else{
			shopForm.setIsFullTime(OrgShopConstant.IS_FULL_TIME_FALSE);
		}
		if(!"-1".equals(shopForm.getCountyCode())){
			//选择到县
			shopForm.setAreaCode(shopForm.getCountyCode());
		
		}else if(!"-1".equals(shopForm.getCityCode())){
			//选择到市
			shopForm.setAreaCode(shopForm.getCityCode());
		}else{
			//选择到省
			shopForm.setAreaCode(shopForm.getProvinceCode());
		}
		
		shopService.update(shopForm);
		
		orgShopPageImgService.updatePageImg(shopForm,shopImgForm);
		
		return "redirect:/shop/list";
	}
	
	@RequestMapping(value = "/shopSelectInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String shopSelectInit(HttpSession session,Model model,OrgShopQuery query,PageReq pageReq){

		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		query.setShopIds(admin.getShopIds());
		//省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		
		//商圈
		List<OrgBusinessArea> listBusinessArea = orgBusinessAreaService.queryList(null);
		model.addAttribute("listBusinessArea", listBusinessArea);
		
		List<OrgShop> listShop = shopService.queryList(query);
		model.addAttribute("listShop", listShop);

		return "shop/shopSelect";
	}
	
	@ResponseBody
	@RequestMapping(value = "/shopSelect", method = { RequestMethod.POST })
	public Map<String, Object> shopSelect(HttpSession session,OrgShopQuery query){
		Map<String, Object> result = new HashMap<String, Object>();
		
		// 2016-07-12去掉，不以用户的管理权限控制
//		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
//		query.setShopIds(admin.getShopIds());
		
		//区域搜索条件
		List<OrgShop> listShop = shopService.queryList(query);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("listShop", listShop);
		return result;
	}
	
	@RequestMapping(value = "/shopDiscountSelectInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String shopDiscountSelectInit(Model model,OrgShopQuery query){
		
		List<OrgShopVo> listAllShop = shopService.queryList(query);
		String[] area = null;
		String city = null;
		String county = null;
		Map<String,Map<String,List<OrgShop>>> mapCity = new LinkedHashMap<String,Map<String,List<OrgShop>>>();
		Map<String,List<OrgShop>> mapCounty = null;
		List<OrgShop> listShop = null;
		for(OrgShopVo shop:listAllShop){
			area = shop.getArea();
			//市
			if(area.length >= 2 && !"".equals(area[1])){
				city = area[1];
			}
			//区县
			if(area.length == 3 && !"".equals(area[2])){
				county = area[2];
			}
			//添加城市
			if(!mapCity.containsKey(city)){
				mapCounty = new LinkedHashMap<String,List<OrgShop>>();
				mapCity.put(city, mapCounty);
			}
			//添加区县
			if(!mapCity.get(city).containsKey(county)){
				listShop = new ArrayList<OrgShop>();
				mapCity.get(city).put(county, listShop);
			}
			//添加店铺
			mapCity.get(city).get(county).add(shop);
			
		}
		model.addAttribute("mapCity", mapCity);

		return "shop/shopDiscountSelect";
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
}
