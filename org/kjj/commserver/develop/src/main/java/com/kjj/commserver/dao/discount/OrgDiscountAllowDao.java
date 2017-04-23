package com.kjj.commserver.dao.discount;

import com.kjj.commserver.entity.discount.OrgDiscountAllow;
import com.kjj.core.dao.BaseDao;

public interface OrgDiscountAllowDao extends BaseDao<OrgDiscountAllow, Integer> {
	
	/**
	 * 查询允许同时优惠信息
	 * @param typeId
	 * @param discountId
	 * @return
	 */
	String selectInfo(Byte typeId,Integer discountId);
}