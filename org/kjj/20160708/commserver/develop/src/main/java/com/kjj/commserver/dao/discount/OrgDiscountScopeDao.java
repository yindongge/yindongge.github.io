package com.kjj.commserver.dao.discount;

import com.kjj.commserver.entity.discount.OrgDiscountScope;
import com.kjj.core.dao.BaseDao;

public interface OrgDiscountScopeDao extends BaseDao<OrgDiscountScope, Integer> {
	
	/**
	 * 查询相关适用终端范围信息
	 * @param typeId
	 * @param discountId
	 * @return
	 */
	String selectInfo(Byte typeId,Integer discountId);
	
}