package com.kjj.commserver.dao.goods;

import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;
import com.kjj.core.dao.BaseDao;

public interface OrgProductLinkSalespecDao extends BaseDao<OrgProductLinkSalespec, Integer> {
	
	  List<OrgProductLinkSalespec> getSpecGroupByGoodsId(Integer goodId);
	
	  List<OrgProductLinkSalespec> getSpecGroupByItemId(Integer itemId);
	  
	  List<Map<String,Object>>  getSpecTypeByItemId(Integer goodId);
	  
	  
}