package com.kjj.commserver.entity.goods;

public class OrgProductLinkSubclass {
    /** 产品id */
    private Integer orgProductId;

    /** 分类id */
    private Integer subClassid;

    /** skuId(暂无数据) */
    private Integer itemId;

    public Integer getOrgProductId() {
        return orgProductId;
    }

    public void setOrgProductId(Integer orgProductId) {
        this.orgProductId = orgProductId;
    }

    public Integer getSubClassid() {
        return subClassid;
    }

    public void setSubClassid(Integer subClassid) {
        this.subClassid = subClassid;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
        OrgProductLinkSubclass other = (OrgProductLinkSubclass) that;
        return (this.getOrgProductId() == null ? other.getOrgProductId() == null : this.getOrgProductId().equals(other.getOrgProductId()))
            && (this.getSubClassid() == null ? other.getSubClassid() == null : this.getSubClassid().equals(other.getSubClassid()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrgProductId() == null) ? 0 : getOrgProductId().hashCode());
        result = prime * result + ((getSubClassid() == null) ? 0 : getSubClassid().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgProductId=").append(orgProductId);
        sb.append(", subClassid=").append(subClassid);
        sb.append(", itemId=").append(itemId);
        sb.append("]");
        return sb.toString();
    }
}