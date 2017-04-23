package com.kjj.commserver.entity.order.aide;

import com.kjj.commserver.entity.order.OrgGoodsComment;

public class OrgGoodsCommentVo extends OrgGoodsComment {
	
	/**用户名称  */
	private String userName;
	
	/** 商品名称  */
	private String goodsName;
	
	/** 用户会员等级名称  */
	private String levelName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
}