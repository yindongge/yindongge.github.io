package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgProductTypeLinkSaleSpecDao;
import com.kjj.commserver.entity.goods.OrgProductTypeLinkSaleSpec;
import com.kjj.commserver.service.goods.OrgProductTypeLinkSaleSpecService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgProductTypeLinkSaleSpecServiceImpl extends BaseServiceImpl<OrgProductTypeLinkSaleSpec, Integer> implements OrgProductTypeLinkSaleSpecService {
    @Resource
    private OrgProductTypeLinkSaleSpecDao orgProductTypeLinkSaleSpecDao;

    @Override
    protected BaseDao<OrgProductTypeLinkSaleSpec, Integer> getBaseDao() {
        return orgProductTypeLinkSaleSpecDao;
    }
}