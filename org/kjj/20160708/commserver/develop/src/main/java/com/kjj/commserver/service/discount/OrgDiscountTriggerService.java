package com.kjj.commserver.service.discount;

import com.kjj.commserver.entity.discount.OrgDiscountTrigger;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.core.service.BaseService;

public interface OrgDiscountTriggerService extends BaseService<OrgDiscountTrigger, Integer> {

	/**
	 * 添加触发券
	 * @param orgDiscountTrigger
	 * @param admin
	 */
	void add(OrgDiscountTrigger orgDiscountTrigger,
			OrgAdminUserSession admin);
	/**
	 * 把状态修改为暂停或者恢复
	 * @param id
	 */
	void updatePause(Integer id);
	
	/**
	 * 触发
	 * @param triggerType
	 * @param user
	 */
	void updateTrigger(Byte triggerType,OrgUsers user);
}