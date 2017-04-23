package com.kjj.pc.web.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("error")
public class ErrorController {
	
	@RequestMapping(value = "/404", method = {RequestMethod.GET,RequestMethod.POST })
	public String error404(Model model) {
		model.addAttribute("errorCode", "404");
		return "error/error";
	}
	@RequestMapping(value = "/500", method = {RequestMethod.GET,RequestMethod.POST })
	public String error500(Model model) {
		model.addAttribute("errorCode", "500");
		return "error/error";
	}
	
	@RequestMapping(value = "/error", method = {RequestMethod.GET,RequestMethod.POST })
	public String error(Model model) {
		return "error/error";
	}
}
