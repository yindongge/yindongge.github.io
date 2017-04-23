package com.kjj.commserver.dao.discount.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.discount.OrgLimitTimeGoodsDao;
import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgLimitTimeGoodsDaoImpl extends BaseDaoImpl<OrgLimitTimeGoods, Integer> implements OrgLimitTimeGoodsDao {

	private static final String SQL_ID_UPDATE_BY_GOODSID_AND_LTDID = "updateByGoodsIdAndLtdId";

	@Override
	public int updateByGoodsIdAndLtdId(OrgLimitTimeGoods orgLimitTimeGoods) {
		Assert.notNull(orgLimitTimeGoods);
		try {
			return this.sqlSession.update(getSqlName(SQL_ID_UPDATE_BY_GOODSID_AND_LTDID), orgLimitTimeGoods);
		} catch (Exception e) {
			throw new DaoException(String.format("更新对象出错！语句：%s", getSqlName(SQL_ID_UPDATE_BY_GOODSID_AND_LTDID)), e);
		}
	}
}