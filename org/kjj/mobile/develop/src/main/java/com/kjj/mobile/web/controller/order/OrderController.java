package com.kjj.mobile.web.controller.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
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

import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositVo;
import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordVo;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionVo;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountVo;
import com.kjj.commserver.entity.discount.aide.OrgReachVo;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderForm;
import com.kjj.commserver.entity.order.aide.OrgOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderResult;
import com.kjj.commserver.entity.order.aide.OrgOrderSend;
import com.kjj.commserver.entity.order.aide.OrgOrderUserCount;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseConstant;
import com.kjj.commserver.entity.user.aide.OrgUserAddressConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.swap.WechatPushService;
import com.kjj.commserver.service.user.OrgUserAddressService;
import com.kjj.commserver.util.DateParseUtil;
import com.kjj.commserver.util.ExceptionUtil;
import com.kjj.mobile.constant.BackUrlConstant;
import com.kjj.mobile.constant.CookieConstant;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.CookieUtil;
import com.kjj.mobile.util.PageReq;

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
	private OrgOrderGoodsService orgOrderGoodsService;
	@Resource
	private OrgShopService orgShopService;
	@Resource
	private OrgAccountDepositService orgAccountDepositService;
	@Resource
	private OrgReachService orgReachService;
	@Resource
    private WechatPushService wechatPushService;
	
	@RequestMapping(value = "/addInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(Model model, HttpSession session, HttpServletRequest request, @RequestParam(value="goodsIds",defaultValue="")List<Integer> goodsIds) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//企业用户审核未通过
		if(orgUsersSession.getEnterpriseStatus() != null && (orgUsersSession.getEnterpriseStatus() == OrgEnterpriseConstant.STATUS_BEGIN || orgUsersSession.getEnterpriseStatus() == OrgEnterpriseConstant.STATUS_FALSE)){
			return "enterprise/cantPay";
		}
		
		OrgOrderForm orderFormOld = (OrgOrderForm)session.getAttribute(SessionConstant.SESSION_ORDER_FORM);
		OrgOrderForm orgOrderForm = new OrgOrderForm();
		
		if (CollectionUtils.isEmpty(goodsIds)) {
			if(orderFormOld != null && CollectionUtils.isNotEmpty(orderFormOld.getGoodsIds())){
				goodsIds = (List<Integer>)orderFormOld.getGoodsIds();
				orgOrderForm.setGoodsIds(orderFormOld.getGoodsIds());
			}else{
				return "redirect:/cart/list";
			}
		}else{
			orgOrderForm.setGoodsIds(goodsIds);
		}
		
		//未登录用户登录
		if(!orgUsersSession.isLogin()){
			//登录跳转
			session.setAttribute(SessionConstant.SESSION_LOGIN_BACK_URL, BackUrlConstant.URL_ORDER_INIT);
			session.setAttribute(SessionConstant.SESSION_ORDER_FORM, orgOrderForm);
			return "redirect:/loginInit";
		}
		
		//选中的物品
		List<OrgCartAll> listCartAll = orgCartService.queryList4Select(orgUsersSession,goodsIds);
		orgOrderForm.setListCartAll(listCartAll);
		
		//满减满送
		Map<Integer, OrgReach>  mapReach = orgReachService.updateMap4View(orgUsersSession, listCartAll);
		orgOrderForm.setMapReach(mapReach);
		
		//应收
		BigDecimal accounts = BigDecimal.ZERO;
		//订单金额
		BigDecimal orderMoney = BigDecimal.ZERO;
		//送货取货起始日期
		Date startDate = null;
		//是否包含菜品
		boolean hasMeal = false;
		for(OrgCartAll cart:listCartAll){
			//检查购物车商品状态
			if(!cart.getCanBuy()){
				return "redirect:/cart/list";
			}
			accounts = accounts.add(cart.getOrgProductItemAll().getOrgProductItemAide().getSourcePrice().multiply(BigDecimal.valueOf(cart.getOrgProductItemAll().getOrgProductItemAide().getUserBuy())));
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
		
		orgOrderForm.setAccounts(accounts);
		//订单优惠
		orgOrderForm.setDiscount(accounts.subtract(orderMoney));
		orgOrderForm.setOrderMoneyNoCoupon(orderMoney);
		orgOrderForm.setOrderMoney(orderMoney);
		//送货选项
		OrgOrderSend orgOrderSend = hasMeal ? orgOrderService.getSendOption4Meal(orgUsersSession,startDate) : orgOrderService.getSendOption(orgUsersSession,startDate);
			
		orgOrderForm.setOrgOrderSend(orgOrderSend);
		orgOrderForm.setTakeDate(DateParseUtil.parseDate(orgOrderSend.getDefaultTakeDate()));
		orgOrderForm.setSendDate(DateParseUtil.parseDate(orgOrderSend.getDefaultSendDate()));
		orgOrderForm.setSendTimeStart(DateParseUtil.parseTime(orgOrderSend.getDefaultSendTime()[0]));
		orgOrderForm.setSendTimeEnd(DateParseUtil.parseTime(orgOrderSend.getDefaultSendTime()[1]));
		orgOrderForm.setCanTake(!hasMeal);
		
		//用户预存款
		OrgAccountDepositVo orgAccountDepositVo = orgAccountDepositService.queryVoById4Pay(orgUsersSession.getOrgUsers().getUserId());
		orgOrderForm.setAccountDeposit(orgAccountDepositVo);
		
		//预存款开通提示
		if(orgAccountDepositVo == null){
			OrgAccountDeposit orgAccountDeposit = orgAccountDepositService.queryById(orgUsersSession.getOrgUsers().getUserId());
			if(orgAccountDeposit != null && StringUtils.isBlank(orgAccountDeposit.getPayPassword()) 
					&& (orgAccountDeposit.getFundAmount().add(orgAccountDeposit.getAllowanceAmount())).compareTo(BigDecimal.ZERO) > 0 ){
				model.addAttribute("alertAccountDeposit", true);
			}
		}
				
		//预存款
		if(orgOrderForm.getAccountDeposit() != null && orderMoney.compareTo(BigDecimal.ZERO) > 0
				&& orgOrderForm.getAccountDeposit().getStatus() == OrgAccountDepositConstant.STATUS_VALID){
			if(orgOrderForm.getAccountDeposit().getCanUseAmount().compareTo(orderMoney) > 0){
				orgOrderForm.setDepositMoney(orderMoney);
			}else{
				orgOrderForm.setDepositMoney(orgOrderForm.getAccountDeposit().getCanUseAmount());
			}
		}
		
		//可选优惠券
		List<OrgCouponRecord> listCouponRecord = orgCouponRecordService.queryList4View(orgUsersSession,listCartAll);
		orgOrderForm.setListCouponRecord(listCouponRecord);
		
		//发票
		orgOrderForm.setTakeInvoice(false);
		
		//支付方式
		orgOrderForm.setPayStyle(OrgOrderConstant.PAY_STYLE_ONLINE);
		
		session.setAttribute(SessionConstant.SESSION_ORDER_FORM, orgOrderForm);
		//跳转页面
		session.setAttribute(SessionConstant.SESSION_BACK_URL,BackUrlConstant.URL_ORDER_INIT);
		
		//引导页
		String leadme = CookieUtil.getCookieValue(request, CookieConstant.COOKIE_LEAD_ME_ORDER);
		if (StringUtils.isNotBlank(leadme)) {
			model.addAttribute("leadme", leadme);
		}
		
		return "order/add";
	}
	
	@RequestMapping(value = "/addReInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addReInit(Model model,HttpSession session, HttpServletRequest request, OrgOrderForm orgOrderForm) {
		
		OrgOrderForm orderFormSession  = (OrgOrderForm)session.getAttribute(SessionConstant.SESSION_ORDER_FORM);
		if (orderFormSession != null) {
			//发票
			if(BooleanUtils.isTrue(orgOrderForm.getTakeInvoice())){
				orderFormSession.setTakeInvoice(true);
				orderFormSession.setInvoice(orgOrderForm.getInvoice());
			}else if(BooleanUtils.isFalse(orgOrderForm.getTakeInvoice())){
				orderFormSession.setTakeInvoice(false);
				orderFormSession.setInvoice(null);
			}
			//优惠券
			if(orgOrderForm.getCouponRecordId() != null){
				orderFormSession.setCouponRecordId(orgOrderForm.getCouponRecordId());
				for(OrgCouponRecord couponRecord : orderFormSession.getListCouponRecord()){
					if(orgOrderForm.getCouponRecordId().equals(couponRecord.getRecordId())){
						//订单金额
						orderFormSession.setOrderMoney(orderFormSession.getOrderMoneyNoCoupon().subtract(((OrgCouponRecordVo)couponRecord).getOrgCoupon().getDiscountMoney()));
						//预存款
						if(orderFormSession.getAccountDeposit() != null && orderFormSession.getOrderMoney().compareTo(BigDecimal.ZERO) > 0
								&&  orderFormSession.getAccountDeposit().getStatus() == OrgAccountDepositConstant.STATUS_VALID){
							if(orderFormSession.getAccountDeposit().getCanUseAmount().compareTo(orderFormSession.getOrderMoney()) > 0){
								orderFormSession.setDepositMoney(orderFormSession.getOrderMoney());
							}else{
								orderFormSession.setDepositMoney(orderFormSession.getAccountDeposit().getCanUseAmount());
							}
						}else{
							orderFormSession.setDepositMoney(null);
							orderFormSession.setUseDeposit(false);
						}
						orderFormSession.setCouponRecordSelect(couponRecord);
						break;
					}
				}
			}
			session.setAttribute(SessionConstant.SESSION_ORDER_FORM, orderFormSession);
			//引导页
			String leadme = CookieUtil.getCookieValue(request, CookieConstant.COOKIE_LEAD_ME_ORDER);
			if (StringUtils.isNotBlank(leadme)) {
				model.addAttribute("leadme", leadme);
			}
			return "order/add";
		}else{
			return "redirect:/cart/list";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public Map<String, Object> add(Model model,HttpSession session,OrgOrderForm orgOrderForm) {
		Map<String, Object> result = new HashMap<String, Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgOrderForm orderFormSession  = (OrgOrderForm)session.getAttribute(SessionConstant.SESSION_ORDER_FORM);
		//session失效
		if(orderFormSession == null ){
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "链接超时，请返回购物车重新下单！");
			result.put("cart", true);
			return result;
		}
		//删除session
		session.removeAttribute(SessionConstant.SESSION_ORDER_FORM);
		if(orgOrderForm != null){
			orderFormSession.setTakeDate(orgOrderForm.getTakeDate());
			orderFormSession.setSendDate(orgOrderForm.getSendDate());
			orderFormSession.setSendTimeStart(orgOrderForm.getSendTimeStart());
			orderFormSession.setSendTimeEnd(orgOrderForm.getSendTimeEnd());
			orderFormSession.setConsigneeMobile(orgOrderForm.getConsigneeMobile());
			orderFormSession.setPayStyle(orgOrderForm.getPayStyle());
			orderFormSession.setUseDeposit(orgOrderForm.getUseDeposit());
			orderFormSession.setDepositMoney(orgOrderForm.getDepositMoney());
			orderFormSession.setDepositPassword(orgOrderForm.getDepositPassword());
			orderFormSession.setRemark(orgOrderForm.getRemark());
		}
		
		//后台校验
		if (CollectionUtils.isEmpty(orderFormSession.getGoodsIds())) {
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "购物车不能为空！");
			result.put("cart", true);
			return result;
		}
		
		if (orgUsersSession.getOrgUsers().getLastSendStyle() == OrgUsersConstant.LAST_SEND_STYLE_SEND){
			//送货
			orderFormSession.setSendStyle(OrgOrderConstant.SEND_STYLE_SEND);
			//店铺校验
			OrgShop shop = orgShopService.queryById(orgUsersSession.getOrgShop().getShopId());
			if(shop.getStatus() == OrgShopConstant.STATUS_HIDE ){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "店铺已经失效！请重新选择店铺");
				return result;
			}
			if(orderFormSession.getSendDate() == null || orderFormSession.getSendTimeStart() == null || orderFormSession.getSendTimeEnd() == null ){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "请选择送货日期！");
				return result;
			}
			orderFormSession.setAddressId(orgUsersSession.getOrgUserAddress().getAddressId());
			//地址已经失效的
			OrgUserAddress userAddress = orgUserAddressService.queryById(orderFormSession.getAddressId());
			if(userAddress.getStatus() == OrgUserAddressConstant.STATUS_INVALID ){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "地址已经失效！");
				return result;
			}
			
		}else if(orgUsersSession.getOrgUsers().getLastSendStyle() == OrgUsersConstant.LAST_SEND_STYLE_TAKE){
			//自提
			orderFormSession.setSendStyle(OrgOrderConstant.SEND_STYLE_TAKE);
			orderFormSession.setShopId(orgUsersSession.getOrgShop().getShopId());
			if(orderFormSession.getTakeDate() == null ){
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "请选择自提日期！");
				return result;
			}
			
			if (orderFormSession.getConsigneeMobile() == null) {
				result.put("code", HttpStatusCode.CODE_ERROR);
				result.put("desc", "请输入手机号！");
				return result;
			}
		}else{
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("desc", "请选择取货方式！");
			return result;
		}
		
		if (orderFormSession.getPayStyle() == OrgOrderConstant.PAY_STYLE_ONLINE) {
			orderFormSession.setLocalPayStyle(null);
		}else if(orderFormSession.getPayStyle() == OrgOrderConstant.PAY_STYLE_LOCAL){
			orderFormSession.setLocalPayStyle(OrgOrderConstant.LOCAL_PAY_STYLE_CASH);
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
		
		//来源
		orderFormSession.setSource(OrgOrderConstant.SOURCE_MOBILE);
		//生成订单
		OrgOrderResult orgOrderResult = null;
		try{
			orgOrderResult = orgOrderService.add(orgUsersSession,orderFormSession);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(ExceptionUtil.getStackMsg(e));
		}
		if(orgOrderResult != null && orgOrderResult.getResult()){
			//成功
			//数量
			session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));
			if(orderFormSession.getPayStyle() == OrgOrderConstant.PAY_STYLE_LOCAL || orderFormSession.getPayStatus() == OrgOrderConstant.PAY_STATUS_PAID){
				result.put("code", HttpStatusCode.CODE_SUCCESS);
				result.put("orderId", orderFormSession.getOrderId());
				result.put("onlinePay", false);
				return result;
			}else{
				result.put("code", HttpStatusCode.CODE_SUCCESS);
				result.put("orderId", orderFormSession.getOrderId());
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
				}else{
					session.setAttribute(SessionConstant.SESSION_ORDER_FORM,orderFormSession);
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
	
	@RequestMapping(value = "/invoice", method = { RequestMethod.GET,RequestMethod.POST })
	public String invoice(HttpSession session,OrgOrderForm orgOrderForm){
		OrgOrderForm orderFormSession  = (OrgOrderForm)session.getAttribute(SessionConstant.SESSION_ORDER_FORM);
		//session失效
		if(orderFormSession == null ){
			return "redirect:cart/list";
		}
		if(orgOrderForm != null){
			orderFormSession.setTakeDate(orgOrderForm.getTakeDate());
			orderFormSession.setSendDate(orgOrderForm.getSendDate());
			orderFormSession.setSendTimeStart(orgOrderForm.getSendTimeStart());
			orderFormSession.setSendTimeEnd(orgOrderForm.getSendTimeEnd());
			orderFormSession.setConsigneeMobile(orgOrderForm.getConsigneeMobile());
			orderFormSession.setPayStyle(orgOrderForm.getPayStyle());
			orderFormSession.setUseDeposit(orgOrderForm.getUseDeposit());
			orderFormSession.setRemark(orgOrderForm.getRemark());
		}
		session.setAttribute(SessionConstant.SESSION_ORDER_FORM,orderFormSession);
		return "order/invoice";
	}
	
	@RequestMapping(value = "/desc", method = { RequestMethod.POST,RequestMethod.GET })
	public String desc(HttpSession session,Model model, Integer orderId) {
		model.addAttribute("orderId", orderId);
		OrgOrder order = orgOrderService.queryVoById(orderId);
		model.addAttribute("order", order);
		return "order/desc";
	}
	
	@RequestMapping(value = {"/list","/welist"}, method = {RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model,OrgOrderQuery query,PageReq pageReq) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		
		//计算总订单量
		OrgOrderQuery queryCount = new OrgOrderQuery();
		queryCount.setUserId(orgUsersSession.getOrgUsers().getUserId());
		long orderCount = orgOrderService.queryCount(queryCount);
		
		pageReq.setSort(new Sort(Direction.DESC,"t.order_id"));
		Page<OrgOrder> page = orgOrderService.queryPageList4User(orgUsersSession, query, pageReq);
		
		//订单数量（待付款，待收货，待自提，待评价）
		OrgOrderUserCount userCount = orgOrderService.queryUserCount(orgUsersSession.getOrgUsers().getUserId());
  		model.addAttribute("page",page);
		model.addAttribute("query",query);
		model.addAttribute("userCount",userCount);
		model.addAttribute("orderCount",orderCount);
		return "order/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/listLoad", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> listLoad(HttpSession session,Model model,OrgOrderQuery query,PageReq pageReq) {
		Map<String,Object> result = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		pageReq.setSort(new Sort(Direction.DESC,"t.order_id"));
		//pageReq.setPageSize(3);
		Page<OrgOrder> page = orgOrderService.queryPageList4User(orgUsersSession, query, pageReq);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("pageOrder", page);
		return result;
	}
	
	@RequestMapping(value = "/detail", method = {RequestMethod.GET,RequestMethod.POST })
	public String detail(HttpSession session,Model model,Integer orderId) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//后台校验
		if (orderId == null) {
			return BackUrlConstant.URL_WARNING;
		}
		//获得订单
		OrgOrderVo order = (OrgOrderVo)orgOrderService.queryVoById(orderId);
		
		if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			return BackUrlConstant.URL_WARNING;
		}
		
		//订单商品
		order.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orderId));
		model.addAttribute("order",order);
		
		return "order/detail";
	}
	
	@RequestMapping(value = "/detail4WXMessage/{orderId}", method = {RequestMethod.GET,RequestMethod.POST })
	public String detail4WXMessage(HttpSession session,Model model,@PathVariable Integer orderId) {

		//获得订单
		OrgOrderVo order = (OrgOrderVo)orgOrderService.queryVoById(orderId);
		
		//订单商品
		order.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orderId));
		model.addAttribute("order",order);
		
		return "order/detail4WXMessage";
	}
	
	
	
	@RequestMapping(value = "/cancel", method = {RequestMethod.GET,RequestMethod.POST })
	public String cancel(HttpSession session,Model model,Integer orderId) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//后台校验
		if (orderId == null) {
			return BackUrlConstant.URL_WARNING;
		}
		orgOrderService.updateCancal4User(orgUsersSession,orderId, null);
		// 如果有预存款，就发送消息，否则不发送消息
		OrgOrder order = orgOrderService.queryById(orderId);
		if(null != order.getDepositMoney() && order.getDepositMoney().compareTo(BigDecimal.ZERO) > 0) {
			wechatPushService.refundSuccess(String.valueOf(orderId));
		}
		
		return "redirect:/order/list";
	}
}
