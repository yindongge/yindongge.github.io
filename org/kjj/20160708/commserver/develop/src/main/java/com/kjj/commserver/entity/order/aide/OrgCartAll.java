package com.kjj.commserver.entity.order.aide;

import java.util.LinkedHashMap;
import java.util.Map;

import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.order.OrgCart;

public class OrgCartAll{
	
	private OrgCart orgCart;

	private OrgProductItemAll orgProductItemAll;
	
	/** 用户是否可以购买该商品 */
	private Boolean canBuy = true;
	
	/** 可选促销 */
	private Map<Integer,String> mapDiscount = new LinkedHashMap<Integer,String>();

	public OrgCart getOrgCart() {
		return orgCart;
	}

	public void setOrgCart(OrgCart orgCart) {
		this.orgCart = orgCart;
	}

	public OrgProductItemAll getOrgProductItemAll() {
		return orgProductItemAll;
	}

	public void setOrgProductItemAll(OrgProductItemAll orgProductItemAll) {
		this.orgProductItemAll = orgProductItemAll;
	}

	public Boolean getCanBuy() {
		return canBuy;
	}

	public void setCanBuy(Boolean canBuy) {
		this.canBuy = canBuy;
	}

	public Map<Integer, String> getMapDiscount() {
		return mapDiscount;
	}

	public void setMapDiscount(Map<Integer, String> mapDiscount) {
		this.mapDiscount = mapDiscount;
	}
	
}
