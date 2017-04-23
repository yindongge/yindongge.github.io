package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgBusinessArea;
import com.kjj.core.service.BaseService;

public interface OrgBusinessAreaService extends BaseService<OrgBusinessArea, Integer> {

	/**
	 * 根据区号获取商圈信息
	 * @param areaCode
	 * @return
	 */
	List<OrgBusinessArea> queryListByAreaCodeLike(String areaCode);
	/**
	 * 修改商圈信息
	 * @param areaCode
	 * @return
	 */
	void update(OrgBusinessArea businessArea);
}