package com.kjj.manage.web.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryQuery;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.OrgOrderLog;
import com.kjj.commserver.entity.order.OrgSolveOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsVo;
import com.kjj.commserver.entity.order.aide.OrgOrderLogConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderLogVo;
import com.kjj.commserver.entity.order.aide.OrgOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.goods.OrgProductInventoryService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderLogService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.swap.WechatPushService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.ManagePropertiesUtil;
import com.kjj.manage.util.PageReq;
import com.kjj.manage.util.QrcodeUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	OrgOrderService orgOrderService;
	
	@Resource
	private OrgOrderLogService orgOrderLogService;
	
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@Resource
	private OrgCouponRecordService osrgCouponRecordService;
	
	@Resource
	private OrgCouponRecordService orgCouponRecordService;
	
	@Resource
	private OrgProductInventoryService orgProductInventoryService;
	
	@Resource
    private WechatPushService wechatPushService;
	
	@Resource
	private OrgShopService orgShopService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model, PageReq pageReq,OrgOrderQuery query){
			
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		query.setShopIds(admin.getShopIds());
		model.addAttribute("query", query);
		pageReq.setPageSize(20);
		pageReq.setSort(new Sort(Direction.DESC,"t.order_id"));
		Page<OrgOrder> page = orgOrderService.queryPageList4Admin(admin, query, pageReq);
		model.addAttribute("page", page);
		return "order/list";
	}
	
	@RequestMapping(value = "/detail/{orderId}", method = { RequestMethod.GET })
	public String detail(Model model,@PathVariable Integer orderId){
		
		OrgOrderVo orderVo = (OrgOrderVo) orgOrderService.queryVoById(orderId);
		orderVo.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orderId));
		model.addAttribute("order", orderVo);
		
		//订单日志
		List<OrgOrderLog> listOrderLog = orgOrderLogService.query4AdminByOrderId(orderId);
		model.addAttribute("listOrderLog", listOrderLog);
		
		//确认订单的日志
		OrgOrderLog confirmLog = null;
		//取消订单的日志
		OrgOrderLog sendLog = null;
		OrgOrderLogVo logVo = null;
		for(OrgOrderLog log : listOrderLog){
			logVo = (OrgOrderLogVo)log;
			if(logVo.getLogSource()== OrgOrderLogConstant.SOURCE_USER){
				logVo.setAdminName("用户");
			}else if(logVo.getLogSource() == OrgOrderLogConstant.SOURCE_SYSTEM){
				logVo.setAdminName("系统");
			}
			//添加日志链
			if(log.getLogType() == OrgOrderLogConstant.TYPE_ADMIN_CONFIRE || log.getLogType() == OrgOrderLogConstant.TYPE_SYSTEM_CONFIRE){
				confirmLog = log;
			}else if(log.getLogType() == OrgOrderLogConstant.TYPE_ADMIN_SEND){
				sendLog = log;
			}
		}
		model.addAttribute("confirmLog", confirmLog);
		model.addAttribute("sendLog", sendLog);
		
		OrgCouponRecord couponRecord = orgCouponRecordService.queryOneByOrderId(orderId);
		model.addAttribute("couponRecord", couponRecord);
		
		return "order/detail";
	}
	@ResponseBody
	@RequestMapping(value = "/confirm", method = { RequestMethod.POST })
	public Map<String,Object> confirm(Integer orderId,String logDetail,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		if(orgOrderService.updateConfirm(orderId,logDetail,admin)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！订单状态已改变，请刷新");
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/sendOrTake", method = { RequestMethod.POST })
	public Map<String,Object> sendOrTake(Integer orderId,String logDetail,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgOrderService.updateSendOrTake(orderId,logDetail,admin)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！订单状态已改变，请刷新");
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/finish", method = { RequestMethod.POST })
	public Map<String,Object> finish(Integer orderId,String logDetail,String takeCode,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgOrderService.updateFinish(orderId,logDetail,takeCode,admin)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！订单状态已改变，请刷新");
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/cancel", method = { RequestMethod.POST })
	public Map<String,Object> cancel(Integer orderId,String logDetail,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		if(orgOrderService.updateCancel4Admin(orderId,logDetail,admin)){
			// 取消订单时，可能发生退款
			wechatPushService.refundSuccess(String.valueOf(orderId));
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！订单状态已改变，请刷新");
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/remark", method = { RequestMethod.POST })
	public Map<String,Object> remark(Integer orderId,String logDetail,HttpSession session) {
		
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		orgOrderService.updateRemark(orderId,logDetail,admin);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/consignee", method = { RequestMethod.POST })
	public Map<String,Object> consignee(OrgOrder order,HttpSession session) {
		
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		orgOrderService.updateConsignee(order,admin);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/solve2Server", method = { RequestMethod.POST })
	public Map<String,Object> solve2Server(OrgSolveOrder orgSolveOrder,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		orgOrderService.updateSolve2Server(orgSolveOrder,admin);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/solveCancel", method = { RequestMethod.POST })
	public Map<String,Object> solveCancel(OrgSolveOrder orgSolveOrder,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		if(orgOrderService.updateSolveCancel(orgSolveOrder,admin)){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}else{
			result.put("desc", "非法操作！订单状态已改变，请刷新");
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/solve2Shop", method = { RequestMethod.POST })
	public Map<String,Object> solve2Shop(OrgSolveOrder orgSolveOrder,HttpSession session) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		orgOrderService.updateSolve2Shop(orgSolveOrder,admin);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}	
	
	@RequestMapping(value = "/print/{orderId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String print(HttpSession session,Model model,@PathVariable(value = "orderId") String orderId){
		OrgOrderVo orgOrderVo = orgOrderService.queryVoById(Integer.parseInt(orderId));
		List<OrgOrderGoods> orderGoodsList = orgOrderGoodsService.queryByOrderId(Integer.parseInt(orderId));
		OrgProductInventoryQuery query =new OrgProductInventoryQuery();
		query.setShopCode(orgOrderVo.getOrgShop().getShopCode());
		OrgOrderGoodsVo orgOrderGoodsVo=null;
		int totalNum=0;
		for (OrgOrderGoods orgOrderGoods : orderGoodsList) {
			orgOrderGoodsVo=(OrgOrderGoodsVo) orgOrderGoods;
			query.setGoodsSn(orgOrderGoods.getGoodsSn());
			//根据管理员负责的店铺Id及商品goodsSn获得库存信息，并从库存信息中获得条形码。
			orgOrderGoodsVo.setBarcode(orgProductInventoryService.queryOne(query).getBarcode());
			totalNum+=orgOrderGoods.getAmount();
		}
		orgOrderVo.setListOrderGoods(orderGoodsList);
		orgOrderVo.setTotalNum(totalNum);
		model.addAttribute("order", orgOrderVo);
		String qrcodeUrl="";
		model.addAttribute("qrcode", qrcodeUrl);
		return "order/printSendList";
	}
	
	//打印送货单页面呈现二维码（订单链接微信版，方便店铺管理员操作订单）
	@RequestMapping(value = "/code/{orderId}", method = { RequestMethod.GET,RequestMethod.POST })
	public void code(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer orderId) {
		String wxPath = ManagePropertiesUtil.getProperty("wx.path");
		String codeUrl=wxPath+"/orderAdmin/detail4Admin/"+orderId;
		QrcodeUtil.encodeQrcode(codeUrl, response);
	}
	
}
