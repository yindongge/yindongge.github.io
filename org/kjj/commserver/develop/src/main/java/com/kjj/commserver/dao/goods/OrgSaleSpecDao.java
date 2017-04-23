package com.kjj.commserver.dao.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.core.dao.BaseDao;

public interface OrgSaleSpecDao extends BaseDao<OrgSaleSpec, Integer> {
	
	List<OrgSaleSpec> queryByProductTypeId(Integer typeId);
}