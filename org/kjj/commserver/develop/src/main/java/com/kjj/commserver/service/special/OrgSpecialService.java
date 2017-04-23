package com.kjj.commserver.service.special;

import org.springframework.ui.Model;

import com.kjj.commserver.entity.special.OrgSpecial;
import com.kjj.commserver.entity.special.aide.OrgSpecialVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgSpecialService extends BaseService<OrgSpecial, Integer> {
	
	Integer save(OrgSpecialVo orgSpecialVo);
	
	void show(Model model,OrgUsersSession orgUsersSession,Integer specialId);
}