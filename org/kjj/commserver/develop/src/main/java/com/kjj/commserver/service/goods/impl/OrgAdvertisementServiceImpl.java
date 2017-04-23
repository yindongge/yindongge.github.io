package com.kjj.commserver.service.goods.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgAdvertisementDao;
import com.kjj.commserver.entity.goods.OrgAdvertisement;
import com.kjj.commserver.entity.goods.OrgAdvertisementItem;
import com.kjj.commserver.entity.goods.aide.OrgAdvertisementQuery;
import com.kjj.commserver.service.goods.OrgAdvertisementItemService;
import com.kjj.commserver.service.goods.OrgAdvertisementService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAdvertisementServiceImpl extends BaseServiceImpl<OrgAdvertisement, Integer> implements OrgAdvertisementService {
    @Resource
    private OrgAdvertisementDao orgAdvertisementDao;
    
    @Resource
    private OrgAdvertisementItemService advertisementItemService;

    @Override
    protected BaseDao<OrgAdvertisement, Integer> getBaseDao() {
        return orgAdvertisementDao;
    }

	@Override
	public void addAdvertisementAndItem(OrgAdvertisement advertisement) {
		this.add(advertisement);
		OrgAdvertisementQuery advertisementQuery = (OrgAdvertisementQuery)advertisement;
		OrgAdvertisementItem advertisementItem = new OrgAdvertisementItem();
		advertisementItem.setAdvertisementId(advertisement.getAdvertisementId());
		advertisementItem.setProductId(advertisementQuery.getSkuId());
		advertisementItemService.add(advertisementItem);
	}

	@Override
	public void deleteAdvertisementAndItem(Integer id) {
		this.deleteById(id);
		OrgAdvertisementItem advertisementItemQuery = new OrgAdvertisementItem();
		advertisementItemQuery.setAdvertisementId(id);
		Map<Integer, OrgAdvertisementItem> advertisementItemMap = advertisementItemService.queryMap(advertisementItemQuery, "advertisementItemId");
		advertisementItemService.deleteByIdInBatch(advertisementItemMap.keySet());
	}
}