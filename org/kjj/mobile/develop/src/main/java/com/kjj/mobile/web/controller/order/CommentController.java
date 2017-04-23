package com.kjj.mobile.web.controller.order;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.order.OrgGoodsComment;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgGoodsCommentService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource
	private OrgGoodsCommentService orgGoodsCommentService;
	
	@Resource
	private OrgOrderGoodsService  orgOrderGoodsService;
	
	@Resource
	private OrgOrderService orgOrderService;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String add(HttpSession session, OrgGoodsComment goodsComment){	
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		//获取订单商品关联信息
		OrgOrderGoodsVo orderGoods = orgOrderGoodsService.queryVoById(goodsComment.getOrderGoodsId());
		//后台校验
		if(orderGoods.getOrgOrder().getUserId().equals(user.getOrgUsers().getUserId())  && orderGoods.getCommentStatus().equals(OrgOrderGoodsConstant.COMMENT_STATUS_UNCOMMENT)){
			orgGoodsCommentService.add(goodsComment);
		}
		return "redirect:/comment/list";
		
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session, Model model, OrgOrderGoodsQuery query){
		
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		query.setUserId(user.getOrgUsers().getUserId());
		//评价状态，默认未评价
		if(query.getCommentStatus()== null){
			query.setCommentStatus(OrgOrderGoodsConstant.COMMENT_STATUS_UNCOMMENT);
		}
		//只允许评价已完成的订单
		query.setOrderStatus(OrgOrderConstant.STATUS_FINISH);
		List<OrgOrderGoods> list = orgOrderGoodsService.queryListComment(query);
		//获取未评价，已评价数量
		long countCanComment = orgOrderGoodsService.queryCountCanCommentByUserId(user.getOrgUsers().getUserId());
		long countCanNotComment = orgOrderGoodsService.queryCountCanNotCommentByUserId(user.getOrgUsers().getUserId());
		model.addAttribute("countCanComment", countCanComment);
		model.addAttribute("countCanNotComment", countCanNotComment);
		model.addAttribute("list", list);
		model.addAttribute("query", query);	
		return "comment/list";
	}
}
