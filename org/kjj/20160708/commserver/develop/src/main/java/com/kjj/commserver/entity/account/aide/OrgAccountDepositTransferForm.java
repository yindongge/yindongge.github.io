package com.kjj.commserver.entity.account.aide;

import java.math.BigDecimal;

public class OrgAccountDepositTransferForm {
	/** 收款人Id */
	private Integer userId;
	
	/** 转账金额 */
	private BigDecimal amount;
	
	/** 收款人账户余额 */
	private BigDecimal balance;
	
	/** 电话 */
	private String mobilePhone;

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
}
