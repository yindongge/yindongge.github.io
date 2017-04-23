package com.kjj.commserver.dao.shop.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.shop.OrgMobilePageCustomizeDao;
import com.kjj.commserver.entity.shop.OrgMobilePageCustomize;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageCustomizeQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;
import com.kjj.core.util.BeanUtils;

@Repository
public class OrgMobilePageCustomizeDaoImpl extends BaseDaoImpl<OrgMobilePageCustomize, Integer> implements OrgMobilePageCustomizeDao {
	
	public static final String SQL_SELECT_BLOB = "selectBlob";
	
	public static final String SQL_SELECT_FOR_ONE = "selectForOne";
	
	@Override
	public OrgMobilePageCustomize queryOnlyOne(OrgMobilePageCustomizeQuery query) {
		Assert.notNull(query);
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.sqlSession.selectOne(SQL_SELECT_BLOB, params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询一条记录出错！语句：%s", SQL_SELECT_BLOB), e);
		}
	}

	@Override
	public OrgMobilePageCustomize queryForOne(OrgMobilePageCustomizeQuery query) {
		Assert.notNull(query);
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.sqlSession.selectOne(SQL_SELECT_FOR_ONE, params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询一条记录出错！语句：%s", SQL_SELECT_BLOB), e);
		}
	}
}