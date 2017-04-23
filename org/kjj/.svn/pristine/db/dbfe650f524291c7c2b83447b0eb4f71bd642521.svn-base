package com.kjj.commserver.service.discount.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgDiscountTriggerDao;
import com.kjj.commserver.entity.discount.OrgDiscountTrigger;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTriggerConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.discount.OrgDiscountTriggerService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgDiscountTriggerServiceImpl extends BaseServiceImpl<OrgDiscountTrigger, Integer> implements OrgDiscountTriggerService {
    @Resource
    private OrgDiscountTriggerDao orgDiscountTriggerDao;
    @Resource
    private OrgCouponRecordService orgCouponRecordService;

    @Override
    protected BaseDao<OrgDiscountTrigger, Integer> getBaseDao() {
        return orgDiscountTriggerDao;
    }

	@Override
	public void add(OrgDiscountTrigger orgDiscountTrigger,OrgAdminUserSession admin) {
		//状态
		orgDiscountTrigger.setStatus(OrgDiscountTriggerConstant.STATUS_VALID);
		//创建人
		orgDiscountTrigger.setCreateAdminId(admin.getOrgAdminUser().getUserId());
		orgDiscountTrigger.setCreateTime(new Date());
		add(orgDiscountTrigger);
		
	}

	@Override
	public void updatePause(Integer id) {
		OrgDiscountTrigger orgDiscountTrigger = queryById(id);
		if(orgDiscountTrigger.getStatus() == OrgDiscountTriggerConstant.STATUS_INVALID){
			orgDiscountTrigger.setStatus(OrgDiscountTriggerConstant.STATUS_VALID);
		}else{
			orgDiscountTrigger.setStatus(OrgDiscountTriggerConstant.STATUS_INVALID);
		}
		updateByIdSelective(orgDiscountTrigger);
		
	}
	
	@Override
	public void updateTrigger(Byte triggerType,OrgUsers user) {
		//查询触发的优惠
		OrgDiscountTrigger query =  new OrgDiscountTrigger();
		query.setTriggerType(triggerType);
		query.setStatus(OrgDiscountTriggerConstant.STATUS_VALID);
		List<OrgDiscountTrigger> listTrigger = queryList(query);
		
		for(OrgDiscountTrigger trigger:listTrigger){
			if(trigger.getTypeId() == OrgDiscountTypeConstant.TYPE_COUPON){
				//优惠券
				for (int i = 0; i < trigger.getTriggerAmount(); i++) {
					orgCouponRecordService.addRecord4User(user.getUserId(), user.getMobilePhone(), trigger.getDiscountId(), OrgCouponRecordConstant.SOURCE_TYPE_TRIGGER,null,trigger.getId(),null);
				}
			}
		}
	}
}