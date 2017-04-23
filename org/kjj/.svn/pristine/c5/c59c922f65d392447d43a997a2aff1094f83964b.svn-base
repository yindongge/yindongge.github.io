package com.kjj.commserver.service.goods;

import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.goods.OrgProductInventory;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryVo;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgProductInventoryService extends BaseService<OrgProductInventory, Integer> {
	
	/**
	 * 查询并锁定
	 * @param id
	 * @return
	 */
	OrgProductInventory lockQueryById(Integer id);
	/**
	 * 查询本地库存数据Map
	 * @param orgUsersSession
	 * @param mapItemAide 辅助信息(返回)
	 * @return
	 */
	Map<String,OrgProductInventory> queryMap4View(OrgUsersSession orgUsersSession,Map<Integer,OrgProductItemAide> mapItemAide);
	
	/**
	 * 下单时查询并实时库存数据Map
	 * 查询实时库存，(外卖锁定库存)
	 * @param orgUsersSession
	 * @param mapItemAide 辅助信息(返回)
	 * @return
	 */
	Map<String,OrgProductInventory> lockQueryMap4Buy(OrgUsersSession orgUsersSession,Map<Integer,OrgProductItemAide> mapItemAide);

	/**
	 * 下单后更新本地库存
	 * @param lisCart
	 */
	void updateAfterBuy(List<OrgCartAll> listCartAll);
	
	/**
	 * 下单失败后更新本地库存
	 * @param lisCart
	 */
	void updateAfterCantBuy(List<OrgCartAll> listCartAll);
	
	/***
	 * 同步瑞星库存到本地
	 */
	void syncInventoryFromRuiXing();
	
	/**
	 * 菜品管理查询列表
	 * @param query
	 * @return
	 */
	List<OrgProductInventoryVo> queryMealList(OrgProductInventoryQuery query);
	
	void syncInventoryFromRuiXingTest();
}