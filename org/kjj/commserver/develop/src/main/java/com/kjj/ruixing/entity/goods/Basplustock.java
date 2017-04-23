package com.kjj.ruixing.entity.goods;

import java.math.BigDecimal;
import java.util.Date;

public class Basplustock {
    /** 网点ID */
    private Short pluid;

    /** 商品ID */
    private Short shpid;

    /** 网点编码 */
    private String shpno;

    /** 网点名称 */
    private String shpname;

    /** 商品编码 */
    private String pluno;

    /** 商品名称 */
    private String pluname;

    /** 零售单价 */
    private BigDecimal slprc;

    /** 条码 */
    private String bcd;

    /** 库存数量 */
    private Short fqty;

    /** 更新日期 */
    private Date syncdate;

    /** 所属配送库存 */
    private BigDecimal psqty;

    /** 会员价 */
    private BigDecimal aslprc;

    public Short getPluid() {
        return pluid;
    }

    public void setPluid(Short pluid) {
        this.pluid = pluid;
    }

    public Short getShpid() {
        return shpid;
    }

    public void setShpid(Short shpid) {
        this.shpid = shpid;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno == null ? null : shpno.trim();
    }

    public String getShpname() {
        return shpname;
    }

    public void setShpname(String shpname) {
        this.shpname = shpname == null ? null : shpname.trim();
    }

    public String getPluno() {
        return pluno;
    }

    public void setPluno(String pluno) {
        this.pluno = pluno == null ? null : pluno.trim();
    }

    public String getPluname() {
        return pluname;
    }

    public void setPluname(String pluname) {
        this.pluname = pluname == null ? null : pluname.trim();
    }

    public BigDecimal getSlprc() {
        return slprc;
    }

    public void setSlprc(BigDecimal slprc) {
        this.slprc = slprc;
    }

    public String getBcd() {
        return bcd;
    }

    public void setBcd(String bcd) {
        this.bcd = bcd == null ? null : bcd.trim();
    }

    public Short getFqty() {
        return fqty;
    }

    public void setFqty(Short fqty) {
        this.fqty = fqty;
    }

    public Date getSyncdate() {
        return syncdate;
    }

    public void setSyncdate(Date syncdate) {
        this.syncdate = syncdate;
    }

    public BigDecimal getPsqty() {
        return psqty;
    }

    public void setPsqty(BigDecimal psqty) {
        this.psqty = psqty;
    }

    public BigDecimal getAslprc() {
        return aslprc;
    }

    public void setAslprc(BigDecimal aslprc) {
        this.aslprc = aslprc;
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
        Basplustock other = (Basplustock) that;
        return (this.getPluid() == null ? other.getPluid() == null : this.getPluid().equals(other.getPluid()))
            && (this.getShpid() == null ? other.getShpid() == null : this.getShpid().equals(other.getShpid()))
            && (this.getShpno() == null ? other.getShpno() == null : this.getShpno().equals(other.getShpno()))
            && (this.getShpname() == null ? other.getShpname() == null : this.getShpname().equals(other.getShpname()))
            && (this.getPluno() == null ? other.getPluno() == null : this.getPluno().equals(other.getPluno()))
            && (this.getPluname() == null ? other.getPluname() == null : this.getPluname().equals(other.getPluname()))
            && (this.getSlprc() == null ? other.getSlprc() == null : this.getSlprc().equals(other.getSlprc()))
            && (this.getBcd() == null ? other.getBcd() == null : this.getBcd().equals(other.getBcd()))
            && (this.getFqty() == null ? other.getFqty() == null : this.getFqty().equals(other.getFqty()))
            && (this.getSyncdate() == null ? other.getSyncdate() == null : this.getSyncdate().equals(other.getSyncdate()))
            && (this.getPsqty() == null ? other.getPsqty() == null : this.getPsqty().equals(other.getPsqty()))
            && (this.getAslprc() == null ? other.getAslprc() == null : this.getAslprc().equals(other.getAslprc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPluid() == null) ? 0 : getPluid().hashCode());
        result = prime * result + ((getShpid() == null) ? 0 : getShpid().hashCode());
        result = prime * result + ((getShpno() == null) ? 0 : getShpno().hashCode());
        result = prime * result + ((getShpname() == null) ? 0 : getShpname().hashCode());
        result = prime * result + ((getPluno() == null) ? 0 : getPluno().hashCode());
        result = prime * result + ((getPluname() == null) ? 0 : getPluname().hashCode());
        result = prime * result + ((getSlprc() == null) ? 0 : getSlprc().hashCode());
        result = prime * result + ((getBcd() == null) ? 0 : getBcd().hashCode());
        result = prime * result + ((getFqty() == null) ? 0 : getFqty().hashCode());
        result = prime * result + ((getSyncdate() == null) ? 0 : getSyncdate().hashCode());
        result = prime * result + ((getPsqty() == null) ? 0 : getPsqty().hashCode());
        result = prime * result + ((getAslprc() == null) ? 0 : getAslprc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pluid=").append(pluid);
        sb.append(", shpid=").append(shpid);
        sb.append(", shpno=").append(shpno);
        sb.append(", shpname=").append(shpname);
        sb.append(", pluno=").append(pluno);
        sb.append(", pluname=").append(pluname);
        sb.append(", slprc=").append(slprc);
        sb.append(", bcd=").append(bcd);
        sb.append(", fqty=").append(fqty);
        sb.append(", syncdate=").append(syncdate);
        sb.append(", psqty=").append(psqty);
        sb.append(", aslprc=").append(aslprc);
        sb.append("]");
        return sb.toString();
    }
}