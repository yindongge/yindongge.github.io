package com.kjj.commserver.entity.system.aide;

import com.kjj.commserver.entity.system.OrgAdminUser;

public class OrgAdminUserForm extends OrgAdminUser{

	/** 菜单modelIds */
	private String modelIds;
	
	/** 角色roleIds */
	private String roleIds;
	
	/** 店铺shopIds */
	private String shopIds;
	
	/** 旧email */
	private String emailOld;

	public String getModelIds() {
		return modelIds;
	}

	public void setModelIds(String modelIds) {
		this.modelIds = modelIds;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getShopIds() {
		return shopIds;
	}

	public void setShopIds(String shopIds) {
		this.shopIds = shopIds;
	}

	public String getEmailOld() {
		return emailOld;
	}

	public void setEmailOld(String emailOld) {
		this.emailOld = emailOld;
	}

}
