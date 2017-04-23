package com.kjj.commserver.entity.leveldiscount;

import java.util.Date;

public class OrgUserLevelCoupon {
    /**  */
    private Integer levelCouponId;

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

    /** 类别ID */
    private Integer classId;

    /** 商品ID */
    private Integer goodsId;

    /** 类别名称 */
    private String className;

    /** 商品名称 */
    private String goodsName;

    /** 所有城市店铺ID */
    private String cityShopId;
    
    /** 适用城市编码 对应org_area表code字段 */
    private String cityCode;

    public Integer getLevelCouponId() {
        return levelCouponId;
    }

    public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public void setLevelCouponId(Integer levelCouponId) {
        this.levelCouponId = levelCouponId;
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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getCityShopId() {
        return cityShopId;
    }

    public void setCityShopId(String cityShopId) {
        this.cityShopId = cityShopId == null ? null : cityShopId.trim();
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
        OrgUserLevelCoupon other = (OrgUserLevelCoupon) that;
        return (this.getLevelCouponId() == null ? other.getLevelCouponId() == null : this.getLevelCouponId().equals(other.getLevelCouponId()))
            && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateAdminId() == null ? other.getCreateAdminId() == null : this.getCreateAdminId().equals(other.getCreateAdminId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getCityShopId() == null ? other.getCityShopId() == null : this.getCityShopId().equals(other.getCityShopId()))
        	&& (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLevelCouponId() == null) ? 0 : getLevelCouponId().hashCode());
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateAdminId() == null) ? 0 : getCreateAdminId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getCityShopId() == null) ? 0 : getCityShopId().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", levelCouponId=").append(levelCouponId);
        sb.append(", shopType=").append(shopType);
        sb.append(", productType=").append(productType);
        sb.append(", status=").append(status);
        sb.append(", createAdminId=").append(createAdminId);
        sb.append(", createTime=").append(createTime);
        sb.append(", classId=").append(classId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", className=").append(className);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", cityShopId=").append(cityShopId);
        sb.append(", cityCode=").append(cityCode);
        sb.append("]");
        return sb.toString();
    }
}