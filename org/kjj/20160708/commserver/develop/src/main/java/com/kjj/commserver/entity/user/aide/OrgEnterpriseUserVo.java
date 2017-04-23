package com.kjj.commserver.entity.user.aide;

import com.kjj.commserver.entity.user.OrgEnterpriseUser;

public class OrgEnterpriseUserVo extends OrgEnterpriseUser {
	/** 用户名 */
    private String userName;
    
    /** 手机 */
    private String mobilePhone;
    
    /** 真实姓名 */
    private String realname;

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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
    
    
}