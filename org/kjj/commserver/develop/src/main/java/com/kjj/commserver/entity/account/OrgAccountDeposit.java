package com.kjj.commserver.entity.account;

import java.math.BigDecimal;

public class OrgAccountDeposit {
    /** 与org_users表的user_id对应 */
    private Integer userId;

    /** 与org_users表的user_code对应 */
    private String userCode;

    /** 可用可提现金额 */
    private BigDecimal fundAmount;

    /** 可用不可提现金额 */
    private BigDecimal allowanceAmount;

    /** 冻结金额 */
    private BigDecimal frozenAmount;

    /** 0正常 1 锁定 */
    private Byte status;

    /** 支付密码 */
    private String payPassword;
    
    /** 锁定级别,1为自动锁定2为管理员锁定 */
    private Byte lockLevel;
    
    /** 扣款时密码输入错误次数 */
    private Integer errorNum;

    public Byte getLockLevel() {
		return lockLevel;
	}

	public void setLockLevel(Byte lockLevel) {
		this.lockLevel = lockLevel;
	}

	public Integer getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }
    
    public BigDecimal getFundAmount() {
		return fundAmount;
	}

	public void setFundAmount(BigDecimal fundAmount) {
		this.fundAmount = fundAmount;
	}

	public BigDecimal getAllowanceAmount() {
		return allowanceAmount;
	}

	public void setAllowanceAmount(BigDecimal allowanceAmount) {
		this.allowanceAmount = allowanceAmount;
	}

	public BigDecimal getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(BigDecimal frozenAmount) {
		this.frozenAmount = frozenAmount;
	}

	public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrgAccountDeposit other = (OrgAccountDeposit) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserCode() == null ? other.getUserCode() == null : this.getUserCode().equals(other.getUserCode()))
            && (this.getFundAmount() == null ? other.getFundAmount() == null : this.getFundAmount().equals(other.getFundAmount()))
            && (this.getAllowanceAmount() == null ? other.getAllowanceAmount() == null : this.getAllowanceAmount().equals(other.getAllowanceAmount()))
            && (this.getFrozenAmount() == null ? other.getFrozenAmount() == null : this.getFrozenAmount().equals(other.getFrozenAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPayPassword() == null ? other.getPayPassword() == null : this.getPayPassword().equals(other.getPayPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());
        result = prime * result + ((getFundAmount() == null) ? 0 : getFundAmount().hashCode());
        result = prime * result + ((getAllowanceAmount() == null) ? 0 : getAllowanceAmount().hashCode());
        result = prime * result + ((getFrozenAmount() == null) ? 0 : getFrozenAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPayPassword() == null) ? 0 : getPayPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userCode=").append(userCode);
        sb.append(", fundAmount=").append(fundAmount);
        sb.append(", allowanceAmount=").append(allowanceAmount);
        sb.append(", frozenAmount=").append(frozenAmount);
        sb.append(", status=").append(status);
        sb.append(", payPassword=").append(payPassword);
        sb.append("]");
        return sb.toString();
    }
}