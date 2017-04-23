package com.kjj.commserver.dao.shop.impl;

import java.util.List;

import com.kjj.commserver.dao.shop.OrgTouchPageBannerDao;
import com.kjj.commserver.entity.shop.OrgTouchPageBanner;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageBannerQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class OrgTouchPageBannerDaoImpl extends BaseDaoImpl<OrgTouchPageBanner, Integer> implements OrgTouchPageBannerDao {
	
	private static final String SELECT_MAX_ORDER = "selectMaxOrder";
	public static final String SQL_QUERY_BANNER_LIST="queryBannerList";
	@Override
	public Integer selectMaxOrder(Integer pageId) {
		Assert.notNull(pageId);
		try {
			return this.sqlSession.selectOne(getSqlName(SELECT_MAX_ORDER), pageId);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", getSqlName(SELECT_MAX_ORDER)), e);
		}
	}

	@Override
	public List<OrgTouchPageBanner> queryBannerList(OrgTouchPageBannerQuery query) {
		return selectList(query,SQL_QUERY_BANNER_LIST);
	}
}