package com.kjj.commserver.entity.discount.aide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.OrgReachCondition;
import com.kjj.commserver.entity.discount.OrgReachDiscount;

public class OrgReachConditionVo extends OrgReachCondition {
	
	/** 优惠 */
	private Map<Long,OrgReachDiscount> mapReachDiscount = new HashMap<Long,OrgReachDiscount>();
	
	/** 满减活动 */
	private OrgReach orgReach;

	/** 满减优惠级别  */
	private List<OrgReachDiscount>  orgReachDiscountList;

	public Map<Long, OrgReachDiscount> getMapReachDiscount() {
		return mapReachDiscount;
	}

	public void setMapReachDiscount(Map<Long, OrgReachDiscount> mapReachDiscount) {
		this.mapReachDiscount = mapReachDiscount;
	}
	
	public OrgReach getOrgReach() {
		return orgReach;
	}

	public void setOrgReach(OrgReach orgReach) {
		this.orgReach = orgReach;
	}

	public List<OrgReachDiscount> getOrgReachDiscountList() {
		return orgReachDiscountList;
	}

	public void setOrgReachDiscountList(List<OrgReachDiscount> orgReachDiscountList) {
		this.orgReachDiscountList = orgReachDiscountList;
	}
	
}