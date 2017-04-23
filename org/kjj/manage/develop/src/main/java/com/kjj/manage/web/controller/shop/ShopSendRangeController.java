package com.kjj.manage.web.controller.shop;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.manage.constant.HttpStatusCode;

@Controller
@RequestMapping("/shop/sendRange")
public class ShopSendRangeController {

	@Autowired
	private OrgShopSendRangeService orgShopSendRangeService;

	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> add(OrgShopSendRange orgShopSendRange) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgShopSendRangeService.add(orgShopSendRange);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("desc", orgShopSendRange.getId());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> edit(OrgShopSendRange orgShopSendRange) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgShopSendRangeService.updateByIdSelective(orgShopSendRange);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> del(Integer id, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgShopSendRangeService.deleteById(id);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}
