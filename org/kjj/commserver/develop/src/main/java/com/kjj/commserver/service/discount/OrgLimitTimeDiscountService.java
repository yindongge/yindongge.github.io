package com.kjj.commserver.service.discount;

import com.kjj.commserver.entity.discount.OrgLimitTimeDiscount;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeDiscountForm;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.core.service.BaseService;

public interface OrgLimitTimeDiscountService extends BaseService<OrgLimitTimeDiscount, Integer> {
	
	/**
	 * 添加限时折扣
	 * @param orgLimitTimeDiscount
	 * @param admin
	 */
	void add(OrgLimitTimeDiscountForm orgLimitTimeDiscountForm,OrgAdminUserSession admin);
	
	/**
	 * 修改
	 * @param orgLimitTimeDiscount
	 */
	void update(OrgLimitTimeDiscountForm orgLimitTimeDiscountForm);
	
	/**
	 * 暂停
	 * @param id
	 */
	void updatePause(Integer id);
}