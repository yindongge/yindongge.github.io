package com.kjj.manage.web.controller.activity;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjj.commserver.entity.activity.OrgActivity;
import com.kjj.commserver.entity.activity.aide.OrgActivityQuery;
import com.kjj.commserver.service.activity.OrgActivityService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Resource
	private OrgActivityService orgActivityService;


	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list( Model model,HttpSession session,PageReq pageReq,OrgActivityQuery query ) {
		Page<OrgActivity> page = orgActivityService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		return "/activity/list";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit( Model model,HttpSession session) {
		return "activity/add";
	}

	@RequestMapping(value = "/edit/{id}/{pageNumber}", method = { RequestMethod.GET,RequestMethod.POST })
	public String edit( Model model,HttpSession session,@PathVariable Integer id, @PathVariable Integer pageNumber) {
		OrgActivity orgActivity = orgActivityService.queryById(id);
		model.addAttribute("orgActivity", orgActivity);
		model.addAttribute("pageNumber", pageNumber);
		return "activity/edit";
	}

	@RequestMapping(value = "/save", method = { RequestMethod.GET,RequestMethod.POST })
	public String save(Model model,HttpSession session,OrgActivity orgActivity,PageReq pageReq,RedirectAttributes redirectAttributes) {
		if(orgActivity.getId()==null){
			orgActivityService.add(orgActivity);
		}else{
			orgActivityService.updateByIdSelective(orgActivity);
		}
		redirectAttributes.addAttribute("pageNumber", pageReq.getPageNumber());
		return "redirect:/activity/list";
	}

	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> delete(@PathVariable Integer id) {
		orgActivityService.deleteById(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}