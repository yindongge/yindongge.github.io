package com.kjj.commserver.service.article.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.article.OrgArticleDao;
import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.article.aide.OrgArticleConstant;
import com.kjj.commserver.entity.article.aide.OrgArticleQuery;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.commserver.service.article.OrgArticleShopService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgArticleServiceImpl extends BaseServiceImpl<OrgArticle, Integer> implements OrgArticleService {
    @Resource
    private OrgArticleDao orgArticleDao;
    
    @Resource
    private OrgArticleShopService orgArticleShopService;

    @Override
    protected BaseDao<OrgArticle, Integer> getBaseDao() {
        return orgArticleDao;
    }

	@Override
	public void add(OrgArticle orgArticle) {
		orgArticle.setCount(0);
		super.add(orgArticle);
	}
	
	@Override
	public OrgArticle queryOneByTitle(String title) {
		OrgArticleQuery query = new OrgArticleQuery();
		query.setTitle(title);
		return queryOne(query);
	}

	@Override
	public List<OrgArticle> queryListByParentClassIdAndShopId(Integer parentClassId, Integer shopId) {
		OrgArticleQuery query = new OrgArticleQuery();
		query.setParentClassId(parentClassId);
		query.setArticleShopId(shopId);
		query.setStatus(OrgArticleConstant.STATUS_APPROVE_YES);
		return queryList(query);
	}

	@Override
	public List<OrgArticle> queryListByClassidAndShopId(Short classid,Integer shopId) {
		OrgArticleQuery query = new OrgArticleQuery();
		query.setClassid(classid);
		query.setArticleShopId(shopId);
		query.setStatus(OrgArticleConstant.STATUS_APPROVE_YES);
		return queryList(query);
	}

	@Override
	public int delete4Article(Integer articleId) {
		int i=0;
		if(articleId!=null){
			deleteById(articleId);
			i=orgArticleShopService.deleteById(articleId);
		}
		return i;
	}
}