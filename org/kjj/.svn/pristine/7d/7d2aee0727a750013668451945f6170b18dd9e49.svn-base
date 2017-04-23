package com.kjj.commserver.dao.discount.impl;

import java.util.Date;

import com.kjj.commserver.dao.discount.OrgReachDao;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgReachDaoImpl extends BaseDaoImpl<OrgReach, Integer> implements OrgReachDao {

	public static final String DB_TIME="DBTime";
	
	@Override
	public Date getDbTime() {
		return sqlSession.selectOne(DB_TIME);
	}
}