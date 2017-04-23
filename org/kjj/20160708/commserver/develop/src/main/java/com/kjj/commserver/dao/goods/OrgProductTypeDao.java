package com.kjj.commserver.dao.goods;

import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.core.dao.BaseDao;

public interface OrgProductTypeDao extends BaseDao<OrgProductType, Integer> {
	/**
	 * 下架关联此类型的spu
	 * @param typeId 类型id
	 */
	void offSaleLinkedSpuByProductTypeId(Integer typeId);
	/**
	 * 逻辑删除关联此类型的sku
	 * @param typeId 类型id
	 */
	void deleteLinkedSkuByProductTypeId(Integer typeId);
	/**
	 * 删除此类型下sku关联的销售规格
	 * @param typeId 类型id
	 */
	void deleteSkuLinkedSaleSpecByProductTypeId(Integer typeId);
}