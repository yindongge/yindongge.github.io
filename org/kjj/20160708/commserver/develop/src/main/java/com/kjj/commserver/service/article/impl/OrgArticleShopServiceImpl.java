package com.kjj.commserver.service.article.impl;

import com.kjj.commserver.dao.article.OrgArticleShopDao;
import com.kjj.commserver.entity.article.OrgArticleShop;
import com.kjj.commserver.service.article.OrgArticleShopService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgArticleShopServiceImpl extends BaseServiceImpl<OrgArticleShop, Integer> implements OrgArticleShopService {
    @Resource
    private OrgArticleShopDao orgArticleShopDao;

    @Override
    protected BaseDao<OrgArticleShop, Integer> getBaseDao() {
        return orgArticleShopDao;
    }
}