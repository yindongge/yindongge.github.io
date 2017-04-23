package com.kjj.commserver.entity.account.aide;

import java.util.Collection;

import com.kjj.commserver.entity.account.OrgAccountGroupUser;

public class OrgAccountGroupUserQuery extends OrgAccountGroupUser {
	/** 用户名 */
	private String userName;
	
	/** 手机号 */
	private String mobilePhone;
	
	/** 要删除的用户Id */
	private Collection<Integer> userIds;

	public Collection<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(Collection<Integer> userIds) {
		this.userIds = userIds;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	
}