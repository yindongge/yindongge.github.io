package com.kjj.commserver.service.activity.impl;

import com.kjj.commserver.dao.activity.OrgActivityTicketDao;
import com.kjj.commserver.entity.activity.OrgActivityTicket;
import com.kjj.commserver.service.activity.OrgActivityTicketService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgActivityTicketServiceImpl extends BaseServiceImpl<OrgActivityTicket, Integer> implements OrgActivityTicketService {
    @Resource
    private OrgActivityTicketDao orgActivityTicketDao;

    @Override
    protected BaseDao<OrgActivityTicket, Integer> getBaseDao() {
        return orgActivityTicketDao;
    }
}