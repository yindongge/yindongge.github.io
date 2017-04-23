package com.kjj.commserver.dao.discount;

import java.util.Map;

import com.kjj.commserver.entity.discount.OrgDiscountShop;
import com.kjj.core.dao.BaseDao;

public interface OrgDiscountShopDao extends BaseDao<OrgDiscountShop, Integer> {
	
	/**
	 * 查询相关店铺信息
	 * @param typeId
	 * @param discountId
	 * @return
	 */
	Map<String, String> selectInfo(Byte typeId,Integer discountId);
}