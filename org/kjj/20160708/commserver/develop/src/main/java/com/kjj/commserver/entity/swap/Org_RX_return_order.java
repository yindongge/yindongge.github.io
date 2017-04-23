package com.kjj.commserver.entity.swap;

import java.math.BigDecimal;

public class Org_RX_return_order {
	  private String docno;
	  private String doc21no;
	  private String pluno;
	  private Integer qty;
	  private BigDecimal absslprc;
	  private BigDecimal slnet;
	  private String dsc;
	  private String shpno;
	  private BigDecimal psamt;
	  
	public String getDocno() {
		return docno;
	}
	public void setDocno(String docno) {
		this.docno = docno;
	}
	public String getDoc21no() {
		return doc21no;
	}
	public void setDoc21no(String doc21no) {
		this.doc21no = doc21no;
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
	public BigDecimal getAbsslprc() {
		return absslprc;
	}
	public void setAbsslprc(BigDecimal absslprc) {
		this.absslprc = absslprc;
	}
	public BigDecimal getSlnet() {
		return slnet;
	}
	public void setSlnet(BigDecimal slnet) {
		this.slnet = slnet;
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
	public BigDecimal getPsamt() {
		return psamt;
	}
	public void setPsamt(BigDecimal psamt) {
		this.psamt = psamt;
	}
}
