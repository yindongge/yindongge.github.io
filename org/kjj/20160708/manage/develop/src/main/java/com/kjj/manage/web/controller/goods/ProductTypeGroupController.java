package com.kjj.manage.web.controller.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
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

import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.commserver.entity.goods.OrgProductTypeGroup;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeGroupConstant;
import com.kjj.commserver.service.goods.OrgProductTypeGroupService;
import com.kjj.commserver.service.goods.OrgProductTypeService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/productTypeGroup")
public class ProductTypeGroupController {
	
	@Resource
	private OrgProductTypeGroupService productTypeGroupService;
	
	@Resource
	private OrgProductTypeService productTypeService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, OrgProductTypeGroup query, PageReq pageReq){
		query.setGroupStatus(OrgProductTypeGroupConstant.IS_NOT_DELETE);
		pageReq.setSort(new Sort(Direction.ASC, "t.group_order"));
		Page<OrgProductTypeGroup> page = productTypeGroupService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		return "productTypeGroup/list";
	}
	
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(){		
		return "productTypeGroup/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> save(
			@RequestParam(value = "name") List<Object> names,
			@RequestParam(value = "order") List<Object> orders){
		List<OrgProductTypeGroup> list = new ArrayList<OrgProductTypeGroup>();
		OrgProductTypeGroup productTypeGroup = null;
		for(int i=0;i<names.size();i++){
			String name = names.get(i).toString();
			String order = orders.get(i).toString();
			if(StringUtils.isNotEmpty(name)){
				productTypeGroup = new OrgProductTypeGroup();
				productTypeGroup.setGroupStatus(OrgProductTypeGroupConstant.IS_NOT_DELETE);
				productTypeGroup.setOrgproductTypeGroupName(name);
				if(StringUtils.isNotEmpty(order)){
					productTypeGroup.setGroupOrder(Short.valueOf(order));
				}else{
					productTypeGroup.setGroupOrder(Short.valueOf("255"));
				}
				list.add(productTypeGroup);
			}
		}
		productTypeGroupService.addInBatch(list);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(Model model,@PathVariable Integer id){
		OrgProductTypeGroup productTypeGroup = productTypeGroupService.queryById(id);
		model.addAttribute("productTypeGroup", productTypeGroup);
		return "productTypeGroup/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> update(OrgProductTypeGroup query){
		productTypeGroupService.updateByIdSelective(query);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> delete(@PathVariable Integer id){
		Map<String, Object> result = new HashMap<String, Object>();
		OrgProductType productTypeQuery = new OrgProductType();
		productTypeQuery.setGroupId(id);
		productTypeQuery.setIsDelete(OrgProductTypeConstant.IS_NOT_DELETE);
		long count = productTypeService.queryCount(productTypeQuery);
		if(count > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("message", "此分组下有类型，不可删除");
		}else{
			productTypeGroupService.deleteById(id);
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			result.put("message", "删除成功");
		}
		return result;
	}
}
