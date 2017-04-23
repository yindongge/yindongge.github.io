package com.kjj.commserver.service.user;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.entity.user.aide.OrgUsersVo;
import com.kjj.core.service.BaseService;

public interface OrgUsersService extends BaseService<OrgUsers, Integer> {

	/**
	 * 查询登录用户 (email或手机号或用户名查询)
	 * @param loginName
	 * @return
	 */
	OrgUsers queryByLoginName(String loginName);
	
	/**
	 * 用户成功登录
	 * @param usersSession 原Session用户 
	 * @param orgUsers 登录用户
	 * @param ipAddress 登录IP
	 */
	void updateLogin(OrgUsersSession oldUsersSession, OrgUsers orgUsers,String ipAddress);
	
	/**
	 *  查询用户
	 * @param openId 微信公众号OpenId
	 * @return
	 */
	OrgUsers queryByOpenId(String openId);
	
	/**
	 * 变更用户自提店铺
	 * @param orgUsersSession
	 * @param orgShop
	 */
	void updateUserShop4Take(OrgUsersSession orgUsersSession,OrgShop orgShop);
	
	/**
	 * 变更用户送货地址
	 * @param orgUsersSession
	 * @param orgUserAddress
	 */
	void updateUserAddress4Send(OrgUsersSession orgUsersSession,OrgUserAddress orgUserAddress);
	
	/**
	 * 手机用户登录
	 * @param userSession
	 */
	void updateMobileLogin(OrgUsersSession orgUsersSession,OrgUsers userLogin, String ipAddress);
	/**
	 * 根据userid修改锁定状态
	 * @param id
	 * @param i
	 * @return 
	 */
	int updateStatus(Integer userId, Integer status);
	
	/**
	 * 同步用户会员等级到瑞星数据库
	 */
	void syncUserLevelToRuiXing();
	
	/**
	 * 获取企业关联的用户
	 * @param enterpriseId
	 * @return
	 */
	List<OrgUsersVo> queryEnterpriseUsers(Integer enterpriseId);
	
	
	/**
	 * 获取用户折扣和消费积分
	 * @param userId
	 * @return
	 */
	List<OrgUsersVo> queryDiscountAndPoint(Integer userId);
	
	/**
	 * 获取用户定位历史列表
	 * @param localHistory Cookie手动定位历史
	 * @return
	 */
	List<OrgLocation> getListLocalHistory(String localHistory);
	
	/**
	 * 获取用户最后定位历史
	 * @param localHistory Cookie手动定位历史
	 * @return
	 */
	OrgLocation getLastLocalHistory(String localHistory);
	
	void mergeTX();
}