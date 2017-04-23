package com.kjj.commserver.dao.goods.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.goods.OrgProductInventoryClearDao;
import com.kjj.commserver.entity.goods.OrgProductInventoryClear;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.exception.DaoException;

@Repository
public class OrgProductInventoryClearDaoImpl extends BaseDaoImpl<OrgProductInventoryClear, Integer> implements OrgProductInventoryClearDao {

	String UPDATE_MEAL_INVENTORY_NUM_ZERO = "updateMealInventoryNumZero";
	
	@Override
	public void updateMealInventoryZero(String timeType, Integer classId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("timeType", timeType);
		param.put("classId", classId);
		try {
			this.sqlSession.update(getSqlName(UPDATE_MEAL_INVENTORY_NUM_ZERO), param);
		} catch (Exception e) {
			throw new DaoException(String.format("清空库存出错！语句：%s", getSqlName(UPDATE_MEAL_INVENTORY_NUM_ZERO)), e);
		}
	}
}