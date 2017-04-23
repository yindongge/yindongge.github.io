package com.kjj.commserver.dao.goods;

import java.util.Collection;

import com.kjj.commserver.entity.goods.OrgProductLinkProperty;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkPropertyQuery;
import com.kjj.core.dao.BaseDao;

public interface OrgProductLinkPropertyDao extends BaseDao<OrgProductLinkProperty, Integer> {
	
	Collection<Integer> queryGoodsIdsByProps(OrgProductLinkPropertyQuery query);
}