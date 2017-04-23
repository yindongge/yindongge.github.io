package com.kjj.commserver.dao.user.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.user.OrgUserAddressDao;
import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgUserAddressDaoImpl extends BaseDaoImpl<OrgUserAddress, Integer> implements OrgUserAddressDao {
	
	public static final String SQL_ID_UPDATE_SEND_RANGE = "updateInvaildByShopSendRangeId";

	@Override
	public int updateInvaildByShopSendRangeId(Integer shopSendRangeId) {
		Assert.notNull(shopSendRangeId);
		try {
			return this.sqlSession.update(getSqlName(SQL_ID_UPDATE_SEND_RANGE), shopSendRangeId);
		} catch (Exception e) {
			throw new DaoException(String.format("更新对象出错！语句：%s", getSqlName(SQL_ID_UPDATE_SEND_RANGE)), e);
		}
	}
}