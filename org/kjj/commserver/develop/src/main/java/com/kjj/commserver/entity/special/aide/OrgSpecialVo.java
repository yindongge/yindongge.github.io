package com.kjj.commserver.entity.special.aide;

import com.kjj.commserver.entity.special.OrgSpecial;
import com.kjj.commserver.entity.special.OrgSpecialRule;
import com.kjj.commserver.entity.special.OrgSpecialTime;

public class OrgSpecialVo extends OrgSpecial {
	
	/** 专题活动时刻表  */
	private OrgSpecialTime orgSpecialTime;
	
	/** 星期循环 */
	private String weeks;
	
	/** 活动规则  */
	private OrgSpecialRule orgSpecialRule;

	public OrgSpecialTime getOrgSpecialTime() {
		return orgSpecialTime;
	}

	public void setOrgSpecialTime(OrgSpecialTime orgSpecialTime) {
		this.orgSpecialTime = orgSpecialTime;
	}


	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public OrgSpecialRule getOrgSpecialRule() {
		return orgSpecialRule;
	}

	public void setOrgSpecialRule(OrgSpecialRule orgSpecialRule) {
		this.orgSpecialRule = orgSpecialRule;
	}

}