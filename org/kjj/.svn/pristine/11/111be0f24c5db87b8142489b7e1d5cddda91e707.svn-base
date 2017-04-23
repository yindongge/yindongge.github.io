package com.kjj.commserver.service.shop.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopDao;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgShopBindService;
import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.shop.aide.OrgShopBindServiceQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopForm;
import com.kjj.commserver.entity.shop.aide.OrgShopQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.service.shop.OrgShopBindServiceService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.shop.OrgShopServiceService;
import com.kjj.commserver.util.CommServerPropertiesUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopServiceImpl extends BaseServiceImpl<OrgShop, Integer> implements OrgShopService {
    @Resource
    private OrgShopDao orgShopDao;
    @Resource
	private OrgShopBindServiceService orgShopBindServiceService;
    @Resource
	private OrgShopSendRangeService orgShopSendRangeService;
    @Resource
    private OrgShopPageService orgShopPageService;
    @Resource
    private OrgShopServiceService orgShopServiceService;
    
    @Override
    protected BaseDao<OrgShop, Integer> getBaseDao() {
        return orgShopDao;
    }

	@Override
	public Page<OrgShop> selectPageListView(OrgShop query, Pageable pageable) {
		return orgShopDao.selectPageListView(query, pageable);
	}

	@Override
	public void updateHide(Integer shopId) {
		OrgShop shop = new OrgShop();
		shop.setShopId(shopId);
		shop.setStatus(OrgShopConstant.STATUS_HIDE);
		updateByIdSelective(shop);
	}

	@Override
	public void updateShow(Integer shopId) {
		OrgShop shop = new OrgShop();
		shop.setShopId(shopId);
		shop.setStatus(OrgShopConstant.STATUS_SHOW);
		updateByIdSelective(shop);
	}

	@Override
	public void add(OrgShopForm shopForm) {
		//添加商铺
		if(shopForm.getBusinessAreaId() == -1){
			shopForm.setBusinessAreaId(null);
		}
		shopForm.setStatus(OrgShopConstant.STATUS_SHOW);
		shopForm.setCreateTime(new Date());
		shopForm.setUpdateTime(new Date());
		//修改时间
		super.add(shopForm);
		//添加配送范围
		if(CollectionUtils.isNotEmpty(shopForm.getSendRangeList())){
			OrgShopSendRange orgShopSendRange = new OrgShopSendRange();
			orgShopSendRange.setShopId(shopForm.getShopId());
			for(String sendRange:shopForm.getSendRangeList()){
				orgShopSendRange.setSendRangeName(sendRange);
				orgShopSendRangeService.add(orgShopSendRange);
			}
		}
		//添加商户服务
		if(CollectionUtils.isNotEmpty(shopForm.getShopServiceList())){
			OrgShopBindService oegShopBindSerice = new OrgShopBindService();
			oegShopBindSerice.setShopId(shopForm.getShopId());
			for(short serviceId:shopForm.getShopServiceList()){
				oegShopBindSerice.setServiceId(serviceId);;
				orgShopBindServiceService.add(oegShopBindSerice);
			}
		}
	}

	@Override
	public long queryCountByShopCode(String shopCode) {
		OrgShopQuery query = new OrgShopQuery();
		query.setShopCode(shopCode);
		return queryCount(query);
	}

	@Override
	public void update(OrgShopForm shopForm) {
		//修改商铺
		if(shopForm.getBusinessAreaId() == -1){
			shopForm.setBusinessAreaId(null);
		}
		shopForm.setUpdateTime(new Date());
		//修改时间
		updateByIdSelective(shopForm);
		//删除原商户服务
		OrgShopBindServiceQuery query = new OrgShopBindServiceQuery();
		query.setShopId(shopForm.getShopId());
		orgShopBindServiceService.delete(query);
		//添加商户服务
		//排除服务为空的情况
		if(CollectionUtils.isNotEmpty(shopForm.getShopServiceList())){
			OrgShopBindService orgShopBindService = new OrgShopBindService();
			orgShopBindService.setShopId(shopForm.getShopId());
			for(short service_id:shopForm.getShopServiceList()){
				orgShopBindService.setServiceId(service_id);;
				orgShopBindServiceService.add(orgShopBindService);
			}
		}
	}

	@Override
	public OrgShop queryViewVoById(Integer id) {
		return orgShopDao.selectViewVoById(id);
	}

	@Override
	public List<OrgShop> queryShopListByCode(String areaCode) {
		OrgShopQuery query = new OrgShopQuery();
		query.setAreaCodeLike(areaCode);
		return queryList(query);
	}
	
	@Override
	public List<OrgShop> queryNearbyShopList(OrgLocation orgLocation) {
		OrgShopQuery query = new OrgShopQuery();
		query.setStatus(OrgShopConstant.STATUS_SHOW);
		if(orgLocation != null && orgLocation.getLatitude() != null && orgLocation.getLongitude() != null){
			query.setOrgLocation(orgLocation);
			Sort sort = new Sort(Direction.ASC,"distance");
			return queryList(query,sort);
		}else{
			//未定位
			Sort sort = new Sort(Direction.ASC,"t.update_time");
			return queryList(query,sort);
		}
	}
	
	@Override
	public OrgShop queryNearbyShop(OrgLocation orgLocation) {
		if(orgLocation != null && orgLocation.getLatitude() != null && orgLocation.getLongitude() != null){
			OrgShopQuery query = new OrgShopQuery();
			query.setStatus(OrgShopConstant.STATUS_SHOW);
			query.setOrgLocation(orgLocation);
			Sort sort = new Sort(Direction.ASC,"distance");
			return queryOne(query,sort);
		}else{
			//无定位信息，返回默认店铺
			return getDefaultShop();
		}
	}
	
	@Override
	public Map<String,List<OrgShop>> getCountyGroupByShopList(List<OrgShop> listShop){
		Map<String,List<OrgShop>> mapCounty = new LinkedHashMap<String,List<OrgShop>>();
		if(CollectionUtils.isNotEmpty(listShop)){
			OrgShopVo shopVo = null;
			String countyName = null;
			List<OrgShop> listShopTemp = null;
			for(OrgShop shop : listShop){
				shopVo = (OrgShopVo)shop;
				countyName = shopVo.getArea()[2];
				//添加区县
				if (!mapCounty.containsKey(countyName)) {
					listShopTemp = new ArrayList<OrgShop>();
					mapCounty.put(countyName, listShopTemp);
				}
				mapCounty.get(countyName).add(shopVo);
			}
		}
		return mapCounty;
	}

	@Override
	public OrgShop getDefaultShop() {
		return queryVoById(Integer.parseInt(CommServerPropertiesUtil.getProperty("default.shopId")));
	}

	@Override
	public List<OrgShop> queryListAll() {
		OrgShopQuery query = new OrgShopQuery();
		return queryList(query);
	}
	
	@Override
	public List<OrgShop> queryListAllShow() {
		OrgShopQuery query = new OrgShopQuery();
		query.setStatus(OrgShopConstant.STATUS_SHOW);
		Sort sort = new Sort(Direction.ASC,"t.area_code,t.shop_order");
		return queryList(query,sort);
	}

	@Override
	public OrgShop queryVoById4Session(Integer shopId) {
		OrgShopVo shop = queryVoById(shopId);
		shop.setShopSearch(orgShopPageService.queryShopSearchByShop(shop));
		shop.setHasMealService(orgShopServiceService.hasMealServiceByShopId(shopId));
		return shop;
	}
}