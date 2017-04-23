package com.kjj.commserver.entity.shop.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.entity.shop.OrgBusinessArea;

public class OrgBusinessAreaQuery extends OrgBusinessArea {
	
	/** 商圈名称 */
	private String nameLike;
	/** 省区号 */
	private String provinceCode;
	/** 市区号 */
	private String cityCode;
	/** 县区号 */
	private String countyCode;
	/** areaCodeLike */
	private String areaCodeLike;

	public String getNameLike() {
		return nameLike;
	}
	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}
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
	public String getAreaCodeLike() {
		return areaCodeLike;
	}
	public void setAreaCodeLike(String areaCodeLike) {
		if (StringUtils.isBlank(areaCodeLike) || "-1".equals(areaCodeLike)) {
			//查询条件为空
			areaCodeLike = null;
		}else if(areaCodeLike.endsWith("0000")){
			//查询条件为省
			areaCodeLike = areaCodeLike.replace("0000", "");
		}else if(areaCodeLike.endsWith("00")){
			//查询条件为市
			areaCodeLike = areaCodeLike.replace("00", "");
		}else{
			//查询条件为县
		}
		this.areaCodeLike = areaCodeLike;
	}
}