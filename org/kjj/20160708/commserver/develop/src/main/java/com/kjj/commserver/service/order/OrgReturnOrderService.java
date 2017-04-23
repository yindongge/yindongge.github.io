package com.kjj.commserver.service.order;

import java.util.Collection;

import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.core.service.BaseService;

public interface OrgReturnOrderService extends BaseService<OrgReturnOrder, Integer> {

	/**
	 * 根据ID查询退货单并锁定
	 * @param returnOrderId
	 * @return
	 */
	OrgReturnOrder lockQueryById(Integer returnOrderId);
	
	/**
	 * 添加退货单
	 * @param returnOrder 退货信息
	 * @param imgUrls 退货图片Url列表
	 */
	void addByUser(OrgReturnOrder returnOrder, Collection<String> imgUrls);
	/**
	 * 添加退货信息
	 * @param returnOrder 退货信息
	 * @param admin
	 */
	void addByAdmin(OrgReturnOrder returnOrder, OrgAdminUserSession admin);
	/**
	 * 修改退货备注同意信息
	 * @param returnOrderId 退货id
	 * @param admin
	 * @param logDetail
	 */
	boolean updateApprove(Integer returnOrderId, String logDetail,
			OrgAdminUserSession admin);
	/**
	 * 修改退货拒绝信息
	 * @param returnOrderId 退货id
	 * @param admin
	 * @param logDetail
	 *  @param reply
	 */
	boolean updateRefuse(Integer returnOrderId, String logDetail,
			OrgAdminUserSession admin, String reply);
	/**
	 * 修改退货失败信息
	 * @param returnOrderId 退货id
	 * @param admin
	 * @param logDetail
	 *  @param reply
	 */
	boolean updateFail(Integer returnOrderId, String logDetail,
			OrgAdminUserSession admin, String reply);
	/**
	 * 修改退货完成信息
	 * @param returnOrderId 退货id
	 * @param admin
	 * @param logDetail
	 */
	boolean updateFinish(OrgReturnOrder orgReturnOrder, String logDetail,
			OrgAdminUserSession admin);
	/**
	 * 修改退货备注确认信息
     * @param returnOrderId 退货id
	 * @param admin
	 * @param logDetail
	 */
	void updateRemark(Integer returnOrderId, String logDetail,
			OrgAdminUserSession admin);
}