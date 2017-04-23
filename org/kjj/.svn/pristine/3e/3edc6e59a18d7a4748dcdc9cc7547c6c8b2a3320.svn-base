package com.kjj.commserver.service.system.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.system.OrgAdminUserDao;
import com.kjj.commserver.entity.system.OrgAdminUser;
import com.kjj.commserver.entity.system.aide.OrgAdminUserForm;
import com.kjj.commserver.entity.system.aide.OrgAdminUserQuery;
import com.kjj.commserver.service.system.OrgAdminAuthorityService;
import com.kjj.commserver.service.system.OrgAdminLinkRoleService;
import com.kjj.commserver.service.system.OrgAdminShopService;
import com.kjj.commserver.service.system.OrgAdminUserService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAdminUserServiceImpl extends BaseServiceImpl<OrgAdminUser, Short> implements OrgAdminUserService {
    @Resource
    private OrgAdminUserDao orgAdminUserDao;
    @Resource
    private OrgAdminAuthorityService orgAdminAuthorityService;
    @Resource
    private OrgAdminShopService orgAdminShopService;
    @Resource
    private OrgAdminLinkRoleService orgAdminLinkRoleService;

    @Override
    protected BaseDao<OrgAdminUser, Short> getBaseDao() {
        return orgAdminUserDao;
    }

	@Override
	public long queryCountByEmail(String email) {
		OrgAdminUserQuery query = new OrgAdminUserQuery();
		query.setEmail(email);
		return queryCount(query);
	}

	@Override
	public OrgAdminUser queryByMobile(String mobile) {
		OrgAdminUserQuery query = new OrgAdminUserQuery();
		query.setMobile(mobile);
		return queryOne(query);
	}

	@Override
	public void add(OrgAdminUserForm orgAdminUserForm) {
		orgAdminUserForm.setAddTime(new Date());
		orgAdminUserForm.setMobile(orgAdminUserForm.getEmail());
		super.add(orgAdminUserForm);
		// 添加菜单
		orgAdminAuthorityService.addInModelIds(orgAdminUserForm.getModelIds(),orgAdminUserForm.getUserId());
		// 添加角色
		orgAdminLinkRoleService.addInRoleIds(orgAdminUserForm.getRoleIds(),orgAdminUserForm.getUserId());
		// 添加店铺信息
		orgAdminShopService.addInShopIds(orgAdminUserForm.getShopIds(),orgAdminUserForm.getUserId());
	}

	@Override
	public void update(OrgAdminUserForm orgAdminUserForm) {
		orgAdminUserForm.setMobile(orgAdminUserForm.getEmail());
		updateByIdSelective(orgAdminUserForm);
		// 编辑菜单
		orgAdminAuthorityService.deleteByUserId(orgAdminUserForm.getUserId());
		orgAdminAuthorityService.addInModelIds(orgAdminUserForm.getModelIds(),orgAdminUserForm.getUserId());
		// 编辑角色
		orgAdminLinkRoleService.deleteByUserId(orgAdminUserForm.getUserId());
		orgAdminLinkRoleService.addInRoleIds(orgAdminUserForm.getRoleIds(),orgAdminUserForm.getUserId());
		// 编辑店铺信息
		orgAdminShopService.deleteByShopId(orgAdminUserForm.getUserId());
		orgAdminShopService.addInShopIds(orgAdminUserForm.getShopIds(),orgAdminUserForm.getUserId());
	}
}