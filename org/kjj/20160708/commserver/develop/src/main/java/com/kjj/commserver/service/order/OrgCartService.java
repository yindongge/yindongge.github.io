package com.kjj.commserver.service.order;

import java.util.Collection;
import java.util.List;

import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgCartService extends BaseService<OrgCart, Integer> {
	
	/**
	 * 购物车添加商品
	 * @param orgUsersSession session中user
	 * @param orgCart 要添加的购物车商品
	 */
	void add(OrgUsersSession orgUsersSession,OrgCart orgCart);
	
	/**
	 * 购物车修改商品数量
	 * @param orgUsersSession session中user
	 * @param orgCart 要修改的购物车商品
	 */
	void update(OrgUsersSession orgUsersSession,OrgCart orgCart);
	
	/**
	 * 购物车删除商品
	 * @param orgUsersSession session中user
	 * @param goodsIds 要删除的goodsId
	 */
	void deleteBatch(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds);
	
	/**
	 * 购物车商品总数量
	 * @param orgUsersSession session中user
	 * @return 数量
	 */
	long getCountByUser(OrgUsersSession orgUsersSession);
	
	/**
	 * 购物车商品总数量
	 * @param userId 用户ID
	 * @return
	 */
	long getCountByUserId(Integer userId);
	
	/***
	 * 把游客购物车保留信息合并到登录后用户
	 * @param orgUsersSession
	 */
	void mergeVisitorCart(OrgUsersSession orgUsersSession);
	
	/***
	 * 查询用户购物车全部数据(包含库存，优惠等全部信息)
	 * @param orgUsersSession
	 * @return
	 */
	List<OrgCartAll> queryList4View(OrgUsersSession orgUsersSession);
	
	/***
	 * 查询登录用户购物车选择的数据(包含库存，优惠等全部信息)
	 * @param orgUsersSession
	 * @param goodsIds 要查询的goodsId,不可为null
	 * @return
	 */
	List<OrgCartAll> queryList4Select(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds);
	
	/***
	 * 下单时查询并修改用户购物车数据(包含库存，优惠等全部信息)
	 * 查询同时会更新本地库存，添加限时折扣记录
	 * @param orgUsersSession 必须为登录用户
	 * @param goodsIds 要查询的goodsId,不可为null
	 * @return
	 */
	List<OrgCartAll> updateList4Buy(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds);

	/**
	 * 下单成功后删除购物车物品
	 * @param listCartAll
	 */
	void deleteBatchAfterBuy(List<OrgCartAll> listCartAll);
	
	/**
	 * 根据userId和goodsId更新购物车
	 * @param orgCart
	 */
	void updateByUserIdAndGoodsId(OrgCart orgCart);
	
	/***
	 * 修改用户超过可买数量的商品，改为可买最大量
	 * @param orgUsersSession
	 * @param listCartAll
	 * @return
	 */
	List<OrgCartAll> updateAmount4Over(OrgUsersSession orgUsersSession,List<OrgCartAll> listCartAll);

	/**
	 * 购物车商品选择
	 * @param orgUsersSession
	 * @param orgCart
	 */
	void updateSelectOn(OrgUsersSession orgUsersSession,OrgCart orgCart);
	
	/**
	 * 购物车商品取消选择
	 * @param orgUsersSession
	 * @param orgCart
	 */
	void updateSelectOff(OrgUsersSession orgUsersSession, OrgCart orgCart);

	/**
	 * 购物车商品全部选择
	 * @param orgUsersSession
	 */
	void updateSelectAllOn(OrgUsersSession orgUsersSession);

	/**
	 * 购物车商品全部取消选择
	 * @param orgUsersSession
	 */
	void updateSelectAllOff(OrgUsersSession orgUsersSession);

}