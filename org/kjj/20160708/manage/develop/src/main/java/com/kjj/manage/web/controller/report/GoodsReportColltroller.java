package com.kjj.manage.web.controller.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.aide.OrgGoodsReportVo;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/goodsReport")
public class GoodsReportColltroller {
	
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@Resource
	private OrgShopService orgShopService;
	
	@RequestMapping(value = "/list" , method= { RequestMethod.GET , RequestMethod.POST}) 
	public String list(Model model,PageReq pageReq,OrgOrderGoodsQuery query){
		query.setQueryStatus(OrgOrderConstant.STATUS_FINISH);
		pageReq.setPageSize(15);
		Page<OrgGoodsReportVo> page = orgOrderGoodsService.queryPageList4GoodsReport(query,pageReq);
		List<OrgShop> shopList = orgShopService.queryListAll();
		model.addAttribute("page", page);
		model.addAttribute("query",query);
		model.addAttribute("shopList",shopList);
		return "goodsReport/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/exportExcel",method = {RequestMethod.POST, RequestMethod.GET})
	public Map<String, Object> exportExcel(OrgOrderGoodsQuery query){
		query.setQueryStatus(OrgOrderConstant.STATUS_FINISH);
		String downloadUrl = orgOrderGoodsService.exportExcel(query);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("downloadUrl", downloadUrl);
		return result;
	}
}
