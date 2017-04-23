package com.kjj.commserver.service.discount;

import java.util.Collection;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgDiscountProduct;
import com.kjj.core.service.BaseService;

public interface OrgDiscountProductService extends BaseService<OrgDiscountProduct, Integer> {

	/**
	 * 添加适用商品范围
	 * @param typeId
	 * @param discountId
	 * @param productType
	 * @param listClass
	 * @param listGoods
	 */
	void addByDiscount(Byte typeId, Integer discountId, Byte productType,Collection<Integer> listClass, Collection<Integer> listGoods);

	/**
	 * 修改适用商品范围
	 * @param typeId
	 * @param discountId
	 * @param productType
	 * @param listClass
	 * @param listGoods
	 */
	void updateByDiscount(Byte typeId, Integer discountId, Byte productType,Collection<Integer> listClass, Collection<Integer> listGoods);
	
	/**
	 * 获取适用商品范围(以classId为key)
	 * @param orgDiscountProduct
	 * @return
	 */
	Map<Integer, OrgDiscountProduct> queryMapKeyClassId(OrgDiscountProduct orgDiscountProduct);
	
}