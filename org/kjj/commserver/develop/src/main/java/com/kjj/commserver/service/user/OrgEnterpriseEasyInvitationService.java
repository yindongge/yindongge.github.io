package com.kjj.commserver.service.user;

import com.kjj.commserver.entity.user.OrgEnterpriseEasyInvitation;
import com.kjj.core.service.BaseService;

public interface OrgEnterpriseEasyInvitationService extends BaseService<OrgEnterpriseEasyInvitation, Integer> {
	/**
	 * 产生一个6位唯一的邀请码
	 * @return
	 */
	String createInvitationCode();
	
	/**
	 * 根据邀请码锁定对象
	 * @param code
	 * @return
	 */
	OrgEnterpriseEasyInvitation lockQueryByInvitationCode(String code);
}