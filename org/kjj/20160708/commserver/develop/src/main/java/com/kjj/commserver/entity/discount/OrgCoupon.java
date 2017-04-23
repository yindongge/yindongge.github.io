package com.kjj.commserver.entity.discount;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrgCoupon {
    /** 优惠券ID */
    private Integer couponId;

    /** 优惠券名称 */
    private String couponName;

    /** 固定开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 固定结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date endTime;

    /** 限制天数 从领取之后限制天数之内有效 */
    private Short limitDays;

    /** 生成优惠券数量 0为不限量 */
    private Integer amount;

    /** 每人领取限量 0为不限量 */
    private Byte userLimit;

    /** 满足条件金额 */
    private BigDecimal conditionMoney;

    /** 优惠金额 */
    private BigDecimal discountMoney;

    /** 描述 */
    private String couponDesc;

    /** 判断手机 0：不判断 1：判断 */
    private Byte checkPhone;

    /** 范围店铺类型 1：全部2：区域3：店铺 */
    private Byte shopType;

    /** 商品范围类型 1：全部2：类型3：商品 */
    private Byte productType;

    /** 状态 0：无效1：有效 */
    private Byte status;

    /** 创建人ID 对应org_admin_user表user_id字段 */
    private Short createAdminId;

    /** 创建时间 */
    private Date createTime;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
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

    public Short getLimitDays() {
        return limitDays;
    }

    public void setLimitDays(Short limitDays) {
        this.limitDays = limitDays;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Byte getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Byte userLimit) {
        this.userLimit = userLimit;
    }

    public BigDecimal getConditionMoney() {
        return conditionMoney;
    }

    public void setConditionMoney(BigDecimal conditionMoney) {
        this.conditionMoney = conditionMoney;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc == null ? null : couponDesc.trim();
    }

    public Byte getCheckPhone() {
        return checkPhone;
    }

    public void setCheckPhone(Byte checkPhone) {
        this.checkPhone = checkPhone;
    }

    public Byte getShopType() {
        return shopType;
    }

    public void setShopType(Byte shopType) {
        this.shopType = shopType;
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Short getCreateAdminId() {
        return createAdminId;
    }

    public void setCreateAdminId(Short createAdminId) {
        this.createAdminId = createAdminId;
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
        OrgCoupon other = (OrgCoupon) that;
        return (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getCouponName() == null ? other.getCouponName() == null : this.getCouponName().equals(other.getCouponName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getLimitDays() == null ? other.getLimitDays() == null : this.getLimitDays().equals(other.getLimitDays()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getUserLimit() == null ? other.getUserLimit() == null : this.getUserLimit().equals(other.getUserLimit()))
            && (this.getConditionMoney() == null ? other.getConditionMoney() == null : this.getConditionMoney().equals(other.getConditionMoney()))
            && (this.getDiscountMoney() == null ? other.getDiscountMoney() == null : this.getDiscountMoney().equals(other.getDiscountMoney()))
            && (this.getCouponDesc() == null ? other.getCouponDesc() == null : this.getCouponDesc().equals(other.getCouponDesc()))
            && (this.getCheckPhone() == null ? other.getCheckPhone() == null : this.getCheckPhone().equals(other.getCheckPhone()))
            && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateAdminId() == null ? other.getCreateAdminId() == null : this.getCreateAdminId().equals(other.getCreateAdminId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getCouponName() == null) ? 0 : getCouponName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getLimitDays() == null) ? 0 : getLimitDays().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getUserLimit() == null) ? 0 : getUserLimit().hashCode());
        result = prime * result + ((getConditionMoney() == null) ? 0 : getConditionMoney().hashCode());
        result = prime * result + ((getDiscountMoney() == null) ? 0 : getDiscountMoney().hashCode());
        result = prime * result + ((getCouponDesc() == null) ? 0 : getCouponDesc().hashCode());
        result = prime * result + ((getCheckPhone() == null) ? 0 : getCheckPhone().hashCode());
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateAdminId() == null) ? 0 : getCreateAdminId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", couponId=").append(couponId);
        sb.append(", couponName=").append(couponName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", limitDays=").append(limitDays);
        sb.append(", amount=").append(amount);
        sb.append(", userLimit=").append(userLimit);
        sb.append(", conditionMoney=").append(conditionMoney);
        sb.append(", discountMoney=").append(discountMoney);
        sb.append(", couponDesc=").append(couponDesc);
        sb.append(", checkPhone=").append(checkPhone);
        sb.append(", shopType=").append(shopType);
        sb.append(", productType=").append(productType);
        sb.append(", status=").append(status);
        sb.append(", createAdminId=").append(createAdminId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}