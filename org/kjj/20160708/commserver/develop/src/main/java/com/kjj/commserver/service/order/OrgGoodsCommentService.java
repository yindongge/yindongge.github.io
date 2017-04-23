package com.kjj.commserver.service.order;

import com.kjj.commserver.entity.order.OrgGoodsComment;
import com.kjj.commserver.entity.order.aide.OrgGoodsCommentQuery;
import com.kjj.core.service.BaseService;

public interface OrgGoodsCommentService extends BaseService<OrgGoodsComment, Integer> {
	/**
	 * 修改处理状态--隐藏
	 * @param id
	 */
	void updateHide(Integer id);
	/**
	 * 修改处理状态--显示
	 * @param id
	 */
	void updateShow(Integer id);
	/**
	 * 修改回复评论状态 时间
	 * @param id
	 */
	void updateReply(OrgGoodsComment orgGoodsComment);
	
	/**
	 * 获取商品平均评分（满意度）
	 * @param orgGoodsCommentQuery
	 * @return
	 */
	double queryAverageStarScore(OrgGoodsCommentQuery orgGoodsCommentQuery);
}