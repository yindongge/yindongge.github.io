package com.kjj.commserver.entity.shop.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.shop.OrgMobilePageModule;

public class OrgMobilePageModuleVo extends OrgMobilePageModule {
	@Override
	public void setModuleImg(String moduleImg){
		super.setModuleImg(StringUtils.isBlank(moduleImg)? null : ImageConstant.IMAGE_BASE_URL+moduleImg);
	}
	private Long count;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}