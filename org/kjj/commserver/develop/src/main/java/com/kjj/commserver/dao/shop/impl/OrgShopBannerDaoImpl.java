package com.kjj.commserver.dao.shop.impl;

import java.util.HashMap;
import java.util.Map;

import com.kjj.commserver.dao.shop.OrgShopBannerDao;
import com.kjj.commserver.entity.shop.OrgShopBanner;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgShopBannerDaoImpl extends BaseDaoImpl<OrgShopBanner, Integer> implements OrgShopBannerDao {
	
	private static final String SQL_ID_UPDATE_BY_OLD_PATH = "updateByOldPath";
	
	private static final String SQL_ID_UPDATE_URL_BY_IMG = "updateBannerUrlByImg";
	
	private static final String SQL_ID_DELETE_BANNER_BY_IMG = "deleteBannerByImg";
	
	private static final String SQL_ID_UPDATE_ORDER_BY_OLD_PATH = "updateOrderByOldPath";
	
	@Override
	public void updateBanner(String oldpath, String url, String newpath,String bannerOrder) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("oldpath", oldpath);
		t.put("newpath", newpath);
		t.put("url", url);
		t.put("bannerOrder", bannerOrder);
		sqlSession.update(getSqlName(SQL_ID_UPDATE_BY_OLD_PATH), t);
	}
	@Override
	public void updateBanner(String oldpath, String bannerOrder) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("oldpath", oldpath);
		t.put("bannerOrder", bannerOrder);
		sqlSession.update(getSqlName(SQL_ID_UPDATE_ORDER_BY_OLD_PATH), t);
	}

	@Override
	public void updateBannerUrlByImg(String imgPath, String url) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("oldpath", imgPath);
		t.put("url", url);
		sqlSession.update(getSqlName(SQL_ID_UPDATE_URL_BY_IMG), t);
	}

	@Override
	public void deleteBannerByImg(String imgPath) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("oldpath", imgPath);
		sqlSession.delete(getSqlName(SQL_ID_DELETE_BANNER_BY_IMG), t);
		
	}
}