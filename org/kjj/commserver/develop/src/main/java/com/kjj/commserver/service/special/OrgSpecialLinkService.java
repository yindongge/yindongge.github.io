package com.kjj.commserver.service.special;

import java.util.List;

import com.kjj.commserver.entity.special.OrgSpecialLink;
import com.kjj.core.service.BaseService;

public interface OrgSpecialLinkService extends BaseService<OrgSpecialLink, Integer> {
	
	/**
	 * 新增或更新链接表
	 * @param orgSpecialLink
	 */
	void save(OrgSpecialLink orgSpecialLink);
	
	
	void saveAllAnchor(Integer specialId,List<OrgSpecialLink> orgSpecialLinkList);
	
	/**
	 * 根据specialId查询最大排序
	 * @param specialId
	 * @return
	 */
	Integer selectMaxOrder(Integer specialId);
	
}