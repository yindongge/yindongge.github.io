package com.kjj.commserver.entity.operation;

public class OrgItemRecommend {
    /** 主键 */
    private Integer id;

    /** 范围店铺类型 1：全部2：区域3：店铺 */
    private Byte shopType;

    /** 适用城市编码 对应org_area表code字段 */
    private String cityCode;

    /** 适用店铺ID 对应org_shop表shop_id字段 */
    private Integer shopId;

    /** 商品ID 对应org_product_item表goods_id字段 */
    private Integer goodsId;

    /** 推荐类型 1：新品 2.热卖 3.促销 4.推荐 */
    private Byte recommendType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getShopType() {
        return shopType;
    }

    public void setShopType(Byte shopType) {
        this.shopType = shopType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Byte getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(Byte recommendType) {
        this.recommendType = recommendType;
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
        OrgItemRecommend other = (OrgItemRecommend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getRecommendType() == null ? other.getRecommendType() == null : this.getRecommendType().equals(other.getRecommendType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getRecommendType() == null) ? 0 : getRecommendType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopType=").append(shopType);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", shopId=").append(shopId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", recommendType=").append(recommendType);
        sb.append("]");
        return sb.toString();
    }
}