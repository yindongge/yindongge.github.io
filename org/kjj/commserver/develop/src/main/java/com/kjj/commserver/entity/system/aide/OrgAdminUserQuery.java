package com.kjj.commserver.entity.system.aide;

import com.kjj.commserver.entity.system.OrgAdminUser;

public class OrgAdminUserQuery extends OrgAdminUser {
	
	/** 用户名*/
	private String userNameLike;
	
	/** 手机号码 */
	private String mobileLike;

	public String getUserNameLike() {
		return userNameLike;
	}

	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}

	public String getMobileLike() {
		return mobileLike;
	}

	public void setMobileLike(String mobileLike) {
		this.mobileLike = mobileLike;
	}
	
	
	
}