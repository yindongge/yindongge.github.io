package com.kjj.commserver.dao.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.core.dao.BaseDao;

public interface OrgShopDao extends BaseDao<OrgShop, Integer> {
	
	/**
	 * 查询分页店铺展示信息
	 * @param query
	 * @param pageable
	 * @return
	 */
	public Page<OrgShop> selectPageListView(OrgShop query,Pageable pageable);
	/**
	 * 根据Id查询店铺展示信息
	 * @param id
	 * @return
	 */
	OrgShop selectViewVoById(Integer shopId);
}