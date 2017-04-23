package com.kjj.commserver.entity.special;

public class OrgSpecialWeek {
    /**  */
    private Integer id;

    /** 对应表org_special中的special_id */
    private Integer specialId;

    /** 周几的code值，周一为2，类推，周日为1 */
    private Byte weekCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }

    public Byte getWeekCode() {
        return weekCode;
    }

    public void setWeekCode(Byte weekCode) {
        this.weekCode = weekCode;
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
        OrgSpecialWeek other = (OrgSpecialWeek) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpecialId() == null ? other.getSpecialId() == null : this.getSpecialId().equals(other.getSpecialId()))
            && (this.getWeekCode() == null ? other.getWeekCode() == null : this.getWeekCode().equals(other.getWeekCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpecialId() == null) ? 0 : getSpecialId().hashCode());
        result = prime * result + ((getWeekCode() == null) ? 0 : getWeekCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", specialId=").append(specialId);
        sb.append(", weekCode=").append(weekCode);
        sb.append("]");
        return sb.toString();
    }
}