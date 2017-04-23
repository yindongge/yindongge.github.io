package com.kjj.commserver.entity.discount;

public class OrgDiscountScope {
    /** 主键 */
    private Integer id;

    /** 优惠类型id 对应org_discount_type表discount_type_id字段 */
    private Byte typeId;

    /** 优惠id 对应各种优惠活动的id，和本表的type_id字段组合使用确定唯一的优惠活动 */
    private Integer discountId;

    /** 适用范围 1：PC2：触屏版 */
    private Byte scope;

    public OrgDiscountScope(){
    	super();
    }
    
    public OrgDiscountScope(Byte typeId, Integer discountId) {
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

    public Byte getScope() {
        return scope;
    }

    public void setScope(Byte scope) {
        this.scope = scope;
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
        OrgDiscountScope other = (OrgDiscountScope) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getDiscountId() == null ? other.getDiscountId() == null : this.getDiscountId().equals(other.getDiscountId()))
            && (this.getScope() == null ? other.getScope() == null : this.getScope().equals(other.getScope()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getDiscountId() == null) ? 0 : getDiscountId().hashCode());
        result = prime * result + ((getScope() == null) ? 0 : getScope().hashCode());
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
        sb.append(", scope=").append(scope);
        sb.append("]");
        return sb.toString();
    }
}