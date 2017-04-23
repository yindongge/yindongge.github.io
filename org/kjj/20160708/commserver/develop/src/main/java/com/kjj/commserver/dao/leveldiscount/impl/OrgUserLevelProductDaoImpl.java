package com.kjj.commserver.dao.leveldiscount.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.leveldiscount.OrgUserLevelProductDao;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelProduct;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelProductQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelProductVo;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgUserLevelProductDaoImpl extends BaseDaoImpl<OrgUserLevelProduct, Integer> implements OrgUserLevelProductDao {

	private static final String SQL_ID_SELECT_LEVEL_PRODUCT = "selectLevelProduct";
	private static final String SQL_ID_SELECT_LEVEL_PRODUCT_COUNT = "selectLevelProductCount";
	
	private static final String SQL_ID_SELECT_PRODUCT_LEVEL = "selectProductLevel";
	private static final String SQL_ID_SELECT_PRODUCT_LEVEL_COUNT = "selectProductLevelCount";
	
	
	private long selectCountComment(OrgUserLevelProductQuery query,String sqlId) {
		return selectCount(query, sqlId);
	}
	

	@Override
	public Page<OrgUserLevelProductVo> selectPageLevelProduct(OrgUserLevelProductQuery query, Pageable pageable) {
		List<OrgUserLevelProductVo> contentList = sqlSession.selectList(getSqlName(SQL_ID_SELECT_LEVEL_PRODUCT),getParams(query, pageable));
		return new PageImpl<OrgUserLevelProductVo>(contentList, pageable, selectCountComment(query, SQL_ID_SELECT_LEVEL_PRODUCT_COUNT));
	}
	
	@Override
	public Page<OrgUserLevelProductVo> selectPageProductLevel(OrgUserLevelProductQuery query, Pageable pageable) {
		List<OrgUserLevelProductVo> contentList = sqlSession.selectList(getSqlName(SQL_ID_SELECT_PRODUCT_LEVEL),getParams(query, pageable));
		return new PageImpl<OrgUserLevelProductVo>(contentList, pageable, selectCountComment(query, SQL_ID_SELECT_PRODUCT_LEVEL_COUNT));
	}
}