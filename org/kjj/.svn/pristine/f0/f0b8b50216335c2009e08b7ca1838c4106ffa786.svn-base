package com.kjj.commserver.service.user.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgFeedbackDao;
import com.kjj.commserver.entity.user.OrgFeedback;
import com.kjj.commserver.service.user.OrgFeedbackService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgFeedbackServiceImpl extends BaseServiceImpl<OrgFeedback, Integer> implements OrgFeedbackService {
    @Resource
    private OrgFeedbackDao orgFeedbackDao;

    @Override
    protected BaseDao<OrgFeedback, Integer> getBaseDao() {
        return orgFeedbackDao;
    }
    
    @Override
    public void add(OrgFeedback orgFeedback){
    	orgFeedback.setCreateTime(new Date());
    	super.add(orgFeedback);
    }
}