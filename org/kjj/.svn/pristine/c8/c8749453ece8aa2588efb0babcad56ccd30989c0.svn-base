package com.kjj.commserver.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrgRefundOrder {
    /** id主键 */
    private Integer refundOrderId;

    /** 退单流水号 */
    private Long refundSerialNo;

    /** 订单ID 对应org_order表order_id字段 */
    private Integer orderId;

    /** 订单流水号 对应org_order表serial_no字段 */
    private Long orderSerialNo;

    /** 退货单号 对应org_return_order表return_order_id字段 */
    private Integer returnOrderId;

    /** 退货单流水号 对应org_return__order表return_serial_no */
    private Long returnSerialNo;

    /** 用户ID对应org_user表user_id字段 */
    private Integer userId;

    /** 店铺ID对应org_shop表shop_id字段 */
    private Integer shopId;

    /** 退款方式 0：在线退款 1.本地退款 */
    private Byte refundStyle;

    /** 在线退款方式 1.支付宝 2.微信支付 3.财付通 4.银联支付 */
    private Byte onlineRefundStyle;

    /** 退款状态 0.退款中 1.退款完成 */
    private Byte refundStatus;

    /** 退款金额 */
    private BigDecimal refundMoney;

    /** 创建时间 */
    private Date createTime;

    /** 备注 */
    private String remark;

    /** 退款人ID 对应org_admin_user表user_id字段 */
    private Short refundAdminId;

    /** 退款时间 */
    private Date refundTime;

    public Integer getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(Integer refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public Long getRefundSerialNo() {
        return refundSerialNo;
    }

    public void setRefundSerialNo(Long refundSerialNo) {
        this.refundSerialNo = refundSerialNo;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getOrderSerialNo() {
        return orderSerialNo;
    }

    public void setOrderSerialNo(Long orderSerialNo) {
        this.orderSerialNo = orderSerialNo;
    }

    public Integer getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(Integer returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public Long getReturnSerialNo() {
        return returnSerialNo;
    }

    public void setReturnSerialNo(Long returnSerialNo) {
        this.returnSerialNo = returnSerialNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Byte getRefundStyle() {
        return refundStyle;
    }

    public void setRefundStyle(Byte refundStyle) {
        this.refundStyle = refundStyle;
    }

    public Byte getOnlineRefundStyle() {
        return onlineRefundStyle;
    }

    public void setOnlineRefundStyle(Byte onlineRefundStyle) {
        this.onlineRefundStyle = onlineRefundStyle;
    }

    public Byte getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Byte refundStatus) {
        this.refundStatus = refundStatus;
    }

    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getRefundAdminId() {
        return refundAdminId;
    }

    public void setRefundAdminId(Short refundAdminId) {
        this.refundAdminId = refundAdminId;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
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
        OrgRefundOrder other = (OrgRefundOrder) that;
        return (this.getRefundOrderId() == null ? other.getRefundOrderId() == null : this.getRefundOrderId().equals(other.getRefundOrderId()))
            && (this.getRefundSerialNo() == null ? other.getRefundSerialNo() == null : this.getRefundSerialNo().equals(other.getRefundSerialNo()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderSerialNo() == null ? other.getOrderSerialNo() == null : this.getOrderSerialNo().equals(other.getOrderSerialNo()))
            && (this.getReturnOrderId() == null ? other.getReturnOrderId() == null : this.getReturnOrderId().equals(other.getReturnOrderId()))
            && (this.getReturnSerialNo() == null ? other.getReturnSerialNo() == null : this.getReturnSerialNo().equals(other.getReturnSerialNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getRefundStyle() == null ? other.getRefundStyle() == null : this.getRefundStyle().equals(other.getRefundStyle()))
            && (this.getOnlineRefundStyle() == null ? other.getOnlineRefundStyle() == null : this.getOnlineRefundStyle().equals(other.getOnlineRefundStyle()))
            && (this.getRefundStatus() == null ? other.getRefundStatus() == null : this.getRefundStatus().equals(other.getRefundStatus()))
            && (this.getRefundMoney() == null ? other.getRefundMoney() == null : this.getRefundMoney().equals(other.getRefundMoney()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRefundAdminId() == null ? other.getRefundAdminId() == null : this.getRefundAdminId().equals(other.getRefundAdminId()))
            && (this.getRefundTime() == null ? other.getRefundTime() == null : this.getRefundTime().equals(other.getRefundTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRefundOrderId() == null) ? 0 : getRefundOrderId().hashCode());
        result = prime * result + ((getRefundSerialNo() == null) ? 0 : getRefundSerialNo().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderSerialNo() == null) ? 0 : getOrderSerialNo().hashCode());
        result = prime * result + ((getReturnOrderId() == null) ? 0 : getReturnOrderId().hashCode());
        result = prime * result + ((getReturnSerialNo() == null) ? 0 : getReturnSerialNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getRefundStyle() == null) ? 0 : getRefundStyle().hashCode());
        result = prime * result + ((getOnlineRefundStyle() == null) ? 0 : getOnlineRefundStyle().hashCode());
        result = prime * result + ((getRefundStatus() == null) ? 0 : getRefundStatus().hashCode());
        result = prime * result + ((getRefundMoney() == null) ? 0 : getRefundMoney().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRefundAdminId() == null) ? 0 : getRefundAdminId().hashCode());
        result = prime * result + ((getRefundTime() == null) ? 0 : getRefundTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", refundOrderId=").append(refundOrderId);
        sb.append(", refundSerialNo=").append(refundSerialNo);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSerialNo=").append(orderSerialNo);
        sb.append(", returnOrderId=").append(returnOrderId);
        sb.append(", returnSerialNo=").append(returnSerialNo);
        sb.append(", userId=").append(userId);
        sb.append(", shopId=").append(shopId);
        sb.append(", refundStyle=").append(refundStyle);
        sb.append(", onlineRefundStyle=").append(onlineRefundStyle);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", refundMoney=").append(refundMoney);
        sb.append(", createTime=").append(createTime);
        sb.append(", remark=").append(remark);
        sb.append(", refundAdminId=").append(refundAdminId);
        sb.append(", refundTime=").append(refundTime);
        sb.append("]");
        return sb.toString();
    }
}