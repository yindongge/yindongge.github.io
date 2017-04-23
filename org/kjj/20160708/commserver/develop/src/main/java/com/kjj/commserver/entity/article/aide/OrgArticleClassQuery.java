package com.kjj.commserver.entity.article.aide;

import com.kjj.commserver.entity.article.OrgArticleClass;

public class OrgArticleClassQuery extends OrgArticleClass {
	
	/** 祖先ID 查询孙子辈分类*/
	private Integer rootId;

	public Integer getRootId() {
		return rootId;
	}

	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}
}