package com.kjj.manage.web.controller.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgClassLevel;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.commserver.entity.goods.aide.OrgClassQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeConstant;
import com.kjj.commserver.service.goods.OrgClassLevelService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductTypeService;
import com.kjj.manage.constant.HttpStatusCode;

@Controller
@RequestMapping("/class")
public class ClassController {
	
	@Resource
	private OrgClassService classService;
	
	@Resource
	private OrgClassLevelService classLevelService;
	
	@Resource
	private OrgProductTypeService productTypeService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model){
		List<OrgClass> classes = classService.queryListAllAsTree();
		model.addAttribute("classes", classes);
		return "class/list";
	}
	
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(Model model){
		List<OrgClassLevel> classLevelList = classLevelService.queryList(new OrgClassLevel());
		model.addAttribute("classLevelList", classLevelList);
		OrgProductType productTypeQuery = new OrgProductType();
		productTypeQuery.setIsDelete(OrgProductTypeConstant.IS_NOT_DELETE);
		List<OrgProductType> productTypeList = productTypeService.queryList(productTypeQuery);
		model.addAttribute("productTypeList", productTypeList);
		return "class/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getClassesByLevel/{level}", method = {RequestMethod.GET, RequestMethod.POST})
	public List<OrgClass> getClassesByLevel(@PathVariable Byte level){
		List<OrgClass> classList = classService.queryListByLevel(level);
		return classList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getClassesByParent/{parentId}", method = {RequestMethod.GET, RequestMethod.POST})
	public List<OrgClass> getClassesByParent(@PathVariable Integer parentId){
		return classService.queryListByParentId(parentId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> save(OrgClassQuery query){
		classService.add(query);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(Model model,@PathVariable Integer id){
		OrgClass obj = classService.queryById(id);
		model.addAttribute("obj", obj);
		List<OrgClassLevel> classLevelList = classLevelService.queryList(new OrgClassLevel());
		model.addAttribute("classLevelList", classLevelList);
		OrgProductType productTypeQuery = new OrgProductType();
		productTypeQuery.setIsDelete(OrgProductTypeConstant.IS_NOT_DELETE);
		List<OrgProductType> productTypeList = productTypeService.queryList(productTypeQuery);
		model.addAttribute("productTypeList", productTypeList);
		List<OrgClass> parentClassList = classService.queryListByLevel((byte)(obj.getClassLevel()-1));
		model.addAttribute("parentClassList", parentClassList);
		return "class/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> update(OrgClassQuery query){
		classService.update(query);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> delete(@PathVariable Integer id){
		classService.deleteClass(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteValidate/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> deleteValidate(@PathVariable Integer id){
		Map<String, Object> result = new HashMap<String, Object>();
		//校验是否有子分类
		OrgClassQuery query = new OrgClassQuery();
		query.setClassParent(id);
		if(classService.queryList(query).size()>0){
			result.put("code", HttpStatusCode.CODE_ERROR);
		}else{
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}
		return result;
	}

}
