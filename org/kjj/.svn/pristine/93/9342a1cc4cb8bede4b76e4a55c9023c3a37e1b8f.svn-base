package com.kjj.commserver.dao.shop.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.shop.OrgMobilePageModuleDao;
import com.kjj.commserver.entity.shop.OrgMobilePageModule;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageModuleQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgMobilePageModuleDaoImpl extends BaseDaoImpl<OrgMobilePageModule, Integer> implements OrgMobilePageModuleDao {
	
	public static final String SQL_SELECT_MAX = "selectMax";
	public static final String SQL_QUERY_MODULE_LIST="queryModuleList";
	@Override
	public Long queryMaxOrder() {
		try {
			return this.sqlSession.selectOne(SQL_SELECT_MAX);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象总数出错！语句：%s", SQL_SELECT_MAX), e);
		}
	}

	@Override
	public List<OrgMobilePageModule> queryModuleList(OrgMobilePageModuleQuery moduleQuery) {
		return selectList(moduleQuery,SQL_QUERY_MODULE_LIST);
	}
}