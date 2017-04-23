package com.kjj.commserver.dao.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgProductInventory;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryVo;
import com.kjj.core.dao.BaseDao;

public interface OrgProductInventoryDao extends BaseDao<OrgProductInventory, Integer> {
	
	/**
	 * 菜品管理查询列表
	 * @param query
	 * @return
	 */
	List<OrgProductInventoryVo> queryMealList(OrgProductInventoryQuery query);

	/**
	 * 查询并锁定
	 * @param id
	 * @return
	 */
	OrgProductInventory selectById4Update(Integer id);
	
}