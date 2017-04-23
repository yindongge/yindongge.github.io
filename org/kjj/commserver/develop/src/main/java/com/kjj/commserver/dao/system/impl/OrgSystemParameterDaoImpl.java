package com.kjj.commserver.dao.system.impl;

import com.kjj.commserver.dao.system.OrgSystemParameterDao;
import com.kjj.commserver.entity.system.OrgSystemParameter;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.dao.BaseSqlId;
import com.kjj.core.exception.DaoException;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class OrgSystemParameterDaoImpl extends BaseDaoImpl<OrgSystemParameter, Integer> implements OrgSystemParameterDao {
	
	private static final String SQL_ID_UPDATE_BY_NAME = "updateByName";

	@Override
	public int updateByName(OrgSystemParameter orgSystemParameter) {
		Assert.notNull(orgSystemParameter);
		try {
			return this.sqlSession.update(getSqlName(SQL_ID_UPDATE_BY_NAME), orgSystemParameter);
		} catch (Exception e) {
			throw new DaoException(String.format("更新对象出错！语句：%s", getSqlName(BaseSqlId.SQL_UPDATE_BY_ID)), e);
		}
	}
}