package com.kjj.commserver.entity.user;

import java.math.BigDecimal;

public class OrgUserLevel {
    /** 会员级别编码 */
    private String levelId;

    /** 级别名称 */
    private String levelName;

    /** 可否积分，1，是；0，否 */
    private Byte isIntegral;

    /** 可否折扣，1，是；0，否 */
    private Byte isDiscount;

    /** 折扣比率 */
    private BigDecimal discount;

    /** 级别类型，1，个人；2，企业 */
    private Byte levelType;

    /** 消费上线 */
    private BigDecimal consumeTop;

    /** 消费下线 */
    private BigDecimal consumeDown;

    /** 积分 */
    private BigDecimal integral;
    
    /** 排序，值越大级别越高 */
    private Byte levelOrder;

    public Byte getLevelOrder() {
		return levelOrder;
	}

	public void setLevelOrder(Byte levelOrder) {
		this.levelOrder = levelOrder;
	}

	public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Byte getIsIntegral() {
        return isIntegral;
    }

    public void setIsIntegral(Byte isIntegral) {
        this.isIntegral = isIntegral;
    }

    public Byte getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Byte isDiscount) {
        this.isDiscount = isDiscount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Byte getLevelType() {
        return levelType;
    }

    public void setLevelType(Byte levelType) {
        this.levelType = levelType;
    }

    public BigDecimal getConsumeTop() {
        return consumeTop;
    }

    public void setConsumeTop(BigDecimal consumeTop) {
        this.consumeTop = consumeTop;
    }

    public BigDecimal getConsumeDown() {
        return consumeDown;
    }

    public void setConsumeDown(BigDecimal consumeDown) {
        this.consumeDown = consumeDown;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
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
        OrgUserLevel other = (OrgUserLevel) that;
        return (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
            && (this.getLevelName() == null ? other.getLevelName() == null : this.getLevelName().equals(other.getLevelName()))
            && (this.getIsIntegral() == null ? other.getIsIntegral() == null : this.getIsIntegral().equals(other.getIsIntegral()))
            && (this.getIsDiscount() == null ? other.getIsDiscount() == null : this.getIsDiscount().equals(other.getIsDiscount()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getLevelType() == null ? other.getLevelType() == null : this.getLevelType().equals(other.getLevelType()))
            && (this.getConsumeTop() == null ? other.getConsumeTop() == null : this.getConsumeTop().equals(other.getConsumeTop()))
            && (this.getConsumeDown() == null ? other.getConsumeDown() == null : this.getConsumeDown().equals(other.getConsumeDown()))
            && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
            && (this.getLevelOrder() == null ? other.getLevelOrder() == null : this.getLevelOrder().equals(other.getLevelOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
        result = prime * result + ((getLevelName() == null) ? 0 : getLevelName().hashCode());
        result = prime * result + ((getIsIntegral() == null) ? 0 : getIsIntegral().hashCode());
        result = prime * result + ((getIsDiscount() == null) ? 0 : getIsDiscount().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getLevelType() == null) ? 0 : getLevelType().hashCode());
        result = prime * result + ((getConsumeTop() == null) ? 0 : getConsumeTop().hashCode());
        result = prime * result + ((getConsumeDown() == null) ? 0 : getConsumeDown().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getLevelOrder() == null) ? 0 : getLevelOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", levelId=").append(levelId);
        sb.append(", levelName=").append(levelName);
        sb.append(", isIntegral=").append(isIntegral);
        sb.append(", isDiscount=").append(isDiscount);
        sb.append(", discount=").append(discount);
        sb.append(", levelType=").append(levelType);
        sb.append(", consumeTop=").append(consumeTop);
        sb.append(", consumeDown=").append(consumeDown);
        sb.append(", integral=").append(integral);
        sb.append(", levelOrder=").append(levelOrder);
        sb.append("]");
        return sb.toString();
    }
}