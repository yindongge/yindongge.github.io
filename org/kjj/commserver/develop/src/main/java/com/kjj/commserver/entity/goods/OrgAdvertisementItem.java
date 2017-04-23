package com.kjj.commserver.entity.goods;

import java.util.Date;

public class OrgAdvertisementItem {
    /** 热门推荐item Id */
    private Integer advertisementItemId;

    /** 热门推荐id */
    private Integer advertisementId;

    /** spuId */
    private Integer productParentId;

    /** skuId */
    private Integer productId;

    /** 创建时间 */
    private Date timestamp;

    public Integer getAdvertisementItemId() {
        return advertisementItemId;
    }

    public void setAdvertisementItemId(Integer advertisementItemId) {
        this.advertisementItemId = advertisementItemId;
    }

    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public Integer getProductParentId() {
        return productParentId;
    }

    public void setProductParentId(Integer productParentId) {
        this.productParentId = productParentId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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
        OrgAdvertisementItem other = (OrgAdvertisementItem) that;
        return (this.getAdvertisementItemId() == null ? other.getAdvertisementItemId() == null : this.getAdvertisementItemId().equals(other.getAdvertisementItemId()))
            && (this.getAdvertisementId() == null ? other.getAdvertisementId() == null : this.getAdvertisementId().equals(other.getAdvertisementId()))
            && (this.getProductParentId() == null ? other.getProductParentId() == null : this.getProductParentId().equals(other.getProductParentId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdvertisementItemId() == null) ? 0 : getAdvertisementItemId().hashCode());
        result = prime * result + ((getAdvertisementId() == null) ? 0 : getAdvertisementId().hashCode());
        result = prime * result + ((getProductParentId() == null) ? 0 : getProductParentId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", advertisementItemId=").append(advertisementItemId);
        sb.append(", advertisementId=").append(advertisementId);
        sb.append(", productParentId=").append(productParentId);
        sb.append(", productId=").append(productId);
        sb.append(", timestamp=").append(timestamp);
        sb.append("]");
        return sb.toString();
    }
}