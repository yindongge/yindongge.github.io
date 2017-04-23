package com.kjj.commserver.service.user.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgUserAddressDao;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.aide.OrgUserAddressConstant;
import com.kjj.commserver.entity.user.aide.OrgUserAddressQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUserAddressService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgUserAddressServiceImpl extends BaseServiceImpl<OrgUserAddress, Integer> implements OrgUserAddressService {
    @Resource
    private OrgUserAddressDao orgUserAddressDao;
    
    @Resource
    private OrgShopSendRangeService orgShopSendRangeService;
    
    @Resource
	private OrgShopService orgShopService;
    
    @Override
    protected BaseDao<OrgUserAddress, Integer> getBaseDao() {
        return orgUserAddressDao;
    }

	@Override
	public List<OrgUserAddress> getThisShopVaildByUser(OrgUsersSession orgUsersSession) {
		OrgUserAddressQuery query = new OrgUserAddressQuery();
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		query.setShopId(orgUsersSession.getOrgShop().getShopId());
		query.setStatus(OrgUserAddressConstant.STATUS_VALID);
		return queryList(query);
	}

	@Override
	public List<OrgUserAddress> getThisShopInvaildByUser(OrgUsersSession orgUsersSession) {
		OrgUserAddressQuery query = new OrgUserAddressQuery();
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		query.setShopId(orgUsersSession.getOrgShop().getShopId());
		query.setStatus(OrgUserAddressConstant.STATUS_INVALID);
		return queryList(query);
	}
	
	@Override
	public List<OrgUserAddress> getListVaildByUser(OrgUsersSession orgUsersSession) {
		OrgUserAddressQuery query = new OrgUserAddressQuery();
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		query.setStatus(OrgUserAddressConstant.STATUS_VALID);
		query.setShopStatus(OrgShopConstant.STATUS_SHOW);
		Sort sort = new Sort(Direction.DESC,"t.update_time");
		return queryList(query,sort);
	}

	@Override
	public List<OrgUserAddress> getListInvaildByUser(OrgUsersSession orgUsersSession) {
		OrgUserAddressQuery query = new OrgUserAddressQuery();
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		query.setStatus(OrgUserAddressConstant.STATUS_INVALID);
		query.setShopStatus(OrgShopConstant.STATUS_SHOW);
		Sort sort = new Sort(Direction.DESC,"t.update_time");
		return queryList(query,sort);
	}

	@Override
	public List<OrgUserAddress> getOtherShopByUser(OrgUsersSession orgUsersSession) {
		OrgUserAddressQuery query = new OrgUserAddressQuery();
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		query.setNotEqualShopId(orgUsersSession.getOrgShop().getShopId());
		return queryList(query);
	}
	
	@Override
	public List<OrgUserAddress> getByUser(OrgUsersSession orgUsersSession) {
		OrgUserAddressQuery query = new OrgUserAddressQuery();
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		Sort sort = new Sort(Direction.DESC,"t.shop_id","t.address_id");
		return queryList(query,sort);
	}
	
	@Override
	public void add(OrgUserAddress orgUserAddress) {
		OrgShopVo shop =orgShopService.queryVoById(orgUserAddress.getShopId());
		orgUserAddress.setAddressName(orgUserAddress.getConsignee()+" "+shop.getShopName());
		orgUserAddress.setStatus(OrgUserAddressConstant.STATUS_VALID);
		orgUserAddress.setUpdateTime(new Date());
		super.add(orgUserAddress);
	}

	@Override
	public void update(OrgUserAddress orgUserAddress) {
		OrgShopVo shop = orgShopService.queryVoById(orgUserAddress.getShopId());
		orgUserAddress.setAddressName(orgUserAddress.getConsignee()+" "+shop.getShopName());
		orgUserAddress.setStatus(OrgUserAddressConstant.STATUS_VALID);
		orgUserAddress.setUpdateTime(new Date());
		updateByIdSelective(orgUserAddress);
	}

	@Override
	public OrgUserAddress queryLastAddressByUserId(Integer userId) {
		OrgUserAddressQuery query = new OrgUserAddressQuery();
		query.setUserId(userId);
		Sort sort = new Sort(Direction.DESC,"t.update_time");
		return queryOne(query,sort);
	}

	@Override
	public void updateInvaildByShopSendRangeId(Integer shopSendRangeId) {
		orgUserAddressDao.updateInvaildByShopSendRangeId(shopSendRangeId);
	}

}