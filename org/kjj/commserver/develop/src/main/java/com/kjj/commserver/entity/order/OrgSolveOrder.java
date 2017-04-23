package com.kjj.commserver.entity.order;

import java.util.Date;

public class OrgSolveOrder {
    /** 主键 */
    private Integer id;

    /** 订单号 对应org_order表order_id字段 */
    private Integer orderId;

    /** 店铺ID对应org_shop表shop_id字段 */
    private Integer shopId;

    /** 转客服原因 */
    private String reason;

    /** 备注 */
    private String remark;

    /** 来源管理员ID 对应org_admin_user表user_id字段 */
    private Short fromAdminId;

    /** 解决管理员ID 对应org_admin_user表user_id字段 */
    private Short solveAdminId;

    /** 状态 0：待解决 1：已解决 */
    private Byte status;

    /** 创建时间 */
    private Date createTime;

    /** 解决时间 */
    private Date solveTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getFromAdminId() {
        return fromAdminId;
    }

    public void setFromAdminId(Short fromAdminId) {
        this.fromAdminId = fromAdminId;
    }

    public Short getSolveAdminId() {
        return solveAdminId;
    }

    public void setSolveAdminId(Short solveAdminId) {
        this.solveAdminId = solveAdminId;
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

    public Date getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
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
        OrgSolveOrder other = (OrgSolveOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getFromAdminId() == null ? other.getFromAdminId() == null : this.getFromAdminId().equals(other.getFromAdminId()))
            && (this.getSolveAdminId() == null ? other.getSolveAdminId() == null : this.getSolveAdminId().equals(other.getSolveAdminId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSolveTime() == null ? other.getSolveTime() == null : this.getSolveTime().equals(other.getSolveTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getFromAdminId() == null) ? 0 : getFromAdminId().hashCode());
        result = prime * result + ((getSolveAdminId() == null) ? 0 : getSolveAdminId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSolveTime() == null) ? 0 : getSolveTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", shopId=").append(shopId);
        sb.append(", reason=").append(reason);
        sb.append(", remark=").append(remark);
        sb.append(", fromAdminId=").append(fromAdminId);
        sb.append(", solveAdminId=").append(solveAdminId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", solveTime=").append(solveTime);
        sb.append("]");
        return sb.toString();
    }
}