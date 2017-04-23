package com.kjj.commserver.entity.shop;

public class OrgShopPageImg {
    /**  */
    private Integer id;

    /** 店铺id */
    private Integer shopId;

    /** 0 图标，1 形象图，2 外景，3 内景 */
    private Byte type;

    /** 图片上传的地址 */
    private String pageImg;

    /** 设备 1.pc 2微信 */
    private Byte device;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getPageImg() {
        return pageImg;
    }

    public void setPageImg(String pageImg) {
        this.pageImg = pageImg == null ? null : pageImg.trim();
    }

    public Byte getDevice() {
        return device;
    }

    public void setDevice(Byte device) {
        this.device = device;
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
        OrgShopPageImg other = (OrgShopPageImg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getPageImg() == null ? other.getPageImg() == null : this.getPageImg().equals(other.getPageImg()))
            && (this.getDevice() == null ? other.getDevice() == null : this.getDevice().equals(other.getDevice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPageImg() == null) ? 0 : getPageImg().hashCode());
        result = prime * result + ((getDevice() == null) ? 0 : getDevice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopId=").append(shopId);
        sb.append(", type=").append(type);
        sb.append(", pageImg=").append(pageImg);
        sb.append(", device=").append(device);
        sb.append("]");
        return sb.toString();
    }
}