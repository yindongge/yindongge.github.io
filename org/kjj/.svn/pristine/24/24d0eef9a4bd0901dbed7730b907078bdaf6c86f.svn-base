package com.kjj.commserver.service.user;

import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.core.service.BaseService;

public interface OrgUserActiveService extends BaseService<OrgUserActive, Integer> {

	/**
	 * 查询用户注册验证码
	 * @param mobilePhone
	 * @return
	 */
	OrgUserActive queryLastByMobilePhone(String mobilePhone);
	
	/**
	 * 发送手机注册验证码,并发送短息
	 * @param mobilePhone
	 */
	void addRegisterCodeByMobilePhone(String mobilePhone);
	
	/**
	 * 发送邮件验证码，并发送邮件
	 * @param email
	 * @param orgUsersName
	 */
	void addBindCodeByEmai(String email,String orgUsersName);
}