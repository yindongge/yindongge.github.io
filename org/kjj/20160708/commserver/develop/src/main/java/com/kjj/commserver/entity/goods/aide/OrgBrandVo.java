package com.kjj.commserver.entity.goods.aide;

import java.util.ArrayList;
import java.util.List;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;

public class OrgBrandVo extends OrgBrand {
	private List<OrgClass> classes = new ArrayList<OrgClass>();

	public List<OrgClass> getClasses() {
		return classes;
	}

	public void setClasses(List<OrgClass> classes) {
		this.classes = classes;
	}

	@Override
	public void setProductBrandLogoimage(String productBrandLogoimage) {
		if(productBrandLogoimage.indexOf(ImageConstant.IMAGE_BASE_URL)==-1){
			productBrandLogoimage=ImageConstant.IMAGE_BASE_URL+productBrandLogoimage;
    	}
		super.setProductBrandLogoimage(productBrandLogoimage);
	}
	
	
}