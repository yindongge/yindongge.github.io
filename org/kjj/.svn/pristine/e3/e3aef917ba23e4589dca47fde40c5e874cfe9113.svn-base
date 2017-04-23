package com.kjj.commserver.service.goods.impl;

import com.kjj.commserver.dao.goods.OrgProductImgDao;
import com.kjj.commserver.entity.goods.OrgProductImg;
import com.kjj.commserver.service.goods.OrgProductImgService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrgProductImgServiceImpl extends BaseServiceImpl<OrgProductImg, Integer> implements OrgProductImgService {
    @Resource
    private OrgProductImgDao orgProductImgDao;

    @Override
    protected BaseDao<OrgProductImg, Integer> getBaseDao() {
        return orgProductImgDao;
    }
}