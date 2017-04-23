package com.kjj.commserver.service.order.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.order.OrgOrderDao;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsConstant;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.OrgReachCoupon;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionVo;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountVo;
import com.kjj.commserver.entity.discount.aide.OrgReachVo;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.OrgSolveOrder;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderForm;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderLogConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderResult;
import com.kjj.commserver.entity.order.aide.OrgOrderSend;
import com.kjj.commserver.entity.order.aide.OrgOrderUserCount;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.order.aide.OrgSolveOrderConstant;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.aide.OrgUserAddressVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.discount.OrgLimitTimeRecordService;
import com.kjj.commserver.service.discount.OrgReachCouponOrderService;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.goods.OrgProductInventoryService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderLogService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgRefundOrderService;
import com.kjj.commserver.service.order.OrgSolveOrderService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.swap.RxOrderService;
import com.kjj.commserver.service.swap.WechatPushService;
import com.kjj.commserver.service.user.OrgUserAddressService;
import com.kjj.commserver.util.DateFormatUtil;
import com.kjj.commserver.util.DateParseUtil;
import com.kjj.commserver.util.IdUtil;
import com.kjj.commserver.util.SmsUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgOrderServiceImpl extends BaseServiceImpl<OrgOrder, Integer> implements OrgOrderService {
    @Resource
    private OrgOrderDao orgOrderDao;
    @Resource
    private OrgCartService orgCartService;
    @Resource
    private OrgCouponRecordService orgCouponRecordService;
    @Resource
    private OrgUserAddressService orgUserAddressService;
    @Resource
    private OrgLimitTimeRecordService orgLimitTimeRecordService;
    @Resource
    private OrgOrderLogService orgOrderLogService;
    @Resource
    private WechatPushService wechatPushService;
    @Resource
    private OrgOrderGoodsService orgOrderGoodsService;
    @Resource
    private RxOrderService rxOrderService;
    @Resource
    private OrgRefundOrderService orgRefundOrderService;
    @Resource
    private OrgSolveOrderService orgSolveOrderService;
    @Resource
    private OrgProductInventoryService orgProductInventoryService;
    @Resource
    private OrgShopService orgShopService;
    @Resource
    private OrgAccountDepositService orgAccountDepositService;
    @Resource
    private OrgReachService orgReachService;
    @Resource
    private OrgReachCouponOrderService orgReachCouponOrderService;
    
    @Override
    protected BaseDao<OrgOrder, Integer> getBaseDao() {
        return orgOrderDao;
    }
    
    @Override
    public OrgOrder lockQueryById(Integer orderId){
    	return orgOrderDao.selectById4Update(orderId);
    }

	@Override
	public OrgOrderResult add(OrgUsersSession orgUsersSession, OrgOrderForm orgOrderForm) {
		//判断能否下单
		OrgOrderResult orderResult = new OrgOrderResult();
		orderResult.setResult(false);
		//平衡金额初始化
		orgOrderForm.setBalance(BigDecimal.ZERO);
		//下单商品数据
		List<OrgCartAll>  listCartAll = null;
		//满减赠送优惠券
		Map<Integer,Integer> mapReachCoupon = new HashMap<Integer,Integer>();
		if(CollectionUtils.isEmpty(orgOrderForm.getGoodsIds())){
			//无商品
			orderResult.setResult(false);
		}else{
			//下单时查询并修改用户下单商品数据(包含库存，优惠等全部信息) 查询同时会更新本地库存，添加限时折扣记录
			listCartAll = orgCartService.updateList4Buy(orgUsersSession, orgOrderForm.getGoodsIds());
			//满减
			Map<Integer, OrgReach> mapReach = orgReachService.updateMap4Buy(orgUsersSession, listCartAll);
			OrgReachDiscountVo reachDiscountVo = null;
			for(OrgReach reach : mapReach.values()){
				//减钱
				reachDiscountVo = (OrgReachDiscountVo)((OrgReachConditionVo)(((OrgReachVo)reach).getOrgReachCondition())).getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY));
				if(reachDiscountVo != null){
					orgOrderForm.setBalance(orgOrderForm.getBalance().add(reachDiscountVo.getBalance()));
				}
				//赠优惠券
				reachDiscountVo = (OrgReachDiscountVo)((OrgReachConditionVo)(((OrgReachVo)reach).getOrgReachCondition())).getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_COUPON));
				if(reachDiscountVo != null){
					for(OrgReachCoupon orgReachCoupon : reachDiscountVo.getListReachCoupon()){
						if(mapReachCoupon.containsKey(orgReachCoupon.getCouponId())){
							mapReachCoupon.put(orgReachCoupon.getCouponId(), mapReachCoupon.get(orgReachCoupon.getCouponId())+reachDiscountVo.getDiscountMultiple());
						}else{
							mapReachCoupon.put(orgReachCoupon.getCouponId(), reachDiscountVo.getDiscountMultiple());
						}
					}
				}
			}
			//查询商品是否都可买
			if(!isAllowBuy(listCartAll)){
				//无货或限制购买
				orderResult.setResult(false);
			}else{
				//使用优惠券
				if(orgOrderForm.getCouponRecordId() != null && orgOrderForm.getCouponRecordId() != 0){
					BigDecimal couponBalanceMoney = orgCouponRecordService.update4Buy(orgUsersSession, listCartAll, orgOrderForm.getCouponRecordId());
					if(couponBalanceMoney == null){
						//优惠券使用失败
						orderResult.setResult(false);
					}else{
						//优惠券使用成功
						orderResult.setResult(true);
						orgOrderForm.setBalance(orgOrderForm.getBalance().add(couponBalanceMoney));
					}
				}else{
					//没有使用优惠券
					orderResult.setResult(true);
				}
			}
		}
		
		//满足生成订单条件
		if(orderResult.getResult()){
			//获取用户
			orgOrderForm.setUserId(orgUsersSession.getOrgUsers().getUserId());
			//获取店铺
			orgOrderForm.setShopId(orgUsersSession.getOrgShop().getShopId());
			//流水号
			orgOrderForm.setSerialNo(new IdUtil(1,1).nextId());
			//支付状态
			orgOrderForm.setPayStatus(OrgOrderConstant.PAY_STATUS_UNPAID);
			//评价状态
			orgOrderForm.setCommentStatus(OrgOrderConstant.COMMENT_STATUS_UNCOMMENT);
			//退货状态
			orgOrderForm.setReturnStatus(OrgOrderConstant.RETURN_STATUS_OPEN);
			//创建时间
			orgOrderForm.setCreateTime(new Date());
			//设置订单金额数据和限制支付时间
			setOrderMoneysAndLimitPayTime(orgOrderForm,listCartAll);
			//订单金额校验
			if(orgOrderForm.getOrderMoney().compareTo(BigDecimal.ZERO) < 0
					|| orgOrderForm.getDepositMoney().compareTo(BigDecimal.ZERO) < 0
					|| orgOrderForm.getPayMoney().compareTo(BigDecimal.ZERO) < 0){
				//失败处理
				orderResult.setResult(false);
				orderResult.setFailDesc("订单错误！");
			}
			//支付密码校验
			if(orgOrderForm.getPayMoney().compareTo(BigDecimal.ZERO) == 0
					&& orgOrderForm.getDepositMoney().compareTo(BigDecimal.ZERO) > 0
					&& StringUtils.isBlank(orgOrderForm.getDepositPassword())){
				//失败处理
				orderResult.setResult(false);
				orderResult.setFailDesc("订单错误！");
			}
			
			if(orderResult.getResult()){
				//设置地址信息
				setOrderAddress(orgOrderForm);
				//设置送货取货时间
				setSendOrTakeTime(orgOrderForm);
				//订单状态
				orgOrderForm.setStatus(OrgOrderConstant.STATUS_CREATE);
				//评论状态
				orgOrderForm.setCommentStatus(OrgOrderConstant.COMMENT_STATUS_UNCOMMENT);
				if(orgOrderForm.getPayStyle() == OrgOrderConstant.PAY_STYLE_LOCAL){
					//如果是货到付款的话，订单设为待确认状态
					orgOrderForm.setStatus(OrgOrderConstant.STATUS_WAIT_CONFIRM);
				}
				
				add(orgOrderForm);
				
				//预付款支付
				if(orgOrderForm.getDepositMoney().compareTo(BigDecimal.ZERO) > 0){
					Map<String, Object> mapResultAccountDeposit = orgAccountDepositService.updateAddOrder(OrgAccountDepositRecordsConstant.ORIGIN_ONLINE_SHOP,orgUsersSession.getOrgUsers().getUserCode(), orgOrderForm.getDepositMoney(), orgOrderForm.getDepositPassword(), orgOrderForm.getOrderId().toString());
					if((Integer)mapResultAccountDeposit.get("status") != OrgAccountDepositConstant.CHARGE_STATUS_SUCCESS){
						//失败处理
						orderResult.setResult(false);
						orderResult.setDepositStatus((Integer)mapResultAccountDeposit.get("status"));
						deleteById(orgOrderForm.getOrderId());
					}
				}
				
				if(orderResult.getResult()){
					//修改限时折扣记录订单号
					orgLimitTimeRecordService.add4Order(listCartAll,orgOrderForm.getOrderId(),orgUsersSession);
					
					//修改优惠券状态
					if (orgOrderForm.getCouponRecordId() != null && orgOrderForm.getCouponRecordId() > 0) {
						orgCouponRecordService.updateUsed(orgUsersSession,orgOrderForm.getCouponRecordId(),orgOrderForm.getOrderId());
					}
					
					//购物车删除已购商品
					orgCartService.deleteBatchAfterBuy(listCartAll);
					//添加生成订单日志
					orgOrderLogService.addByUser(orgOrderForm.getOrderId(), orgOrderForm.getUserId(),OrgOrderLogConstant.TYPE_USER_CREATE, null);
					
					//赠送优惠券
					if(MapUtils.isNotEmpty(mapReachCoupon)){
						orgReachCouponOrderService.addInBatch(orgOrderForm.getOrderId(),mapReachCoupon);
					}
					
					//如果网上支付订单金额为0,算做支付成功
					if(orgOrderForm.getPayStyle() == OrgOrderConstant.PAY_STYLE_ONLINE && orgOrderForm.getPayMoney().compareTo(BigDecimal.ZERO) == 0){
						//按支付成功处理
						updatePayOnline(orgOrderForm, OrgOrderConstant.ONLINE_PAY_STYLE_WITHOUT);
					}
					//如果是货到付款的话
					if(orgOrderForm.getPayStyle() == OrgOrderConstant.PAY_STYLE_LOCAL){
						//给店员推送消息
						wechatPushService.addPushOrder(orgOrderForm);
					}
					//添加订单商品明细及发送给瑞星
					orgOrderGoodsService.addBatch(orgUsersSession,orgOrderForm,listCartAll);
				}
			}
		}
		
		//更新库存
		if(orderResult.getResult()){
			orgProductInventoryService.updateAfterBuy(listCartAll);
		}else{
			orgProductInventoryService.updateAfterCantBuy(listCartAll);
		}
		
		//设置失败说明
		setFailDesc(orderResult);
		return orderResult;
	}
	
	/**
	 * 设置订单失败说明
	 * @param orderResult
	 */
	private void setFailDesc(OrgOrderResult orderResult){
		if(orderResult.getDepositStatus() != null){
			switch (orderResult.getDepositStatus()) {
			case OrgAccountDepositConstant.CHARGE_STATUS_INVALID:
				orderResult.setFailDesc("账户不存在");
				break;
			case OrgAccountDepositConstant.CHARGE_STATUS_NOTENOUGH:
				orderResult.setFailDesc("余额不足");
				break;
			case OrgAccountDepositConstant.CHARGE_STATUS_PASSWORDERROR:
				orderResult.setFailDesc("支付密码错误");
				break;
			case OrgAccountDepositConstant.CHARGE_STATUS_LOCK:
				orderResult.setFailDesc("密码输错超过3次，您的余额账户已被锁定，第二日0点自动恢复或联系客服：4000-306-603");
				break;
			case OrgAccountDepositConstant.GLOBAL_STATUS_PARAMETERERROR:
				orderResult.setFailDesc("参数错误");
				break;
			case OrgAccountDepositConstant.CHARGE_STATUS_SC_EXIST:
				orderResult.setFailDesc("订单已经存在");
				break;
			case OrgAccountDepositConstant.CHARGE_STATUS_NOPASSWORD:
				orderResult.setFailDesc("没有支付密码");
				break;
			default:
				orderResult.setFailDesc("");
				break;
			}
		}
	}
	
	@Override
	public void updatePayOnline(Integer orderId,Byte onlinePayStyle) {
		OrgOrder orgOrder = lockQueryById(orderId);
		updatePayOnline(orgOrder,onlinePayStyle);
	}
	
	/**
	 * 网上支付成功处理
	 * @param orgOrder
	 * @param onlinePayStyle
	 */
	private void updatePayOnline(OrgOrder orgOrder,Byte onlinePayStyle) {
		//未处理订单进行处理（网上支付可能会多次发送成功消息）
		if(orgOrder.getStatus() == OrgOrderConstant.STATUS_CREATE){
			//修改订单状态
			orgOrder.setPayStatus(OrgOrderConstant.PAY_STATUS_PAID);
			orgOrder.setStatus(OrgOrderConstant.STATUS_WAIT_CONFIRM);
			orgOrder.setOnlinePayStyle(onlinePayStyle);
			orgOrder.setPayTime(new Date());
			//自提取货码
			if(orgOrder.getSendStyle() == OrgOrderConstant.SEND_STYLE_TAKE){
				orgOrder.setTakeCode(RandomStringUtils.randomNumeric(6));
			}
			updateById(orgOrder);
			
			//添加订单支付成功日志
			orgOrderLogService.addByUser(orgOrder.getOrderId(),orgOrder.getUserId(),OrgOrderLogConstant.TYPE_USER_ONLINE_PAY_SUCCESS, "网上支付方式为："+onlinePayStyle);
			
			//发送短信
			if(orgOrder.getSendStyle() == OrgOrderConstant.SEND_STYLE_TAKE){
				if(StringUtils.isNotEmpty(orgOrder.getConsigneeMobile())){
					SmsUtil.sendTakeCodeMessage(orgOrder.getConsigneeMobile(), orgOrder.getTakeCode(), String.valueOf(orgOrder.getOrderId()));
				}
			}
			
			//给店员推送消息
			wechatPushService.addPushOrder(orgOrder);
		}
	}

	/**
	 * 设置订单金额数据和限制支付时间
	 * @param orgOrderForm
	 * @param listCartAll
	 */
	private void setOrderMoneysAndLimitPayTime(OrgOrderForm orgOrderForm,List<OrgCartAll>  listCartAll){
		//应收
		BigDecimal accounts = BigDecimal.ZERO;
		//实收(不包含配送费)
		BigDecimal realMoney = BigDecimal.ZERO;
		//限时支付
		Short limitPayTime = Short.MAX_VALUE;
		OrgProductItemAide itemAide = null;
		for(OrgCartAll cartALL:listCartAll){
			itemAide = cartALL.getOrgProductItemAll().getOrgProductItemAide();
			//限时支付
			if(itemAide.getLimitPayTime() != null){
				if(limitPayTime > itemAide.getLimitPayTime() ){
					limitPayTime = itemAide.getLimitPayTime() ;
				}
			}
			accounts = accounts.add(itemAide.getSourcePrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
			realMoney = realMoney.add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
		}
		//订单应收
		orgOrderForm.setAccounts(accounts);
		realMoney = realMoney.subtract(orgOrderForm.getBalance());
		//订单优惠
		orgOrderForm.setDiscount(accounts.subtract(realMoney));
		//订单配送费
		//配送费
		orgOrderForm.setSendMoney(BigDecimal.ZERO);
		//订单金额
		orgOrderForm.setOrderMoney(realMoney.add(orgOrderForm.getSendMoney()));
		//预付费金额
		if(orgOrderForm.getDepositMoney() == null || !orgOrderForm.getUseDeposit()){
			orgOrderForm.setDepositMoney(BigDecimal.ZERO);
		}
		//预付费退款累计
		orgOrderForm.setDepositRefund(BigDecimal.ZERO);
		//支付金额
		orgOrderForm.setPayMoney(orgOrderForm.getOrderMoney().subtract(orgOrderForm.getDepositMoney()));
		//设置网上支付订单付款时长限制
		if(orgOrderForm.getPayStyle() == OrgOrderConstant.PAY_STYLE_ONLINE && limitPayTime != Short.MAX_VALUE){
			orgOrderForm.setLimitPayTime(limitPayTime);
		}
	}
	
	/**
	 * 设置送货地址信息
	 * @param orgOrderForm
	 */
	private void setOrderAddress(OrgOrderForm orgOrderForm){
		if (orgOrderForm.getSendStyle() == OrgOrderConstant.SEND_STYLE_SEND) {
			OrgUserAddressVo userAddress = (OrgUserAddressVo)orgUserAddressService.queryVoById(orgOrderForm.getAddressId());
			orgOrderForm.setConsignee(userAddress.getConsignee());
			orgOrderForm.setConsigneeAddress(userAddress.getSendRangeName()+userAddress.getAddress());
			orgOrderForm.setConsigneeEmail(userAddress.getEmail());
			if(userAddress.getTel() != null && !"".equals(userAddress.getTel())){
				orgOrderForm.setConsigneeTel(userAddress.getTelAreaCode()+"-"+userAddress.getTel());
			}
			orgOrderForm.setConsigneeMobile(userAddress.getMobile());
		}
	}
	
	/**
	 * 设置送货取货时间
	 * @param orgOrderForm
	 */
	private void setSendOrTakeTime(OrgOrderForm orgOrderForm){
		if(orgOrderForm.getSendStyle() == OrgOrderConstant.SEND_STYLE_SEND){
			//送货时间
			orgOrderForm.setTakeDate(null);
		}else{
			//取货时间
			orgOrderForm.setSendDate(null);
			orgOrderForm.setSendTimeStart(null);
			orgOrderForm.setSendTimeEnd(null);
		}
	}
	
	/***
	 * 查询商品是否都有货
	 * @param listCartAll
	 * @return
	 */
	private boolean isAllowBuy(List<OrgCartAll>  listCartAll){
		//查询商品是否都有货
		boolean allCanbuy = true;
		if(CollectionUtils.isNotEmpty(listCartAll)){
			for(OrgCartAll cartAll:listCartAll){
				if(!cartAll.getCanBuy()){
					allCanbuy = false;
					break;
				}
			}
		}else{
			allCanbuy = false;
		}
		return allCanbuy;
	}

	@Override
	public OrgOrderSend getSendOption(OrgUsersSession orgUsersSession,Date startSendDate) {
		OrgOrderSend send = new OrgOrderSend();	
		OrgShop shop = orgShopService.queryVoById(orgUsersSession.getOrgShop().getShopId());
		String[] date = new String[7];
		String[] week = new String[7];
		Boolean[] isTake = new Boolean[7];
		String defaultSendDate = "";
		String defaultSendWeek = "";
		String[] defaultSendTime = new String[2];
		String defaultTakeDate = "";
		String defaultTakeWeek = "";
		String openTime = "";
		
		//判断非空时间个数
		int timeLength = 0;
		if(shop.getSendTimeAmStart() != null && shop.getSendTimeAmEnd() != null){
			timeLength ++ ;
		}
		if(shop.getSendTimeNoonStart() != null && shop.getSendTimeNoonEnd() != null){
			timeLength ++ ;
		}
		if(shop.getSendTimePmStart() != null && shop.getSendTimePmEnd() != null){
			timeLength ++ ;
		}
		if(shop.getSendTimeNightStart() != null && shop.getSendTimeNightEnd() != null){
			timeLength ++ ;
		}
		
		//送货时间
		String[][] time = new String[timeLength][2];
		timeLength = 0;
		if(shop.getSendTimeAmStart() != null && shop.getSendTimeAmEnd() != null){
			time[timeLength][0] = DateFormatUtil.formatTime(shop.getSendTimeAmStart());
			time[timeLength][1] = DateFormatUtil.formatTime(shop.getSendTimeAmEnd());
			timeLength ++ ;
		}
		if(shop.getSendTimeNoonStart() != null && shop.getSendTimeNoonEnd() != null){
			time[timeLength][0] = DateFormatUtil.formatTime(shop.getSendTimeNoonStart());
			time[timeLength][1] = DateFormatUtil.formatTime(shop.getSendTimeNoonEnd());
			timeLength ++ ;
		}
		if(shop.getSendTimePmStart() != null && shop.getSendTimePmEnd() != null){
			time[timeLength][0] = DateFormatUtil.formatTime(shop.getSendTimePmStart());
			time[timeLength][1] = DateFormatUtil.formatTime(shop.getSendTimePmEnd());
			timeLength ++ ;
		}
		if(shop.getSendTimeNightStart() != null && shop.getSendTimeNightEnd() != null){
			time[timeLength][0] = DateFormatUtil.formatTime(shop.getSendTimeNightStart());
			time[timeLength][1] = DateFormatUtil.formatTime(shop.getSendTimeNightEnd());
			timeLength ++ ;
		}
		
		//是否可送
		Boolean[][] isSend = new Boolean[timeLength][7];
		
		openTime = DateFormatUtil.formatTime(shop.getOpenTimeStart())+"-"+DateFormatUtil.formatTime(shop.getOpenTimeEnd());
		Calendar calendar = Calendar.getInstance();
		if( startSendDate == null){
			//修改时间添加配送的余量时间
			calendar.add(Calendar.MINUTE,OrgOrderConstant.SEND_MARGIN_TIME_MINUTE);
			Date nowMargin = calendar.getTime();
			date[0] = DateFormatUtil.formatDate(nowMargin);
			week[0] = DateFormatUtil.formatWeek(nowMargin);
			
			Date nowTime = DateParseUtil.parseTime(DateFormatUtil.formatTime(nowMargin));
			
			//如果为周末不配送
			if(shop.getOpenDay() == OrgShopConstant.OPEN_DAT_WORK && (week[0].equals("星期六") || week[0].equals("星期日"))){
				for (int i = 0; i < timeLength; i++) {
					isSend[i][0] = false;
				}
				isTake[0] = false;
			}else{
				
				//初始化时间
				int index = 0;
				if(shop.getSendTimeAmStart() != null && shop.getSendTimeAmEnd() != null){
					if(nowTime.compareTo(shop.getSendTimeAmEnd()) < 0){
						isSend[index][0] = true;
					}else{
						isSend[index][0] = false;
					}
					index ++ ;
				}
				if(shop.getSendTimeNoonStart() != null && shop.getSendTimeNoonEnd() != null){
					if(nowTime.compareTo(shop.getSendTimeNoonEnd()) < 0){
						isSend[index][0] = true;
					}else{
						isSend[index][0] = false;
					}
					index ++ ;
				}
				if(shop.getSendTimePmStart() != null && shop.getSendTimePmEnd() != null){
					if(nowTime.compareTo(shop.getSendTimePmEnd()) < 0){
						isSend[index][0] = true;
					}else{
						isSend[index][0] = false;
					}
					index ++ ;
				}
				if(shop.getSendTimeNightStart() != null && shop.getSendTimeNightEnd() != null){
					if(nowTime.compareTo(shop.getSendTimeNightEnd()) < 0){
						isSend[index][0] = true;
					}else{
						isSend[index][0] = false;
					}
					index ++ ;
				}
				
				if(nowTime.compareTo(shop.getOpenTimeEnd()) < 0){
					isTake[0] = true;
				}else{
					isTake[0] = false;
				}
			
			}
			//week[0] = "今天";
		}else{
			//非当天
			calendar.setTime(startSendDate);
			date[0] = DateFormatUtil.formatDate(startSendDate);
			week[0] = DateFormatUtil.formatWeek(startSendDate);
			//如果为周末不配送
			if(shop.getOpenDay() == OrgShopConstant.OPEN_DAT_WORK && (week[0].equals("星期六") || week[0].equals("星期日"))){
				for (int i = 0; i < timeLength; i++) {
					isSend[i][0] = false;
				}
				isTake[0] = false;
			}else{
				for (int i = 0; i < timeLength; i++) {
					isSend[i][0] = true;
				}
				isTake[0] = true;
			}
		}
		
		// 之后6天
		Date temp = null; 
		for(int i=1;i<=6;i++){
			calendar.add(Calendar.DATE, 1);
			temp = calendar.getTime(); 
			date[i] = DateFormatUtil.formatDate(temp);
			week[i] = DateFormatUtil.formatWeek(temp);
			if(shop.getOpenDay() == OrgShopConstant.OPEN_DAT_WORK && (week[i].equals("星期六") || week[i].equals("星期日"))){
				for (int j = 0; j < timeLength; j++) {
					isSend[j][i] = false;
				}
				isTake[i] = false;
			}else{
				for (int j = 0; j < timeLength; j++) {
					isSend[j][i] = true;
				}
				isTake[i] = true;
			}
		}
		
		//默认送货时间
		out:
		for(int i=0;i<7;i++){
			for(int j=0;j<timeLength;j++){
				if(isSend[j][i]){
					defaultSendDate = date[i];
					defaultSendWeek = week[i];
					defaultSendTime = time[j];
					break out;
				}
			}
		}
		
		//默认取货时间
		for(int i=0;i<7;i++){
			if(isTake[i]){
				defaultTakeDate = date[i];
				defaultTakeWeek = week[i];
				break;
			}
		}
		
		send.setTime(time);
		send.setWeek(week);
		send.setDate(date);
		send.setIsSend(isSend);
		send.setIsTake(isTake);
		send.setOpenTime(openTime);
		send.setDefaultSendDate(defaultSendDate);
		send.setDefaultSendWeek(defaultSendWeek);
		send.setDefaultSendTime(defaultSendTime);
		send.setDefaultTakeDate(defaultTakeDate);
		send.setDefaultTakeWeek(defaultTakeWeek);
		return send;
	}
	
	@Override
	public OrgOrderSend getSendOption4Meal(OrgUsersSession orgUsersSession,Date startSendDate) {
		OrgOrderSend send = new OrgOrderSend();	
		OrgShop shop = orgShopService.queryVoById(orgUsersSession.getOrgShop().getShopId());
		String[] date = new String[1];
		String[] week = new String[1];
		Boolean[] isTake = new Boolean[1];
		String defaultSendDate = "";
		String defaultSendWeek = "";
		String[] defaultSendTime = new String[2];
		String defaultTakeDate = "";
		String defaultTakeWeek = "";
		String openTime = "";
		
		//判断非空时间个数
		int timeLength = 0;
		if(shop.getSendTimeNoonStart() != null && shop.getSendTimeNoonEnd() != null){
			timeLength ++ ;
		}
		
		//送货时间
		String[][] time = new String[timeLength][2];
		timeLength = 0;
		if(shop.getSendTimeNoonStart() != null && shop.getSendTimeNoonEnd() != null){
			time[timeLength][0] = DateFormatUtil.formatTime(shop.getSendTimeNoonStart());
			time[timeLength][1] = DateFormatUtil.formatTime(shop.getSendTimeNoonEnd());
			timeLength ++ ;
		}
		
		//是否可送
		Boolean[][] isSend = new Boolean[timeLength][1];
		
		openTime = DateFormatUtil.formatTime(shop.getOpenTimeStart())+"-"+DateFormatUtil.formatTime(shop.getOpenTimeEnd());
		Calendar calendar = Calendar.getInstance();
		if( startSendDate == null){
			//修改时间添加配送的余量时间
			calendar.add(Calendar.MINUTE,OrgOrderConstant.SEND_MARGIN_TIME_MINUTE);
			Date nowMargin = calendar.getTime();
			date[0] = DateFormatUtil.formatDate(nowMargin);
			week[0] = DateFormatUtil.formatWeek(nowMargin);
			
			Date nowTime = DateParseUtil.parseTime(DateFormatUtil.formatTime(nowMargin));
			
			//如果为周末不配送
			if(shop.getOpenDay() == OrgShopConstant.OPEN_DAT_WORK && (week[0].equals("星期六") || week[0].equals("星期日"))){
				for (int i = 0; i < timeLength; i++) {
					isSend[i][0] = false;
				}
				isTake[0] = false;
			}else{
				
				//初始化时间
				int index = 0;
				if(shop.getSendTimeNoonStart() != null && shop.getSendTimeNoonEnd() != null){
					if(nowTime.compareTo(shop.getSendTimeNoonEnd()) < 0){
						isSend[index][0] = true;
					}else{
						isSend[index][0] = false;
					}
					index ++ ;
				}
				
				if(nowTime.compareTo(shop.getOpenTimeEnd()) < 0){
					isTake[0] = true;
				}else{
					isTake[0] = false;
				}
				
			}
			//week[0] = "今天";
		}else{
			//非当天
			calendar.setTime(startSendDate);
			date[0] = DateFormatUtil.formatDate(startSendDate);
			week[0] = DateFormatUtil.formatWeek(startSendDate);
			//如果为周末不配送
			if(shop.getOpenDay() == OrgShopConstant.OPEN_DAT_WORK && (week[0].equals("星期六") || week[0].equals("星期日"))){
				for (int i = 0; i < timeLength; i++) {
					isSend[i][0] = false;
				}
				isTake[0] = false;
			}else{
				for (int i = 0; i < timeLength; i++) {
					isSend[i][0] = true;
				}
				isTake[0] = true;
			}
		}
		
		//默认送货时间
		if(timeLength == 1 && isSend[0][0]){
			defaultSendDate = date[0];
			defaultSendWeek = week[0];
			defaultSendTime = time[0];
		}
		
		//默认取货时间
		if(isTake[0]){
			defaultTakeDate = date[0];
			defaultTakeWeek = week[0];
		}
		
		send.setTime(time);
		send.setWeek(week);
		send.setDate(date);
		send.setIsSend(isSend);
		send.setIsTake(isTake);
		send.setOpenTime(openTime);
		send.setDefaultSendDate(defaultSendDate);
		send.setDefaultSendWeek(defaultSendWeek);
		send.setDefaultSendTime(defaultSendTime);
		send.setDefaultTakeDate(defaultTakeDate);
		send.setDefaultTakeWeek(defaultTakeWeek);
		return send;
	}

	@Override
	public boolean updateCancal4User(OrgUsersSession orgUsersSession,Integer orderId, String logDetail) {
		boolean result = updateCancel(orderId);
		if(result){
			try{
				//添加订单日志
				orgOrderLogService.addByUser(orderId,orgUsersSession.getOrgUsers().getUserId(), OrgOrderLogConstant.TYPE_USER_CANCEL, logDetail);
			}catch(Exception e){
			}
		}
		return result;
	}
	
	@Override
	public boolean updateCancel4Admin(Integer orderId, String logDetail, OrgAdminUserSession admin) {
		boolean result = updateCancel(orderId);
		if(result){
			try{
				//添加订单日志
				orgOrderLogService.addByAdmin(orderId, admin.getOrgAdminUser().getUserId(), OrgOrderLogConstant.TYPE_ADMIN_CANCEL, logDetail);
				//发送短信
				OrgOrder orgOrder = queryById(orderId);
				DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
				SmsUtil.sendCancelMessage(orgOrder.getConsigneeMobile(), logDetail,String.valueOf(orderId), df.format(orgOrder.getCreateTime()));
			}catch(Exception e){
				
			}
		}
		return result;
	}
	
	private boolean updateCancel(Integer orderId) {
		OrgOrder order = lockQueryById(orderId);
		
		//判断能否取消(完成前才能取消)
		if(order.getStatus() < OrgOrderConstant.STATUS_FINISH){
			orgRefundOrderService.addByOrder(order);
			//限时折扣记录删除
			orgLimitTimeRecordService.deleteByOrderId(order.getOrderId());
			
			//优惠券恢复
			orgCouponRecordService.updateUnusedByOrderId(order.getOrderId());
			
			//远程数据库数据修改
			rxOrderService.deleteByOrderId(order.getOrderId());
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public Page<OrgOrder> queryPageList4User(OrgUsersSession orgUsersSession,OrgOrderQuery query,Pageable pageable){
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		Page<OrgOrder> pageOrder = queryPageList(query, pageable);
		addOrderGoods(pageOrder.getContent());
		return pageOrder;
	}

	@Override
	public Page<OrgOrder> queryPageList4Admin(OrgAdminUserSession orgAdminUserSession,OrgOrderQuery query,Pageable pageable) {
		query.setShopIds(orgAdminUserSession.getShopIds());
		Page<OrgOrder> pageOrder = queryPageList(query, pageable);
		addOrderGoods(pageOrder.getContent());
		return pageOrder;
	}
	
	@Override
	public List<OrgOrder> queryList4Report(OrgOrderQuery query) {
		List<OrgOrder> listOrder = queryList(query);
		addOrderGoods(listOrder);
		return listOrder;
	}
	
	/**
	 * 添加订单对应商品详情
	 * @param listOrder
	 */
	private void addOrderGoods(List<OrgOrder> listOrder){
		if(CollectionUtils.isNotEmpty(listOrder)){
			Map<Integer,OrgOrderVo> mapOrder = new HashMap<Integer,OrgOrderVo>();
			OrgOrderVo orgOrderVo = null;
			for(OrgOrder order : listOrder){
				orgOrderVo = (OrgOrderVo)order;
				mapOrder.put(orgOrderVo.getOrderId(), orgOrderVo);
			}
			
			List<OrgOrderGoods> listOrderGoods = orgOrderGoodsService.queryByOrderIds(mapOrder.keySet());
			for(OrgOrderGoods orderGoods : listOrderGoods){
				mapOrder.get(orderGoods.getOrderId()).getListOrderGoods().add(orderGoods);
			}
		}
	}

	@Override
	public OrgOrderUserCount queryUserCount(Integer userId) {
		return orgOrderDao.selectUserCount(userId);
	}

	@Override
	public boolean updateConfirm(Integer orderId, String logDetail, OrgAdminUserSession admin) {
		OrgOrder order = lockQueryById(orderId);
		if(order.getStatus() == OrgOrderConstant.STATUS_WAIT_CONFIRM){
			order.setStatus(OrgOrderConstant.STATUS_WAIT_SEND);
			updateByIdSelective(order);
			orgOrderLogService.addByAdmin(order.getOrderId(), admin.getOrgAdminUser().getUserId(), OrgOrderLogConstant.TYPE_ADMIN_CONFIRE, logDetail);
			//  发送订单到数据中心
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateSendOrTake(Integer orderId, String logDetail, OrgAdminUserSession admin) {
		OrgOrder order = lockQueryById(orderId);
		if(order.getStatus() == OrgOrderConstant.STATUS_WAIT_SEND){
			order.setStatus(OrgOrderConstant.STATUS_SEND);
			updateByIdSelective(order);
			
			if (order.getSendStyle() == OrgOrderConstant.SEND_STYLE_SEND) {
				orgOrderLogService.addByAdmin(order.getOrderId(),admin.getOrgAdminUser().getUserId(),OrgOrderLogConstant.TYPE_ADMIN_SEND, logDetail);
			} else if (order.getSendStyle() == OrgOrderConstant.SEND_STYLE_TAKE) {
				orgOrderLogService.addByAdmin(order.getOrderId(),admin.getOrgAdminUser().getUserId(),OrgOrderLogConstant.TYPE_ADMIN_TAKE, logDetail);
			}
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateFinish(Integer orderId, String logDetail, String takeCode, OrgAdminUserSession admin) {
		OrgOrder order = lockQueryById(orderId);
		if(order.getStatus() == OrgOrderConstant.STATUS_SEND){
			//判断自提码
			if(order.getSendStyle() == OrgOrderConstant.SEND_STYLE_TAKE 
					&& (takeCode == null || StringUtils.isEmpty(takeCode) || !takeCode.trim().equals(order.getTakeCode()))){
				return false;
			}
			order.setStatus(OrgOrderConstant.STATUS_FINISH);
			if(order.getPayStyle() == OrgOrderConstant.PAY_STYLE_LOCAL){
				order.setPayStatus(OrgOrderConstant.PAY_STATUS_PAID); 
				order.setPayTime(new Date());
			}
			order.setFinishTime(new Date());
			updateByIdSelective(order);
			
			//赠送优惠券
			orgCouponRecordService.updateGive4Order(order);
			
			//远程数据库数据修改
			rxOrderService.updateFinishByOrderId(order.getOrderId());
			orgOrderLogService.addByAdmin(order.getOrderId(), admin.getOrgAdminUser().getUserId(), OrgOrderLogConstant.TYPE_ADMIN_FINISH, logDetail);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void updateRemark(Integer orderId, String logDetail, OrgAdminUserSession admin) {
		orgOrderLogService.addByAdmin(orderId, admin.getOrgAdminUser().getUserId(), OrgOrderLogConstant.TYPE_ADMIN_REMARK, logDetail);
	}

	@Override
	public void updateConsignee(OrgOrder order, OrgAdminUserSession admin) {
		OrgOrder old = lockQueryById(order.getOrderId());
		StringBuilder logDetail = new StringBuilder(128);
		logDetail.append("订单：");
		logDetail.append(old.getOrderId());
		logDetail.append("修改送货信息。原数据为送货人:");
		logDetail.append(old.getConsignee());
		logDetail.append(";手机：");
		logDetail.append(old.getConsigneeMobile());
		logDetail.append(";电话：");
		logDetail.append(old.getConsigneeTel());
		logDetail.append(";邮箱：");
		logDetail.append(old.getConsigneeEmail());
		logDetail.append(";地址：");
		logDetail.append(old.getConsigneeAddress());
		logDetail.append("。");
		
		old.setConsignee(order.getConsignee());
		old.setConsigneeMobile(order.getConsigneeMobile());
		old.setConsigneeTel(order.getConsigneeTel());
		old.setConsigneeEmail(order.getConsigneeEmail());
		old.setConsigneeAddress(order.getConsigneeAddress());
		
		updateByIdSelective(old);
		orgOrderLogService.addByAdmin(order.getOrderId(), admin.getOrgAdminUser().getUserId(), OrgOrderLogConstant.TYPE_SYSTEM_REMARK, logDetail.toString());
		
		
	}

	@Override
	public void updateSolve2Server(OrgSolveOrder orgSolveOrder, OrgAdminUserSession admin) {
		OrgOrder order = queryById(orgSolveOrder.getOrderId());
		orgSolveOrder.setShopId(order.getShopId());
		orgSolveOrder.setFromAdminId(admin.getOrgAdminUser().getUserId());
		orgSolveOrder.setStatus(OrgSolveOrderConstant.STATUS_WAIT_SOLVE);
		orgSolveOrder.setCreateTime(new Date());
		orgSolveOrderService.add(orgSolveOrder);
		orgOrderLogService.addByAdmin(orgSolveOrder.getOrderId(), admin.getOrgAdminUser().getUserId(), OrgOrderLogConstant.TYPE_ADMIN_TO_SERVER, orgSolveOrder.getRemark());		
		
	}

	@Override
	public boolean updateSolveCancel(OrgSolveOrder orgSolveOrder, OrgAdminUserSession admin) {
		if(updateCancel4Admin(orgSolveOrder.getOrderId(),orgSolveOrder.getReason(),admin)){
			updateSolve2Shop(orgSolveOrder,admin);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void updateSolve2Shop(OrgSolveOrder orgSolveOrder, OrgAdminUserSession admin) {
		orgSolveOrder.setSolveAdminId((short)admin.getOrgAdminUser().getUserId());
		orgSolveOrder.setSolveTime(new Date());
		orgSolveOrder.setStatus(OrgSolveOrderConstant.STATUS_FINISH_SOLVE);
		orgSolveOrderService.updateByIdSelective(orgSolveOrder);
		orgOrderLogService.addByAdmin(orgSolveOrder.getOrderId(), admin.getOrgAdminUser().getUserId(), OrgOrderLogConstant.TYPE_ADMIN_TO_SHOP, orgSolveOrder.getRemark());		
	}
	
	@Override
	public void updateReturnStatus(Integer orderId){
		//修改订单的退货状态
		//查询是否整个订单都已退货
		OrgOrderGoodsQuery query = new OrgOrderGoodsQuery();
		query.setOrderId(orderId);
		query.setCountLastReturnGoods(true);
		long countLastReturnGoods = orgOrderGoodsService.queryOtherCount(query);
		OrgOrder order = new OrgOrder();
		order.setOrderId(orderId);
		if(countLastReturnGoods == 0){
			order.setReturnStatus(OrgOrderConstant.RETURN_STATUS_CLOSE);
		}else{
			order.setReturnStatus(OrgOrderConstant.RETURN_STATUS_OPEN);
		}
		updateByIdSelective(order);
	}
	
	/**
	 * 超时订单作废
	 * @param order
	 */
	public void updateCancelTimeOut(OrgOrder order){
		order.setStatus(OrgOrderConstant.STATUS_CLOSE);
		updateByIdSelective(order);
		
		//限时折扣记录删除
		orgLimitTimeRecordService.deleteByOrderId(order.getOrderId());
		
		//优惠券恢复
		orgCouponRecordService.updateUnusedByOrderId(order.getOrderId());
		
		//远程订单状态修改
		rxOrderService.deleteByOrderId(order.getOrderId());
		
		//添加订单支付成功日志
		orgOrderLogService.addBySystem(order.getOrderId(), OrgOrderLogConstant.TYPE_SYSTEM_TIMEOUT_COLSE, "网上订单支付超时！");
	}
}