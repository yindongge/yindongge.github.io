package com.kjj.commserver.service.discount;

import java.util.Collection;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgDiscountScope;
import com.kjj.core.service.BaseService;

public interface OrgDiscountScopeService extends BaseService<OrgDiscountScope, Integer> {

	/**
	 * 添加适用终端范围
	 * @param typeId
	 * @param discountId
	 * @param listScope
	 */
	void addByDiscount(Byte typeId, Integer discountId, Collection<Byte> listScope);
	/**
	 * 查询适用终端范围(scope为key)
	 * @param orgDiscountScope
	 * @return
	 */
	Map<Byte, OrgDiscountScope> queryMapKeyScope(OrgDiscountScope orgDiscountScope);
	/**
	 * 修改适用终端范围
	 * @param typeId
	 * @param discountId
	 * @param listScope
	 */
	void updateByDiscount(Byte typeId, Integer discountId, Collection<Byte> listScope);
	/**
	 * 查询相关适用终端范围信息
	 * @param typeId
	 * @param discountId
	 * @return
	 */
	String queryInfo(Byte typeId,Integer discountId);
}