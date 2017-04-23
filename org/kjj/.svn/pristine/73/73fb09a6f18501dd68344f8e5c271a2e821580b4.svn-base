package com.kjj.commserver.service.shop;

import com.kjj.commserver.entity.shop.OrgShopPageImg;
import com.kjj.commserver.entity.shop.aide.OrgShopForm;
import com.kjj.commserver.entity.shop.aide.OrgShopImgForm;
import com.kjj.core.service.BaseService;

public interface OrgShopPageImgService extends BaseService<OrgShopPageImg, Integer> {
	
	/**
	 *  店铺图片的更新
	 * @param shopForm 
	 * @param shopImgForm
	 */
	void updatePageImg(OrgShopForm shopForm, OrgShopImgForm shopImgForm);

	OrgShopPageImg queryImgByType(Integer shopId, byte type);
}