package com.kjj.commserver.entity.shop.aide;

import com.kjj.commserver.entity.shop.OrgBusinessArea;

public class OrgBusinessAreaAll extends OrgBusinessArea{

	/** 省区号 */
	private String provinceCode;
	/** 市区号 */
	private String cityCode;
	/** 县区号 */
	private String countyCode;
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
	
	
}
