package com.kjj.commserver.entity.order;

import java.math.BigDecimal;

public class OrgOrderGoods {
    /**  */
    private Integer id;

    /** 订单ID 对应org_order表order_id字段 */
    private Integer orderId;

    /** 订单流水号 */
    private Long orderSerialNo;

    /** 店铺ID对应org_shop表shop_id字段 */
    private Integer shopId;

    /** 商品ID 对应org_product_item表goods_id字段 */
    private Integer goodsId;

    /** 商品的唯一货号 */
    private String goodsSn;
    
    /** 交易快照id，对应org_trade_snapshoot表trade_snapshoot_id字段 */
    private Integer tradeSnapshootId;

    /** 单价应收 */
    private BigDecimal unitAccounts;

    /** 单价优惠 */
    private BigDecimal unitDiscount;

    /** 单价实收 */
    private BigDecimal unitPrice;

    /** 商品数量 */
    private Integer amount;

    /** 退换货数量 */
    private Integer returnAmount;

    /** 退款数量 */
    private Integer refundAmount;

    /** 评价状态 0：未评价 1：已评价 */
    private Byte commentStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getOrderSerialNo() {
        return orderSerialNo;
    }

    public void setOrderSerialNo(Long orderSerialNo) {
        this.orderSerialNo = orderSerialNo;
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

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    public Integer getTradeSnapshootId() {
		return tradeSnapshootId;
	}

	public void setTradeSnapshootId(Integer tradeSnapshootId) {
		this.tradeSnapshootId = tradeSnapshootId;
	}

	public BigDecimal getUnitAccounts() {
        return unitAccounts;
    }

    public void setUnitAccounts(BigDecimal unitAccounts) {
        this.unitAccounts = unitAccounts;
    }

    public BigDecimal getUnitDiscount() {
        return unitDiscount;
    }

    public void setUnitDiscount(BigDecimal unitDiscount) {
        this.unitDiscount = unitDiscount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(Integer returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
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
        OrgOrderGoods other = (OrgOrderGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderSerialNo() == null ? other.getOrderSerialNo() == null : this.getOrderSerialNo().equals(other.getOrderSerialNo()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsSn() == null ? other.getGoodsSn() == null : this.getGoodsSn().equals(other.getGoodsSn()))
            && (this.getTradeSnapshootId() == null ? other.getTradeSnapshootId() == null : this.getTradeSnapshootId().equals(other.getTradeSnapshootId()))
            && (this.getUnitAccounts() == null ? other.getUnitAccounts() == null : this.getUnitAccounts().equals(other.getUnitAccounts()))
            && (this.getUnitDiscount() == null ? other.getUnitDiscount() == null : this.getUnitDiscount().equals(other.getUnitDiscount()))
            && (this.getUnitPrice() == null ? other.getUnitPrice() == null : this.getUnitPrice().equals(other.getUnitPrice()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getReturnAmount() == null ? other.getReturnAmount() == null : this.getReturnAmount().equals(other.getReturnAmount()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getCommentStatus() == null ? other.getCommentStatus() == null : this.getCommentStatus().equals(other.getCommentStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderSerialNo() == null) ? 0 : getOrderSerialNo().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsSn() == null) ? 0 : getGoodsSn().hashCode());
        result = prime * result + ((getTradeSnapshootId() == null) ? 0 : getTradeSnapshootId().hashCode());
        result = prime * result + ((getUnitAccounts() == null) ? 0 : getUnitAccounts().hashCode());
        result = prime * result + ((getUnitDiscount() == null) ? 0 : getUnitDiscount().hashCode());
        result = prime * result + ((getUnitPrice() == null) ? 0 : getUnitPrice().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getReturnAmount() == null) ? 0 : getReturnAmount().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getCommentStatus() == null) ? 0 : getCommentStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSerialNo=").append(orderSerialNo);
        sb.append(", shopId=").append(shopId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", tradeSnapshootId=").append(tradeSnapshootId);
        sb.append(", unitAccounts=").append(unitAccounts);
        sb.append(", unitDiscount=").append(unitDiscount);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", amount=").append(amount);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append("]");
        return sb.toString();
    }
}