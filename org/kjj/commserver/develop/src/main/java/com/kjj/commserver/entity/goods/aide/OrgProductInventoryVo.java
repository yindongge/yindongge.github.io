package com.kjj.commserver.entity.goods.aide;

import com.kjj.commserver.entity.goods.OrgProductInventory;

public class OrgProductInventoryVo extends OrgProductInventory {
	/* 商品名称 */
	private String goodsName;
	
	/* 类名称 */
	private String className;
	
	/* 店铺名称 */
	private String shopName;
	
	/** org_product_shop_sale表id */
	private Integer opssId;
	
	/** 是否销售 */
    private Byte status;
	
	/** 是否直营 0：直营 1：联营 */
    private Byte isDirect;
   
	public Byte getIsDirect() {
		return isDirect;
	}

	public void setIsDirect(Byte isDirect) {
		this.isDirect = isDirect;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getOpssId() {
		return opssId;
	}

	public void setOpssId(Integer opssId) {
		this.opssId = opssId;
	}
	
}