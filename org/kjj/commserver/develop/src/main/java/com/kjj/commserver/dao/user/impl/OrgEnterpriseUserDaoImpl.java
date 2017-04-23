package com.kjj.commserver.dao.user.impl;

import com.kjj.commserver.dao.user.OrgEnterpriseUserDao;
import com.kjj.commserver.entity.user.OrgEnterpriseUser;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgEnterpriseUserDaoImpl extends BaseDaoImpl<OrgEnterpriseUser, Integer> implements OrgEnterpriseUserDao {
}