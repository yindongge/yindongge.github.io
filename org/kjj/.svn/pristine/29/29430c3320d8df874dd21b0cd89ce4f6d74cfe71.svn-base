package com.kjj.commserver.dao.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShopPageFloorProduct;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductVo;
import com.kjj.core.dao.BaseDao;

public interface OrgShopPageFloorProductDao extends BaseDao<OrgShopPageFloorProduct, Integer> {
	/**
	 * 获取楼层对应的普通商品，包括商品图片等
	 * @param floorid
	 * @return
	 */
	List<OrgShopPageFloorProductVo> queryCommProductByFloor(Integer floorid);
	
	/**
	 * 获取楼层对应的推荐商品，包括商品图片等
	 * @param floorid
	 * @return
	 */
	List<OrgShopPageFloorProductVo> queryRecommandProductByFloor(Integer floorid);
	
	/**
	 * 获取楼层对应的普通商品，包括商品图片等,只显示有货商品
	 * @param query
	 * @return
	 */
	List<OrgShopPageFloorProductVo> queryCanSailList(OrgShopPageFloorProductQuery query);
}