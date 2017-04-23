package com.kjj.commserver.service.goods;

import java.util.Collection;
import java.util.List;

import com.kjj.commserver.entity.goods.OrgSaleSpecValue;
import com.kjj.core.service.BaseService;

public interface OrgSaleSpecValueService extends BaseService<OrgSaleSpecValue, Integer> {
	/**
	 * 查询销售规格值
	 * @param saleSpecIds 销售规格id集合
	 * @return
	 */
	List<OrgSaleSpecValue> queryBySaleSpecIds(Collection<Integer> saleSpecIds);
	
	/**
	 * 查询销售规格值
	 * @param saleSpecId 销售规格id
	 * @return
	 */
	List<OrgSaleSpecValue> queryBySaleSpecId(Integer saleSpecId);
	
	/**
	 * 保存或更新规格值
	 * @param saleSpecValue
	 */
	void saveOrUpdate(OrgSaleSpecValue saleSpecValue);
}