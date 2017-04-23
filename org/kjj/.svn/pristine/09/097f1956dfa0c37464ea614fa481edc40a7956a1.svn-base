package com.kjj.commserver.service.discount.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgLimitTimeRecordDao;
import com.kjj.commserver.entity.discount.OrgLimitTimeRecord;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeGoodsVo;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeRecordQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgLimitTimeRecordService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgLimitTimeRecordServiceImpl extends BaseServiceImpl<OrgLimitTimeRecord, Integer> implements OrgLimitTimeRecordService {
    @Resource
    private OrgLimitTimeRecordDao orgLimitTimeRecordDao;

    @Override
    protected BaseDao<OrgLimitTimeRecord, Integer> getBaseDao() {
        return orgLimitTimeRecordDao;
    }

	@Override
	public void add4Order(List<OrgCartAll> listCartAll, Integer orderId,OrgUsersSession orgUsersSession) {
		List<OrgLimitTimeRecord> listLimitTimeRecord = new ArrayList<OrgLimitTimeRecord>();
		OrgProductItemAide itemAide = null;
		OrgLimitTimeGoodsVo limitTimeGoods = null;
		OrgLimitTimeRecord limitTimeRecord = null;
		for(OrgCartAll cartAll:listCartAll){
			//如使用限时折扣
			limitTimeGoods = (OrgLimitTimeGoodsVo)cartAll.getOrgProductItemAll().getOrgLimitTimeGoods();
			if(limitTimeGoods != null){
				itemAide = cartAll.getOrgProductItemAll().getOrgProductItemAide();
				limitTimeRecord = new OrgLimitTimeRecord();
				limitTimeRecord.setLtgId(limitTimeGoods.getId());
				limitTimeRecord.setShopId(orgUsersSession.getOrgShop().getShopId());
				limitTimeRecord.setUserId(orgUsersSession.getOrgUsers().getUserId());
				//用户购买量
				limitTimeRecord.setAmount(itemAide.getUserBuy());
				limitTimeRecord.setPrice(limitTimeGoods.getPrice());
				limitTimeRecord.setOrderId(orderId);
				limitTimeRecord.setCreateTime(new Date());
				listLimitTimeRecord.add(limitTimeRecord);
			}
		}
		addInBatch(listLimitTimeRecord);
	}
	
	@Override
	public void deleteByOrderId(Integer orderId) {
		OrgLimitTimeRecordQuery query = new OrgLimitTimeRecordQuery();
		query.setOrderId(orderId);
		delete(query);
	}
}