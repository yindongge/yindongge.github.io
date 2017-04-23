package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShopBanner;
import com.kjj.core.service.BaseService;

public interface OrgShopBannerService extends BaseService<OrgShopBanner, Integer> {

	/**
	 * 查询店铺首页轮播图
	 * @param pageId
	 * @return
	 */
	List<OrgShopBanner> queryByPageId(Integer pageId);
	
	/**
	 * 通过原来的图片路径来更新记录
	 * @param oldpath
	 * @param url
	 * @param newpath
	 */
	void updateBanner(String oldpath,String url,String newpath,String bannerOrder);
	
	/**
	 * 
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