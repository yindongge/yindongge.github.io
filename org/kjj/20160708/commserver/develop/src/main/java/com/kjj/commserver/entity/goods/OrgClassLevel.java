package com.kjj.commserver.entity.goods;

public class OrgClassLevel {
    /**  */
    private Integer classLevelId;

    /**  */
    private String classLevelname;

    public Integer getClassLevelId() {
        return classLevelId;
    }

    public void setClassLevelId(Integer classLevelId) {
        this.classLevelId = classLevelId;
    }

    public String getClassLevelname() {
        return classLevelname;
    }

    public void setClassLevelname(String classLevelname) {
        this.classLevelname = classLevelname == null ? null : classLevelname.trim();
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
        OrgClassLevel other = (OrgClassLevel) that;
        return (this.getClassLevelId() == null ? other.getClassLevelId() == null : this.getClassLevelId().equals(other.getClassLevelId()))
            && (this.getClassLevelname() == null ? other.getClassLevelname() == null : this.getClassLevelname().equals(other.getClassLevelname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClassLevelId() == null) ? 0 : getClassLevelId().hashCode());
        result = prime * result + ((getClassLevelname() == null) ? 0 : getClassLevelname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classLevelId=").append(classLevelId);
        sb.append(", classLevelname=").append(classLevelname);
        sb.append("]");
        return sb.toString();
    }
}