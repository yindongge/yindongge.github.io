package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShopService;
import com.kjj.core.service.BaseService;

public interface OrgShopServiceService extends BaseService<OrgShopService, Short> {

	/** 获取所有店内服务信息 */
	List<OrgShopService> queryAll();

	/**
	 * 获取店铺服务列表
	 * @param shopId
	 * @return
	 */
	List<OrgShopService> queryListByShopId(Integer shopId);

	/**
	 * 获取店铺是否有外卖服务
	 * @param shopId
	 * @return
	 */
	boolean hasMealServiceByShopId(Integer shopId);
}