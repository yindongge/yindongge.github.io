package com.kjj.commserver.dao.leveldiscount.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.leveldiscount.OrgUserLevelCouponDiscountDao;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCouponDiscount;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgUserLevelCouponDiscountDaoImpl extends BaseDaoImpl<OrgUserLevelCouponDiscount, Integer> implements OrgUserLevelCouponDiscountDao {

	private static final String SQL_ID_DELETE_BY_LEVEL_COUPON_ID = "deleteByLevelCouponId";
	
	@Override
	public int deleteByLevelCouponId(Integer levelCouponId) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("levelCouponId", levelCouponId);
		return sqlSession.delete(getSqlName(SQL_ID_DELETE_BY_LEVEL_COUPON_ID), parameter);
	}
}