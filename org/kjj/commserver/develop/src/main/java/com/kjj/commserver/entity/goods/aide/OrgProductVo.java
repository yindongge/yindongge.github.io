package com.kjj.commserver.entity.goods.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.constant.UploadConstant;
import com.kjj.commserver.entity.goods.OrgProduct;

public class OrgProductVo extends OrgProduct {
	/**品牌名称*/
	private String productBrandName;
	/**库存*/
	private Integer inventory;
	
	/** 商品压缩图片25x25 */
	private String goodsImg25;
	
	/** 商品压缩图片50x50 */
	private String goodsImg50;
	
	/** 商品压缩图片180x180 */
	private String goodsImg180;
	
	/** 商品压缩图片180x180 */
	private String goodsImg350;

	public String getProductBrandName() {
		return productBrandName;
	}

	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getGoodsImg25() {
		return goodsImg25;
	}

	public void setGoodsImg25(String goodsImg25) {
		this.goodsImg25 = goodsImg25;
	}

	public String getGoodsImg50() {
		return goodsImg50;
	}

	public void setGoodsImg50(String goodsImg50) {
		this.goodsImg50 = goodsImg50;
	}

	public String getGoodsImg180() {
		return goodsImg180;
	}

	public void setGoodsImg180(String goodsImg180) {
		this.goodsImg180 = goodsImg180;
	}

	public String getGoodsImg350() {
		return goodsImg350;
	}

	public void setGoodsImg350(String goodsImg350) {
		this.goodsImg350 = goodsImg350;
	}

	@Override
	public void setGoodsImg(String goodsImg){
		if(goodsImg.indexOf(ImageConstant.IMAGE_BASE_URL)==-1){
			goodsImg=ImageConstant.IMAGE_BASE_URL+goodsImg;
    	}
		super.setGoodsImg(goodsImg);
		setGoodsImg25(goodsImg.replace("_", "_25x25"));
        setGoodsImg50(goodsImg.replace("_", "_50x50"));
        setGoodsImg180(goodsImg.replace("_", "_180x180"));
        setGoodsImg350(goodsImg.replace("_", "_350x350"));
	}

	@Override
	public void setGoodsDesc(String goodsDesc) {
		if(StringUtils.isNotEmpty(goodsDesc) && goodsDesc.indexOf(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL)==-1){
			goodsDesc= goodsDesc.replace("src=\"", "src=\""+UploadConstant.KINDEDITOR_UPLOAD_BASE_URL);
		}
		super.setGoodsDesc(goodsDesc);
	}

	@Override
	public void setMobileGoodsDesc(String mobileGoodsDesc) {
		if(StringUtils.isNotEmpty(mobileGoodsDesc) && mobileGoodsDesc.indexOf(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL)==-1){
			mobileGoodsDesc= mobileGoodsDesc.replace("src=\"", "src=\""+UploadConstant.KINDEDITOR_UPLOAD_BASE_URL);
		}
		super.setMobileGoodsDesc(mobileGoodsDesc);
	}
	
}