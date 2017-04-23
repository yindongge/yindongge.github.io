package com.kjj.commserver.entity.shop.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.shop.OrgShopRecommand;

public class OrgShopRecommandVo extends OrgShopRecommand {
	
	@Override
	public void setRecommandImg1(String recommandImg1) {
        super.setRecommandImg1(StringUtils.isBlank(recommandImg1) ? null : ImageConstant.IMAGE_BASE_URL + recommandImg1);
    }

    @Override
    public void setRecommandImg2(String recommandImg2) {
    	super.setRecommandImg2(StringUtils.isBlank(recommandImg2) ? null : ImageConstant.IMAGE_BASE_URL + recommandImg2);
    }
}