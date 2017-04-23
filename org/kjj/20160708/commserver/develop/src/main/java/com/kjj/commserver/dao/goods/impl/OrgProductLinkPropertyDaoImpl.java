package com.kjj.commserver.dao.goods.impl;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.goods.OrgProductLinkPropertyDao;
import com.kjj.commserver.entity.goods.OrgProductLinkProperty;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkPropertyQuery;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;
import com.kjj.core.util.BeanUtils;

@Repository
public class OrgProductLinkPropertyDaoImpl extends BaseDaoImpl<OrgProductLinkProperty, Integer> implements OrgProductLinkPropertyDao {

	public static final String SELECT_GOODS_PROPS = "selectGoodsByProps";
	
	@Override
	public Collection<Integer> queryGoodsIdsByProps(OrgProductLinkPropertyQuery query) {
		Assert.notNull(query);
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.sqlSession.selectList(getSqlName(OrgProductLinkPropertyDaoImpl.SELECT_GOODS_PROPS), params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象出错！语句：%s", getSqlName(OrgProductLinkPropertyDaoImpl.SELECT_GOODS_PROPS)), e);
		}
	}
}