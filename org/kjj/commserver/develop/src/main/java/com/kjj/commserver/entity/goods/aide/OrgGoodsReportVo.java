package com.kjj.commserver.entity.goods.aide;

import java.math.BigDecimal;

import com.kjj.commserver.entity.order.OrgOrderGoods;

public class OrgGoodsReportVo extends OrgOrderGoods{
	/** 商品名称 */
	private String goodsName;
	
	/** 商店名称 */
	private String shopName;
	private BigDecimal amountGoods;
	private BigDecimal avgPrice;
	private BigDecimal totalMoney;
	
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getAmountGoods() {
		return amountGoods;
	}

	public void setAmountGoods(BigDecimal amountGoods) {
		this.amountGoods = amountGoods;
	}
	
	
	
}
