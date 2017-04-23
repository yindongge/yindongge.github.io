package com.kjj.commserver.service.system.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.system.OrgAdminShopDao;
import com.kjj.commserver.entity.system.OrgAdminShop;
import com.kjj.commserver.entity.system.aide.OrgAdminShopQuery;
import com.kjj.commserver.service.system.OrgAdminShopService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAdminShopServiceImpl extends BaseServiceImpl<OrgAdminShop, Integer> implements OrgAdminShopService {
    @Resource
    private OrgAdminShopDao orgAdminShopDao;

    @Override
    protected BaseDao<OrgAdminShop, Integer> getBaseDao() {
        return orgAdminShopDao;
    }

	@Override
	public Collection<Integer> queryShopIdsByUserId(int userId) {
		OrgAdminShopQuery query = new OrgAdminShopQuery();
		query.setUserid(userId);
		Map<Integer,OrgAdminShop> map = queryMap(query, "shopid");
		return map.keySet();
	}

	@Override
	public List<OrgAdminShop> queryByUserId(Integer userId) {
		OrgAdminShopQuery query = new OrgAdminShopQuery();
		query.setUserid(userId);
		return queryList(query);
	}

	@Override
	public void addInShopIds(String shopIds, Short userId) {
		if(StringUtils.isNotBlank(shopIds)){
			List<OrgAdminShop> list = new ArrayList<OrgAdminShop>();
			String ids[] = shopIds.split(",");
			for (String id : ids) {
				OrgAdminShop orgAdminShop = new OrgAdminShop();
				orgAdminShop.setUserid((int)userId);
				orgAdminShop.setShopid(Integer.parseInt(id));
				list.add(orgAdminShop);
			}
			addInBatch(list);
		}
	}

	@Override
	public int deleteByShopId(Short userId) {
		OrgAdminShopQuery query = new OrgAdminShopQuery();
		query.setUserid(userId.intValue());
		return delete(query);
	}
}