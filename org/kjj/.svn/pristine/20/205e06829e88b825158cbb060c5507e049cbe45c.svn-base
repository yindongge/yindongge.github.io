package com.kjj.commserver.service.shop.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopPageFloorDao;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.shop.OrgShopPageFloor;
import com.kjj.commserver.entity.shop.OrgShopPageFloorProduct;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductVo;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.shop.OrgShopPageFloorProductService;
import com.kjj.commserver.service.shop.OrgShopPageFloorService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopPageFloorServiceImpl extends BaseServiceImpl<OrgShopPageFloor, Integer> implements OrgShopPageFloorService {
    @Resource
    private OrgShopPageFloorDao orgShopPageFloorDao;
    
    @Resource
    private OrgShopPageFloorProductService orgShopPageFloorProductService;
    
    @Resource
    private OrgProductItemService orgProductItemService;
    
    @Override
    protected BaseDao<OrgShopPageFloor, Integer> getBaseDao() {
        return orgShopPageFloorDao;
    }

	@Override
	public List<OrgShopPageFloor> queryActiveByPageId(Integer pageId) {
		OrgShopPageFloorQuery query = new OrgShopPageFloorQuery();
		query.setPageid(pageId);
		query.setIsactive(OrgShopPageFloorConstant.STATUS_ACTIVE);
		Sort sort = new Sort(Direction.ASC,"t.floorid");
		return queryList(query,sort);
	}



	@Override
	public void deleteFloorByPageId(Integer pageId) {
		orgShopPageFloorDao.deleteFloorByPageId(pageId);
		
	}

	@Override
	public List<OrgShopPageFloorVo> queryByPageIdAsc(Integer pageId) {
		OrgShopPageFloorQuery query = new OrgShopPageFloorQuery();
		query.setPageid(pageId);
		Sort sort = new Sort(Direction.ASC,"t.floorid");
		return orgShopPageFloorDao.selectList(query, sort);
	}

	@Override
	public List<OrgShopPageFloor> addCommonProductList(OrgUsersSession orgUsersSession, List<OrgShopPageFloor> floorList) {
		List<OrgShopPageFloorProductVo> listCommon = null;
		List<OrgProductItemAll> listItemCommon = null;
		OrgShopPageFloorVo vo= null;
		if(floorList.size()>0){
			for(OrgShopPageFloor floor:floorList){
				//获取楼层对应的普通商品明细
				listCommon =  orgShopPageFloorProductService.queryCommCanSailProductByFloor(orgUsersSession.getOrgShop().getShopCode(),floor.getFloorid());
				 if(CollectionUtils.isNotEmpty(listCommon)){
					 List<Integer> goodsIds = new ArrayList<Integer>();
					 for(OrgShopPageFloorProduct floorProduct : listCommon){
						 goodsIds.add(floorProduct.getProductid());
					 }
					 OrgProductItemQuery query =new OrgProductItemQuery();
					query.setGoodsIds(goodsIds);
					//query.setIsShowZeroInventoryFlg(true);
					query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
					query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
					//query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
					listItemCommon = orgProductItemService.queryList4View(orgUsersSession,query);
				 }else{
					listItemCommon = new ArrayList<OrgProductItemAll>();
				 }
				 
				 for(OrgShopPageFloorProductVo productVo : listCommon){
					 if(CollectionUtils.isNotEmpty(listItemCommon)){
					 for(OrgProductItemAll itemAll : listItemCommon){
						 if(productVo.getProductid().equals(itemAll.getOrgProductItem().getGoodsId())){
							 productVo.setShopPrice(itemAll.getOrgProductItemAide().getRealPrice());
						 }
					 	}
					 }
				 }
				 vo = (OrgShopPageFloorVo) floor;
				 vo.setProductList(listCommon);
			}
		}
		return floorList;
	}
}