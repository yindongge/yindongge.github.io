package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgMobilePageBanner;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageBannerQuery;
import com.kjj.core.service.BaseService;

public interface OrgMobilePageBannerService extends BaseService<OrgMobilePageBanner, Integer> {
	
	/**
	 * 查询移动店铺首页轮播图
	 * @param pageId
	 * @return
	 */
	List<OrgMobilePageBanner> queryByPageId(Integer pageId);
	
	/**
	 * 修改id字段,此方法用作轮播图排序操作
	 */
	int updateId(OrgMobilePageBanner orgClickBanner);
	
	/**
	 * 根据query对象查询移动店铺首页轮播图
	 * @param query
	 * @param sort
	 * @return
	 */
	List<OrgMobilePageBanner> queryBannerList(OrgMobilePageBannerQuery query);
	
	/**
	 * 增加轮播图
	 */
	void addBanner(OrgMobilePageBanner orgMobilePageBanner);
	
	/**
	 * 通过id来更新轮播图
	 */
	void updateBannerByIdSelective(OrgMobilePageBanner orgMobilePageBanner);
	
	/**
	 * 通过id删除轮播图
	 */
	void deleteBannerById(Integer id);
}