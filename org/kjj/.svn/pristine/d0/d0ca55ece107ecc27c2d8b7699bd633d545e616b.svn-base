package com.kjj.commserver.service.discount.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgDiscountAllowDao;
import com.kjj.commserver.entity.discount.OrgDiscountAllow;
import com.kjj.commserver.entity.discount.aide.OrgDiscountAllowQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgDiscountAllowServiceImpl extends BaseServiceImpl<OrgDiscountAllow, Integer> implements OrgDiscountAllowService {
    @Resource
    private OrgDiscountAllowDao orgDiscountAllowDao;

    @Override
    protected BaseDao<OrgDiscountAllow, Integer> getBaseDao() {
        return orgDiscountAllowDao;
    }
    
    public void loadDiscountAllow(Byte typeId, Integer discountId,OrgProductItemAide itemAide) {
    	//查询该优惠允许的其他优惠
		OrgDiscountAllowQuery query = new OrgDiscountAllowQuery();
		query.setTypeId(typeId);
		query.setDiscountId(discountId);	
		Map<Byte, OrgDiscountAllow> mapAllow = queryMap(query,"allowTypeId");
		Map.Entry<Byte,OrgDiscountAllow> enAllow = null;
		//把不能共存的优惠去除
		Iterator<Map.Entry<Byte,OrgDiscountAllow>> itAllow = itemAide.getMapDiscountAllow().entrySet().iterator();
		while(itAllow.hasNext()){
			enAllow = itAllow.next();
			//本优惠不去除，其他优惠没有的话去除
			if(enAllow.getKey() != typeId && !mapAllow.containsKey(enAllow.getKey())){
				itAllow.remove();
			}
		}
	}

	@Override
	public void addByDiscount(Byte typeId, Integer discountId, List<Byte> listAllow) {
		OrgDiscountAllow orgDiscountAllow = null;
		if (CollectionUtils.isNotEmpty(listAllow)) {
			for(Byte allowTypeId:listAllow){
				orgDiscountAllow = new OrgDiscountAllow(typeId,discountId);
				orgDiscountAllow.setAllowTypeId(allowTypeId);
				add(orgDiscountAllow);
			}
		}
	}

	@Override
	public Map<Byte, OrgDiscountAllow> queryMapKeyAllowTypeId(OrgDiscountAllow orgDiscountAllow) {
		return queryMap(orgDiscountAllow, "allowTypeId");
	}

	@Override
	public void updateByDiscount(Byte typeId, Integer discountId, List<Byte> listAllow) {
		OrgDiscountAllow orgDiscountAllow = new OrgDiscountAllow();
		orgDiscountAllow.setTypeId(typeId);
		orgDiscountAllow.setDiscountId(discountId);
		delete(orgDiscountAllow);
		addByDiscount(typeId,discountId, listAllow);
	}

	@Override
	public String queryInfo(Byte typeId, Integer discountId) {
		return orgDiscountAllowDao.selectInfo(typeId, discountId);
	}
}