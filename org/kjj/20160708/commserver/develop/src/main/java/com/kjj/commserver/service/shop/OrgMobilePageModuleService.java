package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgMobilePageModule;
import com.kjj.core.service.BaseService;

public interface OrgMobilePageModuleService extends BaseService<OrgMobilePageModule, Integer> {
	
	/**
	 * 查询移动店铺模块区
	 * @param pageId
	 * @return
	 */
	List<OrgMobilePageModule> queryByPageId(Integer pageId);
	
	/**
	 * 查询模块区最大排序值
	 */
	Long queryMaxOrder();
	
	/**
	 * 增加模块区
	 */
	void addModule(OrgMobilePageModule orgMobilePageModule);
	
	/**
	 * 更新模块区byId
	 */
	void updateModuleByIdSelective(OrgMobilePageModule orgMobilePageModule);
	
	/**
	 * 删除模块区byId
	 */
	void deleteModuleById(Integer id);
}