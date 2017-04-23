package com.kjj.commserver.dao.user;

import java.util.List;

import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersVo;
import com.kjj.core.dao.BaseDao;

public interface OrgUsersDao extends BaseDao<OrgUsers, Integer> {
	/**
	 * 获取企业关联的用户
	 * @param enterpriseId
	 * @return
	 */
	List<OrgUsersVo> queryEnterpriseUsers(Integer enterpriseId);
	
	/**
	 * 获取用户的折扣和消费积分
	 * @param userId
	 * @return
	 */
	List<OrgUsersVo> queryDiscountAndPoint(Integer userId);
	
	int updateOpenId4User(String openId);
}