package com.kjj.commserver.entity.order.aide;

import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.order.OrgReturnOrder;

public class OrgReturnOrderVo extends OrgReturnOrder {
	
	/** 退货商品 */
	private OrgProductItem orgProductItem;

	public OrgProductItem getOrgProductItem() {
		return orgProductItem;
	}

	public void setOrgProductItem(OrgProductItem orgProductItem) {
		this.orgProductItem = orgProductItem;
	}

}