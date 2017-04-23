package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgClassLevelDao;
import com.kjj.commserver.entity.goods.OrgClassLevel;
import com.kjj.commserver.service.goods.OrgClassLevelService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgClassLevelServiceImpl extends BaseServiceImpl<OrgClassLevel, Integer> implements OrgClassLevelService {
    @Resource
    private OrgClassLevelDao orgClassLevelDao;

    @Override
    protected BaseDao<OrgClassLevel, Integer> getBaseDao() {
        return orgClassLevelDao;
    }
}