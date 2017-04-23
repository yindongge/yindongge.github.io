package com.kjj.commserver.entity.shop.aide;

import com.kjj.commserver.entity.shop.OrgShopPage;

public class OrgShopPageForm extends OrgShopPage{
	/** 省区号 */
	private String provinceCode;
	/** 市区号 */
	private String cityCode;
	/** 县区号 */
	private String countyCode;
	
	/** 店铺 */
	private String shop_id;

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

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	
	
	

}
