package com.kjj.commserver.entity.shop;

public class OrgShopSendRange {
    /**  */
    private Integer id;

    /** 店铺id对应org_shop表shop_id字段 */
    private Integer shopId;

    /** 派送范围名称 */
    private String sendRangeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getSendRangeName() {
        return sendRangeName;
    }

    public void setSendRangeName(String sendRangeName) {
        this.sendRangeName = sendRangeName == null ? null : sendRangeName.trim();
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
        OrgShopSendRange other = (OrgShopSendRange) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getSendRangeName() == null ? other.getSendRangeName() == null : this.getSendRangeName().equals(other.getSendRangeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getSendRangeName() == null) ? 0 : getSendRangeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopId=").append(shopId);
        sb.append(", sendRangeName=").append(sendRangeName);
        sb.append("]");
        return sb.toString();
    }
}