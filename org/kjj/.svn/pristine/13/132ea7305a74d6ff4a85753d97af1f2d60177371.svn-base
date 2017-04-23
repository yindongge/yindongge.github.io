package com.kjj.commserver.service.order.impl;

import com.kjj.commserver.dao.order.OrgSolveOrderDao;
import com.kjj.commserver.entity.order.OrgSolveOrder;
import com.kjj.commserver.service.order.OrgSolveOrderService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgSolveOrderServiceImpl extends BaseServiceImpl<OrgSolveOrder, Integer> implements OrgSolveOrderService {
    @Resource
    private OrgSolveOrderDao orgSolveOrderDao;

    @Override
    protected BaseDao<OrgSolveOrder, Integer> getBaseDao() {
        return orgSolveOrderDao;
    }
}