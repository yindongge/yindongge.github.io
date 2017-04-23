package com.kjj.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.manage.constant.HttpStatusCode;

@Controller
@RequestMapping("/xxx")
public class XxxController {

//	@Resource
//	private XxxService xxxService;


	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(HttpSession session, HttpServletResponse response, Model model) {
		List<Object>  list = new ArrayList<Object>();
		model.addAttribute("list", list);
		return "xxx/list";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String add(HttpSession session, HttpServletResponse response,Model model) {
		return "xxx/add";
	}

	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String edit(@PathVariable Integer id, Model model) {
		List<Object>  list = new ArrayList<Object>();
		model.addAttribute("list", list);
		return "xxx/edit";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> save(Model model) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> delete(@PathVariable Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;

	}
}