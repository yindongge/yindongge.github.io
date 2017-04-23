package com.kjj.commserver.service.goods.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kjj.commserver.dao.goods.OrgProductItemDao;
import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.commserver.entity.goods.OrgProduct;
import com.kjj.commserver.entity.goods.OrgProductImg;
import com.kjj.commserver.entity.goods.OrgProductInventory;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductLinkProperty;
import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;
import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductDetailAll;
import com.kjj.commserver.entity.goods.aide.OrgProductImgQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductItemVo;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkPropertyQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkSalespecVo;
import com.kjj.commserver.entity.operation.aide.OrgItemRecommendConstant;
import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgCouponService;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.commserver.service.discount.OrgLimitTimeDiscountService;
import com.kjj.commserver.service.discount.OrgLimitTimeGoodsService;
import com.kjj.commserver.service.discount.OrgReachDiscountService;
import com.kjj.commserver.service.goods.OrgProductImgService;
import com.kjj.commserver.service.goods.OrgProductInventoryService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.goods.OrgProductLinkPropertyService;
import com.kjj.commserver.service.goods.OrgProductLinkSalespecService;
import com.kjj.commserver.service.goods.OrgProductService;
import com.kjj.commserver.service.goods.OrgSaleSpecService;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelCouponService;
import com.kjj.commserver.service.order.OrgGoodsCommentService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgProductItemServiceImpl extends BaseServiceImpl<OrgProductItem, Integer> implements OrgProductItemService {
    @Resource
    private OrgProductItemDao orgProductItemDao;
    @Resource
    private OrgProductInventoryService orgProductInventoryService;
    @Resource
    private OrgLimitTimeGoodsService orgLimitTimeGoodsService;
    @Resource
    private OrgProductLinkSalespecService  orgProductLinkSalespecService;
    @Resource
    private OrgProductLinkPropertyService orgProductLinkPropertyService;
    @Resource
    private OrgSaleSpecService orgSaleSpecService;
    @Resource
    private OrgProductImgService orgProductImgService;
    @Resource
    private OrgGoodsCommentService orgGoodsCommentService;
    @Resource
    private OrgUserLevelCouponService orgUserLevelCouponService;
    @Resource
    private OrgLimitTimeDiscountService orgLimitTimeDiscountService;
    @Resource
    private OrgCouponService orgCouponService;
    @Resource
    private OrgDiscountProductService orgDiscountProductService;
    @Resource
    private OrgProductService orgProductService;
    @Resource
    private OrgReachDiscountService orgReachDiscountService;
    
    @Override
    protected BaseDao<OrgProductItem, Integer> getBaseDao() {
        return orgProductItemDao;
    }
    
    @Override
	public OrgProductItemAll query4View(OrgUsersSession orgUsersSession,Integer goodsId){
    	Collection<Integer> goodsIds = Arrays.asList(goodsId);
    	OrgProductItemQuery itemQuery = new OrgProductItemQuery();
    	itemQuery.setGoodsIds(goodsIds);
    	return queryList4View(orgUsersSession,itemQuery).get(0);
    }
    
    @Override
    public List<OrgProductItemAll> queryList4View(OrgUsersSession orgUsersSession,OrgProductItemQuery itemQuery) {
    	Map<Integer, OrgProductItemAll> mapItemAll = queryMap4View(orgUsersSession,/*null,*/itemQuery);
    	return new ArrayList<OrgProductItemAll>(mapItemAll.values());
    }
    
    @Override
    public Page<OrgProductItemAll> queryPageList4View(OrgUsersSession orgUsersSession,OrgProductItemQuery query, Pageable pageable){
    	Page<OrgProductItemAll> pageItemAll = null;
    	Page<OrgProductItem> pageItem = queryPageList(query,pageable);
    	Set<Integer> goodsIds = new HashSet<Integer>();
    	for (OrgProductItem orgProductItem : pageItem) {
    		goodsIds.add(orgProductItem.getGoodsId());
		}
    	query.setGoodsIds(goodsIds);
    	if(pageItem.hasContent()){
        	pageItemAll = new PageImpl<OrgProductItemAll>(queryList4View(orgUsersSession,query), pageable, pageItem.getTotalElements());
    	}else{
        	pageItemAll = new PageImpl<OrgProductItemAll>(new ArrayList<OrgProductItemAll>(), pageable, pageItem.getTotalElements());
    	}
    	return pageItemAll;
    }
    
    @Override
    public Page<OrgProductItemAll> queryPageList4Recommend(OrgUsersSession orgUsersSession,OrgProductItemQuery query, Pageable pageable){
    	//店铺推荐
    	query.setShopType(OrgItemRecommendConstant.SHOP_TYPE_SHOP);
    	query.setShopId(orgUsersSession.getOrgShop().getShopId());
    	query.setSelectType(OrgProductItemConstant.SELECT_TYPE_YES);
    	long countShop = queryCount(query);
    	if(countShop == 0){
    		//区域推荐
    		query.setShopType(OrgItemRecommendConstant.SHOP_TYPE_CITY);
        	query.setCityCode(orgUsersSession.getOrgShop().getAreaCode());
        	long countCity = queryCount(query);
        	if(countCity == 0){
        		//全部推荐
        		query.setShopType(OrgItemRecommendConstant.SHOP_TYPE_ALL);
        	}
    	}
    	Page<OrgProductItemAll> pageItemAll = null;
    	Page<OrgProductItem> pageItem = queryPageList(query,pageable);
    	if(pageItem.hasContent()){
    		Collection<Integer> goodsIds = new ArrayList<Integer>();
    		for(OrgProductItem item : pageItem.getContent()){
    			goodsIds.add(item.getGoodsId());
    		}
    		OrgProductItemQuery itemQuery = new OrgProductItemQuery();
    		itemQuery.setGoodsIds(goodsIds);
    		pageItemAll = new PageImpl<OrgProductItemAll>(queryList4View(orgUsersSession,itemQuery), pageable, pageItem.getTotalElements());
    	}else{
    		pageItemAll = new PageImpl<OrgProductItemAll>(new ArrayList<OrgProductItemAll>(), pageable, pageItem.getTotalElements());
    	}
    	return pageItemAll;
    }

	@Override
	public Map<Integer, OrgProductItemAll> queryMap4View(OrgUsersSession orgUsersSession, /*Map<Integer,OrgCart> mapCart,*/OrgProductItemQuery itemQuery) {
		//商品信息
		Map<Integer,OrgProductItem> mapItem = queryMap(itemQuery,"goodsId",getSortFormQuery(itemQuery));
		if(MapUtils.isNotEmpty(mapItem)){
			//筛选后的goodsIds
			Collection<Integer> goodsIds = mapItem.keySet();
			//辅助信息
			Map<Integer, OrgProductItemAide> mapItemAide = initMapItemAide(goodsIds,/*mapCart,*/mapItem);
			//库存信息
			Map<String,OrgProductInventory> mapInventory = orgProductInventoryService.queryMap4View(orgUsersSession,mapItemAide);
			//会员级别折扣或价格
			orgUserLevelCouponService.queryMap4View(orgUsersSession, goodsIds, mapItemAide);
			//限时折扣信息
			Map<Integer,OrgLimitTimeGoods> mapLimitTimeGoods = orgLimitTimeGoodsService.queryMap4View(orgUsersSession,goodsIds,mapItemAide);
			return getMapProductItemAll(mapItem,mapInventory,mapLimitTimeGoods,mapItemAide);
		}else{
			return new HashMap<Integer,OrgProductItemAll>();
		}
	}
	
	@Override
	public Map<Integer, OrgProductItemAll> updateMap4Buy(OrgUsersSession orgUsersSession, Collection<Integer> goodsIds/*,Map<Integer,OrgCart> mapCart*/) {
		//商品信息
		OrgProductItemQuery itemQuery = new OrgProductItemQuery();
		itemQuery.setGoodsIds(goodsIds);
		Map<Integer,OrgProductItem> mapItem = queryMap(itemQuery,"goodsId");
		//辅助信息
		Map<Integer, OrgProductItemAide> mapItemAide = initMapItemAide(goodsIds,/*mapCart,*/mapItem);
		//库存信息
		Map<String,OrgProductInventory> mapInventory = orgProductInventoryService.lockQueryMap4Buy(orgUsersSession,mapItemAide);
		//限时折扣信息
		Map<Integer,OrgLimitTimeGoods> mapLimitTimeGoods = null;
		if(isAllowBuy(mapItemAide)){
			//会员级别折扣或价格
			orgUserLevelCouponService.queryMap4View(orgUsersSession, goodsIds, mapItemAide);
			mapLimitTimeGoods = orgLimitTimeGoodsService.updateMap4Buy(orgUsersSession,goodsIds,mapItemAide);
		}
		return getMapProductItemAll(mapItem,mapInventory,mapLimitTimeGoods,mapItemAide);
	}
	
	/**
	 * 获取商品明细信息Map
	 * @param mapItem 商品信息
	 * @param mapInventory 库存信息
	 * @param mapLimitTimeGoods 限时折扣信息
	 * @param mapItemAide 辅助信息
	 * @return
	 */
	private Map<Integer, OrgProductItemAll> getMapProductItemAll(Map<Integer,OrgProductItem> mapItem,
			Map<String,OrgProductInventory> mapInventory,Map<Integer,OrgLimitTimeGoods> mapLimitTimeGoods,
			Map<Integer, OrgProductItemAide> mapItemAide){
		Map<Integer, OrgProductItemAll> mapItemAll = new LinkedHashMap<Integer, OrgProductItemAll>();
		OrgProductItemAll itemAll = null;
		OrgProductInventory inventory = null;
		OrgProductItemAide itemAide = null;
		OrgProductItemVo itemVo = null;
		for (Iterator<OrgProductItem> iterator = mapItem.values().iterator(); iterator.hasNext();) {
			itemVo = (OrgProductItemVo) iterator.next();
			inventory = mapInventory.get(itemVo.getGoodsSn());
			itemAide = mapItemAide.get(itemVo.getGoodsId());
			itemAll = new OrgProductItemAll();
			itemAll.setOrgProductItem(mapItem.get(itemVo.getGoodsId()));
			itemAll.setOrgProductInventory(inventory);
			if(itemVo.getProductIsOnSale() == OrgProductConstant.IS_ON_SALE_ON
					&& itemVo.getProductIsDelete() == OrgProductConstant.IS_NOT_DELETE
					&& inventory != null  && inventory.getSellPrice() != null 
					&& inventory.getShopAmount() != null && inventory.getShopAmount() > 0){
				itemAide.setCanSale(true);
			}
			//展示金额
			itemAide.setShowPrice(itemAide.getRealPrice());
			itemAll.setOrgProductItemAide(mapItemAide.get(itemVo.getGoodsId()));	
			if(mapLimitTimeGoods != null){
				itemAll.setOrgLimitTimeGoods(mapLimitTimeGoods.get(itemVo.getGoodsId()));
			}
			mapItemAll.put(itemVo.getGoodsId(), itemAll);
		}
		return mapItemAll;
	}
	
	/***
	 * 初始化辅助信息
	 * @param goodsIds
	 * @return
	 */
	private Map<Integer, OrgProductItemAide> initMapItemAide(Collection<Integer> goodsIds,/*Map<Integer,OrgCart> mapCart,*/Map<Integer,OrgProductItem> mapItem){
		Map<Integer, OrgProductItemAide> mapItemAide = new HashMap<Integer, OrgProductItemAide>();
		OrgProductItemAide orgProductItemAide = null;
		OrgProductItem orgProductItem = null;
		if(goodsIds==null||goodsIds.size()==0){
			return null;
		}
		
		for(Integer goodsId : goodsIds){
			orgProductItemAide = new OrgProductItemAide(goodsId);
			orgProductItem = mapItem.get(goodsId);
			if (orgProductItem != null) {
				//添加goodsSn
				orgProductItemAide.setGoodsSn(orgProductItem.getGoodsSn());
				//是否菜品
				orgProductItemAide.setMarkMeal(orgProductItem.getCatId() == OrgClassConstant.MEAL_CLASS_ID);
				//是否直营
				orgProductItemAide.setIsDirect(orgProductItem.getIsDirect());
				//设置菜品下单时间15分钟
				if(orgProductItemAide.getMarkMeal()){
					orgProductItemAide.setLimitPayTime((short)15);
				}
			}
			/*//添加用户准备购买数量
			if(mapCart != null){
				orgProductItemAide.setUserBuy(mapCart.get(goodsId).getAmount());
			}*/
			mapItemAide.put(goodsId, orgProductItemAide);
		}
		return mapItemAide;
	}
	
	/**
	 * 是否允许下单
	 * @param mapItemAide
	 * @return
	 */
	public boolean isAllowBuy(Map<Integer,OrgProductItemAide> mapItemAide){
		//是否所有商品都可买
		boolean allCanbuy = true;
		for(OrgProductItemAide itemAide:mapItemAide.values()){
			if(itemAide.getUserBuyMax() < itemAide.getUserBuy()){
				allCanbuy = false;
				break;
			}
		}
		return allCanbuy;
	}

	@Override
	public OrgProductDetailAll queryDetail4View(Integer itemId) {
		
		//sku商品信息
		OrgProductItemQuery queryOne=new OrgProductItemQuery();
		queryOne.setGoodsId(itemId);
		OrgProductItem item = queryOne(queryOne);
		if(StringUtils.isEmpty(item.getGoodsDesc())){
			OrgProduct orgProduct = orgProductService.queryById(item.getParentGoodsId());
			item.setGoodsDesc(orgProduct.getGoodsDesc());
		}
		List<Map<String, Object>> specTypeList = orgProductLinkSalespecService.getSpecTypeByItemId(item.getParentGoodsId());
		OrgProductItemVo itemsVo = (OrgProductItemVo) item;
		itemsVo.setSpecTypeList(specTypeList);
		List<OrgProductLinkSalespec> orgProductLinkItemSalespecList=new ArrayList<OrgProductLinkSalespec>();
		orgProductLinkItemSalespecList = orgProductLinkSalespecService.getSpecGroupByItemId(itemId);
		initSaleSpecAll(orgProductLinkItemSalespecList);
		itemsVo.setOrgProductItemLinkSalespecList(orgProductLinkItemSalespecList);
		
		//spu商品信息
		OrgProductItemQuery queryList=new OrgProductItemQuery();
		queryList.setParentGoodsId(item.getParentGoodsId());
		List<OrgProductItem> itemList = queryList(queryList);
		for (OrgProductItem orgProductItem : itemList) {
			//sku规格信息		
			orgProductLinkItemSalespecList = orgProductLinkSalespecService.getSpecGroupByItemId(orgProductItem.getGoodsId());
			initSaleSpecAll(orgProductLinkItemSalespecList);
			OrgProductItemVo orgProductItemVo = (OrgProductItemVo) orgProductItem;
			orgProductItemVo.setOrgProductItemLinkSalespecList(orgProductLinkItemSalespecList);
		}
		
		//spu规格信息json
		String itemJson = transJson(itemList);
		
		//spu商品属性
		List<OrgProductLinkProperty> orgProductLinkPropertyList = new ArrayList<OrgProductLinkProperty>();
		OrgProductLinkPropertyQuery query=new OrgProductLinkPropertyQuery();
		query.setItemGoodsId(itemId);
		orgProductLinkPropertyList= orgProductLinkPropertyService.queryList(query);

		//商品轮播图片信息
		OrgProductImgQuery orgProductImgQuery=new OrgProductImgQuery();
		//sku没有图片，图片在squ中
		orgProductImgQuery.setItemGoodsId(itemId);
		List<OrgProductImg> orgProductImgList = orgProductImgService.queryList(orgProductImgQuery);
		
		//全部商品
		OrgProductDetailAll orgProductDetailAll=new OrgProductDetailAll();
		orgProductDetailAll.setOrgProductItem(item);
		orgProductDetailAll.setOrgProductItems(itemList);
		orgProductDetailAll.setOrgProductLinkPropertyList(orgProductLinkPropertyList);
		orgProductDetailAll.setItemJson(itemJson);
		orgProductDetailAll.setOrgProductImgList(orgProductImgList);
		return orgProductDetailAll;
	}

	//将信息转成json
	private String transJson(List<OrgProductItem> itemList) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (OrgProductItem orgProductItem : itemList) {
			map = new HashMap<String, Object>();
			OrgProductItemVo itemVo = (OrgProductItemVo) orgProductItem;
			map.put("itemId", itemVo.getGoodsId());
			map.put("skuSpecList", itemVo.getOrgProductItemLinkSalespecList());
			list.add(map);
		}
		String itemJson = new Gson().toJson(list);
		return itemJson;
	}
	
	//添加商品分类信息
	@Override
	public void initSaleSpecAll(List<OrgProductLinkSalespec> productItemLinkSalespecList) {
		for (OrgProductLinkSalespec orgProductLinkSalespec : productItemLinkSalespecList) {
			initSaleSpec(orgProductLinkSalespec);
		}
	}

	private void initSaleSpec(OrgProductLinkSalespec orgProductLinkSalespec) {
		OrgProductLinkSalespecVo orgProductLinkSalespecVo = (OrgProductLinkSalespecVo) orgProductLinkSalespec;
		OrgSaleSpec orgSaleSpec = new OrgSaleSpec();
		Short specId = orgProductLinkSalespecVo.getSpecId();
		int specIdInt=specId;
		orgSaleSpec= orgSaleSpecService.queryVoById(specIdInt);
		orgProductLinkSalespecVo.setSpecName(orgSaleSpec.getSpecName());
	}

	@Override
	public Sort getSortFormQuery(OrgProductItemQuery query ) {
		Direction direct = Direction.DESC;
		//pc
	    if(StringUtils.isNotEmpty(query.getOrderDirection())){
	    	direct = Direction.fromString(query.getOrderDirection());	    	
	    }
		String orderType=query.getOrderType();
		//wx
		if(StringUtils.contains(orderType,"-")){
			orderType=orderType.replace("-", "");
			direct=Direction.ASC;
		}
		String orderTypeStr="t.click_count";
		if(orderType!=null){
			switch (orderType) {
			case "2":
				orderTypeStr="t.sale_num";
				break;
			case "3":
				orderTypeStr="opi.sell_price";
				break;
			case "4":
				orderTypeStr="t.comment_num";
				break;
			case "5":
				orderTypeStr="t.goods_id";
				break;
			default:
				orderTypeStr="t.click_count";
				break;
			}
		}
		return new Sort(direct,orderTypeStr);
	}

	@Override
	public OrgProductItem queryByGoodsSnValid(String goodsSn) {
		OrgProductItemQuery query = new OrgProductItemQuery();
		query.setGoodsSn(goodsSn);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		return queryOne(query);
	}

	@Override
	public long updateSaleNumAndCommentNum() {
		return orgProductItemDao.updateSaleNumAndCommentNum();
	}
	
	@Override
	public List<OrgProductItem> queryListByReachDiscountId(Integer reachDiscountId, OrgUsersSession orgUsersSession){
		OrgProductItemQuery query = new OrgProductItemQuery();
		query.setReachDiscountId(reachDiscountId);
		query.setSelectType(OrgProductItemConstant.SELECT_TYPE_YES);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		query.setIsShowZeroInventoryFlg(true);
		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		return queryList(query);
	}

	@Override
	public void updateReachGive4Buy(OrgUsersSession orgUsersSession, List<OrgCartAll> listCartAll,Map<Integer,Integer> mapGoodsGive) {
		Map<Integer,OrgCartAll> mapCartAllGive = new HashMap<Integer,OrgCartAll>();
		OrgCartAll cartAllGive = null;
		OrgCart cartGive = null;
		OrgProductItemAll productItemAllGive = null;
		OrgProductInventory productInventoryGive = null;
		OrgProductItemAide productItemAideGive = null;
		//购物车已存在赠品
		for(OrgCartAll cartAll : listCartAll){
			if(mapGoodsGive.keySet().contains(cartAll.getOrgCart().getGoodsId())){
				cartAllGive = new OrgCartAll();
				cartGive = new OrgCart();
				cartGive.setGoodsId(cartAll.getOrgCart().getGoodsId());
				cartGive.setGoodsSn(cartAll.getOrgCart().getGoodsSn());
				productItemAllGive = new OrgProductItemAll();
				productItemAllGive.setOrgProductItem(cartAll.getOrgProductItemAll().getOrgProductItem());
				productInventoryGive = new OrgProductInventory();
				productInventoryGive.setId(cartAll.getOrgProductItemAll().getOrgProductInventory().getId());
				productInventoryGive.setShopAmount(cartAll.getOrgProductItemAll().getOrgProductInventory().getShopAmount()-cartAll.getOrgCart().getAmount());
				productItemAllGive.setOrgProductInventory(productInventoryGive);
				if(productInventoryGive.getShopAmount() < mapGoodsGive.get(cartGive.getGoodsId())){
					cartGive.setAmount(productInventoryGive.getShopAmount());
				}else{
					cartGive.setAmount(mapGoodsGive.get(cartGive.getGoodsId()));
				}
				cartAllGive.setOrgCart(cartGive);
				productItemAideGive = new OrgProductItemAide(cartGive.getGoodsId());
				productItemAideGive.setGoodsId(cartGive.getGoodsId());
				productItemAideGive.setGoodsSn(cartGive.getGoodsSn());
				productItemAideGive.setSourcePrice(BigDecimal.ZERO);
				productItemAideGive.setRealPrice(BigDecimal.ZERO);
				productItemAideGive.setUserBuy(cartGive.getAmount());
				productItemAllGive.setOrgProductItemAide(productItemAideGive);
				cartAllGive.setOrgProductItemAll(productItemAllGive);
				if(cartGive.getAmount() > 0){
					mapCartAllGive.put(cartGive.getGoodsId(), cartAllGive);
				}
				mapGoodsGive.remove(cartGive.getGoodsId());
			}
		}
		
		
		//购物车不存在赠品
		if(MapUtils.isNotEmpty(mapGoodsGive)){
			//商品信息
			OrgProductItemQuery itemQuery = new OrgProductItemQuery();
			itemQuery.setGoodsIds(mapGoodsGive.keySet());
			Map<Integer,OrgProductItem> mapItem = queryMap(itemQuery,"goodsId");
			//辅助信息
			Map<Integer, OrgProductItemAide> mapItemAide = initMapItemAide(mapGoodsGive.keySet(),mapItem);
			//库存信息
			Map<String,OrgProductInventory> mapInventory = orgProductInventoryService.lockQueryMap4Buy(orgUsersSession,mapItemAide);
			Map<Integer, OrgProductItemAll> mapProductItemAll = getMapProductItemAll(mapItem,mapInventory,null,mapItemAide);
			for(Integer goodsId : mapGoodsGive.keySet()){
				cartAllGive = new OrgCartAll();
				cartAllGive.setOrgProductItemAll(mapProductItemAll.get(goodsId));
				cartGive = new OrgCart();
				cartGive.setGoodsId(goodsId);
				productItemAideGive = mapProductItemAll.get(goodsId).getOrgProductItemAide();
				cartGive.setGoodsSn(productItemAideGive.getGoodsSn());
				
				if(mapProductItemAll.get(goodsId).getOrgProductInventory().getShopAmount() < mapGoodsGive.get(goodsId)){
					cartGive.setAmount(mapProductItemAll.get(goodsId).getOrgProductInventory().getShopAmount());
				}else{
					cartGive.setAmount(mapGoodsGive.get(goodsId));
				}
				cartAllGive.setOrgCart(cartGive);
				productItemAideGive.setSourcePrice(BigDecimal.ZERO);
				productItemAideGive.setRealPrice(BigDecimal.ZERO);
				productItemAideGive.setUserBuy(cartGive.getAmount());
				if(cartGive.getAmount() > 0){
					mapCartAllGive.put(cartGive.getGoodsId(), cartAllGive);
				}
			}
		}
		
		//添加所有赠品
		listCartAll.addAll(mapCartAllGive.values());
	}
}