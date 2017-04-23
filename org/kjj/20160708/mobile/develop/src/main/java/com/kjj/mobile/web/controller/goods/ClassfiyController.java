package com.kjj.mobile.web.controller.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.mobile.constant.HttpStatusCode;

@Controller
@RequestMapping("/classfiy")
public class ClassfiyController {
	
	@Resource
	private OrgClassService orgClassService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST })
	public String list(Model model) {
		List<OrgClass> listClassLevelOne =  orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		List<OrgClass> listClassLevelTwo = null;
		if(CollectionUtils.isNotEmpty(listClassLevelOne)){
			listClassLevelTwo = orgClassService.queryListByParentId(listClassLevelOne.get(0).getClassId());
		}
		model.addAttribute("listClassLevelOne",listClassLevelOne);
		model.addAttribute("listClassLevelTwo",listClassLevelTwo);
		return "classfiy/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getByParentId", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> userinfo(Integer parentId) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<OrgClass> listClassLevelTwo = orgClassService.queryListByParentId(parentId);
		result.put("listClassLevelTwo", listClassLevelTwo);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}

}
