package com.kjj.commserver.service.user.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgUserLoginDao;
import com.kjj.commserver.entity.user.OrgUserLogin;
import com.kjj.commserver.entity.user.aide.OrgUserLoginQuery;
import com.kjj.commserver.service.user.OrgUserLoginService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgUserLoginServiceImpl extends BaseServiceImpl<OrgUserLogin, Long> implements OrgUserLoginService {
    @Resource
    private OrgUserLoginDao orgUserLoginDao;

    @Override
    protected BaseDao<OrgUserLogin, Long> getBaseDao() {
        return orgUserLoginDao;
    }
    
    @Override
    public void add(OrgUserLogin orgUserLogin){
    	orgUserLogin.setLogintime(new Date());
    	super.add(orgUserLogin);
    }

	@Override
	public OrgUserLogin queryByRememberKey(String rememberKey) {
		OrgUserLoginQuery query = new OrgUserLoginQuery();
		query.setRememberKey(rememberKey);
		return queryOne(query);
	}
}