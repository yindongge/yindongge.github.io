package com.kjj.commserver.service.discount;

import java.util.List;

import com.kjj.commserver.entity.discount.OrgLimitTimeRecord;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgLimitTimeRecordService extends BaseService<OrgLimitTimeRecord, Integer> {
	
	/**
	 * 生成订单限时折扣记录
	 * @param listCartAll
	 * @param orderId
	 * @param orgUsersSession
	 */
	void add4Order(List<OrgCartAll> listCartAll, Integer orderId,OrgUsersSession orgUsersSession);

	/***
	 * 删除订单的限时折扣记录
	 * @param orderId
	 */
	void deleteByOrderId(Integer orderId);
}