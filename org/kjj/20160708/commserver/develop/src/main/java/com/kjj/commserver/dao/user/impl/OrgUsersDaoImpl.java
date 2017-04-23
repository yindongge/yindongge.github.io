package com.kjj.commserver.dao.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kjj.commserver.dao.user.OrgUsersDao;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersVo;
import com.kjj.core.dao.BaseDaoImpl;

@Repository
public class OrgUsersDaoImpl extends BaseDaoImpl<OrgUsers, Integer> implements OrgUsersDao {

	private static final String SQL_ID_SELECT_ENTERPRISE_USER = "selectEnterpriseUser";
	
	private static final String SQL_ID_SELECT_DISCOUNT_AND_POINT = "selectDiscountAndPoint";
	
	@Override
	public List<OrgUsersVo> queryEnterpriseUsers(Integer enterpriseId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("enterpriseId", enterpriseId);
		return sqlSession.selectList(getSqlName(SQL_ID_SELECT_ENTERPRISE_USER), parameter);
	}

	@Override
	public List<OrgUsersVo> queryDiscountAndPoint(Integer userId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("userId", userId);
		return sqlSession.selectList(getSqlName(SQL_ID_SELECT_DISCOUNT_AND_POINT), parameter);
	}
}