package com.kjj.commserver.dao.shop.impl;

import java.util.HashMap;
import java.util.Map;

import com.kjj.commserver.dao.shop.OrgShopRecommandDao;
import com.kjj.commserver.entity.shop.OrgShopRecommand;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgShopRecommandDaoImpl extends BaseDaoImpl<OrgShopRecommand, Integer> implements OrgShopRecommandDao {

	private static final String SQL_ID_UPDATE_BY_IMG1 = "updateByImg1";
	
	private static final String SQL_ID_UPDATE_BY_IMG2 = "updateByImg2";
	
	private static final String SQL_ID_UPDATE_URL_BY_IMG1 = "updateUrlByImg1";
	
	private static final String SQL_ID_DELETE_RECOMMAND_BY_IMG1 = "deleteRecommandByImg1";
	
	@Override
	public void updateRecommandImg1(String oldPath, String newPath, String url) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("oldpath", oldPath);
		t.put("newpath", newPath);
		t.put("url", url);
		sqlSession.update(getSqlName(SQL_ID_UPDATE_BY_IMG1), t);
	}

	@Override
	public void updateRecommandImg2(String oldPath, String newPath, String url) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("oldpath", oldPath);
		t.put("newpath", newPath);
		t.put("url", url);
		sqlSession.update(getSqlName(SQL_ID_UPDATE_BY_IMG2), t);
	}

	@Override
	public void updateUrlByImg1(String imgPath1, String url) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("oldpath", imgPath1);
		t.put("url", url);
		sqlSession.update(getSqlName(SQL_ID_UPDATE_URL_BY_IMG1), t);
	}

	@Override
	public void deleteRecommandByImg1(String imgPath1) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("oldpath", imgPath1);
		sqlSession.delete(getSqlName(SQL_ID_DELETE_RECOMMAND_BY_IMG1), t);
		
	}
}