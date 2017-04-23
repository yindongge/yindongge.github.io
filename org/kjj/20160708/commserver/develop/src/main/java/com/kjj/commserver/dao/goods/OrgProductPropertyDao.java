package com.kjj.commserver.dao.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.core.dao.BaseDao;

public interface OrgProductPropertyDao extends BaseDao<OrgProductProperty, Integer> {
	/**
	 * 根据类型id获取关联属性
	 * @param typeId 类型id
	 * @return
	 */
	List<OrgProductProperty> queryByProductTypeId(Integer typeId);
}