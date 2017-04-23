package com.kjj.commserver.service.discount.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgReachDiscountDao;
import com.kjj.commserver.entity.discount.OrgReachDiscount;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountQuery;
import com.kjj.commserver.service.discount.OrgReachDiscountService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgReachDiscountServiceImpl extends BaseServiceImpl<OrgReachDiscount, Integer> implements OrgReachDiscountService {
    @Resource
    private OrgReachDiscountDao orgReachDiscountDao;

    @Override
    protected BaseDao<OrgReachDiscount, Integer> getBaseDao() {
        return orgReachDiscountDao;
    }

	@Override
	public Map<Long, OrgReachDiscount> queryMapByRcId(Integer rcId) {
		OrgReachDiscountQuery query = new OrgReachDiscountQuery();
		query.setRcId(rcId);
		Map<Byte, OrgReachDiscount> mapByteReachDiscount =  queryMap(query,"typeId");
		Map<Long, OrgReachDiscount> mapReachDiscount = new HashMap<Long, OrgReachDiscount>();
		for(Map.Entry<Byte, OrgReachDiscount> entry : mapByteReachDiscount.entrySet()){
			mapReachDiscount.put(entry.getKey().longValue(), entry.getValue());
		}
		return mapReachDiscount;
	}


}