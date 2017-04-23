package com.kjj.commserver.entity.shop.aide;

import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgBusinessArea;

public class OrgBusinessAreaVo extends OrgBusinessArea {
	
	/** 区域 */
	private OrgArea orgArea;
	
	/**  */
	private Integer shopCount;
	
	public OrgArea getOrgArea() {
		return orgArea;
	}

	public void setOrgArea(OrgArea orgArea) {
		this.orgArea = orgArea;
	}

	public Integer getShopCount() {
		return shopCount;
	}

	public void setShopCount(Integer shopCount) {
		this.shopCount = shopCount;
	}
	
	
}