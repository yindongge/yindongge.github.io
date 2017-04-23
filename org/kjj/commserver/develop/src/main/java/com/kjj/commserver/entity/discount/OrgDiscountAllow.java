package com.kjj.commserver.entity.discount;

public class OrgDiscountAllow {
    /** 主键 */
    private Integer id;

    /** 优惠类型id 对应org_discount_type表discount_type_id字段 */
    private Byte typeId;

    /** 优惠id 对应各种优惠活动的id，和本表的type_id字段组合使用确定唯一的优惠活动 */
    private Integer discountId;

    /** 允许的其他优惠类型id 对应org_discount_type表discount_type_id字段 */
    private Byte allowTypeId;

    public OrgDiscountAllow() {
		super();
	}

	public OrgDiscountAllow(Byte typeId, int discountId) {
		super();
		this.typeId = typeId;
		this.discountId = discountId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Byte getAllowTypeId() {
        return allowTypeId;
    }

    public void setAllowTypeId(Byte allowTypeId) {
        this.allowTypeId = allowTypeId;
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
        OrgDiscountAllow other = (OrgDiscountAllow) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getDiscountId() == null ? other.getDiscountId() == null : this.getDiscountId().equals(other.getDiscountId()))
            && (this.getAllowTypeId() == null ? other.getAllowTypeId() == null : this.getAllowTypeId().equals(other.getAllowTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getDiscountId() == null) ? 0 : getDiscountId().hashCode());
        result = prime * result + ((getAllowTypeId() == null) ? 0 : getAllowTypeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typeId=").append(typeId);
        sb.append(", discountId=").append(discountId);
        sb.append(", allowTypeId=").append(allowTypeId);
        sb.append("]");
        return sb.toString();
    }
}