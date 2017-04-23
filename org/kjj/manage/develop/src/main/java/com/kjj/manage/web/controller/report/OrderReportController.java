package com.kjj.manage.web.controller.report;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.report.aide.OrgOrderReportQuery;
import com.kjj.commserver.service.report.OrgOrderReportService;
import com.kjj.manage.constant.HttpStatusCode;

@Controller
@RequestMapping("/orderReport")
public class OrderReportController {
	
	@Resource
	private OrgOrderReportService orgOrderReportService;
	
	@RequestMapping(value="/index", method = {RequestMethod.GET, RequestMethod.POST})
	public String index(Model model){
		return "orderReport/export";
	}
	
	@ResponseBody
	@RequestMapping(value="/export", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> export(OrgOrderReportQuery query){
		Map<String, Object> result = new HashMap<String, Object>();
		String downloadUrl = orgOrderReportService.exportOrderExcel(query);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("downloadUrl", downloadUrl);
		return result;
	}

}
