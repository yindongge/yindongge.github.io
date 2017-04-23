package com.kjj.commserver.service.order.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.order.OrgReturnOrderDao;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.OrgReturnOrder;
import com.kjj.commserver.entity.order.OrgReturnOrderImg;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderLogConstant;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgRefundOrderService;
import com.kjj.commserver.service.order.OrgReturnOrderImgService;
import com.kjj.commserver.service.order.OrgReturnOrderLogService;
import com.kjj.commserver.service.order.OrgReturnOrderService;
import com.kjj.commserver.service.swap.RxReturnOrderService;
import com.kjj.commserver.util.IdUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgReturnOrderServiceImpl extends BaseServiceImpl<OrgReturnOrder, Integer> implements OrgReturnOrderService {
    @Resource
    private OrgReturnOrderDao orgReturnOrderDao;
    @Resource
    private OrgReturnOrderImgService orgReturnOrderImgService;
    @Resource
    private OrgOrderGoodsService orgOrderGoodsService;
    @Resource
    private OrgOrderService orgOrderService;
    @Resource
    private OrgReturnOrderLogService orgReturnOrderLogService;
    @Resource
    private OrgRefundOrderService orgRefundOrderService;
    @Resource
    private RxReturnOrderService rxReturnOrderService;
    
    @Override
    protected BaseDao<OrgReturnOrder, Integer> getBaseDao() {
        return orgReturnOrderDao;
    }
    
    @Override
    public OrgReturnOrder lockQueryById(Integer returnOrderId){
    	return orgReturnOrderDao.selectById4Update(returnOrderId);
    }

	@Override
	public void addByUser(OrgReturnOrder orgReturnOrder, Collection<String> imgUrls) {
		add(orgReturnOrder);
		//图片保存
		if (CollectionUtils.isNotEmpty(imgUrls)) {
			List<OrgReturnOrderImg> listReturnOrderImg = new ArrayList<OrgReturnOrderImg>();
			OrgReturnOrderImg returnOrderImg = null;
			for(String imgUrl:imgUrls){
				returnOrderImg = new OrgReturnOrderImg();
				returnOrderImg.setReturnOrderId(orgReturnOrder.getReturnOrderId());
				returnOrderImg.setImgUrl(imgUrl);
				listReturnOrderImg.add(returnOrderImg);
			}
			orgReturnOrderImgService.addInBatch(listReturnOrderImg);
		}
		
		//添加日志
		orgReturnOrderLogService.addBuyUser(orgReturnOrder.getReturnOrderId(), orgReturnOrder.getUserId(), OrgReturnOrderLogConstant.TYPE_USER_APPLY, null);
		
	}

	@Override
	public void addByAdmin(OrgReturnOrder orgReturnOrder, OrgAdminUserSession admin) {
		add(orgReturnOrder);
		//添加日志
		orgReturnOrderLogService.addByAdmin(orgReturnOrder.getReturnOrderId(), admin.getOrgAdminUser().getUserId(), OrgReturnOrderLogConstant.TYPE_ADMIN_APPLY,null);
	}
	
	@Override
	public void add(OrgReturnOrder orgReturnOrder) {
		orgReturnOrder.setReturnSerialNo(new IdUtil(1,1).nextId());
		orgReturnOrder.setReturnStatus(OrgReturnOrderConstant.RETURN_STATUS_APPLY);
		orgReturnOrder.setCreateTime(new Date());
		super.add(orgReturnOrder);
		
		//订单对应的产品修改退换货数量
		OrgOrderGoods orderGoods = orgOrderGoodsService.lockQueryById(orgReturnOrder.getOrderGoodsId());
		orderGoods.setReturnAmount(orderGoods.getReturnAmount() + orgReturnOrder.getAmount());
		orgOrderGoodsService.updateByIdSelective(orderGoods);
		
		//修改订单的退货状态
		orgOrderService.updateReturnStatus(orgReturnOrder.getOrderId());
	}

	@Override
	public boolean updateApprove(Integer returnOrderId, String logDetail,OrgAdminUserSession admin) {
			
		OrgReturnOrder returnOrder = lockQueryById(returnOrderId);
		//判断能否同意
		if(returnOrder.getReturnStatus() == OrgReturnOrderConstant.RETURN_STATUS_APPLY){
			//订单状态改为退货中
			returnOrder.setReturnStatus(OrgReturnOrderConstant.RETURN_STATUS_WAIT_RETURN);
			updateByIdSelective(returnOrder);
			orgReturnOrderLogService.addByAdmin(returnOrder.getReturnOrderId(), admin.getOrgAdminUser().getUserId(), OrgReturnOrderLogConstant.TYPE_ADMIN_APPROVE,logDetail);
			
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateRefuse(Integer returnOrderId, String logDetail, OrgAdminUserSession admin, String reply) {
		
		OrgReturnOrder returnOrder = lockQueryById(returnOrderId);
		//判断能否拒绝
		if(returnOrder.getReturnStatus() == OrgReturnOrderConstant.RETURN_STATUS_APPLY){
			//订单状态改为拒绝
			returnOrder.setReturnStatus(OrgReturnOrderConstant.RETURN_STATUS_REFUSE);
			returnOrder.setReply(reply);
			updateByIdSelective(returnOrder);
			//订单对应的产品修改退换货数量(释放)
			OrgOrderGoods orderGoods = orgOrderGoodsService.lockQueryById(returnOrder.getOrderGoodsId());
			orderGoods.setReturnAmount(orderGoods.getReturnAmount() - returnOrder.getAmount());
			orgOrderGoodsService.updateByIdSelective(orderGoods);
			//修改订单的退货状态
			orgOrderService.updateReturnStatus(returnOrder.getOrderId());
			orgReturnOrderLogService.addByAdmin(returnOrder.getReturnOrderId(), admin.getOrgAdminUser().getUserId(), OrgReturnOrderLogConstant.TYPE_ADMIN_REFUSE,logDetail);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateFail(Integer returnOrderId, String logDetail, OrgAdminUserSession admin, String reply) {
		
		OrgReturnOrder returnOrder = lockQueryById(returnOrderId);
		//判断能否失败
		if(returnOrder.getReturnStatus() == OrgReturnOrderConstant.RETURN_STATUS_WAIT_RETURN){
			//订单状态改为退货中
			returnOrder.setReturnStatus(OrgReturnOrderConstant.RETURN_STATUS_REFUSE);
			returnOrder.setReply(reply);
			updateByIdSelective(returnOrder);
			//订单对应的产品修改退换货数量(释放)
			OrgOrderGoods orderGoods = orgOrderGoodsService.lockQueryById(returnOrder.getOrderGoodsId());
			orderGoods.setReturnAmount(orderGoods.getReturnAmount() - returnOrder.getAmount());
			orgOrderGoodsService.updateByIdSelective(orderGoods);
			orgOrderGoodsService.updateByIdSelective(orderGoods);
			//修改订单的退货状态
			orgOrderService.updateReturnStatus(returnOrder.getOrderId());
			orgReturnOrderLogService.addByAdmin(returnOrder.getReturnOrderId(), admin.getOrgAdminUser().getUserId(), OrgReturnOrderLogConstant.TYPE_ADMIN_FAIL,logDetail);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateFinish(OrgReturnOrder orgReturnOrder,String logDetail, OrgAdminUserSession admin) {
			
		OrgReturnOrder returnOrder = lockQueryById(orgReturnOrder.getReturnOrderId());
		
		//判断能否完成
		if(returnOrder.getReturnStatus() == OrgReturnOrderConstant.RETURN_STATUS_WAIT_RETURN){
			//订单状态改为已退货
			returnOrder.setReply(orgReturnOrder.getReply());
			returnOrder.setReturnMoney(orgReturnOrder.getReturnMoney());
			returnOrder.setReturnSendMoney(orgReturnOrder.getReturnSendMoney());
			returnOrder.setReturnUnitPrice(returnOrder.getReturnMoney().subtract(returnOrder.getReturnSendMoney()).divide(BigDecimal.valueOf(returnOrder.getAmount()),2, BigDecimal.ROUND_HALF_UP));
			//金额调整
			returnOrder.setBalance(orgReturnOrder.getReturnMoney().subtract(returnOrder.getReturnUnitPrice().multiply(BigDecimal.valueOf(returnOrder.getAmount()))));
			returnOrder.setReturnStatus(OrgReturnOrderConstant.RETURN_STATUS_FINISH);
			updateByIdSelective(returnOrder);
			if(returnOrder.getReturnStatus() == OrgReturnOrderConstant.RETURN_STYLE_CHANGE){
				//订单对应的产品修改退换货数量(释放)
				OrgOrderGoods orderGoods = orgOrderGoodsService.lockQueryById(returnOrder.getOrderGoodsId());
				orderGoods.setReturnAmount(orderGoods.getReturnAmount() - returnOrder.getAmount());
				orgOrderGoodsService.updateByIdSelective(orderGoods);
				//修改订单的退货状态
				orgOrderService.updateReturnStatus(returnOrder.getOrderId());
			}
			
			orgReturnOrderLogService.addByAdmin(returnOrder.getReturnOrderId(), admin.getOrgAdminUser().getUserId(), OrgReturnOrderLogConstant.TYPE_ADMIN_FINISH,logDetail);
			//如果为退货添加退款单
			if(returnOrder.getReturnStyle() == OrgReturnOrderConstant.RETURN_STYLE_RETURN){
				orgRefundOrderService.addByReturnOrder(returnOrder);
			}
			
			//远程数据库数据修改
			rxReturnOrderService.add(returnOrder);
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void updateRemark(Integer returnOrderId, String logDetail, OrgAdminUserSession admin) {
		orgReturnOrderLogService.addByAdmin(returnOrderId, admin.getOrgAdminUser().getUserId(), OrgReturnOrderLogConstant.TYPE_ADMIN_REMARK,logDetail);
	}
}