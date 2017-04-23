package com.kjj.pc.web.controller.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.kjj.commserver.entity.account.aide.OrgAccountDepositConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositVo;
import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionVo;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountVo;
import com.kjj.commserver.entity.discount.aide.OrgReachVo;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderLog;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderForm;
import com.kjj.commserver.entity.order.aide.OrgOrderLogConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderLogTypeChain;
import com.kjj.commserver.entity.order.aide.OrgOrderLogVo;
import com.kjj.commserver.entity.order.aide.OrgOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderResult;
import com.kjj.commserver.entity.order.aide.OrgOrderSend;
import com.kjj.commserver.entity.order.aide.OrgOrderUserCount;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseConstant;
import com.kjj.commserver.entity.user.aide.OrgUserAddressConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderLogService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.swap.WechatPushService;
import com.kjj.commserver.service.user.OrgEnterpriseService;
import com.kjj.commserver.service.user.OrgUserAddressService;
import com.kjj.commserver.util.DateFormatUtil;
import com.kjj.commserver.util.ExceptionUtil;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	/** 日志记录 */
	protected static final Log logger = LogFactory.getLog(OrderController.class);
	
	public static final int CODE_ERROR_DEPOSIT = 500;
	
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgCartService orgCartService;
	@Resource
	private OrgShopSendRangeService orgShopSendRangeService;
	@Resource
	private OrgUserAddressService orgUserAddressService;
	@Resource
	private OrgCouponRecordService orgCouponRecordService;
	@Resource
	private OrgOrderLogService orgOrderLogService;
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgEnterpriseService orgEnterpriseService;
	@Resource
	private OrgAccountDepositService orgAccountDepositService;
	@Resource
	private OrgReachService orgReachService;
	@Resource
    private WechatPushService wechatPushService;
	
	@RequestMapping(value = "/addInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(Model model,HttpSession session,@RequestParam(value="goodsIds",defaultValue="")List<Integer> goodsIds) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		//企业用户审核未通过
		if(orgUsersSession.getEnterpriseStatus() != null && (orgUsersSession.getEnterpriseStatus() == OrgEnterpriseConstant.STATUS_BEGIN || orgUsersSession.getEnterpriseStatus() == OrgEnterpriseConstant.STATUS_FALSE)){
			
			return "redirect:/security/desc";
		}
		
		if (CollectionUtils.isEmpty(goodsIds)) {
			return "error/error";
		}
		
		//配送范围
		List<OrgShopSendRange> listSendRange = orgShopSendRangeService.queryList4User(orgUsersSession);
		
		//本店有效收货地址列表
		List<OrgUserAddress> listThisVaildAddress = orgUserAddressService.getThisShopVaildByUser(orgUsersSession);
		
		//本店无效收货地址列表
		List<OrgUserAddress> listThisInvaildAddress = orgUserAddressService.getThisShopInvaildByUser(orgUsersSession);
		
		//其他店地址列表
		List<OrgUserAddress> listOtherAddress = orgUserAddressService.getOtherShopByUser(orgUsersSession);
		
		//选中的物品
		List<OrgCartAll> listCart = orgCartService.queryList4Select(orgUsersSession,goodsIds);
		//满减满送
		Map<Integer, OrgReach>  mapReach = orgReachService.updateMap4View(orgUsersSession, listCart);

		//当前选择的物品购物车为空
		if (CollectionUtils.isEmpty(listCart)) {
			return "redirect:/cart/list";
		}
		
		//计算订单金额
		BigDecimal orderMoney = BigDecimal.ZERO;
		//送货取货起始日期
		Date startDate = null;
		//是否包含菜品
		boolean hasMeal = false;
		for(OrgCartAll cart:listCart){
			orderMoney = orderMoney.add(cart.getOrgProductItemAll().getOrgProductItemAide().getRealPrice().multiply(BigDecimal.valueOf(cart.getOrgProductItemAll().getOrgProductItemAide().getUserBuy())));
			if (!hasMeal) {
				hasMeal = cart.getOrgProductItemAll().getOrgProductItemAide().getMarkMeal();
			}
		}
		//满减满送平衡金额
		OrgReachVo orgReachVo = null;
		OrgReachConditionVo orgReachConditionVo = null;
		OrgReachDiscountVo orgReachDiscountVo = null;
		for(Map.Entry<Integer, OrgReach> entryReach : mapReach.entrySet()){
			orgReachVo = (OrgReachVo)entryReach.getValue();
			orgReachConditionVo = (OrgReachConditionVo)orgReachVo.getOrgReachCondition();
			if(orgReachConditionVo != null && orgReachConditionVo.getMapReachDiscount().containsKey(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY))){
				orgReachDiscountVo = (OrgReachDiscountVo)orgReachConditionVo.getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY));
				orderMoney = orderMoney.subtract(orgReachDiscountVo.getBalance());
			}
		}
		
		//送货选项
		OrgOrderSend orgOrderSend = hasMeal ? orgOrderService.getSendOption4Meal(orgUsersSession,startDate) : orgOrderService.getSendOption(orgUsersSession,startDate);
		
		//可选优惠券
		List<OrgCouponRecord> listCouponRecord = orgCouponRecordService.queryList4View(orgUsersSession,listCart);
		
		//用户预存款
		OrgAccountDepositVo accountDeposit = orgAccountDepositService.queryVoById4Pay(orgUsersSession.getOrgUsers().getUserId());
		model.addAttribute("goodsIds",goodsIds);
		model.addAttribute("listSendRange",listSendRange);
		model.addAttribute("listThisVaildAddress",listThisVaildAddress);
		model.addAttribute("listThisInvaildAddress",listThisInvaildAddress);
		model.addAttribute("listOtherAddress",listOtherAddress);
		model.addAttribute("listCart",listCart);
		model.addAttribute("orderMoney",orderMoney);
		model.addAttribute("orgOrderSend",orgOrderSend);
		model.addAttribute("listCouponRecord",listCouponRecord);
		model.addAttribute("canTake",!hasMeal);
		model.addAttribute("accountDeposit",accountDeposit);
		model.addAttribute("mapReach",mapReach);
		
		return "order/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public Map<String, Object> add(Model model,HttpSession session,OrgOrderForm orgOrderForm) {
		Map<String, Object> result = new HashMap<String, Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		//后台校验
		if (CollectionUtils.isEmpty(orgOrderForm.getGoodsIds())) {
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "购物车不能为空！");
			result.put("cart", true);
			return result;
		}
		
		//店铺校验
		OrgShop shop = orgShopService.queryById(orgUsersSession.getOrgShop().getShopId());
		if(shop.getStatus() == OrgShopConstant.STATUS_HIDE ){
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "店铺已经失效！请重新选择店铺");
			result.put("cart", true);
			return result;
		}
		
		if (orgOrderForm.getSendStyle() == OrgOrderConstant.SEND_STYLE_SEND) {
			if(orgOrderForm.getSendDate() == null || orgOrderForm.getSendTimeStart() == null || orgOrderForm.getSendTimeEnd() == null ){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "请选择送货日期！");
				return result;
			}
			
			if (orgOrderForm.getAddressId() == null) {
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "请选择配送地址！");
				return result;
			}
			
			//地址已经失效的
			OrgUserAddress userAddress = orgUserAddressService.queryById(orgOrderForm.getAddressId());
			if(userAddress.getStatus() == OrgUserAddressConstant.STATUS_INVALID ){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "地址已经失效！");
				return result;
			}
			
			
		}else if(orgOrderForm.getSendStyle() == OrgOrderConstant.SEND_STYLE_TAKE){
			if(orgOrderForm.getTakeDate() == null ){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "请选择自提日期！");
				return result;
			}
			
			if (orgOrderForm.getConsigneeMobile() == null) {
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "请输入手机号！");
				return result;
			}
		}else{
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "请选择取货方式！");
			return result;
		}
		
		if (orgOrderForm.getPayStyle() == OrgOrderConstant.PAY_STYLE_ONLINE) {
			orgOrderForm.setLocalPayStyle(null);
		}else if(orgOrderForm.getPayStyle() == OrgOrderConstant.PAY_STYLE_LOCAL){
			if(orgOrderForm.getLocalPayStyle() != OrgOrderConstant.LOCAL_PAY_STYLE_CASH && orgOrderForm.getLocalPayStyle() != OrgOrderConstant.LOCAL_PAY_STYLE_POS){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "请选择支付方式！");
				return result;
			}
		}else{
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "请选择支付方式！");
			return result;
		}
		
		//预存款
		if (orgOrderForm.getUseDeposit() && orgOrderForm.getDepositMoney() != null) {
			if(orgOrderForm.getDepositMoney().compareTo(BigDecimal.ZERO) == 0){
				orgOrderForm.setUseDeposit(false);
			}else if(orgOrderForm.getDepositMoney().compareTo(BigDecimal.ZERO) < 0){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "预存款错误！");
				return result;
			}
		}
		
		//发票
		if(BooleanUtils.isNotTrue(orgOrderForm.getTakeInvoice())){
			orgOrderForm.setInvoice(null);
		}
		//来源
		orgOrderForm.setSource(OrgOrderConstant.SOURCE_PC);
		
		//生成订单
		OrgOrderResult orgOrderResult = null;
		try{
			orgOrderResult = orgOrderService.add(orgUsersSession,orgOrderForm);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(ExceptionUtil.getStackMsg(e));
		}
		
		if(orgOrderResult != null && orgOrderResult.getResult()){
			//成功
			if(orgOrderForm.getPayStyle() == OrgOrderConstant.PAY_STYLE_LOCAL || orgOrderForm.getPayStatus() == OrgOrderConstant.PAY_STATUS_PAID){
				result.put("code", HttpStatusCode.CODE_SUCCESS);
				result.put("orderId", orgOrderForm.getOrderId());
				result.put("onlinePay", false);
				return result;
			}else{
				result.put("code", HttpStatusCode.CODE_SUCCESS);
				result.put("orderId", orgOrderForm.getOrderId());
				result.put("onlinePay", true);
				return result;
			}
		}else{
			if(orgOrderResult != null && orgOrderResult.getDepositStatus() != null){
				//预付费失败
				result.put("code", CODE_ERROR_DEPOSIT);
				result.put("desc", orgOrderResult.getFailDesc());
				if(orgOrderResult.getDepositStatus() != OrgAccountDepositConstant.CHARGE_STATUS_PASSWORDERROR){
					result.put("cart", true);
				}
				return result;
			}else{
				//失败
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "订单生成失败！请重新尝试下单");
				result.put("cart", true);
				return result;
			}
		}
	}
	
	@RequestMapping(value = "/desc", method = { RequestMethod.POST,RequestMethod.GET })
	public String desc(HttpSession session,Model model, Integer orderId) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//后台校验
		if (orderId == null) {
			return "error/error";
		}
		
		OrgOrder order = orgOrderService.queryVoById(orderId);
		
		if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			return "error/error";
		}
		
		model.addAttribute("order",order);
		long cartCount = orgCartService.getCountByUser(orgUsersSession);
		model.addAttribute("cartCount",cartCount);
		return "order/desc";
	}
	
	@RequestMapping(value = "/cancel", method = {RequestMethod.GET,RequestMethod.POST })
	public String cancel(HttpSession session,Model model,Integer orderId,String logDetail) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//后台校验
		if (orderId == null) {
			return "error/error";
		}
		orgOrderService.updateCancal4User(orgUsersSession,orderId, logDetail);
		// 如果有预存款，就发送消息，否则不发送消息
		OrgOrder order = orgOrderService.queryById(orderId);
		if(null != order.getDepositMoney() && order.getDepositMoney().compareTo(BigDecimal.ZERO) > 0) {
			wechatPushService.refundSuccess(String.valueOf(orderId));
		}
		return "redirect:/order/list";
	}
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model,OrgOrderQuery query,PageReq pageReq) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		pageReq.setPageSize(10);
		pageReq.setSort(new Sort(Direction.DESC,"t.order_id"));
		Page<OrgOrder> page = orgOrderService.queryPageList4User(orgUsersSession, query, pageReq);
		OrgOrderUserCount userCount = orgOrderService.queryUserCount(orgUsersSession.getOrgUsers().getUserId());
		model.addAttribute("page",page);
		model.addAttribute("query",query);
		model.addAttribute("userCount",userCount);
		return "order/list";
	}
	
	@RequestMapping(value = "/detail/{orderId}", method = {RequestMethod.GET })
	public String detail(HttpSession session,Model model, @PathVariable Integer orderId) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//后台校验
		if (orderId == null) {
			return "error/error";
		}
		
		OrgOrderVo order = (OrgOrderVo)orgOrderService.queryVoById(orderId);
		//店铺
		OrgShop shop = orgShopService.queryVoById(order.getShopId());
		//订单商品
		order.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orderId));
		
		if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			return "error/error";
		}
		
		List<OrgOrderLog> listLog = orgOrderLogService.query4UserByOrderId(orderId);
		//日志链
		Map<OrgOrderLogTypeChain,Date> mapChain = new EnumMap<OrgOrderLogTypeChain,Date>(OrgOrderLogTypeChain.class);
		//取消订单的日志
		OrgOrderLog cancelLog = null;
		OrgOrderLogVo logVo = null;
		for(OrgOrderLog log : listLog){
			logVo = (OrgOrderLogVo)log; 
			//显示替换
			logVo.setTypeShow(logVo.getTypeShow().replace("{admin_name}",logVo.getAdminName() == null ? "" : logVo.getAdminName()));
			logVo.setTypeShow(logVo.getTypeShow().replace("{shop_name}", order.getOrgShop().getShopName()));
			logVo.setTypeShow(logVo.getTypeShow().replace("{create_time}", DateFormatUtil.formatDateTime(order.getCreateTime())));
			logVo.setTypeShow(logVo.getTypeShow().replace("{pay_time}", DateFormatUtil.formatDateTime(order.getPayTime())));
			logVo.setTypeShow(logVo.getTypeShow().replace("{send_date}", DateFormatUtil.formatDate(order.getSendDate())));
			logVo.setTypeShow(logVo.getTypeShow().replace("{send_time_start}", DateFormatUtil.formatTime(order.getSendTimeStart())));
			logVo.setTypeShow(logVo.getTypeShow().replace("{send_time_end}", DateFormatUtil.formatTime(order.getSendTimeEnd())));
			logVo.setTypeShow(logVo.getTypeShow().replace("{take_date}", DateFormatUtil.formatDate(order.getTakeDate())));
			logVo.setTypeShow(logVo.getTypeShow().replace("{log_detail}", logVo.getLogDetail() == null ? "" : logVo.getLogDetail()));
		
			//添加日志链
			if(logVo.getLogType() == OrgOrderLogConstant.TYPE_USER_ONLINE_PAY_SUCCESS){
				if(order.getPayStyle() == OrgOrderConstant.PAY_STYLE_ONLINE){
					mapChain.put(OrgOrderLogTypeChain.CHAIN_TYPE_ONLINE_PAY,logVo.getLogTime());
				}
			}else if(logVo.getLogType() == OrgOrderLogConstant.TYPE_ADMIN_CONFIRE || logVo.getLogType() == OrgOrderLogConstant.TYPE_SYSTEM_CONFIRE){
				mapChain.put(OrgOrderLogTypeChain.CHAIN_TYPE_CONFIRE,logVo.getLogTime());
			}else if(logVo.getLogType() == OrgOrderLogConstant.TYPE_USER_FINISH || logVo.getLogType() == OrgOrderLogConstant.TYPE_ADMIN_FINISH){
				mapChain.put(OrgOrderLogTypeChain.CHAIN_TYPE_FINISH,logVo.getLogTime());
			}else if(logVo.getLogType() == OrgOrderLogConstant.TYPE_USER_CANCEL || logVo.getLogType() == OrgOrderLogConstant.TYPE_ADMIN_CANCEL || logVo.getLogType() == OrgOrderLogConstant.TYPE_SYSTEM_TIMEOUT_COLSE){
				cancelLog = log;
			}
		}
		
		//补充日志链
		//付款成功
		if(order.getPayStyle() == OrgOrderConstant.PAY_STYLE_ONLINE && !mapChain.containsKey( OrgOrderLogTypeChain.CHAIN_TYPE_ONLINE_PAY)){
			if(order.getPayStatus() == OrgOrderConstant.PAY_STATUS_PAID){
				mapChain.put(OrgOrderLogTypeChain.CHAIN_TYPE_ONLINE_PAY, order.getPayTime());
			}else{
				mapChain.put(OrgOrderLogTypeChain.CHAIN_TYPE_ONLINE_PAY, null);
			}
		}
		//确认
		if(!mapChain.containsKey( OrgOrderLogTypeChain.CHAIN_TYPE_CONFIRE)){
			mapChain.put(OrgOrderLogTypeChain.CHAIN_TYPE_CONFIRE, null);
		}
		//完成
		if(!mapChain.containsKey( OrgOrderLogTypeChain.CHAIN_TYPE_FINISH)){
			mapChain.put(OrgOrderLogTypeChain.CHAIN_TYPE_FINISH, null);
		}
		
		model.addAttribute("order",order);
		model.addAttribute("shop",shop);
		model.addAttribute("listLog",listLog);
		model.addAttribute("cancelLog",cancelLog);
		model.addAttribute("mapChain",mapChain);
		
		return "order/detail";
	}
}
