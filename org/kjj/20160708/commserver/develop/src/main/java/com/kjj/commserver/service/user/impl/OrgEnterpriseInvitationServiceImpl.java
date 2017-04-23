package com.kjj.commserver.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgEnterpriseInvitationDao;
import com.kjj.commserver.entity.user.OrgEnterpriseInvitation;
import com.kjj.commserver.entity.user.OrgEnterpriseUser;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseInvitationConstant;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseInvitationQuery;
import com.kjj.commserver.entity.user.aide.OrgUserLevelConstant;
import com.kjj.commserver.service.user.OrgEnterpriseInvitationService;
import com.kjj.commserver.service.user.OrgEnterpriseUserService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgEnterpriseInvitationServiceImpl extends BaseServiceImpl<OrgEnterpriseInvitation, Integer> implements OrgEnterpriseInvitationService {
    @Resource
    private OrgEnterpriseInvitationDao orgEnterpriseInvitationDao;

    @Override
    protected BaseDao<OrgEnterpriseInvitation, Integer> getBaseDao() {
        return orgEnterpriseInvitationDao;
    }
    @Resource
    private OrgUsersService orgUsersService;
    
    @Resource
    private OrgEnterpriseUserService orgEnterpriseUserService;

	@Override
	public void addInvitationOfEnterprise(Integer enterpriseId) {
		List<OrgEnterpriseInvitation> list = new ArrayList<OrgEnterpriseInvitation>();
		
		// 生成50个邀请码
		for(int i = 0; i < 50; i++){
			OrgEnterpriseInvitation ei = new OrgEnterpriseInvitation();
			ei.setEnterpriseId(enterpriseId);
			ei.setStatus(OrgEnterpriseInvitationConstant.INVITATION_STATUS_NO_USE); // 状态为未使用
			
			String code = String.valueOf(nextInt(100000000,999999999));

			StringBuffer sb = new StringBuffer(code);
			for(int j = 0; j < 9; j++){
				int max=8;
				int min=0;
				Random random = new Random();
				int one = random.nextInt(max)%(max-min+1) + min;
				
				int two = random.nextInt(max)%(max-min+1) + min;
				
				char oneChar = sb.charAt(one);
				
				sb.setCharAt(one,sb.charAt(two));
				sb.setCharAt(two, oneChar);
			}
			
			ei.setInvitationCode(sb.toString());
			
			list.add(ei);
		}
		orgEnterpriseInvitationDao.insertInBatch(list);
	}
	
	private static int nextInt(final int min, final int max) {
		Random rand = new Random(); 
	    int tmp = Math.abs(rand.nextInt());
	    return tmp % (max - min + 1) + min;
	}

	@Override
	public boolean updateInvitation(String invitationCode, OrgUsers users) {
		
		OrgEnterpriseInvitation enterpriseInvitation = lockQueryByInvitationCode(invitationCode);
		if(enterpriseInvitation == null || enterpriseInvitation.getStatus() != OrgEnterpriseInvitationConstant.INVITATION_STATUS_NO_USE){
			return false;
		}
		// 更新邀请码信息
		enterpriseInvitation.setStatus(OrgEnterpriseInvitationConstant.INVITATION_STATUS_USEED);
		enterpriseInvitation.setUserId(users.getUserId());
		enterpriseInvitation.setUseTime(new Date());
		orgEnterpriseInvitationDao.updateByIdSelective(enterpriseInvitation);
		
		OrgEnterpriseUser eu = new OrgEnterpriseUser();
		eu.setEnterpriseId(enterpriseInvitation.getEnterpriseId());
		eu.setUserId(users.getUserId());
		orgEnterpriseUserService.add(eu);
		
		// 更改用户会员信息
		OrgUsers modifyUser = new OrgUsers();
		modifyUser.setUserId(users.getUserId());
		modifyUser.setRealname(users.getRealname());
		modifyUser.setLevelType(OrgUserLevelConstant.LEVEL_TYPE_ENTERPRISE_USER);
		modifyUser.setLevelId(OrgUserLevelConstant.LEVEL_USER_TYPE_NORMAL_ENTERPRISE);
		orgUsersService.updateByIdSelective(modifyUser);
		return true;
	}
	
	/**
	 * 查询邀请码并锁定
	 * @param invitationCode
	 * @return
	 */
	private OrgEnterpriseInvitation lockQueryByInvitationCode(String invitationCode) {
		OrgEnterpriseInvitationQuery query = new OrgEnterpriseInvitationQuery();
		query.setInvitationCode(invitationCode);
		query.setSelect4Update(true);
		return queryOne(query);
	}
	
	public static void  main(String[] args) throws InterruptedException{
//		Set<String> mySet = new HashSet<String>();
//		// 测试过，同时产生30000个字符串，没有问题,30000以上重复出现的概率会增加
//		for(int i = 0; i < 30000; i++) {
//			String code = String.valueOf(System.currentTimeMillis()  - i).substring(4, 13);
//			//String code = String.valueOf(System.currentTimeMillis()  - i);
//			System.out.println(code);
//			if(mySet.contains(code)){
//				int max=100;
//		        int min=60;
//		        Random random = new Random();
//		        
//				long num = random.nextInt(max)%(max-min+1) + min;
//				code = String.valueOf(System.currentTimeMillis()  + num + i).substring(4, 13);
//				System.out.println("重复的code:" + code);
//			}
//			mySet.add(code);
//		}
//		System.out.println("集合大小为:" + mySet.size());
		Set<String> mySet = new HashSet<String>();
		// 测试过，同时产生30000个字符串，没有问题,30000以上重复出现的概率会增加
		long starttime = System.currentTimeMillis();
		for(int i = 0; i < 50; i++) {
			
			String code = String.valueOf(nextInt(100000000,999999999));
			StringBuffer sb = new StringBuffer(code);
			for(int j = 0; j < 9; j++){
				int max=8;
				int min=0;
				Random random = new Random();
				int one = random.nextInt(max)%(max-min+1) + min;
				
				int two = random.nextInt(max)%(max-min+1) + min;
				
				char oneChar = sb.charAt(one);
				
				sb.setCharAt(one,sb.charAt(two));
				sb.setCharAt(two, oneChar);
			}
			
			System.out.println(sb);
			mySet.add(sb.toString());
		}
		long endtime = (System.currentTimeMillis() - starttime)/1000;
		System.out.println("总耗时:" + endtime + "秒");
		System.out.println("集合大小为:" + mySet.size());
//		System.out.println(System.currentTimeMillis() - 1459000000000L);
	}
}