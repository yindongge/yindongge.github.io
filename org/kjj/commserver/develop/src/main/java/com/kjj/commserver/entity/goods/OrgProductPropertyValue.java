package com.kjj.commserver.entity.goods;

public class OrgProductPropertyValue {
    /**  */
    private Integer propertyValueId;

    /**  */
    private Integer propertyId;

    /**  */
    private String propertyValue;

    /**  */
    private String propertyValue1;

    /**  */
    private String propertyValue2;

    /**  */
    private String propertyValue3;

    public Integer getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(Integer propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue == null ? null : propertyValue.trim();
    }

    public String getPropertyValue1() {
        return propertyValue1;
    }

    public void setPropertyValue1(String propertyValue1) {
        this.propertyValue1 = propertyValue1 == null ? null : propertyValue1.trim();
    }

    public String getPropertyValue2() {
        return propertyValue2;
    }

    public void setPropertyValue2(String propertyValue2) {
        this.propertyValue2 = propertyValue2 == null ? null : propertyValue2.trim();
    }

    public String getPropertyValue3() {
        return propertyValue3;
    }

    public void setPropertyValue3(String propertyValue3) {
        this.propertyValue3 = propertyValue3 == null ? null : propertyValue3.trim();
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
        OrgProductPropertyValue other = (OrgProductPropertyValue) that;
        return (this.getPropertyValueId() == null ? other.getPropertyValueId() == null : this.getPropertyValueId().equals(other.getPropertyValueId()))
            && (this.getPropertyId() == null ? other.getPropertyId() == null : this.getPropertyId().equals(other.getPropertyId()))
            && (this.getPropertyValue() == null ? other.getPropertyValue() == null : this.getPropertyValue().equals(other.getPropertyValue()))
            && (this.getPropertyValue1() == null ? other.getPropertyValue1() == null : this.getPropertyValue1().equals(other.getPropertyValue1()))
            && (this.getPropertyValue2() == null ? other.getPropertyValue2() == null : this.getPropertyValue2().equals(other.getPropertyValue2()))
            && (this.getPropertyValue3() == null ? other.getPropertyValue3() == null : this.getPropertyValue3().equals(other.getPropertyValue3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPropertyValueId() == null) ? 0 : getPropertyValueId().hashCode());
        result = prime * result + ((getPropertyId() == null) ? 0 : getPropertyId().hashCode());
        result = prime * result + ((getPropertyValue() == null) ? 0 : getPropertyValue().hashCode());
        result = prime * result + ((getPropertyValue1() == null) ? 0 : getPropertyValue1().hashCode());
        result = prime * result + ((getPropertyValue2() == null) ? 0 : getPropertyValue2().hashCode());
        result = prime * result + ((getPropertyValue3() == null) ? 0 : getPropertyValue3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", propertyValueId=").append(propertyValueId);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", propertyValue=").append(propertyValue);
        sb.append(", propertyValue1=").append(propertyValue1);
        sb.append(", propertyValue2=").append(propertyValue2);
        sb.append(", propertyValue3=").append(propertyValue3);
        sb.append("]");
        return sb.toString();
    }
}