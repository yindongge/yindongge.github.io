package com.kjj.commserver.service.system;

import com.kjj.commserver.entity.system.OrgSystemParameter;
import com.kjj.commserver.entity.system.aide.OrgSystemParameterNameEnum;
import com.kjj.core.service.BaseService;

public interface OrgSystemParameterService extends BaseService<OrgSystemParameter, Integer> {
	
	/**
	 * 通过名称查询参数值
	 * @param parametername
	 * @return
	 */
	String queryValueByName(OrgSystemParameterNameEnum parameterName);
	
	/**
	 * 通过名称修改参数值
	 * @param parameterName
	 * @param parameterValue
	 */
	void updateValueByName(OrgSystemParameterNameEnum parameterName,String parameterValue);
	
}