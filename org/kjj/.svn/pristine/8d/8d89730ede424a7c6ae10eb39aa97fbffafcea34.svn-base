package com.kjj.commserver.dao.shop.impl;

import java.util.HashMap;

import com.kjj.commserver.dao.shop.OrgShopPageFloorDao;
import com.kjj.commserver.entity.shop.OrgShopPageFloor;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgShopPageFloorDaoImpl extends BaseDaoImpl<OrgShopPageFloor, Integer> implements OrgShopPageFloorDao {
	
	private static final String SQL_ID_DELETE_BY_PAGE_ID = "deleteByPageId";
	
	@Override
	public void deleteFloorByPageId(Integer pageId) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("pageId",pageId);
		sqlSession.update(getSqlName(SQL_ID_DELETE_BY_PAGE_ID), map);
	}
}