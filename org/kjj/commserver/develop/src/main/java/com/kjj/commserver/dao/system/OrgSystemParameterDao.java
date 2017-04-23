package com.kjj.commserver.dao.system;

import com.kjj.commserver.entity.system.OrgSystemParameter;
import com.kjj.core.dao.BaseDao;

public interface OrgSystemParameterDao extends BaseDao<OrgSystemParameter, Integer> {

	/**
	 * 根据parameterName更新
	 * @param orgSystemParameter
	 */
	int updateByName(OrgSystemParameter orgSystemParameter);
}