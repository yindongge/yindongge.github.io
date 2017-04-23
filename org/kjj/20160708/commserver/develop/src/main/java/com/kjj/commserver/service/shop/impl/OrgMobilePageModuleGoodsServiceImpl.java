package com.kjj.commserver.service.shop.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgMobilePageModuleGoodsDao;
import com.kjj.commserver.entity.shop.OrgMobilePageModuleGoods;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageModuleGoodsQuery;
import com.kjj.commserver.service.shop.OrgMobilePageModuleGoodsService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgMobilePageModuleGoodsServiceImpl extends BaseServiceImpl<OrgMobilePageModuleGoods, Integer> implements OrgMobilePageModuleGoodsService {
    @Resource
    private OrgMobilePageModuleGoodsDao orgMobilePageModuleGoodsDao;

    @Override
    protected BaseDao<OrgMobilePageModuleGoods, Integer> getBaseDao() {
        return orgMobilePageModuleGoodsDao;
    }

	@Override
	public void addGoods(OrgMobilePageModuleGoods module) {
		super.add(module);
	}

	@Override
	public void deleteGoods(OrgMobilePageModuleGoodsQuery query) {
		super.delete(query);
	}

	@Override
	public void deleteGoodsByModuleId(OrgMobilePageModuleGoodsQuery query) {
		super.delete(query);
	}

	

}