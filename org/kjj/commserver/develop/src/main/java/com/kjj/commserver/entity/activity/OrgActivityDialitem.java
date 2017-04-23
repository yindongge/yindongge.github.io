package com.kjj.commserver.entity.activity;

public class OrgActivityDialitem {
    /**  */
    private Integer id;

    /** 活动Id */
    private Integer activityId;

    /** 奖项名称 */
    private String itemName;

    /** 奖项类型：1无奖提示2商品3优惠券 */
    private Byte itemType;

    /** 奖品Id */
    private Integer itemPrizeId;

    /** 奖品名 */
    private String itemPrizeName;

    /** 缩略图 */
    private String thumb;

    /** 奖品数量 */
    private Short itemNum;

    /** 剩余数量 */
    private Short remainNum;

    /** 锁定数量 */
    private Short lockNum;

    /** 奖项顺序 */
    private Short itemOrder;

    /** 中奖概率 */
    private Long itemRate;

    /** 奖项状态（1有效，0已失效） */
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Byte getItemType() {
        return itemType;
    }

    public void setItemType(Byte itemType) {
        this.itemType = itemType;
    }

    public Integer getItemPrizeId() {
        return itemPrizeId;
    }

    public void setItemPrizeId(Integer itemPrizeId) {
        this.itemPrizeId = itemPrizeId;
    }

    public String getItemPrizeName() {
        return itemPrizeName;
    }

    public void setItemPrizeName(String itemPrizeName) {
        this.itemPrizeName = itemPrizeName == null ? null : itemPrizeName.trim();
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb == null ? null : thumb.trim();
    }

    public Short getItemNum() {
        return itemNum;
    }

    public void setItemNum(Short itemNum) {
        this.itemNum = itemNum;
    }

    public Short getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Short remainNum) {
        this.remainNum = remainNum;
    }

    public Short getLockNum() {
        return lockNum;
    }

    public void setLockNum(Short lockNum) {
        this.lockNum = lockNum;
    }

    public Short getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Short itemOrder) {
        this.itemOrder = itemOrder;
    }

    public Long getItemRate() {
        return itemRate;
    }

    public void setItemRate(Long itemRate) {
        this.itemRate = itemRate;
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
        OrgActivityDialitem other = (OrgActivityDialitem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getItemType() == null ? other.getItemType() == null : this.getItemType().equals(other.getItemType()))
            && (this.getItemPrizeId() == null ? other.getItemPrizeId() == null : this.getItemPrizeId().equals(other.getItemPrizeId()))
            && (this.getItemPrizeName() == null ? other.getItemPrizeName() == null : this.getItemPrizeName().equals(other.getItemPrizeName()))
            && (this.getThumb() == null ? other.getThumb() == null : this.getThumb().equals(other.getThumb()))
            && (this.getItemNum() == null ? other.getItemNum() == null : this.getItemNum().equals(other.getItemNum()))
            && (this.getRemainNum() == null ? other.getRemainNum() == null : this.getRemainNum().equals(other.getRemainNum()))
            && (this.getLockNum() == null ? other.getLockNum() == null : this.getLockNum().equals(other.getLockNum()))
            && (this.getItemOrder() == null ? other.getItemOrder() == null : this.getItemOrder().equals(other.getItemOrder()))
            && (this.getItemRate() == null ? other.getItemRate() == null : this.getItemRate().equals(other.getItemRate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getItemType() == null) ? 0 : getItemType().hashCode());
        result = prime * result + ((getItemPrizeId() == null) ? 0 : getItemPrizeId().hashCode());
        result = prime * result + ((getItemPrizeName() == null) ? 0 : getItemPrizeName().hashCode());
        result = prime * result + ((getThumb() == null) ? 0 : getThumb().hashCode());
        result = prime * result + ((getItemNum() == null) ? 0 : getItemNum().hashCode());
        result = prime * result + ((getRemainNum() == null) ? 0 : getRemainNum().hashCode());
        result = prime * result + ((getLockNum() == null) ? 0 : getLockNum().hashCode());
        result = prime * result + ((getItemOrder() == null) ? 0 : getItemOrder().hashCode());
        result = prime * result + ((getItemRate() == null) ? 0 : getItemRate().hashCode());
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
        sb.append(", itemName=").append(itemName);
        sb.append(", itemType=").append(itemType);
        sb.append(", itemPrizeId=").append(itemPrizeId);
        sb.append(", itemPrizeName=").append(itemPrizeName);
        sb.append(", thumb=").append(thumb);
        sb.append(", itemNum=").append(itemNum);
        sb.append(", remainNum=").append(remainNum);
        sb.append(", lockNum=").append(lockNum);
        sb.append(", itemOrder=").append(itemOrder);
        sb.append(", itemRate=").append(itemRate);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}