package com.kjj.commserver.service.user;

import com.kjj.commserver.entity.user.OrgEnterpriseInvitation;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.core.service.BaseService;

public interface OrgEnterpriseInvitationService extends BaseService<OrgEnterpriseInvitation, Integer> {
	/**
	 * 批量增加邀请码
	 * @param enterpriseId
	 */
	void addInvitationOfEnterprise(Integer enterpriseId);
	
	/**
	 * 个人用户使用邀请码
	 * @param invitation
	 * @param users
	 */
	boolean updateInvitation(String invitationCode, OrgUsers users);
}