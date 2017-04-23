package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgProductTypeLinkProductPropertyDao;
import com.kjj.commserver.entity.goods.OrgProductTypeLinkProductProperty;
import com.kjj.commserver.service.goods.OrgProductTypeLinkProductPropertyService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgProductTypeLinkProductPropertyServiceImpl extends BaseServiceImpl<OrgProductTypeLinkProductProperty, Integer> implements OrgProductTypeLinkProductPropertyService {
    @Resource
    private OrgProductTypeLinkProductPropertyDao orgProductTypeLinkProductPropertyDao;

    @Override
    protected BaseDao<OrgProductTypeLinkProductProperty, Integer> getBaseDao() {
        return orgProductTypeLinkProductPropertyDao;
    }
}