package com.kjj.commserver.entity.user.aide;

import com.kjj.commserver.entity.user.OrgEnterpriseInvitation;

public class OrgEnterpriseInvitationQuery extends OrgEnterpriseInvitation {
	
	/** 查询锁定  */
	private Boolean select4Update = false;

	public Boolean getSelect4Update() {
		return select4Update;
	}

	public void setSelect4Update(Boolean select4Update) {
		this.select4Update = select4Update;
	}
	
}