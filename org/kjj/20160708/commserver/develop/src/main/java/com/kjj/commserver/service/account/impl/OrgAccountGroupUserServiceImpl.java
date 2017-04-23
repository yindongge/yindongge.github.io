package com.kjj.commserver.service.account.impl;

import com.kjj.commserver.dao.account.OrgAccountGroupUserDao;
import com.kjj.commserver.entity.account.OrgAccountGroupUser;
import com.kjj.commserver.service.account.OrgAccountGroupUserService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgAccountGroupUserServiceImpl extends BaseServiceImpl<OrgAccountGroupUser, Integer> implements OrgAccountGroupUserService {
    @Resource
    private OrgAccountGroupUserDao orgAccountGroupUserDao;

    @Override
    protected BaseDao<OrgAccountGroupUser, Integer> getBaseDao() {
        return orgAccountGroupUserDao;
    }
}