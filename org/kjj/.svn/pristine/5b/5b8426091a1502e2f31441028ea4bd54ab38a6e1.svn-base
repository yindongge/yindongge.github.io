package com.kjj.commserver.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgEnterpriseDao;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgEnterprise;
import com.kjj.commserver.entity.user.OrgEnterpriseCheck;
import com.kjj.commserver.entity.user.OrgEnterpriseInvitation;
import com.kjj.commserver.entity.user.OrgEnterpriseUser;
import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseCheckForm;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseConstant;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseForm;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersVo;
import com.kjj.commserver.service.user.OrgEnterpriseCheckService;
import com.kjj.commserver.service.user.OrgEnterpriseInvitationService;
import com.kjj.commserver.service.user.OrgEnterpriseService;
import com.kjj.commserver.service.user.OrgEnterpriseUserService;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.SmsUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgEnterpriseServiceImpl extends BaseServiceImpl<OrgEnterprise, Integer> implements OrgEnterpriseService {
    @Resource
    private OrgEnterpriseDao orgEnterpriseDao;
    
    @Resource
	private OrgUsersService orgUsersService;
    
    @Resource
    private OrgEnterpriseCheckService  orgEnterpriseCheckService;
    
    @Resource
    private OrgEnterpriseInvitationService  orgEnterpriseInvitationService;
    
    @Resource
    private OrgEnterpriseUserService orgEnterpriseUserService;
    
    @Resource
    private OrgUserLevelService orgUserLevelService;

    @Override
    protected BaseDao<OrgEnterprise, Integer> getBaseDao() {
        return orgEnterpriseDao;
    }

	@Override
	public void add(OrgEnterpriseForm enterprise, OrgUsers orgUsers) {
		orgUsersService.add(orgUsers); // 先保存用户信息
		
		enterprise.setCreateTime(new Date()); // 注册日期
		enterprise.setIsLocked(OrgEnterpriseConstant.LOCK_STATUS_NO_LOCKED); // 未锁定
		enterprise.setStatus(OrgEnterpriseConstant.STATUS_BEGIN); // 审批状态为未审批
		enterprise.setUserId(orgUsers.getUserId()); // 用户Id
		
		orgEnterpriseDao.insert(enterprise);
	}

	@Override
	public OrgEnterprise queryByUserId(Integer userId) {
		OrgEnterpriseQuery query = new OrgEnterpriseQuery();
		query.setUserId(userId);
		return queryOne(query);
	}

	@Override
	public void deleteEnterprise(OrgEnterprise enterprise) {

		// 去掉用户与企业的关联关系
		// 将关联企业的用户都改成个人用户级别，更新用户会员级别
		OrgUsersQuery query = new OrgUsersQuery();
		query.setUserEnterpriseId(enterprise.getEnterpriseId());
		List<OrgUsersVo> userList = orgUsersService.queryEnterpriseUsers(enterprise.getEnterpriseId());
		
		OrgUserLevel userQuery = new OrgUserLevel();
		userQuery.setLevelType(Byte.parseByte("1")); // 1代表个人用户类型
		List<OrgUserLevel> levelList = orgUserLevelService.queryList(userQuery);
		
		List<OrgUsers> updateList = new ArrayList<OrgUsers>();
		for(OrgUsersVo ouv: userList) {
			for(OrgUserLevel level: levelList){
				// 总消费金额在上限和下线之间
				if(ouv.getTotal().compareTo(level.getConsumeTop()) <= 0 && ouv.getTotal().compareTo(level.getConsumeDown()) >= 0){
					ouv.setLevelType(Byte.parseByte("1")); // 1代表个人用户
					ouv.setLevelId(level.getLevelId());
					updateList.add(ouv);
					break;
				}
			}
		}
		orgUsersService.updateInBatch(updateList); // 批量更新用户会员级别
		
		// 删除审批表
		OrgEnterpriseCheck checkQuery = new OrgEnterpriseCheck();
		checkQuery.setEnterpriseId(enterprise.getEnterpriseId());
		orgEnterpriseCheckService.delete(checkQuery);
		
		// 删除企业用户表
		OrgEnterpriseUser euQuery = new OrgEnterpriseUser();
		euQuery.setEnterpriseId(enterprise.getEnterpriseId());
		orgEnterpriseUserService.delete(euQuery);

		// 删除邀请码表
		OrgEnterpriseInvitation invitationQuery = new OrgEnterpriseInvitation();
		invitationQuery.setEnterpriseId(enterprise.getEnterpriseId());
		orgEnterpriseInvitationService.delete(invitationQuery);
		
		// 删除用户表对应信息
		orgUsersService.deleteById(enterprise.getUserId());// 删除用户表对应的记录
		
		// 删除企业用户
		orgEnterpriseDao.deleteById(enterprise.getEnterpriseId());
		
	}

	@Override
	public void lock(Integer enterpriseId) {
		OrgEnterprise oe = new OrgEnterprise();
		oe.setEnterpriseId(enterpriseId);
		oe.setIsLocked(OrgEnterpriseConstant.LOCK_STATUS_LOCKED); // 锁定状态
		
		updateByIdSelective(oe);
		
		oe = queryById(enterpriseId);
		
		OrgUsers user = new OrgUsers();
		user.setUserId(oe.getUserId());
		user.setStatus(OrgUsersConstant.STATUS_INVALID);// 锁定用户
		orgUsersService.updateByIdSelective(user);
		
	}

	@Override
	public void updateDisLock(Integer enterpriseId) {
		OrgEnterprise oe = new OrgEnterprise();
		oe.setEnterpriseId(enterpriseId);
		oe.setIsLocked(OrgEnterpriseConstant.LOCK_STATUS_NO_LOCKED); // 解除锁定状态
		super.updateByIdSelective(oe);
		
		oe = super.queryById(enterpriseId);
		
		OrgUsers user = new OrgUsers();
		user.setUserId(oe.getUserId());
		user.setStatus(OrgUsersConstant.STATUS_VALID);// 正常用户
		orgUsersService.updateByIdSelective(user);
		
	}

	@Override
	public void updateCheck(OrgAdminUserSession admin,
			OrgEnterpriseCheckForm enterpriseCheck) {
		OrgEnterprise enterprise = new OrgEnterprise();
		enterprise.setEnterpriseId(enterpriseCheck.getEnterpriseId());
		enterprise.setStatus(enterpriseCheck.getCheckStatus());

		updateByIdSelective(enterprise); // 更新企业用户状态
		
		// 如果审批通过，生成50个企业邀请码
		if(enterpriseCheck.getCheckStatus().equals(OrgEnterpriseConstant.STATUS_TURE)){
			orgEnterpriseInvitationService.addInvitationOfEnterprise(enterpriseCheck.getEnterpriseId());
		}

		enterpriseCheck.setCheckTime(new Date()); // 审批日期

		
		enterpriseCheck.setUserId(Integer.valueOf(admin.getOrgAdminUser()
				.getUserId().toString())); // 审批人

		orgEnterpriseCheckService.add(enterpriseCheck);
		
		enterprise = queryById(enterprise.getEnterpriseId());
		// 发送短信 enterprise
		SmsUtil.sendEnterpriseCheck(enterprise.getMobile(), enterpriseCheck.getMessage());
		
	}
}