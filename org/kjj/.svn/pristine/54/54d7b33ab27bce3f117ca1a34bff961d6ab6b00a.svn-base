package com.kjj.commserver.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.system.OrgAdminAuthorityDao;
import com.kjj.commserver.entity.system.OrgAdminAuthority;
import com.kjj.commserver.entity.system.aide.OrgAdminAuthorityQuery;
import com.kjj.commserver.service.system.OrgAdminAuthorityService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAdminAuthorityServiceImpl<T> extends BaseServiceImpl<OrgAdminAuthority, Integer> implements OrgAdminAuthorityService {
    @Resource
    private OrgAdminAuthorityDao orgAdminAuthorityDao;

    @Override
    protected BaseDao<OrgAdminAuthority, Integer> getBaseDao() {
        return orgAdminAuthorityDao;
    }

	@Override
	public List<OrgAdminAuthority> queryByUserId(Integer userId) {
		OrgAdminAuthorityQuery query = new OrgAdminAuthorityQuery();
		query.setUserId(userId);
		return queryList(query);
	}

	@Override
	public void addInModelIds(String modelIds,Short userId) {
		if(StringUtils.isNotBlank(modelIds)){
			List<OrgAdminAuthority> list = new ArrayList<OrgAdminAuthority>();
			String ids[] = modelIds.split(",");
			for (String id : ids) {
				OrgAdminAuthority orgAdminAuthority = new OrgAdminAuthority();
				orgAdminAuthority.setUserId((int)userId);
				orgAdminAuthority.setAuthorityid(Integer.parseInt(id));
				list.add(orgAdminAuthority);
			}
			addInBatch(list);
		}
	}

	@Override
	public int deleteByAuthorityId(Integer authorityid) {
		OrgAdminAuthorityQuery query = new OrgAdminAuthorityQuery();
		query.setAuthorityid(authorityid);
		return delete(query);
	}

	@Override
	public int deleteByUserId(Short userId) {
		OrgAdminAuthorityQuery query = new OrgAdminAuthorityQuery();
		query.setUserId(userId.intValue());
		return delete(query);
	}
}