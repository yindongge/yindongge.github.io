package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.core.service.BaseService;

public interface OrgAreaService extends BaseService<OrgArea, String> {

	
	/**
	 * 获取省地址
	 * @param level
	 * @return
	 */
	List<OrgArea> queryListProvince();
	/**
	 * 获取下一级地址
	 * @param level
	 * @return
	 */
	List<OrgArea> queryListByParentCode(String parentCode);
	
	/**
	 * 设置省市县查询条件
	 * @return
	 */
	String getSearchCode(String areaCode);
	
	/**
	 * 通过等级查询
	 * @param level
	 * @return
	 */
	List<OrgArea> queryListByLevel(Byte level);
}