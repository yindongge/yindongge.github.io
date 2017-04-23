package com.kjj.commserver.service.consult.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.consult.OrgConsultTypeDao;
import com.kjj.commserver.entity.consult.OrgConsultType;
import com.kjj.commserver.entity.consult.aide.OrgConsultTypeQuery;
import com.kjj.commserver.service.consult.OrgConsultTypeService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgConsultTypeServiceImpl extends BaseServiceImpl<OrgConsultType, Integer> implements OrgConsultTypeService {
    @Resource
    private OrgConsultTypeDao orgConsultTypeDao;

    @Override
    protected BaseDao<OrgConsultType, Integer> getBaseDao() {
        return orgConsultTypeDao;
    }

	@Override
	public List<OrgConsultType> queryByConsultType(Integer consultClassId) {
		OrgConsultTypeQuery query =new OrgConsultTypeQuery();
		query.setConsultClassId(consultClassId);
		return queryList(query);
	}
}