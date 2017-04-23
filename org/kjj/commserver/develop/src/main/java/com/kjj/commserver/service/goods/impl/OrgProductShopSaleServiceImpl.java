package com.kjj.commserver.service.goods.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgProductShopSaleDao;
import com.kjj.commserver.entity.goods.OrgProductShopSale;
import com.kjj.commserver.service.goods.OrgProductShopSaleService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgProductShopSaleServiceImpl extends BaseServiceImpl<OrgProductShopSale, Integer> implements OrgProductShopSaleService {
    @Resource
    private OrgProductShopSaleDao orgProductShopSaleDao;

    @Override
    protected BaseDao<OrgProductShopSale, Integer> getBaseDao() {
        return orgProductShopSaleDao;
    }

	@Override
	public Integer updateStatusById(Integer id,Integer inventoryId,Byte status) {
		if(id!=null){
			OrgProductShopSale opss = queryById(id);
			opss.setStatus(status);
			updateByIdSelective(opss);
			return id;
		}else{
			OrgProductShopSale orgProductShopSale = new OrgProductShopSale();
			orgProductShopSale.setInventoryId(inventoryId);
			orgProductShopSale.setStatus(status);
			add(orgProductShopSale);
			return orgProductShopSale.getId();
		}
		
	}
}