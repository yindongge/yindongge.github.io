package com.kjj.commserver.dao.leveldiscount;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCoupon;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponVo;
import com.kjj.core.dao.BaseDao;

public interface OrgUserLevelCouponDao extends BaseDao<OrgUserLevelCoupon, Integer> {
	
	/**
	 * 查询电商价格分页
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgUserLevelCouponVo> selectLevelCoupon(OrgUserLevelCouponQuery query,Pageable pageable);
	
	/**
	 * 获取要计算时的所有列表
	 * @param coupon
	 * @return
	 */
	List<OrgUserLevelCoupon> selectCalList(OrgUserLevelCoupon coupon);

}