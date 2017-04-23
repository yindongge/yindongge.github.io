package com.kjj.pc.web.controller.activity;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.service.goods.OrgClassService;

@Controller
public class ActivityController {
	
	@Resource
	private OrgClassService orgClassService;
	
	@RequestMapping(value = "/activity/{actName}", method = {RequestMethod.GET, RequestMethod.POST})
	public String activity(Model model,@PathVariable(value = "actName")String actName){	
		//分类信息
	    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    model.addAttribute("listClass", listClass);
	    model.addAttribute("htmlPage", "/html/"+actName+"/index.html");
		return "activity/activity";
	}
}
