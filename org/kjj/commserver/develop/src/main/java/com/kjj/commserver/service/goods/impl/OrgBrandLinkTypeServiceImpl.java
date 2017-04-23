package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgBrandLinkTypeDao;
import com.kjj.commserver.entity.goods.OrgBrandLinkType;
import com.kjj.commserver.service.goods.OrgBrandLinkTypeService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgBrandLinkTypeServiceImpl extends BaseServiceImpl<OrgBrandLinkType, Integer> implements OrgBrandLinkTypeService {
    @Resource
    private OrgBrandLinkTypeDao orgBrandLinkTypeDao;

    @Override
    protected BaseDao<OrgBrandLinkType, Integer> getBaseDao() {
        return orgBrandLinkTypeDao;
    }
}