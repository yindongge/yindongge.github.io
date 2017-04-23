package com.kjj.commserver.dao.shop.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.shop.OrgShopPageFloorProductDao;
import com.kjj.commserver.entity.shop.OrgShopPageFloorProduct;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductVo;
import com.kjj.core.dao.BaseDaoImpl;
import com.kjj.core.util.BeanUtils;

@Repository
public class OrgShopPageFloorProductDaoImpl extends BaseDaoImpl<OrgShopPageFloorProduct, Integer> implements OrgShopPageFloorProductDao {

	private static final String SQL_ID_SELECT_COMM_PRODUCT_BY_FLOOR = "queryCommProductByFloor";
	private static final String SQL_ID_SELECT_RECOMMAND_PRODUCT_BY_FLOOR = "queryRecommandProductByFloor";
	private static final String SQL_ID_SELECT_COMM_CANSAIL_PRODUCT_BY_FLOOR = "queryCommCanSailProductByFloor";
	@Override
	public List<OrgShopPageFloorProductVo> queryCommProductByFloor(Integer floorid) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("floorId", floorid);
		return this.sqlSession.selectList(getSqlName(SQL_ID_SELECT_COMM_PRODUCT_BY_FLOOR), parameter);
	}

	@Override
	public List<OrgShopPageFloorProductVo> queryRecommandProductByFloor(Integer floorid) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("floorId", floorid);
		return this.sqlSession.selectList(getSqlName(SQL_ID_SELECT_RECOMMAND_PRODUCT_BY_FLOOR), parameter);
	}

	@Override
	public List<OrgShopPageFloorProductVo> queryCanSailList(OrgShopPageFloorProductQuery query) {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.sqlSession.selectList(getSqlName(SQL_ID_SELECT_COMM_CANSAIL_PRODUCT_BY_FLOOR), params);
	}
}