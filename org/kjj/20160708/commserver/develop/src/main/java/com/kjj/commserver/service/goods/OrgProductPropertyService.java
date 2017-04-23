package com.kjj.commserver.service.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyQuery;
import com.kjj.core.service.BaseService;

public interface OrgProductPropertyService extends BaseService<OrgProductProperty, Integer> {
	/**
	 * 根据类型id获取属性及属性值
	 * @param typeId
	 * @return
	 */
	List<OrgProductProperty> queryPropertyAndValuesByTypeId(Integer typeId); 
	
	void updatePropertyAndValues(OrgProductPropertyQuery query);
}