package com.kjj.commserver.dao.goods.impl;

import java.util.List;

import com.kjj.commserver.dao.goods.OrgProductInventoryDao;
import com.kjj.commserver.entity.goods.OrgProductInventory;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryVo;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgProductInventoryDaoImpl extends BaseDaoImpl<OrgProductInventory, Integer> implements OrgProductInventoryDao {

	private static final String SQL_ID_SELECT_MEAL = "selectMeal";
	private static final String SQL_ID_SELECT_4UPDATE = "selectByPrimaryKey4Update";
	
	@Override
	public List<OrgProductInventoryVo> queryMealList(OrgProductInventoryQuery query) {
		return sqlSession.selectList(getSqlName(SQL_ID_SELECT_MEAL),query);
	}

	@Override
	public OrgProductInventory selectById4Update(Integer id) {
		return selectById(id, SQL_ID_SELECT_4UPDATE);
	}
}