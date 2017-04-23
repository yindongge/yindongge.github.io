package com.kjj.commserver.entity.activity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrgActivityAward {
    /**  */
    private Integer id;

    /** 活动Id */
    private Integer activityId;

    /** 门店id */
    private Integer shopId;

    /** 购物小票Id */
    private Integer ticketId;

    /** 小票抽奖号码 */
    private Integer ticketNumber;

    /** 类型（1线上，2线下） */
    private Byte awardType;

    /** 奖品类型:1商品,2优惠券 */
    private Byte prizeType;

    /** 奖品id(商品id或优惠券id) */
    private Integer prizeId;

    /** 奖品id(商品名或优惠券名) */
    private String prizeName;

    /** 手机号 */
    private String mobilePhone;

    /** 获奖时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date drawTime;

    /** 领奖时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date getTime;

    /** 领奖状态（1未领取，2已领取，3已过期，4已放弃） */
    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Byte getAwardType() {
        return awardType;
    }

    public void setAwardType(Byte awardType) {
        this.awardType = awardType;
    }

    public Byte getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(Byte prizeType) {
        this.prizeType = prizeType;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public Date getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(Date drawTime) {
        this.drawTime = drawTime;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        OrgActivityAward other = (OrgActivityAward) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
            && (this.getTicketNumber() == null ? other.getTicketNumber() == null : this.getTicketNumber().equals(other.getTicketNumber()))
            && (this.getAwardType() == null ? other.getAwardType() == null : this.getAwardType().equals(other.getAwardType()))
            && (this.getPrizeType() == null ? other.getPrizeType() == null : this.getPrizeType().equals(other.getPrizeType()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getPrizeName() == null ? other.getPrizeName() == null : this.getPrizeName().equals(other.getPrizeName()))
            && (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
            && (this.getDrawTime() == null ? other.getDrawTime() == null : this.getDrawTime().equals(other.getDrawTime()))
            && (this.getGetTime() == null ? other.getGetTime() == null : this.getGetTime().equals(other.getGetTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getTicketNumber() == null) ? 0 : getTicketNumber().hashCode());
        result = prime * result + ((getAwardType() == null) ? 0 : getAwardType().hashCode());
        result = prime * result + ((getPrizeType() == null) ? 0 : getPrizeType().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getPrizeName() == null) ? 0 : getPrizeName().hashCode());
        result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
        result = prime * result + ((getDrawTime() == null) ? 0 : getDrawTime().hashCode());
        result = prime * result + ((getGetTime() == null) ? 0 : getGetTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", shopId=").append(shopId);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", ticketNumber=").append(ticketNumber);
        sb.append(", awardType=").append(awardType);
        sb.append(", prizeType=").append(prizeType);
        sb.append(", prizeId=").append(prizeId);
        sb.append(", prizeName=").append(prizeName);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", drawTime=").append(drawTime);
        sb.append(", getTime=").append(getTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}