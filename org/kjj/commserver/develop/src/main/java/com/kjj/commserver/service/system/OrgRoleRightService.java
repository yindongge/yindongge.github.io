package com.kjj.commserver.service.system;

import java.util.List;

import com.kjj.commserver.entity.system.OrgRoleRight;
import com.kjj.core.service.BaseService;

public interface OrgRoleRightService extends BaseService<OrgRoleRight, Integer> {

	/**
	 * 根据roleId获取菜单
	 * @param roleid
	 * @return
	 */
	List<OrgRoleRight> queryByRoleId(Integer roleid);
	
	/**
	 * 根据roleId添加
	 * @param roleId
	 * @param modelIds
	 */
	void addByRoleId(Integer roleId, String modelIds);
	
	/**
	 * 根据roleId删除
	 * @param roleId
	 */
	int deleteByRoleId(Integer roleId);
	
	/**
	 * 根据modelId删除
	 * @param roleId
	 */
	int deleteByModelId(Integer modelId);
}