package com.kjj.commserver.service.system.impl;

import com.kjj.commserver.dao.system.OrgSystemParameterDao;
import com.kjj.commserver.entity.system.OrgSystemParameter;
import com.kjj.commserver.entity.system.aide.OrgSystemParameterNameEnum;
import com.kjj.commserver.entity.system.aide.OrgSystemParameterQuery;
import com.kjj.commserver.service.system.OrgSystemParameterService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class OrgSystemParameterServiceImpl extends BaseServiceImpl<OrgSystemParameter, Integer> implements OrgSystemParameterService {
    @Resource
    private OrgSystemParameterDao orgSystemParameterDao;

    @Override
    protected BaseDao<OrgSystemParameter, Integer> getBaseDao() {
        return orgSystemParameterDao;
    }

	@Override
	public String queryValueByName(OrgSystemParameterNameEnum parameterName) {
		OrgSystemParameterQuery query = new OrgSystemParameterQuery();
		query.setParameterName(parameterName.getParameterName());
		OrgSystemParameter parameter = queryOne(query);
		return parameter == null ? null : parameter.getParameterValue();
	}

	@Override
	public void updateValueByName(OrgSystemParameterNameEnum parameterName,String parameterValue) {
		OrgSystemParameter orgSystemParameter = new OrgSystemParameter();
		orgSystemParameter.setParameterName(parameterName.getParameterName());
		orgSystemParameter.setParameterValue(parameterValue);
		orgSystemParameterDao.updateByName(orgSystemParameter);
	}
}