package com.kjj.commserver.entity.shop.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.shop.OrgShopBanner;

public class OrgShopBannerVo extends OrgShopBanner {
	
	@Override
    public void setOrgShopBanner(String orgShopBanner) {
        super.setOrgShopBanner(StringUtils.isBlank(orgShopBanner) ? null : ImageConstant.IMAGE_BASE_URL + orgShopBanner);
    }
}