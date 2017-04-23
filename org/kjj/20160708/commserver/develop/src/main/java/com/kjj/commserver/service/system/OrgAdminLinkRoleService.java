package com.kjj.commserver.service.system;

import java.util.List;

import com.kjj.commserver.entity.system.OrgAdminLinkRole;
import com.kjj.core.service.BaseService;

public interface OrgAdminLinkRoleService extends BaseService<OrgAdminLinkRole, Integer> {
	/**
	 * 根据userId获取所有角色
	 * @param userId
	 * @return
	 */
	List<OrgAdminLinkRole> queryByUserId(Integer userId);
	/**
	 * 根据用户id添加角色
	 * @param roleIds
	 * @param userId
	 */
	void addInRoleIds(String roleIds, Short userId);
	
	/**
	 * 根据用户ID删除
	 * @param userId
	 * @return
	 */
	int deleteByUserId(Short userId);
	/**
	 * 根据角色ID删除
	 * @param userId
	 * @return
	 */
	int deleteByRoleId(Integer roleId);
}