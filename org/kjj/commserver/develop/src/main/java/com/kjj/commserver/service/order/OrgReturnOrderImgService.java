package com.kjj.commserver.service.order;

import java.util.List;

import com.kjj.commserver.entity.order.OrgReturnOrderImg;
import com.kjj.core.service.BaseService;

public interface OrgReturnOrderImgService extends BaseService<OrgReturnOrderImg, Integer> {

	/**
	 * 根据orderid查询出退换货图片信息
	 * @param returnOrderId
	 * @return
	 */
	List<OrgReturnOrderImg> queryByReturnOrderId(Integer returnOrderId);
}