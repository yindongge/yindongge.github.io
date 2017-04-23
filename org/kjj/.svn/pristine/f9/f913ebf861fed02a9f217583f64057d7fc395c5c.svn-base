package com.kjj.manage.web.controller.goods;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgProductTypeLinkSaleSpec;
import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.commserver.entity.goods.OrgSaleSpecValue;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecQuery;
import com.kjj.commserver.service.goods.OrgProductTypeLinkSaleSpecService;
import com.kjj.commserver.service.goods.OrgSaleSpecService;
import com.kjj.commserver.service.goods.OrgSaleSpecValueService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/saleSpec")
public class SaleSpecController {
	
	@Resource
	private OrgSaleSpecService saleSpecService;
	
	@Resource
	private OrgSaleSpecValueService saleSpecValueService;
	
	@Resource
	private OrgProductTypeLinkSaleSpecService productTypeLinkSaleSpecService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, OrgSaleSpecQuery query, PageReq pageReq){
		pageReq.setSort(new Sort(Direction.ASC,"t.spec_order"));
		Page<OrgSaleSpec> page = saleSpecService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		return "saleSpec/list";
	}
	
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(Model model){	
		return "saleSpec/add";
	}
	
	@RequestMapping(value = "/colorpicker", method = {RequestMethod.GET, RequestMethod.POST})
	public String colorpicker(Model model){
		return "saleSpec/colorpicker";
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> save(
			OrgSaleSpec saleSpec,
			@RequestParam(value="specValue") String[] specValues,
			@RequestParam(value="colour") String[] colours){
		List<OrgSaleSpecValue> values = new ArrayList<OrgSaleSpecValue>();
		for(int i=0;i<specValues.length;i++){
			OrgSaleSpecValue value = new OrgSaleSpecValue();
			value.setSpecValue(specValues[i]);
			if(saleSpec.getSpecTypeId() == 2){
				value.setColour(colours[i]);				
			}
			values.add(value);
		}
		saleSpecService.addSaleSpecAndValues(saleSpec, values);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(Model model,@PathVariable Integer id){
		OrgSaleSpec saleSpec = saleSpecService.queryById(id);		
		model.addAttribute("saleSpec", saleSpec);
		List<OrgSaleSpecValue> saleSpecValues = saleSpecValueService.queryBySaleSpecId(id);
		model.addAttribute("saleSpecValues", saleSpecValues);
		return "saleSpec/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> update(OrgSaleSpec saleSpec,
			@RequestParam(value="specValue") String[] specValues,
			@RequestParam(value="colour") String[] colours,
			@RequestParam(value="specValueId") String[] specValueIds,
			@RequestParam(value="isActives") String[] isActives,
			@RequestParam(value="isDeletes") String[] isDeletes){
		List<OrgSaleSpecValue> values = new ArrayList<OrgSaleSpecValue>();
		for(int i=0;i<specValues.length;i++){
			OrgSaleSpecValue value = new OrgSaleSpecValue();
			if(!"".equals(specValueIds[i])){
				value.setSpecValueId(Integer.valueOf(specValueIds[i]));
			}			
			value.setSpecValue(specValues[i]);
			if(saleSpec.getSpecTypeId() == 2){
				value.setColour(colours[i]);				
			}
			value.setIsActive(isActives[i]);
			value.setIsDelete(isDeletes[i]);
			values.add(value);
		}
		saleSpecService.updateSaleSpecAndValues(saleSpec, values);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> delete(@PathVariable Integer id){
		Map<String, Object> result = new HashMap<String, Object>();
		OrgProductTypeLinkSaleSpec productTypeLinkSaleSpecQuery = new OrgProductTypeLinkSaleSpec();
		productTypeLinkSaleSpecQuery.setSpecId(id);
		long count = productTypeLinkSaleSpecService.queryCount(productTypeLinkSaleSpecQuery);
		if(count > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("message", "商品类型关联此销售规格，不可删除");
		}else{
			saleSpecService.deleteSaleSpecAndValues(id);
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			result.put("message", "删除成功");
		}
		return result;
	}

}
