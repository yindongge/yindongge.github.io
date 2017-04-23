package com.kjj.commserver.entity.account.aide;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kjj.commserver.entity.account.OrgAccountGroup;

public class OrgAccountGroupQuery extends OrgAccountGroup {
	
	/** 查询时的用户组名*/
	private String groupNameLike; 
	
	/** 注册开始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeStart;
	
	/** 注册结束时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeEnd;

	public Date getCreateTimeStart() {
		return createTimeStart;
	}
	

	public String getGroupNameLike() {
		return groupNameLike;
	}


	public void setGroupNameLike(String groupNameLike) {
		this.groupNameLike = groupNameLike;
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