package com.kjj.commserver.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.system.OrgAdminLinkRoleDao;
import com.kjj.commserver.entity.system.OrgAdminLinkRole;
import com.kjj.commserver.entity.system.aide.OrgAdminLinkRoleQuery;
import com.kjj.commserver.service.system.OrgAdminLinkRoleService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAdminLinkRoleServiceImpl extends BaseServiceImpl<OrgAdminLinkRole, Integer> implements OrgAdminLinkRoleService {
    @Resource
    private OrgAdminLinkRoleDao orgAdminLinkRoleDao;

    @Override
    protected BaseDao<OrgAdminLinkRole, Integer> getBaseDao() {
        return orgAdminLinkRoleDao;
    }

	@Override
	public List<OrgAdminLinkRole> queryByUserId(Integer userId) {
		OrgAdminLinkRoleQuery query = new OrgAdminLinkRoleQuery();
		query.setUserid(userId);
		return queryList(query);
	}


	@Override
	public void addInRoleIds(String roleIds, Short userId) {
		if(StringUtils.isNotBlank(roleIds)){
			List<OrgAdminLinkRole> list = new ArrayList<OrgAdminLinkRole>();
			String ids[] = roleIds.split(",");
			for(String id : ids){
				OrgAdminLinkRole orgAdminLinkRole = new OrgAdminLinkRole();
				orgAdminLinkRole.setUserid((int)userId);
				orgAdminLinkRole.setRoleid(Integer.parseInt(id));
				list.add(orgAdminLinkRole);
			}
			addInBatch(list);
		}
	}

	@Override
	public int deleteByUserId(Short userId) {
		OrgAdminLinkRoleQuery query = new OrgAdminLinkRoleQuery();
		query.setUserid(userId.intValue());
		return delete(query);
	}

	@Override
	public int deleteByRoleId(Integer roleId) {
		OrgAdminLinkRoleQuery query = new OrgAdminLinkRoleQuery();
		query.setRoleid(roleId);
		return delete(query);
	}
}