package com.kjj.commserver.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.system.OrgRoleRightDao;
import com.kjj.commserver.entity.system.OrgRoleRight;
import com.kjj.commserver.entity.system.aide.OrgRoleRightQuery;
import com.kjj.commserver.service.system.OrgRoleRightService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgRoleRightServiceImpl extends BaseServiceImpl<OrgRoleRight, Integer> implements OrgRoleRightService {
    @Resource
    private OrgRoleRightDao orgRoleRightDao;

    @Override
    protected BaseDao<OrgRoleRight, Integer> getBaseDao() {
        return orgRoleRightDao;
    }

	@Override
	public List<OrgRoleRight> queryByRoleId(Integer roleid) {
		OrgRoleRightQuery query = new OrgRoleRightQuery();
		query.setRoleid(roleid);
		return queryList(query);
	}

	@Override
	public void addByRoleId(Integer roleId, String modelIds) {
		if(StringUtils.isNotBlank(modelIds)){
			List<OrgRoleRight> list = new ArrayList<OrgRoleRight>();
			String ids[] = modelIds.split(",");
			OrgRoleRight orgRoleRight = null;
			for (String id : ids) {
				orgRoleRight = new OrgRoleRight();
				orgRoleRight.setRoleid(roleId);
				orgRoleRight.setModelid(Integer.parseInt(id));
				list.add(orgRoleRight);
			}
			addInBatch(list);
		}
	}

	@Override
	public int deleteByRoleId(Integer roleId) {
		OrgRoleRightQuery query = new OrgRoleRightQuery();
		query.setRoleid(roleId);
		return delete(query);
	}

	@Override
	public int deleteByModelId(Integer modelId) {
		OrgRoleRightQuery query = new OrgRoleRightQuery();
		query.setModelid(modelId);
		return delete(query);
	}
}