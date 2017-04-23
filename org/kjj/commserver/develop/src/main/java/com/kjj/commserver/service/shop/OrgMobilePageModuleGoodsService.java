package com.kjj.commserver.service.shop;

import com.kjj.commserver.entity.shop.OrgMobilePageModuleGoods;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageModuleGoodsQuery;
import com.kjj.core.service.BaseService;

public interface OrgMobilePageModuleGoodsService extends BaseService<OrgMobilePageModuleGoods, Integer> {
	/**
	 * 向模块区增加商品
	 */
	void addGoods(OrgMobilePageModuleGoods module);
	/**
	 * 删除模块区商品
	 */
	void deleteGoods(OrgMobilePageModuleGoodsQuery module);
	/**
	 * 删除商品byModuleId
	 */
	void deleteGoodsByModuleId(OrgMobilePageModuleGoodsQuery query);

}