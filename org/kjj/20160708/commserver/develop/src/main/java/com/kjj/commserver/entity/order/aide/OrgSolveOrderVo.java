package com.kjj.commserver.entity.order.aide;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgSolveOrder;

public class OrgSolveOrderVo extends OrgSolveOrder {
	
	/**店铺名称 */
	private String shopName;
	
	/** 商品对应订单 */
	private OrgOrder orgOrder;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public OrgOrder getOrgOrder() {
		return orgOrder;
	}

	public void setOrgOrder(OrgOrder orgOrder) {
		this.orgOrder = orgOrder;
	}
	
}