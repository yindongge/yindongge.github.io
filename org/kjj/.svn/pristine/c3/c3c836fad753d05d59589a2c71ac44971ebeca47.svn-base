package com.kjj.commserver.service.system;

import com.kjj.commserver.entity.system.OrgAdminUser;
import com.kjj.commserver.entity.system.aide.OrgAdminUserForm;
import com.kjj.core.service.BaseService;

public interface OrgAdminUserService extends BaseService<OrgAdminUser, Short> {
	/**
	 * 根据email查询用户数量
	 * @param email
	 * @return
	 */
	long queryCountByEmail(String email);

	/**
	 * 根据手机号查询用户
	 * @param loginName
	 * @return
	 */
	OrgAdminUser queryByMobile(String mobile);
	
	/**
	 * 添加管理员
	 * @param orgAdminUserForm
	 */
	void add(OrgAdminUserForm orgAdminUserForm);
	
	/**
	 * 编辑管理员
	 * @param orgAdminUserForm
	 */
	void update(OrgAdminUserForm orgAdminUserForm);
}