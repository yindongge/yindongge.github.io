package com.kjj.commserver.dao.shop.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.shop.OrgTouchPageDao;
import com.kjj.commserver.entity.shop.OrgTouchPage;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.util.BeanUtils;

@Repository
public class OrgTouchPageDaoImpl extends BaseDaoImpl<OrgTouchPage, Integer> implements OrgTouchPageDao {
	
	private static final String SQL_ID_SELECT_PAGE_LIST="selectPageList";
	
	private static final String SQL_ID_SELECT_PAGE_LIST_COUNT="selectPageListCount";
	
	private static final String SQL_SELECT_BY_AREACODE_SHOPID="selectByAreaCodeShopId";
	
	private long selectCountComment(OrgTouchPage query,String sqlId){
		return selectCount(query,sqlId);
	}
	
	@Override
	public Page<OrgTouchPage> queryPageList(OrgTouchPage query, Pageable pageable) {
		List<OrgTouchPage> contentList = sqlSession.selectList(getSqlName(SQL_ID_SELECT_PAGE_LIST), getParams(query, pageable));
		return new PageImpl<OrgTouchPage>(contentList,pageable,selectCountComment(query, SQL_ID_SELECT_PAGE_LIST_COUNT));
	}

	@Override
	public OrgTouchPage queryByAreaCodeShopId(OrgTouchPageQuery query) {
		Assert.notNull(query);
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.sqlSession.selectOne(SQL_SELECT_BY_AREACODE_SHOPID, params);
	}
}