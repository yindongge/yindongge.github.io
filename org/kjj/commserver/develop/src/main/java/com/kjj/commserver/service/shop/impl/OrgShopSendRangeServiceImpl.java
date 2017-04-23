package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopSendRangeDao;
import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.shop.aide.OrgShopSendRangeQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.user.OrgUserAddressService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopSendRangeServiceImpl extends BaseServiceImpl<OrgShopSendRange, Integer> implements OrgShopSendRangeService {
    @Resource
    private OrgShopSendRangeDao orgShopSendRangeDao;
    @Resource
    private OrgUserAddressService orgUserAddressService;

    @Override
    protected BaseDao<OrgShopSendRange, Integer> getBaseDao() {
        return orgShopSendRangeDao;
    }

	@Override
	public List<OrgShopSendRange> queryList4User(OrgUsersSession orgUsersSession) {
		OrgShopSendRangeQuery query = new OrgShopSendRangeQuery();
		query.setShopId(orgUsersSession.getOrgShop().getShopId());
		return queryList(query);
	}

	@Override
	public List<OrgShopSendRange> queryListByShopId(Integer shopId) {
		OrgShopSendRangeQuery query = new OrgShopSendRangeQuery();
		query.setShopId(shopId);
		return queryList(query);
	}
	
	@Override
	public int deleteById(Integer id){
		orgUserAddressService.updateInvaildByShopSendRangeId(id);
		return super.deleteById(id);
	}
}