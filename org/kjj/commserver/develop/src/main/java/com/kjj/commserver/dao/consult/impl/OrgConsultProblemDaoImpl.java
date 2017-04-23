package com.kjj.commserver.dao.consult.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.kjj.commserver.dao.consult.OrgConsultProblemDao;
import com.kjj.commserver.entity.consult.OrgConsultProblem;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgConsultProblemDaoImpl extends BaseDaoImpl<OrgConsultProblem, Integer> implements OrgConsultProblemDao {

	public static final String SELECT_GOODS = "selectGoods";
	public static final String SELECT_COUNT_GOODS = "selectCountGoods";
	public static final String SELECT_BY_PRIMARYKEY_GOODS = "selectByPrimaryKeyGoods";
	
	private long selecCountGoods(OrgConsultProblem query) {
		return selectCount(query,SELECT_COUNT_GOODS);
	}
	
	@Override
	public Page<OrgConsultProblem> selectPageListGoods(OrgConsultProblem query, Pageable pageable) {
		List<OrgConsultProblem> contentList = sqlSession.selectList(getSqlName(SELECT_GOODS),getParams(query, pageable));
		return new PageImpl<OrgConsultProblem>(contentList, pageable, selecCountGoods(query));
	}

	@Override
	public OrgConsultProblem selectByGoodsId(Integer consultProblemId) {
			Assert.notNull(consultProblemId);
		return  selectById(consultProblemId, SELECT_BY_PRIMARYKEY_GOODS);
	}
}