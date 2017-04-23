package com.kjj.commserver.entity.order.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.order.OrgReturnOrderImg;

public class OrgReturnOrderImgVo extends OrgReturnOrderImg {
	
	@Override
	public void setImgUrl(String imgUrl) {
		super.setImgUrl(StringUtils.isBlank(imgUrl) ? null : ImageConstant.IMAGE_BASE_URL + imgUrl);
    }
}