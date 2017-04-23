package com.kjj.commserver.entity.account.aide;

import java.util.Date;

import com.kjj.commserver.entity.account.OrgAccountGroupUser;

public class OrgAccountGroupUserVo extends OrgAccountGroupUser {
	/** 会员资料自增id */
    private Integer userId;

    /** 会员邮箱 */
    private String email;

    /** 用户名 */
    private String userName;
    
    private Date regTime;
    
    /** 手机 */
    private String mobilePhone;
    
    /** 会员类型*/
    private Byte levelType;
    
    /** 0正常 1 锁定 */
    private Integer status;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Byte getLevelType() {
		return levelType;
	}

	public void setLevelType(Byte levelType) {
		this.levelType = levelType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
    

}