package com.kjj.commserver.entity.consult;

import java.util.Date;

public class OrgConsultAnswer {
    /**  */
    private Integer consultAnswerId;

    /** 咨询问题id */
    private Integer consultProblemId;

    /** 咨询回复 */
    private String consultAnswer;

    /** 创建时间 */
    private Date createTime;

    /** 创建人 （当为网站咨询时，针对一个咨询，双方为对话模式，多组问答，没有回答，不能再问）*/
    private Integer fromUser;

    /** 接收人（当为网站咨询时，针对一个咨询，双方为对话模式） */
    private Integer toUser;

    /** 回复状态 */
    private Byte replyState;

    /** 是否删除： 1已删除 0未删除 */
    private Byte isDelete;

    /** 是否启用： 1启用 0停用 */
    private Byte isActive;

    /** 创建人类型： 0为前台用户 1为后台用户（网站咨询时，创建人会出现后台用户。商品咨询时，创建人始终是前台用户） */
    private Byte createUserType;

    public Integer getConsultAnswerId() {
        return consultAnswerId;
    }

    public void setConsultAnswerId(Integer consultAnswerId) {
        this.consultAnswerId = consultAnswerId;
    }

    public Integer getConsultProblemId() {
        return consultProblemId;
    }

    public void setConsultProblemId(Integer consultProblemId) {
        this.consultProblemId = consultProblemId;
    }

    public String getConsultAnswer() {
        return consultAnswer;
    }

    public void setConsultAnswer(String consultAnswer) {
        this.consultAnswer = consultAnswer == null ? null : consultAnswer.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFromUser() {
        return fromUser;
    }

    public void setFromUser(Integer fromUser) {
        this.fromUser = fromUser;
    }

    public Integer getToUser() {
        return toUser;
    }

    public void setToUser(Integer toUser) {
        this.toUser = toUser;
    }

    public Byte getReplyState() {
        return replyState;
    }

    public void setReplyState(Byte replyState) {
        this.replyState = replyState;
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

    public Byte getCreateUserType() {
        return createUserType;
    }

    public void setCreateUserType(Byte createUserType) {
        this.createUserType = createUserType;
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
        OrgConsultAnswer other = (OrgConsultAnswer) that;
        return (this.getConsultAnswerId() == null ? other.getConsultAnswerId() == null : this.getConsultAnswerId().equals(other.getConsultAnswerId()))
            && (this.getConsultProblemId() == null ? other.getConsultProblemId() == null : this.getConsultProblemId().equals(other.getConsultProblemId()))
            && (this.getConsultAnswer() == null ? other.getConsultAnswer() == null : this.getConsultAnswer().equals(other.getConsultAnswer()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFromUser() == null ? other.getFromUser() == null : this.getFromUser().equals(other.getFromUser()))
            && (this.getToUser() == null ? other.getToUser() == null : this.getToUser().equals(other.getToUser()))
            && (this.getReplyState() == null ? other.getReplyState() == null : this.getReplyState().equals(other.getReplyState()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()))
            && (this.getCreateUserType() == null ? other.getCreateUserType() == null : this.getCreateUserType().equals(other.getCreateUserType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConsultAnswerId() == null) ? 0 : getConsultAnswerId().hashCode());
        result = prime * result + ((getConsultProblemId() == null) ? 0 : getConsultProblemId().hashCode());
        result = prime * result + ((getConsultAnswer() == null) ? 0 : getConsultAnswer().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFromUser() == null) ? 0 : getFromUser().hashCode());
        result = prime * result + ((getToUser() == null) ? 0 : getToUser().hashCode());
        result = prime * result + ((getReplyState() == null) ? 0 : getReplyState().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsActive() == null) ? 0 : getIsActive().hashCode());
        result = prime * result + ((getCreateUserType() == null) ? 0 : getCreateUserType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", consultAnswerId=").append(consultAnswerId);
        sb.append(", consultProblemId=").append(consultProblemId);
        sb.append(", consultAnswer=").append(consultAnswer);
        sb.append(", createTime=").append(createTime);
        sb.append(", fromUser=").append(fromUser);
        sb.append(", toUser=").append(toUser);
        sb.append(", replyState=").append(replyState);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isActive=").append(isActive);
        sb.append(", createUserType=").append(createUserType);
        sb.append("]");
        return sb.toString();
    }
}