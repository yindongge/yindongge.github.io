package com.kjj.commserver.service.order.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.order.OrgOrderLogDao;
import com.kjj.commserver.entity.order.OrgOrderLog;
import com.kjj.commserver.entity.order.aide.OrgOrderLogQuery;
import com.kjj.commserver.service.order.OrgOrderLogService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgOrderLogServiceImpl extends BaseServiceImpl<OrgOrderLog, Integer> implements OrgOrderLogService {
    @Resource
    private OrgOrderLogDao orgOrderLogDao;

    @Override
    protected BaseDao<OrgOrderLog, Integer> getBaseDao() {
        return orgOrderLogDao;
    }

	@Override
	public void addByUser(Integer orderId,Integer userId,Byte logType, String logDetail) {
		OrgOrderLog orgOrderLog = new OrgOrderLog();
		orgOrderLog.setOrderId(orderId);
		orgOrderLog.setUserId(userId);
		orgOrderLog.setLogType(logType);
		orgOrderLog.setLogDetail(logDetail);
		orgOrderLog.setLogTime(new Date());
		add(orgOrderLog);
	}

	@Override
	public List<OrgOrderLog> query4AdminByOrderId(Integer orderId) {
		OrgOrderLogQuery query = new OrgOrderLogQuery();
		query.setOrderId(orderId);
		Sort sort = new Sort(Direction.DESC,"t.log_id");
		return queryList(query, sort);
	}
	
	@Override
	public List<OrgOrderLog> query4UserByOrderId(Integer orderId) {
		OrgOrderLogQuery query = new OrgOrderLogQuery();
		query.setOrderId(orderId);
		query.setTypeShowNotNull(true);
		Sort sort = new Sort(Direction.DESC,"t.log_id");
		return queryList(query, sort);
	}

	@Override
	public void addByAdmin(Integer orderId, Short adminId,Byte logType,String logDetail) {
		OrgOrderLog orgOrderLog = new OrgOrderLog();
		orgOrderLog.setOrderId(orderId);
		orgOrderLog.setAdminId(adminId);
		orgOrderLog.setLogType(logType);
		orgOrderLog.setLogDetail(logDetail);
		orgOrderLog.setLogTime(new Date());
		add(orgOrderLog);
	}

	@Override
	public void addBySystem(Integer orderId, Byte logType, String logDetail) {
		OrgOrderLog orgOrderLog = new OrgOrderLog();
		orgOrderLog.setOrderId(orderId);
		orgOrderLog.setLogType(logType);
		orgOrderLog.setLogDetail(logDetail);
		orgOrderLog.setLogTime(new Date());
		add(orgOrderLog);
	}
}