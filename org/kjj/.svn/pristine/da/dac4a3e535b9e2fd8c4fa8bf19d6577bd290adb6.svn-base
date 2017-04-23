package com.kjj.commserver.entity.discount;

import java.math.BigDecimal;

public class OrgReachDiscount {
    /** 主键 */
    private Integer id;

    /** 满减条件ID 对应org_reach_condition表ID字段 */
    private Integer rcId;

    /** 优惠类型 1.减钱 2.赠送3.赠优惠券 */
    private Byte typeId;

    /** 是否叠加 0：否1：是 */
    private Byte isloop;

    /** 通用值 */
    private BigDecimal common;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRcId() {
        return rcId;
    }

    public void setRcId(Integer rcId) {
        this.rcId = rcId;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Byte getIsloop() {
        return isloop;
    }

    public void setIsloop(Byte isloop) {
        this.isloop = isloop;
    }

    public BigDecimal getCommon() {
        return common;
    }

    public void setCommon(BigDecimal common) {
        this.common = common;
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
        OrgReachDiscount other = (OrgReachDiscount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRcId() == null ? other.getRcId() == null : this.getRcId().equals(other.getRcId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getIsloop() == null ? other.getIsloop() == null : this.getIsloop().equals(other.getIsloop()))
            && (this.getCommon() == null ? other.getCommon() == null : this.getCommon().equals(other.getCommon()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRcId() == null) ? 0 : getRcId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getIsloop() == null) ? 0 : getIsloop().hashCode());
        result = prime * result + ((getCommon() == null) ? 0 : getCommon().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rcId=").append(rcId);
        sb.append(", typeId=").append(typeId);
        sb.append(", isloop=").append(isloop);
        sb.append(", common=").append(common);
        sb.append("]");
        return sb.toString();
    }
}