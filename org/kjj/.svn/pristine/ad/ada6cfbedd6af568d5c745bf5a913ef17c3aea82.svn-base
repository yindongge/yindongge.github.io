package com.kjj.commserver.service.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.shop.OrgMobilePage;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageQuery;
import com.kjj.core.service.BaseService;

public interface OrgMobilePageService extends BaseService<OrgMobilePage, Integer> {
	/**
	 * 查询店铺首页的分页方法
	 */
	Page<OrgMobilePage> queryPageList(OrgMobilePage query,Pageable pageable);
	
	/**
	 * 查询店铺首页通过区划码或者shopId方法
	 */
	OrgMobilePage queryByAreaCodeShopId(OrgMobilePageQuery query);
	
	/**
	 * 增加移动店铺首页
	 */
	void addMobilePage(OrgMobilePage orgMobilePage);
	
	/**
	 * 删除移动店铺首页byId
	 */
	void deleteMobilePageById(Integer id);
	
	/**
	 * 更新移动店铺首页byId
	 */
	void updateMobilePageByIdSelective(OrgMobilePage orgMobilePage);
	
}