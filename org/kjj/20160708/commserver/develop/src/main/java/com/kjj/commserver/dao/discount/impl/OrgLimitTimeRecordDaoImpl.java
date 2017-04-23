package com.kjj.commserver.dao.discount.impl;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.discount.OrgLimitTimeRecordDao;
import com.kjj.commserver.entity.discount.OrgLimitTimeRecord;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgLimitTimeRecordDaoImpl extends BaseDaoImpl<OrgLimitTimeRecord, Integer> implements OrgLimitTimeRecordDao {
	
	private static final String SQL_ID_UPDATE_LOCK_TABLES = "updateLockTables";
	
	private static final String SQL_ID_UPDATE_UNLOCK_TABLES = "updateUnlockTables";

	@Override
	public void lockTables() {
		try {
			super.sqlSession.update(getSqlName(SQL_ID_UPDATE_LOCK_TABLES));
		} catch (Exception e) {
			throw new DaoException(String.format("锁表出错！语句：%s", getSqlName(SQL_ID_UPDATE_LOCK_TABLES)), e);
		}
	}

	@Override
	public void unlockTables() {
		try {
			super.sqlSession.update(getSqlName(SQL_ID_UPDATE_UNLOCK_TABLES));
		} catch (Exception e) {
			throw new DaoException(String.format("解锁表出错！语句：%s", getSqlName(SQL_ID_UPDATE_UNLOCK_TABLES)), e);
		}
	}
}