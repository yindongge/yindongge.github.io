package com.kjj.commserver.entity.goods;

public class OrgProductTypeLinkProductProperty {
    /** 商品类型属性关联表主键 */
    private Integer productTypeSpecId;

    /** 商品类型Id */
    private Integer productTypeId;

    /** 商品属性Id */
    private Integer propertyId;

    public Integer getProductTypeSpecId() {
        return productTypeSpecId;
    }

    public void setProductTypeSpecId(Integer productTypeSpecId) {
        this.productTypeSpecId = productTypeSpecId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
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
        OrgProductTypeLinkProductProperty other = (OrgProductTypeLinkProductProperty) that;
        return (this.getProductTypeSpecId() == null ? other.getProductTypeSpecId() == null : this.getProductTypeSpecId().equals(other.getProductTypeSpecId()))
            && (this.getProductTypeId() == null ? other.getProductTypeId() == null : this.getProductTypeId().equals(other.getProductTypeId()))
            && (this.getPropertyId() == null ? other.getPropertyId() == null : this.getPropertyId().equals(other.getPropertyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductTypeSpecId() == null) ? 0 : getProductTypeSpecId().hashCode());
        result = prime * result + ((getProductTypeId() == null) ? 0 : getProductTypeId().hashCode());
        result = prime * result + ((getPropertyId() == null) ? 0 : getPropertyId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productTypeSpecId=").append(productTypeSpecId);
        sb.append(", productTypeId=").append(productTypeId);
        sb.append(", propertyId=").append(propertyId);
        sb.append("]");
        return sb.toString();
    }
}