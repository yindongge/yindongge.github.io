package com.kjj.commserver.dao.system.impl;

import com.kjj.commserver.dao.system.OrgAdminUserDao;
import com.kjj.commserver.entity.system.OrgAdminUser;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgAdminUserDaoImpl extends BaseDaoImpl<OrgAdminUser, Short> implements OrgAdminUserDao {
}