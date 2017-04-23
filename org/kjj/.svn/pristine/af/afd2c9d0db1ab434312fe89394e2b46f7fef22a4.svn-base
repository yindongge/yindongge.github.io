package com.kjj.commserver.service.user;

import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgEnterprise;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseCheckForm;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseForm;
import com.kjj.core.service.BaseService;

public interface OrgEnterpriseService extends BaseService<OrgEnterprise, Integer> {
	
	/**
	 * 重写新增方法
	 * @param enterprise
	 */
	void add(OrgEnterpriseForm enterprise, OrgUsers orgUsers);
	

	/**
	 * 根据用户ID查询企业
	 * @param userId
	 * @return
	 */
	OrgEnterprise queryByUserId(Integer userId);
	
	/**
	 * 删除企业用户
	 * @param enterprise
	 */
	void deleteEnterprise(OrgEnterprise enterprise);
	
	/**
	 * 审核企业用户
	 * @param admin
	 * @param enterpriseCheck
	 */
	void updateCheck(OrgAdminUserSession admin, OrgEnterpriseCheckForm enterpriseCheck);
	
	/**
	 * 锁定企业用户
	 * @param enterpriseId
	 */
	void lock(Integer enterpriseId);
	
	/**
	 * 解锁
	 * @param enterpriseId
	 */
	void updateDisLock(Integer enterpriseId);
}