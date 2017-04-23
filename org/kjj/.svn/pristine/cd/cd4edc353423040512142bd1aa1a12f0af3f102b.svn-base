package com.kjj.commserver.service.system;

import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.system.OrgModel;
import com.kjj.core.service.BaseService;

public interface OrgModelService extends BaseService<OrgModel, Integer> {
	
	/**
	 * 获取子菜单
	 * @param parentId
	 * @return
	 */
	public List<OrgModel> queryListByParentId(Integer parentId);
	
	/**
	 * 获取用户所有菜单
	 * @param parentId
	 * @return
	 */
	public Map<Integer,OrgModel> queryMapByUserId(Short userId);
	
	/**
	 * 获取菜单
	 * @param Integer parentId
	 * @return
	 */
	public List<OrgModel> queryTreeByParentId(Integer parentId);
}