package com.kjj.commserver.dao.goods.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.goods.OrgClassDao;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgClassQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgClassDaoImpl extends BaseDaoImpl<OrgClass, Integer> implements OrgClassDao {
	
	public static final String SELECT_BY_BRAND_ID = "selectByBrandId";
	public final static String OFF_SALE_LINKED_SPU_BY_CLASS_ID = "offSaleLinkedSpuByClassId";
	public final static String DELETE_LINKED_SKU_BY_CLASS_ID = "deleteLinkedSkuByClassId";
	public final static String DELETE_SKU_LINKED_SALE_SPEC_BY_CLASS_ID = "deleteSkuLinkedSaleSpecByClassId";
	public final static String OFF_SALE_LINKED_SPU_BY_CLASS_ID_2 = "offSaleLinkedSpuByClassId2";
	public final static String SELECT_SKU_NUM_BY_CLASS_ID = "selectSkuNumByClassId";

	@Override
	public List<OrgClass> queryByBrandId(Integer brandId) {
		OrgClassQuery query = new OrgClassQuery();
		query.setBrandId(brandId);
		return selectList(query, SELECT_BY_BRAND_ID);
	}

	@Override
	public void offSaleLinkedSpuByClassIds(Collection<Integer> classIds) {
		Assert.notNull(classIds);
		try {
			Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("classIds", classIds);
			this.sqlSession.update(getSqlName(OFF_SALE_LINKED_SPU_BY_CLASS_ID), parameter);
		} catch (Exception e) {
			throw new DaoException(String.format("下架分类集合下的spu！语句：%s", getSqlName(OFF_SALE_LINKED_SPU_BY_CLASS_ID)), e);
		}
	}

	@Override
	public void deleteLinkedSkuByClassIds(Collection<Integer> classIds) {
		Assert.notNull(classIds);
		try {
			Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("classIds", classIds);
			this.sqlSession.update(getSqlName(DELETE_LINKED_SKU_BY_CLASS_ID), parameter);
		} catch (Exception e) {
			throw new DaoException(String.format("逻辑删除分类集合下的sku！语句：%s", getSqlName(DELETE_LINKED_SKU_BY_CLASS_ID)), e);
		}
	}

	@Override
	public void deleteSkuLinkedSaleSpecByClassIds(Collection<Integer> classIds) {
		Assert.notNull(classIds);
		try {
			Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("classIds", classIds);
			this.sqlSession.update(getSqlName(DELETE_SKU_LINKED_SALE_SPEC_BY_CLASS_ID), parameter);
		} catch (Exception e) {
			throw new DaoException(String.format("删除分类集合下的sku关联的销售规格！语句：%s", getSqlName(DELETE_SKU_LINKED_SALE_SPEC_BY_CLASS_ID)), e);
		}		
	}

	@Override
	public void offSaleLinkedSpuByClassIds2(Collection<Integer> classIds) {
		Assert.notNull(classIds);
		try {
			Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("classIds", classIds);
			this.sqlSession.update(getSqlName(OFF_SALE_LINKED_SPU_BY_CLASS_ID_2), parameter);
		} catch (Exception e) {
			throw new DaoException(String.format("下架分类集合下的spu,并解除与分类的关联！语句：%s", getSqlName(OFF_SALE_LINKED_SPU_BY_CLASS_ID_2)), e);
		}
		
	}

	@Override
	public Map<Integer, Map<String, Object>> selectSkuNumByClassId() {
		try {
			return this.sqlSession.selectMap(SELECT_SKU_NUM_BY_CLASS_ID, "classId");
		} catch (Exception e) {
			throw new DaoException(String.format("统计所有商品分类下的sku数量！语句：%s", getSqlName(SELECT_SKU_NUM_BY_CLASS_ID)), e);
		}
	}
}