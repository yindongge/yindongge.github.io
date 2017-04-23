package com.kjj.commserver.entity.user.aide;

import com.kjj.commserver.entity.user.OrgEnterprise;

public class OrgEnterpriseForm extends OrgEnterprise  {
	/** 用户名 */
    private String userName;

    /** 用户密码 */
    private String password;
    
    /** 确认密码*/
    private String repassword;
    
    /** 短信验证码*/
    private String verifycode;
    
    /** 验证码*/
    private String identifyCode;
    
    
	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getIdentifyCode() {
		return identifyCode;
	}

	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
