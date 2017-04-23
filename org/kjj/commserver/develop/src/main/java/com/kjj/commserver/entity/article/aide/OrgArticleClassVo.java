package com.kjj.commserver.entity.article.aide;

import java.util.ArrayList;
import java.util.List;

import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.article.OrgArticleClass;

public class OrgArticleClassVo extends OrgArticleClass {
	
	/** 子分类 */
	private List<OrgArticleClass> listSubClass = new ArrayList<OrgArticleClass>();
	
	/** 分类下文章列表 */
	private List<OrgArticle> listArticle = new ArrayList<OrgArticle>();
	
	/** 判断是否是叶子节点 **/
	private Integer flag;
	
	public Integer getFlag() {
		return flag;
	}

	//
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public List<OrgArticleClass> getListSubClass() {
		return listSubClass;
	}

	public void setListSubClass(List<OrgArticleClass> listSubClass) {
		this.listSubClass = listSubClass;
	}

	public List<OrgArticle> getListArticle() {
		return listArticle;
	}

	public void setListArticle(List<OrgArticle> listArticle) {
		this.listArticle = listArticle;
	}
	
}