package com.kjj.manage.web.controller.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.commserver.entity.goods.OrgProductTypeGroup;
import com.kjj.commserver.entity.goods.OrgProductTypeLinkSaleSpec;
import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyValueQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeForm;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeGroupConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeGroupQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeLinkSaleSpecQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeQuery;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecConstant;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecQuery;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecVo;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductPropertyService;
import com.kjj.commserver.service.goods.OrgProductPropertyValueService;
import com.kjj.commserver.service.goods.OrgProductTypeGroupService;
import com.kjj.commserver.service.goods.OrgProductTypeLinkSaleSpecService;
import com.kjj.commserver.service.goods.OrgProductTypeService;
import com.kjj.commserver.service.goods.OrgSaleSpecService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {
	@Resource
	private OrgProductTypeService productTypeService;
	
	@Resource
	private OrgProductTypeGroupService productTypeGroupService;
	
	@Resource
	private OrgSaleSpecService saleSpecService;
	
	@Resource
	private OrgProductTypeLinkSaleSpecService productTypeLinkSaleSpecService;
	
	@Resource
	private OrgProductPropertyService productPropertyService;
	
	@Resource
	private OrgProductPropertyValueService productPropertyValueService;
	
	@Resource
	private OrgClassService classService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, OrgProductTypeQuery query, PageReq pageReq){
		pageReq.setSort(new Sort(Direction.ASC,"t.type_order"));
		Page<OrgProductType> page = productTypeService.queryPageList(query, pageReq);
		productTypeService.addPropertyNum(page.getContent());
		model.addAttribute("page", page);
		OrgProductTypeGroupQuery productTypeGroupQuery = new OrgProductTypeGroupQuery();
		productTypeGroupQuery.setGroupStatus(OrgProductTypeGroupConstant.IS_NOT_DELETE);
		List<OrgProductTypeGroup> groupList = productTypeGroupService.queryList(productTypeGroupQuery);
		model.addAttribute("groupList", groupList);
		model.addAttribute("query", query);
		return "productType/list";
	}
	
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(Model model){
		//类型分组
		OrgProductTypeGroupQuery productTypeGroupQuery = new OrgProductTypeGroupQuery();
		productTypeGroupQuery.setGroupStatus(OrgProductTypeGroupConstant.IS_NOT_DELETE);
		List<OrgProductTypeGroup> groupList = productTypeGroupService.queryList(productTypeGroupQuery);
		model.addAttribute("groupList", groupList);
		//销售规格
		OrgSaleSpecQuery saleSpecQuery = new OrgSaleSpecQuery();
		saleSpecQuery.setIsDelete(OrgSaleSpecConstant.IS_NOT_DELETE);
		List<OrgSaleSpec> saleSpecList = saleSpecService.queryList(saleSpecQuery);
		saleSpecService.addSaleSpecValues(saleSpecList);
		saleSpecService.addSaleSpecValuesStr(saleSpecList);
		model.addAttribute("saleSpecList", saleSpecList);
		return "productType/add";
	}

	@RequestMapping(value = "/addProperty", method = {RequestMethod.GET, RequestMethod.POST})
	public String addProperty(Model model){
		return "productType/addProperty";
	}
	
	@RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
	public String save(OrgProductTypeForm form){
		productTypeService.addProductTypeAndPropery(form);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return "redirect:/productType/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(Model model,
			@PathVariable(value = "id") Integer id){
		OrgProductType productType = productTypeService.queryById(id);
		model.addAttribute("productType", productType);
		//类型分组集合
		OrgProductTypeGroupQuery productTypeGroupQuery = new OrgProductTypeGroupQuery();
		productTypeGroupQuery.setGroupStatus(OrgProductTypeGroupConstant.IS_NOT_DELETE);
		List<OrgProductTypeGroup> groupList = productTypeGroupService.queryList(productTypeGroupQuery);
		model.addAttribute("groupList", groupList);
		//销售规格集合
		OrgSaleSpecQuery saleSpecQuery = new OrgSaleSpecQuery();
		saleSpecQuery.setIsDelete(OrgSaleSpecConstant.IS_NOT_DELETE);
		List<OrgSaleSpec> saleSpecList = saleSpecService.queryList(saleSpecQuery);
		saleSpecService.addSaleSpecValues(saleSpecList);
		saleSpecService.addSaleSpecValuesStr(saleSpecList);
		//已选中销售规格
		OrgProductTypeLinkSaleSpecQuery  productTypeLinkSaleSpecQuery = new OrgProductTypeLinkSaleSpecQuery();
		productTypeLinkSaleSpecQuery.setProductTypeId(id);
		List<OrgProductTypeLinkSaleSpec> productTypeLinkSaleSpecList = productTypeLinkSaleSpecService.queryList(productTypeLinkSaleSpecQuery);
		for(OrgSaleSpec saleSpec:saleSpecList){
			for(OrgProductTypeLinkSaleSpec productTypeLinkSaleSpec:productTypeLinkSaleSpecList){
				if(saleSpec.getSpecId() ==  productTypeLinkSaleSpec.getSpecId()){
					OrgSaleSpecVo saleSpecVo = (OrgSaleSpecVo)saleSpec;
					saleSpecVo.setChecked(true);
				}
			}
		}
		model.addAttribute("saleSpecList", saleSpecList);
		//属性集合
		List<OrgProductProperty>  productPropertyList = productPropertyService.queryPropertyAndValuesByTypeId(id);
		model.addAttribute("productPropertyList", productPropertyList);
		return "productType/edit";
	}
	
	@RequestMapping(value = "/addPropertyForEdit/{typeId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String addPropertyForEdit(Model model,@PathVariable(value = "typeId") Integer typeId){
		model.addAttribute("typeId", typeId);
		return "productType/addPropertyForEdit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/savePropertyForEdit", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> savePropertyForEdit(OrgProductPropertyQuery query){
		productTypeService.addPropertyAndVluesAndLinkType(query);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getPropertyByTypeId/{typeId}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> getPropertyByTypeId(@PathVariable Integer typeId){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("productPropertyList", productPropertyService.queryPropertyAndValuesByTypeId(typeId));
		return result;
	}
	
	@RequestMapping(value = "/eidtPropertyForEdit/{propertyId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String eidtPropertyForEdit(Model model,@PathVariable Integer propertyId){
		model.addAttribute("productProperty", productPropertyService.queryById(propertyId));
		OrgProductPropertyValueQuery productPropertyValueQuery = new OrgProductPropertyValueQuery();
		productPropertyValueQuery.setPropertyId(propertyId);
		model.addAttribute("propertyValueList", productPropertyValueService.queryList(productPropertyValueQuery));
		return "productType/editePropertyForEdit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/updatePropertyForEdit", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> updatePropertyForEdit(OrgProductPropertyQuery query){
		productPropertyService.updatePropertyAndValues(query);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deletePropertyById", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> deletePropertyById(Integer propertyId, Integer typeId){
		productTypeService.deletePropertyAndLinkType(propertyId, typeId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(OrgProductTypeForm form){
		productTypeService.updateProductType(form);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return "redirect:/productType/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> delete(@PathVariable Integer id){
		Map<String, Object> result = new HashMap<String, Object>();
		OrgClass classQuery = new OrgClass();
		classQuery.setClassType(id);
		classQuery.setClassActive(OrgClassConstant.CLASS_ACTIVE);
		long count = classService.queryCount(classQuery);
		if(count > 0){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			result.put("message", "商品分类已关联此类型，不可删除");
		}else{
			productTypeService.deleteType(id);
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("message", "删除成功");
		}
		return result;
	}
	
	@RequestMapping(value = "/view/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String view(Model model, @PathVariable Integer id){
		OrgProductType productType = productTypeService.queryById(id);
		model.addAttribute("productType", productType);
		//类型分组集合
		OrgProductTypeGroupQuery productTypeGroupQuery = new OrgProductTypeGroupQuery();
		productTypeGroupQuery.setGroupStatus(OrgProductTypeGroupConstant.IS_NOT_DELETE);
		List<OrgProductTypeGroup> groupList = productTypeGroupService.queryList(productTypeGroupQuery);
		model.addAttribute("groupList", groupList);
		//销售规格集合
		OrgSaleSpecQuery saleSpecQuery = new OrgSaleSpecQuery();
		saleSpecQuery.setIsDelete(OrgSaleSpecConstant.IS_NOT_DELETE);
		List<OrgSaleSpec> saleSpecList = saleSpecService.queryList(saleSpecQuery);
		saleSpecService.addSaleSpecValues(saleSpecList);
		saleSpecService.addSaleSpecValuesStr(saleSpecList);
		//已选中销售规格
		OrgProductTypeLinkSaleSpecQuery  productTypeLinkSaleSpecQuery = new OrgProductTypeLinkSaleSpecQuery();
		productTypeLinkSaleSpecQuery.setProductTypeId(id);
		List<OrgProductTypeLinkSaleSpec> productTypeLinkSaleSpecList = productTypeLinkSaleSpecService.queryList(productTypeLinkSaleSpecQuery);
		for(OrgSaleSpec saleSpec:saleSpecList){
			for(OrgProductTypeLinkSaleSpec productTypeLinkSaleSpec:productTypeLinkSaleSpecList){
				if(saleSpec.getSpecId() ==  productTypeLinkSaleSpec.getSpecId()){
					OrgSaleSpecVo saleSpecVo = (OrgSaleSpecVo)saleSpec;
					saleSpecVo.setChecked(true);
				}
			}
		}
		model.addAttribute("saleSpecList", saleSpecList);
		//属性集合
		List<OrgProductProperty>  productPropertyList = productPropertyService.queryPropertyAndValuesByTypeId(id);
		model.addAttribute("productPropertyList", productPropertyList);
		return "productType/view";
	}
}
