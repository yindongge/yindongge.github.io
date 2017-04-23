package com.kjj.commserver.service.discount.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgReachCouponOrderDao;
import com.kjj.commserver.entity.discount.OrgReachCouponOrder;
import com.kjj.commserver.entity.discount.aide.OrgReachCouponOrderQuery;
import com.kjj.commserver.service.discount.OrgReachCouponOrderService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgReachCouponOrderServiceImpl extends BaseServiceImpl<OrgReachCouponOrder, Integer> implements OrgReachCouponOrderService {
    @Resource
    private OrgReachCouponOrderDao orgReachCouponOrderDao;

    @Override
    protected BaseDao<OrgReachCouponOrder, Integer> getBaseDao() {
        return orgReachCouponOrderDao;
    }
    
    @Override
	public void addInBatch(Integer orderId,Map<Integer, Integer> mapReachCoupon) {
		//处理
    	List<OrgReachCouponOrder> listOrgReachCouponOrder = new ArrayList<OrgReachCouponOrder>();
    	OrgReachCouponOrder orgReachCouponOrder = null;
    	for(Map.Entry<Integer, Integer> entry : mapReachCoupon.entrySet()){
    		orgReachCouponOrder = new OrgReachCouponOrder();
    		orgReachCouponOrder.setOrderId(orderId);
    		orgReachCouponOrder.setCouponId(entry.getKey());
    		orgReachCouponOrder.setAmount(entry.getValue());
    		listOrgReachCouponOrder.add(orgReachCouponOrder);
    	}
    	addInBatch(listOrgReachCouponOrder);
	}

	@Override
	public List<OrgReachCouponOrder> queryListByOrderId(Integer orderId) {
		OrgReachCouponOrderQuery query = new OrgReachCouponOrderQuery();
		query.setOrderId(orderId);
		return queryList(query);
	}
}