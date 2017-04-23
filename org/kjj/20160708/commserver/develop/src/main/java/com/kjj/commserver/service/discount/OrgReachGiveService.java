package com.kjj.commserver.service.discount;

import java.util.Collection;
import java.util.List;

import com.kjj.commserver.entity.discount.OrgReachGive;
import com.kjj.core.service.BaseService;

public interface OrgReachGiveService extends BaseService<OrgReachGive, Integer> {

	/**
	 * 查询赠品
	 * @param rdIds
	 * @return
	 */
	List<OrgReachGive> queryListByRdIds(Collection<Integer> rdIds);
}