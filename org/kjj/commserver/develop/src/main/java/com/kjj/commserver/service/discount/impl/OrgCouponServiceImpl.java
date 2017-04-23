package com.kjj.commserver.service.discount.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgCouponDao;
import com.kjj.commserver.entity.discount.OrgCoupon;
import com.kjj.commserver.entity.discount.aide.OrgCouponConstant;
import com.kjj.commserver.entity.discount.aide.OrgCouponForm;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.discount.OrgCouponService;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.commserver.service.discount.OrgDiscountScopeService;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgCouponServiceImpl extends BaseServiceImpl<OrgCoupon, Integer> implements OrgCouponService {
    @Resource
    private OrgCouponDao orgCouponDao;
    
	@Resource
	private OrgCouponRecordService orgCouponRecordService;
	
	@Resource
	private OrgDiscountShopService orgDiscountShopService;
	
	@Resource
	private OrgDiscountProductService orgDiscountProductService;
	
	@Resource
	private OrgDiscountScopeService orgDiscountScopeService;

    @Override
    protected BaseDao<OrgCoupon, Integer> getBaseDao() {
        return orgCouponDao;
    }

	@Override
	public void add(OrgCouponForm orgCouponForm, OrgAdminUserSession admin) {
		//有效期
		if(orgCouponForm.getTimeType() == OrgCouponConstant.TIME_TYPE_START_END){
			orgCouponForm.setLimitDays(null);
		}else if(orgCouponForm.getTimeType() == OrgCouponConstant.TIME_TYPE_LIMIT_DAYS){
			orgCouponForm.setStartTime(null);
			orgCouponForm.setEndTime(null);
		}
		//判断手机
		if (orgCouponForm.getCheckPhone() == null) {
			orgCouponForm.setCheckPhone(OrgCouponConstant.CHECK_PHONE_NO);
		}
		//初始状态
		orgCouponForm.setStatus(OrgCouponConstant.STATUS_INVALID);
		//创建人
		orgCouponForm.setCreateAdminId(admin.getOrgAdminUser().getUserId());
		orgCouponForm.setCreateTime(new Date());
		add(orgCouponForm);
		
		//适用店铺范围
		orgDiscountShopService.addByDiscount(orgCouponForm.getTypeId(),orgCouponForm.getCouponId(),orgCouponForm.getShopType(),orgCouponForm.getListCity(),orgCouponForm.getListShop());
		
		//适用商品分类范围
		orgDiscountProductService.addByDiscount(orgCouponForm.getTypeId(),orgCouponForm.getCouponId(),orgCouponForm.getProductType(),orgCouponForm.getListClass(),orgCouponForm.getListGoods());
		
		//适用终端范围
		orgDiscountScopeService.addByDiscount(orgCouponForm.getTypeId(),orgCouponForm.getCouponId(),orgCouponForm.getListScope());
		
		//限量券生成
		if(orgCouponForm.getAmount() > 0){
			orgCouponRecordService.addBatch(orgCouponForm);
		}
		
	}

	@Override
	public void updatePause(Integer couponId) {
		OrgCoupon orgCoupon = queryById(couponId);	
		if(orgCoupon.getStatus() == OrgCouponConstant.STATUS_INVALID){
			orgCoupon.setStatus(OrgCouponConstant.STATUS_VALID);
		}else{
			orgCoupon.setStatus(OrgCouponConstant.STATUS_INVALID);
		}
		updateByIdSelective(orgCoupon);
	}

	@Override
	public void update(OrgCouponForm orgCouponForm) {
		//有效期
		if(orgCouponForm.getTimeType() == OrgCouponConstant.TIME_TYPE_START_END){
			orgCouponForm.setLimitDays(null);
		}else if(orgCouponForm.getTimeType() == OrgCouponConstant.TIME_TYPE_LIMIT_DAYS){
			orgCouponForm.setStartTime(null);
			orgCouponForm.setEndTime(null);
		}
		//判断手机
		if (orgCouponForm.getCheckPhone() == null) {
			orgCouponForm.setCheckPhone(OrgCouponConstant.CHECK_PHONE_NO);
		}
		updateByIdSelective(orgCouponForm);
		
		//适用店铺范围
		orgDiscountShopService.updateByDiscount(orgCouponForm.getTypeId(),orgCouponForm.getCouponId(),orgCouponForm.getShopType(),orgCouponForm.getListCity(),orgCouponForm.getListShop());
		
		//适用商品分类范围
		orgDiscountProductService.updateByDiscount(orgCouponForm.getTypeId(),orgCouponForm.getCouponId(),orgCouponForm.getProductType(),orgCouponForm.getListClass(),orgCouponForm.getListGoods());
		
		//适用终端范围
		orgDiscountScopeService.updateByDiscount(orgCouponForm.getTypeId(),orgCouponForm.getCouponId(),orgCouponForm.getListScope());
		
	}
}