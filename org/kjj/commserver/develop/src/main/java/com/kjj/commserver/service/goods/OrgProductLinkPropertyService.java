package com.kjj.commserver.service.goods;

import java.util.Collection;

import com.kjj.commserver.entity.goods.OrgProductLinkProperty;
import com.kjj.core.service.BaseService;

public interface OrgProductLinkPropertyService extends BaseService<OrgProductLinkProperty, Integer> {
	
	//通过url参数查询商品Id组
	Collection<Integer> queryGoodsIdsByUrlParam(String url);
	
	//通过url参数查询商品Brand组
	Collection<Integer> queryBrandsByUrlParam(String url);
}