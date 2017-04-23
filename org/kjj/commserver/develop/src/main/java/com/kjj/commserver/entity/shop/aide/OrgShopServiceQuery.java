package com.kjj.commserver.entity.shop.aide;

import com.kjj.commserver.entity.shop.OrgShopService;

public class OrgShopServiceQuery extends OrgShopService {
	
	/** 店铺ID */
	private Integer shopId;

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
}