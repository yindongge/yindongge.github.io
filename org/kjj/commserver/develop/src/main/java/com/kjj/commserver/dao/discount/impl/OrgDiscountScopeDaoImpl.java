package com.kjj.commserver.dao.discount.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.discount.OrgDiscountScopeDao;
import com.kjj.commserver.entity.discount.OrgDiscountScope;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgDiscountScopeDaoImpl extends BaseDaoImpl<OrgDiscountScope, Integer> implements OrgDiscountScopeDao {

	private static final String  SQL_SELECT_INFO="selectInfo";
	
	@Override
	public String selectInfo(Byte typeId, Integer discountId) {
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("typeId", typeId);
		t.put("discountId", discountId);
		return sqlSession.selectOne(getSqlName(SQL_SELECT_INFO), t);
	}
}