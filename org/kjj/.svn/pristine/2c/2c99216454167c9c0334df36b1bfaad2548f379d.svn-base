package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopPageFloorProductDao;
import com.kjj.commserver.entity.shop.OrgShopPageFloorProduct;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductVo;
import com.kjj.commserver.service.shop.OrgShopPageFloorProductService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopPageFloorProductServiceImpl extends BaseServiceImpl<OrgShopPageFloorProduct, Integer> implements OrgShopPageFloorProductService {
    @Resource
    private OrgShopPageFloorProductDao orgShopPageFloorProductDao;

    @Override
    protected BaseDao<OrgShopPageFloorProduct, Integer> getBaseDao() {
        return orgShopPageFloorProductDao;
    }

	@Override
	public List<OrgShopPageFloorProductVo> queryCommProductByFloor(Integer floorid) {
		// TODO Auto-generated method stub
		return orgShopPageFloorProductDao.queryCommProductByFloor(floorid);
	}

	@Override
	public List<OrgShopPageFloorProductVo> queryRecommandProductByFloor(Integer floorid) {
		// TODO Auto-generated method stub
		return orgShopPageFloorProductDao.queryRecommandProductByFloor(floorid);
	}

	@Override
	public List<OrgShopPageFloorProduct> queryListRecommandByFloorid(Integer floorid) {
		OrgShopPageFloorProductQuery query = new OrgShopPageFloorProductQuery();
		query.setFloorid(floorid);
		query.setType(OrgShopPageFloorProductConstant.TYPE_RECOMMAND);
		query.setProductidNotEqual(OrgShopPageFloorProductConstant.PRODUCTID_EMPTY);
		return queryList(query);
	}
	
	@Override
	public List<OrgShopPageFloorProduct> queryListCommonByFloorid(Integer floorid) {
		OrgShopPageFloorProductQuery query = new OrgShopPageFloorProductQuery();
		query.setFloorid(floorid);
		query.setType(OrgShopPageFloorProductConstant.TYPE_COMMON);
		query.setProductidNotEqual(OrgShopPageFloorProductConstant.PRODUCTID_EMPTY);
		return queryList(query);
	}
}