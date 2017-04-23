package com.kjj.commserver.service.system.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.system.OrgAdminRoleDao;
import com.kjj.commserver.entity.system.OrgAdminRole;
import com.kjj.commserver.service.system.OrgAdminLinkRoleService;
import com.kjj.commserver.service.system.OrgAdminRoleService;
import com.kjj.commserver.service.system.OrgRoleRightService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAdminRoleServiceImpl extends BaseServiceImpl<OrgAdminRole, Integer> implements OrgAdminRoleService {
    @Resource
    private OrgAdminRoleDao orgAdminRoleDao;
    @Resource
    private OrgRoleRightService orgRoleRightService;
    @Resource
    private OrgAdminLinkRoleService orgAdminLinkRoleService;

    @Override
    protected BaseDao<OrgAdminRole, Integer> getBaseDao() {
        return orgAdminRoleDao;
    }

	@Override
	public void add(OrgAdminRole orgAdminRole, String modelIds) {
		orgAdminRole.setCreattime(new Date());
		add(orgAdminRole);
		//添加角色菜单
		orgRoleRightService.addByRoleId(orgAdminRole.getRoleId(), modelIds);
	}

	@Override
	public void update(OrgAdminRole orgAdminRole, String modelIds) {
		updateByIdSelective(orgAdminRole);
		//删除角色菜单
		orgRoleRightService.deleteByRoleId(orgAdminRole.getRoleId());
		//添加角色菜单
		orgRoleRightService.addByRoleId(orgAdminRole.getRoleId(), modelIds);
	}
	
	@Override
	public int deleteById(Integer roleId){
		//删除角色菜单
		orgRoleRightService.deleteByRoleId(roleId);
		//删除用户角色
		orgAdminLinkRoleService.deleteByRoleId(roleId);
		return super.deleteById(roleId);
	}
}