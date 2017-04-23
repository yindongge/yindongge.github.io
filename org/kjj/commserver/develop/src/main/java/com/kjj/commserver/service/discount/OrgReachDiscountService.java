package com.kjj.commserver.service.discount;

import java.util.Map;

import com.kjj.commserver.entity.discount.OrgReachDiscount;
import com.kjj.core.service.BaseService;

public interface OrgReachDiscountService extends BaseService<OrgReachDiscount, Integer> {

	/**
	 * 根据优惠条件查询满减优惠
	 * @param rcId
	 * @return
	 */
	Map<Long, OrgReachDiscount> queryMapByRcId(Integer rcId);
	
	
}