package com.kjj.commserver.entity.order.aide;

import java.util.Collection;

import com.kjj.commserver.entity.order.OrgCart;

public class OrgCartQuery extends OrgCart {
	
	/** 选择的goodsIds */
	private Collection<Integer> goodsIds;

	/** select for update */
	private Boolean select4Update = false;
	
	public Collection<Integer> getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(Collection<Integer> goodsIds) {
		this.goodsIds = goodsIds;
	}

	public Boolean getSelect4Update() {
		return select4Update;
	}

	public void setSelect4Update(Boolean select4Update) {
		this.select4Update = select4Update;
	}
	
}