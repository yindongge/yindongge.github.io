package com.kjj.commserver.dao.activity.impl;

import com.kjj.commserver.dao.activity.OrgActivityTicketDao;
import com.kjj.commserver.entity.activity.OrgActivityTicket;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgActivityTicketDaoImpl extends BaseDaoImpl<OrgActivityTicket, Integer> implements OrgActivityTicketDao {
}