package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgTradeSnapshootDao;
import com.kjj.commserver.entity.goods.OrgTradeSnapshoot;
import com.kjj.commserver.service.goods.OrgTradeSnapshootService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgTradeSnapshootServiceImpl extends BaseServiceImpl<OrgTradeSnapshoot, Integer> implements OrgTradeSnapshootService {
    @Resource
    private OrgTradeSnapshootDao orgTradeSnapshootDao;

    @Override
    protected BaseDao<OrgTradeSnapshoot, Integer> getBaseDao() {
        return orgTradeSnapshootDao;
    }
}