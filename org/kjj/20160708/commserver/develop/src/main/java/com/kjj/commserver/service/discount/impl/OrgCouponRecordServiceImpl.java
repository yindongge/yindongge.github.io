package com.kjj.commserver.service.discount.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgCouponRecordDao;
import com.kjj.commserver.entity.discount.OrgCoupon;
import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.OrgDiscountProduct;
import com.kjj.commserver.entity.discount.OrgReachCouponOrder;
import com.kjj.commserver.entity.discount.aide.OrgCouponConstant;
import com.kjj.commserver.entity.discount.aide.OrgCouponForm;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordConstant;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordQuery;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordResult;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordResultConstant;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordVo;
import com.kjj.commserver.entity.discount.aide.OrgCouponVo;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopVo;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.goods.aide.OrgProductItemVo;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.discount.OrgCouponService;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.commserver.service.discount.OrgLimitTimeRecordService;
import com.kjj.commserver.service.discount.OrgReachCouponOrderService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;


@Service
public class OrgCouponRecordServiceImpl extends BaseServiceImpl<OrgCouponRecord, Integer> implements OrgCouponRecordService {
    @Resource
    private OrgCouponRecordDao orgCouponRecordDao;
    @Resource
    private OrgDiscountProductService orgDiscountProductService;
    @Resource
    private OrgProductItemService orgProductItemService;
    @Resource
    private OrgLimitTimeRecordService orgLimitTimeRecordService;
    @Resource
    private OrgCouponService orgCouponService;
    @Resource
	private OrgUsersService orgUserService;
    @Resource
    private OrgDiscountShopService orgDiscountShopService;
    @Resource
    private OrgReachCouponOrderService orgReachCouponOrderService;
    @Resource
    private OrgUsersService orgUsersService;
    
    @Override
    protected BaseDao<OrgCouponRecord, Integer> getBaseDao() {
        return orgCouponRecordDao;
    }
    
    @Override
    public List<OrgCouponRecord> queryList4View(OrgUsersSession orgUsersSession,List<OrgCartAll> listCartAll){
		List<OrgCouponRecord> listCouponRecord = queryList4User(orgUsersSession);
		// 删除其中不满足条件的优惠券
		Iterator<OrgCouponRecord> itCouponRecord = listCouponRecord.iterator();
		while (itCouponRecord.hasNext()) {
			// 如果金额不满足条件删除
			if (!isConditionMoney(itCouponRecord.next(),listCartAll)) {
				itCouponRecord.remove();
			}
		}
		return listCouponRecord;
	}
    
    @Override
    public BigDecimal update4Buy(OrgUsersSession orgUsersSession,List<OrgCartAll> listCartAll,Integer couponRecordId){
    	BigDecimal balanceMoney = null;
    	//查询该优惠券，并锁定该记录
    	List<OrgCouponRecord> listCouponRecord = lockQueryList4User(orgUsersSession,couponRecordId);
    	if(CollectionUtils.isEmpty(listCouponRecord)){
    		//失败
    	}else{
    		OrgCouponRecord couponRecord = listCouponRecord.get(0);
    		if(!isConditionMoney(couponRecord,listCartAll)){
    			//失败
    		}else{
    			//优惠券可以使用,分摊优惠金额
    			balanceMoney = updateShareMoney(couponRecord,listCartAll);
    		}
    	}
    	return balanceMoney;
    }
    
    @Override
    public void updateUsed(OrgUsersSession orgUsersSession,Integer couponRecordId,Integer orderId){
    	OrgCouponRecord couponRecord = new OrgCouponRecord();
    	couponRecord.setRecordId(couponRecordId);
    	couponRecord.setUserId(orgUsersSession.getOrgUsers().getUserId());
    	couponRecord.setOrderId(orderId);
    	couponRecord.setStatus(OrgCouponRecordConstant.STATUS_USED);
    	couponRecord.setUseTime(new Date());
    	updateByIdSelective(couponRecord);
    }
    
