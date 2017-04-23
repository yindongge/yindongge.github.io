package com.kjj.commserver.service.discount;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.aide.OrgCouponForm;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordQuery;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordResult;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgCouponRecordService extends BaseService<OrgCouponRecord, Integer> {
	
	/**
	 * 查询可使用的优惠券列表
	 * @param orgUsersSession session中user
	 * @param listCartAll 下单商品详情列表
	 * @return
	 */
	List<OrgCouponRecord> queryList4View(OrgUsersSession orgUsersSession,List<OrgCartAll> listCartAll);
	
	/**
	 * 下单使用优惠券，返回调整金额（如返回null，表示失败）
	 * @param orgUsersSession session中user
	 * @param listCartAll 购物车详情列表
	 * @param couponRecordId 优惠券记录ID
	 * @return
	 */
	BigDecimal update4Buy(OrgUsersSession orgUsersSession,List<OrgCartAll> listCartAll,Integer couponRecordId);
	
	/**
	 * 修改优惠券为已使用
	 * @param orgUsersSession session中user
	 * @param couponRecordId 优惠券记录ID
	 * @param orderId 订单ID
	 */
	void updateUsed(OrgUsersSession orgUsersSession,Integer couponRecordId,Integer orderId);

	/**
	 * 修改订单的优惠券为未使用
	 * @param orderId
	 */
	void updateUnusedByOrderId(Integer orderId);

	/**
	 * 查询多个优惠券
	 * @param recordIds
	 * @return
	 */
	List<OrgCouponRecord> queryListByRecordIds(Collection<Integer> recordIds);
	
	/**
	 * 查询用户可用优惠券数量
	 * @param userId
	 * @return
	 */
	long queryCountCanUseByUserId(Integer userId);
	
	/**
	 * 查询用户不可用优惠券数量
	 * @param userId
	 * @return
	 */
	long queryCountCanNotUseByUserId(Integer userId);
	/**
	 * 限量券生成
	 * @param orgCouponVo
	 */
	void addBatch(OrgCouponForm orgCouponForm);
	/**
	 * 修改优惠券发放信息
	 * @param org_coupon
	 * @param admin
	 */
	void updateGive(OrgCouponForm orgCouponForm, OrgAdminUserSession admin);
	
	/**
	 * 获取优惠券
	 * @param userId
	 * @param mobilePhone
	 * @param couponId
	 * @param sourceTypeGive 1:获取 2：发放 3：触发
	 * @param adminId
	 * @param triggerId
	 * @param remark
	 * @return
	 */
	OrgCouponRecordResult addRecord4User(Integer userId, String mobilePhone,Integer couponId, Byte sourceTypeGive, Short adminId,Integer triggerId, String remark);
	
	/**
	 * 查询用户优惠券及优惠券店铺信息
	 * @param query
	 * @return
	 */
	List<OrgCouponRecord> queryListWithShop(OrgCouponRecordQuery query);
	
	/**
	 * 根据orderId查询优惠券
	 * @param id
	 * @return
	 */
	OrgCouponRecord queryOneByOrderId(Integer orderId);
	
	/**
	 * 根据订单赠送优惠券
	 * @param orgOrder
	 */
	void updateGive4Order(OrgOrder orgOrder);
}