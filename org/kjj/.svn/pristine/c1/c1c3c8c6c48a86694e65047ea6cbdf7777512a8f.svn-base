package com.kjj.commserver.service.operation.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.operation.OrgItemRecommendDao;
import com.kjj.commserver.entity.operation.OrgItemRecommend;
import com.kjj.commserver.entity.operation.aide.OrgItemRecommendConstant;
import com.kjj.commserver.service.operation.OrgItemRecommendService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgItemRecommendServiceImpl extends BaseServiceImpl<OrgItemRecommend, Integer> implements OrgItemRecommendService {
    @Resource
    private OrgItemRecommendDao orgItemRecommendDao;

    @Override
    protected BaseDao<OrgItemRecommend, Integer> getBaseDao() {
        return orgItemRecommendDao;
    }
    
    @Override
    public void add(OrgItemRecommend orgItemRecommend){
    	if(orgItemRecommend.getShopType() != OrgItemRecommendConstant.SHOP_TYPE_CITY){
    		orgItemRecommend.setCityCode(null);
		}
		if(orgItemRecommend.getShopType() != OrgItemRecommendConstant.SHOP_TYPE_SHOP){
			orgItemRecommend.setShopId(null);
		}    	
    	super.add(orgItemRecommend);
    }
    
    @Override
	public int delete(OrgItemRecommend orgItemRecommend) {
    	if(orgItemRecommend.getShopType() != OrgItemRecommendConstant.SHOP_TYPE_CITY){
    		orgItemRecommend.setCityCode(null);
		}
		if(orgItemRecommend.getShopType() != OrgItemRecommendConstant.SHOP_TYPE_SHOP){
			orgItemRecommend.setShopId(null);
		}  
		return super.delete(orgItemRecommend);
	}
}