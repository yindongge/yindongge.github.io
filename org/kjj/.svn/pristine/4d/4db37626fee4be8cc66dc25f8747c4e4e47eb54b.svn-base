package com.kjj.commserver.entity.special;

public class OrgSpecialFloor {
    /**  */
    private Integer floorId;

    /** 对应表org_special中的special_id */
    private Integer specialId;

    /** 图片路径 */
    private String imgPath;

    /** 楼层排序 */
    private Byte floorOrder;

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public Byte getFloorOrder() {
        return floorOrder;
    }

    public void setFloorOrder(Byte floorOrder) {
        this.floorOrder = floorOrder;
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
        OrgSpecialFloor other = (OrgSpecialFloor) that;
        return (this.getFloorId() == null ? other.getFloorId() == null : this.getFloorId().equals(other.getFloorId()))
            && (this.getSpecialId() == null ? other.getSpecialId() == null : this.getSpecialId().equals(other.getSpecialId()))
            && (this.getImgPath() == null ? other.getImgPath() == null : this.getImgPath().equals(other.getImgPath()))
            && (this.getFloorOrder() == null ? other.getFloorOrder() == null : this.getFloorOrder().equals(other.getFloorOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFloorId() == null) ? 0 : getFloorId().hashCode());
        result = prime * result + ((getSpecialId() == null) ? 0 : getSpecialId().hashCode());
        result = prime * result + ((getImgPath() == null) ? 0 : getImgPath().hashCode());
        result = prime * result + ((getFloorOrder() == null) ? 0 : getFloorOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", floorId=").append(floorId);
        sb.append(", specialId=").append(specialId);
        sb.append(", imgPath=").append(imgPath);
        sb.append(", floorOrder=").append(floorOrder);
        sb.append("]");
        return sb.toString();
    }
}