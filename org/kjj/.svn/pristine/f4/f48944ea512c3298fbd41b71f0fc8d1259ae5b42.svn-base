package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgProductLinkSubclassDao;
import com.kjj.commserver.entity.goods.OrgProductLinkSubclass;
import com.kjj.commserver.service.goods.OrgProductLinkSubclassService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgProductLinkSubclassServiceImpl extends BaseServiceImpl<OrgProductLinkSubclass, Integer> implements OrgProductLinkSubclassService {
    @Resource
    private OrgProductLinkSubclassDao orgProductLinkSubclassDao;

    @Override
    protected BaseDao<OrgProductLinkSubclass, Integer> getBaseDao() {
        return orgProductLinkSubclassDao;
    }
}