package com.kjj.commserver.entity.goods;

public class OrgProductInventoryClear {
    /**  */
    private Integer id;

    /** 店铺编号,对应org_shop表shop_code字段 */
    private String shopCode;

    /** 情况库存时间类型 */
    private Byte timeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Byte getTimeType() {
        return timeType;
    }

    public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public void setTimeType(Byte timeType) {
        this.timeType = timeType;
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
        OrgProductInventoryClear other = (OrgProductInventoryClear) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShopCode() == null ? other.getShopCode() == null : this.getShopCode().equals(other.getShopCode()))
            && (this.getTimeType() == null ? other.getTimeType() == null : this.getTimeType().equals(other.getTimeType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShopCode() == null) ? 0 : getShopCode().hashCode());
        result = prime * result + ((getTimeType() == null) ? 0 : getTimeType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ShopCode=").append(shopCode);
        sb.append(", timeType=").append(timeType);
        sb.append("]");
        return sb.toString();
    }
}