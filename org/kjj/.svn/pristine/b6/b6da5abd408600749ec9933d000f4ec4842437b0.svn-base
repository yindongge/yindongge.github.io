package com.kjj.manage.web.controller.leveldiscount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCoupon;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCouponDiscount;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponVo;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelProductQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelProductVo;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgShopQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelCouponDiscountService;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelCouponService;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelProductService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgBusinessAreaService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/levelprice")
public class LevelPriceController {
	
	@Resource
	private OrgUserLevelService orgUserLevelService;
	
	@Resource
	private OrgUserLevelProductService orgUserLevelProductService;
	
	@Resource
	private OrgUserLevelCouponService orgUserLevelCouponService;
	
	@Resource
	OrgBusinessAreaService orgBusinessAreaService;
	
	@Resource
	private OrgUserLevelCouponDiscountService orgUserLevelCouponDiscountService;
	
	@Resource
	private OrgShopService orgShopService;
	
	@Resource
	private OrgAreaService orgAreaService;
	
	@Resource
	private OrgClassService orgClassService;
	
	@Resource
	private OrgProductItemService orgProductItemService;

	@Resource
	private OrgBrandService orgBrandService;
	
	@Resource
	private OrgUsersService orgUserService;
	/**
	 * 显示一体化价格分页
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/commlevel", method = { RequestMethod.GET, RequestMethod.POST })
	public String commLevel(OrgUserLevelProductQuery query,Model model,PageReq pageReq){
		
		//orgUserService.syncUserLevelToRuiXing();//测试会员同步
		
		//orgUserLevelCouponService.queryMap4ViewTest();
		
		pageReq.setPageSize(10);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);// 未删除的商品
		
		Page<OrgUserLevelProductVo> page = orgUserLevelProductService.selectPageLevelProduct(query, pageReq);
		model.addAttribute("page", page);// 查询到的会员级别的商品折扣信息
		
		List<OrgUserLevel> userLevels = orgUserLevelService.queryList(new OrgUserLevel()); 
		model.addAttribute("userLevels", userLevels);// 会员级别列表
		
		model.addAttribute("query", query);// 查询条件
		
		return "levelDiscount/commLevel";
	}
	
	/**
	 * 更新一体化价格-生效
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/updateActive", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> updateActive(Integer goodsId,Model model,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		orgUserLevelProductService.updateActive(goodsId);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 更新一体化价格-无效
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/updateNoActive", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> updateNoActive(Integer id,Model model,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		orgUserLevelProductService.updateNoActive(id);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 显示商品及折扣信息
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/queryGoodsLevel", method = { RequestMethod.GET, RequestMethod.POST })
	public String queryGoodsLevel(OrgUserLevelProductQuery query,Model model,PageReq pageReq){
		
		pageReq.setPageSize(1);
		Page<OrgUserLevelProductVo> page = orgUserLevelProductService.selectPageLevelProduct(query, pageReq);
		List<OrgUserLevelProductVo> productItemList = page.getContent();
		
		model.addAttribute("productItem", productItemList.get(0));// 取第一个对象
		
		List<OrgUserLevel> userLevels = orgUserLevelService.queryList(new OrgUserLevel()); 
		model.addAttribute("userLevels", userLevels);// 会员级别列表
		
		return "levelDiscount/goodsLevel";
	}
	
	
	/**
	 * 显示电商会员价格分页
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/levelcoupon", method = { RequestMethod.GET, RequestMethod.POST })
	public String levelPoupon(OrgUserLevelCouponQuery query,Model model,PageReq pageReq){
		
		List<OrgUserLevel> userLevels = orgUserLevelService.queryList(new OrgUserLevel()); 
		model.addAttribute("userLevels", userLevels);// 会员级别列表
		
		List<OrgShop> shopList = orgShopService.queryListAll();
		model.addAttribute("shopList", shopList);// 所有商铺列表
		
		pageReq.setPageSize(10);
		if(query == null){
			query = new OrgUserLevelCouponQuery();
		}
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);// 未删除的商品
		Page<OrgUserLevelCouponVo> page = orgUserLevelCouponService.selectLevelCoupon(query, pageReq);
		model.addAttribute("page", page);
		
		model.addAttribute("query", query);// 查询条件
		
		return "levelDiscount/levelCoupon";
	}
	
	/**
	 * 准备增加电商会员折扣
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/addLeveCoupon", method = { RequestMethod.GET, RequestMethod.POST })
	public String addLeveCoupon(OrgUserLevelCouponQuery query,Model model,PageReq pageReq){
		
		List<OrgUserLevel> userLevels = orgUserLevelService.queryList(new OrgUserLevel()); 
		model.addAttribute("userLevels", userLevels);// 会员级别列表
		
		//获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);
		
		
		return "levelDiscount/couponAdd";
	}

	@RequestMapping(value = "/shopSelect", method = { RequestMethod.GET,RequestMethod.POST })
	public String shopSelect(String selectedIds,Model model,OrgShopQuery query){
		
		List<OrgShopVo> listAllShop = orgShopService.queryList(query);
		String[] area = null;
		String city = null;
		String county = null;
		Map<String,Map<String,List<OrgShop>>> mapCity = new LinkedHashMap<String,Map<String,List<OrgShop>>>();
		Map<String,List<OrgShop>> mapCounty = null;
		List<OrgShop> listShop = null;
		for(OrgShopVo shop:listAllShop){
			area = shop.getArea();
			//市
			if(area.length>=2 && !"".equals(area[1])){
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
		
		model.addAttribute("selectedIds", selectedIds);// 已经选择的店铺id

		return "levelDiscount/shopSelect";
	}
	
	@RequestMapping(value = "/productSelect", method = { RequestMethod.GET,RequestMethod.POST })
	public String productSelect(OrgProductItemQuery query,Model model,PageReq pageReq, String classLock) {
		
		//获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		
		// classLock代表类锁定，不允许出现其他的分类
		if(!StringUtils.isBlank(classLock)){
			List<OrgClass> defClassList = new ArrayList<OrgClass>();
			for(OrgClass oc : listClass){
				if(oc.getClassId().toString().equals(String.valueOf(classLock))){
					defClassList.add(oc);
				}
				if(oc.getClassParent().toString().equals(String.valueOf(classLock))){
					defClassList.add(oc);
				}
			}
			model.addAttribute("listClass", defClassList);
			model.addAttribute("classLock", classLock);
		} else {
			model.addAttribute("listClass", listClass);
		}
		
		//获取品牌
		if(query.getCatId()!= null && query.getCatId() > 0){
			List<OrgBrand> listBrand =  orgBrandService.queryAllBrandByClass((int)query.getCatId());
			model.addAttribute("listBrand",listBrand);
		}
		
		List<Integer> catIds = new ArrayList<Integer>();
		if(null != query.getCatId()){
			for(OrgClass oc : listClass){
				if(oc.getClassParent().toString().equals(String.valueOf(query.getCatId()))){
					catIds.add(oc.getClassId());
				}
			}
			if(catIds.size() > 0){
				query.setCatIds(catIds);
			}
		}
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);// 未删除的商品
		query.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		
		Page<OrgProductItem> page = orgProductItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "levelDiscount/productSelect";
	}

	 
	
	/**
	 * 更新电商会员价格-生效
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/updateCouponActive", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> updateCouponActive(Integer couponId,Model model,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		orgUserLevelCouponService.updateActive(couponId);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
		
	}
	
	/**
	 * 更新电商会员价格-无效
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/updateCouponNoActive", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> updateCouponNoActive(Integer couponId,Model model,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		orgUserLevelCouponService.updateNoActive(couponId);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
		
	}
	
	/**
	 * 删除电商会员价格
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/deleteLevelCoupon", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> deleteLevelCoupon(Integer couponId,Model model,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		orgUserLevelCouponService.deleteByCouponId(couponId);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 保存修改后的会员级别信息
	 * @param model
	 * @param orgUserLevel
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveLevelCoupon", method = { RequestMethod.GET,RequestMethod.POST })
	public String save(Model model,OrgUserLevelCoupon orgUserLevelCoupon,String discountAll, HttpServletRequest request,HttpSession session) {
		
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		orgUserLevelCouponService.addLevelCoupon(orgUserLevelCoupon, discountAll, admin);
		return levelPoupon(null,model,new PageReq());
	}
	
	/**
	 * 新增验证电商会员价格
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/validateBeforeSave", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> validateBeforeSave(Model model,OrgUserLevelCoupon orgUserLevelCoupon,String discountAll, HttpServletRequest request,HttpSession session){
		Map<String, Object> result=new HashMap<String, Object>();
		 
		OrgUserLevelCouponQuery vc = new OrgUserLevelCouponQuery();
		vc.setCityCode(orgUserLevelCoupon.getCityCode());
		vc.setClassId(orgUserLevelCoupon.getClassId());
		vc.setGoodsId(orgUserLevelCoupon.getGoodsId());
		vc.setProductType(orgUserLevelCoupon.getProductType());
		vc.setShopType(orgUserLevelCoupon.getShopType());
		
		if(null != orgUserLevelCoupon.getCityShopId()) {
			String shopIdsStr = orgUserLevelCoupon.getCityShopId();
			String[] shopIds = shopIdsStr.split(",");
			for(String id : shopIds){
				if(!StringUtils.isBlank(id)){
					vc.setCityShopIds(id);
					List<OrgUserLevelCoupon> couponList = orgUserLevelCouponService.queryList(vc);
					if(null == orgUserLevelCoupon.getLevelCouponId() && couponList.size() > 0){
						result.put("code", "202");
						return result;
					}
					// -条，但不是本记录
					if(null != orgUserLevelCoupon.getLevelCouponId() && couponList.size() == 1){
						if(!couponList.get(0).getLevelCouponId().equals(orgUserLevelCoupon.getLevelCouponId())){
							result.put("code", "202");
							return result;
						}
					}
					if(null != orgUserLevelCoupon.getLevelCouponId() && couponList.size() > 1){
						result.put("code", "202");
						return result;
					}
				}
			}
		} else {
			List<OrgUserLevelCoupon> couponList = orgUserLevelCouponService.queryList(vc);
			
			if(couponList == null || couponList.size() == 0){
				result.put("code", "200");
			} else {
				if(couponList.get(0).getLevelCouponId().equals(orgUserLevelCoupon.getLevelCouponId())){
					result.put("code", "200");
				} else {
					result.put("code", "202");// 优惠已经存在
				}
			}
		}
		result.put("code", "200");
		return result;
		
	}
	
	@RequestMapping(value = "/findLevelCoupon", method = { RequestMethod.GET,RequestMethod.POST })
	public String findLevelCoupon(String levelCouponId,Model model,PageReq pageReq) {
		
		OrgUserLevelCoupon coupon = orgUserLevelCouponService.queryById(Integer.parseInt(levelCouponId));
		

		if(coupon.getCityShopId() != null && !coupon.getCityShopId().equals("")){
			String shopName = orgUserLevelCouponService.convertShopName(coupon.getCityShopId());
			model.addAttribute("shopName", shopName);// 门店名称
		}
		
		List<OrgUserLevel> userLevels = orgUserLevelService.queryList(new OrgUserLevel()); 
		
		OrgUserLevelCouponDiscount oldc = new OrgUserLevelCouponDiscount();
		oldc.setLevelCouponId(Integer.parseInt(levelCouponId));
		OrgUserLevelCouponDiscount queryDisc = new OrgUserLevelCouponDiscount();
		queryDisc.setLevelCouponId(Integer.parseInt(levelCouponId));
		List<OrgUserLevelCouponDiscount>  discountList = orgUserLevelCouponDiscountService.queryList(queryDisc);
		
		List<Map<String,Object>> newUserLevel = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> newUserLevelMap = null;
		
		for(OrgUserLevel oul:userLevels){
			newUserLevelMap = new HashMap<String,Object>();
			newUserLevelMap.put("levelName", oul.getLevelName());
			newUserLevelMap.put("levelId", oul.getLevelId());
			for(OrgUserLevelCouponDiscount disc: discountList){
				if(String.valueOf(disc.getLevelId()).equals(String.valueOf(oul.getLevelId()))){
					newUserLevelMap.put("discount", disc.getDiscount());
					newUserLevelMap.put("price", disc.getPrice());
				}
			}
			newUserLevel.add(newUserLevelMap);
		}
		model.addAttribute("userLevels", newUserLevel);// 会员级别列表
		
		model.addAttribute("levelCoupon", coupon); // 会员折扣
		
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);// 商品分类
		
		return "levelDiscount/couponEdit";
	}
	
}
