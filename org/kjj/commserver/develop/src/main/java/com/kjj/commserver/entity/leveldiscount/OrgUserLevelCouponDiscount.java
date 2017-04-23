package com.kjj.commserver.entity.leveldiscount;

import java.math.BigDecimal;

public class OrgUserLevelCouponDiscount {
    /**  */
    private Integer id;

    /** 会员级别主键 */
    private Integer levelId;

    /** 会员级别优惠主键 */
    private Integer levelCouponId;

    /** 折扣值 */
    private BigDecimal discount;

    /** 指定价格 */
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getLevelCouponId() {
        return levelCouponId;
    }

    public void setLevelCouponId(Integer levelCouponId) {
        this.levelCouponId = levelCouponId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        OrgUserLevelCouponDiscount other = (OrgUserLevelCouponDiscount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
            && (this.getLevelCouponId() == null ? other.getLevelCouponId() == null : this.getLevelCouponId().equals(other.getLevelCouponId()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
        result = prime * result + ((getLevelCouponId() == null) ? 0 : getLevelCouponId().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", levelId=").append(levelId);
        sb.append(", levelCouponId=").append(levelCouponId);
        sb.append(", discount=").append(discount);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }
}