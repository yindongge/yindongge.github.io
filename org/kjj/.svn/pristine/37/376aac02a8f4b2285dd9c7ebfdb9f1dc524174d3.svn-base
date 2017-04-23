package com.kjj.commserver.service.user;

import java.util.List;

import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgUserAddressService extends BaseService<OrgUserAddress, Integer> {

	/**
	 * 查询用户当前店铺有效地址
	 * @param orgUsersSession session中user
	 * @return
	 */
	List<OrgUserAddress> getThisShopVaildByUser(OrgUsersSession orgUsersSession);

	/**
	 * 查询用户当前店铺无效地址
	 * @param orgUsersSession session中user
	 * @return
	 */
	List<OrgUserAddress> getThisShopInvaildByUser(OrgUsersSession orgUsersSession);
	
	/**
	 * 查询用户所有店铺有效地址
	 * @param orgUsersSession session中user
	 * @return
	 */
	List<OrgUserAddress> getListVaildByUser(OrgUsersSession orgUsersSession);

	/**
	 * 查询用户所有店铺无效地址
	 * @param orgUsersSession session中user
	 * @return
	 */
	List<OrgUserAddress> getListInvaildByUser(OrgUsersSession orgUsersSession);

	/**
	 * 查询用户其他店铺地址
	 * @param orgUsersSession session中user
	 * @return
	 */
	List<OrgUserAddress> getOtherShopByUser(OrgUsersSession orgUsersSession);
	
	/**
	 * 查询用户所有地址
	 * @param orgUsersSession session中user
	 * @return
	 */
	List<OrgUserAddress> getByUser(OrgUsersSession orgUsersSession);
	
	/**
	 * 修改收货地址
	 * @param orgUserAddress
	 * @return
	 */
	void update(OrgUserAddress orgUserAddress);
	
	/**
	 * 查询用户最新收货地址
	 * @param userId
	 * @return
	 */
	OrgUserAddress queryLastAddressByUserId(Integer userId);
	
	/**
	 * 设置对应配送范围的地址全部失效
	 */
	void updateInvaildByShopSendRangeId(Integer shopSendRangeId);
}