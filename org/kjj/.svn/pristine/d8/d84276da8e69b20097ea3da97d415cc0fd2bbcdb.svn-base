package com.kjj.ruixing.service.user.impl;

import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import com.kjj.ruixing.dao.user.BasvipDao;
import com.kjj.ruixing.entity.user.Basvip;
import com.kjj.ruixing.service.user.BasvipService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BasvipServiceImpl extends BaseServiceImpl<Basvip, String> implements BasvipService {
    @Resource
    private BasvipDao basvipDao;

    @Override
    protected BaseDao<Basvip, String> getBaseDao() {
        return basvipDao;
    }
}