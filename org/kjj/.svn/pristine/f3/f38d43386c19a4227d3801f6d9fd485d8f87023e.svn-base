package com.kjj.commserver.entity.goods;

public class OrgProductTypeLinkSaleSpec {
    /** 商品类型规格主键 */
    private Integer productTypeSpecId;

    /** 商品类型Id */
    private Integer productTypeId;

    /** 商品规格Id */
    private Integer specId;

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

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
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
        OrgProductTypeLinkSaleSpec other = (OrgProductTypeLinkSaleSpec) that;
        return (this.getProductTypeSpecId() == null ? other.getProductTypeSpecId() == null : this.getProductTypeSpecId().equals(other.getProductTypeSpecId()))
            && (this.getProductTypeId() == null ? other.getProductTypeId() == null : this.getProductTypeId().equals(other.getProductTypeId()))
            && (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductTypeSpecId() == null) ? 0 : getProductTypeSpecId().hashCode());
        result = prime * result + ((getProductTypeId() == null) ? 0 : getProductTypeId().hashCode());
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
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
        sb.append(", specId=").append(specId);
        sb.append("]");
        return sb.toString();
    }
}