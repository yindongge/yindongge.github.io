package com.kjj.commserver.service.shop.impl;

import java.util.List;

import com.kjj.commserver.dao.shop.OrgMobilePageModuleDao;
import com.kjj.commserver.entity.shop.OrgMobilePageModule;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageModuleQuery;
import com.kjj.commserver.service.shop.OrgMobilePageModuleService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class OrgMobilePageModuleServiceImpl extends BaseServiceImpl<OrgMobilePageModule, Integer> implements OrgMobilePageModuleService {
    @Resource
    private OrgMobilePageModuleDao orgMobilePageModuleDao;

    @Override
    protected BaseDao<OrgMobilePageModule, Integer> getBaseDao() {
        return orgMobilePageModuleDao;
    }

	@Override
	public List<OrgMobilePageModule> queryByPageId(Integer pageId) {
		OrgMobilePageModuleQuery query = new OrgMobilePageModuleQuery();
		query.setPageId(pageId);
		Sort sort = new Sort(Direction.ASC,"t.module_order");
		return queryList(query,sort);
	}

	@Override
	public Long queryMaxOrder() {
		return orgMobilePageModuleDao.queryMaxOrder();
	}

	@Override
	public void addModule(OrgMobilePageModule orgMobilePageModule) {
		super.add(orgMobilePageModule);
	}

	@Override
	public void updateModuleByIdSelective(OrgMobilePageModule orgMobilePageModule) {
		super.updateByIdSelective(orgMobilePageModule);
	}

	@Override
	public void deleteModuleById(Integer id) {
		super.deleteById(id);
	}
}