package com.kjj.commserver.service.discount;

import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgDiscountAllow;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.core.service.BaseService;

public interface OrgDiscountAllowService extends BaseService<OrgDiscountAllow, Integer> {
	
	/***
	 * 载入商品允许的优惠
	 * @param typeId 优惠类型
	 * @param discountId
	 * @param itemAide 辅助信息
	 */
	void loadDiscountAllow(Byte typeId, Integer discountId,OrgProductItemAide itemAide);
	
	/**
	 * 添加优惠适用范围
	 * @param typeId
	 * @param discountId
	 * @param listAllow
	 */
	void addByDiscount(Byte typeId, Integer discountId, List<Byte> listAllow);
	
	/**
	 * 修改优惠适用范围
	 * @param typeId
	 * @param discountId
	 * @param listAllow
	 */
	void updateByDiscount(Byte typeId, Integer discountId, List<Byte> listAllow);
	
	/**
	 * 查询适用优惠范围(以allowTypeId为key)
	 * @param orgDiscountAllow
	 * @return
	 */
	Map<Byte, OrgDiscountAllow> queryMapKeyAllowTypeId(OrgDiscountAllow orgDiscountAllow);
	
	/**
	 * 查询允许同时优惠信息
	 * @param typeId
	 * @param discountId
	 * @return
	 */
	String queryInfo(Byte typeId,Integer discountId);
}