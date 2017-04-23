package com.kjj.commserver.dao.shop.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.shop.OrgShopDao;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgShopDaoImpl extends BaseDaoImpl<OrgShop, Integer> implements OrgShopDao {
	
	public static final String SQL_ID_VIEW = "selectView";
	public static final String SQL_ID_COUNT_VIEW = "selectCountView";
	

	@Override
	public Page<OrgShop> selectPageListView(OrgShop query,Pageable pageable) {
		List<OrgShop> contentList = sqlSession.selectList(getSqlName(SQL_ID_VIEW),getParams(query, pageable));
		return new PageImpl<OrgShop>(contentList, pageable, selectCountView(query));
	}
	
	private long selectCountView(OrgShop query) {
		return selectCount(query,SQL_ID_COUNT_VIEW);
	}

	@Override
	public OrgShop selectViewVoById(Integer shopId) {
		return  selectById(shopId, "selectViewVoById");
	}
}