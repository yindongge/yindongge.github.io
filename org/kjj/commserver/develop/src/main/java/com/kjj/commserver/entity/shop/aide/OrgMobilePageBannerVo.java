package com.kjj.commserver.entity.shop.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.shop.OrgMobilePageBanner;

public class OrgMobilePageBannerVo extends OrgMobilePageBanner {
	@Override
    public void setBannerImg(String bannerImg) {
        super.setBannerImg(StringUtils.isBlank(bannerImg) ? null : ImageConstant.IMAGE_BASE_URL + bannerImg);
    }
}