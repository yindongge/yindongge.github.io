package com.kjj.commserver.service.special.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.special.OrgSpecialTimeDao;
import com.kjj.commserver.entity.special.OrgSpecialTime;
import com.kjj.commserver.entity.special.aide.OrgSpecialTimeQuery;
import com.kjj.commserver.service.special.OrgSpecialTimeService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgSpecialTimeServiceImpl extends BaseServiceImpl<OrgSpecialTime, Integer> implements OrgSpecialTimeService {
    @Resource
    private OrgSpecialTimeDao orgSpecialTimeDao;

    @Override
    protected BaseDao<OrgSpecialTime, Integer> getBaseDao() {
        return orgSpecialTimeDao;
    }

	@Override
	public void updateBySpecialId(OrgSpecialTime orgSpecialTime) {
		if(orgSpecialTime.getSpecialId()!=null){
			OrgSpecialTimeQuery orgSpecialTimeQuery = new OrgSpecialTimeQuery();
			orgSpecialTimeQuery.setSpecialId(orgSpecialTime.getSpecialId());
			OrgSpecialTime OrgSpecialTmp = queryOne(orgSpecialTimeQuery);
			if(OrgSpecialTmp!=null){
				Integer id = OrgSpecialTmp.getId();
				orgSpecialTime.setId(id);
				updateByIdSelective(orgSpecialTime);
			}
		}
	}
}
