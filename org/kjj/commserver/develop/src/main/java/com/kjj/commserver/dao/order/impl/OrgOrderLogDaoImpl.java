package com.kjj.commserver.dao.order.impl;

import com.kjj.commserver.dao.order.OrgOrderLogDao;
import com.kjj.commserver.entity.order.OrgOrderLog;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgOrderLogDaoImpl extends BaseDaoImpl<OrgOrderLog, Integer> implements OrgOrderLogDao {
}