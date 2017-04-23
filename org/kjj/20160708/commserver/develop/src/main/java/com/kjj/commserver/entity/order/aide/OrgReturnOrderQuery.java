package com.kjj.commserver.entity.order.aide;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kjj.commserver.entity.order.OrgReturnOrder;

public class OrgReturnOrderQuery extends OrgReturnOrder {
	
	/** 要退货的订单号 */
	private Integer reOrderId;

	/** 管理员店铺权限 */
	private Collection<Integer> shopIds;
	/** 退换货单号 */
	private String returnOrderLike;
	/** 订单号 */
	private String orderIdLike;
	/** 起始时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeStart;
	/** 结束时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeEnd;
	 /** 商品的唯一货号 */
    private String goodsSnLike;
	/** 商品名称 */
	private String goodsNameLike;
	
	public Integer getReOrderId() {
		return reOrderId;
	}

	public void setReOrderId(Integer reOrderId) {
		this.reOrderId = reOrderId;
	}

	public Collection<Integer> getShopIds() {
		return shopIds;
	}

	public void setShopIds(Collection<Integer> shopIds) {
		this.shopIds = shopIds;
	}

	
	public String getReturnOrderLike() {
		return returnOrderLike;
	}

	public void setReturnOrderLike(String returnOrderLike) {
		this.returnOrderLike = returnOrderLike;
	}

	public String getOrderIdLike() {
		return orderIdLike;
	}

	public void setOrderIdLike(String orderIdLike) {
		this.orderIdLike = orderIdLike;
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

	public String getGoodsSnLike() {
		return goodsSnLike;
	}

	public void setGoodsSnLike(String goodsSnLike) {
		this.goodsSnLike = goodsSnLike;
	}

	public String getGoodsNameLike() {
		return goodsNameLike;
	}

	public void setGoodsNameLike(String goodsNameLike) {
		this.goodsNameLike = goodsNameLike;
	}

	
}