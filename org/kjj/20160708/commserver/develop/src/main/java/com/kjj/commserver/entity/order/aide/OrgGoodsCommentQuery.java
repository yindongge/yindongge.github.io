package com.kjj.commserver.entity.order.aide;

import com.kjj.commserver.entity.order.OrgGoodsComment;

public class OrgGoodsCommentQuery extends OrgGoodsComment {
	
	/*** 评论内容 */
	private String goodsCommentLike;

	public String getGoodsCommentLike() {
		return goodsCommentLike;
	}

	public void setGoodsCommentLike(String goodsCommentLike) {
		this.goodsCommentLike = goodsCommentLike;
	}
	
	
}