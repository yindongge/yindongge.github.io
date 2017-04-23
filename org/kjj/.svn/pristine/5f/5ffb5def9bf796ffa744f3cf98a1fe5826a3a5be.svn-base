package com.kjj.commserver.service.article;

import java.util.List;

import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.core.service.BaseService;

public interface OrgArticleClassService extends BaseService<OrgArticleClass, Integer> {

	/**
	 * 查询分类名称(有效)
	 * @param className
	 * @return
	 */
	
	OrgArticleClass queryClassByClassName(String className);
	
	/**
	 * 查询子类List
	 * @param parentId
	 * @return
	 */
	List<OrgArticleClass> queryListByParentid(Integer parentId);
	
	/**
	 * 查询子类List并包含文章
	 * @param parentId
	 * @return
	 */
	List<OrgArticleClass> queryListByParentidAndShopIdWithArticle(Integer parentId,Integer shopId);

	/**
	 * 查询子类List及子类的子类List
	 * @param rootId 祖先ID
	 * @return
	 */
	List<OrgArticleClass> queryListByParentidWithSubList(Integer rootId);
	
	/**
	 * 获取根分类
	 * @param articleClassChildren
	 * @return
	 */
	public OrgArticleClass getRootClass(OrgArticleClass articleClassChildren);
	
	/**
	 * 获得文章多级分类
	 * @param articleClassId
	 * @return
	 */
	List<OrgArticleClass> getArticleClassTree(int articleClassId);
	
}