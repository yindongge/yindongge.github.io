package com.kjj.commserver.service.system;

import com.kjj.commserver.entity.system.OrgAdminRole;
import com.kjj.core.service.BaseService;

public interface OrgAdminRoleService extends BaseService<OrgAdminRole, Integer> {
	
	/**
	 * 添加角色
	 * @param orgAdminRole
	 * @param modelIds
	 */
	void add(OrgAdminRole orgAdminRole, String modelIds);

	/**
	 * 编辑角色
	 * @param orgAdminRole
	 * @param modelIds
	 */
	void update(OrgAdminRole orgAdminRole, String modelIds);
}