package com.kjj.commserver.entity.user.aide;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kjj.commserver.entity.user.OrgEnterprise;

public class OrgEnterpriseQuery extends OrgEnterprise {
	/** 用户名称 */
	private String userName;
	
	/** 公司名称查询条件 */
	private String enterpriseNameLike;
	
	/** 注册开始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeStart;
	
	public String getEnterpriseNameLike() {
		return enterpriseNameLike;
	}

	public void setEnterpriseNameLike(String enterpriseNameLike) {
		this.enterpriseNameLike = enterpriseNameLike;
	}

	/** 注册结束时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeEnd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
    
}