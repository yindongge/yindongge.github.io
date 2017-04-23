package com.kjj.commserver.entity.shop.aide;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShop;

public class OrgShopForm extends OrgShop{
	/** 省区号 */
	private String provinceCode;
	/** 市区号 */
	private String cityCode;
	/** 县区号 */
	private String countyCode;
	/** 配送范围 */
	private List<String> sendRangeList;
	/** 商户服务 */
	private List<Short> shopServiceList;
	/** 24小时营业 */
	private boolean fullTime;
	
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public List<String> getSendRangeList() {
		return sendRangeList;
	}
	public void setSendRangeList(List<String> sendRangeList) {
		this.sendRangeList = sendRangeList;
	}
	public List<Short> getShopServiceList() {
		return shopServiceList;
	}
	public void setShopServiceList(List<Short> shopServiceList) {
		this.shopServiceList = shopServiceList;
	}
	public boolean isFullTime() {
		return fullTime;
	}
	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}
	
}
