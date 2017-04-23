package com.kjj.commserver.service.goods.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgProductInventoryDao;
import com.kjj.commserver.entity.goods.OrgProductInventory;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryVo;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.swap.Org_RX_Product;
import com.kjj.commserver.entity.system.aide.OrgSystemParameterNameEnum;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.exception.swap.RxException;
import com.kjj.commserver.service.goods.OrgProductInventoryService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.swap.RxProductService;
import com.kjj.commserver.service.system.OrgSystemParameterService;
import com.kjj.commserver.util.DateFormatUtil;
import com.kjj.commserver.util.DateParseUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import com.kjj.ruixing.entity.goods.Basplustock;
import com.kjj.ruixing.entity.goods.aide.BasplustockVo;
import com.kjj.ruixing.service.goods.BasplustockService;

@Service
public class OrgProductInventoryServiceImpl extends BaseServiceImpl<OrgProductInventory, Integer> implements OrgProductInventoryService {
	
	private Logger logger = LoggerFactory.getLogger(OrgProductInventoryServiceImpl.class);
	
    @Resource
    private OrgProductInventoryDao orgProductInventoryDao;
    @Resource
    private RxProductService rxProductService;
    @Resource
    private BasplustockService basplustockService;
    @Resource
    private OrgShopService orgShopService;
    @Resource
    private OrgProductItemService orgProductItemService;
    @Resource
    private OrgSystemParameterService orgSystemParameterService;

    @Override
    protected BaseDao<OrgProductInventory, Integer> getBaseDao() {
        return orgProductInventoryDao;
    }
    
    @Override
    public OrgProductInventory lockQueryById(Integer id){
    	return orgProductInventoryDao.selectById4Update(id);
    }

	@Override
	public Map<String, OrgProductInventory> queryMap4View(OrgUsersSession orgUsersSession, Map<Integer,OrgProductItemAide> mapItemAide) {
		Map<String, OrgProductInventory> mapInventory = queryMap(orgUsersSession,getGoodsSns(mapItemAide));
		setItemAideMap(mapInventory,mapItemAide);
		return mapInventory;
	}
	
	@Override
	public Map<String, OrgProductInventory> lockQueryMap4Buy(OrgUsersSession orgUsersSession, Map<Integer,OrgProductItemAide> mapItemAide) {
		Map<String, OrgProductInventory> mapInventory = lockQueryRealInventoryMap(orgUsersSession,getGoodsSns(mapItemAide),mapItemAide);
		setItemAideMap(mapInventory,mapItemAide);
		return mapInventory;
	}
	
	/**
	 * 查询本地库存Map
	 * @param orgUsersSession
	 * @param goodsIds
	 * @return
	 */
	private Map<String, OrgProductInventory> queryMap(OrgUsersSession orgUsersSession, Collection<String> goodsSns){
		OrgProductInventoryQuery query = new OrgProductInventoryQuery();
		query.setGoodsSns(goodsSns);
		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		return queryMap(query,"goodsSn");
	}
	
	/**
	 * 设置辅助信息
	 * @param mapInventory
	 * @param mapItemAide
	 */
	private void setItemAideMap(Map<String, OrgProductInventory> mapInventory,Map<Integer,OrgProductItemAide> mapItemAide){
		if(MapUtils.isNotEmpty(mapItemAide)){
			OrgProductInventory inventory = null;
			for(OrgProductItemAide itemAide : mapItemAide.values()){
				inventory = mapInventory.get(itemAide.getGoodsSn());
				if(inventory != null){
					itemAide.setUserBuyMax(inventory.getShopAmount());
					itemAide.setSourcePrice(inventory.getSourcePrice());
					itemAide.setRealPrice(inventory.getSellPrice());
				}
			}
		}
	}
	
