package com.kjj.commserver.entity.article.aide;

import com.kjj.commserver.entity.article.OrgArticle;

public class OrgArticleQuery extends OrgArticle {
	
	/** 店铺ID */
	private Integer  articleShopId;
	
	/** 标题 */
	private String titleLike;
	
	/** 父分类ID */
	private Integer  parentClassId;

	public Integer getArticleShopId() {
		return articleShopId;
	}

	public void setArticleShopId(Integer articleShopId) {
		this.articleShopId = articleShopId;
	}

	public String getTitleLike() {
		return titleLike;
	}

	public void setTitleLike(String titleLike) {
		this.titleLike = titleLike;
	}

	public Integer getParentClassId() {
		return parentClassId;
	}

	public void setParentClassId(Integer parentClassId) {
		this.parentClassId = parentClassId;
	}

}