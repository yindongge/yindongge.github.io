package com.kjj.commserver.service.special.impl;

import com.kjj.commserver.dao.special.OrgSpecialFloorProductDao;
import com.kjj.commserver.entity.special.OrgSpecialFloorProduct;
import com.kjj.commserver.service.special.OrgSpecialFloorProductService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgSpecialFloorProductServiceImpl extends BaseServiceImpl<OrgSpecialFloorProduct, Integer> implements OrgSpecialFloorProductService {
    @Resource
    private OrgSpecialFloorProductDao orgSpecialFloorProductDao;

    @Override
    protected BaseDao<OrgSpecialFloorProduct, Integer> getBaseDao() {
        return orgSpecialFloorProductDao;
    }
}