package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgSaleSpecTypeDao;
import com.kjj.commserver.entity.goods.OrgSaleSpecType;
import com.kjj.commserver.service.goods.OrgSaleSpecTypeService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgSaleSpecTypeServiceImpl extends BaseServiceImpl<OrgSaleSpecType, Integer> implements OrgSaleSpecTypeService {
    @Resource
    private OrgSaleSpecTypeDao orgSaleSpecTypeDao;

    @Override
    protected BaseDao<OrgSaleSpecType, Integer> getBaseDao() {
        return orgSaleSpecTypeDao;
    }
}