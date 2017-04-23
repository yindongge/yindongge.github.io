package com.kjj.commserver.entity.discount.aide;

import java.math.BigDecimal;

import com.kjj.commserver.entity.discount.OrgCoupon;
import com.kjj.commserver.entity.discount.OrgCouponRecord;

public class OrgCouponRecordVo extends OrgCouponRecord {
	
	/** 优惠券信息 */
	private OrgCoupon orgCoupon;
	
	/** 下单商品满足优惠券条件总金额 */
	private BigDecimal sumMoney;
	
	/** 会员名称 */
	private String userName;
	
	public OrgCoupon getOrgCoupon() {
		return orgCoupon;
	}

	public void setOrgCoupon(OrgCoupon orgCoupon) {
		this.orgCoupon = orgCoupon;
	}

	public BigDecimal getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}