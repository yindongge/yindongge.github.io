package com.kjj.ruixing.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class Doc21bf {
    /** 销售单号 */
    private String docno;

    /** 销售门店 */
    private String shpno;

    /** 记帐日期 */
    private Date docdat;

    /** 会员编码 */
    private String vipno;

    /** 订单金额 */
    private BigDecimal slamt;

    /** 折扣金额 */
    private BigDecimal disamt;

    /** 配送费 */
    private BigDecimal psamt;

    /** 单据状态(0 预订单 1 已发货 2 取消) */
    private Byte status;

    /** 备注 */
    private String dsc;

    /** 差异分币金额 */
    private BigDecimal diffamt;

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno == null ? null : docno.trim();
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno == null ? null : shpno.trim();
    }

    public Date getDocdat() {
        return docdat;
    }

    public void setDocdat(Date docdat) {
        this.docdat = docdat;
    }

    public String getVipno() {
        return vipno;
    }

    public void setVipno(String vipno) {
        this.vipno = vipno == null ? null : vipno.trim();
    }

    public BigDecimal getSlamt() {
        return slamt;
    }

    public void setSlamt(BigDecimal slamt) {
        this.slamt = slamt;
    }

    public BigDecimal getDisamt() {
        return disamt;
    }

    public void setDisamt(BigDecimal disamt) {
        this.disamt = disamt;
    }

    public BigDecimal getPsamt() {
        return psamt;
    }

    public void setPsamt(BigDecimal psamt) {
        this.psamt = psamt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc == null ? null : dsc.trim();
    }

    public BigDecimal getDiffamt() {
        return diffamt;
    }

    public void setDiffamt(BigDecimal diffamt) {
        this.diffamt = diffamt;
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
        Doc21bf other = (Doc21bf) that;
        return (this.getDocno() == null ? other.getDocno() == null : this.getDocno().equals(other.getDocno()))
            && (this.getShpno() == null ? other.getShpno() == null : this.getShpno().equals(other.getShpno()))
            && (this.getDocdat() == null ? other.getDocdat() == null : this.getDocdat().equals(other.getDocdat()))
            && (this.getVipno() == null ? other.getVipno() == null : this.getVipno().equals(other.getVipno()))
            && (this.getSlamt() == null ? other.getSlamt() == null : this.getSlamt().equals(other.getSlamt()))
            && (this.getDisamt() == null ? other.getDisamt() == null : this.getDisamt().equals(other.getDisamt()))
            && (this.getPsamt() == null ? other.getPsamt() == null : this.getPsamt().equals(other.getPsamt()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDsc() == null ? other.getDsc() == null : this.getDsc().equals(other.getDsc()))
            && (this.getDiffamt() == null ? other.getDiffamt() == null : this.getDiffamt().equals(other.getDiffamt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDocno() == null) ? 0 : getDocno().hashCode());
        result = prime * result + ((getShpno() == null) ? 0 : getShpno().hashCode());
        result = prime * result + ((getDocdat() == null) ? 0 : getDocdat().hashCode());
        result = prime * result + ((getVipno() == null) ? 0 : getVipno().hashCode());
        result = prime * result + ((getSlamt() == null) ? 0 : getSlamt().hashCode());
        result = prime * result + ((getDisamt() == null) ? 0 : getDisamt().hashCode());
        result = prime * result + ((getPsamt() == null) ? 0 : getPsamt().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDsc() == null) ? 0 : getDsc().hashCode());
        result = prime * result + ((getDiffamt() == null) ? 0 : getDiffamt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", docno=").append(docno);
        sb.append(", shpno=").append(shpno);
        sb.append(", docdat=").append(docdat);
        sb.append(", vipno=").append(vipno);
        sb.append(", slamt=").append(slamt);
        sb.append(", disamt=").append(disamt);
        sb.append(", psamt=").append(psamt);
        sb.append(", status=").append(status);
        sb.append(", dsc=").append(dsc);
        sb.append(", diffamt=").append(diffamt);
        sb.append("]");
        return sb.toString();
    }
}