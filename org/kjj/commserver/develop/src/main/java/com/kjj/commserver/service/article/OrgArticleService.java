package com.kjj.commserver.service.article;

import java.util.List;

import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.core.service.BaseService;

public interface OrgArticleService extends BaseService<OrgArticle, Integer> {

	/**
	 * 根据标题查询文章
	 * @param title
	 * @return
	 */
	OrgArticle queryOneByTitle(String title);

	/**
	 * 根据父类型ID和店铺查询其所有子分类文章
	 * @param parentClassId
	 * @param shopId
	 * @return
	 */
	List<OrgArticle> queryListByParentClassIdAndShopId(Integer parentClassId, Integer shopId);

	/**
	 * 根据分类查询文章
	 * @param classid
	 * @param shopId
	 * @return
	 */
	List<OrgArticle> queryListByClassidAndShopId(Short classid,Integer shopId);
	
	/**
	 * 删除文章
	 * 如果还有其他店铺使用该文章，则删除文章店铺关联信息
	 * 没有其他店铺使用该文章，删除该文章
	 * @param articleId  文章Id
	 * @param shopId  店铺Id
	 * @return
	 */
	int delete4Article(Integer articleId);
}