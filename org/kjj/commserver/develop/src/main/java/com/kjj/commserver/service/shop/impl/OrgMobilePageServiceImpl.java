package com.kjj.commserver.service.shop.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgMobilePageDao;
import com.kjj.commserver.entity.shop.OrgMobilePage;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageQuery;
import com.kjj.commserver.service.shop.OrgMobilePageService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgMobilePageServiceImpl extends BaseServiceImpl<OrgMobilePage, Integer> implements OrgMobilePageService {
    @Resource
    private OrgMobilePageDao orgMobilePageDao;

    @Override
    protected BaseDao<OrgMobilePage, Integer> getBaseDao() {
        return orgMobilePageDao;
    }
    
    @Override
	public Page<OrgMobilePage> queryPageList(OrgMobilePage query,Pageable pageable){
		return orgMobilePageDao.queryPageList(query, pageable);
	}

	@Override
	public OrgMobilePage queryByAreaCodeShopId(OrgMobilePageQuery query) {
		return orgMobilePageDao.queryByAreaCodeShopId(query);
	}

	@Override
	public void addMobilePage(OrgMobilePage orgMobilePage) {
		 super.add(orgMobilePage);
	}

	@Override
	public void deleteMobilePageById(Integer id) {
		super.deleteById(id);
	}

	@Override
	public void updateMobilePageByIdSelective(OrgMobilePage orgMobilePage) {
		super.updateByIdSelective(orgMobilePage);
	}	
}