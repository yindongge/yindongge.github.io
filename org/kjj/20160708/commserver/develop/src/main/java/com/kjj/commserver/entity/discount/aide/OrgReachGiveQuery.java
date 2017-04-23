package com.kjj.commserver.entity.discount.aide;

import java.util.Collection;

import com.kjj.commserver.entity.discount.OrgReachGive;

public class OrgReachGiveQuery extends OrgReachGive {
	
	/** 活动ID集合 */
	private Collection<Integer> rdIds = null;

	public Collection<Integer> getRdIds() {
		return rdIds;
	}

	public void setRdIds(Collection<Integer> rdIds) {
		this.rdIds = rdIds;
	}
}