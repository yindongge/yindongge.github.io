package com.kjj.commserver.entity.shop;

import java.util.Date;

public class OrgBusinessArea {
    /**  */
    private Integer id;

    /**  */
    private String name;

    /** 区域对应org_area表code字段 */
    private String areaCode;

    /** 排序:1到255 */
    private Short businessAreaOrder;

    /** 范围说明 */
    private String rangeExplain;

    /** 状态 0：有效1：无效 */
    private Byte status;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Short getBusinessAreaOrder() {
        return businessAreaOrder;
    }

    public void setBusinessAreaOrder(Short businessAreaOrder) {
        this.businessAreaOrder = businessAreaOrder;
    }

    public String getRangeExplain() {
        return rangeExplain;
    }

    public void setRangeExplain(String rangeExplain) {
        this.rangeExplain = rangeExplain == null ? null : rangeExplain.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        OrgBusinessArea other = (OrgBusinessArea) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getBusinessAreaOrder() == null ? other.getBusinessAreaOrder() == null : this.getBusinessAreaOrder().equals(other.getBusinessAreaOrder()))
            && (this.getRangeExplain() == null ? other.getRangeExplain() == null : this.getRangeExplain().equals(other.getRangeExplain()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getBusinessAreaOrder() == null) ? 0 : getBusinessAreaOrder().hashCode());
        result = prime * result + ((getRangeExplain() == null) ? 0 : getRangeExplain().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", businessAreaOrder=").append(businessAreaOrder);
        sb.append(", rangeExplain=").append(rangeExplain);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}