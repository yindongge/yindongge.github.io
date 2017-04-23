package com.kjj.commserver.dao.system.impl;

import com.kjj.commserver.dao.system.OrgModelDao;
import com.kjj.commserver.entity.system.OrgModel;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgModelDaoImpl extends BaseDaoImpl<OrgModel, Integer> implements OrgModelDao {
}