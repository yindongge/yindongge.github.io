package com.kjj.commserver.entity.discount.aide;

import java.math.BigDecimal;

import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.OrgReachCondition;

public class OrgReachVo extends OrgReach {
	
	/** 金额合计 */
	private BigDecimal sumMoney = BigDecimal.ZERO;
	
	/** 件数合计 */
	private int sumAmount = 0;
	
	/** 优惠条件 */
	private OrgReachCondition orgReachCondition;
	
	public BigDecimal getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
	public int getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(int sumAmount) {
		this.sumAmount = sumAmount;
	}
	public OrgReachCondition getOrgReachCondition() {
		return orgReachCondition;
	}
	public void setOrgReachCondition(OrgReachCondition orgReachCondition) {
		this.orgReachCondition = orgReachCondition;
	}
	
}