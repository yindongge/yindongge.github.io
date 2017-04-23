package com.kjj.commserver.dao.account.impl;

import com.kjj.commserver.dao.account.OrgAccountGroupUserDao;
import com.kjj.commserver.entity.account.OrgAccountGroupUser;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgAccountGroupUserDaoImpl extends BaseDaoImpl<OrgAccountGroupUser, Integer> implements OrgAccountGroupUserDao {
}