	/**
	 * 获取GoodsSn集合
	 * @param mapItemAide
	 */
	private Collection<String> getGoodsSns(Map<Integer,OrgProductItemAide> mapItemAide){
		Collection<String> goodsSns = new ArrayList<String>();
		for(OrgProductItemAide itemAide :mapItemAide.values()){
			goodsSns.add(itemAide.getGoodsSn());
		}
		return goodsSns;
	}
	
	/***
	 * 查询实时库存（外卖锁定库存）
	 * @param orgUsersSession
	 * @param mapItemAide
	 * @return
	 */
	private Map<String, OrgProductInventory> lockQueryRealInventoryMap(OrgUsersSession orgUsersSession,Collection<String> goodsSns,Map<Integer,OrgProductItemAide> mapItemAide) {
		Map<String, OrgProductInventory> mapInventory = queryMap(orgUsersSession,goodsSns);
		//锁定库存
		for(OrgProductItemAide itemAide:mapItemAide.values()){
			if (itemAide.getIsDirect() == OrgProductItemConstant.IS_DIRECT_NO) {
				//联营商品使用本地库存锁定库存
				mapInventory.put(itemAide.getGoodsSn(), lockQueryById(mapInventory.get(itemAide.getGoodsSn()).getId()));
			}
		}
		Map<String, Org_RX_Product> mapProduct = rxProductService.getRxInventoryMap(orgUsersSession,mapItemAide);
		OrgProductInventory inventory = null;
		Org_RX_Product rxProduct = null;
		for(OrgProductItemAide itemAide:mapItemAide.values()){
			inventory = mapInventory.get(itemAide.getGoodsSn());
			//直营商品瑞星获取实时库存
			if (itemAide.getIsDirect() == OrgProductItemConstant.IS_DIRECT_YES) {
				inventory.setGoodsSn(itemAide.getGoodsSn());
				inventory.setShopCode(orgUsersSession.getOrgShop().getShopCode());
				rxProduct = mapProduct.get(itemAide.getGoodsSn());
				if(rxProduct != null){
					inventory.setShopAmount(rxProduct.getCount());
					inventory.setWarehouseAmount(rxProduct.getWarehouse_num());
					inventory.setSourcePrice(rxProduct.getSourcePrice());
					inventory.setSellPrice(rxProduct.getShopPrice());
				}else{
					throw new RxException("ruixing query real inventory fail goodsSn = " + itemAide.getGoodsSn() + ",shopCode = " + orgUsersSession.getOrgShop().getShopCode());
				}
				mapInventory.put(itemAide.getGoodsSn(), inventory);
			}
		}
		return mapInventory;
	}
	
	@Override
	public void updateAfterBuy(List<OrgCartAll> listCartAll) {
		List<OrgProductInventory> listInventory = new ArrayList<OrgProductInventory>();
		OrgProductInventory productInventory = null;
		for(OrgCartAll cartAll : listCartAll){
			productInventory =  cartAll.getOrgProductItemAll().getOrgProductInventory();
			productInventory.setShopAmount(productInventory.getShopAmount() - cartAll.getOrgProductItemAll().getOrgProductItemAide().getUserBuy());
			listInventory.add(productInventory);
		}
		//更新本地库存
		updateInBatch(listInventory);
	}
	
	@Override
	public void updateAfterCantBuy(List<OrgCartAll> listCartAll) {
		List<OrgProductInventory> listInventory = new ArrayList<OrgProductInventory>();
		OrgProductInventory productInventory = null;
		for(OrgCartAll cartAll : listCartAll){
			productInventory =  cartAll.getOrgProductItemAll().getOrgProductInventory();
			listInventory.add(productInventory);
		}
		//更新本地库存
		updateInBatch(listInventory);
	}

