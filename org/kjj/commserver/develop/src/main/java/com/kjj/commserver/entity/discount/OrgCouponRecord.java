package com.kjj.commserver.entity.discount;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrgCouponRecord {
    /** 优惠券记录ID */
    private Integer recordId;

    /** 优惠券ID 对应org_coupon表coupon_id字段 */
    private Integer couponId;

    /** 有效期开始 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date startTime;

    /** 有效期结束 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date endTime;

    /** 状态 0：待领取 1：待绑定2：未使用 3：已使用 4：已过期 5：已作废 */
    private Byte status;

    /** 来源 1：领取2：发放3：触发 */
    private Byte source;

    /** 发放人ID 对应org_admin_user表user_id字段 */
    private Short giveAdmin;

    /** 触发ID 对应org_discount_trigger表id字段 */
    private Integer triggerId;

    /** 说明 */
    private String remark;

    /** 绑定时间 */
    private Date bindingTime;

    /** 使用时间 */
    private Date useTime;

    /** 用户ID 对应org_users表user_id字段 */
    private Integer userId;

    /** 用户手机号 */
    private String userPhone;

    /** 订单ID 对应org_order表order_id字段 */
    private Integer orderId;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Short getGiveAdmin() {
        return giveAdmin;
    }

    public void setGiveAdmin(Short giveAdmin) {
        this.giveAdmin = giveAdmin;
    }

    public Integer getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(Integer triggerId) {
        this.triggerId = triggerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(Date bindingTime) {
        this.bindingTime = bindingTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        OrgCouponRecord other = (OrgCouponRecord) that;
        return (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getGiveAdmin() == null ? other.getGiveAdmin() == null : this.getGiveAdmin().equals(other.getGiveAdmin()))
            && (this.getTriggerId() == null ? other.getTriggerId() == null : this.getTriggerId().equals(other.getTriggerId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBindingTime() == null ? other.getBindingTime() == null : this.getBindingTime().equals(other.getBindingTime()))
            && (this.getUseTime() == null ? other.getUseTime() == null : this.getUseTime().equals(other.getUseTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getGiveAdmin() == null) ? 0 : getGiveAdmin().hashCode());
        result = prime * result + ((getTriggerId() == null) ? 0 : getTriggerId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBindingTime() == null) ? 0 : getBindingTime().hashCode());
        result = prime * result + ((getUseTime() == null) ? 0 : getUseTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordId=").append(recordId);
        sb.append(", couponId=").append(couponId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", source=").append(source);
        sb.append(", giveAdmin=").append(giveAdmin);
        sb.append(", triggerId=").append(triggerId);
        sb.append(", remark=").append(remark);
        sb.append(", bindingTime=").append(bindingTime);
        sb.append(", useTime=").append(useTime);
        sb.append(", userId=").append(userId);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", orderId=").append(orderId);
        sb.append("]");
        return sb.toString();
    }
}