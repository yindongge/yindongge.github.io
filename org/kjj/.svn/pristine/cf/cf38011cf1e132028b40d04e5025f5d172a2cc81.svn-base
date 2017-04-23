package com.kjj.commserver.service.activity.impl;

import com.kjj.commserver.dao.activity.OrgActivityDetailDao;
import com.kjj.commserver.entity.activity.OrgActivityDetail;
import com.kjj.commserver.service.activity.OrgActivityDetailService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgActivityDetailServiceImpl extends BaseServiceImpl<OrgActivityDetail, Integer> implements OrgActivityDetailService {
    @Resource
    private OrgActivityDetailDao orgActivityDetailDao;

    @Override
    protected BaseDao<OrgActivityDetail, Integer> getBaseDao() {
        return orgActivityDetailDao;
    }
}