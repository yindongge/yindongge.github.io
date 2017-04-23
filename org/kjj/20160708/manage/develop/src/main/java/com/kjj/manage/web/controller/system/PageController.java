package com.kjj.manage.web.controller.system;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.system.OrgModel;
import com.kjj.commserver.entity.system.aide.OrgModelVo;
import com.kjj.commserver.service.system.OrgModelService;
import com.kjj.manage.constant.SessionConstant;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@Resource
	private OrgModelService orgModelService;
	
	@RequestMapping(value ="/head", method = { RequestMethod.GET, RequestMethod.POST })
	public String head(Model model){
		return "page/head";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/left", method = { RequestMethod.GET, RequestMethod.POST })
	public String left(Model model,HttpSession session,int modelid){
		Map<Integer,OrgModelVo> mapModel = (Map<Integer,OrgModelVo>)session.getAttribute(SessionConstant.SESSION_ADMIN_MODEL);
		int defaultModelid = 9000;
		if(defaultModelid - modelid == 0){
			modelid = 2;
		}
		List<OrgModel> menu = mapModel.get(modelid).getModelList();
		model.addAttribute("menu", menu);
		return "page/left";
	}
	
	@RequestMapping(value ="/right", method = { RequestMethod.GET, RequestMethod.POST })
	public String right(){
		return "page/right";
	}
}

