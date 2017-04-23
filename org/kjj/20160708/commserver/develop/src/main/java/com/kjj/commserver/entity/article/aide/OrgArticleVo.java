package com.kjj.commserver.entity.article.aide;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.constant.UploadConstant;
import com.kjj.commserver.entity.article.OrgArticle;


public class OrgArticleVo extends OrgArticle {
	
	private String className;
	
	private String userName;
	
	private String shopId;
	
	@Override
	public void setContent(String content) {
        super.setContent(content.replace("src=\"", "src=\"" + UploadConstant.KINDEDITOR_UPLOAD_BASE_URL));
    }

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Override
	public void setImage(String image) {
		if(image.indexOf(ImageConstant.IMAGE_BASE_URL)==-1){
			image=ImageConstant.IMAGE_BASE_URL+image;
		}
		super.setImage(image);
	}


}