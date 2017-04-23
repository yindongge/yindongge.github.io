package com.kjj.commserver.entity.goods;


public class OrgSaleSpecValue {
    /** 规格值Id */
    private Integer specValueId;

    /** 规格Id(见规格表) */
    private Integer specId;

    /** 规格值(文字) */
    private String specValue;

    /** 规格值(颜色) */
    private String colour;

    /**  */
    private String isActive;

    /**  */
    private String isDelete;

    public Integer getSpecValueId() {
        return specValueId;
    }

    public void setSpecValueId(Integer specValueId) {
        this.specValueId = specValueId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue == null ? null : specValue.trim();
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour == null ? null : colour.trim();
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
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
        OrgSaleSpecValue other = (OrgSaleSpecValue) that;
        return (this.getSpecValueId() == null ? other.getSpecValueId() == null : this.getSpecValueId().equals(other.getSpecValueId()))
            && (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()))
            && (this.getSpecValue() == null ? other.getSpecValue() == null : this.getSpecValue().equals(other.getSpecValue()))
            && (this.getColour() == null ? other.getColour() == null : this.getColour().equals(other.getColour()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecValueId() == null) ? 0 : getSpecValueId().hashCode());
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
        result = prime * result + ((getSpecValue() == null) ? 0 : getSpecValue().hashCode());
        result = prime * result + ((getColour() == null) ? 0 : getColour().hashCode());
        result = prime * result + ((getIsActive() == null) ? 0 : getIsActive().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", specValueId=").append(specValueId);
        sb.append(", specId=").append(specId);
        sb.append(", specValue=").append(specValue);
        sb.append(", colour=").append(colour);
        sb.append(", isActive=").append(isActive);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}