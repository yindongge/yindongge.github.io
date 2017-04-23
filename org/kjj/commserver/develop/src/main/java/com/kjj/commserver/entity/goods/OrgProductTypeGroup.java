package com.kjj.commserver.entity.goods;

public class OrgProductTypeGroup {
    /** 商品类型分组主键 */
    private Integer groupId;

    /** 商品类型分组名称 */
    private String orgproductTypeGroupName;

    /** 排序号码 */
    private Short groupOrder;

    /** 货品分组状态  是否删除：1 true 0 false*/
    private Byte groupStatus;

    /**  */
    private String group1;

    /**  */
    private String group2;

    /**  */
    private String group3;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getOrgproductTypeGroupName() {
        return orgproductTypeGroupName;
    }

    public void setOrgproductTypeGroupName(String orgproductTypeGroupName) {
        this.orgproductTypeGroupName = orgproductTypeGroupName == null ? null : orgproductTypeGroupName.trim();
    }

    public Short getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(Short groupOrder) {
        this.groupOrder = groupOrder;
    }

    public Byte getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Byte groupStatus) {
        this.groupStatus = groupStatus;
    }

    public String getGroup1() {
        return group1;
    }

    public void setGroup1(String group1) {
        this.group1 = group1 == null ? null : group1.trim();
    }

    public String getGroup2() {
        return group2;
    }

    public void setGroup2(String group2) {
        this.group2 = group2 == null ? null : group2.trim();
    }

    public String getGroup3() {
        return group3;
    }

    public void setGroup3(String group3) {
        this.group3 = group3 == null ? null : group3.trim();
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
        OrgProductTypeGroup other = (OrgProductTypeGroup) that;
        return (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getOrgproductTypeGroupName() == null ? other.getOrgproductTypeGroupName() == null : this.getOrgproductTypeGroupName().equals(other.getOrgproductTypeGroupName()))
            && (this.getGroupOrder() == null ? other.getGroupOrder() == null : this.getGroupOrder().equals(other.getGroupOrder()))
            && (this.getGroupStatus() == null ? other.getGroupStatus() == null : this.getGroupStatus().equals(other.getGroupStatus()))
            && (this.getGroup1() == null ? other.getGroup1() == null : this.getGroup1().equals(other.getGroup1()))
            && (this.getGroup2() == null ? other.getGroup2() == null : this.getGroup2().equals(other.getGroup2()))
            && (this.getGroup3() == null ? other.getGroup3() == null : this.getGroup3().equals(other.getGroup3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getOrgproductTypeGroupName() == null) ? 0 : getOrgproductTypeGroupName().hashCode());
        result = prime * result + ((getGroupOrder() == null) ? 0 : getGroupOrder().hashCode());
        result = prime * result + ((getGroupStatus() == null) ? 0 : getGroupStatus().hashCode());
        result = prime * result + ((getGroup1() == null) ? 0 : getGroup1().hashCode());
        result = prime * result + ((getGroup2() == null) ? 0 : getGroup2().hashCode());
        result = prime * result + ((getGroup3() == null) ? 0 : getGroup3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", groupId=").append(groupId);
        sb.append(", orgproductTypeGroupName=").append(orgproductTypeGroupName);
        sb.append(", groupOrder=").append(groupOrder);
        sb.append(", groupStatus=").append(groupStatus);
        sb.append(", group1=").append(group1);
        sb.append(", group2=").append(group2);
        sb.append(", group3=").append(group3);
        sb.append("]");
        return sb.toString();
    }
}