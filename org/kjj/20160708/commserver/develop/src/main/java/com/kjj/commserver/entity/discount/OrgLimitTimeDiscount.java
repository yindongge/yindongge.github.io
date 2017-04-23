package com.kjj.commserver.entity.discount;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrgLimitTimeDiscount {
    /** 主键 */
    private Integer id;

    /** 限时折扣名称 */
    private String name;

    /** 标题 */
    private String title;

    /** 活动开始日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /** 活动结束日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /** 活动开始时刻 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date startTime;

    /** 活动结束时刻 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date endTime;

    /** 是否秒杀 0：否 1：是 */
    private Byte seckill;

    /** 秒杀付款时间限制 */
    private Short seckillTimeLength;

    /** 判断手机 0：不判断 1：判断 */
    private Byte checkPhone;

    /** 范围店铺类型 1：全部2：区域3：店铺 */
    private Byte shopType;

    /** 状态 0：无效1：有效 */
    private Byte status;

    /** 创建人ID 对应org_admin_user表user_id字段 */
    private Short createAdminId;

    /** 创建时间 */
    private Date createTime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Byte getSeckill() {
        return seckill;
    }

    public void setSeckill(Byte seckill) {
        this.seckill = seckill;
    }

    public Short getSeckillTimeLength() {
        return seckillTimeLength;
    }

    public void setSeckillTimeLength(Short seckillTimeLength) {
        this.seckillTimeLength = seckillTimeLength;
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
        OrgLimitTimeDiscount other = (OrgLimitTimeDiscount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getSeckill() == null ? other.getSeckill() == null : this.getSeckill().equals(other.getSeckill()))
            && (this.getSeckillTimeLength() == null ? other.getSeckillTimeLength() == null : this.getSeckillTimeLength().equals(other.getSeckillTimeLength()))
            && (this.getCheckPhone() == null ? other.getCheckPhone() == null : this.getCheckPhone().equals(other.getCheckPhone()))
            && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateAdminId() == null ? other.getCreateAdminId() == null : this.getCreateAdminId().equals(other.getCreateAdminId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getSeckill() == null) ? 0 : getSeckill().hashCode());
        result = prime * result + ((getSeckillTimeLength() == null) ? 0 : getSeckillTimeLength().hashCode());
        result = prime * result + ((getCheckPhone() == null) ? 0 : getCheckPhone().hashCode());
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", seckill=").append(seckill);
        sb.append(", seckillTimeLength=").append(seckillTimeLength);
        sb.append(", checkPhone=").append(checkPhone);
        sb.append(", shopType=").append(shopType);
        sb.append(", status=").append(status);
        sb.append(", createAdminId=").append(createAdminId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}