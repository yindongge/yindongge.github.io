package com.kjj.commserver.entity.user.aide;

import java.math.BigDecimal;

import com.kjj.commserver.entity.user.OrgUsers;

public class OrgUsersVo extends OrgUsers {
	
	/** 总消费金额 */
	private BigDecimal total;
	
	/** 会员级别对应的折扣 */
	private BigDecimal discount;
	
	/** 用户会员等级信息  */
	private String levelName;

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
}