package com.kjj.commserver.dao.order;

import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.order.aide.OrgCartQuery;
import com.kjj.core.dao.BaseDao;

public interface OrgCartDao extends BaseDao<OrgCart, Integer> {

	/**
	 * 查询商品数量
	 * @param query
	 * @return
	 */
	long selectGoodsCount(OrgCartQuery query);

	/**
	 * 修改购物车
	 * @param orgCart
	 * @return
	 */
	int updateByUserIdAndGoodsId(OrgCart orgCart);
}