package com.kjj.manage.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.system.OrgModel;
import com.kjj.commserver.entity.system.aide.OrgModelConstant;
import com.kjj.commserver.service.system.OrgModelService;
import com.kjj.commserver.service.system.OrgRoleRightService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Resource
	private OrgModelService orgModelService;
	@Resource
	private OrgRoleRightService orgRoleRightService;

	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, PageReq pageReq){	
		List<OrgModel> list = orgModelService.queryTreeByParentId(OrgModelConstant.ROOT_ID);
		model.addAttribute("list", list);
		return "menu/list";
	}
	
	@RequestMapping(value = "/addInit", method = {RequestMethod.GET, RequestMethod.POST})
	public String addInit(Model model,@RequestParam(value="pageNow", defaultValue="1") String pageNow){
		//获取活动分类
		model.addAttribute("list", orgModelService.queryTreeByParentId(OrgModelConstant.ROOT_ID));
		return "menu/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> add(Model model,OrgModel orgModel){	
		Map<String,Object>	result = new HashMap<String, Object>();
		orgModelService.add(orgModel);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value = "/editInit", method = {RequestMethod.GET, RequestMethod.POST})
	public String editInit(Model model, Integer modelid){	
		model.addAttribute("obj", orgModelService.queryById(modelid));
		model.addAttribute("list", orgModelService.queryTreeByParentId(OrgModelConstant.ROOT_ID));
		return "menu/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> update(Model model,OrgModel orgModel,Integer modelid){	
		Map<String,Object>	result = new HashMap<String, Object>();
		orgModelService.updateByIdSelective(orgModel);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public int delete(Integer modelid){	
		orgModelService.deleteById(modelid);
		return HttpStatusCode.CODE_SUCCESS;
	}
}
