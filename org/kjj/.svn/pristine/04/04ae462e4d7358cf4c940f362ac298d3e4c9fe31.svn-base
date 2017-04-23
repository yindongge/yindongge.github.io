package com.kjj.commserver.service.consult.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.consult.OrgConsultStateDao;
import com.kjj.commserver.entity.consult.OrgConsultState;
import com.kjj.commserver.entity.consult.aide.OrgConsultStateConstant;
import com.kjj.commserver.entity.consult.aide.OrgConsultStateQuery;
import com.kjj.commserver.service.consult.OrgConsultStateService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgConsultStateServiceImpl extends BaseServiceImpl<OrgConsultState, Integer> implements OrgConsultStateService {
    @Resource
    private OrgConsultStateDao orgConsultStateDao;

    @Override
    protected BaseDao<OrgConsultState, Integer> getBaseDao() {
        return orgConsultStateDao;
    }

	@Override
	public List<OrgConsultState> queryByConsultState() {
		OrgConsultStateQuery query = new OrgConsultStateQuery();
		query.setConsultStateType(OrgConsultStateConstant.CONSULT_STATE_TYPE_1);
		return queryList(query);
	}

	@Override
	public List<OrgConsultState> queryByConsultStateType() {
		OrgConsultStateQuery query = new OrgConsultStateQuery();
		query.setConsultStateType(OrgConsultStateConstant.CONSULT_STATE_TYPE_2);
		return queryList(query);
	}
}