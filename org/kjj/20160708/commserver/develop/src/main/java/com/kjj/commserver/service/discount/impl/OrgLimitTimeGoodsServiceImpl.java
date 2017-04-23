package com.kjj.commserver.service.discount.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgLimitTimeGoodsDao;
import com.kjj.commserver.entity.discount.OrgLimitTimeDiscount;
import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeDiscountConstant;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeGoodsQuery;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeGoodsVo;
import com.kjj.commserver.entity.goods.OrgProductInventory;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.commserver.service.discount.OrgLimitTimeDiscountService;
import com.kjj.commserver.service.discount.OrgLimitTimeGoodsService;
import com.kjj.commserver.service.discount.OrgLimitTimeRecordService;
import com.kjj.commserver.service.goods.OrgProductInventoryService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.util.DateUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgLimitTimeGoodsServiceImpl extends BaseServiceImpl<OrgLimitTimeGoods, Integer> implements OrgLimitTimeGoodsService {
    @Resource
    private OrgLimitTimeGoodsDao orgLimitTimeGoodsDao;
    @Resource
    private OrgLimitTimeRecordService orgLimitTimeRecordService;
    @Resource
    private OrgDiscountAllowService orgDiscountAllowService;
    @Resource
    private OrgProductItemService orgProductItemService;
    @Resource
    private OrgProductInventoryService orgProductInventoryService;
    @Resource
    private OrgLimitTimeDiscountService orgLimitTimeDiscountService;

    @Override
    protected BaseDao<OrgLimitTimeGoods, Integer> getBaseDao() {
        return orgLimitTimeGoodsDao;
    }
    
    @Override
    public void add(OrgLimitTimeGoods orgLimitTimeGoods){
    	if(StringUtils.isBlank(orgLimitTimeGoods.getGoodsTitle())){
			orgLimitTimeGoods.setGoodsTitle(null);
		}
    	super.add(orgLimitTimeGoods);
    }
    
    @Override
	public Map<Integer, OrgLimitTimeGoods> queryMap4View(OrgUsersSession orgUsersSession, Collection<Integer> goodsIds,Map<Integer,OrgProductItemAide> mapItemAide) {
		return queryMap4ViewOrBuy(orgUsersSession,goodsIds,mapItemAide,false);
	}

	@Override
	public Map<Integer, OrgLimitTimeGoods> updateMap4Buy(OrgUsersSession orgUsersSession, Collection<Integer> goodsIds,Map<Integer, OrgProductItemAide> mapItemAide) {
		return queryMap4ViewOrBuy(orgUsersSession,goodsIds,mapItemAide,true);
	}
	
	/**
	 * 
	 * @param orgUsersSession
	 * @param goodsIds
	 * @param mapItemAide
	 * @param forBuy
	 * @return
	 */
	private Map<Integer, OrgLimitTimeGoods> queryMap4ViewOrBuy(OrgUsersSession orgUsersSession, Collection<Integer> goodsIds,Map<Integer,OrgProductItemAide> mapItemAide, boolean forBuy) {
		Map<Integer, OrgLimitTimeGoods> mapLimitTimeGoods = queryMapNow(orgUsersSession,goodsIds,forBuy);
		OrgLimitTimeGoodsVo limitTimeGoods = null;
		OrgProductItemAide itemAide = null;
		int shopLast = 0;
		int userLast = 0;
		for(Integer goodsId : goodsIds){
			limitTimeGoods = (OrgLimitTimeGoodsVo) mapLimitTimeGoods.get(goodsId);
			if(limitTimeGoods != null){
				itemAide = mapItemAide.get(goodsId);
				//无价商品
				if(itemAide.getRealPrice() == null ){
					continue;
				}
				//设置金额折扣转换,失败跳过
				if(!changeDiscountPrice(limitTimeGoods,itemAide)){
					continue;
				}
				//店铺还有剩余数量,限时折扣进行中
				if(limitTimeGoods.getShopNum() == null || limitTimeGoods.getShopNum() > limitTimeGoods.getShopBuyNum()){
					//限时折扣和会员折扣进行对比，选择价低的
					if(itemAide.getMarkUserLevelDiscount() && itemAide.getUserLevelPrice().compareTo(limitTimeGoods.getPrice()) < 0){
						continue;
					}
					//限时折扣进行中
					itemAide.setMarkLimitTimeDiscount(true);
					//设置支付限制时长
					if(itemAide.getLimitPayTime() == null 
							|| (limitTimeGoods.getOrgLimitTimeDiscount().getSeckillTimeLength() != null 
								&& itemAide.getLimitPayTime().compareTo(limitTimeGoods.getOrgLimitTimeDiscount().getSeckillTimeLength()) > 0)){
						itemAide.setLimitPayTime(limitTimeGoods.getOrgLimitTimeDiscount().getSeckillTimeLength());
					}
					//设置当前金额
					itemAide.setRealPrice(limitTimeGoods.getPrice());
					//修改数量限制
					if( limitTimeGoods.getUserBuyNum() == null){
						//未登录用户
						//用户数量不限
						if(limitTimeGoods.getShopNum() == null){
							//店铺不限
							if(limitTimeGoods.getUserNum() == null){
								//用户不限量
								//使用原库存
							}else{
								//用户数量限制
								userLast = limitTimeGoods.getUserNum();
								itemAide.setUserBuyMax(userLast < itemAide.getUserBuyMax() ? userLast : itemAide.getUserBuyMax());
							}
						}else if(limitTimeGoods.getShopNum() > limitTimeGoods.getShopBuyNum()){
							//店铺限量
							shopLast = limitTimeGoods.getShopNum()-limitTimeGoods.getShopBuyNum();
							if(limitTimeGoods.getUserNum() == null){
								//用户不限量
								userLast = shopLast;
							}else{
								//用户数量限制
								userLast = limitTimeGoods.getUserNum();
								userLast = shopLast < userLast ? shopLast : userLast;
							}
							itemAide.setUserBuyMax(userLast < itemAide.getUserBuyMax() ? userLast : itemAide.getUserBuyMax());
							
						}
					}else if(limitTimeGoods.getOrgLimitTimeDiscount().getCheckPhone() == OrgLimitTimeDiscountConstant.CHECK_PHONE_YES && StringUtils.isBlank(orgUsersSession.getOrgUsers().getMobilePhone())){
						itemAide.setUserBuyMax(0);
					}else if(limitTimeGoods.getUserNum() == null){
						//用户数量不限
						if(limitTimeGoods.getShopNum() == null){
							//店铺不限
							//使用原库存
						}else if(limitTimeGoods.getShopNum() > limitTimeGoods.getShopBuyNum()){
							//店铺限量
							shopLast = limitTimeGoods.getShopNum()-limitTimeGoods.getShopBuyNum();
							itemAide.setUserBuyMax(shopLast < itemAide.getUserBuyMax() ? shopLast : itemAide.getUserBuyMax());
						}
					}else if(limitTimeGoods.getUserNum() > limitTimeGoods.getUserBuyNum()){
						//用户数量限制
						userLast = limitTimeGoods.getUserNum()-limitTimeGoods.getUserBuyNum();
						if(limitTimeGoods.getShopNum() == null){
							//店铺不限
						}else if(limitTimeGoods.getShopNum() > limitTimeGoods.getShopBuyNum()){
							//店铺限量
							shopLast = limitTimeGoods.getShopNum()-limitTimeGoods.getShopBuyNum();
							userLast = shopLast < userLast ? shopLast : userLast;
						}
						
						itemAide.setUserBuyMax(userLast < itemAide.getUserBuyMax() ? userLast : itemAide.getUserBuyMax());
					}else{
						itemAide.setUserBuyMax(0);
					}
					//设置其他优惠能否一起进行
					orgDiscountAllowService.loadDiscountAllow(OrgDiscountTypeConstant.TYPE_LIMIT_TIME_DISCOUNT,limitTimeGoods.getLtdId(),itemAide);
				}
				
			}
		}
		return mapLimitTimeGoods;
	}
	
	/**
	 * 查询正在进行的限时折扣
	 * @param orgUsersSession
	 * @param goodsIds
	 * @return
	 */
	private Map<Integer, OrgLimitTimeGoods> queryMapNow(OrgUsersSession orgUsersSession, Collection<Integer> goodsIds, boolean forUpdate) {
		OrgLimitTimeGoodsQuery query = new OrgLimitTimeGoodsQuery();
		query.setQuery4User(true);
		query.setGoodsIds(goodsIds);
		query.setTimeType(OrgLimitTimeDiscountConstant.TIME_TYPE_TIME);
		query.setOrgUsersSession(orgUsersSession);
		query.setStatus(OrgLimitTimeDiscountConstant.STATUS_VALID);
		query.setForUpdate(forUpdate);
		return queryMap(query,"goodsId");
	}
	
	/**
	 * 设置金额折扣转换,如果折扣金额大于原价返回false
	 * @param limitTimeGoods
	 * @param itemAide
	 */
	private boolean changeDiscountPrice(OrgLimitTimeGoods limitTimeGoods,OrgProductItemAide itemAide){
		if (limitTimeGoods != null) {
			//限时折扣取原价进行换算
			if(itemAide.getSourcePrice() != null){
				if(limitTimeGoods.getDiscount() != null){
					limitTimeGoods.setPrice(itemAide.getSourcePrice().multiply(BigDecimal.valueOf(limitTimeGoods.getDiscount())).divide(BigDecimal.valueOf(100),2,BigDecimal.ROUND_HALF_UP));
					return true;
				}else if(limitTimeGoods.getPrice() != null){
					if(itemAide.getSourcePrice().compareTo(limitTimeGoods.getPrice()) >= 0){
						limitTimeGoods.setDiscount(itemAide.getSourcePrice().divide(itemAide.getSourcePrice(),2,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100)).byteValue());
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Long getNearestData(Long[] arr, Long sourse) {
		if(ArrayUtils.isEmpty(arr)){
			return null;
		}
		Arrays.sort(arr);
		Long target = 0l;
		if (sourse < arr[0]) {
			target = arr[0];
		} else if (sourse > arr[arr.length - 1]) {
			return null;
		} else {
			int i = Arrays.binarySearch(arr, sourse);
			if (i < 0) {
				i = -i - 1;
			}
			target = arr[i];
		}
		return target;
	}

	@Override
	public Map<Integer, Long> getCountDownBeforeAcivity(Collection<Integer> goodsIds,Map<Integer,List<OrgLimitTimeGoods>> OrgLimitTimeGoodsMap) {
		Map<Integer, Long> map=new HashMap<Integer, Long>();
		List<OrgLimitTimeGoods> list=null;
		long countDownTime=0l;
		//获得今天的日期
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		List<Long> startmslist= new ArrayList<Long>();
		List<Long> startTimemslist= new ArrayList<Long>();
		List<Long> endTimemslist= new ArrayList<Long>();
		for(Integer goodsId : goodsIds){
			list = OrgLimitTimeGoodsMap.get(goodsId);
			if(CollectionUtils.isNotEmpty(list)){
				//数据库时间
				OrgLimitTimeGoodsVo oltgVoTmp=(OrgLimitTimeGoodsVo) list.get(0);
				Long dbms=oltgVoTmp.getDbDate().getTime();
				Boolean flg=false;
				for (OrgLimitTimeGoods oltg : list) {
					OrgLimitTimeGoodsVo oltgVo = (OrgLimitTimeGoodsVo)oltg;
					OrgLimitTimeDiscount oltd = oltgVo.getOrgLimitTimeDiscount();
					//每个活动的开始时间
					//时间戳是自 1970 年 1 月 1 日（08:00:00 GMT）至当前时间的总秒数。它也被称为 Unix 时间戳（Unix Timestamp）
					Long startms=oltd.getStartDate().getTime()+oltd.getStartTime().getTime()+28800000; 
					Long startTimems=DateUtil.getDateByTime(oltd.getStartTime()).getTime(); 
					Long endTimems=DateUtil.getDateByTime(oltd.getEndTime()).getTime(); 
					if(startTimems<dbms && endTimems>dbms){
						//活动正在进行
						flg=true;
						break;
					}
					if(oltgVo != null){
						//所有活动的开始时间
						startmslist.add(startms);
						if(startms<dbms || oltd.getStartDate().compareTo(c.getTime())==0){
							//将已经开始或今天开始的活动纳入计算
							startTimemslist.add(startTimems);
							endTimemslist.add(endTimems);							
						}
					}
				}
				//活动没有进行
				if(!flg){
					//所有开始时间正序排序，当前时间和最小开始时间比较
					Collections.sort(startmslist);
					if(dbms<startmslist.get(0)){
						//所有活动还没开始
						countDownTime=startmslist.get(0)-dbms;
						//map.put("ltdId", getLtdIdByms(startmslist.get(0)));
						
					}else{
						//活动期间，没有活动的时间段
						Long[] startmsArr = (Long[])startTimemslist.toArray(new Long[startTimemslist.size()]);
						Long nearestStartms = getNearestData(startmsArr,dbms);
						if(nearestStartms!=null){
							//今天还有活动
							countDownTime=nearestStartms-dbms;
						}else{
							//今天没有后续活动，倒计时到第二天的第一个活动开始时间
							Collections.sort(startTimemslist);
							countDownTime=86400000-dbms+startTimemslist.get(0);
						}
					}
				}
				
			}
			map.put(goodsId, countDownTime);
		}
		 return map;
	}

	@Override
	public Map<Integer,List<OrgLimitTimeGoods>> getLimitTimeGoodsByGoodsIds( OrgUsersSession orgUsersSession, Collection<Integer> goodsIds) {
		Map<Integer,List<OrgLimitTimeGoods>> map =new HashMap<Integer,List<OrgLimitTimeGoods>>();
		OrgLimitTimeGoodsQuery query = new OrgLimitTimeGoodsQuery();
		List<OrgLimitTimeGoods> list =null;
		OrgProductItemAide itemAide=null;
		//设置店铺等相关信息
		query.setQuery4User(true);
		//设置endDateTime大于当前时间
		query.setTimeType(OrgLimitTimeDiscountConstant.TIME_TYPE_NOT_END);
		//设置活动有效
		query.setStatus(OrgLimitTimeDiscountConstant.STATUS_VALID);
		query.setOrgUsersSession(orgUsersSession);
		for(Integer goodsId : goodsIds){
			query.setGoodsId(goodsId);
			list = queryList(query);
			OrgProductItem orgProductItem = orgProductItemService.queryVoById(goodsId);
			itemAide = new OrgProductItemAide(goodsId);
			OrgProductInventoryQuery orgProductInventoryQuery = new OrgProductInventoryQuery();
			orgProductInventoryQuery.setGoodsSn(orgProductItem.getGoodsSn());
			orgProductInventoryQuery.setShopCode(orgUsersSession.getOrgShop().getShopCode());
			OrgProductInventory inventory = orgProductInventoryService.queryOne(orgProductInventoryQuery);
			boolean flg = true;
			if(inventory != null){
				itemAide.setSourcePrice(inventory.getSourcePrice());
				for (OrgLimitTimeGoods orgLimitTimeGoods : list) {
					//商品价格有误，将该商品从活动中移除
					flg = changeDiscountPrice(orgLimitTimeGoods,itemAide);	
					if(!flg){
						list.remove(orgLimitTimeGoods);	
					}
				}
			}
			map.put(goodsId, list);
		}
		return map;
	}

	@Override
	public int updateByGoodsIdAndLtdId(OrgLimitTimeGoods orgLimitTimeGoods) {
		if(StringUtils.isBlank(orgLimitTimeGoods.getGoodsTitle())){
			orgLimitTimeGoods.setGoodsTitle(null);
		}
		return orgLimitTimeGoodsDao.updateByGoodsIdAndLtdId(orgLimitTimeGoods);
	}
}