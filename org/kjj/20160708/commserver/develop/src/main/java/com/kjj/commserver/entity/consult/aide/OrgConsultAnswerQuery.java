package com.kjj.commserver.entity.consult.aide;

import java.util.Collection;

import com.kjj.commserver.entity.consult.OrgConsultAnswer;

public class OrgConsultAnswerQuery extends OrgConsultAnswer {
	
	/** 多条回复 */
	private Collection<Integer> consultProblemIds;

	public Collection<Integer> getConsultProblemIds() {
		return consultProblemIds;
	}

	public void setConsultProblemIds(Collection<Integer> consultProblemIds) {
		this.consultProblemIds = consultProblemIds;
	}

}