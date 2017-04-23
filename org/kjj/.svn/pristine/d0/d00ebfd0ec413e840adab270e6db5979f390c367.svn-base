package com.kjj.commserver.entity.account.aide;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kjj.commserver.entity.account.OrgAccountDepositRecords;

public class OrgAccountDepositRecordsQuery extends OrgAccountDepositRecords {
	/** 会员名*/
	private String userName;
	
	/** 注册开始时间*/ 
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeStart;
	
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