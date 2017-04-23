package com.kjj.commserver.dao.goods.impl;

import com.kjj.commserver.dao.goods.OrgProductTypeDao;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class OrgProductTypeDaoImpl extends BaseDaoImpl<OrgProductType, Integer> implements OrgProductTypeDao {
	public final static String OFF_SALE_LINKED_SPU_BY_PRODUCT_TYPE_ID = "offSaleLinkedSpuByProductTypeId";
	public final static String DELETE_LINKED_SKU_BY_PRODUCT_TYPE_ID = "offSaleLinkedSpuByProductTypeId";
	public final static String DELETE_SKU_LINKED_SALE_SPEC_BY_PRODUCT_TYPE_ID = "deleteSkuLinkedSaleSpecByProductTypeId";
	
	@Override
	public void offSaleLinkedSpuByProductTypeId(Integer typeId) {
		Assert.notNull(typeId);
		try {
			this.sqlSession.update(getSqlName(OFF_SALE_LINKED_SPU_BY_PRODUCT_TYPE_ID), typeId);
		} catch (Exception e) {
			throw new DaoException(String.format("下架关联此类型的spu！语句：%s", getSqlName(OFF_SALE_LINKED_SPU_BY_PRODUCT_TYPE_ID)), e);
		}
		
	}

	@Override
	public void deleteLinkedSkuByProductTypeId(Integer typeId) {
		Assert.notNull(typeId);
		try {
			this.sqlSession.update(getSqlName(DELETE_LINKED_SKU_BY_PRODUCT_TYPE_ID), typeId);
		} catch (Exception e) {
			throw new DaoException(String.format("逻辑删除关联此类型的sku！语句：%s", getSqlName(DELETE_LINKED_SKU_BY_PRODUCT_TYPE_ID)), e);
		}
		
	}

	@Override
	public void deleteSkuLinkedSaleSpecByProductTypeId(Integer typeId) {
		Assert.notNull(typeId);
		try {
			this.sqlSession.update(getSqlName(DELETE_SKU_LINKED_SALE_SPEC_BY_PRODUCT_TYPE_ID), typeId);
		} catch (Exception e) {
			throw new DaoException(String.format("删除此类型下sku关联的销售规格！语句：%s", getSqlName(DELETE_SKU_LINKED_SALE_SPEC_BY_PRODUCT_TYPE_ID)), e);
		}
		
	}
}