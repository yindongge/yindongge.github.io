package com.kjj.commserver.service.order.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.order.OrgCartDao;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgCartConstant;
import com.kjj.commserver.entity.order.aide.OrgCartQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgCartServiceImpl extends BaseServiceImpl<OrgCart, Integer> implements OrgCartService {

	@Resource
    private OrgCartDao orgCartDao;
	@Resource
	private OrgProductItemService orgProductItemService;

    @Override
    protected BaseDao<OrgCart, Integer> getBaseDao() {
        return orgCartDao;
    }
    
    @Override
   	public void add(OrgCart entity) {
    	entity.setCreateTime(new Date());
    	entity.setUpdateTime(new Date());
   		super.add(entity);
   	}

   	@Override
   	public int updateByIdSelective(OrgCart entity) {
   		entity.setUpdateTime(new Date());
   		return super.updateByIdSelective(entity);
   	}

	@Override
	public void add(OrgUsersSession orgUsersSession, OrgCart orgCart) {
		Map<Integer,OrgCart> mapCart = queryMapCartByUser(orgUsersSession,null);
		orgCart.setStatus(OrgCartConstant.STATUS_SELECT_ON);
		if(orgUsersSession.isLogin()){
			if(mapCart.containsKey(orgCart.getGoodsId())){
				orgCart.setUserId(orgUsersSession.getOrgUsers().getUserId());
				orgCart.setAmount(orgCart.getAmount()+mapCart.get(orgCart.getGoodsId()).getAmount());
				updateByUserIdAndGoodsId(orgCart);
			}else{
				//设置用户ID
				orgCart.setUserId(orgUsersSession.getOrgUsers().getUserId());
				add(orgCart);
			}
		}else{
			if(mapCart.containsKey(orgCart.getGoodsId())){
				mapCart.get(orgCart.getGoodsId()).setAmount(orgCart.getAmount()+mapCart.get(orgCart.getGoodsId()).getAmount());
			}else{
				mapCart.put(orgCart.getGoodsId(),orgCart);
			}
		}
	}
	
	@Override
	public void update(OrgUsersSession orgUsersSession, OrgCart orgCart) {
		if(orgUsersSession.isLogin()){
			orgCart.setUserId(orgUsersSession.getOrgUsers().getUserId());
			updateByUserIdAndGoodsId(orgCart);
		}else{
			Map<Integer,OrgCart> mapCart = orgUsersSession.getVisitorCart();
			if (orgCart.getAmount() != null) {
				mapCart.get(orgCart.getGoodsId()).setAmount(orgCart.getAmount());
			}else if(orgCart.getDiscountId() != null){
				mapCart.get(orgCart.getGoodsId()).setDiscountId(orgCart.getDiscountId());
			}
		}
	}
	
	@Override
	public void updateByUserIdAndGoodsId(OrgCart orgCart){
		orgCart.setUpdateTime(new Date());
		orgCartDao.updateByUserIdAndGoodsId(orgCart);
	}
	
	@Override
	public void deleteBatch(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds) {
		if(orgUsersSession.isLogin()){
			OrgCartQuery query = new OrgCartQuery();
			query.setUserId(orgUsersSession.getOrgUsers().getUserId());
			query.setGoodsIds(goodsIds);
			this.delete(query);
		}else{
			Map<Integer,OrgCart> mapCart = orgUsersSession.getVisitorCart();
			for(Integer goodsId:goodsIds){
				mapCart.remove(goodsId);
			}
		}
		
	}
	
	@Override
	public long getCountByUser(OrgUsersSession orgUsersSession){
		long count = 0;
		if(orgUsersSession.isLogin()){
			OrgCartQuery query = new OrgCartQuery();
			query.setUserId(orgUsersSession.getOrgUsers().getUserId());
			count = orgCartDao.selectGoodsCount(query);
		}else{
			Map<Integer,OrgCart> mapCart = orgUsersSession.getVisitorCart();
			for(OrgCart cart:mapCart.values()){
				count += cart.getAmount();
			}
		}
		return count;
	}
	@Override
	public long getCountByUserId(Integer userId){
		OrgCartQuery query = new OrgCartQuery();
		query.setUserId(userId);
		return orgCartDao.selectGoodsCount(query);
	}
	
	/**
	 * 查询购物车商品Map以goodsId为键
	 * @param orgUsersSession
	 * @param goodsIds 要查询的goodsId List。如果为null则全部查询
	 * @return
	 */
	private Map<Integer,OrgCart> queryMapCartByUser(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds){
		Map<Integer,OrgCart> mapCart = null;
		if(orgUsersSession.isLogin()){
			OrgCartQuery query = new OrgCartQuery();
			query.setUserId(orgUsersSession.getOrgUsers().getUserId());
			query.setGoodsIds(goodsIds);
			mapCart = queryMap(query, "goodsId");
		}else{
			mapCart = orgUsersSession.getVisitorCart();
		}
		return mapCart;
	}
	
	@Override
	public void mergeVisitorCart(OrgUsersSession orgUsersSession) {
		Map<Integer,OrgCart> mapVisitorCart = orgUsersSession.getVisitorCart();
		OrgCartQuery query = new OrgCartQuery();
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		Map<Integer,OrgCart> mapDBCart = queryMap(query, "goodsId");;
		OrgCart old = null;
		for(OrgCart cart :mapVisitorCart.values()){
			if(mapDBCart.containsKey(cart.getGoodsId())){
				old = mapDBCart.get(cart.getGoodsId());
				old.setAmount(old.getAmount()+cart.getAmount());
				updateByIdSelective(old);
			}else{
				//设置用户ID
				cart.setUserId(orgUsersSession.getOrgUsers().getUserId());
				add(cart);
			}
		}
	}

	@Override
	public List<OrgCartAll> queryList4View(OrgUsersSession orgUsersSession) {
		Map<Integer,OrgCart> mapCart = queryMapCartByUser(orgUsersSession,null);
		if(MapUtils.isNotEmpty(mapCart)){
			OrgProductItemQuery itemQuery = new OrgProductItemQuery();
			itemQuery.setGoodsIds(mapCart.keySet());
			Map<Integer,OrgProductItemAll> mapItem = orgProductItemService.queryMap4View(orgUsersSession,/*mapCart,*/itemQuery);
			return getListCartAll(mapCart,mapItem);
		}else{
			return new ArrayList<OrgCartAll>();
		}
	}
	
	@Override
	public List<OrgCartAll> queryList4Select(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds) {
		Map<Integer,OrgCart> mapCart = queryMapCartByUser(orgUsersSession,goodsIds);
		if(MapUtils.isNotEmpty(mapCart)){
			OrgProductItemQuery itemQuery=new OrgProductItemQuery();
			itemQuery.setGoodsIds(goodsIds);
			Map<Integer,OrgProductItemAll> mapItem = orgProductItemService.queryMap4View(orgUsersSession,/*mapCart,*/itemQuery);
			return getListCartAll(mapCart,mapItem);
		}else{
			return new ArrayList<OrgCartAll>();
		}
	}
	
	@Override
	public List<OrgCartAll> updateList4Buy(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds) {
		OrgCartQuery query = new OrgCartQuery();
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		query.setGoodsIds(goodsIds);
		query.setSelect4Update(true);
		Map<Integer,OrgCart> mapCart = queryMap(query, "goodsId");
		if(MapUtils.isNotEmpty(mapCart)){
			Map<Integer,OrgProductItemAll> mapItem = orgProductItemService.updateMap4Buy(orgUsersSession, goodsIds/*,mapCart*/);
			return getListCartAll(mapCart,mapItem);
		}else{
			return new ArrayList<OrgCartAll>();
		}
	}
	
	/**
	 * 获取购物车明细信息列表
	 * @param mapCart 购物车信息
	 * @param mapItem 商品明细信息
	 * @return
	 */
	private List<OrgCartAll> getListCartAll(Map<Integer,OrgCart> mapCart,Map<Integer,OrgProductItemAll> mapItem){
		List<OrgCartAll> listCartAll = new ArrayList<OrgCartAll>();
		OrgCartAll cartAll = null;
		OrgProductItemAide itemAide = null;
		for(OrgCart cart :mapCart.values()){
			cartAll = new OrgCartAll();
			cartAll.setOrgCart(cart);
			cartAll.setOrgProductItemAll(mapItem.get(cart.getGoodsId()));
			itemAide = cartAll.getOrgProductItemAll().getOrgProductItemAide();
			itemAide.setUserBuy(cart.getAmount());
			//可售
			if(!itemAide.getCanSale()){
				cartAll.setCanBuy(false);
			}
			//库存不足
			if(itemAide.getUserBuyMax() < itemAide.getUserBuy()){
				cartAll.setCanBuy(false);
			}
			listCartAll.add(cartAll);
		}
		return listCartAll;
	}

	@Override
	public void deleteBatchAfterBuy(List<OrgCartAll> listCartAll) {
		List<Integer> listCartId = new ArrayList<Integer>();
		for(OrgCartAll cartAll:listCartAll){
			if (cartAll.getOrgCart().getCartId() != null) {
				listCartId.add(cartAll.getOrgCart().getCartId());
			}
		}
		deleteByIdInBatch(listCartId);
	}

	@Override
	public List<OrgCartAll> updateAmount4Over(OrgUsersSession orgUsersSession,List<OrgCartAll> listCartAll) {
		if(CollectionUtils.isNotEmpty(listCartAll)){
			for (OrgCartAll cartAll : listCartAll) {
				//用户买的数量超出物品可售卖量
				if(!cartAll.getCanBuy() && cartAll.getOrgProductItemAll().getOrgProductItemAide().getCanSale() 
						&& cartAll.getOrgProductItemAll().getOrgProductItemAide().getUserBuyMax() > 0){
					cartAll.getOrgCart().setAmount(cartAll.getOrgProductItemAll().getOrgProductItemAide().getUserBuyMax());
					cartAll.getOrgProductItemAll().getOrgProductItemAide().setUserBuy(cartAll.getOrgProductItemAll().getOrgProductItemAide().getUserBuyMax());
					cartAll.setCanBuy(true);
					update(orgUsersSession,cartAll.getOrgCart());
				}
			}
		}
		return listCartAll;
	}

	@Override
	public void updateSelectOn(OrgUsersSession orgUsersSession,OrgCart orgCart) {
		if(orgUsersSession.isLogin()){
			orgCart.setUserId(orgUsersSession.getOrgUsers().getUserId());
			orgCart.setStatus(OrgCartConstant.STATUS_SELECT_ON);
			updateByUserIdAndGoodsId(orgCart);
		}else{
			orgUsersSession.getVisitorCart().get(orgCart.getGoodsId()).setStatus(OrgCartConstant.STATUS_SELECT_ON);
		}
	}

	@Override
	public void updateSelectOff(OrgUsersSession orgUsersSession,OrgCart orgCart) {
		if(orgUsersSession.isLogin()){
			orgCart.setUserId(orgUsersSession.getOrgUsers().getUserId());
			orgCart.setStatus(OrgCartConstant.STATUS_SELECT_OFF);
			updateByUserIdAndGoodsId(orgCart);
		}else{
			orgUsersSession.getVisitorCart().get(orgCart.getGoodsId()).setStatus(OrgCartConstant.STATUS_SELECT_OFF);
		}
	}

	@Override
	public void updateSelectAllOn(OrgUsersSession orgUsersSession) {
		if(orgUsersSession.isLogin()){
			OrgCart orgCart = new OrgCart();
			orgCart.setUserId(orgUsersSession.getOrgUsers().getUserId());
			orgCart.setStatus(OrgCartConstant.STATUS_SELECT_ON);
			updateByUserIdAndGoodsId(orgCart);
		}else{
			for(OrgCart cart : orgUsersSession.getVisitorCart().values()){
				cart.setStatus(OrgCartConstant.STATUS_SELECT_ON);
			}
		}
	}

	@Override
	public void updateSelectAllOff(OrgUsersSession orgUsersSession) {
		if(orgUsersSession.isLogin()){
			OrgCart orgCart = new OrgCart();
			orgCart.setUserId(orgUsersSession.getOrgUsers().getUserId());
			orgCart.setStatus(OrgCartConstant.STATUS_SELECT_OFF);
			updateByUserIdAndGoodsId(orgCart);
		}else{
			for(OrgCart cart : orgUsersSession.getVisitorCart().values()){
				cart.setStatus(OrgCartConstant.STATUS_SELECT_OFF);
			}
		}
	}
}