package com.kjj.commserver.entity.shop;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrgShop {
    /**  */
    private Integer shopId;

    /** 店铺编号 */
    private String shopCode;

    /** 店铺名称 */
    private String shopName;

    /** 区域对应org_area表code字段 */
    private String areaCode;

    /** 商圈id对应business_area表id字段 */
    private Integer businessAreaId;

    /** 详细地址 */
    private String address;

    /** 电话1区号 */
    private String firstPhoneAreaCode;

    /** 电话1号码 */
    private String firstPhoneNo;

    /** 电话1分机号 */
    private String firstPhoneExtension;

    /** 电话2区号 */
    private String secondPhoneAreaCode;

    /** 电话2号码 */
    private String secondPhoneNo;

    /** 电话2分机 */
    private String secondPhoneExtension;

    /** 配送说明 */
    private String sendExplain;

    /** 配送上午开始时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date sendTimeAmStart;

    /** 配送上午结束时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date sendTimeAmEnd;
    
    /** 配送中午开始时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date sendTimeNoonStart;

    /** 配送中午结束时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date sendTimeNoonEnd;

    /** 配送下午开始时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date sendTimePmStart;

    /** 配送下午结束时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date sendTimePmEnd;
    
    /** 配送晚上开始时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date sendTimeNightStart;

    /** 配送晚上结束时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date sendTimeNightEnd;

    /** 营业时间 0：全部时间1：仅工作日 */
    private Byte openDay;

    /** 营业开始时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date openTimeStart;

    /** 营业结束时间 */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date openTimeEnd;

    /** 是否24小时营业 0：是1：否 */
    private Byte isFullTime;

    /** 补货周期 以“,”分割 */
    private String restockCycle;

    /** 经度 */
    private Double longitude;

    /** 纬度 */
    private Double latitude;

    /** 排序:1到255 */
    private Short shopOrder;

    /** 状态 0：有效1：无效 */
    private Byte status;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Integer getBusinessAreaId() {
        return businessAreaId;
    }

    public void setBusinessAreaId(Integer businessAreaId) {
        this.businessAreaId = businessAreaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFirstPhoneAreaCode() {
        return firstPhoneAreaCode;
    }

    public void setFirstPhoneAreaCode(String firstPhoneAreaCode) {
        this.firstPhoneAreaCode = firstPhoneAreaCode == null ? null : firstPhoneAreaCode.trim();
    }

    public String getFirstPhoneNo() {
        return firstPhoneNo;
    }

    public void setFirstPhoneNo(String firstPhoneNo) {
        this.firstPhoneNo = firstPhoneNo == null ? null : firstPhoneNo.trim();
    }

    public String getFirstPhoneExtension() {
        return firstPhoneExtension;
    }

    public void setFirstPhoneExtension(String firstPhoneExtension) {
        this.firstPhoneExtension = firstPhoneExtension == null ? null : firstPhoneExtension.trim();
    }

    public String getSecondPhoneAreaCode() {
        return secondPhoneAreaCode;
    }

    public void setSecondPhoneAreaCode(String secondPhoneAreaCode) {
        this.secondPhoneAreaCode = secondPhoneAreaCode == null ? null : secondPhoneAreaCode.trim();
    }

    public String getSecondPhoneNo() {
        return secondPhoneNo;
    }

    public void setSecondPhoneNo(String secondPhoneNo) {
        this.secondPhoneNo = secondPhoneNo == null ? null : secondPhoneNo.trim();
    }

    public String getSecondPhoneExtension() {
        return secondPhoneExtension;
    }

    public void setSecondPhoneExtension(String secondPhoneExtension) {
        this.secondPhoneExtension = secondPhoneExtension == null ? null : secondPhoneExtension.trim();
    }

    public String getSendExplain() {
        return sendExplain;
    }

    public void setSendExplain(String sendExplain) {
        this.sendExplain = sendExplain == null ? null : sendExplain.trim();
    }

    public Date getSendTimeAmStart() {
        return sendTimeAmStart;
    }

    public void setSendTimeAmStart(Date sendTimeAmStart) {
        this.sendTimeAmStart = sendTimeAmStart;
    }

    public Date getSendTimeNoonStart() {
		return sendTimeNoonStart;
	}

	public Date getSendTimeAmEnd() {
		return sendTimeAmEnd;
	}

	public void setSendTimeAmEnd(Date sendTimeAmEnd) {
		this.sendTimeAmEnd = sendTimeAmEnd;
	}

	public void setSendTimeNoonStart(Date sendTimeNoonStart) {
		this.sendTimeNoonStart = sendTimeNoonStart;
	}

	public Date getSendTimeNoonEnd() {
		return sendTimeNoonEnd;
	}

	public void setSendTimeNoonEnd(Date sendTimeNoonEnd) {
		this.sendTimeNoonEnd = sendTimeNoonEnd;
	}

    public Date getSendTimePmStart() {
        return sendTimePmStart;
    }

    public void setSendTimePmStart(Date sendTimePmStart) {
        this.sendTimePmStart = sendTimePmStart;
    }

    public Date getSendTimePmEnd() {
        return sendTimePmEnd;
    }

    public void setSendTimePmEnd(Date sendTimePmEnd) {
        this.sendTimePmEnd = sendTimePmEnd;
    }

    public Date getSendTimeNightStart() {
        return sendTimeNightStart;
    }

    public void setSendTimeNightStart(Date sendTimeNightStart) {
        this.sendTimeNightStart = sendTimeNightStart;
    }

    public Date getSendTimeNightEnd() {
        return sendTimeNightEnd;
    }

    public void setSendTimeNightEnd(Date sendTimeNightEnd) {
        this.sendTimeNightEnd = sendTimeNightEnd;
    }

    public Byte getOpenDay() {
        return openDay;
    }

    public void setOpenDay(Byte openDay) {
        this.openDay = openDay;
    }

    public Date getOpenTimeStart() {
        return openTimeStart;
    }

    public void setOpenTimeStart(Date openTimeStart) {
        this.openTimeStart = openTimeStart;
    }

    public Date getOpenTimeEnd() {
        return openTimeEnd;
    }

    public void setOpenTimeEnd(Date openTimeEnd) {
        this.openTimeEnd = openTimeEnd;
    }

    public Byte getIsFullTime() {
        return isFullTime;
    }

    public void setIsFullTime(Byte isFullTime) {
        this.isFullTime = isFullTime;
    }

    public String getRestockCycle() {
        return restockCycle;
    }

    public void setRestockCycle(String restockCycle) {
        this.restockCycle = restockCycle == null ? null : restockCycle.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Short getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(Short shopOrder) {
        this.shopOrder = shopOrder;
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
        OrgShop other = (OrgShop) that;
        return (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getShopCode() == null ? other.getShopCode() == null : this.getShopCode().equals(other.getShopCode()))
            && (this.getShopName() == null ? other.getShopName() == null : this.getShopName().equals(other.getShopName()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getBusinessAreaId() == null ? other.getBusinessAreaId() == null : this.getBusinessAreaId().equals(other.getBusinessAreaId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getFirstPhoneAreaCode() == null ? other.getFirstPhoneAreaCode() == null : this.getFirstPhoneAreaCode().equals(other.getFirstPhoneAreaCode()))
            && (this.getFirstPhoneNo() == null ? other.getFirstPhoneNo() == null : this.getFirstPhoneNo().equals(other.getFirstPhoneNo()))
            && (this.getFirstPhoneExtension() == null ? other.getFirstPhoneExtension() == null : this.getFirstPhoneExtension().equals(other.getFirstPhoneExtension()))
            && (this.getSecondPhoneAreaCode() == null ? other.getSecondPhoneAreaCode() == null : this.getSecondPhoneAreaCode().equals(other.getSecondPhoneAreaCode()))
            && (this.getSecondPhoneNo() == null ? other.getSecondPhoneNo() == null : this.getSecondPhoneNo().equals(other.getSecondPhoneNo()))
            && (this.getSecondPhoneExtension() == null ? other.getSecondPhoneExtension() == null : this.getSecondPhoneExtension().equals(other.getSecondPhoneExtension()))
            && (this.getSendExplain() == null ? other.getSendExplain() == null : this.getSendExplain().equals(other.getSendExplain()))
            && (this.getSendTimeAmStart() == null ? other.getSendTimeAmStart() == null : this.getSendTimeAmStart().equals(other.getSendTimeAmStart()))
            && (this.getSendTimeAmEnd() == null ? other.getSendTimeAmEnd() == null : this.getSendTimeAmEnd().equals(other.getSendTimeAmEnd()))
            && (this.getSendTimeNoonStart() == null ? other.getSendTimeNoonStart() == null : this.getSendTimeNoonStart().equals(other.getSendTimeNoonStart()))
            && (this.getSendTimeNoonEnd() == null ? other.getSendTimeNoonEnd() == null : this.getSendTimeNoonEnd().equals(other.getSendTimeNoonEnd()))
            && (this.getSendTimePmStart() == null ? other.getSendTimePmStart() == null : this.getSendTimePmStart().equals(other.getSendTimePmStart()))
            && (this.getSendTimePmEnd() == null ? other.getSendTimePmEnd() == null : this.getSendTimePmEnd().equals(other.getSendTimePmEnd()))
            && (this.getSendTimeNightStart() == null ? other.getSendTimeNightStart() == null : this.getSendTimeNightStart().equals(other.getSendTimeNightStart()))
            && (this.getSendTimeNightEnd() == null ? other.getSendTimeNightEnd() == null : this.getSendTimeNightEnd().equals(other.getSendTimeNightEnd()))
            && (this.getOpenDay() == null ? other.getOpenDay() == null : this.getOpenDay().equals(other.getOpenDay()))
            && (this.getOpenTimeStart() == null ? other.getOpenTimeStart() == null : this.getOpenTimeStart().equals(other.getOpenTimeStart()))
            && (this.getOpenTimeEnd() == null ? other.getOpenTimeEnd() == null : this.getOpenTimeEnd().equals(other.getOpenTimeEnd()))
            && (this.getIsFullTime() == null ? other.getIsFullTime() == null : this.getIsFullTime().equals(other.getIsFullTime()))
            && (this.getRestockCycle() == null ? other.getRestockCycle() == null : this.getRestockCycle().equals(other.getRestockCycle()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getShopOrder() == null ? other.getShopOrder() == null : this.getShopOrder().equals(other.getShopOrder()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getShopCode() == null) ? 0 : getShopCode().hashCode());
        result = prime * result + ((getShopName() == null) ? 0 : getShopName().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getBusinessAreaId() == null) ? 0 : getBusinessAreaId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getFirstPhoneAreaCode() == null) ? 0 : getFirstPhoneAreaCode().hashCode());
        result = prime * result + ((getFirstPhoneNo() == null) ? 0 : getFirstPhoneNo().hashCode());
        result = prime * result + ((getFirstPhoneExtension() == null) ? 0 : getFirstPhoneExtension().hashCode());
        result = prime * result + ((getSecondPhoneAreaCode() == null) ? 0 : getSecondPhoneAreaCode().hashCode());
        result = prime * result + ((getSecondPhoneNo() == null) ? 0 : getSecondPhoneNo().hashCode());
        result = prime * result + ((getSecondPhoneExtension() == null) ? 0 : getSecondPhoneExtension().hashCode());
        result = prime * result + ((getSendExplain() == null) ? 0 : getSendExplain().hashCode());
        result = prime * result + ((getSendTimeAmStart() == null) ? 0 : getSendTimeAmStart().hashCode());
        result = prime * result + ((getSendTimeAmEnd() == null) ? 0 : getSendTimeAmEnd().hashCode());
        result = prime * result + ((getSendTimeNoonStart() == null) ? 0 : getSendTimeNoonStart().hashCode());
        result = prime * result + ((getSendTimeNoonEnd() == null) ? 0 : getSendTimeNoonEnd().hashCode());
        result = prime * result + ((getSendTimePmStart() == null) ? 0 : getSendTimePmStart().hashCode());
        result = prime * result + ((getSendTimePmEnd() == null) ? 0 : getSendTimePmEnd().hashCode());
        result = prime * result + ((getSendTimeNightStart() == null) ? 0 : getSendTimeNightStart().hashCode());
        result = prime * result + ((getSendTimeNightEnd() == null) ? 0 : getSendTimeNightEnd().hashCode());
        result = prime * result + ((getOpenDay() == null) ? 0 : getOpenDay().hashCode());
        result = prime * result + ((getOpenTimeStart() == null) ? 0 : getOpenTimeStart().hashCode());
        result = prime * result + ((getOpenTimeEnd() == null) ? 0 : getOpenTimeEnd().hashCode());
        result = prime * result + ((getIsFullTime() == null) ? 0 : getIsFullTime().hashCode());
        result = prime * result + ((getRestockCycle() == null) ? 0 : getRestockCycle().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getShopOrder() == null) ? 0 : getShopOrder().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shopId=").append(shopId);
        sb.append(", shopCode=").append(shopCode);
        sb.append(", shopName=").append(shopName);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", businessAreaId=").append(businessAreaId);
        sb.append(", address=").append(address);
        sb.append(", firstPhoneAreaCode=").append(firstPhoneAreaCode);
        sb.append(", firstPhoneNo=").append(firstPhoneNo);
        sb.append(", firstPhoneExtension=").append(firstPhoneExtension);
        sb.append(", secondPhoneAreaCode=").append(secondPhoneAreaCode);
        sb.append(", secondPhoneNo=").append(secondPhoneNo);
        sb.append(", secondPhoneExtension=").append(secondPhoneExtension);
        sb.append(", sendExplain=").append(sendExplain);
        sb.append(", sendTimeAmStart=").append(sendTimeAmStart);
        sb.append(", sendTimeAmEnd=").append(sendTimeAmEnd);
        sb.append(", sendTimeNoonStart=").append(sendTimeNoonStart);
        sb.append(", sendTimeNoonEnd=").append(sendTimeNoonEnd);
        sb.append(", sendTimePmStart=").append(sendTimePmStart);
        sb.append(", sendTimePmEnd=").append(sendTimePmEnd);
        sb.append(", sendTimeNightStart=").append(sendTimeNightStart);
        sb.append(", sendTimeNightEnd=").append(sendTimeNightEnd);
        sb.append(", openDay=").append(openDay);
        sb.append(", openTimeStart=").append(openTimeStart);
        sb.append(", openTimeEnd=").append(openTimeEnd);
        sb.append(", isFullTime=").append(isFullTime);
        sb.append(", restockCycle=").append(restockCycle);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", shopOrder=").append(shopOrder);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}