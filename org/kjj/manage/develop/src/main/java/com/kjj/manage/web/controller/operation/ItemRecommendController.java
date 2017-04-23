package com.kjj.manage.web.controller.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.operation.OrgItemRecommend;
import com.kjj.commserver.entity.operation.aide.OrgItemRecommendConstant;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.operation.OrgItemRecommendService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/itemRecommend")
public class ItemRecommendController {

	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgProductItemService orgProductItemService;
	@Resource
	private OrgBrandService orgBrandService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgItemRecommendService orgItemRecommendService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(OrgProductItemQuery query,Model model,PageReq pageReq) {
		
		if(query.getRecommendType() == null){
			query.setRecommendType(OrgItemRecommendConstant.RECOMMEND_TYPE_NEW);
		}
		if(query.getShopType() == null){
			query.setShopType(OrgItemRecommendConstant.SHOP_TYPE_ALL);
		}
		//获取店铺
		List<OrgShop> listShop = orgShopService.queryListAll();
		model.addAttribute("listShop", listShop);
		
		//获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);
		
		//获取品牌
		if(query.getSuperClassId()!= null){
			List<OrgBrand> listBrand =  orgBrandService.queryAllBrandByClass(query.getSuperClassId());
			model.addAttribute("listBrand",listBrand);
		}
		
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		Page<OrgProductItem> page = orgProductItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "itemRecommend/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/select", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> select(OrgItemRecommend orgItemRecommend) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgItemRecommendService.add(orgItemRecommend);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/cancel", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> cancel(OrgItemRecommend orgItemRecommend) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgItemRecommendService.delete(orgItemRecommend);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}
