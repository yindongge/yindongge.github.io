package com.kjj.commserver.service.user.impl;

import com.kjj.commserver.dao.user.OrgEnterpriseInvitationUserDao;
import com.kjj.commserver.entity.user.OrgEnterpriseInvitationUser;
import com.kjj.commserver.service.user.OrgEnterpriseInvitationUserService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgEnterpriseInvitationUserServiceImpl extends BaseServiceImpl<OrgEnterpriseInvitationUser, Integer> implements OrgEnterpriseInvitationUserService {
    @Resource
    private OrgEnterpriseInvitationUserDao orgEnterpriseInvitationUserDao;

    @Override
    protected BaseDao<OrgEnterpriseInvitationUser, Integer> getBaseDao() {
        return orgEnterpriseInvitationUserDao;
    }
}