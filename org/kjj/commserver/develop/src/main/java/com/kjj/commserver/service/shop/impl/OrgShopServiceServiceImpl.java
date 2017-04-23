package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopServiceDao;
import com.kjj.commserver.entity.shop.OrgShopService;
import com.kjj.commserver.entity.shop.aide.OrgShopServiceConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopServiceQuery;
import com.kjj.commserver.service.shop.OrgShopServiceService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopServiceServiceImpl extends BaseServiceImpl<OrgShopService, Short> implements OrgShopServiceService {
    @Resource
    private OrgShopServiceDao orgShopServiceDao;

    @Override
    protected BaseDao<OrgShopService, Short> getBaseDao() {
        return orgShopServiceDao;
    }

	@Override
	public List<OrgShopService> queryAll() {
		return queryList(null);
	}

	@Override
	public List<OrgShopService> queryListByShopId(Integer shopId) {
		OrgShopServiceQuery query = new OrgShopServiceQuery();
		query.setShopId(shopId);
		return queryList(query);
	}

	@Override
	public boolean hasMealServiceByShopId(Integer shopId) {
		OrgShopServiceQuery query = new OrgShopServiceQuery();
		query.setShopId(shopId);
		query.setServiceId(OrgShopServiceConstant.SERVICE_ID_MEAL);
		return (queryCount(query) > 0);
	}
}