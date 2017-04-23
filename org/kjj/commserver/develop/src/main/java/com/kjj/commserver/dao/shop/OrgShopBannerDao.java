package com.kjj.commserver.dao.shop;

import com.kjj.commserver.entity.shop.OrgShopBanner;
import com.kjj.core.dao.BaseDao;

public interface OrgShopBannerDao extends BaseDao<OrgShopBanner, Integer> {
	/**
	 * 通过原来的图片路径来更新记录
	 * @param oldpath
	 * @param url
	 * @param newpath
	 */
	void updateBanner(String oldpath,String url,String newpath,String bannerOrder);
	
	/**
	 * 通过原来的图片路径来更新记录
	 * @param oldpath
	 * @param bannerOrder
	 */
	void updateBanner(String oldpath,String bannerOrder);
	
	/**
	 * 通过原来的图片路径来更新url
	 * @param imgPath
	 * @param url
	 */
	void updateBannerUrlByImg(String imgPath, String url);
	
	/**
	 * 通过原来的图片路径删除banner
	 * @param imgPath
	 */
	void deleteBannerByImg(String imgPath);
}