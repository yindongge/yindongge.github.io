package com.kjj.commserver.entity.discount;

import java.math.BigDecimal;

public class OrgLimitTimeGoods {
    /** 主键 */
    private Integer id;

    /** 限时折扣ID 对应org_limit_time_discount表id字段 */
    private Integer ltdId;

    /** 商品ID 对应org_product_item表goods_id字段 */
    private Integer goodsId;

    /** 商品标题 */
    private String goodsTitle;

    /** 折扣 */
    private Byte discount;

    /** 价格 */
    private BigDecimal price;

    /** 城市限购量 */
    private Integer cityNum;

    /** 店铺限购量 */
    private Integer shopNum;

    /** 用户限购量 */
    private Integer userNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLtdId() {
        return ltdId;
    }

    public void setLtdId(Integer ltdId) {
        this.ltdId = ltdId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    public Byte getDiscount() {
        return discount;
    }

    public void setDiscount(Byte discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCityNum() {
        return cityNum;
    }

    public void setCityNum(Integer cityNum) {
        this.cityNum = cityNum;
    }

    public Integer getShopNum() {
        return shopNum;
    }

    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
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
        OrgLimitTimeGoods other = (OrgLimitTimeGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLtdId() == null ? other.getLtdId() == null : this.getLtdId().equals(other.getLtdId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsTitle() == null ? other.getGoodsTitle() == null : this.getGoodsTitle().equals(other.getGoodsTitle()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCityNum() == null ? other.getCityNum() == null : this.getCityNum().equals(other.getCityNum()))
            && (this.getShopNum() == null ? other.getShopNum() == null : this.getShopNum().equals(other.getShopNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLtdId() == null) ? 0 : getLtdId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsTitle() == null) ? 0 : getGoodsTitle().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCityNum() == null) ? 0 : getCityNum().hashCode());
        result = prime * result + ((getShopNum() == null) ? 0 : getShopNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ltdId=").append(ltdId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsTitle=").append(goodsTitle);
        sb.append(", discount=").append(discount);
        sb.append(", price=").append(price);
        sb.append(", cityNum=").append(cityNum);
        sb.append(", shopNum=").append(shopNum);
        sb.append(", userNum=").append(userNum);
        sb.append("]");
        return sb.toString();
    }
}