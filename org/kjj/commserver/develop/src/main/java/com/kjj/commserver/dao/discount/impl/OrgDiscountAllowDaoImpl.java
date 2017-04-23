package com.kjj.commserver.dao.discount.impl;

import java.util.HashMap;
import java.util.Map;

import com.kjj.commserver.dao.discount.OrgDiscountAllowDao;
import com.kjj.commserver.entity.discount.OrgDiscountAllow;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgDiscountAllowDaoImpl extends BaseDaoImpl<OrgDiscountAllow, Integer> implements OrgDiscountAllowDao {
	
	private static final String  SQL_SELECT_INFO="selectInfo";
	
	
	@Override
	public String selectInfo(Byte typeId, Integer discountId) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("typeId", typeId);
		t.put("discountId", discountId);
		return sqlSession.selectOne(getSqlName(SQL_SELECT_INFO), t);
	}
}