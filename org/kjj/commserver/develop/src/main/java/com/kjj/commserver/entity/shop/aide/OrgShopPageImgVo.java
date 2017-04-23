package com.kjj.commserver.entity.shop.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.shop.OrgShopPageImg;

public class OrgShopPageImgVo extends OrgShopPageImg {
	@Override
    public void setPageImg(String pageImg) {
        super.setPageImg(StringUtils.isBlank(pageImg) ? null : ImageConstant.IMAGE_BASE_URL + pageImg);
    }
}