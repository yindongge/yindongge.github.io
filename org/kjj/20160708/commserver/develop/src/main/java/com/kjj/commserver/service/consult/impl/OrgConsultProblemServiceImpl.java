package com.kjj.commserver.service.consult.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.consult.OrgConsultProblemDao;
import com.kjj.commserver.entity.consult.OrgConsultAnswer;
import com.kjj.commserver.entity.consult.OrgConsultProblem;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemConstant;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemQuery;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemVo;
import com.kjj.commserver.service.consult.OrgConsultAnswerService;
import com.kjj.commserver.service.consult.OrgConsultProblemService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgConsultProblemServiceImpl extends BaseServiceImpl<OrgConsultProblem, Integer> implements OrgConsultProblemService {
    @Resource
    private OrgConsultProblemDao orgConsultProblemDao;
    
    @Resource
    private OrgConsultAnswerService orgConsultAnswerService;
    
    @Override
    protected BaseDao<OrgConsultProblem, Integer> getBaseDao() {
        return orgConsultProblemDao;
    }

	@Override
	public Page<OrgConsultProblem> queryList4Goods(OrgConsultProblem query, Pageable pageable) {
		query.setConsultClassId(OrgConsultProblemConstant.CONSULT_CLASS_GOODS);
		Page<OrgConsultProblem> page = orgConsultProblemDao.selectPageListGoods(query,pageable);
		addConsultAnswer(page.getContent());
		return page;
	}
	
	@Override
	public Page<OrgConsultProblem> queryList4Web(OrgConsultProblem query, Pageable pageable) {
		query.setConsultClassId(OrgConsultProblemConstant.CONSULT_CLASS_WEB);
		return queryPageList(query, pageable);
	}
	/**
	 * 添加商品咨询对应咨询内容
	 * @param listConsultProblem
	 */
	private void addConsultAnswer(List<OrgConsultProblem> listConsultProblem){
		if(CollectionUtils.isNotEmpty(listConsultProblem)){
			Map<Integer,OrgConsultProblemVo> map = new HashMap<Integer,OrgConsultProblemVo>();
			OrgConsultProblemVo orgConsultProblemVo = null;
			for(OrgConsultProblem orgConsultProblem : listConsultProblem){
				orgConsultProblemVo =(OrgConsultProblemVo) orgConsultProblem;
				map.put(orgConsultProblemVo.getConsultProblemId(), orgConsultProblemVo);
			}
			
			List<OrgConsultAnswer> ConsultProblemIds = orgConsultAnswerService.queryByConsultProblemIds(map.keySet());
			for(OrgConsultAnswer orgConsultAnswer : ConsultProblemIds){
				map.get(orgConsultAnswer.getConsultProblemId()).getListOrgConsultAnswer().add(orgConsultAnswer);
			}
		}
	}

	@Override
	public Page<OrgConsultProblem> queryPageListGoods(OrgConsultProblemQuery query, Pageable pageable) {
		query.setConsultClassId(OrgConsultProblemConstant.CONSULT_CLASS_GOODS);
		return orgConsultProblemDao.selectPageListGoods(query,pageable);
	}

	@Override
	public OrgConsultProblem queryByGoodsId(Integer consultProblemId) {
		return orgConsultProblemDao.selectByGoodsId(consultProblemId);
	}

	@Override
	public Page<OrgConsultProblem> queryPageListWeb(OrgConsultProblemQuery query, Pageable pageable) {
		query.setConsultClassId(OrgConsultProblemConstant.CONSULT_CLASS_WEB);
		return orgConsultProblemDao.selectPageListGoods(query,pageable);
	}
	
}