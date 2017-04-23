package com.kjj.commserver.dao.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.shop.OrgShopPage;
import com.kjj.core.dao.BaseDao;

public interface OrgShopPageDao extends BaseDao<OrgShopPage, Integer> {
	/**
	 * 查询店铺首页的分页方法
	 */
	Page<OrgShopPage> queryPageList(OrgShopPage query,Pageable pageable);
	
}