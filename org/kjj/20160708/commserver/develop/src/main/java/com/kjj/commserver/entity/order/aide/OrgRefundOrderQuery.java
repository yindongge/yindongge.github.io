package com.kjj.commserver.entity.order.aide;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kjj.commserver.entity.order.OrgRefundOrder;

public class OrgRefundOrderQuery extends OrgRefundOrder {
	
	/** 要退货的订单号 */
	private Integer reOrderId;
	
	/** 用户名 */
	private String userNameLike;
	
	/** 管理员店铺权限 */
	private Collection<Integer> shopIds;
	
	/** 退款单号 */
	private String refundOrderLike;
	
	/** 订单号 */
	private String orderLike;
	
	/** 申请起始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeStart;	
	
	/** 申请结束时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeEnd;
    
    /** 选择的店铺 */
    private Collection<Integer> shopSelect;
	
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

	public String getUserNameLike() {
		return userNameLike;
	}

	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
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

	public String getRefundOrderLike() {
		return refundOrderLike;
	}

	public void setRefundOrderLike(String refundOrderLike) {
		this.refundOrderLike = refundOrderLike;
	}

	public String getOrderLike() {
		return orderLike;
	}

	public void setOrderLike(String orderLike) {
		this.orderLike = orderLike;
	}

	public Collection<Integer> getShopSelect() {
		return shopSelect;
	}

	public void setShopSelect(Collection<Integer> shopSelect) {
		this.shopSelect = shopSelect;
	}

}