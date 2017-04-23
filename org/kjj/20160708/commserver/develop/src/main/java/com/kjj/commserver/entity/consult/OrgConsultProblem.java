package com.kjj.commserver.entity.consult;

import java.util.Date;

public class OrgConsultProblem {
    /**  */
    private Integer consultProblemId;

    /** 咨询分类 (见OrgConsultClass 1商品咨询，2网站咨询……)*/
    private Integer consultClassId;

    /**  */
    private String consultClassName;

    /** 咨询类型 (见OrgConsultType)*/
    private Integer consultTypeId;

    /**  */
    private String consultTypeName;

    /** 关联商品sku */
    private Integer goodsId;

    /** 咨询问题描述 */
    private String consultProblem;

    /** 咨询发起人 */
    private Integer createUser;

    /** 问题创建时间 */
    private Date createTime;

    /** 回复状态 */
    private Byte replyState;

    /** 处理状态 */
    private Byte solveState;

    /** 是否删除： 1已删除  0未删除 */
    private Byte isDelete;

    /** 是否启用： 1启用 0停用 */
    private Byte isActive;

    public Integer getConsultProblemId() {
        return consultProblemId;
    }

    public void setConsultProblemId(Integer consultProblemId) {
        this.consultProblemId = consultProblemId;
    }

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

    public Integer getConsultTypeId() {
        return consultTypeId;
    }

    public void setConsultTypeId(Integer consultTypeId) {
        this.consultTypeId = consultTypeId;
    }

    public String getConsultTypeName() {
        return consultTypeName;
    }

    public void setConsultTypeName(String consultTypeName) {
        this.consultTypeName = consultTypeName == null ? null : consultTypeName.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getConsultProblem() {
        return consultProblem;
    }

    public void setConsultProblem(String consultProblem) {
        this.consultProblem = consultProblem == null ? null : consultProblem.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getReplyState() {
        return replyState;
    }

    public void setReplyState(Byte replyState) {
        this.replyState = replyState;
    }

    public Byte getSolveState() {
        return solveState;
    }

    public void setSolveState(Byte solveState) {
        this.solveState = solveState;
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
        OrgConsultProblem other = (OrgConsultProblem) that;
        return (this.getConsultProblemId() == null ? other.getConsultProblemId() == null : this.getConsultProblemId().equals(other.getConsultProblemId()))
            && (this.getConsultClassId() == null ? other.getConsultClassId() == null : this.getConsultClassId().equals(other.getConsultClassId()))
            && (this.getConsultClassName() == null ? other.getConsultClassName() == null : this.getConsultClassName().equals(other.getConsultClassName()))
            && (this.getConsultTypeId() == null ? other.getConsultTypeId() == null : this.getConsultTypeId().equals(other.getConsultTypeId()))
            && (this.getConsultTypeName() == null ? other.getConsultTypeName() == null : this.getConsultTypeName().equals(other.getConsultTypeName()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getConsultProblem() == null ? other.getConsultProblem() == null : this.getConsultProblem().equals(other.getConsultProblem()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getReplyState() == null ? other.getReplyState() == null : this.getReplyState().equals(other.getReplyState()))
            && (this.getSolveState() == null ? other.getSolveState() == null : this.getSolveState().equals(other.getSolveState()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConsultProblemId() == null) ? 0 : getConsultProblemId().hashCode());
        result = prime * result + ((getConsultClassId() == null) ? 0 : getConsultClassId().hashCode());
        result = prime * result + ((getConsultClassName() == null) ? 0 : getConsultClassName().hashCode());
        result = prime * result + ((getConsultTypeId() == null) ? 0 : getConsultTypeId().hashCode());
        result = prime * result + ((getConsultTypeName() == null) ? 0 : getConsultTypeName().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getConsultProblem() == null) ? 0 : getConsultProblem().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getReplyState() == null) ? 0 : getReplyState().hashCode());
        result = prime * result + ((getSolveState() == null) ? 0 : getSolveState().hashCode());
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
        sb.append(", consultProblemId=").append(consultProblemId);
        sb.append(", consultClassId=").append(consultClassId);
        sb.append(", consultClassName=").append(consultClassName);
        sb.append(", consultTypeId=").append(consultTypeId);
        sb.append(", consultTypeName=").append(consultTypeName);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", consultProblem=").append(consultProblem);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", replyState=").append(replyState);
        sb.append(", solveState=").append(solveState);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isActive=").append(isActive);
        sb.append("]");
        return sb.toString();
    }
}