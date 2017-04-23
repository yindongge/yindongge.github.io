package com.kjj.commserver.entity.consult;

public class OrgConsultState {
    /**  */
    private Integer consultStateId;

    /** 状态名称 */
    private String consultStateName;

    /** 状态类型：1 回复状态   2解决状态 */
    private Byte consultStateType;

    public Integer getConsultStateId() {
        return consultStateId;
    }

    public void setConsultStateId(Integer consultStateId) {
        this.consultStateId = consultStateId;
    }

    public String getConsultStateName() {
        return consultStateName;
    }

    public void setConsultStateName(String consultStateName) {
        this.consultStateName = consultStateName == null ? null : consultStateName.trim();
    }

    public Byte getConsultStateType() {
        return consultStateType;
    }

    public void setConsultStateType(Byte consultStateType) {
        this.consultStateType = consultStateType;
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
        OrgConsultState other = (OrgConsultState) that;
        return (this.getConsultStateId() == null ? other.getConsultStateId() == null : this.getConsultStateId().equals(other.getConsultStateId()))
            && (this.getConsultStateName() == null ? other.getConsultStateName() == null : this.getConsultStateName().equals(other.getConsultStateName()))
            && (this.getConsultStateType() == null ? other.getConsultStateType() == null : this.getConsultStateType().equals(other.getConsultStateType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConsultStateId() == null) ? 0 : getConsultStateId().hashCode());
        result = prime * result + ((getConsultStateName() == null) ? 0 : getConsultStateName().hashCode());
        result = prime * result + ((getConsultStateType() == null) ? 0 : getConsultStateType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", consultStateId=").append(consultStateId);
        sb.append(", consultStateName=").append(consultStateName);
        sb.append(", consultStateType=").append(consultStateType);
        sb.append("]");
        return sb.toString();
    }
}