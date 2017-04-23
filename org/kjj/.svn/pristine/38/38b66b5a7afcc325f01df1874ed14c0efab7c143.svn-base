package com.kjj.commserver.entity.goods;

public class OrgAdvertisementType {
    /** 热门推荐类型id */
    private Integer advertisementTypeId;

    /** 热门推荐类型名称 */
    private String advertisementTypeName;

    public Integer getAdvertisementTypeId() {
        return advertisementTypeId;
    }

    public void setAdvertisementTypeId(Integer advertisementTypeId) {
        this.advertisementTypeId = advertisementTypeId;
    }

    public String getAdvertisementTypeName() {
        return advertisementTypeName;
    }

    public void setAdvertisementTypeName(String advertisementTypeName) {
        this.advertisementTypeName = advertisementTypeName == null ? null : advertisementTypeName.trim();
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
        OrgAdvertisementType other = (OrgAdvertisementType) that;
        return (this.getAdvertisementTypeId() == null ? other.getAdvertisementTypeId() == null : this.getAdvertisementTypeId().equals(other.getAdvertisementTypeId()))
            && (this.getAdvertisementTypeName() == null ? other.getAdvertisementTypeName() == null : this.getAdvertisementTypeName().equals(other.getAdvertisementTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdvertisementTypeId() == null) ? 0 : getAdvertisementTypeId().hashCode());
        result = prime * result + ((getAdvertisementTypeName() == null) ? 0 : getAdvertisementTypeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", advertisementTypeId=").append(advertisementTypeId);
        sb.append(", advertisementTypeName=").append(advertisementTypeName);
        sb.append("]");
        return sb.toString();
    }
}