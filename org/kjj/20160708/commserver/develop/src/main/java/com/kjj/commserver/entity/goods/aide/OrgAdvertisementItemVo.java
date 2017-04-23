package com.kjj.commserver.entity.goods.aide;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.goods.OrgAdvertisement;
import com.kjj.commserver.entity.goods.OrgAdvertisementItem;

public class OrgAdvertisementItemVo extends OrgAdvertisementItem {
	/**商品货号*/
	private String goodsSn;
	/**商品名称*/
	private String goodsName;
	/**品牌名称*/
	private String productBrandName;
	/**商品图片*/
	private String goodsThumb;
	/**上下架状态：1上架0下架*/
	private Byte isOnSale;
	
	private OrgAdvertisement orgAdvertisement;
	
	public String getGoodsSn() {
		return goodsSn;
	}
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getProductBrandName() {
		return productBrandName;
	}
	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}
	public String getGoodsThumb() {
		return goodsThumb;
	}
	public void setGoodsThumb(String goodsThumb) {
		if(goodsThumb.indexOf(ImageConstant.IMAGE_BASE_URL)==-1){
			goodsThumb=ImageConstant.IMAGE_BASE_URL+goodsThumb;
    	}
		this.goodsThumb = goodsThumb;
	}
	public Byte getIsOnSale() {
		return isOnSale;
	}
	public void setIsOnSale(Byte isOnSale) {
		this.isOnSale = isOnSale;
	}
	public OrgAdvertisement getOrgAdvertisement() {
		return orgAdvertisement;
	}
	public void setOrgAdvertisement(OrgAdvertisement orgAdvertisement) {
		this.orgAdvertisement = orgAdvertisement;
	}
	
	
}