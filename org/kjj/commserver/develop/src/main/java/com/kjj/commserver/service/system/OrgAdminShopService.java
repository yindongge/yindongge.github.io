package com.kjj.commserver.service.system;

import java.util.Collection;
import java.util.List;

import com.kjj.commserver.entity.system.OrgAdminShop;
import com.kjj.core.service.BaseService;

public interface OrgAdminShopService extends BaseService<OrgAdminShop, Integer> {

	/**
	 * 查询管理员店铺权限
	 * @param userId
	 * @return
	 */
	Collection<Integer> queryShopIdsByUserId(int userId);
	/**
	 * 根据userId获取店铺信息
	 * @param userId
	 * @return
	 */
	List<OrgAdminShop> queryByUserId(Integer userId);
	/**
	 * 根据以后id添加店铺信息
	 * @param shopIds
	 * @param userId
	 */
	void addInShopIds(String shopIds, Short userId);
	/**
	 * 根据用户Id删除
	 * @param userId
	 */
	int deleteByShopId(Short userId);
}