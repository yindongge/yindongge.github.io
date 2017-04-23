package com.kjj.commserver.entity.order.aide;

import com.kjj.commserver.entity.order.OrgGoodsComment;


public class OrgOrderGoodsCommentVo extends OrgOrderGoodsVo {

	/** 评论信息 */
	
	private OrgGoodsComment orgGoodsComment;

	public OrgGoodsComment getOrgGoodsComment() {
		return orgGoodsComment;
	}

	public void setOrgGoodsComment(OrgGoodsComment orgGoodsComment) {
		this.orgGoodsComment = orgGoodsComment;
	}
	
}
