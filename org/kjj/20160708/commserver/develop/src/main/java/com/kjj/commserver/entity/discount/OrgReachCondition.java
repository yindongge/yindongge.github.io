package com.kjj.commserver.entity.discount;

import java.math.BigDecimal;

public class OrgReachCondition {
    /** 主键 */
    private Integer id;

    /** 满减优惠ID 对应org_reach表ID字段 */
    private Integer reachId;

    /** 满足条件 */
    private BigDecimal reachCondition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReachId() {
        return reachId;
    }

    public void setReachId(Integer reachId) {
        this.reachId = reachId;
    }

    public BigDecimal getReachCondition() {
        return reachCondition;
    }

    public void setReachCondition(BigDecimal reachCondition) {
        this.reachCondition = reachCondition;
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
        OrgReachCondition other = (OrgReachCondition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReachId() == null ? other.getReachId() == null : this.getReachId().equals(other.getReachId()))
            && (this.getReachCondition() == null ? other.getReachCondition() == null : this.getReachCondition().equals(other.getReachCondition()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReachId() == null) ? 0 : getReachId().hashCode());
        result = prime * result + ((getReachCondition() == null) ? 0 : getReachCondition().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", reachId=").append(reachId);
        sb.append(", reachCondition=").append(reachCondition);
        sb.append("]");
        return sb.toString();
    }
}