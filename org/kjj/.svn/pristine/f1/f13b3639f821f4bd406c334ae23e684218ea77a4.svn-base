package com.kjj.commserver.service.system;

import java.util.List;

import com.kjj.commserver.entity.system.OrgAdminAuthority;
import com.kjj.core.service.BaseService;

public interface OrgAdminAuthorityService extends BaseService<OrgAdminAuthority, Integer> {

	/**
	 * 根据userid查询出菜单信息
	 * @param userid
	 * @return
	 */
	List<OrgAdminAuthority> queryByUserId(Integer userId);
	/**
	 * 
	 * @param modelIds
	 */
	void addInModelIds(String modelIds,Short userId);
	
	/**
	 * 根据菜单Id删除
	 * @param authorityid
	 */
	int deleteByAuthorityId(Integer authorityid);
	/**
	 * 根据用户Id删除
	 * @param userId
	 */
	int deleteByUserId(Short userId);
}