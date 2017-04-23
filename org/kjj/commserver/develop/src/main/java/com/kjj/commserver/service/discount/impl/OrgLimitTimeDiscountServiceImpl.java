package com.kjj.commserver.service.discount.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgLimitTimeDiscountDao;
import com.kjj.commserver.entity.discount.OrgLimitTimeDiscount;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeDiscountConstant;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeDiscountForm;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.commserver.service.discount.OrgDiscountScopeService;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.commserver.service.discount.OrgLimitTimeDiscountService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgLimitTimeDiscountServiceImpl extends BaseServiceImpl<OrgLimitTimeDiscount, Integer> implements OrgLimitTimeDiscountService {
    @Resource
    private OrgLimitTimeDiscountDao orgLimitTimeDiscountDao;

	@Resource
	private OrgDiscountShopService orgDiscountShopService;
	
	@Resource
	private OrgDiscountAllowService orgDiscountAllowService;
	
	@Resource
	private OrgDiscountScopeService orgDiscountScopeService;
    
    @Override
    protected BaseDao<OrgLimitTimeDiscount, Integer> getBaseDao() {
        return orgLimitTimeDiscountDao;
    }

	@Override
	public void add(OrgLimitTimeDiscountForm orgLimitTimeDiscountForm,OrgAdminUserSession admin) {
			
		//初始状态
		orgLimitTimeDiscountForm.setStatus(OrgLimitTimeDiscountConstant.STATUS_INVALID);
		//创建人
		orgLimitTimeDiscountForm.setCreateAdminId(admin.getOrgAdminUser().getUserId());
		//秒杀
		if(orgLimitTimeDiscountForm.getSeckill() == null){
			orgLimitTimeDiscountForm.setSeckill(OrgLimitTimeDiscountConstant.SECKILL_NO);
		}
		//判断手机
		if (orgLimitTimeDiscountForm.getCheckPhone() == null) {
			orgLimitTimeDiscountForm.setCheckPhone(OrgLimitTimeDiscountConstant.CHECK_PHONE_NO);
		}
		orgLimitTimeDiscountForm.setCreateTime(new Date());
		add(orgLimitTimeDiscountForm);
		
		//适用店铺范围
		orgDiscountShopService.addByDiscount(orgLimitTimeDiscountForm.getTypeId(),orgLimitTimeDiscountForm.getId(),orgLimitTimeDiscountForm.getShopType(),orgLimitTimeDiscountForm.getListCity(),orgLimitTimeDiscountForm.getListShop());
		
		//适用优惠范围
		orgDiscountAllowService.addByDiscount(orgLimitTimeDiscountForm.getTypeId(),orgLimitTimeDiscountForm.getId(),orgLimitTimeDiscountForm.getListAllow());
		
		//适用终端范围
		orgDiscountScopeService.addByDiscount(orgLimitTimeDiscountForm.getTypeId(),orgLimitTimeDiscountForm.getId(),orgLimitTimeDiscountForm.getListScope());
				
		
	}

	@Override
	public void update(OrgLimitTimeDiscountForm orgLimitTimeDiscountForm) {
		//秒杀
		if(orgLimitTimeDiscountForm.getSeckill() == null){
			orgLimitTimeDiscountForm.setSeckill(OrgLimitTimeDiscountConstant.SECKILL_NO);
		}
		//判断手机
		if (orgLimitTimeDiscountForm.getCheckPhone() == null) {
			orgLimitTimeDiscountForm.setCheckPhone(OrgLimitTimeDiscountConstant.CHECK_PHONE_NO);
		}
		updateByIdSelective(orgLimitTimeDiscountForm);
		//适用店铺范围
		orgDiscountShopService.updateByDiscount(orgLimitTimeDiscountForm.getTypeId(),orgLimitTimeDiscountForm.getId(),orgLimitTimeDiscountForm.getShopType(),orgLimitTimeDiscountForm.getListCity(),orgLimitTimeDiscountForm.getListShop());
		
		//适用优惠范围
		orgDiscountAllowService.updateByDiscount(orgLimitTimeDiscountForm.getTypeId(),orgLimitTimeDiscountForm.getId(),orgLimitTimeDiscountForm.getListAllow());
		
		//适用终端范围
		orgDiscountScopeService.updateByDiscount(orgLimitTimeDiscountForm.getTypeId(),orgLimitTimeDiscountForm.getId(),orgLimitTimeDiscountForm.getListScope());
		
		
	}

	@Override
	public void updatePause(Integer id) {
		OrgLimitTimeDiscount orgLimitTimeDiscount = queryById(id);	
		if(orgLimitTimeDiscount.getStatus() == OrgLimitTimeDiscountConstant.STATUS_INVALID){
			orgLimitTimeDiscount.setStatus(OrgLimitTimeDiscountConstant.STATUS_VALID);
		}else{
			orgLimitTimeDiscount.setStatus(OrgLimitTimeDiscountConstant.STATUS_INVALID);
		}
		updateByIdSelective(orgLimitTimeDiscount);
	}
}