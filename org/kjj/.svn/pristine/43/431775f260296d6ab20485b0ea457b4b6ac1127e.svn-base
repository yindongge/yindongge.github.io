package com.kjj.commserver.service.order;

import java.util.List;

import com.kjj.commserver.entity.order.OrgReturnOrderLog;
import com.kjj.core.service.BaseService;

public interface OrgReturnOrderLogService extends BaseService<OrgReturnOrderLog, Integer> {

	/**
	 * 添加用户 退货日志
	 * @param returnOrderId 退货单号
	 * @param userId 用户Id
	 * @param logType 日志类型
	 * @param logDetail 日志明细
	 */
	void addBuyUser(Integer returnOrderId, Integer userId, Byte logType, String logDetail);

	/**
	 * 查询退货单日志
	 * @param returnOrderId
	 * @return
	 */
	List<OrgReturnOrderLog> queryByReturnOrderId(Integer returnOrderId);
	/**
	 * 添加管理员 退货日志
	 * @param returnOrderId 退货单号
	 * @param userId 用户Id
	 * @param logType 日志类型
	 * @param logDetail 日志明细
	 */
	void addByAdmin(Integer returnOrderId, Short adminId, Byte logType,String logDetail);
}