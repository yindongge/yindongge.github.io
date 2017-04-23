package com.kjj.commserver.service.goods.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgProductLinkSalespecDao;
import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.goods.OrgProductLinkSalespecService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgProductLinkSalespecServiceImpl extends BaseServiceImpl<OrgProductLinkSalespec, Integer> implements OrgProductLinkSalespecService {
    @Resource
    private OrgProductLinkSalespecDao orgProductLinkSalespecDao;
    
    @Resource
    private OrgProductItemService orgProductItemService;

    @Override
    protected BaseDao<OrgProductLinkSalespec, Integer> getBaseDao() {
        return orgProductLinkSalespecDao;
    }

	@Override
	public List<OrgProductLinkSalespec> getSpecGroupByGoodsId(Integer goodsId) {
		return orgProductLinkSalespecDao.getSpecGroupByGoodsId(goodsId);
	}

	
	@Override
	public List<OrgProductLinkSalespec> getSpecGroupByItemId(Integer itemId) {
		return orgProductLinkSalespecDao.getSpecGroupByItemId(itemId);
	}

	@Override
	public List<Map<String,Object>> getSpecTypeByItemId(Integer goodId) {
		return orgProductLinkSalespecDao.getSpecTypeByItemId(goodId);
	}
	
}