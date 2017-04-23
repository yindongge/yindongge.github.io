package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgShopSendRangeService extends BaseService<OrgShopSendRange, Integer> {

	/**
	 * 查询用户对应店铺的配送范围
	 * @param orgUsersSession session中user
	 * @return
	 */
	List<OrgShopSendRange> queryList4User(OrgUsersSession orgUsersSession);
	/**
	 * 查询用户对应店铺的配送范围
	 * @param orgUsersSession session中user
	 * @return
	 */
	List<OrgShopSendRange> queryListByShopId(Integer shopId);
}