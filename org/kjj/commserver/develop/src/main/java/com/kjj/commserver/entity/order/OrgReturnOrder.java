package com.kjj.commserver.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrgReturnOrder {
    /** id主键 */
    private Integer returnOrderId;

    /** 退单流水号 */
    private Long returnSerialNo;

    /** 订单ID 对应org_order表order_id字段 */
    private Integer orderId;

    /** 订单流水号 */
    private Long orderSerialNo;

    /** 用户ID对应org_user表user_id字段 */
    private Integer userId;

    /** 店铺ID对应org_shop表shop_id字段 */
    private Integer shopId;

    /** 对应org_order_goods表id字段 */
    private Integer orderGoodsId;

    /** 商品ID 对应org_product_item表goods_id字段 */
    private Integer goodsId;

    /** 商品的唯一货号 */
    private String goodsSn;

    /** 商品数量 */
    private Integer amount;

    /** 退货原因 */
    private String reason;

    /** 退货联系人 */
    private String returnContact;

    /** 退货地址 */
    private String returnAddress;

    /** 退货联系方式 */
    private String returnTel;

    /** 回复信息 */
    private String reply;

    /** 方式 0：退货 1：换货 */
    private Byte returnStyle;

    /** 取货方式 0：上门退货 1：到店退货 */
    private Byte takeStyle;

    /** 退款状态 0.申请退货 1.拒绝退货 2.退货中 3.已退货 */
    private Byte returnStatus;

    /** 退货单价 */
    private BigDecimal returnUnitPrice;

    /** 调整金额 */
    private BigDecimal balance;

    /** 退运费金额 */
    private BigDecimal returnSendMoney;

    /** 退款金额 */
    private BigDecimal returnMoney;

    /** 创建时间 */
    private Date createTime;

    /** 退货时间 */
    private Date returnTime;

    public Integer getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(Integer returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public Long getReturnSerialNo() {
        return returnSerialNo;
    }

    public void setReturnSerialNo(Long returnSerialNo) {
        this.returnSerialNo = returnSerialNo;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getReturnContact() {
        return returnContact;
    }

    public void setReturnContact(String returnContact) {
        this.returnContact = returnContact == null ? null : returnContact.trim();
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress == null ? null : returnAddress.trim();
    }

    public String getReturnTel() {
        return returnTel;
    }

    public void setReturnTel(String returnTel) {
        this.returnTel = returnTel == null ? null : returnTel.trim();
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public Byte getReturnStyle() {
        return returnStyle;
    }

    public void setReturnStyle(Byte returnStyle) {
        this.returnStyle = returnStyle;
    }

    public Byte getTakeStyle() {
        return takeStyle;
    }

    public void setTakeStyle(Byte takeStyle) {
        this.takeStyle = takeStyle;
    }

    public Byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public BigDecimal getReturnUnitPrice() {
        return returnUnitPrice;
    }

    public void setReturnUnitPrice(BigDecimal returnUnitPrice) {
        this.returnUnitPrice = returnUnitPrice;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getReturnSendMoney() {
        return returnSendMoney;
    }

    public void setReturnSendMoney(BigDecimal returnSendMoney) {
        this.returnSendMoney = returnSendMoney;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
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
        OrgReturnOrder other = (OrgReturnOrder) that;
        return (this.getReturnOrderId() == null ? other.getReturnOrderId() == null : this.getReturnOrderId().equals(other.getReturnOrderId()))
            && (this.getReturnSerialNo() == null ? other.getReturnSerialNo() == null : this.getReturnSerialNo().equals(other.getReturnSerialNo()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderSerialNo() == null ? other.getOrderSerialNo() == null : this.getOrderSerialNo().equals(other.getOrderSerialNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getOrderGoodsId() == null ? other.getOrderGoodsId() == null : this.getOrderGoodsId().equals(other.getOrderGoodsId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsSn() == null ? other.getGoodsSn() == null : this.getGoodsSn().equals(other.getGoodsSn()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getReturnContact() == null ? other.getReturnContact() == null : this.getReturnContact().equals(other.getReturnContact()))
            && (this.getReturnAddress() == null ? other.getReturnAddress() == null : this.getReturnAddress().equals(other.getReturnAddress()))
            && (this.getReturnTel() == null ? other.getReturnTel() == null : this.getReturnTel().equals(other.getReturnTel()))
            && (this.getReply() == null ? other.getReply() == null : this.getReply().equals(other.getReply()))
            && (this.getReturnStyle() == null ? other.getReturnStyle() == null : this.getReturnStyle().equals(other.getReturnStyle()))
            && (this.getTakeStyle() == null ? other.getTakeStyle() == null : this.getTakeStyle().equals(other.getTakeStyle()))
            && (this.getReturnStatus() == null ? other.getReturnStatus() == null : this.getReturnStatus().equals(other.getReturnStatus()))
            && (this.getReturnUnitPrice() == null ? other.getReturnUnitPrice() == null : this.getReturnUnitPrice().equals(other.getReturnUnitPrice()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getReturnSendMoney() == null ? other.getReturnSendMoney() == null : this.getReturnSendMoney().equals(other.getReturnSendMoney()))
            && (this.getReturnMoney() == null ? other.getReturnMoney() == null : this.getReturnMoney().equals(other.getReturnMoney()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getReturnTime() == null ? other.getReturnTime() == null : this.getReturnTime().equals(other.getReturnTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReturnOrderId() == null) ? 0 : getReturnOrderId().hashCode());
        result = prime * result + ((getReturnSerialNo() == null) ? 0 : getReturnSerialNo().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderSerialNo() == null) ? 0 : getOrderSerialNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getOrderGoodsId() == null) ? 0 : getOrderGoodsId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsSn() == null) ? 0 : getGoodsSn().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getReturnContact() == null) ? 0 : getReturnContact().hashCode());
        result = prime * result + ((getReturnAddress() == null) ? 0 : getReturnAddress().hashCode());
        result = prime * result + ((getReturnTel() == null) ? 0 : getReturnTel().hashCode());
        result = prime * result + ((getReply() == null) ? 0 : getReply().hashCode());
        result = prime * result + ((getReturnStyle() == null) ? 0 : getReturnStyle().hashCode());
        result = prime * result + ((getTakeStyle() == null) ? 0 : getTakeStyle().hashCode());
        result = prime * result + ((getReturnStatus() == null) ? 0 : getReturnStatus().hashCode());
        result = prime * result + ((getReturnUnitPrice() == null) ? 0 : getReturnUnitPrice().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getReturnSendMoney() == null) ? 0 : getReturnSendMoney().hashCode());
        result = prime * result + ((getReturnMoney() == null) ? 0 : getReturnMoney().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getReturnTime() == null) ? 0 : getReturnTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", returnOrderId=").append(returnOrderId);
        sb.append(", returnSerialNo=").append(returnSerialNo);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSerialNo=").append(orderSerialNo);
        sb.append(", userId=").append(userId);
        sb.append(", shopId=").append(shopId);
        sb.append(", orderGoodsId=").append(orderGoodsId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", amount=").append(amount);
        sb.append(", reason=").append(reason);
        sb.append(", returnContact=").append(returnContact);
        sb.append(", returnAddress=").append(returnAddress);
        sb.append(", returnTel=").append(returnTel);
        sb.append(", reply=").append(reply);
        sb.append(", returnStyle=").append(returnStyle);
        sb.append(", takeStyle=").append(takeStyle);
        sb.append(", returnStatus=").append(returnStatus);
        sb.append(", returnUnitPrice=").append(returnUnitPrice);
        sb.append(", balance=").append(balance);
        sb.append(", returnSendMoney=").append(returnSendMoney);
        sb.append(", returnMoney=").append(returnMoney);
        sb.append(", createTime=").append(createTime);
        sb.append(", returnTime=").append(returnTime);
        sb.append("]");
        return sb.toString();
    }
}