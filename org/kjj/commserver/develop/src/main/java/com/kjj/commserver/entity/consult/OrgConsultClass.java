package com.kjj.commserver.entity.consult;

public class OrgConsultClass {
    /**分类ID*/
    private Integer consultClassId;

    /** 咨询分类名称 */
    private String consultClassName;

    /**保留字段*/
    private Byte isWebConsult;

    public Integer getConsultClassId() {
        return consultClassId;
    }

    public void setConsultClassId(Integer consultClassId) {
        this.consultClassId = consultClassId;
    }

    public String getConsultClassName() {
        return consultClassName;
    }

    public void setConsultClassName(String consultClassName) {
        this.consultClassName = consultClassName == null ? null : consultClassName.trim();
    }

    public Byte getIsWebConsult() {
        return isWebConsult;
    }

    public void setIsWebConsult(Byte isWebConsult) {
        this.isWebConsult = isWebConsult;
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
        OrgConsultClass other = (OrgConsultClass) that;
        return (this.getConsultClassId() == null ? other.getConsultClassId() == null : this.getConsultClassId().equals(other.getConsultClassId()))
            && (this.getConsultClassName() == null ? other.getConsultClassName() == null : this.getConsultClassName().equals(other.getConsultClassName()))
            && (this.getIsWebConsult() == null ? other.getIsWebConsult() == null : this.getIsWebConsult().equals(other.getIsWebConsult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConsultClassId() == null) ? 0 : getConsultClassId().hashCode());
        result = prime * result + ((getConsultClassName() == null) ? 0 : getConsultClassName().hashCode());
        result = prime * result + ((getIsWebConsult() == null) ? 0 : getIsWebConsult().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", consultClassId=").append(consultClassId);
        sb.append(", consultClassName=").append(consultClassName);
        sb.append(", isWebConsult=").append(isWebConsult);
        sb.append("]");
        return sb.toString();
    }
}