package com.kjj.commserver.service.goods;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;
import com.kjj.commserver.entity.goods.aide.OrgProductDetailAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgProductItemService extends BaseService<OrgProductItem, Integer> {
	
	/**
	 * 查询商品数据(包含库存，优惠等全部信息)
	 * @param orgUsersSession session中user
	 * @param listGoods 要查询的goodsId List
	 * @return
	 */
	OrgProductItemAll query4View(OrgUsersSession orgUsersSession, Integer goodsId);
	
	/**
	 * 查询商品数据List(包含库存，优惠等全部信息)
	 * @param orgUsersSession session中user
	 * @param goodsIds 要查询的goodsId
	 * @return
	 */
	List<OrgProductItemAll> queryList4View(OrgUsersSession orgUsersSession, OrgProductItemQuery itemQuery);
	
	/**
	 * 查询商品数据List(包含库存，优惠等全部信息)
	 * @param orgUsersSession session中user
	 * @param query 查询条件
	 * @param pageable 分页条件
	 * @return
	 */
	Page<OrgProductItemAll> queryPageList4View(OrgUsersSession orgUsersSession,OrgProductItemQuery query, Pageable pageable);
	
	/**
	 * 查询推荐商品数据List(包含库存，优惠等全部信息)
	 * @param orgUsersSession session中user
	 * @param query 查询条件
	 * @param pageable 分页条件
	 * @return
	 */
	Page<OrgProductItemAll> queryPageList4Recommend(OrgUsersSession orgUsersSession,OrgProductItemQuery query, Pageable pageable);
	
	/**
	 * 查询商品数据Map(包含库存，优惠等全部信息)
	 * @param orgUsersSession session中user
	 * @param goodsIds 要查询的goodsId，不可为null
	 * @param mapCart 要下单的购物车Map
	 * @return
	 */
	Map<Integer,OrgProductItemAll> queryMap4View(OrgUsersSession orgUsersSession,/*Map<Integer,OrgCart> mapCart,*/OrgProductItemQuery itemQuery);
	
	/**
	 * 下单时查询并修改商品数据Map(包含库存，优惠等全部信息)
	 * 查询同时会更新本地库存，添加限时折扣记录
	 * @param orgUsersSession session中user
	 * @param goodsIds 要查询的goodsId，不可为null
	 * @param mapCart 要下单的购物车Map
	 * @return
	 */
	Map<Integer,OrgProductItemAll> updateMap4Buy(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds/*,Map<Integer,OrgCart> mapCart*/);
	
	/**
	 * 是否允许下单
	 * @param mapItemAide
	 * @return
	 */
	boolean isAllowBuy(Map<Integer,OrgProductItemAide> mapItemAide);
	
	/**
	 * 查询商品详细
	 * @param listGoods 要查询的goodsId List
	 * @return
	 */
	OrgProductDetailAll queryDetail4View(Integer itemId);
	
	/**
	 * 从query中获得排序获得排序
	 * @param Query
	 * @return
	 */
	Sort getSortFormQuery(OrgProductItemQuery query );
	
	/**
	 * 添加商品分类信息
	 * @param productItemLinkSalespecList
	 */
	void initSaleSpecAll(List<OrgProductLinkSalespec> productItemLinkSalespecList);

	/**
	 * 根据GoodsSn查询有效商品
	 * @return
	 */
	OrgProductItem queryByGoodsSnValid(String goodsSn);

	/**
	 * SKU销售数、评论数更新
	 */
	long updateSaleNumAndCommentNum();
	
	/**
	 * 查询满赠商品列表
	 * @param reachDiscountId
	 * @param orgUsersSession
	 * @return
	 */
	List<OrgProductItem> queryListByReachDiscountId(Integer reachDiscountId, OrgUsersSession orgUsersSession);

	/**
	 * 赠品下单
	 * @param orgUsersSession
	 * @param listCartAll
	 * @param mapGoodsGive
	 * @return
	 */
	void updateReachGive4Buy(OrgUsersSession orgUsersSession, List<OrgCartAll> listCartAll, Map<Integer,Integer> mapGoodsGive);
	/**
	 * 查询模块商品数据List(包含库存，优惠等全部信息)
	 * @param orgUsersSession session中user
	 * @param query 查询条件
	 * @param pageable 分页条件
	 * @return
	 */
	Page<OrgProductItemAll> queryPageList4ModuleGoods(OrgUsersSession orgUsersSession, OrgProductItemQuery query, Pageable pageable);
}