package com.kjj.ruixing.service.user.impl;

import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import com.kjj.ruixing.dao.user.BasviptypDao;
import com.kjj.ruixing.entity.user.Basviptyp;
import com.kjj.ruixing.service.user.BasviptypService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BasviptypServiceImpl extends BaseServiceImpl<Basviptyp, Short> implements BasviptypService {
    @Resource
    private BasviptypDao basviptypDao;

    @Override
    protected BaseDao<Basviptyp, Short> getBaseDao() {
        return basviptypDao;
    }
}