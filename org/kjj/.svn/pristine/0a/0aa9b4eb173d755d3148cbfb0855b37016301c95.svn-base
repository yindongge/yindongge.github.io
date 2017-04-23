package com.kjj.commserver.entity.order;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrgOrder {
    /** 订单ID */
    private Integer orderId;

    /** 流水号 */
    private Long serialNo;

    /** 店铺ID对应org_shop表shop_id字段 */
    private Integer shopId;

    /** 用户ID对应org_user表user_id字段 */
    private Integer userId;

    /** 应收金额 */
    private BigDecimal accounts;

    /** 优惠金额 */
    private BigDecimal discount;

    /** 调整金额 */
    private BigDecimal balance;

    /** 配送费 */
    private BigDecimal sendMoney;

    /** 订单金额 */
    private BigDecimal orderMoney;
    
    /** 使用预存款金额 */
    private BigDecimal depositMoney;
    
    /** 预存款退款累计 */
    private BigDecimal depositRefund;
    
    /** 支付金额 */
    private BigDecimal payMoney;

    /** 收货人 */
    private String consignee;

    /** 收货地址 */
    private String consigneeAddress;

    /** 收货人电话 */
    private String consigneeTel;

    /** 收货人手机号 */
    private String consigneeMobile;

    /** 收货人email */
    private String consigneeEmail;

    /** 发票 */
    private String invoice;

    /** 配送方式 0：送货上门 1：到店自取 */
    private Byte sendStyle;

    /** 配送日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date sendDate;

    /** 配送起始时间 */
    @DateTimeFormat(pattern = "HH:mm:ss") 
    private Date sendTimeStart;

    /** 配送结束时间 */
    @DateTimeFormat(pattern = "HH:mm:ss") 
    private Date sendTimeEnd;

    /** 自提日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date takeDate;

    /** 取货码 */
    private String takeCode;

    /** 支付方式 0：在线支付 1：货到付款 */
    private Byte payStyle;

    /** 货到付款方式 1：现金2：pos */
    private Byte localPayStyle;

    /** 在线支付方式 1.支付宝 2.微信支付 3.财付通 4.银联支付5.手机微信支付 */
    private Byte onlinePayStyle;

    /** 订单来源 1.pc 2触屏版 */
    private Byte source;

    /** 备注 */
    private String remark;

    /** 支付状态 0:未支付 1:已支付 */
    private Byte payStatus;

    /** 评价状态 0：未评价 1：已评价 */
    private Byte commentStatus;

    /** 退货状态 0：可退货 1.不可退货 */
    private Byte returnStatus;

    /** 订单状态 0.生成订单 1.未确认 2.代发货 3.已发货 4.已收货 5.已取消 6.已关闭 */
    private Byte status;

    /** 创建时间 */
    private Date createTime;

    /** 支付时间 */
    private Date payTime;
    
    /** 完成时间 */
    private Date finishTime;

    /** 网上支付付款时间限制 单位：分钟 */
    private Short limitPayTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAccounts() {
        return accounts;
    }

    public void setAccounts(BigDecimal accounts) {
        this.accounts = accounts;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(BigDecimal sendMoney) {
        this.sendMoney = sendMoney;
    }

    public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

	public BigDecimal getDepositMoney() {
		return depositMoney;
	}

	public void setDepositMoney(BigDecimal depositMoney) {
		this.depositMoney = depositMoney;
	}

	public BigDecimal getDepositRefund() {
		return depositRefund;
	}

	public void setDepositRefund(BigDecimal depositRefund) {
		this.depositRefund = depositRefund;
	}

	public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress == null ? null : consigneeAddress.trim();
    }

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel == null ? null : consigneeTel.trim();
    }

    public String getConsigneeMobile() {
        return consigneeMobile;
    }

    public void setConsigneeMobile(String consigneeMobile) {
        this.consigneeMobile = consigneeMobile == null ? null : consigneeMobile.trim();
    }

    public String getConsigneeEmail() {
        return consigneeEmail;
    }

    public void setConsigneeEmail(String consigneeEmail) {
        this.consigneeEmail = consigneeEmail == null ? null : consigneeEmail.trim();
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public Byte getSendStyle() {
        return sendStyle;
    }

    public void setSendStyle(Byte sendStyle) {
        this.sendStyle = sendStyle;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getSendTimeStart() {
        return sendTimeStart;
    }

    public void setSendTimeStart(Date sendTimeStart) {
        this.sendTimeStart = sendTimeStart;
    }

    public Date getSendTimeEnd() {
        return sendTimeEnd;
    }

    public void setSendTimeEnd(Date sendTimeEnd) {
        this.sendTimeEnd = sendTimeEnd;
    }

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public String getTakeCode() {
        return takeCode;
    }

    public void setTakeCode(String takeCode) {
        this.takeCode = takeCode == null ? null : takeCode.trim();
    }

    public Byte getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(Byte payStyle) {
        this.payStyle = payStyle;
    }

    public Byte getLocalPayStyle() {
        return localPayStyle;
    }

    public void setLocalPayStyle(Byte localPayStyle) {
        this.localPayStyle = localPayStyle;
    }

    public Byte getOnlinePayStyle() {
        return onlinePayStyle;
    }

    public void setOnlinePayStyle(Byte onlinePayStyle) {
        this.onlinePayStyle = onlinePayStyle;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Short getLimitPayTime() {
        return limitPayTime;
    }

    public void setLimitPayTime(Short limitPayTime) {
        this.limitPayTime = limitPayTime;
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
        OrgOrder other = (OrgOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAccounts() == null ? other.getAccounts() == null : this.getAccounts().equals(other.getAccounts()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getSendMoney() == null ? other.getSendMoney() == null : this.getSendMoney().equals(other.getSendMoney()))
            && (this.getOrderMoney() == null ? other.getOrderMoney() == null : this.getOrderMoney().equals(other.getOrderMoney()))
            && (this.getDepositMoney() == null ? other.getDepositMoney() == null : this.getDepositMoney().equals(other.getDepositMoney()))
            && (this.getPayMoney() == null ? other.getPayMoney() == null : this.getPayMoney().equals(other.getPayMoney()))
            && (this.getConsignee() == null ? other.getConsignee() == null : this.getConsignee().equals(other.getConsignee()))
            && (this.getConsigneeAddress() == null ? other.getConsigneeAddress() == null : this.getConsigneeAddress().equals(other.getConsigneeAddress()))
            && (this.getConsigneeTel() == null ? other.getConsigneeTel() == null : this.getConsigneeTel().equals(other.getConsigneeTel()))
            && (this.getConsigneeMobile() == null ? other.getConsigneeMobile() == null : this.getConsigneeMobile().equals(other.getConsigneeMobile()))
            && (this.getConsigneeEmail() == null ? other.getConsigneeEmail() == null : this.getConsigneeEmail().equals(other.getConsigneeEmail()))
            && (this.getInvoice() == null ? other.getInvoice() == null : this.getInvoice().equals(other.getInvoice()))
            && (this.getSendStyle() == null ? other.getSendStyle() == null : this.getSendStyle().equals(other.getSendStyle()))
            && (this.getSendDate() == null ? other.getSendDate() == null : this.getSendDate().equals(other.getSendDate()))
            && (this.getSendTimeStart() == null ? other.getSendTimeStart() == null : this.getSendTimeStart().equals(other.getSendTimeStart()))
            && (this.getSendTimeEnd() == null ? other.getSendTimeEnd() == null : this.getSendTimeEnd().equals(other.getSendTimeEnd()))
            && (this.getTakeDate() == null ? other.getTakeDate() == null : this.getTakeDate().equals(other.getTakeDate()))
            && (this.getTakeCode() == null ? other.getTakeCode() == null : this.getTakeCode().equals(other.getTakeCode()))
            && (this.getPayStyle() == null ? other.getPayStyle() == null : this.getPayStyle().equals(other.getPayStyle()))
            && (this.getLocalPayStyle() == null ? other.getLocalPayStyle() == null : this.getLocalPayStyle().equals(other.getLocalPayStyle()))
            && (this.getOnlinePayStyle() == null ? other.getOnlinePayStyle() == null : this.getOnlinePayStyle().equals(other.getOnlinePayStyle()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getCommentStatus() == null ? other.getCommentStatus() == null : this.getCommentStatus().equals(other.getCommentStatus()))
            && (this.getReturnStatus() == null ? other.getReturnStatus() == null : this.getReturnStatus().equals(other.getReturnStatus()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getLimitPayTime() == null ? other.getLimitPayTime() == null : this.getLimitPayTime().equals(other.getLimitPayTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAccounts() == null) ? 0 : getAccounts().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getSendMoney() == null) ? 0 : getSendMoney().hashCode());
        result = prime * result + ((getOrderMoney() == null) ? 0 : getOrderMoney().hashCode());
        result = prime * result + ((getDepositMoney() == null) ? 0 : getDepositMoney().hashCode());
        result = prime * result + ((getPayMoney() == null) ? 0 : getPayMoney().hashCode());
        result = prime * result + ((getConsignee() == null) ? 0 : getConsignee().hashCode());
        result = prime * result + ((getConsigneeAddress() == null) ? 0 : getConsigneeAddress().hashCode());
        result = prime * result + ((getConsigneeTel() == null) ? 0 : getConsigneeTel().hashCode());
        result = prime * result + ((getConsigneeMobile() == null) ? 0 : getConsigneeMobile().hashCode());
        result = prime * result + ((getConsigneeEmail() == null) ? 0 : getConsigneeEmail().hashCode());
        result = prime * result + ((getInvoice() == null) ? 0 : getInvoice().hashCode());
        result = prime * result + ((getSendStyle() == null) ? 0 : getSendStyle().hashCode());
        result = prime * result + ((getSendDate() == null) ? 0 : getSendDate().hashCode());
        result = prime * result + ((getSendTimeStart() == null) ? 0 : getSendTimeStart().hashCode());
        result = prime * result + ((getSendTimeEnd() == null) ? 0 : getSendTimeEnd().hashCode());
        result = prime * result + ((getTakeDate() == null) ? 0 : getTakeDate().hashCode());
        result = prime * result + ((getTakeCode() == null) ? 0 : getTakeCode().hashCode());
        result = prime * result + ((getPayStyle() == null) ? 0 : getPayStyle().hashCode());
        result = prime * result + ((getLocalPayStyle() == null) ? 0 : getLocalPayStyle().hashCode());
        result = prime * result + ((getOnlinePayStyle() == null) ? 0 : getOnlinePayStyle().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getCommentStatus() == null) ? 0 : getCommentStatus().hashCode());
        result = prime * result + ((getReturnStatus() == null) ? 0 : getReturnStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getLimitPayTime() == null) ? 0 : getLimitPayTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", shopId=").append(shopId);
        sb.append(", userId=").append(userId);
        sb.append(", accounts=").append(accounts);
        sb.append(", discount=").append(discount);
        sb.append(", balance=").append(balance);
        sb.append(", sendMoney=").append(sendMoney);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", depositMoney=").append(depositMoney);
        sb.append(", payMoney=").append(payMoney);
        sb.append(", consignee=").append(consignee);
        sb.append(", consigneeAddress=").append(consigneeAddress);
        sb.append(", consigneeTel=").append(consigneeTel);
        sb.append(", consigneeMobile=").append(consigneeMobile);
        sb.append(", consigneeEmail=").append(consigneeEmail);
        sb.append(", invoice=").append(invoice);
        sb.append(", sendStyle=").append(sendStyle);
        sb.append(", sendDate=").append(sendDate);
        sb.append(", sendTimeStart=").append(sendTimeStart);
        sb.append(", sendTimeEnd=").append(sendTimeEnd);
        sb.append(", takeDate=").append(takeDate);
        sb.append(", takeCode=").append(takeCode);
        sb.append(", payStyle=").append(payStyle);
        sb.append(", localPayStyle=").append(localPayStyle);
        sb.append(", onlinePayStyle=").append(onlinePayStyle);
        sb.append(", source=").append(source);
        sb.append(", remark=").append(remark);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", returnStatus=").append(returnStatus);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", limitPayTime=").append(limitPayTime);
        sb.append("]");
        return sb.toString();
    }
}