package com.kjj.commserver.entity.shop.aide;

import com.kjj.commserver.entity.shop.OrgMobilePageBanner;

public class OrgMobilePageBannerForm extends OrgMobilePageBanner{
	 /**新的id字段，用作排序*/
    private Integer newId;

	public Integer getNewId() {
		return newId;
	}

	public void setNewId(Integer newId) {
		this.newId = newId;
	}
    
}
