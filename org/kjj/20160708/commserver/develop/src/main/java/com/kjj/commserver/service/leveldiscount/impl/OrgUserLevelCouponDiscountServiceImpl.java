package com.kjj.commserver.service.leveldiscount.impl;

import com.kjj.commserver.dao.leveldiscount.OrgUserLevelCouponDiscountDao;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCouponDiscount;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelCouponDiscountService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class OrgUserLevelCouponDiscountServiceImpl extends BaseServiceImpl<OrgUserLevelCouponDiscount, Integer> implements OrgUserLevelCouponDiscountService {
    @Resource
    private OrgUserLevelCouponDiscountDao orgUserLevelCouponDiscountDao;

    @Override
    protected BaseDao<OrgUserLevelCouponDiscount, Integer> getBaseDao() {
        return orgUserLevelCouponDiscountDao;
    }

	@Override
	public int deleteByLevelCouponId(Integer levelCouponId) {
		
		return orgUserLevelCouponDiscountDao.deleteByLevelCouponId(levelCouponId);
	}
}