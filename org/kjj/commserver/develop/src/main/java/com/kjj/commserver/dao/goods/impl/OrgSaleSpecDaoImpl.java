package com.kjj.commserver.dao.goods.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.goods.OrgSaleSpecDao;
import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgSaleSpecDaoImpl extends BaseDaoImpl<OrgSaleSpec, Integer> implements OrgSaleSpecDao {
	public final static String SELECT_BY_TYPE_ID = "selectByTypeId";
	
	@Override
	public List<OrgSaleSpec> queryByProductTypeId(Integer typeId) {
		Assert.notNull(typeId);
		try {
			return this.sqlSession.selectList(getSqlName(SELECT_BY_TYPE_ID), typeId);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", getSqlName(SELECT_BY_TYPE_ID)), e);
		}
	}
	
}