package com.kjj.commserver.entity.goods.aide;

import com.kjj.commserver.entity.goods.OrgAdvertisement;

public class OrgAdvertisementQuery extends OrgAdvertisement {
	/**一级分类Id*/
	private Integer classLevel1;
	/**二级分类Id*/
	private Integer classLevel2;
	/**skuId*/
	private Integer skuId;
	
	public Integer getClassLevel1() {
		return classLevel1;
	}
	public void setClassLevel1(Integer classLevel1) {
		this.classLevel1 = classLevel1;
	}
	public Integer getClassLevel2() {
		return classLevel2;
	}
	public void setClassLevel2(Integer classLevel2) {
		this.classLevel2 = classLevel2;
	}
	public Integer getSkuId() {
		return skuId;
	}
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	
	
}