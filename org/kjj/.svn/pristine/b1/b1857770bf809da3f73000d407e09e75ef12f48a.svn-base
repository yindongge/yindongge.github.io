package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgTouchPageBanner;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageBannerQuery;
import com.kjj.core.service.BaseService;

public interface OrgTouchPageBannerService extends BaseService<OrgTouchPageBanner, Integer> {
	
	/**
	 * 查询触摸屏店铺首页轮播图
	 * @param pageId
	 * @return
	 */
	List<OrgTouchPageBanner> queryByPageId(Integer pageId);
	/**
	 * 查询同一首页下的轮播图排序号最大值
	 * @param pageId
	 * @return
	 */
	Integer selectMaxOrder(Integer pageId);
	/**
	 * 保存轮播图
	 * @param orgTouchPageBanner
	 */
	void save(OrgTouchPageBanner orgTouchPageBanner);
	/**
	 * 根据query对象查询触摸屏店铺首页轮播图
	 * @param query
	 * @param sort
	 * @return
	 */
	List<OrgTouchPageBanner> queryBannerList(OrgTouchPageBannerQuery query);
}