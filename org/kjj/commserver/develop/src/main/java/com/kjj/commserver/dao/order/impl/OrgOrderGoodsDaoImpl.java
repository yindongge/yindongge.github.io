package com.kjj.commserver.dao.order.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.order.OrgOrderGoodsDao;
import com.kjj.commserver.entity.goods.aide.OrgGoodsReportVo;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgOrderGoodsDaoImpl extends BaseDaoImpl<OrgOrderGoods, Integer> implements OrgOrderGoodsDao {
	
	public static final String SQL_ID_COMMENT = "selectComment";
	public static final String SQL_ID_COUNT_COMMENT= "selectCountComment";
	public static final String SQL_ID_COUNT_OTHER = "selectCountOther";
	public static final String SQL_ID_SELECT_4UPDATE = "selectByPrimaryKey4Update";
	public static final String SQL_ID_ORDER_REPORT = "selectOrderReport";
	public static final String SQL_ID_COUNT_GOODS_REPORT = "selectCountGoodsReport";
	public static final String SQL_ID_GOODS_REPORT = "selectGoodsReport";
	
	private long selectCountComment(OrgOrderGoods query) {
		return selectCount(query,SQL_ID_COUNT_COMMENT);
	}
	
	@Override
	public Page<OrgOrderGoods> selectPageListComment(OrgOrderGoods query, Pageable pageable) {
		List<OrgOrderGoods> contentList = sqlSession.selectList(getSqlName(SQL_ID_COMMENT),getParams(query, pageable));
		return new PageImpl<OrgOrderGoods>(contentList, pageable, selectCountComment(query));
	}
	
	@Override
	public List<OrgOrderGoods> selectListComment(OrgOrderGoods query) {
		return selectList(query,SQL_ID_COMMENT);
	}
	
	@Override
	public long selectOtherCount(OrgOrderGoods query) {
		return selectCount(query,SQL_ID_COUNT_OTHER);
	}

	@Override
	public OrgOrderGoods selectById4Update(Integer orderGoodsId) {
		return selectById(orderGoodsId,SQL_ID_SELECT_4UPDATE);
	}

	@Override
	public List<OrgOrderGoods> selectList4OrderReport(OrgOrderGoods query) {
		return selectList(query,SQL_ID_ORDER_REPORT);
	}

	private long selectCountGoodsReport(OrgOrderGoods query){
		return selectCount(query,SQL_ID_COUNT_GOODS_REPORT);
	}
	
	@Override
	public Page<OrgGoodsReportVo> selectPageList4GoodsReport(OrgOrderGoods query,Pageable pageable) {
		List<OrgGoodsReportVo> contentList = sqlSession.selectList(getSqlName(SQL_ID_GOODS_REPORT),getParams(query, pageable));
		return new PageImpl<OrgGoodsReportVo>(contentList,pageable,selectCountGoodsReport(query));
	}

	@Override
	public List<OrgGoodsReportVo> selectList4GoodsReport(OrgOrderGoods query) {
		return selectList(query,SQL_ID_GOODS_REPORT);
	}
}