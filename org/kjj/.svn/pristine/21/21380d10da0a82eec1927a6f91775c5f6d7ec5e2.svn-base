package com.kjj.commserver.service.discount.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgReachDao;
import com.kjj.commserver.entity.discount.OrgDiscountProduct;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.OrgReachCondition;
import com.kjj.commserver.entity.discount.OrgReachDiscount;
import com.kjj.commserver.entity.discount.OrgReachGive;
import com.kjj.commserver.entity.discount.aide.OrgCouponConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionVo;
import com.kjj.commserver.entity.discount.aide.OrgReachConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountVo;
import com.kjj.commserver.entity.discount.aide.OrgReachForm;
import com.kjj.commserver.entity.discount.aide.OrgReachQuery;
import com.kjj.commserver.entity.discount.aide.OrgReachVo;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.goods.aide.OrgProductItemVo;
import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgCartConstant;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgCouponService;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.commserver.service.discount.OrgDiscountScopeService;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.commserver.service.discount.OrgReachConditionService;
import com.kjj.commserver.service.discount.OrgReachCouponService;
import com.kjj.commserver.service.discount.OrgReachDiscountService;
import com.kjj.commserver.service.discount.OrgReachGiveService;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgReachServiceImpl extends BaseServiceImpl<OrgReach, Integer> implements OrgReachService {
    @Resource
    private OrgReachDao orgReachDao;
    @Resource
    private OrgReachConditionService orgReachConditionService;
    @Resource
    private OrgReachDiscountService orgReachDiscountService;
    @Resource
    private OrgDiscountProductService orgDiscountProductService;
    @Resource
    private OrgProductItemService orgProductItemService;
    @Resource
    private OrgCouponService orgCouponService;
    @Resource
    private OrgCartService orgCartService;
    @Resource
    private OrgDiscountAllowService orgDiscountAllowService;
    @Resource
	private OrgDiscountShopService orgDiscountShopService;
	@Resource
	private OrgDiscountScopeService orgDiscountScopeService;
	@Resource
	private OrgReachGiveService orgReachGiveService;
	@Resource
	private OrgReachCouponService orgReachCouponService;

    @Override
    protected BaseDao<OrgReach, Integer> getBaseDao() {
        return orgReachDao;
    }
    
    @Override
	public Map<Integer, OrgReach> updateMap4View(OrgUsersSession orgUsersSession, List<OrgCartAll> listCartAll) {
		return updateMap4ViewOrBuy(orgUsersSession,listCartAll,false);
	}
    
    @Override
    public Map<Integer, OrgReach> updateMap4Buy(OrgUsersSession orgUsersSession, List<OrgCartAll> listCartAll) {
    	return updateMap4ViewOrBuy(orgUsersSession,listCartAll,true);
    }
    
    /**
     * 查询满赠信息
     * @param orgUsersSession
     * @param listCartAll
     * @param isBuy
     * @return
     */
    private Map<Integer, OrgReach> updateMap4ViewOrBuy(OrgUsersSession orgUsersSession, List<OrgCartAll> listCartAll, boolean isBuy){
    	Map<Integer,OrgReach> mapReach = new HashMap<Integer,OrgReach>();
    	List<OrgReach> listReach = queryList4User(orgUsersSession);
    	
    	//当前的活动SET
    	Set<Integer> setReachId = new HashSet<Integer>();
    	for(OrgReach orgReach : listReach){
    		setReachId.add(orgReach.getId());
    	}
    	//下单赠品
    	Map<Integer,OrgReachDiscountVo> mapReachDiscountGive4Buy = new HashMap<Integer,OrgReachDiscountVo>();
    	//展示赠品
		Map<Integer,Integer> mapGoodsCanGive4View = new HashMap<Integer,Integer>();
    			
    	OrgReachVo reach = null;
    	OrgReachDiscountVo reachDiscount = null;
    	OrgReachConditionVo reachCondition = null;
    	
    	List<OrgReachCondition> listOrgReachCondition = null;
    	Map<Long,OrgReachDiscount> mapReachDiscount = null;
    	
    	OrgDiscountProductQuery discountProductQuery = new OrgDiscountProductQuery();
    	discountProductQuery.setTypeId(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT);
    	
    	Map<Integer, OrgDiscountProduct> mapDiscountProduct = null;
    	OrgProductItemVo productItem = null;
    	OrgProductItemAide itemAide = null;
    	
    	boolean isCondition = false;
    	for(OrgReach orgReach : listReach){
    		reach = (OrgReachVo)orgReach;
    		discountProductQuery.setDiscountId(reach.getId());
    		// 查询满减适用商品范围
    		if (reach.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_PRODUCT) {
    			// 查询满减适用商品
    			mapDiscountProduct = orgDiscountProductService.queryMap(discountProductQuery, "goodsId");
    			
    		} else if (reach.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_CLASS) {
    			// 查询满减适用分类
    			mapDiscountProduct = orgDiscountProductService.queryMap(discountProductQuery, "classId");
    		}
    		
    		// 查询满足条件的商品总金额
    		for (OrgCartAll cartAll : listCartAll) {
    			if(cartAll.getCanBuy()){
    				itemAide = cartAll.getOrgProductItemAll().getOrgProductItemAide();
    				//商品允许使用满减
    				if (itemAide.getMapDiscountAllow().containsKey(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT)) {
    					if (reach.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_PRODUCT) {
    						// 商品
    						// 如商品在满减商品范围内
    						if (mapDiscountProduct.containsKey(itemAide.getGoodsId())) {
								setDiscount(orgUsersSession,cartAll,reach,itemAide,setReachId,mapReach,isBuy);
    						}else{
    							//原有参加活动商品删除优惠
    							removeDiscount(cartAll,reach);
    						}
    					} else if (reach.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_CLASS) {
    						// 分类
    						productItem = (OrgProductItemVo)orgProductItemService.queryVoById(itemAide.getGoodsId());
    						// 如商品分类或者上级分类在满减分类范围内
    						if (mapDiscountProduct.containsKey(productItem.getCatId().intValue())|| mapDiscountProduct.containsKey(productItem.getOrgClass().getClassParent())) {
								setDiscount(orgUsersSession,cartAll,reach,itemAide,setReachId,mapReach,isBuy);
    						}else{
    							//原有参加活动商品删除优惠
    							removeDiscount(cartAll,reach);
    						}
    					} else if (reach.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_ALL) {
    						// 全部商品
							setDiscount(orgUsersSession,cartAll,reach,itemAide,setReachId,mapReach,isBuy);
    					}
    				} else {
    					//原有参加活动商品删除优惠
						removeDiscount(cartAll,reach);
    				}
    				
    				if(!isBuy){
						//展示可送数量
    					if(cartAll.getOrgCart().getStatus() == OrgCartConstant.STATUS_SELECT_ON){
        					mapGoodsCanGive4View.put(itemAide.getGoodsId(), itemAide.getUserBuyMax()-itemAide.getUserBuy());
    					}else{
        					mapGoodsCanGive4View.put(itemAide.getGoodsId(), itemAide.getUserBuyMax());
    					}
    				}
    			}
    		}
    		
    		//条件
    		listOrgReachCondition = orgReachConditionService.queryByReachId(reach.getId());
    		for(OrgReachCondition orgReachCondition : listOrgReachCondition){
    			reachCondition = (OrgReachConditionVo)orgReachCondition;
    			isCondition = false;
    			if(reach.getReachStyle() == OrgReachConstant.REACH_STYLE_MONEY){
    				isCondition = reach.getSumMoney().compareTo(reachCondition.getReachCondition()) >= 0;
    			}else if(reach.getReachStyle() == OrgReachConstant.REACH_STYLE_AMOUNT){
    				isCondition = BigDecimal.valueOf(reach.getSumAmount()).compareTo(reachCondition.getReachCondition()) >= 0;
    			}
    			//满足条件
    			if(isCondition){
    				if(isBuy){
    					mapReach.put(reach.getId(), reach);
    				}
    				reach.setOrgReachCondition(reachCondition);
    				for(OrgCartAll cartAll : listCartAll){
    					if(reach.getId().equals(cartAll.getOrgCart().getDiscountId())){
    						itemAide = cartAll.getOrgProductItemAll().getOrgProductItemAide();
    						//满减标志
    						itemAide.setMarkReachDiscount(true);
    						//设置其他优惠能否一起进行
    						orgDiscountAllowService.loadDiscountAllow(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT,reach.getId(),itemAide);
    					}
    				}
    				//优惠开始
    				mapReachDiscount = orgReachDiscountService.queryMapByRcId(reachCondition.getId());
    				for(OrgReachDiscount orgReachDiscount : mapReachDiscount.values()){
    					reachDiscount = (OrgReachDiscountVo)orgReachDiscount;
    					reachDiscount.setDiscountMultiple(Integer.valueOf(1));
    					if(reachDiscount.getIsloop() == OrgReachDiscountConstant.IS_LOOP_YES){
    						if(reach.getReachStyle() == OrgReachConstant.REACH_STYLE_MONEY){
    							reachDiscount.setDiscountMultiple(reach.getSumMoney().divide(reachCondition.getReachCondition(), RoundingMode.DOWN).intValue());
    						}else if(reach.getReachStyle() == OrgReachConstant.REACH_STYLE_AMOUNT){
    							reachDiscount.setDiscountMultiple(BigDecimal.valueOf(reach.getSumAmount()).divide(reachCondition.getReachCondition(), RoundingMode.DOWN).intValue());
    						}
    					}
    					
    					if(reachDiscount.getTypeId() == OrgReachDiscountConstant.TYPE_MONEY){
    						//金额
    						//优惠金额合计
    						BigDecimal sumDiscountMoney = BigDecimal.ZERO;
    						for(OrgCartAll cartAll : listCartAll){
    							if(cartAll.getOrgCart().getStatus() == OrgCartConstant.STATUS_SELECT_ON && reach.getId().equals(cartAll.getOrgCart().getDiscountId())){
    								itemAide = cartAll.getOrgProductItemAll().getOrgProductItemAide();
    								sumDiscountMoney = sumDiscountMoney.add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
    								itemAide.setRealPrice((reach.getSumMoney().subtract(reachDiscount.getCommon().multiply(BigDecimal.valueOf(reachDiscount.getDiscountMultiple()))).multiply(itemAide.getRealPrice()).divide(reach.getSumMoney(),2,BigDecimal.ROUND_HALF_UP)));
    								sumDiscountMoney = sumDiscountMoney.subtract(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
    							}
    						}
    						//调整金额
    						reachDiscount.setBalance(reachDiscount.getCommon().multiply(BigDecimal.valueOf(reachDiscount.getDiscountMultiple())).subtract(sumDiscountMoney));
    					}else if(reachDiscount.getTypeId() == OrgReachDiscountConstant.TYPE_GIVE){
    						//赠品
    						if(isBuy){
    							//下单
        						mapReachDiscountGive4Buy.put(reachDiscount.getId(), reachDiscount);
    						}else{
    							//展示
    							List<OrgProductItem> listReachGive = orgProductItemService.queryListByReachDiscountId(reachDiscount.getId(),orgUsersSession);
    							Iterator<OrgProductItem> iterOrgProductItem = listReachGive.iterator();
    							while(iterOrgProductItem.hasNext()){
    								productItem = (OrgProductItemVo)iterOrgProductItem.next();
    								if(!mapGoodsCanGive4View.containsKey(productItem.getGoodsId())){
    									mapGoodsCanGive4View.put(productItem.getGoodsId(), productItem.getShopAmount());
    								}
    								if(mapGoodsCanGive4View.get(productItem.getGoodsId()) == 0){
    									iterOrgProductItem.remove();
    								}else{
    									if(mapGoodsCanGive4View.get(productItem.getGoodsId()) < productItem.getOrgReachGive().getAmount()*reachDiscount.getDiscountMultiple()){
    										productItem.setGiveAmount(mapGoodsCanGive4View.get(productItem.getGoodsId()));
    									}else{
    										productItem.setGiveAmount(productItem.getOrgReachGive().getAmount()*reachDiscount.getDiscountMultiple());
    									}
    									mapGoodsCanGive4View.put(productItem.getGoodsId(), mapGoodsCanGive4View.get(productItem.getGoodsId()) - productItem.getGiveAmount());
    								}
    							}
    							reachDiscount.setListReachGive(listReachGive);
    							
    						}
    					}else if(reachDiscount.getTypeId() == OrgReachDiscountConstant.TYPE_COUPON){
    						//优惠券
    						reachDiscount.setListReachCoupon(orgReachCouponService.queryListByReachDiscountId(reachDiscount.getId()));
    					}
    				}
    				reachCondition.setMapReachDiscount(mapReachDiscount);
    				//优惠结束
    				break;
    			}
    		}
    	}
    	
    	//下单赠品处理
    	if(isBuy && MapUtils.isNotEmpty(mapReachDiscountGive4Buy)){
        	List<OrgReachGive> listReachGive = orgReachGiveService.queryListByRdIds(mapReachDiscountGive4Buy.keySet());
        	Map<Integer,Integer> mapGoodsGive = new HashMap<Integer,Integer>();
        	for(OrgReachGive reachGive : listReachGive){
        		if(mapGoodsGive.containsKey(reachGive.getGoodsId())){
        			mapGoodsGive.put(reachGive.getGoodsId(), mapGoodsGive.get(reachGive.getGoodsId()) + reachGive.getAmount()*mapReachDiscountGive4Buy.get(reachGive.getRdId()).getDiscountMultiple());
        		}else{
        			mapGoodsGive.put(reachGive.getGoodsId(), reachGive.getAmount()*mapReachDiscountGive4Buy.get(reachGive.getRdId()).getDiscountMultiple());
        		}
        	}
        	//添加赠品
        	orgProductItemService.updateReachGive4Buy(orgUsersSession,listCartAll,mapGoodsGive);
    	}
    	
    	return mapReach;
    }
    
	/**
	 * 设置满减优惠
	 * @param orgUsersSession
	 * @param cartAll
	 * @param reach
	 * @param itemAide
	 * @param setReachId
	 * @param isBuy
	 */
	private void setDiscount(OrgUsersSession orgUsersSession, OrgCartAll cartAll,OrgReachVo reach,OrgProductItemAide itemAide,Set<Integer> setReachId,Map<Integer, OrgReach> mapReach,boolean isBuy){
		//旧的活动ID去除
		if(cartAll.getOrgCart().getDiscountId() != null && cartAll.getOrgCart().getDiscountId() != OrgCartConstant.DISCOUNT_ID_NO && !setReachId.contains(cartAll.getOrgCart().getDiscountId())){
			cartAll.getOrgCart().setDiscountId(null);
		}
		//添加活动
		if(cartAll.getOrgCart().getDiscountId() == null){
			cartAll.getOrgCart().setDiscountId(reach.getId());
			OrgCart  cart = new OrgCart();
			cart.setGoodsId(itemAide.getGoodsId());
			cart.setDiscountId(reach.getId());
			cart.setUpdateTime(new Date());
			orgCartService.update(orgUsersSession, cart);
		}
		
		//活动加入列表
		cartAll.getMapDiscount().put(reach.getId(), reach.getTitle());
		
		//选择当前活动
		if(cartAll.getOrgCart().getDiscountId() == reach.getId()){
			if(!isBuy){
				//展示页面添加活动
				mapReach.put(reach.getId(), reach);
			}
			//已选择
			if(cartAll.getOrgCart().getStatus() == OrgCartConstant.STATUS_SELECT_ON){
				//计算活动金额合计，件数合计
				reach.setSumMoney(reach.getSumMoney().add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy()))));
				reach.setSumAmount(reach.getSumAmount()+itemAide.getUserBuy());
			}
		}
	}
	
	/**
	 * 原来参加活动的商品删除优惠
	 * @param cartAll
	 * @param reach
	 */
	private void removeDiscount( OrgCartAll cartAll,OrgReachVo reach){
		//旧的活动ID去除
		if(cartAll.getOrgCart().getDiscountId() != null && cartAll.getOrgCart().getDiscountId() == reach.getId()){
			cartAll.getOrgCart().setDiscountId(null);
		}
	}

	/**
	 * 查询用户可用满减优惠
	 * @param orgUsersSession
	 * @return
	 */
	@Override
	public List<OrgReach> queryList4User(OrgUsersSession orgUsersSession) {
		OrgReachQuery query = new OrgReachQuery();
		query.setQuery4User(true);
		query.setStatus(OrgReachConstant.STATUS_VALID);
		query.setOrgUsersSession(orgUsersSession);
		Sort sort = new Sort(Direction.DESC,"t.id");
		return queryList(query, sort);
	}
	

	@Override
	public List<OrgReach> queryList4Item(OrgUsersSession orgUsersSession,Integer goodsId) {
		OrgReachQuery query = new OrgReachQuery();
		query.setQuery4User(true);
		query.setGoodsId(goodsId);
		query.setStatus(OrgReachConstant.STATUS_VALID);
		query.setOrgUsersSession(orgUsersSession);
		Sort sort = new Sort(Direction.DESC,"t.id");
		return queryList(query, sort);
	}


	@Override
	public Date getDbTime() {
		return orgReachDao.getDbTime();
	}

	@Override
	public void addInfo(OrgReachForm orgReachForm, OrgAdminUserSession admin) {
		//初始状态：无效
		orgReachForm.setStatus(OrgCouponConstant.STATUS_INVALID);
		//创建人
		orgReachForm.setCreateAdminId(admin.getOrgAdminUser().getUserId());
		//创建时间
		orgReachForm.setCreateTime(new Date());
		add(orgReachForm);
		//适用店铺范围 
		orgDiscountShopService.addByDiscount(orgReachForm.getTypeId(),orgReachForm.getId(),orgReachForm.getShopType(),orgReachForm.getListCity(),orgReachForm.getListShop());
		//适用终端范围
		orgDiscountScopeService.addByDiscount(orgReachForm.getTypeId(),orgReachForm.getId(),orgReachForm.getListScope());
		//允许同时优惠
		orgDiscountAllowService.addByDiscount(orgReachForm.getTypeId(),orgReachForm.getId(),orgReachForm.getListAllow());
	}

	@Override
	public void updateInfo(OrgReachForm orgReachForm, OrgAdminUserSession admin) {
		updateByIdSelective(orgReachForm);
		//适用店铺范围
		orgDiscountShopService.updateByDiscount(orgReachForm.getTypeId(),orgReachForm.getId(),orgReachForm.getShopType(),orgReachForm.getListCity(),orgReachForm.getListShop());
		//适用终端范围
		orgDiscountScopeService.updateByDiscount(orgReachForm.getTypeId(),orgReachForm.getId(),orgReachForm.getListScope());
		//允许同时优惠
		orgDiscountAllowService.updateByDiscount(orgReachForm.getTypeId(),orgReachForm.getId(),orgReachForm.getListAllow());
	}

	@Override
	public void updateItem(Byte typeId, Integer discountId, Byte productType,Collection<Integer> listClass, Collection<Integer> listGoods) {
		//适用商品分类范围
		 OrgReach orgReach = new OrgReach();
		 orgReach.setId(discountId);
		 orgReach.setProductType(productType);
		 updateByIdSelective(orgReach);
		orgDiscountProductService.updateByDiscount(typeId, discountId, productType, listClass, listGoods);
	}
		
}
	
	


