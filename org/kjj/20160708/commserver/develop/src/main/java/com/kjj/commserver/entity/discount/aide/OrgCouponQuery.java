package com.kjj.commserver.entity.discount.aide;

import com.kjj.commserver.entity.discount.OrgCoupon;

public class OrgCouponQuery extends OrgCoupon {
	
	/** 优惠劵名称 */
	private String couponNameLike;
	
	 /** 满减优惠ID */
    private Integer reachDiscountId;

	public String getCouponNameLike() {
		return couponNameLike;
	}

	public void setCouponNameLike(String couponNameLike) {
		this.couponNameLike = couponNameLike;
	}

	public Integer getReachDiscountId() {
		return reachDiscountId;
	}

	public void setReachDiscountId(Integer reachDiscountId) {
		this.reachDiscountId = reachDiscountId;
	}

}