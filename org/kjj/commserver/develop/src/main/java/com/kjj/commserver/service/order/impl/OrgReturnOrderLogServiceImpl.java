package com.kjj.commserver.service.order.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.order.OrgReturnOrderLogDao;
import com.kjj.commserver.entity.order.OrgReturnOrderLog;
import com.kjj.commserver.entity.order.aide.OrgReturnOrderLogQuery;
import com.kjj.commserver.service.order.OrgReturnOrderLogService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgReturnOrderLogServiceImpl extends BaseServiceImpl<OrgReturnOrderLog, Integer> implements OrgReturnOrderLogService {
    @Resource
    private OrgReturnOrderLogDao orgReturnOrderLogDao;

    @Override
    protected BaseDao<OrgReturnOrderLog, Integer> getBaseDao() {
        return orgReturnOrderLogDao;
    }

	@Override
	public void addBuyUser(Integer returnOrderId, Integer userId, Byte logType,String logDetail) {
		OrgReturnOrderLog orgReturnOrderLog = new OrgReturnOrderLog();
		orgReturnOrderLog.setReturnOrderId(returnOrderId);
		orgReturnOrderLog.setUserId(userId);
		orgReturnOrderLog.setLogType(logType);
		orgReturnOrderLog.setLogDetail(logDetail);
		orgReturnOrderLog.setLogTime(new Date());
		add(orgReturnOrderLog);
	}

	@Override
	public List<OrgReturnOrderLog> queryByReturnOrderId(Integer returnOrderId) {
		OrgReturnOrderLogQuery query = new OrgReturnOrderLogQuery();
		query.setReturnOrderId(returnOrderId);
		Sort sort = new Sort(Direction.DESC,"t.log_id");
		return queryList(query,sort);
	}

	@Override
	public void addByAdmin(Integer returnOrderId, Short adminId, Byte logType,String logDetail) {
		OrgReturnOrderLog orgReturnOrderLog = new OrgReturnOrderLog();
		orgReturnOrderLog.setReturnOrderId(returnOrderId);
		orgReturnOrderLog.setAdminId(adminId);
		orgReturnOrderLog.setLogType(logType);
		orgReturnOrderLog.setLogDetail(logDetail);
		orgReturnOrderLog.setLogTime(new Date());
		add(orgReturnOrderLog);
		
	}
}