package com.kjj.commserver.dao.shop.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.shop.OrgMobilePageDao;
import com.kjj.commserver.entity.shop.OrgMobilePage;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;
import com.kjj.core.util.BeanUtils;

@Repository
public class OrgMobilePageDaoImpl extends BaseDaoImpl<OrgMobilePage, Integer> implements OrgMobilePageDao {

	private static final String SQL_ID_SELECT_PAGE_LIST="selectPageList";
	private static final String SQL_ID_SELECT_PAGE_LIST_COUNT="selectPageListCount";
	
	private static final String SQL_ID_SELECT_BY_AREACODE_SHOPID="selectPageByAreaCodeShopId";
	
	private long selectCountComment(OrgMobilePage query,String sqlId){
		return selectCount(query,sqlId);
	}
	
	@Override
	public Page<OrgMobilePage> queryPageList(OrgMobilePage query,Pageable pageable) {
		List<OrgMobilePage> contentList = sqlSession.selectList(getSqlName(SQL_ID_SELECT_PAGE_LIST), getParams(query, pageable));
		return new PageImpl<OrgMobilePage>(contentList,pageable,selectCountComment(query, SQL_ID_SELECT_PAGE_LIST_COUNT));
	}

	@Override
	public OrgMobilePage queryByAreaCodeShopId(OrgMobilePageQuery query) {
		Assert.notNull(query);
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.sqlSession.selectOne(SQL_ID_SELECT_BY_AREACODE_SHOPID, params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询一条记录出错！语句：%s", SQL_ID_SELECT_BY_AREACODE_SHOPID), e);
		}
	}
}