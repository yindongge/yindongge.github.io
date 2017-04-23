package com.kjj.commserver.service.discount;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.aide.OrgReachForm;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgReachService extends BaseService<OrgReach, Integer> {
	
	/**
	 * 查询满减
	 * @param orgUsersSession
	 * @param listCartAll
	 * @return
	 */
	Map<Integer, OrgReach> updateMap4View(OrgUsersSession orgUsersSession, List<OrgCartAll> listCartAll);
	/**
	 * 下单满减
	 * @param orgUsersSession
	 * @param listCartAll
	 * @return
	 */
	Map<Integer, OrgReach> updateMap4Buy(OrgUsersSession orgUsersSession, List<OrgCartAll> listCartAll);
	/**
	 * 添加满减满送相关信息
	 * @param orgReachForm 表单信息
	 * @param admin
	 */
	void addInfo(OrgReachForm orgReachForm,OrgAdminUserSession admin);
	
	/**
	 * 更新满减满送相关信息
	 * @param orgReachForm
	 * @param admin
	 */
	void updateInfo(OrgReachForm orgReachForm,OrgAdminUserSession admin);
	
	/**
	 * 更新满减满送关联的分类产品信息
	 * @param typeId
	 * @param discountId
	 * @param productType
	 * @param listClass
	 * @param listGoods
	 */
	void updateItem(Byte typeId, Integer discountId, Byte productType,Collection<Integer> listClass, Collection<Integer> listGoods);
	
	/**
	 * 获得数据库时间
	 * @return
	 */
	Date getDbTime();
	
	/**
	 * 查询用户可用满减优惠
	 * @param orgUsersSession
	 * @return
	 */
	List<OrgReach> queryList4User(OrgUsersSession orgUsersSession);
	
	/**
	 * 查询商品可用满减优惠
	 * @param orgUsersSession
	 * @param goodsId
	 * @return
	 */
	List<OrgReach> queryList4Item(OrgUsersSession orgUsersSession,Integer goodsId);
	
}