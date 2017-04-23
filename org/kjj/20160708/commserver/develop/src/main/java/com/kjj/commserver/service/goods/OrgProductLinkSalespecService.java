package com.kjj.commserver.service.goods;

import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;
import com.kjj.core.service.BaseService;

public interface OrgProductLinkSalespecService extends BaseService<OrgProductLinkSalespec, Integer> {
	
	/**
	 * spu商品规格信息List
	 * @param goodId 
	 * @return
	 */
	List<OrgProductLinkSalespec> getSpecGroupByGoodsId(Integer goodsId);
	
	/**
	 * sku商品规格信息List
	 * @param itemId 
	 * @return
	 */
	List<OrgProductLinkSalespec> getSpecGroupByItemId(Integer itemId);
	
	/**
	 * 获取商品规格种类
	 * @param goodId
	 * @return
	 */
	List<Map<String,Object>> getSpecTypeByItemId(Integer goodId);
}