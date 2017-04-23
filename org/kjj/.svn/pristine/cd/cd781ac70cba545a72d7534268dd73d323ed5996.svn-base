package com.kjj.commserver.service.activity.impl;

import com.kjj.commserver.dao.activity.OrgActivityDao;
import com.kjj.commserver.entity.activity.OrgActivity;
import com.kjj.commserver.service.activity.OrgActivityService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgActivityServiceImpl extends BaseServiceImpl<OrgActivity, Integer> implements OrgActivityService {
    @Resource
    private OrgActivityDao orgActivityDao;

    @Override
    protected BaseDao<OrgActivity, Integer> getBaseDao() {
        return orgActivityDao;
    }
}