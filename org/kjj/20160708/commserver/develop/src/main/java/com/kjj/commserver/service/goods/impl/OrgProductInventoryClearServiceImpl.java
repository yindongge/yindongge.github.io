package com.kjj.commserver.service.goods.impl;

import java.util.List;

import com.kjj.commserver.dao.goods.OrgProductInventoryClearDao;
import com.kjj.commserver.entity.goods.OrgProductInventoryClear;
import com.kjj.commserver.service.goods.OrgProductInventoryClearService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class OrgProductInventoryClearServiceImpl extends BaseServiceImpl<OrgProductInventoryClear, Integer> implements OrgProductInventoryClearService {
    @Resource
    private OrgProductInventoryClearDao orgProductInventoryClearDao;

    @Override
    protected BaseDao<OrgProductInventoryClear, Integer> getBaseDao() {
        return orgProductInventoryClearDao;
    }

	@Override
	public void updateInventoryClear(String shopCode,
			List<OrgProductInventoryClear> InventoryClearList) {
		OrgProductInventoryClear query = new OrgProductInventoryClear();
		query.setShopCode(shopCode);
		orgProductInventoryClearDao.delete(query);
		if(InventoryClearList.size() > 0){
			orgProductInventoryClearDao.insertInBatch(InventoryClearList);
		}
		
	}

	@Override
	public void updateMealInventoryZero(String timeType, Integer classId) {
		orgProductInventoryClearDao.updateMealInventoryZero(timeType, classId);
	}
}