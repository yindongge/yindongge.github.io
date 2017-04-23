package com.kjj.commserver.dao.order;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderUserCount;
import com.kjj.core.dao.BaseDao;

public interface OrgOrderDao extends BaseDao<OrgOrder, Integer> {
	
	/**
	 * 通过Id查询订单并锁定
	 * @param id 主键，不能为null
	 * @return  结果对象，如果未找到返回null
	 */
	OrgOrder selectById4Update(Integer id);
	
	/**
	 * 查询用户订单分类总计
	 * @param userId
	 * @return
	 */
	OrgOrderUserCount selectUserCount(Integer userId);
}