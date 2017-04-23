package com.kjj.commserver.dao.order;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.goods.aide.OrgGoodsReportVo;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.core.dao.BaseDao;

public interface OrgOrderGoodsDao extends BaseDao<OrgOrderGoods, Integer> {

	/** 
	 * 查询评论信息分页(评论)
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgOrderGoods> selectPageListComment(OrgOrderGoods query,Pageable pageable);

	
	/**
	 * 查询商品信息(评论)
	 * @param query
	 * @return
	 */
	List<OrgOrderGoods> selectListComment(OrgOrderGoods query);

	/**
	 * 查询其他数量信息
	 * @param query
	 * @return
	 */
	long selectOtherCount(OrgOrderGoods query);

	/**
	 * 根据ID查询订单商品并锁定
	 * @param orderGoodsId
	 * @return
	 */
	OrgOrderGoods selectById4Update(Integer orderGoodsId);

	/**
	 * 查询订单商品为订单报表
	 * @param orgOrderGoods
	 * @return
	 */
	List<OrgOrderGoods> selectList4OrderReport(OrgOrderGoods query);

	/**
	 * 分页查询所售商品报表
	 * @param orgOrderGood
	 * @param pageable
	 * @return
	 */
	Page<OrgGoodsReportVo> selectPageList4GoodsReport(OrgOrderGoods query,Pageable pageable);

	/**
	 * 查询所售商品报表
	 * @param orgOrderGoods
	 * @return
	 */
	List<OrgGoodsReportVo> selectList4GoodsReport(OrgOrderGoods query);
}