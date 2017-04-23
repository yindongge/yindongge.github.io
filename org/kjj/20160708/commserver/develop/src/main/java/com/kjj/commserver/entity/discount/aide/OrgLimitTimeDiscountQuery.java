package com.kjj.commserver.entity.discount.aide;

import com.kjj.commserver.entity.discount.OrgLimitTimeDiscount;

public class OrgLimitTimeDiscountQuery extends OrgLimitTimeDiscount {
	
	/** 活动名称 */
	
	private String nameLike;

	public String getNameLike() {
		return nameLike;
	}

	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}
	
}