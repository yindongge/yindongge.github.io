package com.kjj.commserver.entity.account;

import java.math.BigDecimal;
import java.util.Date;

public class OrgAccountDepositRecords {
    /**  */
    private Integer id;

    /** 与org_users表的user_id对应 */
    private Integer userId;

    /** 可用可提现金额增减值 */
    private BigDecimal fundAmount;

    /** 可用不可提现金额增减值 */
    private BigDecimal allowanceAmount;

    /** 冻结金额增减值 */
    private BigDecimal frozenAmount;

    /** 发生时间 */
    private Date createTime;

    /** 来源,1门店 2线上 3车帮 */
    private Byte origin;

    /** 1消费 2充值 3提现 4退款 5手动增减 6手动减少 7手动冻结 8手动解冻 9 系统冻结 10 系统解解冻 */
    private Byte type;
    
    /** 交易人，转账时使用 */
    private Integer traderId;

    /** 调用系统的业务标识内容 */
    private String serviceCode;

    /** 退款时调用系统的新业务标识内容 */
    private String quitCode;

    /** 备注 */
    private String comment;
    
    /** 申请原因 */
    private Byte reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getOrigin() {
        return origin;
    }

    public void setOrigin(Byte origin) {
        this.origin = origin;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode == null ? null : serviceCode.trim();
    }

    public String getQuitCode() {
        return quitCode;
    }

    public void setQuitCode(String quitCode) {
        this.quitCode = quitCode == null ? null : quitCode.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
    
    

    public Byte getReason() {
		return reason;
	}

	public void setReason(Byte reason) {
		this.reason = reason;
	}
	

	public Integer getTraderId() {
		return traderId;
	}

	public void setTraderId(Integer traderId) {
		this.traderId = traderId;
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
        OrgAccountDepositRecords other = (OrgAccountDepositRecords) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFundAmount() == null ? other.getFundAmount() == null : this.getFundAmount().equals(other.getFundAmount()))
            && (this.getAllowanceAmount() == null ? other.getAllowanceAmount() == null : this.getAllowanceAmount().equals(other.getAllowanceAmount()))
            && (this.getFrozenAmount() == null ? other.getFrozenAmount() == null : this.getFrozenAmount().equals(other.getFrozenAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOrigin() == null ? other.getOrigin() == null : this.getOrigin().equals(other.getOrigin()))
            && (this.getTraderId() == null ? other.getTraderId() == null : this.getTraderId().equals(other.getTraderId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getServiceCode() == null ? other.getServiceCode() == null : this.getServiceCode().equals(other.getServiceCode()))
            && (this.getQuitCode() == null ? other.getQuitCode() == null : this.getQuitCode().equals(other.getQuitCode()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFundAmount() == null) ? 0 : getFundAmount().hashCode());
        result = prime * result + ((getAllowanceAmount() == null) ? 0 : getAllowanceAmount().hashCode());
        result = prime * result + ((getFrozenAmount() == null) ? 0 : getFrozenAmount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOrigin() == null) ? 0 : getOrigin().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTraderId() == null) ? 0 : getTraderId().hashCode());
        result = prime * result + ((getServiceCode() == null) ? 0 : getServiceCode().hashCode());
        result = prime * result + ((getQuitCode() == null) ? 0 : getQuitCode().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", fundAmount=").append(fundAmount);
        sb.append(", allowanceAmount=").append(allowanceAmount);
        sb.append(", frozenAmount=").append(frozenAmount);
        sb.append(", createTime=").append(createTime);
        sb.append(", origin=").append(origin);
        sb.append(", type=").append(type);
        sb.append(", traderId=").append(traderId);
        sb.append(", serviceCode=").append(serviceCode);
        sb.append(", quitCode=").append(quitCode);
        sb.append(", comment=").append(comment);
        sb.append(", reason=").append(reason);
        sb.append("]");
        return sb.toString();
    }
}