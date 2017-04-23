package com.kjj.commserver.service.discount.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgDiscountProductDao;
import com.kjj.commserver.entity.discount.OrgDiscountProduct;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductQuery;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgDiscountProductServiceImpl extends BaseServiceImpl<OrgDiscountProduct, Integer> implements OrgDiscountProductService {
    @Resource
    private OrgDiscountProductDao orgDiscountProductDao;

    @Override
    protected BaseDao<OrgDiscountProduct, Integer> getBaseDao() {
        return orgDiscountProductDao;
    }

	@Override
	public void addByDiscount(Byte typeId, Integer discountId,Byte productType, Collection<Integer> listClass,Collection<Integer> listGoods) {
		OrgDiscountProduct orgDiscountProduct = null;
		if(productType==OrgDiscountProductConstant.PRODUCT_TYPE_CLASS){
			if(CollectionUtils.isNotEmpty(listClass)){
				for (Integer classId : listClass) {
					orgDiscountProduct = new OrgDiscountProduct(typeId,discountId);
					orgDiscountProduct.setClassId(classId);
					add(orgDiscountProduct);
				}
			}
		}else if(productType==OrgDiscountProductConstant.PRODUCT_TYPE_PRODUCT){
			if(CollectionUtils.isNotEmpty(listGoods)){
				for (Integer goodsId : listGoods) {
					orgDiscountProduct = new OrgDiscountProduct(typeId,discountId);
					orgDiscountProduct.setGoodsId(goodsId);
					add(orgDiscountProduct);
				}
			}
		}
		
	}
	
	@Override
	public void updateByDiscount(Byte typeId, Integer discountId,Byte productType, Collection<Integer> listClass, Collection<Integer> listGoods) {
		OrgDiscountProductQuery orgDiscountProduct = new OrgDiscountProductQuery();
		orgDiscountProduct.setTypeId(typeId);
		orgDiscountProduct.setDiscountId(discountId);
		if(productType.equals(OrgDiscountProductConstant.PRODUCT_TYPE_PRODUCT)){
			orgDiscountProduct.setTypeProduct(true);
		}
		delete(orgDiscountProduct);
		addByDiscount(typeId, discountId,productType, listClass, listGoods);
	}

	@Override
	public Map<Integer, OrgDiscountProduct> queryMapKeyClassId(OrgDiscountProduct orgDiscountProduct) {
		return queryMap(orgDiscountProduct, "classId");
	}
}