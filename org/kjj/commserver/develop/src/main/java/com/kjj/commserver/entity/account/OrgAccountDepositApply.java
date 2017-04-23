package com.kjj.commserver.entity.account;

import java.math.BigDecimal;
import java.util.Date;

public class OrgAccountDepositApply {
    /**  */
    private Integer id;

    /** 与org_users表的user_id对应 */
    private Integer userId;

    /** 与org_users表的user_name对应 */
    private String userName;

    /** 可用可提现金额增减值 */
    private BigDecimal fundAmount;

    /** 可用不可提现金额增减值 */
    private BigDecimal allowanceAmount;

    /** 冻结金额增减值 */
    private BigDecimal frozenAmount;

    /** 1消费 2充值 3提现 4退款 5手动增加 6手动减少 7手动冻结 8手动解冻 9 系统冻结 10 系统解解冻 */
    private Byte type;

    /** 申请时间 */
    private Date createTime;

    /** 申请原因 */
    private Byte reason;

    /** 申请备注 */
    private String applyComment;

    /** 1待处理 2处理成功 3处理失败4关闭 */
    private Byte status;

    /** 批量充值批次号 */
    private String batchCode;

    /** 1.支付宝 2.微信支付 3.财付通 4.银联支付5.手机微信支付6.手机支付宝7银行转账 */
    private Byte payStyle;

    /** 银行名称 */
    private String bankName;

    /** 支付账号 */
    private String paymentCode;

    /** 1 代表后台发起 2代表商城发起 3代表车帮 */
    private Byte source;

    /** 申请编号 */
    private String applyCode;

    /** 申请人 */
    private Integer createId;

    /** 申请人登录名 */
    private String createName;

    /** 失败原因 */
    private Byte failReason;

    /** 更新时间 */
    private Date updateTime;

    /** 更新人 */
    private Integer updateId;

    /** 更新人登录名 */
    private String updateName;

    /** 审核时间 */
    private Date checkTime;

    /** 审核备注 */
    private String checkComment;

    /** 审核人 */
    private Integer checkId;

    /** 审核人登录名 */
    private String checkName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public BigDecimal getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(BigDecimal fundAmount) {
        this.fundAmount = fundAmount;
    }

    public BigDecimal getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(BigDecimal allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getReason() {
        return reason;
    }

    public void setReason(Byte reason) {
        this.reason = reason;
    }

    public String getApplyComment() {
        return applyComment;
    }

    public void setApplyComment(String applyComment) {
        this.applyComment = applyComment == null ? null : applyComment.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode == null ? null : batchCode.trim();
    }

    public Byte getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(Byte payStyle) {
        this.payStyle = payStyle;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode == null ? null : paymentCode.trim();
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode == null ? null : applyCode.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Byte getFailReason() {
        return failReason;
    }

    public void setFailReason(Byte failReason) {
        this.failReason = failReason;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment == null ? null : checkComment.trim();
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName == null ? null : checkName.trim();
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
        OrgAccountDepositApply other = (OrgAccountDepositApply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getFundAmount() == null ? other.getFundAmount() == null : this.getFundAmount().equals(other.getFundAmount()))
            && (this.getAllowanceAmount() == null ? other.getAllowanceAmount() == null : this.getAllowanceAmount().equals(other.getAllowanceAmount()))
            && (this.getFrozenAmount() == null ? other.getFrozenAmount() == null : this.getFrozenAmount().equals(other.getFrozenAmount()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getApplyComment() == null ? other.getApplyComment() == null : this.getApplyComment().equals(other.getApplyComment()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBatchCode() == null ? other.getBatchCode() == null : this.getBatchCode().equals(other.getBatchCode()))
            && (this.getPayStyle() == null ? other.getPayStyle() == null : this.getPayStyle().equals(other.getPayStyle()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getPaymentCode() == null ? other.getPaymentCode() == null : this.getPaymentCode().equals(other.getPaymentCode()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getApplyCode() == null ? other.getApplyCode() == null : this.getApplyCode().equals(other.getApplyCode()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getFailReason() == null ? other.getFailReason() == null : this.getFailReason().equals(other.getFailReason()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getCheckComment() == null ? other.getCheckComment() == null : this.getCheckComment().equals(other.getCheckComment()))
            && (this.getCheckId() == null ? other.getCheckId() == null : this.getCheckId().equals(other.getCheckId()))
            && (this.getCheckName() == null ? other.getCheckName() == null : this.getCheckName().equals(other.getCheckName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getFundAmount() == null) ? 0 : getFundAmount().hashCode());
        result = prime * result + ((getAllowanceAmount() == null) ? 0 : getAllowanceAmount().hashCode());
        result = prime * result + ((getFrozenAmount() == null) ? 0 : getFrozenAmount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getApplyComment() == null) ? 0 : getApplyComment().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBatchCode() == null) ? 0 : getBatchCode().hashCode());
        result = prime * result + ((getPayStyle() == null) ? 0 : getPayStyle().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getPaymentCode() == null) ? 0 : getPaymentCode().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getApplyCode() == null) ? 0 : getApplyCode().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getFailReason() == null) ? 0 : getFailReason().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getCheckComment() == null) ? 0 : getCheckComment().hashCode());
        result = prime * result + ((getCheckId() == null) ? 0 : getCheckId().hashCode());
        result = prime * result + ((getCheckName() == null) ? 0 : getCheckName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", fundAmount=").append(fundAmount);
        sb.append(", allowanceAmount=").append(allowanceAmount);
        sb.append(", frozenAmount=").append(frozenAmount);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", reason=").append(reason);
        sb.append(", applyComment=").append(applyComment);
        sb.append(", status=").append(status);
        sb.append(", batchCode=").append(batchCode);
        sb.append(", payStyle=").append(payStyle);
        sb.append(", bankName=").append(bankName);
        sb.append(", paymentCode=").append(paymentCode);
        sb.append(", source=").append(source);
        sb.append(", applyCode=").append(applyCode);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", failReason=").append(failReason);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateName=").append(updateName);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", checkComment=").append(checkComment);
        sb.append(", checkId=").append(checkId);
        sb.append(", checkName=").append(checkName);
        sb.append("]");
        return sb.toString();
    }
}