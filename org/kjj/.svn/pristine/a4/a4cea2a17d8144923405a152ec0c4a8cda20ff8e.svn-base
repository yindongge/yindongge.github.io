package com.kjj.commserver.service.order;

import java.util.List;

import com.kjj.commserver.entity.order.OrgOrderLog;
import com.kjj.core.service.BaseService;

public interface OrgOrderLogService extends BaseService<OrgOrderLog, Integer> {

	/**
	 * 添加用户操作订单日志
	 * @param orderId 订单号
	 * @param userId 用户Id
	 * @param logType 日志类型
	 * @param logDetail 日志明细
	 */
	void addByUser(Integer orderId, Integer userId,Byte logType, String logDetail);

	/**
	 * 管理员查询订单的日志
	 * @param orderId
	 * @return
	 */
	List<OrgOrderLog> query4AdminByOrderId(Integer orderId);
	
	/**
	 * 用户查询订单的日志
	 * @param orderId
	 * @return
	 */
	List<OrgOrderLog> query4UserByOrderId(Integer orderId);
	
	/**
	 * 添加管理员操作订单日志
	 * @param orderId 订单号
	 * @param short 用户Id
	 * @param logType 日志类型
	 * @param logDetail 日志明细
	 */
	void addByAdmin(Integer orderId, Short userId,Byte logType,String logDetail);
	
	/**
	 * 添加系统操作订单日志
	 * @param orderId 订单号
	 * @param logType 日志类型
	 * @param logDetail 日志明细
	 */
	void addBySystem(Integer orderId, Byte logType,String logDetail);
}