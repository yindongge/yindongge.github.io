package com.kjj.commserver.service.shop;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgShopForm;
import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.core.service.BaseService;

public interface OrgShopService extends BaseService<OrgShop, Integer> {
	
	/**
	 * 查询分页店铺展示信息
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgShop> selectPageListView(OrgShop query,Pageable pageable);

	/**
	 * 隐藏店铺
	 * @param shopId
	 */
	void updateHide(Integer shopId);

	/**
	 * 显示店铺
	 * @param shopId
	 */
	void updateShow(Integer shopId);
	/**
	 * 添加店铺信息
	 * @param orgShop 
	 * @param sendRangeList 
	 * @param shopServiceList 
	 *  
	 */
	void add(OrgShopForm shopForm);
	/**
	 * 添加店铺信息
	 * @param shopCode
	 */
	
	long queryCountByShopCode(String shopCode);
	/**
	 * 修改店铺信息
	 * @param orgShop 
	 * @param sendRangeList 
	 * @param shopServiceList 
	 *  
	 */
	void update(OrgShopForm shopForm);
	/**
	 * 根据Id查询店铺展示信息
	 * @param id 主键，不能为null
	 */
	OrgShop queryViewVoById(Integer id);
	/**
	 * 根据区号获取门店列表
	 * @param areaCode
	 */
	List<OrgShop>  queryShopListByCode(String areaCode);

	/**
	 * 查询用户有效店铺列表按照距离排序
	 * @param orgLocation
	 * @return
	 */
	List<OrgShop> queryNearbyShopList(OrgLocation orgLocation);
	
	/**
	 * 查询用户有效当前位置最近的店铺
	 * @param orgLocation
	 * @return
	 */
	OrgShop queryNearbyShop(OrgLocation orgLocation);
	
	/**
	 * 将店铺按照区县分组
	 * @param listShop
	 * @return
	 */
	Map<String,List<OrgShop>> getCountyGroupByShopList(List<OrgShop> listShop);
	
	/**
	 * 查询默认店铺
	 * @return
	 */
	OrgShop getDefaultShop();
	/**
	 * 获取所有店铺信息
	 * @return
	 */
	List<OrgShop> queryListAll();
	/**
	 * 获取所有展示店铺信息
	 * @return
	 */
	List<OrgShop> queryListAllShow();
	
	/**
	 * 查询店铺信息供Session使用
	 * @param shopId
	 * @return
	 */
	OrgShop queryVoById4Session(Integer shopId);
}