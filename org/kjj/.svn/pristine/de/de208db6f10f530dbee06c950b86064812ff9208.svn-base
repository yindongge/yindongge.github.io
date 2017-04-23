package com.kjj.commserver.service.activity.impl;

import com.kjj.commserver.dao.activity.OrgActivityAwardDao;
import com.kjj.commserver.entity.activity.OrgActivityAward;
import com.kjj.commserver.service.activity.OrgActivityAwardService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgActivityAwardServiceImpl extends BaseServiceImpl<OrgActivityAward, Integer> implements OrgActivityAwardService {
    @Resource
    private OrgActivityAwardDao orgActivityAwardDao;

    @Override
    protected BaseDao<OrgActivityAward, Integer> getBaseDao() {
        return orgActivityAwardDao;
    }
}