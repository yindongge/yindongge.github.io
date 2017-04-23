package com.kjj.commserver.entity.shop.aide;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.system.aide.OrgLocation;

public class OrgShopQuery extends OrgShop {
	
	/** 店铺名称或编号 */ 
	private String codeOrNameLike;
	/** 省编号 */ 
	private String provinceCode;
	/** 市编号 */ 
	private String cityCode;
	/** 区编号 */ 
	private String countyCode;
	/** 位置 */ 
	private OrgLocation orgLocation;
	/** ariticleId */
	private Integer ariticleId;
	/** shopIds */
	private Collection<Integer> shopIds;
	/** areaCodeLike */
	private String areaCodeLike;
	
	public String getCodeOrNameLike() {
		return codeOrNameLike;
	}
	public void setCodeOrNameLike(String codeOrNameLike) {
		this.codeOrNameLike = codeOrNameLike;
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
	public OrgLocation getOrgLocation() {
		return orgLocation;
	}
	public void setOrgLocation(OrgLocation orgLocation) {
		this.orgLocation = orgLocation;
	}
	public Integer getAriticleId() {
		return ariticleId;
	}
	public void setAriticleId(Integer ariticleId) {
		this.ariticleId = ariticleId;
	}
	public Collection<Integer> getShopIds() {
		return shopIds;
	}
	public void setShopIds(Collection<Integer> shopIds) {
		this.shopIds = shopIds;
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