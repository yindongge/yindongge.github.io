package com.kjj.commserver.service.consult.impl;

import com.kjj.commserver.dao.consult.OrgConsultClassDao;
import com.kjj.commserver.entity.consult.OrgConsultClass;
import com.kjj.commserver.service.consult.OrgConsultClassService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgConsultClassServiceImpl extends BaseServiceImpl<OrgConsultClass, Integer> implements OrgConsultClassService {
    @Resource
    private OrgConsultClassDao orgConsultClassDao;

    @Override
    protected BaseDao<OrgConsultClass, Integer> getBaseDao() {
        return orgConsultClassDao;
    }
}