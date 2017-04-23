package com.kjj.commserver.entity.goods;

public class OrgProductProperty {
    /**  */
    private Integer propertyId;

    /** 排序 */
    private Integer propertyOrder;

    /** 属性名称 */
    private String propertyName;

    /** 属性录入方式：1手动输入2单选组3列表单选4复选框 */
    private Integer propertyInputType;

    /** 是否必选：1是0否 */
    private Byte propertySelect;

    /** 是否启用：1是0否 */
    private String isActive;

    /** 是否删除：1是0否 */
    private String isDelete;

    /**  */
    private String property1;

    /**  */
    private String property2;

    /**  */
    private String property3;

    /** 属性值 */
    private String propertyValue;

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getPropertyOrder() {
        return propertyOrder;
    }

    public void setPropertyOrder(Integer propertyOrder) {
        this.propertyOrder = propertyOrder;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    public Integer getPropertyInputType() {
        return propertyInputType;
    }

    public void setPropertyInputType(Integer propertyInputType) {
        this.propertyInputType = propertyInputType;
    }

    public Byte getPropertySelect() {
        return propertySelect;
    }

    public void setPropertySelect(Byte propertySelect) {
        this.propertySelect = propertySelect;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1 == null ? null : property1.trim();
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2 == null ? null : property2.trim();
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        this.property3 = property3 == null ? null : property3.trim();
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
        OrgProductProperty other = (OrgProductProperty) that;
        return (this.getPropertyId() == null ? other.getPropertyId() == null : this.getPropertyId().equals(other.getPropertyId()))
            && (this.getPropertyOrder() == null ? other.getPropertyOrder() == null : this.getPropertyOrder().equals(other.getPropertyOrder()))
            && (this.getPropertyName() == null ? other.getPropertyName() == null : this.getPropertyName().equals(other.getPropertyName()))
            && (this.getPropertyInputType() == null ? other.getPropertyInputType() == null : this.getPropertyInputType().equals(other.getPropertyInputType()))
            && (this.getPropertySelect() == null ? other.getPropertySelect() == null : this.getPropertySelect().equals(other.getPropertySelect()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getProperty1() == null ? other.getProperty1() == null : this.getProperty1().equals(other.getProperty1()))
            && (this.getProperty2() == null ? other.getProperty2() == null : this.getProperty2().equals(other.getProperty2()))
            && (this.getProperty3() == null ? other.getProperty3() == null : this.getProperty3().equals(other.getProperty3()))
            && (this.getPropertyValue() == null ? other.getPropertyValue() == null : this.getPropertyValue().equals(other.getPropertyValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPropertyId() == null) ? 0 : getPropertyId().hashCode());
        result = prime * result + ((getPropertyOrder() == null) ? 0 : getPropertyOrder().hashCode());
        result = prime * result + ((getPropertyName() == null) ? 0 : getPropertyName().hashCode());
        result = prime * result + ((getPropertyInputType() == null) ? 0 : getPropertyInputType().hashCode());
        result = prime * result + ((getPropertySelect() == null) ? 0 : getPropertySelect().hashCode());
        result = prime * result + ((getIsActive() == null) ? 0 : getIsActive().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getProperty1() == null) ? 0 : getProperty1().hashCode());
        result = prime * result + ((getProperty2() == null) ? 0 : getProperty2().hashCode());
        result = prime * result + ((getProperty3() == null) ? 0 : getProperty3().hashCode());
        result = prime * result + ((getPropertyValue() == null) ? 0 : getPropertyValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", propertyId=").append(propertyId);
        sb.append(", propertyOrder=").append(propertyOrder);
        sb.append(", propertyName=").append(propertyName);
        sb.append(", propertyInputType=").append(propertyInputType);
        sb.append(", propertySelect=").append(propertySelect);
        sb.append(", isActive=").append(isActive);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", property1=").append(property1);
        sb.append(", property2=").append(property2);
        sb.append(", property3=").append(property3);
        sb.append(", propertyValue=").append(propertyValue);
        sb.append("]");
        return sb.toString();
    }
}