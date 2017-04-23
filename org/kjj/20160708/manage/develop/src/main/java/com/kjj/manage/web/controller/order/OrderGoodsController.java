package com.kjj.manage.web.controller.order;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/orderGoods")
public class OrderGoodsController {
	
	
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model, PageReq pageReq,OrgOrderGoodsQuery query){
		
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		query.setShopIds(admin.getShopIds());
		model.addAttribute("query", query);
		
		pageReq.setPageSize(20);
		pageReq.setSort(new Sort(Direction.DESC,"t.id"));
		Page<OrgOrderGoods> page = orgOrderGoodsService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		
		return "orderGoods/list";
	}
	
}
