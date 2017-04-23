package com.kjj.commserver.entity.goods;

public class OrgTradeSnapshootProperty {
    /** 交易快照属性id */
    private Integer tradeSnapshootPropertyId;

    /** 交易快照id */
    private Integer tradeSnapshootId;

    /** 属性名称 */
    private String propertyName;

    /** 属性值 */
    private String propertyValue;

    public Integer getTradeSnapshootPropertyId() {
        return tradeSnapshootPropertyId;
    }

    public void setTradeSnapshootPropertyId(Integer tradeSnapshootPropertyId) {
        this.tradeSnapshootPropertyId = tradeSnapshootPropertyId;
    }

    public Integer getTradeSnapshootId() {
        return tradeSnapshootId;
    }

    public void setTradeSnapshootId(Integer tradeSnapshootId) {
        this.tradeSnapshootId = tradeSnapshootId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue == null ? null : propertyValue.trim();
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
        OrgTradeSnapshootProperty other = (OrgTradeSnapshootProperty) that;
        return (this.getTradeSnapshootPropertyId() == null ? other.getTradeSnapshootPropertyId() == null : this.getTradeSnapshootPropertyId().equals(other.getTradeSnapshootPropertyId()))
            && (this.getTradeSnapshootId() == null ? other.getTradeSnapshootId() == null : this.getTradeSnapshootId().equals(other.getTradeSnapshootId()))
            && (this.getPropertyName() == null ? other.getPropertyName() == null : this.getPropertyName().equals(other.getPropertyName()))
            && (this.getPropertyValue() == null ? other.getPropertyValue() == null : this.getPropertyValue().equals(other.getPropertyValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTradeSnapshootPropertyId() == null) ? 0 : getTradeSnapshootPropertyId().hashCode());
        result = prime * result + ((getTradeSnapshootId() == null) ? 0 : getTradeSnapshootId().hashCode());
        result = prime * result + ((getPropertyName() == null) ? 0 : getPropertyName().hashCode());
        result = prime * result + ((getPropertyValue() == null) ? 0 : getPropertyValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tradeSnapshootPropertyId=").append(tradeSnapshootPropertyId);
        sb.append(", tradeSnapshootId=").append(tradeSnapshootId);
        sb.append(", propertyName=").append(propertyName);
        sb.append(", propertyValue=").append(propertyValue);
        sb.append("]");
        return sb.toString();
    }
}