package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgProductTypeGroupDao;
import com.kjj.commserver.entity.goods.OrgProductTypeGroup;
import com.kjj.commserver.service.goods.OrgProductTypeGroupService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgProductTypeGroupServiceImpl extends BaseServiceImpl<OrgProductTypeGroup, Integer> implements OrgProductTypeGroupService {
    @Resource
    private OrgProductTypeGroupDao orgProductTypeGroupDao;

    @Override
    protected BaseDao<OrgProductTypeGroup, Integer> getBaseDao() {
        return orgProductTypeGroupDao;
    }
}