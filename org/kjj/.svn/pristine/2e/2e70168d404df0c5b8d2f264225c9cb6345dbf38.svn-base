package com.kjj.commserver.service.discount;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgLimitTimeGoodsService extends BaseService<OrgLimitTimeGoods, Integer> {
	
	/**
	 * 获取限时折扣信息
	 * @param orgUsersSession
	 * @param goodsIds 要查询的goodsId
	 * @param mapItemAide 辅助信息(返回)
	 * @return
	 */
	Map<Integer, OrgLimitTimeGoods> queryMap4View(OrgUsersSession orgUsersSession, Collection<Integer> goodsIds, Map<Integer,OrgProductItemAide> mapItemAide);
	
	/**
	 * 下单时查询并修改限时折扣信息Map
	 * 预先生成OrgLimitTimeRecord记录，如后续订单生成失败删除这些记录
	 * @param orgUsersSession
	 * @param goodsIds 要查询的goodsId
	 * @param mapItemAide 辅助信息(返回)
	 * @return
	 */
	Map<Integer, OrgLimitTimeGoods> updateMap4Buy(OrgUsersSession orgUsersSession, Collection<Integer> goodsIds, Map<Integer,OrgProductItemAide> mapItemAide);


	/**
	 * 找到正序数组中距离sourse最近的且大于sourse的数据
	 * @param arr
	 * @param sourse
	 * @return
	 */
	Long getNearestData(Long[] arr, Long sourse);
	
	/**
	 * 倒计时（活动开始前）
	 * @param goodsIds
	 * @param map
	 * @param flg 是否活动中
	 * @return
	 */
	Map<Integer, Long> getCountDownBeforeAcivity(Collection<Integer> goodsIds,Map<Integer,List<OrgLimitTimeGoods>> map,Boolean flg);
	
	/**
	 * 获得未结束的限时活动
	 * @param orgUsersSession
	 * @param goodsIds
	 * @return
	 */
	Map<Integer,List<OrgLimitTimeGoods>> getLimitTimeGoodsByGoodsIds(OrgUsersSession orgUsersSession, Collection<Integer> goodsIds);

	/**
	 * 根据限时折扣ID和goodsId修改
	 * @param orgLimitTimeGoods
	 */
	int updateByGoodsIdAndLtdId(OrgLimitTimeGoods orgLimitTimeGoods);

}