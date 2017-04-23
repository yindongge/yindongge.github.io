package com.kjj.commserver.entity.discount.aide;

import java.util.Collection;

import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;

public class OrgCouponRecordQuery extends OrgCouponRecord {
	
	/** 用户 */
	private OrgUsersSession orgUsersSession;
	
	/** 查询锁定  */
	private Boolean query4User = false;
	
	/** select for update */
	private Boolean select4Update = false;
	
	/** 多张优惠券 */
	private Collection<Integer> recordIds;
	
	/** 状态 true:可用 false:不可用 */
	private Boolean statusCanUse;
	
	/** 会员名称 */
	private String userNameLike;
	
	/** 优惠卷名称 */
	private String couponNameLike;
	
	/** 返回一个 */
	private Boolean LimitOne;
	
	public OrgUsersSession getOrgUsersSession() {
		return orgUsersSession;
	}

	public void setOrgUsersSession(OrgUsersSession orgUsersSession) {
		this.orgUsersSession = orgUsersSession;
	}

	public Boolean getQuery4User() {
		return query4User;
	}

	public void setQuery4User(Boolean query4User) {
		this.query4User = query4User;
	}

	public Boolean getSelect4Update() {
		return select4Update;
	}

	public void setSelect4Update(Boolean select4Update) {
		this.select4Update = select4Update;
	}

	public Collection<Integer> getRecordIds() {
		return recordIds;
	}

	public void setRecordIds(Collection<Integer> recordIds) {
		this.recordIds = recordIds;
	}

	public Boolean getStatusCanUse() {
		return statusCanUse;
	}

	public void setStatusCanUse(Boolean statusCanUse) {
		this.statusCanUse = statusCanUse;
	}

	public String getUserNameLike() {
		return userNameLike;
	}

	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}

	public String getCouponNameLike() {
		return couponNameLike;
	}

	public void setCouponNameLike(String couponNameLike) {
		this.couponNameLike = couponNameLike;
	}

	public Boolean getLimitOne() {
		return LimitOne;
	}

	public void setLimitOne(Boolean limitOne) {
		LimitOne = limitOne;
	}

}