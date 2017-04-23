package com.kjj.commserver.dao.user.impl;

import com.kjj.commserver.dao.user.OrgUserActiveDao;
import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgUserActiveDaoImpl extends BaseDaoImpl<OrgUserActive, Integer> implements OrgUserActiveDao {
}