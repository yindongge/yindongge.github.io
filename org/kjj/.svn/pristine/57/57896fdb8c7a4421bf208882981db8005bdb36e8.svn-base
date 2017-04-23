package com.kjj.commserver.service.shop.impl;

import com.kjj.commserver.dao.shop.OrgShopBindServiceDao;
import com.kjj.commserver.entity.shop.OrgShopBindService;
import com.kjj.commserver.service.shop.OrgShopBindServiceService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgShopBindServiceServiceImpl extends BaseServiceImpl<OrgShopBindService, Integer> implements OrgShopBindServiceService {
    @Resource
    private OrgShopBindServiceDao orgShopBindServiceDao;

    @Override
    protected BaseDao<OrgShopBindService, Integer> getBaseDao() {
        return orgShopBindServiceDao;
    }
}