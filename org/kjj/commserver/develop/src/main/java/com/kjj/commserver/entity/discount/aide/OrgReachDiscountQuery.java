package com.kjj.commserver.entity.discount.aide;

import com.kjj.commserver.entity.discount.OrgReachDiscount;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;

public class OrgReachDiscountQuery extends OrgReachDiscount {
	
	/** 查询锁定  */
	private Boolean query4User = false;
	
	/** 用户 */
	private OrgUsersSession orgUsersSession;
	
	/** 状态 */
	private Byte status;

	public OrgUsersSession getOrgUsersSession() {
		return orgUsersSession;
	}

	public void setOrgUsersSession(OrgUsersSession orgUsersSession) {
		this.orgUsersSession = orgUsersSession;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Boolean getQuery4User() {
		return query4User;
	}

	public void setQuery4User(Boolean query4User) {
		this.query4User = query4User;
	}
	
}