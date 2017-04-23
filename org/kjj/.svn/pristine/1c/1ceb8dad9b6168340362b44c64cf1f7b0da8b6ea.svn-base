package com.kjj.commserver.service.activity.impl;

import com.kjj.commserver.dao.activity.OrgActivityShopDao;
import com.kjj.commserver.entity.activity.OrgActivityShop;
import com.kjj.commserver.service.activity.OrgActivityShopService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgActivityShopServiceImpl extends BaseServiceImpl<OrgActivityShop, Integer> implements OrgActivityShopService {
    @Resource
    private OrgActivityShopDao orgActivityShopDao;

    @Override
    protected BaseDao<OrgActivityShop, Integer> getBaseDao() {
        return orgActivityShopDao;
    }
}