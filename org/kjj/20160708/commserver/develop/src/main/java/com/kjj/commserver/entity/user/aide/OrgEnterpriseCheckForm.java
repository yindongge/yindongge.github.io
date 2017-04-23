package com.kjj.commserver.entity.user.aide;

import com.kjj.commserver.entity.user.OrgEnterpriseCheck;

public class OrgEnterpriseCheckForm extends OrgEnterpriseCheck{
	/** 手机发送的短信内容 */
	private String message;
	
	/** 企业名称 */
	private String enterpriseName;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	
}
