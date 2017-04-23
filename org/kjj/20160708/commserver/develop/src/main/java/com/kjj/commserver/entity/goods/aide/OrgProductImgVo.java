package com.kjj.commserver.entity.goods.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.goods.OrgProductImg;

public class OrgProductImgVo extends OrgProductImg {
	/** 商品压缩图片25x25 */
	private String imgUrl25;
	
	/** 商品压缩图片50x50 */
	private String imgUrl50;
	
	/** 商品压缩图片180x180 */
	private String imgUrl180;
	
	/** 商品压缩图片350x350 */
	private String imgUrl350;

	public String getImgUrl25() {
		return imgUrl25;
	}

	public void setImgUrl25(String imgUrl25) {
		this.imgUrl25 = imgUrl25;
	}

	public String getImgUrl50() {
		return imgUrl50;
	}

	public void setImgUrl50(String imgUrl50) {
		this.imgUrl50 = imgUrl50;
	}

	public String getImgUrl180() {
		return imgUrl180;
	}

	public void setImgUrl180(String imgUrl180) {
		this.imgUrl180 = imgUrl180;
	}

	public String getImgUrl350() {
		return imgUrl350;
	}

	public void setImgUrl350(String imgUrl350) {
		this.imgUrl350 = imgUrl350;
	}

	@Override
    public void setImgUrl(String imgUrl) {
        if(StringUtils.isNotEmpty(imgUrl)){
        	if(imgUrl.indexOf(ImageConstant.IMAGE_BASE_URL)==-1){
        		imgUrl=ImageConstant.IMAGE_BASE_URL+imgUrl;
        	}
        	setImgUrl25(imgUrl.replace("_", "_25x25"));
        	setImgUrl50(imgUrl.replace("_", "_50x50"));
        	setImgUrl180(imgUrl.replace("_", "_180x180"));
        	setImgUrl350(imgUrl.replace("_", "_350x350"));
        }
        super.setImgUrl(imgUrl == null ? null : imgUrl.trim());
    }
}