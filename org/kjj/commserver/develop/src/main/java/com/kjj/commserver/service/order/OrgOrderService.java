package com.kjj.commserver.service.order;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgSolveOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderForm;
import com.kjj.commserver.entity.order.aide.OrgOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderResult;
import com.kjj.commserver.entity.order.aide.OrgOrderSend;
import com.kjj.commserver.entity.order.aide.OrgOrderUserCount;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgOrderService extends BaseService<OrgOrder, Integer> {
	
	/**
	 * 查询并锁定订单
	 * @param orderId
	 * @return
	 */
	OrgOrder lockQueryById(Integer orderId);
	
	/***
	 * 
	 * @param orgUsersSession session中user
	 * @param orgOrderForm 订单详情
	 * @return
	 */
	OrgOrderResult add(OrgUsersSession orgUsersSession,OrgOrderForm orgOrderForm);
	
	/**
	 * 网上支付成功处理
	 * @param orderId 订单号
	 * @param onlinePayStyle 支付方式
	 */
	void updatePayOnline(Integer orderId,Byte onlinePayStyle);

	/**
	 * 获取配送时间选项
	 * @param orgUsersSession
	 * @param startDate
	 * @return
	 */
	OrgOrderSend getSendOption(OrgUsersSession orgUsersSession, Date startDate);
	
	/**
	 * 获取订餐订单配送时间选项
	 * @param orgUsersSession
	 * @param startDate
	 * @return
	 */
	OrgOrderSend getSendOption4Meal(OrgUsersSession orgUsersSession, Date startDate);
	
	/**
	 * 用户取消订单
	 * @param orgUsersSession
	 * @param orderId
	 * @param logDetail
	 */
	boolean updateCancal4User(OrgUsersSession orgUsersSession,Integer orderId,String logDetail);
	
	/**
	 * 用户查询订单分页
	 * @param orgUsersSession
	 * @param pageable
	 * @return
	 */
	Page<OrgOrder> queryPageList4User(OrgUsersSession orgUsersSession,OrgOrderQuery query,Pageable pageable);
	
	/**
	 * 管理员查询订单分页
	 * @param orgUsersSession
	 * @param pageable
	 * @return
	 */
	Page<OrgOrder> queryPageList4Admin(OrgAdminUserSession orgAdminUserSession,OrgOrderQuery query,Pageable pageable);
	
	/**
	 * 查询订单包含其中商品
	 * @param query
	 * @return
	 */
	List<OrgOrder> queryList4Report(OrgOrderQuery query);
	
	/**
	 * 查询用户订单分类总计
	 * @param userId
	 * @return
	 */
	OrgOrderUserCount queryUserCount(Integer userId);
	/**
	 * 根据订单id修改为确认订单状态
	 * @param orderId
	 * @return
	 */
	boolean updateConfirm(Integer orderId, String logDetail, OrgAdminUserSession admin);
	/**
	 * 根据订单id修改为发货订单状态
	 * @param orderId
	 * @return
	 */
	boolean updateSendOrTake(Integer orderId, String logDetail,
			OrgAdminUserSession admin);
	/**
	 * 根据订单id修改为完成订单状态
	 * @param orderId
	 * @param logDetail
	 * @param takeCode
	 *  @param admin
	 * @return
	 */
	boolean updateFinish(Integer orderId, String logDetail, String takeCode,
			OrgAdminUserSession admin);
	/**
	 * 根据订单id修改为取消订单状态
	 * @param orderId
	 * @param logDetail
	 * @param admin
	 * @return
	 */
	boolean updateCancel4Admin(Integer orderId, String logDetail,
			OrgAdminUserSession admin);
	/**
	 * 根据订单id修备注记录到订单日志
	 * @param orderId
	 * @param logDetail
	 * @param admin
	 * @return
	 */
	void updateRemark(Integer orderId, String logDetail,
			OrgAdminUserSession admin);
	/**
	 * 修改收货信息
	 * @param order
	 * @param admin
	 * @return
	 */
	void updateConsignee(OrgOrder order, OrgAdminUserSession admin);
	/**
	 * 转客服
	 * @param orgSolveOrder
	 * @param admin
	 */
	void updateSolve2Server(OrgSolveOrder orgSolveOrder, OrgAdminUserSession admin);
	/**
	 * 
	 * @param orgSolveOrder
	 * @param admin
	 * @return
	 */
	boolean updateSolveCancel(OrgSolveOrder orgSolveOrder, OrgAdminUserSession admin);
	/**
	 * 转门店
	 * @param orgSolveOrder
	 * @param admin
	 */
	void updateSolve2Shop(OrgSolveOrder orgSolveOrder, OrgAdminUserSession admin);

	/**
	 * 修改订单退货状态
	 * @param orderId
	 */
	void updateReturnStatus(Integer orderId);
	
	/**
	 * 超时订单作废
	 * @param order
	 */
	void updateCancelTimeOut(OrgOrder order);
}