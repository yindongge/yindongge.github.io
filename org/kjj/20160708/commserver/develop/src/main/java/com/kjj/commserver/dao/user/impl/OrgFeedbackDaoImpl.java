package com.kjj.commserver.dao.user.impl;

import com.kjj.commserver.dao.user.OrgFeedbackDao;
import com.kjj.commserver.entity.user.OrgFeedback;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgFeedbackDaoImpl extends BaseDaoImpl<OrgFeedback, Integer> implements OrgFeedbackDao {
}