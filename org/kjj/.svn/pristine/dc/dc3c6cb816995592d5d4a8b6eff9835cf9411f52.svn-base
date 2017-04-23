package com.kjj.commserver.entity.user;

import java.util.Date;

public class OrgEnterpriseInvitationUser {
    /**  */
    private Integer id;

    /** 对应org_enterprise_easy_invitation表的id */
    private Integer easyInvitationId;

    /** 对应org_users表的user_id */
    private Integer userId;

    /** 创建时间 */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEasyInvitationId() {
        return easyInvitationId;
    }

    public void setEasyInvitationId(Integer easyInvitationId) {
        this.easyInvitationId = easyInvitationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        OrgEnterpriseInvitationUser other = (OrgEnterpriseInvitationUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEasyInvitationId() == null ? other.getEasyInvitationId() == null : this.getEasyInvitationId().equals(other.getEasyInvitationId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEasyInvitationId() == null) ? 0 : getEasyInvitationId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", easyInvitationId=").append(easyInvitationId);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}