	@Override
	public void syncInventoryFromRuiXing() {
		// 首先执行瑞星存储过程 Sync_Stock
		basplustockService.querySyncStock();
		
		//上次更新时间
		Date LastUpdateTime = DateParseUtil.parseDateTime(orgSystemParameterService.queryValueByName(OrgSystemParameterNameEnum.NAME_INVENTORY_LAST_UPDATE_TIME));
		//瑞星最近更新的库存
		List<Basplustock> listBasplustock =  basplustockService.queryListByLastUpdateTime(LastUpdateTime);
		if(CollectionUtils.isNotEmpty(listBasplustock)){
			//当前时间
			Date now = new Date();
			//瑞星数据库当前时间
			Date rxDbNow = ((BasplustockVo)(listBasplustock.get(0))).getDbTime();
			OrgProductInventoryVo inventory = null;
			List<OrgProductInventory> listAddInventory = new ArrayList<OrgProductInventory>();
			List<OrgProductInventory> listUpdateInventory = new ArrayList<OrgProductInventory>();
			for(Basplustock basplustock : listBasplustock){
				inventory = queryByGoodsSnAndShopCode(basplustock.getPluno(),basplustock.getShpno());
				if(inventory == null){
					//新增
					inventory = new OrgProductInventoryVo();
					inventory.setGoodsSn(basplustock.getPluno());
					inventory.setShopCode(basplustock.getShpno());
					inventory.setShopAmount(basplustock.getFqty().intValue());
					inventory.setWarehouseAmount(basplustock.getPsqty().intValue());
					inventory.setSourcePrice(basplustock.getSlprc());
					inventory.setSellPrice(basplustock.getSlprc());
					inventory.setBarcode(basplustock.getBcd());
					inventory.setUpdateTime(now);
					listAddInventory.add(inventory);
				}else{
					//修改
					// 如果商品是直营的就更新，联营不更新
//					if(inventory.getIsDirect().equals(OrgProductItemConstant.IS_DIRECT_YES)){
//						System.out.println("*****************************");
//						System.out.println("当前商品是直营");
//					}
//					if(inventory.getIsDirect().equals(OrgProductItemConstant.IS_DIRECT_NO)){
//						System.out.println("*****************************");
//						System.out.println("当前商品是联营");
//					}
					
					if(null != inventory.getIsDirect() && inventory.getIsDirect().equals(OrgProductItemConstant.IS_DIRECT_YES)){
						//System.out.println("执行更新..................................");
						if(!inventory.getShopAmount().equals(basplustock.getFqty().intValue()) || !inventory.getSellPrice().equals(basplustock.getSlprc())){
							
							inventory.setShopAmount(basplustock.getFqty().intValue());
							inventory.setWarehouseAmount(basplustock.getPsqty().intValue());
							inventory.setSourcePrice(basplustock.getSlprc());
							inventory.setSellPrice(basplustock.getSlprc());
							inventory.setBarcode(basplustock.getBcd());
							inventory.setUpdateTime(now);
							listUpdateInventory.add(inventory);
						}
					}
					
				}
			}
			//批量添加
			addInBatch(listAddInventory);
			//批量更新
			updateInBatch(listUpdateInventory);
			//记录更新时间
			if(rxDbNow != null){
				orgSystemParameterService.updateValueByName(OrgSystemParameterNameEnum.NAME_INVENTORY_LAST_UPDATE_TIME, DateFormatUtil.formatDateTime(rxDbNow));
			}
			logger.info("insert:"+listAddInventory.size()+"，update:"+listUpdateInventory.size());
		}else{
			logger.info("insert:0，update:0");
		}
	}

