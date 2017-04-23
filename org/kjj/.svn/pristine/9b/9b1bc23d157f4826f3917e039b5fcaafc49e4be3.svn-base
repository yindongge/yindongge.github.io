package com.kjj.commserver.dao.goods.impl;

import java.util.List;
import java.util.Map;

import com.kjj.commserver.dao.goods.OrgProductLinkSalespecDao;
import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class OrgProductLinkSalespecDaoImpl extends BaseDaoImpl<OrgProductLinkSalespec, Integer> implements OrgProductLinkSalespecDao {

	private static final String SQL_SELECT_BY_GOODSID = "getSpecGroupByGoodsId";
	private static final String SQL_SELECT_BY_ITEMID = "getSpecGroupByItemId";
	private static final String SQL_SELECT_SPECTYPE_BY_ITEMID = "getSpecTypeByItemId";
	
	@Override
	public List<OrgProductLinkSalespec> getSpecGroupByGoodsId(Integer goodId) {
		Assert.notNull(goodId);
		try {
			return this.sqlSession.selectList(getSqlName(SQL_SELECT_BY_GOODSID), goodId);
		} catch (Exception e) {
			throw new DaoException(String.format("更新对象出错！语句：%s", getSqlName(SQL_SELECT_BY_GOODSID)), e);
		}
	}

	@Override
	public List<OrgProductLinkSalespec> getSpecGroupByItemId(Integer itemId) {
		Assert.notNull(itemId);
		try {
			return this.sqlSession.selectList(getSqlName(SQL_SELECT_BY_ITEMID), itemId);
		} catch (Exception e) {
			throw new DaoException(String.format("更新对象出错！语句：%s", getSqlName(SQL_SELECT_BY_ITEMID)), e);
		}
	}

	@Override
	public List<Map<String,Object>> getSpecTypeByItemId(Integer goodId) {
		Assert.notNull(goodId);
		try {
			return this.sqlSession.selectList(getSqlName(SQL_SELECT_SPECTYPE_BY_ITEMID), goodId);
		} catch (Exception e) {
			throw new DaoException(String.format("更新对象出错！语句：%s", getSqlName(SQL_SELECT_SPECTYPE_BY_ITEMID)), e);
		}
	}
}