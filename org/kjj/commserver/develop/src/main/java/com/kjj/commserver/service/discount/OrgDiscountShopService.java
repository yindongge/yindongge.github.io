package com.kjj.commserver.service.discount;

import java.util.Collection;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgDiscountShop;
import com.kjj.core.service.BaseService;

public interface OrgDiscountShopService extends BaseService<OrgDiscountShop, Integer> {

	/**
	 * 添加适用店铺
	 * @param typeId
	 * @param discountId
	 * @param shopType
	 * @param listCity
	 * @param listShop
	 */
	void addByDiscount(Byte typeId, Integer discountId, Byte shopType,Collection<String> listCity, Collection<Integer> listShop);
	/**
	 * 修改适用店铺
	 * @param typeId
	 * @param discountId
	 * @param shopType
	 * @param listCity
	 * @param listShop
	 */
	void updateByDiscount(Byte typeId, Integer discountId, Byte shopType,Collection<String> listCity, Collection<Integer> listShop);

	/**
	 * 查询相关店铺信息
	 * @param typeId
	 * @param discountId
	 * @return
	 */
	Map<String,String> queryInfo(Byte typeId,Integer discountId);
	
}