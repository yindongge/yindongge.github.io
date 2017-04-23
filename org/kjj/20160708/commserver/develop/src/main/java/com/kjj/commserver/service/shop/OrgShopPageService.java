package com.kjj.commserver.service.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgShopPage;
import com.kjj.core.service.BaseService;

public interface OrgShopPageService extends BaseService<OrgShopPage, Integer> {

	/**
	 * 获取店铺展示页面
	 * @param shop
	 * @return
	 */
	OrgShopPage queryByShop(OrgShop orgShop);
	
	/**
	 * 获取店铺搜索
	 * @param orgShop
	 * @return
	 */
	String queryShopSearchByShop(OrgShop orgShop);
	
	/**
	 * 查询店铺首页的分页方法
	 */
	Page<OrgShopPage> queryPageList(OrgShopPage query,Pageable pageable);
	
	/**
	 * 删除店铺首页
	 * @param pageId
	 */
	void deletePage(Integer pageId);
	
}