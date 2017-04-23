package com.kjj.mobile.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.shop.aide.OrgShopSendRangeQuery;
import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.entity.user.aide.OrgUserAddressVo;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.util.PageReq;

@Controller
@RequestMapping("/sendRange")
public class SendRangeController {
	
	@Resource
	private OrgShopSendRangeService orgShopSendRangeService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session,OrgUserAddressVo orgUserAddress) {
		model.addAttribute("userAddress",orgUserAddress);
		return "sendRange/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/load", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> load(Model model,HttpSession session,OrgLocation orgLocation,OrgShopSendRangeQuery query,PageReq pageReq) {
		Map<String,Object> result = new HashMap<String,Object>();
		query.setOrgLocation(orgLocation);
		//距离少于
		query.setDistanceLess(3000d);
		Sort sort = new Sort(Direction.ASC,"distance");
		pageReq.setSort(sort);
		pageReq.setPageSize(10);
		Page<OrgShopSendRange> page = orgShopSendRangeService.queryPageList(query, pageReq);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("pageSendRange", page);
		return result;
	}
}
