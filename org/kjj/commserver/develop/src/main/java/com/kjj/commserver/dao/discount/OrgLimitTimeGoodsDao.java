package com.kjj.commserver.dao.discount;

import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.core.dao.BaseDao;

public interface OrgLimitTimeGoodsDao extends BaseDao<OrgLimitTimeGoods, Integer> {

	/**
	 * 根据限时折扣ID和goodsId修改
	 * @param orgLimitTimeGoods
	 */
	int updateByGoodsIdAndLtdId(OrgLimitTimeGoods orgLimitTimeGoods);
}