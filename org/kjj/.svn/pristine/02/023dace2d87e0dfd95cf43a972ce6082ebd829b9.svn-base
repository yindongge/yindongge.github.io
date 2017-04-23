package com.kjj.commserver.dao.discount.impl;

import java.util.HashMap;
import java.util.Map;

import com.kjj.commserver.dao.discount.OrgDiscountShopDao;
import com.kjj.commserver.entity.discount.OrgDiscountShop;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgDiscountShopDaoImpl extends BaseDaoImpl<OrgDiscountShop, Integer> implements OrgDiscountShopDao {

	private static final String  SQL_SELECT_INFO="selectInfo";
	
	@Override
	public Map<String, String> selectInfo(Byte typeId, Integer discountId) {
		Map<String,String> map = new HashMap<String,String>();
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("typeId", typeId);
		t.put("discountId", discountId);
		map = sqlSession.selectOne(getSqlName(SQL_SELECT_INFO), t);
		return map;
	}
}