package com.kjj.commserver.entity.consult;

public class OrgConsultType {
    /**  */
    private Integer consultTypeId;

    /** 咨询分类id */
    private Integer consultClassId;

    /** 咨询类型名称 */
    private String consultTypeName;

    /** 是否删除： 1已删除  0未删除 */
    private Byte isDelete;

    /** 是否启用： 1已启用 0未启用 */
    private Byte isActive;

    public Integer getConsultTypeId() {
        return consultTypeId;
    }

    public void setConsultTypeId(Integer consultTypeId) {
        this.consultTypeId = consultTypeId;
    }

    public Integer getConsultClassId() {
        return consultClassId;
    }

    public void setConsultClassId(Integer consultClassId) {
        this.consultClassId = consultClassId;
    }

    public String getConsultTypeName() {
        return consultTypeName;
    }

    public void setConsultTypeName(String consultTypeName) {
        this.consultTypeName = consultTypeName == null ? null : consultTypeName.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
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
        OrgConsultType other = (OrgConsultType) that;
        return (this.getConsultTypeId() == null ? other.getConsultTypeId() == null : this.getConsultTypeId().equals(other.getConsultTypeId()))
            && (this.getConsultClassId() == null ? other.getConsultClassId() == null : this.getConsultClassId().equals(other.getConsultClassId()))
            && (this.getConsultTypeName() == null ? other.getConsultTypeName() == null : this.getConsultTypeName().equals(other.getConsultTypeName()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConsultTypeId() == null) ? 0 : getConsultTypeId().hashCode());
        result = prime * result + ((getConsultClassId() == null) ? 0 : getConsultClassId().hashCode());
        result = prime * result + ((getConsultTypeName() == null) ? 0 : getConsultTypeName().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsActive() == null) ? 0 : getIsActive().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", consultTypeId=").append(consultTypeId);
        sb.append(", consultClassId=").append(consultClassId);
        sb.append(", consultTypeName=").append(consultTypeName);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isActive=").append(isActive);
        sb.append("]");
        return sb.toString();
    }
}