package com.kjj.commserver.service.shop.impl;

import com.kjj.commserver.dao.shop.OrgMobilePageCustomizeDao;
import com.kjj.commserver.entity.shop.OrgMobilePageCustomize;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageCustomizeQuery;
import com.kjj.commserver.service.shop.OrgMobilePageCustomizeService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class OrgMobilePageCustomizeServiceImpl extends BaseServiceImpl<OrgMobilePageCustomize, Integer> implements OrgMobilePageCustomizeService {
    @Resource
    private OrgMobilePageCustomizeDao orgMobilePageCustomizeDao;

    @Override
    protected BaseDao<OrgMobilePageCustomize, Integer> getBaseDao() {
        return orgMobilePageCustomizeDao;
    }

	@Override
	public OrgMobilePageCustomize queryOnlyOne(OrgMobilePageCustomizeQuery query) {
		return orgMobilePageCustomizeDao.queryOnlyOne(query);
	}

	@Override
	public OrgMobilePageCustomize queryForOne(OrgMobilePageCustomizeQuery query) {
		return orgMobilePageCustomizeDao.queryForOne(query);
	}
}