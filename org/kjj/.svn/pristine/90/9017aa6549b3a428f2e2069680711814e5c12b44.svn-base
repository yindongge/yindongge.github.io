package com.kjj.commserver.entity.activity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrgActivity {
    /** 主键 */
    private Integer id;

    /** 活动标题 */
    private String title;

    /** 活动类型 1大转盘2砸金蛋3老虎机4刮刮卡 */
    private Byte typeId;

    /** 开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 失效时限，当前时间减中奖时间大于失效时限，不许领奖 */
    private Long awardTimeout;

    /** 中奖提示 */
    private String tipWin;

    /** 未中奖提示 */
    private String tipLose;

    /** 满额开始抽奖 */
    private Long limitMoney;

    /** 是否允许累加抽奖（1允许；0不允许） */
    private Byte limitRepeat;

    /** 最多抽奖次数（默认不限制） */
    private Byte limitCount;

    /** 活动状态(1未开启;2运行中;3已暂停;4已停用) */
    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
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

    public Long getAwardTimeout() {
        return awardTimeout;
    }

    public void setAwardTimeout(Long awardTimeout) {
        this.awardTimeout = awardTimeout;
    }

    public String getTipWin() {
        return tipWin;
    }

    public void setTipWin(String tipWin) {
        this.tipWin = tipWin == null ? null : tipWin.trim();
    }

    public String getTipLose() {
        return tipLose;
    }

    public void setTipLose(String tipLose) {
        this.tipLose = tipLose == null ? null : tipLose.trim();
    }

    public Long getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(Long limitMoney) {
        this.limitMoney = limitMoney;
    }

    public Byte getLimitRepeat() {
        return limitRepeat;
    }

    public void setLimitRepeat(Byte limitRepeat) {
        this.limitRepeat = limitRepeat;
    }

    public Byte getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Byte limitCount) {
        this.limitCount = limitCount;
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
        OrgActivity other = (OrgActivity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getAwardTimeout() == null ? other.getAwardTimeout() == null : this.getAwardTimeout().equals(other.getAwardTimeout()))
            && (this.getTipWin() == null ? other.getTipWin() == null : this.getTipWin().equals(other.getTipWin()))
            && (this.getTipLose() == null ? other.getTipLose() == null : this.getTipLose().equals(other.getTipLose()))
            && (this.getLimitMoney() == null ? other.getLimitMoney() == null : this.getLimitMoney().equals(other.getLimitMoney()))
            && (this.getLimitRepeat() == null ? other.getLimitRepeat() == null : this.getLimitRepeat().equals(other.getLimitRepeat()))
            && (this.getLimitCount() == null ? other.getLimitCount() == null : this.getLimitCount().equals(other.getLimitCount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getAwardTimeout() == null) ? 0 : getAwardTimeout().hashCode());
        result = prime * result + ((getTipWin() == null) ? 0 : getTipWin().hashCode());
        result = prime * result + ((getTipLose() == null) ? 0 : getTipLose().hashCode());
        result = prime * result + ((getLimitMoney() == null) ? 0 : getLimitMoney().hashCode());
        result = prime * result + ((getLimitRepeat() == null) ? 0 : getLimitRepeat().hashCode());
        result = prime * result + ((getLimitCount() == null) ? 0 : getLimitCount().hashCode());
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
        sb.append(", title=").append(title);
        sb.append(", typeId=").append(typeId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", awardTimeout=").append(awardTimeout);
        sb.append(", tipWin=").append(tipWin);
        sb.append(", tipLose=").append(tipLose);
        sb.append(", limitMoney=").append(limitMoney);
        sb.append(", limitRepeat=").append(limitRepeat);
        sb.append(", limitCount=").append(limitCount);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}