package com.kjj.commserver.entity.consult.aide;

import com.kjj.commserver.entity.consult.OrgConsultProblem;

public class OrgConsultProblemQuery extends OrgConsultProblem {
	
	/*** 会员名称  */
	private String userNameLike;
	
	/** 商品的唯一货号 */
    private String goodsSnLike;
	
    /** 咨询问题描述 */
    private String consultProblemLike;
    
    /** 咨询回复 */
    private String consultAnswer;
    
    /** 服务编号 */
    private String consultProblemIdLike;
    
	public String getUserNameLike() {
		return userNameLike;
	}

	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}

	public String getGoodsSnLike() {
		return goodsSnLike;
	}

	public void setGoodsSnLike(String goodsSnLike) {
		this.goodsSnLike = goodsSnLike;
	}

	public String getConsultProblemLike() {
		return consultProblemLike;
	}

	public void setConsultProblemLike(String consultProblemLike) {
		this.consultProblemLike = consultProblemLike;
	}

	public String getConsultAnswer() {
		return consultAnswer;
	}

	public void setConsultAnswer(String consultAnswer) {
		this.consultAnswer = consultAnswer;
	}

	public String getConsultProblemIdLike() {
		return consultProblemIdLike;
	}

	public void setConsultProblemIdLike(String consultProblemIdLike) {
		this.consultProblemIdLike = consultProblemIdLike;
	}

    
}