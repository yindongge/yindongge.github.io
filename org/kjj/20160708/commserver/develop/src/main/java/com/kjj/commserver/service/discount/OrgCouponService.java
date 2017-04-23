package com.kjj.commserver.service.discount;

import com.kjj.commserver.entity.discount.OrgCoupon;
import com.kjj.commserver.entity.discount.aide.OrgCouponForm;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.core.service.BaseService;

public interface OrgCouponService extends BaseService<OrgCoupon, Integer> {

	/**
	 * 添加优惠券
	 * @param orgCoupon
	 * @param admin
	 */
	void add(OrgCouponForm orgCouponForm, OrgAdminUserSession admin);
	/**
	 * 修改优惠卷启用或者停用状态
	 * @param couponId
	 */
	void updatePause(Integer couponId);
	
	/**
	 * 修改优惠券
	 * @param orgCouponForm
	 */
	void update(OrgCouponForm orgCouponForm);
	
}