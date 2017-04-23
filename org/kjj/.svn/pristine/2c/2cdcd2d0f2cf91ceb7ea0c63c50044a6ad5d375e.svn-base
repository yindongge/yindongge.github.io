package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgTradeSnapshootPropertyDao;
import com.kjj.commserver.entity.goods.OrgTradeSnapshootProperty;
import com.kjj.commserver.service.goods.OrgTradeSnapshootPropertyService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgTradeSnapshootPropertyServiceImpl extends BaseServiceImpl<OrgTradeSnapshootProperty, Integer> implements OrgTradeSnapshootPropertyService {
    @Resource
    private OrgTradeSnapshootPropertyDao orgTradeSnapshootPropertyDao;

    @Override
    protected BaseDao<OrgTradeSnapshootProperty, Integer> getBaseDao() {
        return orgTradeSnapshootPropertyDao;
    }
}