package com.kjj.commserver.service.activity.impl;

import com.kjj.commserver.dao.activity.OrgActivityDialitemDao;
import com.kjj.commserver.entity.activity.OrgActivityDialitem;
import com.kjj.commserver.service.activity.OrgActivityDialitemService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgActivityDialitemServiceImpl extends BaseServiceImpl<OrgActivityDialitem, Integer> implements OrgActivityDialitemService {
    @Resource
    private OrgActivityDialitemDao orgActivityDialitemDao;

    @Override
    protected BaseDao<OrgActivityDialitem, Integer> getBaseDao() {
        return orgActivityDialitemDao;
    }
}