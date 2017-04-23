package com.kjj.commserver.entity.shop.aide;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShopBanner;
import com.kjj.commserver.entity.shop.OrgShopPage;
import com.kjj.commserver.entity.shop.OrgShopPageFloor;
import com.kjj.commserver.entity.shop.OrgShopRecommand;

public class OrgShopPageVo extends OrgShopPage {
	
	/** 轮播图 */
	private List<OrgShopBanner> listShopBanner;
	
	/** 推荐 */
	private List<OrgShopRecommand> listShopRecommand;
	
	/** 楼层 */
	private List<OrgShopPageFloor> listShopPageFloor;

	public List<OrgShopBanner> getListShopBanner() {
		return listShopBanner;
	}

	public void setListShopBanner(List<OrgShopBanner> listShopBanner) {
		this.listShopBanner = listShopBanner;
	}

	public List<OrgShopRecommand> getListShopRecommand() {
		return listShopRecommand;
	}

	public void setListShopRecommand(List<OrgShopRecommand> listShopRecommand) {
		this.listShopRecommand = listShopRecommand;
	}

	public List<OrgShopPageFloor> getListShopPageFloor() {
		return listShopPageFloor;
	}

	public void setListShopPageFloor(List<OrgShopPageFloor> listShopPageFloor) {
		this.listShopPageFloor = listShopPageFloor;
	}

}