package com.kjj.commserver.service.account.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.account.OrgAccountGroupDao;
import com.kjj.commserver.entity.account.OrgAccountGroup;
import com.kjj.commserver.entity.account.OrgAccountGroupUser;
import com.kjj.commserver.service.account.OrgAccountGroupService;
import com.kjj.commserver.service.account.OrgAccountGroupUserService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAccountGroupServiceImpl extends BaseServiceImpl<OrgAccountGroup, Integer> implements OrgAccountGroupService {
    @Resource
    private OrgAccountGroupDao orgAccountGroupDao;
    
    @Resource
    private OrgAccountGroupUserService orgAccountGroupUserService;

    @Override
    protected BaseDao<OrgAccountGroup, Integer> getBaseDao() {
        return orgAccountGroupDao;
    }
    
    /**
     * 重写deleteById方法，删除用户组对应的用户
     */
    public int deleteById(Integer id){
    	int result = super.deleteById(id);
    	
    	// 删除用户组对应的用户
    	OrgAccountGroupUser query = new OrgAccountGroupUser();
    	query.setGroupId(id);
    	orgAccountGroupUserService.delete(query);
    	
    	return result;
    }
}