	/**
	 * 根据goodsSn和shopCode查询库存
	 * @param goodsSn
	 * @param shopCode
	 * @return
	 */
	private OrgProductInventoryVo queryByGoodsSnAndShopCode(String goodsSn,String shopCode) {
		OrgProductInventoryQuery query = new OrgProductInventoryQuery();
		query.setGoodsSn(goodsSn);
		query.setShopCode(shopCode);
		//System.out.println(goodsSn + ":" + shopCode);
		List<OrgProductInventoryVo> list = queryList(query);
		if(null == list || list.size() < 1){
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<OrgProductInventoryVo> queryMealList(
			OrgProductInventoryQuery query) {
		return orgProductInventoryDao.queryMealList(query);
	}
	
	public void syncInventoryFromRuiXingTest() {
		//上次更新时间
		Date LastUpdateTime = DateParseUtil.parseDateTime(orgSystemParameterService.queryValueByName(OrgSystemParameterNameEnum.NAME_INVENTORY_LAST_UPDATE_TIME));
		Calendar calendar = new GregorianCalendar(2016, 6, 28,18,0,0);
		LastUpdateTime = calendar.getTime();
		//瑞星最近更新的库存
		List<Basplustock> listBasplustock =  basplustockService.queryListByLastUpdateTime(LastUpdateTime);
		if(CollectionUtils.isNotEmpty(listBasplustock)){
			//当前时间
			Date now = new Date();
			//瑞星数据库当前时间
			Date rxDbNow = ((BasplustockVo)(listBasplustock.get(0))).getDbTime();
			OrgProductInventoryVo inventory = null;
			List<OrgProductInventory> listAddInventory = new ArrayList<OrgProductInventory>();
			List<OrgProductInventory> listUpdateInventory = new ArrayList<OrgProductInventory>();
			for(Basplustock basplustock : listBasplustock){
				inventory = queryByGoodsSnAndShopCode(basplustock.getPluno(),basplustock.getShpno());
				if(inventory == null){
					//新增
					inventory = new OrgProductInventoryVo();
					inventory.setGoodsSn(basplustock.getPluno());
					inventory.setShopCode(basplustock.getShpno());
					inventory.setShopAmount(basplustock.getFqty().intValue());
					inventory.setWarehouseAmount(basplustock.getPsqty().intValue());
					inventory.setSourcePrice(basplustock.getSlprc());
					inventory.setSellPrice(basplustock.getSlprc());
					inventory.setBarcode(basplustock.getBcd());
					inventory.setUpdateTime(now);
					listAddInventory.add(inventory);
				}else{
					//修改
					// 如果商品是直营的就更新，联营不更新
//					if(inventory.getIsDirect().equals(OrgProductItemConstant.IS_DIRECT_YES)){
//						System.out.println("*****************************");
//						System.out.println("当前商品是直营");
//					}
//					if(inventory.getIsDirect().equals(OrgProductItemConstant.IS_DIRECT_NO)){
//						System.out.println("*****************************");
//						System.out.println("当前商品是联营");
//					}
					
					if(null != inventory.getIsDirect() && inventory.getIsDirect().equals(OrgProductItemConstant.IS_DIRECT_YES)){
						//System.out.println("执行更新..................................");
						if(!inventory.getShopAmount().equals(basplustock.getFqty().intValue()) || !inventory.getSellPrice().equals(basplustock.getSlprc())){
							
							inventory.setShopAmount(basplustock.getFqty().intValue());
							inventory.setWarehouseAmount(basplustock.getPsqty().intValue());
							inventory.setSourcePrice(basplustock.getSlprc());
							inventory.setSellPrice(basplustock.getSlprc());
							inventory.setBarcode(basplustock.getBcd());
							inventory.setUpdateTime(now);
							listUpdateInventory.add(inventory);
						}
					}
					
				}
			}
			//批量添加
			addInBatch(listAddInventory);
			//批量更新
			updateInBatch(listUpdateInventory);
			//记录更新时间
			if(rxDbNow != null){
				orgSystemParameterService.updateValueByName(OrgSystemParameterNameEnum.NAME_INVENTORY_LAST_UPDATE_TIME, DateFormatUtil.formatDateTime(rxDbNow));
			}
			logger.info("insert:"+listAddInventory.size()+"，update:"+listUpdateInventory.size());
		}else{
			logger.info("insert:0，update:0");
		}
	}
}