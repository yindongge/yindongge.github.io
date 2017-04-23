package com.kjj.commserver.dao.shop.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.shop.OrgShopPageDao;
import com.kjj.commserver.entity.shop.OrgShopPage;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgShopPageDaoImpl extends BaseDaoImpl<OrgShopPage, Integer> implements OrgShopPageDao {

	private static final String SQL_ID_SELECT_PAGE_LIST = "selectPageList";
	private static final String SQL_ID_SELECT_PAGE_LIST_COUNT = "selectPageListCount";
	
	private long selectCountComment(OrgShopPage query,String sqlId) {
		return selectCount(query, sqlId);
	}
	
	@Override
	public Page<OrgShopPage> queryPageList(OrgShopPage query, Pageable pageable) {
		
		List<OrgShopPage> contentList = sqlSession.selectList(getSqlName(SQL_ID_SELECT_PAGE_LIST),getParams(query, pageable));
		return new PageImpl<OrgShopPage>(contentList, pageable, selectCountComment(query, SQL_ID_SELECT_PAGE_LIST_COUNT));
	}

}