package com.kjj.commserver.entity.user.aide;

import com.kjj.commserver.entity.user.OrgUserAddress;

public class OrgUserAddressQuery extends OrgUserAddress {
	
	/** 不等于店铺ID */
	private Integer notEqualShopId;
	
	/** 店铺状态 */
	private Byte shopStatus;

	public Integer getNotEqualShopId() {
		return notEqualShopId;
	}

	public void setNotEqualShopId(Integer notEqualShopId) {
		this.notEqualShopId = notEqualShopId;
	}

	public Byte getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(Byte shopStatus) {
		this.shopStatus = shopStatus;
	}
	
}