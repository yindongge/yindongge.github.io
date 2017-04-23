package com.kjj.commserver.dao.goods;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.core.dao.BaseDao;

public interface OrgClassDao extends BaseDao<OrgClass, Integer> {
	
	List<OrgClass> queryByBrandId(Integer brandId);
	
	/**
	 * 下架分类集合下的spu
	 * @param classIds 分类id集合
	 */
	void offSaleLinkedSpuByClassIds(Collection<Integer> classIds);
	/**
	 * 逻辑删除分类集合下的sku
	 * @param classIds 分类id集合
	 */
	void deleteLinkedSkuByClassIds(Collection<Integer> classIds);
	/**
	 * 删除分类集合下的sku关联的销售规格
	 * @param classIds 分类id集合
	 */
	void deleteSkuLinkedSaleSpecByClassIds(Collection<Integer> classIds);
	/**
	 * 下架分类集合下的spu,并解除与分类的关联
	 * @param classIds 分类id集合
	 */
	void offSaleLinkedSpuByClassIds2(Collection<Integer> classIds);
	
	/**
	 * 统计所有商品分类下的sku数量
	 */
	Map<Integer, Map<String, Object>> selectSkuNumByClassId();
}