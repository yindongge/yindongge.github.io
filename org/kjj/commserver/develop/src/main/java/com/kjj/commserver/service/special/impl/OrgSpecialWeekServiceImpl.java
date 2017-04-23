package com.kjj.commserver.service.special.impl;

import com.kjj.commserver.dao.special.OrgSpecialWeekDao;
import com.kjj.commserver.entity.special.OrgSpecialWeek;
import com.kjj.commserver.service.special.OrgSpecialWeekService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgSpecialWeekServiceImpl extends BaseServiceImpl<OrgSpecialWeek, Integer> implements OrgSpecialWeekService {
    @Resource
    private OrgSpecialWeekDao orgSpecialWeekDao;

    @Override
    protected BaseDao<OrgSpecialWeek, Integer> getBaseDao() {
        return orgSpecialWeekDao;
    }
}