package com.kjj.commserver.service.user.impl;

import com.kjj.commserver.dao.user.OrgEnterpriseCheckDao;
import com.kjj.commserver.entity.user.OrgEnterpriseCheck;
import com.kjj.commserver.service.user.OrgEnterpriseCheckService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgEnterpriseCheckServiceImpl extends BaseServiceImpl<OrgEnterpriseCheck, Integer> implements OrgEnterpriseCheckService {
    @Resource
    private OrgEnterpriseCheckDao orgEnterpriseCheckDao;

    @Override
    protected BaseDao<OrgEnterpriseCheck, Integer> getBaseDao() {
        return orgEnterpriseCheckDao;
    }
}