package com.kjj.commserver.dao.goods.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.goods.OrgBrandDao;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgBrandDaoImpl extends BaseDaoImpl<OrgBrand, Integer> implements OrgBrandDao {
	private final static String SELECT_SKU_NUM_BY_BRAND_ID = "selectSkuNumByBrandId";
	
	@Override
	public Map<Integer, Map<String, Object>> selectSkuNumByBrandId(
			Collection<Integer> brandIds) {
		Assert.notNull(brandIds);
		try {
			Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("brandIds", brandIds);
			return this.sqlSession.selectMap(SELECT_SKU_NUM_BY_BRAND_ID, parameter, "brandId");
		} catch (Exception e) {
			throw new DaoException(String.format("根据品牌id集合获取各品牌下的sku数量出错！语句：%s", getSqlName(SELECT_SKU_NUM_BY_BRAND_ID)), e);
		}
	}
}