package com.kjj.pc.web.controller.order;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.commserver.entity.order.OrgReturnOrderLog;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderLogVo;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgRefundOrderService;
import com.kjj.commserver.service.order.OrgReturnOrderLogService;
import com.kjj.commserver.service.order.OrgReturnOrderService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.util.DateFormatUtil;
import com.kjj.commserver.util.UUIDUtils;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/return")
public class ReturnController {
	
	@Resource
	private OrgReturnOrderService orgReturnOrderService;
	@Resource
	private OrgRefundOrderService orgRefundOrderService;
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgReturnOrderLogService orgReturnOrderLogService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session,OrgReturnOrderQuery query,PageReq pageReq) {
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		query.setUserId(user.getOrgUsers().getUserId());
		pageReq.setSort(new Sort(Direction.DESC,"t.return_order_id"));
		Page<OrgReturnOrder> page = orgReturnOrderService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "return/list";
	}
	
	@RequestMapping(value = "/show/{reOrderId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String show(Model model,HttpSession session,@PathVariable Integer reOrderId) {
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		OrgOrder order = orgOrderService.queryById(reOrderId);
		if(!order.getUserId().equals(user.getOrgUsers().getUserId())){
			return "error/error";
		}
		model.addAttribute("order",order);

		List<OrgOrderGoods> listOrderGoods = orgOrderGoodsService.query4ReturnByOrderId(reOrderId);
		model.addAttribute("listOrderGoods",listOrderGoods);
		
		return "return/show";
	}
	
	@RequestMapping(value = "/addInit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(Model model,HttpSession session, @PathVariable Integer id) {
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		OrgOrderGoods orderGoods = orgOrderGoodsService.queryVoById(id);
		
		//后台校验
		//退货数量不能大于买的数量
		if(orderGoods.getReturnAmount() >= orderGoods.getAmount()){
			return "error/error";
		}
		model.addAttribute("orderGoods",orderGoods);
		
		OrgOrderVo order = orgOrderService.queryVoById(orderGoods.getOrderId());
		model.addAttribute("order",order);
		
		//后台校验
		if(!order.getUserId().equals(user.getOrgUsers().getUserId())){
			return "error/error";
		}
		
		OrgShopVo  shop = orgShopService.queryVoById(order.getShopId());
		model.addAttribute("shop",shop);
		
		//联系方式
		String returnTel = "";
		if(StringUtils.isNotEmpty(order.getConsigneeMobile())){
			returnTel = order.getConsigneeMobile();
		}else if(StringUtils.isNotEmpty(order.getConsigneeTel())){
			returnTel = order.getConsigneeTel();
		}
		model.addAttribute("returnTel",returnTel);
		
		return "return/add";
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String add(Model model,HttpSession session,OrgReturnOrder returnOrder,@RequestParam(value="returnImgUrl",defaultValue="") List<String> listImgUrl) {
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		OrgOrderGoods orderGoods = orgOrderGoodsService.queryById(returnOrder.getOrderGoodsId());
		//退货数量不能大于买的数量
		if(orderGoods.getReturnAmount()+returnOrder.getAmount() > orderGoods.getAmount()){
			return "error/error";
		}
				
		OrgOrderVo order = orgOrderService.queryVoById(orderGoods.getOrderId());
		
		//后台校验
		if(!order.getUserId().equals(user.getOrgUsers().getUserId())){
			return "error/error";
		}
		if (orderGoods.getAmount() <= orderGoods.getReturnAmount()) {
			return "error/error";
		}
		
		if(returnOrder.getReturnTel() == null){
			if(StringUtils.isNotBlank(order.getConsigneeMobile())){
				returnOrder.setReturnTel(order.getConsigneeMobile());
			}else if(StringUtils.isNotBlank(order.getConsigneeTel())){
				returnOrder.setReturnTel(order.getConsigneeTel());
			}
		}
		
		returnOrder.setOrderId(order.getOrderId());
		returnOrder.setOrderSerialNo(order.getSerialNo());
		returnOrder.setUserId(order.getUserId());
		returnOrder.setShopId(order.getShopId());
		returnOrder.setGoodsId(orderGoods.getGoodsId());
		returnOrder.setGoodsSn(orderGoods.getGoodsSn());
		
		orgReturnOrderService.addByUser(returnOrder,listImgUrl);
		
		return "redirect:/return/list";
	}
	
	@RequestMapping(value = "/detail/{returnOrderId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String detail(HttpSession session,Model model,@PathVariable Integer returnOrderId){
		
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		//后台校验
		if (returnOrderId == null) {
			return "error/error";
		}
		
		OrgReturnOrder returnOrder = orgReturnOrderService.queryVoById(returnOrderId);
		
		//后台校验
		if (!returnOrder.getUserId().equals(user.getOrgUsers().getUserId())) {
			return "error/error";
		}
		
		//退换货订单日志
		List<OrgReturnOrderLog> listReturnOrderLog = orgReturnOrderLogService.queryByReturnOrderId(returnOrder.getReturnOrderId());
		OrgReturnOrderLogVo logVo = null;
		for(OrgReturnOrderLog log : listReturnOrderLog){
			logVo = (OrgReturnOrderLogVo)log;
			//显示替换
			logVo.setTypeShow(logVo.getTypeShow().replace("{admin_name}",logVo.getAdminName() == null ? "" : logVo.getAdminName()));
			logVo.setTypeShow(logVo.getTypeShow().replace("{create_time}", DateFormatUtil.formatDateTime(returnOrder.getCreateTime())));
			logVo.setTypeShow(logVo.getTypeShow().replace("{return_time}", DateFormatUtil.formatDateTime(returnOrder.getReturnTime())));
			logVo.setTypeShow(logVo.getTypeShow().replace("{log_detail}", logVo.getLogDetail() == null ? "" : logVo.getLogDetail()));
			logVo.setTypeShow(logVo.getTypeShow().replace("{reply}", returnOrder.getReply() == null ? "" : returnOrder.getReply()));

		}
		
		OrgOrderGoods orderGoods = orgOrderGoodsService.queryVoById(returnOrder.getOrderGoodsId());
		
		model.addAttribute("listReturnOrderLog", listReturnOrderLog);
		model.addAttribute("returnOrder", returnOrder);
		model.addAttribute("orderGoods", orderGoods);
		
		return "return/detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public Map<String,Object> uploadImage(MultipartFile file,HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> mapResult = new HashMap<String,Object>();
		if (!file.isEmpty()) {
			String filenName = UUIDUtils.create() + "_.jpg";
			File targetFile = new File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.RETURN_GOODS, filenName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			
			try {
				file.transferTo(targetFile);
				mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
				mapResult.put("url", ImageConstant.IMAGE_BASE_URL + ImageConstant.RETURN_GOODS + filenName);
				mapResult.put("returnImgUrl", ImageConstant.RETURN_GOODS + filenName);
			} catch (Exception e) {
				mapResult.put("code", HttpStatusCode.CODE_ERROR);
			}
			
		} else {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
		}
		return mapResult;
	}
}
