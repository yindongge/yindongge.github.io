package com.kjj.manage.web.controller.goods;

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

import com.kjj.commserver.entity.discount.OrgDiscountProduct;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/productItem")
public class ProductItemController {

	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgProductItemService orgProductItemService;
	@Resource
	private OrgDiscountProductService orgDiscountProductService;
	@Resource
	private OrgBrandService orgBrandService;
	
	@RequestMapping(value = "/discountList", method = { RequestMethod.GET,RequestMethod.POST })
	public String discountList(OrgProductItemQuery query,Model model,PageReq pageReq) {
		
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
		
		return "productItem/itemDiscountSelect";
	}
	
	@ResponseBody
	@RequestMapping(value = "/discountSelect", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> discountSelect(OrgDiscountProduct orgDiscountProduct) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgDiscountProductService.add(orgDiscountProduct);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/discountCancel", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> discountCancel(OrgDiscountProduct orgDiscountProduct) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgDiscountProductService.delete(orgDiscountProduct);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}
