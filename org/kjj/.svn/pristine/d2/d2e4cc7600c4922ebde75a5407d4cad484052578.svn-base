package com.kjj.commserver.entity.goods;

public class OrgProductLinkSalespec {
    /** 商品规格关联表主键 */
    private Integer goodsSalespecId;

    /** skuId */
    private Integer goodsId;

    /** 规格名Id */
    private Short specId;

    /** 规格值Id */
    private Short specTypeId;

    /** 规格值 */
    private String specValue;

    /** 规格图片Url */
    private String specUrl;

    public Integer getGoodsSalespecId() {
        return goodsSalespecId;
    }

    public void setGoodsSalespecId(Integer goodsSalespecId) {
        this.goodsSalespecId = goodsSalespecId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Short getSpecId() {
        return specId;
    }

    public void setSpecId(Short specId) {
        this.specId = specId;
    }

    public Short getSpecTypeId() {
        return specTypeId;
    }

    public void setSpecTypeId(Short specTypeId) {
        this.specTypeId = specTypeId;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue == null ? null : specValue.trim();
    }

    public String getSpecUrl() {
        return specUrl;
    }

    public void setSpecUrl(String specUrl) {
        this.specUrl = specUrl == null ? null : specUrl.trim();
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
        OrgProductLinkSalespec other = (OrgProductLinkSalespec) that;
        return (this.getGoodsSalespecId() == null ? other.getGoodsSalespecId() == null : this.getGoodsSalespecId().equals(other.getGoodsSalespecId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()))
            && (this.getSpecTypeId() == null ? other.getSpecTypeId() == null : this.getSpecTypeId().equals(other.getSpecTypeId()))
            && (this.getSpecValue() == null ? other.getSpecValue() == null : this.getSpecValue().equals(other.getSpecValue()))
            && (this.getSpecUrl() == null ? other.getSpecUrl() == null : this.getSpecUrl().equals(other.getSpecUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsSalespecId() == null) ? 0 : getGoodsSalespecId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
        result = prime * result + ((getSpecTypeId() == null) ? 0 : getSpecTypeId().hashCode());
        result = prime * result + ((getSpecValue() == null) ? 0 : getSpecValue().hashCode());
        result = prime * result + ((getSpecUrl() == null) ? 0 : getSpecUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsSalespecId=").append(goodsSalespecId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", specId=").append(specId);
        sb.append(", specTypeId=").append(specTypeId);
        sb.append(", specValue=").append(specValue);
        sb.append(", specUrl=").append(specUrl);
        sb.append("]");
        return sb.toString();
    }
}