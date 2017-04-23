package com.kjj.commserver.service.consult;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.consult.OrgConsultProblem;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemQuery;
import com.kjj.core.service.BaseService;
public interface OrgConsultProblemService extends BaseService<OrgConsultProblem, Integer> {
	
	/***
	 * 查询商品咨询
	 * @param query
	 * @param
	 * @return
	 */
	Page<OrgConsultProblem> queryList4Goods(OrgConsultProblem query,Pageable pageable);

	/***
	 * 查询网站咨询
	 * @param query
	 * @param
	 * @return
	 */
	Page<OrgConsultProblem> queryList4Web(OrgConsultProblem query,Pageable pageable);
	/**
	 * 查询后台商品咨询
	 * @param query
	 * @param pageReq
	 * @return
	 */
	Page<OrgConsultProblem> queryPageListGoods(OrgConsultProblemQuery query, Pageable pageable);
	/**
	 * 根据consultProblemId查询出商品咨询信息
	 * @param consultProblemId
	 * @return
	 */
	OrgConsultProblem queryByGoodsId(Integer consultProblemId);
	/**
	 * 查询网站商品咨询
	 * @param query
	 * @param pageReq
	 * @return
	 */
	Page<OrgConsultProblem> queryPageListWeb(OrgConsultProblemQuery query, Pageable pageable);
}