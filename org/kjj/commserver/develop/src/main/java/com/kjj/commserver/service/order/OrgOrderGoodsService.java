package com.kjj.commserver.service.order;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.goods.aide.OrgGoodsReportVo;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.core.service.BaseService;

public interface OrgOrderGoodsService extends BaseService<OrgOrderGoods, Integer> {

	/**
	 * 根据ID查询订单商品并锁定
	 * @param orderGoodsId
	 * @return
	 */
	OrgOrderGoods lockQueryById(Integer orderGoodsId);
	
	/**
	 * 下单生成商品
	 * @param orgUsersSession session中user
	 * @param orgOrder 订单
	 * @param listCartAll 订单商品明细
	 */
	void addBatch(OrgUsersSession orgUsersSession,OrgOrder orgOrder,List<OrgCartAll> listCartAll);
	
	/**
	 * 根据订单号查询订单商品
	 * @param collection orderIds
	 * @return
	 */
	List<OrgOrderGoods> queryByOrderIds(Collection<Integer> orderIds);
	/**
	 * 根据订单号查询订单商品
	 * @param orderId
	 * @return
	 */
	List<OrgOrderGoods> queryByOrderId(Integer orderId);
	/**
	 * 根据订单号查询可退换订单商品
	 * @param orderId
	 * @return
	 */
	List<OrgOrderGoods> query4ReturnByOrderId(Integer orderId);
	/**
	 * 查询评论信息
	 * @param orgOrderGoods
	 * @param pageable
	 * @return
	 */
	Page<OrgOrderGoods> queryPageListComment(OrgOrderGoods orgOrderGoods, Pageable pageable);
	/**
	 * 根据订单id查询评论信息
	 * @param orderId
	 * @return
	 */
    List<OrgOrderGoods> queryCommentByOrderId(Integer orderId);

	/**
	 * 查询其他数量信息
	 * @param OrgOrderGoods query
	 * @return
	 */
	long queryOtherCount(OrgOrderGoods query);
	
	/**
	 * 查询评论信息，不分页
	 * @param orgOrderGoods
	 * @return
	 */
	List<OrgOrderGoods> queryListComment(OrgOrderGoods query);
	
	/**
	 * 查询可评价商品
	 * @param query
	 * @return
	 */
	Long queryCountCanCommentByUserId(Integer userId);
	/**
	 * 查询不可评价商品
	 * @param query
	 * @return
	 */
	Long queryCountCanNotCommentByUserId(Integer userId);
	
	/**
	 * 查询订单商品为订单报表
	 * @param orgOrderGoods
	 * @return
	 */
	List<OrgOrderGoods> queryList4OrderReport(OrgOrderGoods query);
	
	
	/**
	 * 分页查询所售商品报表
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgGoodsReportVo> queryPageList4GoodsReport(OrgOrderGoods query,Pageable pageable);
	
	/**
	 * 导出所售商品报表
	 * @param query
	 * @return
	 */
	String exportExcel(OrgOrderGoodsQuery query);
	
}