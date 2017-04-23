package com.kjj.commserver.entity.user.aide;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kjj.commserver.entity.user.OrgUsers;

public class OrgUsersQuery extends OrgUsers {
	
	/** 登录用户   查询用户手机或者邮箱*/
	private String loginName;
	
	/** 注册开始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date regTimeStart;	
	
	/** 注册结束时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date regTimeEnd;
    
    /** 邮箱like */
    private String emailLike;
    
    /** 手机号like */
    private String mobileLike;
    
    /** 会员名称 */
    private String userNameLike;
    
    /** 用户ID或手机号或用户名称查询  */
    public Collection<String> listUserQuery;
    
    /** 用户关联企业的企业主键*/
    public Integer userEnterpriseId;
    
    /** 非企业用户*/
    public boolean noEnterprise;
    

	public boolean isNoEnterprise() {
		return noEnterprise;
	}

	public void setNoEnterprise(boolean noEnterprise) {
		this.noEnterprise = noEnterprise;
	}

	public Integer getUserEnterpriseId() {
		return userEnterpriseId;
	}

	public void setUserEnterpriseId(Integer userEnterpriseId) {
		this.userEnterpriseId = userEnterpriseId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getRegTimeStart() {
		return regTimeStart;
	}

	public void setRegTimeStart(Date regTimeStart) {
		this.regTimeStart = regTimeStart;
	}

	public Date getRegTimeEnd() {
		return regTimeEnd;
	}

	public void setRegTimeEnd(Date regTimeEnd) {
		this.regTimeEnd = regTimeEnd;
	}

	public String getEmailLike() {
		return emailLike;
	}

	public void setEmailLike(String emailLike) {
		this.emailLike = emailLike;
	}

	public String getMobileLike() {
		return mobileLike;
	}

	public void setMobileLike(String mobileLike) {
		this.mobileLike = mobileLike;
	}

	public String getUserNameLike() {
		return userNameLike;
	}

	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}

	public Collection<String> getListUserQuery() {
		return listUserQuery;
	}

	public void setListUserQuery(Collection<String> listUserQuery) {
		this.listUserQuery = listUserQuery;
	}


	
}