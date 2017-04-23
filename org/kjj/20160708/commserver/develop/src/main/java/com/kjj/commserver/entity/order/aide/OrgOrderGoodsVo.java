package com.kjj.commserver.entity.order.aide;

import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;

public class OrgOrderGoodsVo extends OrgOrderGoods {
	
	/** 商品明细 */
	private OrgProductItem orgProductItem;

	/** 商品对应订单 */
	private OrgOrder orgOrder;

	 /** 店铺编号 */
    private String shopCode;
    
    /** 店铺名称 */
    private String shopName;
    
    /** 商品条形码 */
    private String barCode;
    

	public OrgOrder getOrgOrder() {
		return orgOrder;
	}

	public void setOrgOrder(OrgOrder orgOrder) {
		this.orgOrder = orgOrder;
	}

	public OrgProductItem getOrgProductItem() {
		return orgProductItem;
	}

	public void setOrgProductItem(OrgProductItem orgProductItem) {
		this.orgProductItem = orgProductItem;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarcode(String barCode) {
		this.barCode = barCode;
	}
	
}