package com.kjj.commserver.service.discount.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgReachCouponDao;
import com.kjj.commserver.entity.discount.OrgReachCoupon;
import com.kjj.commserver.entity.discount.aide.OrgReachCouponQuery;
import com.kjj.commserver.service.discount.OrgReachCouponService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgReachCouponServiceImpl extends BaseServiceImpl<OrgReachCoupon, Integer> implements OrgReachCouponService {
    @Resource
    private OrgReachCouponDao orgReachCouponDao;

    @Override
    protected BaseDao<OrgReachCoupon, Integer> getBaseDao() {
        return orgReachCouponDao;
    }

	@Override
	public List<OrgReachCoupon> queryListByReachDiscountId(Integer rdId) {
		OrgReachCouponQuery query = new OrgReachCouponQuery();
		query.setRdId(rdId);
		return queryList(query);
	}
}