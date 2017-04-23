package com.kjj.commserver.service.discount.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgDiscountShopDao;
import com.kjj.commserver.entity.discount.OrgDiscountShop;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopConstant;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgDiscountShopServiceImpl extends BaseServiceImpl<OrgDiscountShop, Integer> implements OrgDiscountShopService {
    @Resource
    private OrgDiscountShopDao orgDiscountShopDao;

    @Override
    protected BaseDao<OrgDiscountShop, Integer> getBaseDao() {
        return orgDiscountShopDao;
    }

	@Override
	public void addByDiscount(Byte typeId, Integer discountId, Byte shopType,Collection<String> listCity, Collection<Integer> listShop) {
		OrgDiscountShop orgDiscountShop = null;
		if(shopType == OrgDiscountShopConstant.SHOP_TYPE_CITY){
			if (CollectionUtils.isNotEmpty(listCity)) {
				for(String cityCode:listCity){
					orgDiscountShop = new OrgDiscountShop(typeId,discountId);
					orgDiscountShop.setCityCode(cityCode);
					add(orgDiscountShop);
				}
			}
		}else if(shopType == OrgDiscountShopConstant.SHOP_TYPE_SHOP){
			if (CollectionUtils.isNotEmpty(listShop)) {
				for(Integer shopId:listShop){
					orgDiscountShop = new OrgDiscountShop(typeId,discountId);
					orgDiscountShop.setShopId(shopId);
					add(orgDiscountShop);
				}
			}
		}
	}

	@Override
	public void updateByDiscount(Byte typeId, Integer discountId, Byte shopType,Collection<String> listCity, Collection<Integer> listShop) {
		OrgDiscountShop orgDiscountShop = new OrgDiscountShop();
		orgDiscountShop.setTypeId(typeId);
		orgDiscountShop.setDiscountId(discountId);
		delete(orgDiscountShop);
		addByDiscount(typeId,discountId, shopType,listCity,listShop);
	}

	@Override
	public Map<String,String> queryInfo(Byte typeId, Integer discountId) {
		return orgDiscountShopDao.selectInfo(typeId, discountId);
	}
}