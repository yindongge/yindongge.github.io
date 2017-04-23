package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopPageFloorDao;
import com.kjj.commserver.entity.shop.OrgShopPageFloor;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorVo;
import com.kjj.commserver.service.shop.OrgShopPageFloorService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopPageFloorServiceImpl extends BaseServiceImpl<OrgShopPageFloor, Integer> implements OrgShopPageFloorService {
    @Resource
    private OrgShopPageFloorDao orgShopPageFloorDao;

    @Override
    protected BaseDao<OrgShopPageFloor, Integer> getBaseDao() {
        return orgShopPageFloorDao;
    }

	@Override
	public List<OrgShopPageFloor> queryActiveByPageId(Integer pageId) {
		OrgShopPageFloorQuery query = new OrgShopPageFloorQuery();
		query.setPageid(pageId);
		query.setIsactive(OrgShopPageFloorConstant.STATUS_ACTIVE);
		Sort sort = new Sort(Direction.ASC,"t.floorid");
		return queryList(query,sort);
	}



	@Override
	public void deleteFloorByPageId(Integer pageId) {
		orgShopPageFloorDao.deleteFloorByPageId(pageId);
		
	}

	@Override
	public List<OrgShopPageFloorVo> queryByPageIdAsc(Integer pageId) {
		OrgShopPageFloorQuery query = new OrgShopPageFloorQuery();
		query.setPageid(pageId);
		Sort sort = new Sort(Direction.ASC,"t.floorid");
		return orgShopPageFloorDao.selectList(query, sort);
	}
}