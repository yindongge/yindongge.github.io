package com.kjj.pc.web.controller.order;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.order.OrgGoodsComment;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgGoodsCommentService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource
	private OrgGoodsCommentService orgGoodsCommentService;
	
	@Resource
	private OrgOrderGoodsService  orgOrderGoodsService;
	
	@Resource
	private OrgOrderService orgOrderService;

	@RequestMapping(value = "/addInit/{orderId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(HttpSession session,Model model, @PathVariable Integer orderId){
		
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		OrgOrder order = orgOrderService.queryById(orderId);
		//后台校验
		if(!order.getUserId().equals(user.getOrgUsers().getUserId())){
			return "error/error";
		}
		
		List<OrgOrderGoods> listOrderGoods =orgOrderGoodsService.queryCommentByOrderId(orderId);
		model.addAttribute("listOrderGoods", listOrderGoods);
		
		return "comment/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public int add(HttpSession session, OrgGoodsComment goodsComment){
		
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		OrgOrderGoodsVo orderGoods = orgOrderGoodsService.queryVoById(goodsComment.getOrderGoodsId());
		//后台校验
		if(orderGoods.getOrgOrder().getUserId().equals(user.getOrgUsers().getUserId())  && orderGoods.getCommentStatus().equals(OrgOrderGoodsConstant.COMMENT_STATUS_UNCOMMENT)){
			orgGoodsCommentService.add(goodsComment);
			return HttpStatusCode.CODE_SUCCESS;
		}else{
			return HttpStatusCode.CODE_ERROR;
		}
		
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,PageReq pageReq, Model model, OrgOrderGoodsQuery query){
		
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		query.setUserId(user.getOrgUsers().getUserId());
		
		//评价状态
		if(query.getCommentStatus()== null){
			query.setCommentStatus(OrgOrderGoodsConstant.COMMENT_STATUS_UNCOMMENT);
		}
				
		//订单状态为已完成的
		query.setOrderStatus(OrgOrderConstant.STATUS_FINISH);
		Page<OrgOrderGoods> page = orgOrderGoodsService.queryPageListComment(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "comment/list";
	}
}
