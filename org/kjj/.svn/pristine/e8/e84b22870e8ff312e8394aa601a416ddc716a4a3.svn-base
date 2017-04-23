package com.kjj.commserver.entity.goods;

import java.util.Date;

public class OrgAdvertisement {
    /** 热门推荐id */
    private Integer advertisementId;

    /** 商品分类id -1，默认不选择商品分类*/
    private Integer productClassId;

    /** 商品分类等级 */
    private Integer productClassLevel;

    /** 热门推荐类型id */
    private Integer typeId;

    /**  */
    private Byte isDelete;

    /**  */
    private Byte isActive;

    /** 创建时间 */
    private Date timestamp;

    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public Integer getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(Integer productClassId) {
        this.productClassId = productClassId;
    }

    public Integer getProductClassLevel() {
        return productClassLevel;
    }

    public void setProductClassLevel(Integer productClassLevel) {
        this.productClassLevel = productClassLevel;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
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
        OrgAdvertisement other = (OrgAdvertisement) that;
        return (this.getAdvertisementId() == null ? other.getAdvertisementId() == null : this.getAdvertisementId().equals(other.getAdvertisementId()))
            && (this.getProductClassId() == null ? other.getProductClassId() == null : this.getProductClassId().equals(other.getProductClassId()))
            && (this.getProductClassLevel() == null ? other.getProductClassLevel() == null : this.getProductClassLevel().equals(other.getProductClassLevel()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdvertisementId() == null) ? 0 : getAdvertisementId().hashCode());
        result = prime * result + ((getProductClassId() == null) ? 0 : getProductClassId().hashCode());
        result = prime * result + ((getProductClassLevel() == null) ? 0 : getProductClassLevel().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsActive() == null) ? 0 : getIsActive().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", advertisementId=").append(advertisementId);
        sb.append(", productClassId=").append(productClassId);
        sb.append(", productClassLevel=").append(productClassLevel);
        sb.append(", typeId=").append(typeId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isActive=").append(isActive);
        sb.append(", timestamp=").append(timestamp);
        sb.append("]");
        return sb.toString();
    }
}