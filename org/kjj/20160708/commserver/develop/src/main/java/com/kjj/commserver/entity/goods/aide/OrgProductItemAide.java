package com.kjj.commserver.entity.goods.aide;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgDiscountAllow;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;

public class OrgProductItemAide {
	
	/** 商品Id */
	private Integer goodsId;
	
	/** 商品Id */
	private String goodsSn;
	
	/** 用户可购买的最大量 */
	private Integer userBuyMax = 0;
	
	/** 用户要购买的量 */
	private Integer userBuy = 0;
	
	/** 原价 注意：可能为null */
	private BigDecimal sourcePrice;
	
	/** 当前价格 注意：可能为null */
	private BigDecimal realPrice;
	
	/** 展示价格 会员折扣，限时折扣后的优惠价格，供购物车、结算页面展示 注意：可能为null */
	private BigDecimal showPrice;
	
	/** 可参加的优惠活动 */
	private Map<Byte, OrgDiscountAllow> mapDiscountAllow = null;
	
	/** 限时折扣标志 */
	private Boolean markLimitTimeDiscount = false;
	
	/** 用户会员折扣标志*/
	private Boolean markUserLevelDiscount = false;
	
	/** 满减标志*/
	private Boolean markReachDiscount = false;
	
	/** 用户会员价格 */
	private BigDecimal userLevelPrice;
	
	/** 商品是否可售 */
	private Boolean canSale = false;
	
	/** 优惠券标志 */
	private Boolean markCoupon = false;
	
	/** 限制支付时长 */
	private Short limitPayTime;
	
	/** 菜品标志 */
	private Boolean markMeal = false;
	
   /** 是否直营 0：直营 1：联营 */
    private Byte isDirect;
	
	public OrgProductItemAide(Integer goodsId){
		setGoodsId(goodsId);
		//初始化允许的优惠活动
		initMapDiscountAllow();
	}
	
	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsSn() {
		return goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	public Integer getUserBuyMax() {
		return userBuyMax;
	}

	public void setUserBuyMax(Integer userBuyMax) {
		this.userBuyMax = userBuyMax;
	}

	public Integer getUserBuy() {
		return userBuy;
	}

	public void setUserBuy(Integer userBuy) {
		this.userBuy = userBuy;
	}

	public BigDecimal getSourcePrice() {
		return sourcePrice;
	}

	public void setSourcePrice(BigDecimal sourcePrice) {
		this.sourcePrice = sourcePrice;
	}

	public BigDecimal getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}

	public BigDecimal getShowPrice() {
		return showPrice;
	}

	public void setShowPrice(BigDecimal showPrice) {
		this.showPrice = showPrice;
	}

	public Map<Byte, OrgDiscountAllow> getMapDiscountAllow() {
		return mapDiscountAllow;
	}

	public void setMapDiscountAllow(Map<Byte, OrgDiscountAllow> mapDiscountAllow) {
		this.mapDiscountAllow = mapDiscountAllow;
	}

	public Boolean getMarkLimitTimeDiscount() {
		return markLimitTimeDiscount;
	}

	public void setMarkLimitTimeDiscount(Boolean markLimitTimeDiscount) {
		this.markLimitTimeDiscount = markLimitTimeDiscount;
	}

	public Boolean getMarkCoupon() {
		return markCoupon;
	}

	public void setMarkCoupon(Boolean markCoupon) {
		this.markCoupon = markCoupon;
	}
	
	public Short getLimitPayTime() {
		return limitPayTime;
	}

	public void setLimitPayTime(Short limitPayTime) {
		this.limitPayTime = limitPayTime;
	}
	
	/**
	 * 初始化允许的优惠活动
	 */
	private void initMapDiscountAllow() {
		mapDiscountAllow = new HashMap<Byte, OrgDiscountAllow>();
		mapDiscountAllow.put(OrgDiscountTypeConstant.TYPE_LIMIT_TIME_DISCOUNT, new OrgDiscountAllow());
		mapDiscountAllow.put(OrgDiscountTypeConstant.TYPE_COUPON, new OrgDiscountAllow());
		mapDiscountAllow.put(OrgDiscountTypeConstant.TYPE_RED_PACKET, new OrgDiscountAllow());
		mapDiscountAllow.put(OrgDiscountTypeConstant.TYPE_GROUP_DISCOUNT, new OrgDiscountAllow());
		mapDiscountAllow.put(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT, new OrgDiscountAllow());
	}

	public Boolean getCanSale() {
		return canSale;
	}

	public void setCanSale(Boolean canSale) {
		this.canSale = canSale;
	}

	public Boolean getMarkUserLevelDiscount() {
		return markUserLevelDiscount;
	}

	public void setMarkUserLevelDiscount(Boolean markUserLevelDiscount) {
		this.markUserLevelDiscount = markUserLevelDiscount;
	}

	public BigDecimal getUserLevelPrice() {
		return userLevelPrice;
	}

	public void setUserLevelPrice(BigDecimal userLevelPrice) {
		this.userLevelPrice = userLevelPrice;
	}

	public Boolean getMarkMeal() {
		return markMeal;
	}

	public void setMarkMeal(Boolean markMeal) {
		this.markMeal = markMeal;
	}

	public Boolean getMarkReachDiscount() {
		return markReachDiscount;
	}

	public void setMarkReachDiscount(Boolean markReachDiscount) {
		this.markReachDiscount = markReachDiscount;
	}

	public Byte getIsDirect() {
		return isDirect;
	}

	public void setIsDirect(Byte isDirect) {
		this.isDirect = isDirect;
	}

}
