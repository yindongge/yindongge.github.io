package com.kjj.commserver.dao.user.impl;

import com.kjj.commserver.dao.user.OrgUserLevelDao;
import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgUserLevelDaoImpl extends BaseDaoImpl<OrgUserLevel, String> implements OrgUserLevelDao {
}