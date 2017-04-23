package com.kjj.commserver.dao.goods;

import java.util.Collection;
import java.util.Map;

import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.core.dao.BaseDao;

public interface OrgBrandDao extends BaseDao<OrgBrand, Integer> {
	/**
	 * 根据品牌id集合获取各品牌下的sku数量
	 * @param brandIds 品牌id集合
	 * @return
	 */
	Map<Integer, Map<String, Object>> selectSkuNumByBrandId(Collection<Integer> brandIds);
}