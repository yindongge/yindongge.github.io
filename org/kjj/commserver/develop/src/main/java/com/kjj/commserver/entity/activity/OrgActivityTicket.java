package com.kjj.commserver.entity.activity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrgActivityTicket {
    /**  */
    private Integer id;

    /**  */
    private Integer activityId;

    /** 门店id */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer shopId;

    /** 店铺编号 */
    private String shopCode;

    /** 小票抽奖号码 */
    private Integer ticketNumber;

    /** 票据打印时间 */
    private Date ticketCreateTime;

    /** 小票金额 */
    private BigDecimal ticketPrice;

    /** 已参与次数 */
    private Byte attendNum;

    /** 可参与次数 */
    private Byte gainNum;

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

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getTicketCreateTime() {
        return ticketCreateTime;
    }

    public void setTicketCreateTime(Date ticketCreateTime) {
        this.ticketCreateTime = ticketCreateTime;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Byte getAttendNum() {
        return attendNum;
    }

    public void setAttendNum(Byte attendNum) {
        this.attendNum = attendNum;
    }

    public Byte getGainNum() {
        return gainNum;
    }

    public void setGainNum(Byte gainNum) {
        this.gainNum = gainNum;
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
        OrgActivityTicket other = (OrgActivityTicket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getShopCode() == null ? other.getShopCode() == null : this.getShopCode().equals(other.getShopCode()))
            && (this.getTicketNumber() == null ? other.getTicketNumber() == null : this.getTicketNumber().equals(other.getTicketNumber()))
            && (this.getTicketCreateTime() == null ? other.getTicketCreateTime() == null : this.getTicketCreateTime().equals(other.getTicketCreateTime()))
            && (this.getTicketPrice() == null ? other.getTicketPrice() == null : this.getTicketPrice().equals(other.getTicketPrice()))
            && (this.getAttendNum() == null ? other.getAttendNum() == null : this.getAttendNum().equals(other.getAttendNum()))
            && (this.getGainNum() == null ? other.getGainNum() == null : this.getGainNum().equals(other.getGainNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getShopCode() == null) ? 0 : getShopCode().hashCode());
        result = prime * result + ((getTicketNumber() == null) ? 0 : getTicketNumber().hashCode());
        result = prime * result + ((getTicketCreateTime() == null) ? 0 : getTicketCreateTime().hashCode());
        result = prime * result + ((getTicketPrice() == null) ? 0 : getTicketPrice().hashCode());
        result = prime * result + ((getAttendNum() == null) ? 0 : getAttendNum().hashCode());
        result = prime * result + ((getGainNum() == null) ? 0 : getGainNum().hashCode());
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
        sb.append(", shopCode=").append(shopCode);
        sb.append(", ticketNumber=").append(ticketNumber);
        sb.append(", ticketCreateTime=").append(ticketCreateTime);
        sb.append(", ticketPrice=").append(ticketPrice);
        sb.append(", attendNum=").append(attendNum);
        sb.append(", gainNum=").append(gainNum);
        sb.append("]");
        return sb.toString();
    }
}