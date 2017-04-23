package com.kjj.commserver.dao.goods.impl;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.goods.OrgProductItemDao;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgProductItemDaoImpl extends BaseDaoImpl<OrgProductItem, Integer> implements OrgProductItemDao {
	
	public static final String SQL_ID_UPDATE_SALENUMANDCOMMENTNUM = "updateSaleNumAndCommentNum";
	
	@Override
	public long updateSaleNumAndCommentNum() {
		try {
			return this.sqlSession.update(getSqlName(SQL_ID_UPDATE_SALENUMANDCOMMENTNUM));
		} catch (Exception e) {
			throw new DaoException(String.format("更新对象出错！语句：%s", getSqlName(SQL_ID_UPDATE_SALENUMANDCOMMENTNUM)), e);
		}
	}
}