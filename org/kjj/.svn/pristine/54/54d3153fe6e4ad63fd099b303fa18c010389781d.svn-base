package com.kjj.commserver.service.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgProductInventoryClear;
import com.kjj.core.service.BaseService;

public interface OrgProductInventoryClearService extends BaseService<OrgProductInventoryClear, Integer> {
	/**
	 * 更新店铺的清空库存设置
	 * @param shopId
	 * @param InventoryClearList
	 */
	void updateInventoryClear(String shopCode, List<OrgProductInventoryClear> InventoryClearList);
	
	/**
	 * 更新库存表，将店铺的菜品库存按时间类型清零
	 * @param timeType
	 * @param classId 菜品或午餐的分类Id
	 */
	void updateMealInventoryZero(String timeType, Integer classId);
	
}