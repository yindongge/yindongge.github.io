package com.kjj.commserver.dao.order.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.order.OrgCartDao;
import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.order.aide.OrgCartQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgCartDaoImpl extends BaseDaoImpl<OrgCart, Integer> implements OrgCartDao {
	
	private static final String SQL_ID_SELECT_GOODS_COUNT = "selectGoodsCount";
	private static final String SQL_ID_UPDATE_BY_USERID_AND_GOODSID = "updateByUserIdAndGoodsId";

	@Override
	public long selectGoodsCount(OrgCartQuery query) {
		return selectCount(query,SQL_ID_SELECT_GOODS_COUNT);
	}

	@Override
	public int updateByUserIdAndGoodsId(OrgCart orgCart) {
		Assert.notNull(orgCart);
		try {
			return this.sqlSession.update(getSqlName(SQL_ID_UPDATE_BY_USERID_AND_GOODSID), orgCart);
		} catch (Exception e) {
			throw new DaoException(String.format("更新对象出错！语句：%s", getSqlName(SQL_ID_UPDATE_BY_USERID_AND_GOODSID)), e);
		}
	}
}