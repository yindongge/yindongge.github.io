package com.kjj.commserver.entity.shop.aide;

import com.kjj.commserver.entity.shop.OrgTouchPage;

public class OrgTouchPageQuery extends OrgTouchPage {
	
	private String shopNameLike;
	
	/*查询的时候标记是店铺还是区划*/
	private String flag;

	public String getShopNameLike() {
		return shopNameLike;
	}

	public void setShopNameLike(String shopNameLike) {
		this.shopNameLike = shopNameLike;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
}