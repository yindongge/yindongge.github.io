package com.kjj.commserver.entity.consult.aide;


import java.util.ArrayList;
import java.util.List;

import com.kjj.commserver.entity.consult.OrgConsultAnswer;
import com.kjj.commserver.entity.consult.OrgConsultProblem;

public class OrgConsultProblemVo extends OrgConsultProblem {
	
	/** 咨询 */
	private List<OrgConsultAnswer> listOrgConsultAnswer = new ArrayList<OrgConsultAnswer>();

	private String createUserName;
	
	public List<OrgConsultAnswer> getListOrgConsultAnswer() {
		return listOrgConsultAnswer;
	}

	public void setListOrgConsultAnswer(List<OrgConsultAnswer> listOrgConsultAnswer) {
		this.listOrgConsultAnswer = listOrgConsultAnswer;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
}