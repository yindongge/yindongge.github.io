package com.kjj.commserver.service.consult;

import java.util.Collection;
import java.util.List;

import com.kjj.commserver.entity.consult.OrgConsultAnswer;
import com.kjj.commserver.entity.consult.aide.OrgConsultAnswerVo;
import com.kjj.core.service.BaseService;

public interface OrgConsultAnswerService extends BaseService<OrgConsultAnswer, Integer> {

	
	/**
	 * 根据商品咨询号查询咨询内容
	 * @param collection orderIds
	 * @return
	 */
	
	List<OrgConsultAnswer>  queryByConsultProblemIds(Collection<Integer> ConsultProblemIds);
	/**
	 * 获取咨询回复信息
	 * @return
	 */
	List<OrgConsultAnswerVo> queryByCousultAnswer(Integer consultProblemId);
	
	
	/**
	 * 前台回复
	 */
	void syncWebReply(Integer userId,OrgConsultAnswer orgConsultAnswer);
	
	
}