    /**
     * 分摊优惠金额,返回调整金额
     * @param orgCouponRecord 优惠券
     * @param listCartAll 下单商品详情列表
     */
    private BigDecimal updateShareMoney(OrgCouponRecord orgCouponRecord,List<OrgCartAll> listCartAll){
    	OrgCouponRecordVo couponRecord = (OrgCouponRecordVo)orgCouponRecord;
		OrgProductItemVo productItem = null;
		Map<Integer, OrgDiscountProduct> mapDiscountProduct = null;
		OrgCoupon coupon = couponRecord.getOrgCoupon();
		OrgDiscountProductQuery discountProductQuery = new OrgDiscountProductQuery();
		discountProductQuery.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
		discountProductQuery.setDiscountId(couponRecord.getCouponId());
		// 查询优惠券适用商品范围
		if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_PRODUCT) {
			// 查询优惠券适用商品
			mapDiscountProduct = orgDiscountProductService.queryMap(discountProductQuery, "goodsId");

		} else if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_CLASS) {
			// 查询优惠券适用分类
			mapDiscountProduct = orgDiscountProductService.queryMap(discountProductQuery, "classId");
		}

		//下单商品满足优惠券条件总金额
		BigDecimal sumMoney = couponRecord.getSumMoney();
		//优惠金额合计
		BigDecimal sumDiscountMoney = BigDecimal.ZERO;
		OrgProductItemAide itemAide = null;
		for (OrgCartAll cartAll : listCartAll) {
			itemAide = cartAll.getOrgProductItemAll().getOrgProductItemAide();
			//商品允许使用优惠券
			if (itemAide.getMapDiscountAllow().containsKey(OrgDiscountTypeConstant.TYPE_COUPON)) {
				if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_PRODUCT) {
					// 商品
					// 如商品在优惠券商品范围内
					if (mapDiscountProduct.containsKey(itemAide.getGoodsId())) {
						itemAide.setMarkCoupon(true);
						sumDiscountMoney = sumDiscountMoney.add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
						itemAide.setRealPrice((sumMoney.subtract(coupon.getDiscountMoney()).multiply(itemAide.getRealPrice()).divide(sumMoney,2,BigDecimal.ROUND_HALF_UP)));
						sumDiscountMoney = sumDiscountMoney.subtract(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
					}

				} else if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_CLASS) {
					// 分类
					productItem = (OrgProductItemVo)orgProductItemService.queryVoById(itemAide.getGoodsId());
					// 如商品分类或者上级分类在优惠券分类范围内
					if (mapDiscountProduct.containsKey(productItem.getCatId().intValue())|| mapDiscountProduct.containsKey(productItem.getOrgClass().getClassParent())) {
						itemAide.setMarkCoupon(true);
						sumDiscountMoney = sumDiscountMoney.add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
						itemAide.setRealPrice((sumMoney.subtract(coupon.getDiscountMoney()).multiply(itemAide.getRealPrice()).divide(sumMoney,2,BigDecimal.ROUND_HALF_UP)));
						sumDiscountMoney = sumDiscountMoney.subtract(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
					}
				} else if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_ALL) {
					// 全部商品
					itemAide.setMarkCoupon(true);
					sumDiscountMoney = sumDiscountMoney.add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
					itemAide.setRealPrice((sumMoney.subtract(coupon.getDiscountMoney()).multiply(itemAide.getRealPrice()).divide(sumMoney,2,BigDecimal.ROUND_HALF_UP)));
					sumDiscountMoney = sumDiscountMoney.subtract(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
				}
			}
		}
		//计算调整金额=订单优惠券优惠金额-所有商品优惠总和
		return coupon.getDiscountMoney().subtract(sumDiscountMoney);
    }
    
    /***
     * 优惠券是否满足使用条件
     * @param orgCouponRecord 优惠券
     * @param listCartAll 下单商品详情列表
     * @return
     */
    private boolean isConditionMoney(OrgCouponRecord orgCouponRecord,List<OrgCartAll> listCartAll){
    	OrgCouponRecordVo couponRecord = (OrgCouponRecordVo)orgCouponRecord;
		OrgProductItemVo productItem = null;
		Map<Integer, OrgDiscountProduct> mapDiscountProduct = null;
		OrgCoupon coupon = couponRecord.getOrgCoupon();
		OrgDiscountProductQuery discountProductQuery = new OrgDiscountProductQuery();
		discountProductQuery.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
		discountProductQuery.setDiscountId(couponRecord.getCouponId());
		BigDecimal sumMoney = BigDecimal.ZERO;
		// 查询优惠券适用商品范围
		if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_PRODUCT) {
			// 查询优惠券适用商品
			mapDiscountProduct = orgDiscountProductService.queryMap(discountProductQuery, "goodsId");

		} else if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_CLASS) {
			// 查询优惠券适用分类
			mapDiscountProduct = orgDiscountProductService.queryMap(discountProductQuery, "classId");
		}

		// 查询满足条件的商品总金额
		OrgProductItemAide itemAide = null;
		for (OrgCartAll cartAll : listCartAll) {
			itemAide = cartAll.getOrgProductItemAll().getOrgProductItemAide();
			//商品允许使用优惠券
			if (itemAide.getMapDiscountAllow().containsKey(OrgDiscountTypeConstant.TYPE_COUPON)) {
				if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_PRODUCT) {
					// 商品
					// 如商品在优惠券商品范围内
					if (mapDiscountProduct.containsKey(itemAide.getGoodsId())) {
						sumMoney = sumMoney.add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
					}

				} else if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_CLASS) {
					// 分类
					productItem = (OrgProductItemVo)orgProductItemService.queryVoById(itemAide.getGoodsId());
					// 如商品分类或者上级分类在优惠券分类范围内
					if (mapDiscountProduct.containsKey(productItem.getCatId().intValue())|| mapDiscountProduct.containsKey(productItem.getOrgClass().getClassParent())) {
						sumMoney = sumMoney.add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
					}
				} else if (coupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_ALL) {
					// 全部商品
					sumMoney = sumMoney.add(itemAide.getRealPrice().multiply(BigDecimal.valueOf(itemAide.getUserBuy())));
				}
			}
		}
		//保存下单商品满足优惠券条件总金额
		couponRecord.setSumMoney(sumMoney);
    	return sumMoney.compareTo(coupon.getConditionMoney()) >= 0;
    }
    
    
    /**
     * 查询用户当前可用优惠券
     * @param orgUsersSession
     * @return
     */
    private List<OrgCouponRecord> queryList4User(OrgUsersSession orgUsersSession){
    	OrgCouponRecordQuery query = new OrgCouponRecordQuery();
    	query.setQuery4User(true);
    	query.setOrgUsersSession(orgUsersSession);
    	query.setStatus(OrgCouponRecordConstant.STATUS_UNUSED);
		//查询可用优惠券列表
		Sort sort = new Sort(Direction.DESC,"oc.discount_money");
		return queryList(query, sort);
    }
    /**
     * 查询用户下单时可用优惠券，并锁表
     * @param orgUsersSession
     * @param couponRecordId 下单所用的优惠券
     * @return
     */
    private List<OrgCouponRecord> lockQueryList4User(OrgUsersSession orgUsersSession,Integer couponRecordId){
    	OrgCouponRecordQuery query = new OrgCouponRecordQuery();
    	query.setQuery4User(true);
    	query.setOrgUsersSession(orgUsersSession);
    	query.setStatus(OrgCouponRecordConstant.STATUS_UNUSED);
		//查询下单选择的优惠券
		query.setRecordId(couponRecordId);
		query.setSelect4Update(true);
		return queryList(query);
    }

	@Override
	public void updateUnusedByOrderId(Integer orderId) {
		OrgCouponRecordQuery query = new OrgCouponRecordQuery();
		query.setOrderId(orderId);
		OrgCouponRecord record = queryOne(query);
		if( record != null ){
			record.setStatus(OrgCouponRecordConstant.STATUS_UNUSED);
			record.setOrderId(null);
			record.setUseTime(null);
			updateById(record);
		}
	}

	@Override
	public List<OrgCouponRecord> queryListByRecordIds(Collection<Integer> recordIds) {
		OrgCouponRecordQuery query = new OrgCouponRecordQuery();
		query.setRecordIds(recordIds);
		Sort sort = new Sort(Direction.DESC,"oc.discount_money");
		return queryList(query, sort);
	}

	@Override
	public long queryCountCanUseByUserId(Integer userId) {
		OrgCouponRecordQuery query = new OrgCouponRecordQuery();
		query.setUserId(userId);
		query.setStatusCanUse(true);
		return queryCount(query);
	}

	@Override
	public long queryCountCanNotUseByUserId(Integer userId) {
		OrgCouponRecordQuery query = new OrgCouponRecordQuery();
		query.setUserId(userId);
		query.setStatusCanUse(false);
		return queryCount(query);
	}

	@Override
	public void addBatch(OrgCouponForm orgCouponForm) {
		OrgCouponRecord orgCouponRecord = null;
		for (int i = 0; i < orgCouponForm.getAmount(); i++) {
			orgCouponRecord = new OrgCouponRecord();
			orgCouponRecord.setCouponId(orgCouponForm.getCouponId());
			orgCouponRecord.setStatus(OrgCouponRecordConstant.STATUS_WARI_GET);
			add(orgCouponRecord);
		}
		
	}

	@Override
	public void updateGive(OrgCouponForm orgCouponForm, OrgAdminUserSession admin) {
		OrgUsersQuery user = new OrgUsersQuery();
		List<OrgUsers> listUser = null;
		if(orgCouponForm.getGiveType() == OrgCouponConstant.GIVE_TYPE_ALL_USER){
			listUser =  orgUserService.queryList(user);
		}else if(orgCouponForm.getGiveType() == OrgCouponConstant.GIVE_TYPE_PART_USER){
			//转换查询条件
			String[]  arrayQuery = orgCouponForm.getUserQuery().split(",");
			List<String> listUserQuery = Arrays.asList(arrayQuery);
			user.setListUserQuery(listUserQuery);
			listUser =  orgUserService.queryList(user);
		}
		
		//处理
		for(OrgUsers orgUser : listUser){
			for(int i = 0; i < orgCouponForm.getGiveAmount();i++){
				addRecord4User(orgUser.getUserId(),orgUser.getMobilePhone(),orgCouponForm.getCouponId(),OrgCouponRecordConstant.SOURCE_TYPE_GIVE,admin.getOrgAdminUser().getUserId(),null,orgCouponForm.getRemark());
			}
		}
		
	}

	@Override
	public OrgCouponRecordResult addRecord4User(Integer userId, String mobilePhone,Integer couponId, Byte sourceTypeGive, Short adminId,Integer triggerId, String remark) {
		OrgCouponRecordResult recordResult = new OrgCouponRecordResult();
		recordResult.setResult(false);
		OrgCoupon orgCoupon = orgCouponService.queryById(couponId);
		Date now = new Date();
		
		//状态限制
		if(orgCoupon.getStatus() == OrgCouponConstant.STATUS_INVALID){
			recordResult.setErrorDesc(OrgCouponRecordResultConstant.ERROR_STATUS_INVALID);
			return recordResult;
		}
		
		//时间限制
		Date startTime=null;
		Date endTime=null;
		if(orgCoupon.getLimitDays() == null){
			 startTime = orgCoupon.getStartTime();
			 endTime = orgCoupon.getEndTime();
			if(endTime != null && endTime.before(now) ){
				recordResult.setErrorDesc(OrgCouponRecordResultConstant.ERROR_TIME_OVER);
				return recordResult;
			}
		}
		
		//手机限制
		if(orgCoupon.getCheckPhone() == OrgCouponConstant.CHECK_PHONE_YES){
			if(StringUtils.isBlank(mobilePhone)){
				recordResult.setErrorDesc(OrgCouponRecordResultConstant.ERROR_USER_PHONE_NULL);
				return recordResult;
			}
		}
		
		//领取数量限制
		if(orgCoupon.getUserLimit() > 0){
			OrgCouponRecord orgCouponRecord = new OrgCouponRecord();
			orgCouponRecord.setCouponId(couponId);
			orgCouponRecord.setUserId(userId);
			if(orgCoupon.getCheckPhone() == OrgCouponConstant.CHECK_PHONE_YES){
				//手机限制
				orgCouponRecord.setUserPhone(mobilePhone);
				if(queryCount(orgCouponRecord) >= orgCoupon.getUserLimit()){
					recordResult.setErrorDesc(OrgCouponRecordResultConstant.ERROR_USER_PHONE_OVER);
					return recordResult;
				}
			}else{
				//用户限制
				if(queryCount(orgCouponRecord) >= orgCoupon.getUserLimit()){
					recordResult.setErrorDesc(OrgCouponRecordResultConstant.ERROR_USER_ID_OVER);
					return recordResult;
				}
			}
		}
		
		OrgCouponRecord orgCouponRecord = null;
		if(orgCoupon.getAmount() == 0){
			//不限量
			orgCouponRecord = new OrgCouponRecord();
			orgCouponRecord.setCouponId(orgCoupon.getCouponId());
			orgCouponRecord.setStatus(OrgCouponRecordConstant.STATUS_UNUSED);
			orgCouponRecord.setUserId(userId);
			if (StringUtils.isNotBlank(mobilePhone)) {
				orgCouponRecord.setUserPhone(mobilePhone);
			}
			//来源
			orgCouponRecord.setSource(sourceTypeGive);
			if(sourceTypeGive == OrgCouponRecordConstant.SOURCE_TYPE_GIVE){
				orgCouponRecord.setGiveAdmin(adminId);
			}else if(sourceTypeGive == OrgCouponRecordConstant.SOURCE_TYPE_TRIGGER){
				orgCouponRecord.setTriggerId(triggerId);
			}
			//说明
			orgCouponRecord.setRemark(remark);
			//绑定时间
			orgCouponRecord.setBindingTime(now);
			//有效期
			if(orgCoupon.getLimitDays() == null){
				orgCouponRecord.setStartTime(startTime);
				orgCouponRecord.setEndTime(endTime);
			}else{
				Calendar calendar = Calendar.getInstance();  //得到当前日期和时间
				calendar.set(Calendar.HOUR_OF_DAY, 0);       //把当前时间小时变成０
				calendar.set(Calendar.MINUTE, 0);            //把当前时间分钟变成０
				calendar.set(Calendar.SECOND, 0);            //把当前时间秒数变成０
				calendar.set(Calendar.MILLISECOND, 0);       //把当前时间毫秒变成０
		        Date limitStartTime = calendar.getTime();    //创建当天的0时0分0秒一个date对象
		        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+orgCoupon.getLimitDays()-1);//增加日期
		        calendar.set(Calendar.HOUR_OF_DAY, 23);      //把当前时间小时变成23
				calendar.set(Calendar.MINUTE, 59);           //把当前时间分钟变成59
				calendar.set(Calendar.SECOND, 59);           //把当前时间秒数变成59
				calendar.set(Calendar.MILLISECOND, 0);		 //把当前时间毫秒变成０
				Date limitEndTime = calendar.getTime();      //创建结束天的23时59分59秒一个date对象
				orgCouponRecord.setStartTime(limitStartTime);
				orgCouponRecord.setEndTime(limitEndTime);
			}
			add(orgCouponRecord);
		}else{
			//限量
			orgCouponRecord = lockQueryOneByCouponId(couponId);
			//已经领取完
			if(orgCouponRecord == null){
				recordResult.setErrorDesc(OrgCouponRecordResultConstant.ERROR_AMOUNT_OVER);
				return recordResult;
			}
			orgCouponRecord.setStatus(OrgCouponRecordConstant.STATUS_UNUSED);
			orgCouponRecord.setUserId(userId);
			if (StringUtils.isBlank(mobilePhone)) {
				orgCouponRecord.setUserPhone(mobilePhone);
			}
			//来源
			orgCouponRecord.setSource(sourceTypeGive);
			if(sourceTypeGive == OrgCouponRecordConstant.SOURCE_TYPE_GIVE){
				orgCouponRecord.setGiveAdmin(adminId);
			}else if(sourceTypeGive == OrgCouponRecordConstant.SOURCE_TYPE_TRIGGER){
				orgCouponRecord.setTriggerId(triggerId);
			}
			//说明
			orgCouponRecord.setRemark(remark);
			//绑定时间
			orgCouponRecord.setBindingTime(now);
			//有效期
			if(orgCoupon.getLimitDays() == null){
				orgCouponRecord.setStartTime(startTime);
				orgCouponRecord.setEndTime(endTime);
			}else{
				Calendar calendar = Calendar.getInstance();  //得到当前日期和时间
				calendar.set(Calendar.HOUR_OF_DAY, 0);       //把当前时间小时变成０
				calendar.set(Calendar.MINUTE, 0);            //把当前时间分钟变成０
				calendar.set(Calendar.SECOND, 0);            //把当前时间秒数变成０
				calendar.set(Calendar.MILLISECOND, 0);       //把当前时间毫秒变成０
		        Date limitStartTime = calendar.getTime();    //创建当天的0时0分0秒一个date对象
		        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+orgCoupon.getLimitDays()-1);//增加日期
		        calendar.set(Calendar.HOUR_OF_DAY, 23);      //把当前时间小时变成23
				calendar.set(Calendar.MINUTE, 59);           //把当前时间分钟变成59
				calendar.set(Calendar.SECOND, 59);           //把当前时间秒数变成59
				calendar.set(Calendar.MILLISECOND, 0);		 //把当前时间毫秒变成０
				Date limitEndTime = calendar.getTime();      //创建结束天的23时59分59秒一个date对象
				orgCouponRecord.setStartTime(limitStartTime);
				orgCouponRecord.setEndTime(limitEndTime);
			}
			updateByIdSelective(orgCouponRecord);
		}
		recordResult.setResult(true);
		return recordResult;
	}
	
	private OrgCouponRecord lockQueryOneByCouponId(Integer couponId){
		OrgCouponRecordQuery query = new OrgCouponRecordQuery();
		query.setSelect4Update(true);
		query.setCouponId(couponId);
		query.setStatus(OrgCouponRecordConstant.STATUS_WARI_GET);
		query.setLimitOne(true);
		return queryOne(query);
	}

	@Override
	public List<OrgCouponRecord> queryListWithShop(OrgCouponRecordQuery query) {
		List<OrgCouponRecord> list = queryList(query);
		OrgDiscountShopQuery orgDiscountShopQuery = new OrgDiscountShopQuery();
		orgDiscountShopQuery.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
		Byte shopType = null;
		for (OrgCouponRecord orgCouponRecord : list) {
			List<String> shopNames = new ArrayList<String>();
			OrgCouponRecordVo orgCouponRecordVo = (OrgCouponRecordVo) orgCouponRecord;
			OrgCouponVo orgCouponVo = (OrgCouponVo) orgCouponRecordVo.getOrgCoupon();
			if(orgCouponVo != null){
				shopType = orgCouponVo.getShopType();
				if(shopType.equals(OrgDiscountShopConstant.SHOP_TYPE_SHOP)){
					orgDiscountShopQuery.setDiscountId(orgCouponRecord.getCouponId());
					List<OrgDiscountShopVo> OrgDiscountShopVoList = orgDiscountShopService.queryList(orgDiscountShopQuery);
					for (OrgDiscountShopVo orgDiscountShopVo : OrgDiscountShopVoList) {
						shopNames.add(orgDiscountShopVo.getShopName());
					}
					orgCouponVo.setShopNames(shopNames);
				}
			}
		}
		return list;
	}

	@Override
	public OrgCouponRecord queryOneByOrderId(Integer orderId) {
		OrgCouponRecordQuery query = new OrgCouponRecordQuery();
		query.setOrderId(orderId);
		return queryOne(query);
	}

	@Override
	public void updateGive4Order(OrgOrder orgOrder) {
		List<OrgReachCouponOrder> listOrgReachCouponOrder = orgReachCouponOrderService.queryListByOrderId(orgOrder.getOrderId());
		OrgUsers user = orgUsersService.queryById(orgOrder.getUserId());
		//处理
		for(OrgReachCouponOrder reachCouponOrder : listOrgReachCouponOrder){
			for (int i = 0; i < reachCouponOrder.getAmount(); i++) {
				addRecord4User(orgOrder.getUserId(),user.getMobilePhone(),reachCouponOrder.getCouponId(),OrgCouponRecordConstant.SOURCE_TYPE_GIVE,null,null,"满减活动赠送");
			}
		}
	}
}