package com.kjj.commserver.service.user.impl;

import com.kjj.commserver.dao.user.OrgUserConsumeDao;
import com.kjj.commserver.entity.user.OrgUserConsume;
import com.kjj.commserver.service.user.OrgUserConsumeService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgUserConsumeServiceImpl extends BaseServiceImpl<OrgUserConsume, Integer> implements OrgUserConsumeService {
    @Resource
    private OrgUserConsumeDao orgUserConsumeDao;

    @Override
    protected BaseDao<OrgUserConsume, Integer> getBaseDao() {
        return orgUserConsumeDao;
    }
}