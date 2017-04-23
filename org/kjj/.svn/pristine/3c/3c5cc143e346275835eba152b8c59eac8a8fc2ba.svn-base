package com.kjj.commserver.service.discount;

import java.util.List;

import com.kjj.commserver.entity.discount.OrgReachCondition;
import com.kjj.core.service.BaseService;


public interface OrgReachConditionService extends BaseService<OrgReachCondition, Integer> {

	/**
	 * 查询条件
	 * @param id
	 * @return
	 */
	List<OrgReachCondition> queryByReachId(Integer reachId);
	
	/** 更新满减满送优惠设置信息
	 * @param jsonStr
	 */
	Integer updateSet(String jsonStr);
	
	/**
	 * 删除一级优惠设置
	 * @param conditionId
	 */
	void deleteSet(Integer conditionId);
}