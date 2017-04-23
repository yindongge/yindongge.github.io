package com.kjj.commserver.entity.order.aide;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kjj.commserver.entity.order.OrgOrderGoods;

public class OrgOrderGoodsQuery extends OrgOrderGoods {
	
	/** 多个订单 */
	private Collection<Integer> orderIds;
	
	/** 用户id  */
	private Integer userId;
	
	/** 订单状态  */
	private Byte orderStatus;
	
	/** 退货小于订单数量  */
	private Boolean returnLtBuy;
	
	/** 查询商品可退货数量 */
	private Boolean countLastReturnGoods;
	
	/** 查询商品可退款数量 */
	private Boolean countLastRefundGoods;
	
	/** 管理员店铺权限 */
	private Collection<Integer> shopIds;
	
	/** 下单起始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeStart;	
	
	/** 下单结束时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeEnd;
    
	/** 查询列表订单状态 */
	private Byte queryStatus;
	
	/** 商品名称 */
	private String goodsNameLike;
	
	/**商品货号*/
	 private String goodsSnLike;
	
	/** 订单号 */
	private String orderIdLike;	
	
	/** 按店铺分类 */
	private Boolean isAsShop = true;
	
	/** 商店id */
	private Integer shopId;
	
    /** 单价应收不为0 */
    private Boolean unitAccountsNeZero;
	
	public Boolean getIsAsShop() {
		return isAsShop;
	}

	public void setIsAsShop(Boolean isAsShop) {
		this.isAsShop = isAsShop;
	}

	/** 选择的店铺 */
	private Collection<Integer> shopSelect;
	
	public Collection<Integer> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(Collection<Integer> orderIds) {
		this.orderIds = orderIds;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Boolean getReturnLtBuy() {
		return returnLtBuy;
	}

	public void setReturnLtBuy(Boolean returnLtBuy) {
		this.returnLtBuy = returnLtBuy;
	}

	public Boolean getCountLastReturnGoods() {
		return countLastReturnGoods;
	}

	public void setCountLastReturnGoods(Boolean countLastReturnGoods) {
		this.countLastReturnGoods = countLastReturnGoods;
	}

	public Boolean getCountLastRefundGoods() {
		return countLastRefundGoods;
	}

	public void setCountLastRefundGoods(Boolean countLastRefundGoods) {
		this.countLastRefundGoods = countLastRefundGoods;
	}

	public Collection<Integer> getShopIds() {
		return shopIds;
	}

	public void setShopIds(Collection<Integer> shopIds) {
		this.shopIds = shopIds;
	}

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public Byte getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(Byte queryStatus) {
		this.queryStatus = queryStatus;
	}

	public String getGoodsNameLike() {
		return goodsNameLike;
	}

	public void setGoodsNameLike(String goodsNameLike) {
		this.goodsNameLike = goodsNameLike;
	}

	public String getOrderIdLike() {
		return orderIdLike;
	}

	public void setOrderIdLike(String orderIdLike) {
		this.orderIdLike = orderIdLike;
	}

	public Collection<Integer> getShopSelect() {
		return shopSelect;
	}

	public void setShopSelect(Collection<Integer> shopSelect) {
		this.shopSelect = shopSelect;
	}

	public String getGoodsSnLike() {
		return goodsSnLike;
	}

	public void setGoodsSnLike(String goodsSnLike) {
		this.goodsSnLike = goodsSnLike;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Boolean getUnitAccountsNeZero() {
		return unitAccountsNeZero;
	}

	public void setUnitAccountsNeZero(Boolean unitAccountsNeZero) {
		this.unitAccountsNeZero = unitAccountsNeZero;
	}
}