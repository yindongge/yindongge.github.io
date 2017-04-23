package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgAdvertisementTypeDao;
import com.kjj.commserver.entity.goods.OrgAdvertisementType;
import com.kjj.commserver.service.goods.OrgAdvertisementTypeService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgAdvertisementTypeServiceImpl extends BaseServiceImpl<OrgAdvertisementType, Integer> implements OrgAdvertisementTypeService {
    @Resource
    private OrgAdvertisementTypeDao orgAdvertisementTypeDao;

    @Override
    protected BaseDao<OrgAdvertisementType, Integer> getBaseDao() {
        return orgAdvertisementTypeDao;
    }
}