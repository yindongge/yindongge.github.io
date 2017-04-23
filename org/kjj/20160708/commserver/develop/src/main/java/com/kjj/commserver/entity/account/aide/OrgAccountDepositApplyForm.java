package com.kjj.commserver.entity.account.aide;

import java.math.BigDecimal;

import com.kjj.commserver.entity.account.OrgAccountDepositApply;

public class OrgAccountDepositApplyForm extends OrgAccountDepositApply {
	/** 预存款类型*/
	private String depositType;
	
	/** 用户组Id*/
	private Integer groupId;
	
	/** 用户组名称*/
	private String groupName;
	
	/** 金额 */
	private BigDecimal amount;
	

	
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
