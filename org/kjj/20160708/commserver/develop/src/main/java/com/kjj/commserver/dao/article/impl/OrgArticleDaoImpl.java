package com.kjj.commserver.dao.article.impl;

import com.kjj.commserver.dao.article.OrgArticleDao;
import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgArticleDaoImpl extends BaseDaoImpl<OrgArticle, Integer> implements OrgArticleDao {
}