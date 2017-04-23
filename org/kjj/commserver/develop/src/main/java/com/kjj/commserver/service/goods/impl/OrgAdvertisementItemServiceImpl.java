package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgAdvertisementItemDao;
import com.kjj.commserver.entity.goods.OrgAdvertisementItem;
import com.kjj.commserver.service.goods.OrgAdvertisementItemService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgAdvertisementItemServiceImpl extends BaseServiceImpl<OrgAdvertisementItem, Integer> implements OrgAdvertisementItemService {
    @Resource
    private OrgAdvertisementItemDao orgAdvertisementItemDao;

    @Override
    protected BaseDao<OrgAdvertisementItem, Integer> getBaseDao() {
        return orgAdvertisementItemDao;
    }
}