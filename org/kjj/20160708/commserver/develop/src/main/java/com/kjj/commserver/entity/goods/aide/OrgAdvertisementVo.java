package com.kjj.commserver.entity.goods.aide;

import com.kjj.commserver.entity.goods.OrgAdvertisement;

public class OrgAdvertisementVo extends OrgAdvertisement {
	/**推荐类型名称*/
	private String advertisementTypeName;
	/**商品分类名称*/
	private String productClassName;
	
	public String getAdvertisementTypeName() {
		return advertisementTypeName;
	}
	public void setAdvertisementTypeName(String advertisementTypeName) {
		this.advertisementTypeName = advertisementTypeName;
	}
	public String getProductClassName() {
		return productClassName;
	}
	public void setProductClassName(String productClassName) {
		this.productClassName = productClassName;
	}
	
}