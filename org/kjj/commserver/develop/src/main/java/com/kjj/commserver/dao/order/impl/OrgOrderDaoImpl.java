package com.kjj.commserver.dao.order.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.order.OrgOrderDao;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderUserCount;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgOrderDaoImpl extends BaseDaoImpl<OrgOrder, Integer> implements OrgOrderDao {
	
	private static final String SQL_ID_SELECT_4UPDATE = "selectByPrimaryKey4Update";
	
	private static final String SQL_ID_SELECT_USER_COUNT = "selectUserCount";

	@Override
	public OrgOrder selectById4Update(Integer id) {
		return selectById(id,SQL_ID_SELECT_4UPDATE);
	}

	@Override
	public OrgOrderUserCount selectUserCount(Integer userId) {
		Assert.notNull(userId);
		try {
			return this.sqlSession.selectOne(getSqlName(SQL_ID_SELECT_USER_COUNT), userId);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", getSqlName(SQL_ID_SELECT_USER_COUNT)), e);
		}
	}
}