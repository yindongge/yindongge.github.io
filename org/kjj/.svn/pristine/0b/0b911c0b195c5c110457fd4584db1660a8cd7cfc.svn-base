package com.kjj.commserver.service.leveldiscount;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCoupon;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCouponDiscount;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgUserLevelCouponService extends BaseService<OrgUserLevelCoupon, Integer> {

	/**
	 * 电商会员价格列表分页
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgUserLevelCouponVo> selectLevelCoupon(OrgUserLevelCouponQuery query,
			Pageable pageable);
	
	/**
	 * 更新电商会员价格-生效
	 * @param goodsId
	 * @return
	 */
	void updateActive(Integer couponId);
	
	/**
	 * 更新电商会员价格-无效
	 * @param goodsId
	 * @return
	 */
	void updateNoActive(Integer couponId);
	
	/**
	 * 删除电商会员价格折扣
	 * @param couponId
	 * @return
	 */
	void deleteByCouponId(Integer couponId);
	
	/**
	 * 保存新增的电商会员价格折扣
	 * @param coupon
	 * @param discountStr
	 * @param admin
	 * @return
	 */
	void addLevelCoupon(OrgUserLevelCoupon coupon, String discountStr, OrgAdminUserSession admin);
	
	/**
	 * 将id转换成店铺名
	 * @param shopIds
	 * @return
	 */
	String convertShopName(String shopIds);
	
	void  queryMap4ViewTest();
	
	
	/**
	 * 根据商品返回会员级别的折扣或价格
	 * @param orgUsersSession
	 * @param goodsIds
	 * @param mapItemAide
	 * @return
	 */
	Map<Integer,OrgUserLevelCouponDiscount> queryMap4View(OrgUsersSession orgUsersSession,Collection<Integer> goodsIds,Map<Integer,OrgProductItemAide> mapItemAide);
}