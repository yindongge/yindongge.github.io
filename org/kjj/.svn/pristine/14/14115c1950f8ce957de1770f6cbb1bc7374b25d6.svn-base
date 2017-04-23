package com.kjj.commserver.entity.order.aide;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.OrgRefundOrder;
import com.kjj.commserver.entity.order.OrgReturnOrder;

public class OrgRefundOrderVo extends OrgRefundOrder {
	
	/** 退款单对应商品 */
	private List<OrgOrderGoods> listOrderGoods = new ArrayList<OrgOrderGoods>();

	/** 退款单对应订单 */
	private OrgOrder orgOrder;
	
	/** 退款单对应退货单 */
	private OrgReturnOrder orgReturnOrder;
	
	/** 退款单对应商品支付金额 */
	private BigDecimal goodsPayMoney;
	
	/** 用户名 */
	private String userName;
	
	/** 管理员名 */
	private String adminName;
	
	/** 店铺名称 */
	private String shopName;

	public List<OrgOrderGoods> getListOrderGoods() {
		return listOrderGoods;
	}

	public void setListOrderGoods(List<OrgOrderGoods> listOrderGoods) {
		this.listOrderGoods = listOrderGoods;
	}

	public OrgOrder getOrgOrder() {
		return orgOrder;
	}

	public void setOrgOrder(OrgOrder orgOrder) {
		this.orgOrder = orgOrder;
	}

	public OrgReturnOrder getOrgReturnOrder() {
		return orgReturnOrder;
	}

	public void setOrgReturnOrder(OrgReturnOrder orgReturnOrder) {
		this.orgReturnOrder = orgReturnOrder;
	}

	public BigDecimal getGoodsPayMoney() {
		return goodsPayMoney;
	}

	public void setGoodsPayMoney(BigDecimal goodsPayMoney) {
		this.goodsPayMoney = goodsPayMoney;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}