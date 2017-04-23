package com.kjj.commserver.dao.goods.impl;

import java.util.List;

import com.kjj.commserver.dao.goods.OrgProductPropertyDao;
import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class OrgProductPropertyDaoImpl extends BaseDaoImpl<OrgProductProperty, Integer> implements OrgProductPropertyDao {

	public final static String SELECT_BY_TYPE_ID = "selectByTypeId";
	@Override
	public List<OrgProductProperty> queryByProductTypeId(Integer typeId) {
		Assert.notNull(typeId);
		try {
			return this.sqlSession.selectList(getSqlName(SELECT_BY_TYPE_ID), typeId);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", getSqlName(SELECT_BY_TYPE_ID)), e);
		}
	}
}