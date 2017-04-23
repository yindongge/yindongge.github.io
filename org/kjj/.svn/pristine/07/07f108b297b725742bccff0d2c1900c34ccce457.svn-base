package com.kjj.commserver.service.order.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.order.OrgRefundOrderDao;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsConstant;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.OrgRefundOrder;
import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.exception.account.OrgAccountDepositException;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgRefundOrderService;
import com.kjj.commserver.service.order.OrgReturnOrderService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.IdUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgRefundOrderServiceImpl extends BaseServiceImpl<OrgRefundOrder, Integer> implements OrgRefundOrderService {
    @Resource
    private OrgRefundOrderDao orgRefundOrderDao;
    @Resource
    private OrgOrderGoodsService orgOrderGoodsService;
    @Resource
    private OrgOrderService orgOrderService;
    @Resource
    private OrgReturnOrderService orgReturnOrderService;
    @Resource
    private OrgAccountDepositService orgAccountDepositService;
    @Resource
    private OrgUsersService orgUsersService;
    
    @Override
    protected BaseDao<OrgRefundOrder, Integer> getBaseDao() {
        return orgRefundOrderDao;
    }
    
    @Override
    public OrgRefundOrder lockQueryById(Integer returnOrderId){
    	return orgRefundOrderDao.selectById4Update(returnOrderId);
    }
    
    @Override
	public void add(OrgRefundOrder orgRefundOrder) {
    	orgRefundOrder.setRefundSerialNo(new IdUtil(1,1).nextId());
    	orgRefundOrder.setRefundStatus(OrgRefundOrderConstant.REFUND_STATUS_WIRT);
    	orgRefundOrder.setCreateTime(new Date());
    	super.add(orgRefundOrder);
    }

	@Override
	public void addByOrder(OrgOrder order) {
		if(order.getOrderMoney().compareTo(BigDecimal.ZERO) == 0 
				|| (order.getPayStatus() == OrgOrderConstant.PAY_STATUS_UNPAID && order.getDepositMoney().compareTo(BigDecimal.ZERO) == 0)){
			//无需退款
			order.setStatus(OrgOrderConstant.STATUS_CLOSE);
			orgOrderService.updateByIdSelective(order);
		}else{
			//需要退款
			order.setStatus(OrgOrderConstant.STATUS_CANCEL);
			orgOrderService.updateByIdSelective(order);
			
			//支付退费单
			if(order.getPayMoney().compareTo(BigDecimal.ZERO) > 0 && order.getPayStatus() == OrgOrderConstant.PAY_STATUS_PAID){
				OrgRefundOrder orgRefundOrder = new OrgRefundOrder();
				orgRefundOrder.setOrderId(order.getOrderId());
				orgRefundOrder.setOrderSerialNo(order.getSerialNo());
				orgRefundOrder.setUserId(order.getUserId());
				orgRefundOrder.setShopId(order.getShopId());
				orgRefundOrder.setRefundStyle(order.getPayStyle());
				orgRefundOrder.setOnlineRefundStyle(order.getOnlinePayStyle());
				orgRefundOrder.setRefundMoney(order.getPayMoney());
				add(orgRefundOrder);
			}
			//预付费退款单
			if(order.getDepositMoney().compareTo(BigDecimal.ZERO) > 0){
				OrgRefundOrder orgRefundOrder = new OrgRefundOrder();
				orgRefundOrder.setOrderId(order.getOrderId());
				orgRefundOrder.setOrderSerialNo(order.getSerialNo());
				orgRefundOrder.setUserId(order.getUserId());
				orgRefundOrder.setShopId(order.getShopId());
				orgRefundOrder.setRefundStyle(OrgRefundOrderConstant.REFUND_STYLE_DEPOSIT);
				orgRefundOrder.setRefundMoney(order.getDepositMoney());
				add(orgRefundOrder);
				// 预付费直接退款
				OrgUsers orgUsers = orgUsersService.queryById(order.getUserId());
				Map<String, Object> mapResultAccountDeposit = orgAccountDepositService.updateAddRefund(OrgAccountDepositRecordsConstant.ORIGIN_ONLINE_SHOP,orgUsers.getUserCode(), orgRefundOrder.getRefundMoney(), order.getOrderId().toString(),null);
				if((Integer)mapResultAccountDeposit.get("status") != OrgAccountDepositConstant.REFUND_STATUS_SUCCESS){
					//失败
					throw new OrgAccountDepositException("accountDeposit add refund fail userId = " + order.getUserId() + "amount=" + orgRefundOrder.getRefundMoney() + "status=" + mapResultAccountDeposit.get("status"));
				}
				//直接退款成功
				updateFinish(orgRefundOrder);
			}
		}
	}
	
	@Override
	public Page<OrgRefundOrder> queryPageList4User(OrgUsersSession orgUsersSession,OrgRefundOrderQuery query,Pageable pageable){
		query.setUserId(orgUsersSession.getOrgUsers().getUserId());
		Page<OrgRefundOrder> pageOrder = queryPageList(query, pageable);
		addOrderGoods(pageOrder.getContent());
		return pageOrder;
	}

	/**
	 * 添加退款单对应商品详情
	 * @param listRefundOrder
	 */
	private void addOrderGoods(List<OrgRefundOrder> listRefundOrder) {
		if(CollectionUtils.isNotEmpty(listRefundOrder)){
			Map<Integer,List<OrgRefundOrderVo>> mapRefundOrder = new HashMap<Integer,List<OrgRefundOrderVo>>();
			OrgRefundOrderVo orgRefundOrderVo = null;
			List<OrgRefundOrderVo> listRefundOrder4Order = null;
			for(OrgRefundOrder refundOrder : listRefundOrder){
				orgRefundOrderVo = (OrgRefundOrderVo)refundOrder;
				if(orgRefundOrderVo.getReturnOrderId() == null || orgRefundOrderVo.getReturnOrderId() == 0){
					//取消订单的退款单(可能一个订单有多个退款单)
					if(mapRefundOrder.containsKey(orgRefundOrderVo.getOrderId())){
						mapRefundOrder.get(orgRefundOrderVo.getOrderId()).add(orgRefundOrderVo);
					}else{
						listRefundOrder4Order = new ArrayList<OrgRefundOrderVo>();
						listRefundOrder4Order.add(orgRefundOrderVo);
						mapRefundOrder.put(orgRefundOrderVo.getOrderId(), listRefundOrder4Order);
					}
					if(orgRefundOrderVo.getRefundStyle() == OrgRefundOrderConstant.REFUND_STYLE_DEPOSIT){
						//预存款退货单
						orgRefundOrderVo.setGoodsPayMoney(orgRefundOrderVo.getOrgOrder().getDepositMoney());
					}else{
						orgRefundOrderVo.setGoodsPayMoney(orgRefundOrderVo.getOrgOrder().getPayMoney());
					}
				}else{
					//退货的退款单
					OrgOrderGoods orgOrderGoods = orgOrderGoodsService.queryVoById(orgRefundOrderVo.getOrgReturnOrder().getOrderGoodsId());
					orgRefundOrderVo.getListOrderGoods().add(orgOrderGoods);
					orgRefundOrderVo.setGoodsPayMoney(orgOrderGoods.getUnitPrice().multiply(BigDecimal.valueOf(orgRefundOrderVo.getOrgReturnOrder().getAmount())));
				}
			}
			
			List<OrgOrderGoods> listOrderGoods = orgOrderGoodsService.queryByOrderIds(mapRefundOrder.keySet());
			for(OrgOrderGoods orderGoods : listOrderGoods){
				listRefundOrder4Order = mapRefundOrder.get(orderGoods.getOrderId());
				for(OrgRefundOrderVo refundOrderVo : listRefundOrder4Order){
					refundOrderVo.getListOrderGoods().add(orderGoods);
				}
			}
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public OrgRefundOrder queryVoById(Integer refundId){
		OrgRefundOrderVo orgRefundOrderVo = (OrgRefundOrderVo) super.queryVoById(refundId);
		if(orgRefundOrderVo.getReturnOrderId() == null || orgRefundOrderVo.getReturnOrderId() == 0){
			//取消订单的退款单
			orgRefundOrderVo.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orgRefundOrderVo.getOrderId()));
			if(orgRefundOrderVo.getRefundStyle() == OrgRefundOrderConstant.REFUND_STYLE_DEPOSIT){
				//预存款退货单
				orgRefundOrderVo.setGoodsPayMoney(orgRefundOrderVo.getOrgOrder().getDepositMoney());
			}else{
				orgRefundOrderVo.setGoodsPayMoney(orgRefundOrderVo.getOrgOrder().getPayMoney());
			}
		}else{
			//退货的退款单
			OrgOrderGoods orgOrderGoods = orgOrderGoodsService.queryVoById(orgRefundOrderVo.getOrgReturnOrder().getOrderGoodsId());
			orgRefundOrderVo.getListOrderGoods().add(orgOrderGoods);
			orgRefundOrderVo.setGoodsPayMoney(orgOrderGoods.getUnitPrice().multiply(BigDecimal.valueOf(orgRefundOrderVo.getOrgReturnOrder().getAmount())));
		}
		return orgRefundOrderVo;
	}

	@Override
	public void addByReturnOrder(OrgReturnOrder returnOrder) {
		OrgOrder orgOrder = orgOrderService.lockQueryById(returnOrder.getOrderId());
		BigDecimal lastDepositMoney = orgOrder.getDepositMoney().subtract(orgOrder.getDepositRefund());
		//如果预付费还没有退完
		if(lastDepositMoney.compareTo(BigDecimal.ZERO) > 0){
			OrgRefundOrder orgRefundOrder = new OrgRefundOrder();
			orgRefundOrder.setOrderId(returnOrder.getOrderId());
			orgRefundOrder.setOrderSerialNo(returnOrder.getOrderSerialNo());
			orgRefundOrder.setReturnOrderId(returnOrder.getReturnOrderId());
			orgRefundOrder.setReturnSerialNo(returnOrder.getReturnSerialNo());
			orgRefundOrder.setUserId(returnOrder.getUserId());
			orgRefundOrder.setShopId(returnOrder.getShopId());
			orgRefundOrder.setRefundStyle(OrgRefundOrderConstant.REFUND_STYLE_DEPOSIT);
			orgRefundOrder.setRefundStatus(OrgRefundOrderConstant.REFUND_STATUS_WIRT);
			if(returnOrder.getReturnMoney().compareTo(lastDepositMoney) <= 0){
				//剩余预付费够退款
				orgRefundOrder.setRefundMoney(returnOrder.getReturnMoney());
				orgOrder.setDepositRefund(orgOrder.getDepositRefund().add(returnOrder.getReturnMoney()));
				//调整退费金额
				returnOrder.setReturnMoney(BigDecimal.ZERO);
			}else{
				//剩余预付费不够退款
				orgRefundOrder.setRefundMoney(lastDepositMoney);
				orgOrder.setDepositRefund(orgOrder.getDepositRefund().add(lastDepositMoney));
				//调整退费金额
				returnOrder.setReturnMoney(returnOrder.getReturnMoney().subtract(lastDepositMoney));
			}
			add(orgRefundOrder);
			// 预付费直接退款
			OrgUsers orgUsers = orgUsersService.queryById(orgOrder.getUserId());
			Map<String, Object> mapResultAccountDeposit = orgAccountDepositService.updateAddRefund(OrgAccountDepositRecordsConstant.ORIGIN_ONLINE_SHOP,orgUsers.getUserCode(), orgRefundOrder.getRefundMoney(), orgOrder.getOrderId().toString(),orgRefundOrder.getRefundOrderId().toString());
			if((Integer)mapResultAccountDeposit.get("status") != OrgAccountDepositConstant.REFUND_STATUS_SUCCESS){
				//失败
				throw new OrgAccountDepositException("accountDeposit add refund fail userId = " + orgOrder.getUserId() + "amount=" + orgRefundOrder.getRefundMoney() + "status=" + mapResultAccountDeposit.get("status"));
			}
			//直接退款成功
			updateFinish(orgRefundOrder);
		}
		
		//还有退货金额没有退
		if(returnOrder.getReturnMoney().compareTo(BigDecimal.ZERO) > 0){
			OrgRefundOrder orgRefundOrder = new OrgRefundOrder();
			orgRefundOrder.setOrderId(returnOrder.getOrderId());
			orgRefundOrder.setOrderSerialNo(returnOrder.getOrderSerialNo());
			orgRefundOrder.setReturnOrderId(returnOrder.getReturnOrderId());
			orgRefundOrder.setReturnSerialNo(returnOrder.getReturnSerialNo());
			orgRefundOrder.setUserId(returnOrder.getUserId());
			orgRefundOrder.setShopId(returnOrder.getShopId());
			orgRefundOrder.setRefundStyle(orgOrder.getPayStyle());
			orgRefundOrder.setOnlineRefundStyle(orgOrder.getOnlinePayStyle());
			orgRefundOrder.setRefundStatus(OrgRefundOrderConstant.REFUND_STATUS_WIRT);
			orgRefundOrder.setRefundMoney(returnOrder.getReturnMoney());
			add(orgRefundOrder);
		}
		
	}

	@Override
	public Page<OrgRefundOrder> queryPageList4Admin(OrgAdminUserSession admin,
			OrgRefundOrderQuery query, Pageable pageable) {
		query.setShopIds(admin.getShopIds());
		Page<OrgRefundOrder> pageOrder = queryPageList(query, pageable);
		addOrderGoods(pageOrder.getContent());
		return pageOrder;
	}

	@Override
	public boolean updateFinish(OrgRefundOrder orgRefundOrder) {
		OrgRefundOrder oldRefundOrder = lockQueryById(orgRefundOrder.getRefundOrderId());
		//判断能否完成
		if(oldRefundOrder.getRefundStatus() == OrgRefundOrderConstant.REFUND_STATUS_WIRT){
			oldRefundOrder.setRemark(orgRefundOrder.getRemark());
			oldRefundOrder.setRefundAdminId(orgRefundOrder.getRefundAdminId());
			//状态改为已退款
			oldRefundOrder.setRefundStatus(OrgRefundOrderConstant.REFUND_STATUS_FINISH);
			oldRefundOrder.setRefundTime(new Date());
			updateByIdSelective(oldRefundOrder);
			
			if(oldRefundOrder.getReturnOrderId() == null || oldRefundOrder.getReturnOrderId() == 0){
				//查询是否整个订单都退款完毕
				OrgRefundOrderQuery query = new OrgRefundOrderQuery();
				query.setOrderId(oldRefundOrder.getOrderId());
				query.setRefundStatus(OrgRefundOrderConstant.REFUND_STATUS_WIRT);
				long countLastRefundOrder = queryCount(query);
				if(countLastRefundOrder == 0){
					OrgOrder order = new OrgOrder();
					order.setOrderId(oldRefundOrder.getOrderId());
					//订单状态改为已关闭
					order.setStatus(OrgOrderConstant.STATUS_CLOSE);
					orgOrderService.updateByIdSelective(order);
				}
			}else{
				//退货的退费
				//查询此退货单是否都退款完毕
				OrgRefundOrderQuery query = new OrgRefundOrderQuery();
				query.setReturnOrderId(oldRefundOrder.getReturnOrderId());
				query.setRefundStatus(OrgRefundOrderConstant.REFUND_STATUS_WIRT);
				long countLastRefundOrder = queryCount(query);
				if(countLastRefundOrder == 0){
					OrgReturnOrder returnOrder = orgReturnOrderService.queryById(oldRefundOrder.getReturnOrderId());
					//订单对应的产品修改退款数量
					OrgOrderGoods orderGoods = orgOrderGoodsService.lockQueryById(returnOrder.getOrderGoodsId());
					orderGoods.setId(returnOrder.getOrderGoodsId());
					orderGoods.setRefundAmount(orderGoods.getRefundAmount() + returnOrder.getAmount());
					orgOrderGoodsService.updateByIdSelective(orderGoods);
					//查询是否整个订单都退款完毕
					OrgOrderGoodsQuery orderGoodQuery = new OrgOrderGoodsQuery();
					orderGoodQuery.setOrderId(oldRefundOrder.getOrderId());
					orderGoodQuery.setCountLastRefundGoods(true);
					long countLastRefundGoods = orgOrderGoodsService.queryOtherCount(orderGoodQuery);
					if(countLastRefundGoods == 0){
						//取消订单的退费
						OrgOrder order = new OrgOrder();
						order.setOrderId(oldRefundOrder.getOrderId());
						//订单状态改为已关闭
						order.setStatus(OrgOrderConstant.STATUS_CLOSE);
						orgOrderService.updateByIdSelective(order);
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}
}