package com.kjj.commserver.entity.shop.aide;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgMobilePage;
import com.kjj.commserver.entity.shop.OrgMobilePageBanner;

public class OrgMobilePageVo extends OrgMobilePage {
	/** 轮播图 */
	private List<OrgMobilePageBanner> listMobilePageBanner;
	
	private String shopname;

	public List<OrgMobilePageBanner> getListMobilePageBanner() {
		return listMobilePageBanner;
	}

	public void setListMobilePageBanner(
			List<OrgMobilePageBanner> listMobilePageBanner) {
		this.listMobilePageBanner = listMobilePageBanner;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	
	
}