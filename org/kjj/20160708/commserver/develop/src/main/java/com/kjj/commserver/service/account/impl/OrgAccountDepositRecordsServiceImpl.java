package com.kjj.commserver.service.account.impl;

import java.math.BigDecimal;

import com.kjj.commserver.dao.account.OrgAccountDepositRecordsDao;
import com.kjj.commserver.entity.account.OrgAccountDepositRecords;
import com.kjj.commserver.service.account.OrgAccountDepositRecordsService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class OrgAccountDepositRecordsServiceImpl extends BaseServiceImpl<OrgAccountDepositRecords, Integer> implements OrgAccountDepositRecordsService {
    @Resource
    private OrgAccountDepositRecordsDao orgAccountDepositRecordsDao;

    @Override
    protected BaseDao<OrgAccountDepositRecords, Integer> getBaseDao() {
        return orgAccountDepositRecordsDao;
    }

	@Override
	public BigDecimal queryOweOfAllowance(Integer userId) {
		return orgAccountDepositRecordsDao.queryOweOfAllowance(userId);
	}
}