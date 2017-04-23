package com.kjj.commserver.service.discount.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgReachGiveDao;
import com.kjj.commserver.entity.discount.OrgReachGive;
import com.kjj.commserver.entity.discount.aide.OrgReachGiveQuery;
import com.kjj.commserver.service.discount.OrgReachGiveService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgReachGiveServiceImpl extends BaseServiceImpl<OrgReachGive, Integer> implements OrgReachGiveService {
    @Resource
    private OrgReachGiveDao orgReachGiveDao;

    @Override
    protected BaseDao<OrgReachGive, Integer> getBaseDao() {
        return orgReachGiveDao;
    }

	@Override
	public List<OrgReachGive> queryListByRdIds(Collection<Integer> rdIds) {
		OrgReachGiveQuery query = new OrgReachGiveQuery();
		query.setRdIds(rdIds);
		return queryList(query);
	}
}