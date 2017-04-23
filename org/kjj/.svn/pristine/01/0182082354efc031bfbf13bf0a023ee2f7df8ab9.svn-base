package com.kjj.commserver.dao.consult;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.consult.OrgConsultProblem;
import com.kjj.core.dao.BaseDao;

public interface OrgConsultProblemDao extends BaseDao<OrgConsultProblem, Integer> {

	/**
	 * 分页查询商品咨询
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgConsultProblem> selectPageListGoods(OrgConsultProblem query,Pageable pageable);
	/**
	 *  根据consultProblemId查询出商品咨询信息
	 * @param consultProblemId
	 * @return
	 */
	OrgConsultProblem selectByGoodsId(Integer consultProblemId);
}