package com.kjj.commserver.entity.swap;

import java.math.BigDecimal;
import java.util.Date;

public class Org_RX_order {
	  private String docno;
	  private String shpno;
	  private Date docdat;
	  private String vipno;
	  private BigDecimal slamt;
	  private BigDecimal disamt;
	  private BigDecimal psamt;
	  private Integer status;
	  private String dsc;
	public String getDocno() {
		return docno;
	}
	public void setDocno(String docno) {
		this.docno = docno;
	}
	public String getShpno() {
		return shpno;
	}
	public void setShpno(String shpno) {
		this.shpno = shpno;
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
		this.vipno = vipno;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
}
