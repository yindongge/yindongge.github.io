package com.kjj.commserver.service.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.shop.OrgTouchPage;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageQuery;
import com.kjj.core.service.BaseService;

public interface OrgTouchPageService extends BaseService<OrgTouchPage, Integer> {
	/**
	 * 查询触摸屏店铺首页的分页方法
	 */
	Page<OrgTouchPage> queryPageList(OrgTouchPage query,Pageable pageable);

	/**
	 * 增加触摸屏店铺首页
	 */
	void addTouchPage(OrgTouchPage orgTouchPage);

	/**
	 * 删除店铺首页byId 
	 */
	void deleteTouchPageById(Integer id);
	
	/**
	 * 更新触摸屏店铺首页byId
	 */
	void updateTouchPageByIdSelective(OrgTouchPage orgTouchPage);
	/**
	 * 查询店铺首页通过区划码或者shopId方法
	 */
	OrgTouchPage queryByAreaCodeShopId(OrgTouchPageQuery query);
}