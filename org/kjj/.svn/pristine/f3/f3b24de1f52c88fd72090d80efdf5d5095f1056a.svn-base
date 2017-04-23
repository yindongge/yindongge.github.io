package com.kjj.commserver.dao.special.impl;

import com.kjj.commserver.dao.special.OrgSpecialLinkDao;
import com.kjj.commserver.entity.special.OrgSpecialLink;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class OrgSpecialLinkDaoImpl extends BaseDaoImpl<OrgSpecialLink, Integer> implements OrgSpecialLinkDao {

	private static final String SQL_SELECT_MAX_ORDER = "selectMaxOrder";
	
	@Override
	public Integer selectMaxOrder(Integer specialId) {
		Assert.notNull(specialId);
		try {
			return this.sqlSession.selectOne(getSqlName(SQL_SELECT_MAX_ORDER), specialId);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", getSqlName(SQL_SELECT_MAX_ORDER)), e);
		}
	}
}