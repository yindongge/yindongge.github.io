package com.kjj.commserver.service.order.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.order.OrgGoodsCommentDao;
import com.kjj.commserver.entity.order.OrgGoodsComment;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.aide.OrgGoodsCommentConstant;
import com.kjj.commserver.entity.order.aide.OrgGoodsCommentQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsVo;
import com.kjj.commserver.service.order.OrgGoodsCommentService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgGoodsCommentServiceImpl extends BaseServiceImpl<OrgGoodsComment, Integer> implements OrgGoodsCommentService {
    @Resource
    private OrgGoodsCommentDao orgGoodsCommentDao;

    @Resource
	private OrgOrderGoodsService  orgOrderGoodsService;
	
	@Resource
	private OrgOrderService orgOrderService;
	
    @Override
    protected BaseDao<OrgGoodsComment, Integer> getBaseDao() {
        return orgGoodsCommentDao;
    }
    
    @Override
	public void add(OrgGoodsComment orgGoodsComment) {
		OrgOrderGoodsVo orderGoods = orgOrderGoodsService.queryVoById(orgGoodsComment.getOrderGoodsId());
		orgGoodsComment.setUserId(orderGoods.getOrgOrder().getUserId());
		orgGoodsComment.setOrderId(orderGoods.getOrderId());
		orgGoodsComment.setGoodsId(orderGoods.getGoodsId());
		orgGoodsComment.setReplyStatus(OrgOrderGoodsConstant.REPLY_STATUS_WAIT);
		orgGoodsComment.setStatus(OrgOrderGoodsConstant.STATUS_SHOW);
		orgGoodsComment.setCreateTime(new Date());
		super.add(orgGoodsComment);
		//修改org_order_goods评价状态
		orderGoods.setCommentStatus(OrgOrderGoodsConstant.COMMENT_STATUS_COMMENTED);
		orgOrderGoodsService.updateById(orderGoods);
		//修改order评价状态
		OrgOrderGoods query = new OrgOrderGoods();
		query.setOrderId(orderGoods.getOrderId());
		query.setCommentStatus(OrgOrderGoodsConstant.COMMENT_STATUS_UNCOMMENT);
		//全部提交评价
		if(orgOrderGoodsService.queryCount(query) == 0){
			OrgOrder order = new OrgOrder();
			order.setOrderId(orderGoods.getOrderId());
			order.setCommentStatus(OrgOrderConstant.COMMENT_STATUS_COMMENTED);
			orgOrderService.updateByIdSelective(order);
		}
	}

	@Override
	public void updateHide(Integer id) {
		OrgGoodsComment orgGoodsComment = new OrgGoodsComment();
		orgGoodsComment.setId(id);
		orgGoodsComment.setStatus(OrgGoodsCommentConstant.STATUS_HIDE);
		updateByIdSelective(orgGoodsComment);
	}

	@Override
	public void updateShow(Integer id) {
		OrgGoodsComment orgGoodsComment = new OrgGoodsComment();
		orgGoodsComment.setId(id);
		orgGoodsComment.setStatus(OrgGoodsCommentConstant.STATUS_SHOW);
		updateByIdSelective(orgGoodsComment);
	}

	@Override
	public void updateReply(OrgGoodsComment orgGoodsComment) {
		OrgGoodsComment goodsComment = queryById(orgGoodsComment.getId());
		goodsComment.setReply(orgGoodsComment.getReply());
		goodsComment.setReplyStatus(OrgGoodsCommentConstant.REPLY_STATUS_REPLIED);
		goodsComment.setReplyTime(new Date());
		updateByIdSelective(goodsComment);
	}

	@Override
	public  double queryAverageStarScore(OrgGoodsCommentQuery orgGoodsCommentQuery) {
		List<OrgGoodsComment> list = queryList(orgGoodsCommentQuery);
		double total=0d;
		for (OrgGoodsComment orgGoodsComment : list) {
			total+=orgGoodsComment.getStarScore();
		}
		double size = total/list.size();
		return  (total==0l ? 0 : (Math.round(size*100)/100.0));
	}
}