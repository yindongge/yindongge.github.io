package com.kjj.commserver.service.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShopPageFloorProduct;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductVo;
import com.kjj.core.service.BaseService;

public interface OrgShopPageFloorProductService extends BaseService<OrgShopPageFloorProduct, Integer> {
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
	
	/** 获取楼层对应的推荐商品  */
	List<OrgShopPageFloorProduct> queryListRecommandByFloorid(Integer floorId);
	 
	/** 获取楼层对应的普通商品  */
	List<OrgShopPageFloorProduct> queryListCommonByFloorid(Integer floorId);
	
	/**
	 * 获取楼层对应的普通商品，包括商品图片等,只显示有货商品
	 * @param shopCode 
	 * @param floorid
	 * @return
	 */
	List<OrgShopPageFloorProductVo> queryCommCanSailProductByFloor(String shopCode, Integer floorid);
}