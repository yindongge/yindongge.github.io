package com.kjj.commserver.dao.leveldiscount.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.leveldiscount.OrgUserLevelCouponDao;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCoupon;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponVo;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgUserLevelCouponDaoImpl extends BaseDaoImpl<OrgUserLevelCoupon, Integer> implements OrgUserLevelCouponDao {

	private static final String SQL_ID_SELECT_LEVEL_COUPON = "selectLevelCoupon";
	private static final String SQL_ID_SELECT_LEVEL_COUPON_COUNT = "selectLevelCouponCount";
	
	private static final String SQL_ID_SELECT_CAL_LIST = "selectCalList";
	
	private long selectCountComment(OrgUserLevelCouponQuery query,String sqlId) {
		return selectCount(query, sqlId);
	}
	

	@Override
	public Page<OrgUserLevelCouponVo> selectLevelCoupon(OrgUserLevelCouponQuery query,
			Pageable pageable) {
		List<OrgUserLevelCouponVo> contentList = sqlSession.selectList(getSqlName(SQL_ID_SELECT_LEVEL_COUPON),getParams(query, pageable));
		return new PageImpl<OrgUserLevelCouponVo>(contentList, pageable, selectCountComment(query, SQL_ID_SELECT_LEVEL_COUPON_COUNT));
	}

	@Override
	public List<OrgUserLevelCoupon> selectCalList(OrgUserLevelCoupon coupon) {
		return sqlSession.selectList(getSqlName(SQL_ID_SELECT_CAL_LIST), coupon);
	}
	
}