package com.kjj.commserver.dao.shop.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.shop.OrgMobilePageBannerDao;
import com.kjj.commserver.entity.shop.OrgMobilePageBanner;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageBannerQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgMobilePageBannerDaoImpl extends BaseDaoImpl<OrgMobilePageBanner, Integer> implements OrgMobilePageBannerDao {
	
	public static final String SQL_UPDATE_ID_USE_NEWID="updateIdUseNewId";
	public static final String SQL_QUERY_BANNER_LIST="queryBannerList";
	
	@Override
	public int updateId(OrgMobilePageBanner orgClickBanner) {
		Assert.notNull(orgClickBanner);
		try {
			return this.sqlSession.update(SQL_UPDATE_ID_USE_NEWID, orgClickBanner);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象某些属性出错！语句：%s", SQL_UPDATE_ID_USE_NEWID),
					e);
		}
		
	}

	@Override
	public List<OrgMobilePageBanner> queryBannerList(OrgMobilePageBannerQuery query) {
		return selectList(query,SQL_QUERY_BANNER_LIST);
	}

	
}