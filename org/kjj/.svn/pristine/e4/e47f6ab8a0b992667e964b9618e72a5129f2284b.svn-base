package com.kjj.pc.web.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.pc.constant.HttpStatusCode;

@Controller
@RequestMapping("/area")
public class AreaController {
	
	@Resource
	private OrgAreaService  orgAreaService;
	
	@ResponseBody
	@RequestMapping(value = "/getByParentCode", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> getByParentCode(Model model,String parentCode) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<OrgArea> listArea = orgAreaService.queryListByParentCode(parentCode);
		result.put("listArea", listArea);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	} 
}
