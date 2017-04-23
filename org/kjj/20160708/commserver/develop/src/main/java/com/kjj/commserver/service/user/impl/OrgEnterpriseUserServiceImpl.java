package com.kjj.commserver.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgEnterpriseUserDao;
import com.kjj.commserver.entity.user.OrgEnterpriseUser;
import com.kjj.commserver.entity.user.OrgUserConsume;
import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUserLevelConstant;
import com.kjj.commserver.service.user.OrgEnterpriseUserService;
import com.kjj.commserver.service.user.OrgUserConsumeService;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgEnterpriseUserServiceImpl extends BaseServiceImpl<OrgEnterpriseUser, Integer> implements OrgEnterpriseUserService {
    @Resource
    private OrgEnterpriseUserDao orgEnterpriseUserDao;
    @Resource
    private OrgUserLevelService orgUserLevelService;
    @Resource
    private OrgUserConsumeService orgUserConsumeService;
    @Resource
    private OrgUsersService orgUsersService;

    @Override
    protected BaseDao<OrgEnterpriseUser, Integer> getBaseDao() {
        return orgEnterpriseUserDao;
    }
    
    @Override
	public int deleteById(Integer id) {
    	
    	OrgEnterpriseUser oeu = orgEnterpriseUserDao.selectById(id);
    	// 获得所有个人会员的级别
    	OrgUserLevel query = new OrgUserLevel();
    	query.setLevelType(OrgUserLevelConstant.LEVEL_TYPE_USER);
    	List<OrgUserLevel> levelList = orgUserLevelService.queryList(query);
    	
    	// 获得用户的消费总额
    	OrgUserConsume oucQuery = new OrgUserConsume();
    	oucQuery.setUserId(oeu.getUserId());
    	OrgUserConsume ouc = orgUserConsumeService.queryOne(oucQuery);
    	
    	OrgUsers user = new OrgUsers();
    	// 循环赋ID
    	for(OrgUserLevel l : levelList) {
    		if(ouc.getTotal().compareTo(l.getConsumeDown()) != -1 && ouc.getTotal().compareTo(l.getConsumeTop()) != 1){
    			
    			user.setUserId(oeu.getUserId());
    			user.setLevelType(OrgUserLevelConstant.LEVEL_TYPE_USER);
    			user.setLevelId(l.getLevelId());
    		}
    	}
    	// 一定有默认的会员级别
    	if(null == user.getLevelId()){
    		user.setUserId(oeu.getUserId());
			user.setLevelType(OrgUserLevelConstant.LEVEL_TYPE_USER);
			user.setLevelId(OrgUserLevelConstant.LEVEL_USER_TYPE_NORMAL_USER);
    	}
    	
    	// 修改会员级别和类型
    	orgUsersService.updateByIdSelective(user);
    	
		return getBaseDao().deleteById(id);
	}
}