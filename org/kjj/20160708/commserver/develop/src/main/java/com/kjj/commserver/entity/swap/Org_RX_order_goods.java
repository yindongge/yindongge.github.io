package com.kjj.commserver.entity.swap;

import java.math.BigDecimal;

public class Org_RX_order_goods {
	  private String docno;
	  private String pluno;
	  private Integer qty;
	  private BigDecimal slprc;
	  private BigDecimal absslprc;
	  private BigDecimal slamt;
	  private BigDecimal slnet;
	  private BigDecimal disamt;
	  private Integer sno;
	  private String dsc;
	  private String shpno;
	public String getDocno() {
		return docno;
	}
	public void setDocno(String docno) {
		this.docno = docno;
	}
	public String getPluno() {
		return pluno;
	}
	public void setPluno(String pluno) {
		this.pluno = pluno;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public BigDecimal getSlprc() {
		return slprc;
	}
	public void setSlprc(BigDecimal slprc) {
		this.slprc = slprc;
	}
	public BigDecimal getAbsslprc() {
		return absslprc;
	}
	public void setAbsslprc(BigDecimal absslprc) {
		this.absslprc = absslprc;
	}
	public BigDecimal getSlamt() {
		return slamt;
	}
	public void setSlamt(BigDecimal slamt) {
		this.slamt = slamt;
	}
	public BigDecimal getSlnet() {
		return slnet;
	}
	public void setSlnet(BigDecimal slnet) {
		this.slnet = slnet;
	}
	public BigDecimal getDisamt() {
		return disamt;
	}
	public void setDisamt(BigDecimal disamt) {
		this.disamt = disamt;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	public String getShpno() {
		return shpno;
	}
	public void setShpno(String shpno) {
		this.shpno = shpno;
	}
}
