package com.kjj.commserver.service.order.impl;

import java.util.List;

import com.kjj.commserver.dao.order.OrgReturnOrderImgDao;
import com.kjj.commserver.entity.order.OrgReturnOrderImg;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderImgQuery;
import com.kjj.commserver.service.order.OrgReturnOrderImgService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class OrgReturnOrderImgServiceImpl extends BaseServiceImpl<OrgReturnOrderImg, Integer> implements OrgReturnOrderImgService {
    @Resource
    private OrgReturnOrderImgDao orgReturnOrderImgDao;

    @Override
    protected BaseDao<OrgReturnOrderImg, Integer> getBaseDao() {
        return orgReturnOrderImgDao;
    }

	@Override
	public List<OrgReturnOrderImg> queryByReturnOrderId(Integer returnOrderId) {
		OrgReturnOrderImgQuery query = new OrgReturnOrderImgQuery();
		query.setReturnOrderId(returnOrderId);
		return queryList(query);
	}
}