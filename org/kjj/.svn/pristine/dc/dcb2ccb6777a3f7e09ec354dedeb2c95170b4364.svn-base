package com.kjj.commserver.entity.order;

import java.util.Date;

public class OrgGoodsComment {
    /** 主键 */
    private Integer id;

    /** 用户ID对应org_user表user_id字段 */
    private Integer userId;

    /** 订单ID 对应org_order表order_id字段 */
    private Integer orderId;

    /** 对应org_order_goods表id字段 */
    private Integer orderGoodsId;

    /**  */
    private Integer goodsId;

    /** 星级评分 */
    private Byte starScore;

    /** 商品评价 */
    private String goodsComment;

    /** 回复 */
    private String reply;

    /** 回复人ID 对应org_admin_user表user_id字段 */
    private Short replyAdminId;

    /** 回复状态 0：未回复 1：已回复 */
    private Byte replyStatus;

    /** 状态 0：显示 1：隐藏 */
    private Byte status;

    /** 创建时间 */
    private Date createTime;

    /** 回复时间 */
    private Date replyTime;

    /**  */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Byte getStarScore() {
        return starScore;
    }

    public void setStarScore(Byte starScore) {
        this.starScore = starScore;
    }

    public String getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(String goodsComment) {
        this.goodsComment = goodsComment == null ? null : goodsComment.trim();
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public Short getReplyAdminId() {
        return replyAdminId;
    }

    public void setReplyAdminId(Short replyAdminId) {
        this.replyAdminId = replyAdminId;
    }

    public Byte getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Byte replyStatus) {
        this.replyStatus = replyStatus;
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

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
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
        OrgGoodsComment other = (OrgGoodsComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderGoodsId() == null ? other.getOrderGoodsId() == null : this.getOrderGoodsId().equals(other.getOrderGoodsId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getStarScore() == null ? other.getStarScore() == null : this.getStarScore().equals(other.getStarScore()))
            && (this.getGoodsComment() == null ? other.getGoodsComment() == null : this.getGoodsComment().equals(other.getGoodsComment()))
            && (this.getReply() == null ? other.getReply() == null : this.getReply().equals(other.getReply()))
            && (this.getReplyAdminId() == null ? other.getReplyAdminId() == null : this.getReplyAdminId().equals(other.getReplyAdminId()))
            && (this.getReplyStatus() == null ? other.getReplyStatus() == null : this.getReplyStatus().equals(other.getReplyStatus()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getReplyTime() == null ? other.getReplyTime() == null : this.getReplyTime().equals(other.getReplyTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderGoodsId() == null) ? 0 : getOrderGoodsId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getStarScore() == null) ? 0 : getStarScore().hashCode());
        result = prime * result + ((getGoodsComment() == null) ? 0 : getGoodsComment().hashCode());
        result = prime * result + ((getReply() == null) ? 0 : getReply().hashCode());
        result = prime * result + ((getReplyAdminId() == null) ? 0 : getReplyAdminId().hashCode());
        result = prime * result + ((getReplyStatus() == null) ? 0 : getReplyStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getReplyTime() == null) ? 0 : getReplyTime().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderGoodsId=").append(orderGoodsId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", starScore=").append(starScore);
        sb.append(", goodsComment=").append(goodsComment);
        sb.append(", reply=").append(reply);
        sb.append(", replyAdminId=").append(replyAdminId);
        sb.append(", replyStatus=").append(replyStatus);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}