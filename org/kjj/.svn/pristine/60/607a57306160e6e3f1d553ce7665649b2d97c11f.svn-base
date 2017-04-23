package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShopPageFloor;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorVo;
import com.kjj.core.service.BaseService;

public interface OrgShopPageFloorService extends BaseService<OrgShopPageFloor, Integer> {

	/***
	 * 查询店铺首页楼层显示
	 * @param pageId
	 * @return
	 */
	List<OrgShopPageFloor> queryActiveByPageId(Integer pageId);
	
	/**
	 * 通过pageId查询店铺首页楼层
	 * @param pageId
	 * @return
	 */
	List<OrgShopPageFloorVo> queryByPageIdAsc(Integer pageId);
	
	/**
	 * 删除店铺对应的楼层
	 * @param pageId
	 */
	void deleteFloorByPageId(Integer pageId);
}