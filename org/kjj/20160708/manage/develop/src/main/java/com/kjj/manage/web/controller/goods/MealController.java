package com.kjj.manage.web.controller.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductInventory;
import com.kjj.commserver.entity.goods.OrgProductInventoryClear;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgClassQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryClearConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryVo;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgShopQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductInventoryClearService;
import com.kjj.commserver.service.goods.OrgProductInventoryService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;

/**
 * 菜品管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/meal")
public class MealController {
	@Resource
	private OrgProductInventoryService orgProductInventoryService;
	
	@Resource
	private OrgProductInventoryClearService orgProductInventoryClearService;
	
	@Resource
	private OrgShopService orgShopService;
	
	@Resource
	private OrgClassService orgClassService;
	
	/**
	 * 查询菜品列表
	 * @param query
	 * @param model
	 * @param pageReq
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(OrgProductInventoryQuery query,Model model,HttpSession session) {
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		OrgShopQuery shopQuery = new OrgShopQuery();
		shopQuery.setShopIds(admin.getShopIds());
		
		query.setIsDelete(OrgProductConstant.IS_NOT_DELETE); // 非删除商品
		query.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON); // 非下架商品
		
		List<OrgShop> shopList = orgShopService.queryList(shopQuery);
		
		// 只有当前人配置了店铺的情况下才能显示菜品列表
		if(shopList != null && shopList.size() > 0){
			if(null == query.getShopCode()){
				query.setShopCode(shopList.get(0).getShopCode());
			}
			if(null == query.getClassId()){
				query.setClassId(OrgClassConstant.MEAL_CLASS_ID);
			}
			
			List<OrgProductInventoryVo> inventoryList = orgProductInventoryService.queryMealList(query);
			model.addAttribute("inventoryList", inventoryList);
			
			model.addAttribute("shopList", shopList);
		}
		
		// 菜品分类，目前只有午餐，所有用class_id
		OrgClassQuery classQuery = new OrgClassQuery();
		classQuery.setClassId(OrgClassConstant.MEAL_CLASS_ID);
		List<OrgClass> classList = orgClassService.queryList(classQuery);
		model.addAttribute("classList", classList);
		
		model.addAttribute("query", query);
		
		return "meal/mealList"; 
	}
	
	/**
	 * 查询列表
	 * @param query
	 * @param model
	 * @param pageReq
	 * @return
	 */
	@RequestMapping(value = "/freshList", method = { RequestMethod.GET,RequestMethod.POST })
	public String freshList(OrgProductInventoryQuery query,Model model,HttpSession session) {
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		OrgShopQuery shopQuery = new OrgShopQuery();
		shopQuery.setShopIds(admin.getShopIds());
		
		query.setIsDelete(OrgProductConstant.IS_NOT_DELETE); // 非删除商品
		query.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON); // 非下架商品
		
		List<OrgShop> shopList = orgShopService.queryList(shopQuery);
		
		// 只有当前人配置了店铺的情况下才能显示菜品列表
		if(shopList != null && shopList.size() > 0){
			if(null == query.getShopCode()){
				query.setShopCode(shopList.get(0).getShopCode());
			}
			if(null == query.getClassId()){
				query.setClassId(OrgClassConstant.FRESH_CLASS_ID);
			}
			
			List<OrgProductInventoryVo> inventoryList = orgProductInventoryService.queryMealList(query);
			model.addAttribute("inventoryList", inventoryList);
			
			model.addAttribute("shopList", shopList);
		}
		
		// 菜品分类，目前只有午餐，所有用class_id
		OrgClassQuery classQuery = new OrgClassQuery();
		classQuery.setTopId(OrgClassConstant.FRESH_CLASS_ID);
		List<OrgClass> classList = orgClassService.queryList(classQuery);
		model.addAttribute("classList", classList);
		
		model.addAttribute("query", query);
		
		return "meal/freshList"; 
	}
	
	/**
	 * 保存菜品的价格或库存数
	 * @param model
	 * @param inventory
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/saveMeal", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> saveMeal(Model model, OrgProductInventory inventory){
		Map<String, Object> result=new HashMap<String, Object>();
		inventory.setUpdateTime(new Date());
		orgProductInventoryService.updateByIdSelective(inventory);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 设置自动清空库存
	 * @param model
	 * @param shopCode
	 * @param timeType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/updateStockClear", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> updateStockClear(Model model, String shopCode, String timeTypeStr){
		Map<String, Object> result=new HashMap<String, Object>();
		
		String [] timeTypeArray = timeTypeStr.split(",");
		
		List<OrgProductInventoryClear> InventoryClearList = new ArrayList<OrgProductInventoryClear>();
		for(String timeType : timeTypeArray){
			if(!StringUtils.isBlank(timeType)){
				OrgProductInventoryClear entity = new OrgProductInventoryClear();
				entity.setShopCode(shopCode);
				entity.setTimeType(Byte.parseByte(timeType));
				InventoryClearList.add(entity);
			}
		}
		orgProductInventoryClearService.updateInventoryClear(shopCode, InventoryClearList);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value = "/editStockClear", method = { RequestMethod.GET,RequestMethod.POST })
	public String editStockClear(String shopCode, Model model) {
		OrgProductInventoryClear query = new OrgProductInventoryClear();
		query.setShopCode(shopCode);
		List<OrgProductInventoryClear> clearList = orgProductInventoryClearService.queryList(query);
		
		Set<String> existSet = new HashSet<String>();
		
		for(OrgProductInventoryClear e : clearList) {
			existSet.add(String.valueOf(e.getTimeType()));
		}
		
		Map<String, String> map = OrgProductInventoryClearConstant.timeTypeMap;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Iterator<?> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<?,?> entry = (Map.Entry<?,?>) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			Map<String, Object> entity = new HashMap<String,Object>();
			entity.put("id", key);
			entity.put("name", val);
			if(existSet.contains(String.valueOf(key))){
				entity.put("isCheck", "true");
			}
			list.add(entity);
		}
		model.addAttribute("timeList", list);
		model.addAttribute("shopCode", shopCode);
		
		return "meal/stockClear";
	}
}
