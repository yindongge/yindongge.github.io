package com.kjj.commserver.entity.shop.aide;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgTouchPageBanner;
import com.kjj.commserver.entity.shop.OrgTouchPage;

public class OrgTouchPageVo extends OrgTouchPage {
	/** 轮播图 */
	private List<OrgTouchPageBanner> listTouchPageBanner;
	
	private String shopname;

	public List<OrgTouchPageBanner> getListTouchPageBanner() {
		return listTouchPageBanner;
	}

	public void setListTouchPageBanner(
			List<OrgTouchPageBanner> listTouchPageBanner) {
		this.listTouchPageBanner = listTouchPageBanner;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	
	
}