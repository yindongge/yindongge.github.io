package com.kjj.commserver.dao.shop;

import com.kjj.commserver.entity.shop.OrgShopRecommand;
import com.kjj.core.dao.BaseDao;

public interface OrgShopRecommandDao extends BaseDao<OrgShopRecommand, Integer> {
	/**
	 * 通过第一个旧图片路径修改原路径和链接
	 * @param oldPath
	 * @param newPath
	 * @param url
	 */
	void updateRecommandImg1(String oldPath, String newPath, String url);
	
	/**
	 * 通过第二个旧图片路径修改原路径
	 * @param oldPath
	 * @param newPath
	 */
	void updateRecommandImg2(String oldPath, String newPath, String url);
	
	/**
	 * 通过第一个图片路径来更新url地址
	 * @param imgPath1
	 * @param url
	 */
	void updateUrlByImg1(String imgPath1, String url);
	
	/**
	 * 通过第一个图片路径来删除
	 * @param imgPath1
	 */
	void deleteRecommandByImg1(String imgPath1);
}