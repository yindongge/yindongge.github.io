package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgMobilePageBannerDao;
import com.kjj.commserver.entity.shop.OrgMobilePageBanner;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageBannerQuery;
import com.kjj.commserver.service.shop.OrgMobilePageBannerService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgMobilePageBannerServiceImpl extends BaseServiceImpl<OrgMobilePageBanner, Integer> implements OrgMobilePageBannerService {
    @Resource
    private OrgMobilePageBannerDao orgMobilePageBannerDao;

    @Override
    protected BaseDao<OrgMobilePageBanner, Integer> getBaseDao() {
        return orgMobilePageBannerDao;
    }

	@Override
	public List<OrgMobilePageBanner> queryByPageId(Integer pageId) {
		OrgMobilePageBannerQuery query = new OrgMobilePageBannerQuery();
		query.setPageId(pageId);
		Sort sort = new Sort(Direction.ASC,"t.id");
		return queryList(query,sort);
	}

	@Override
	public int updateId(OrgMobilePageBanner orgClickBanner) {
		return orgMobilePageBannerDao.updateId(orgClickBanner);
	}

	@Override
	public List<OrgMobilePageBanner> queryBannerList(OrgMobilePageBannerQuery query) {
		return orgMobilePageBannerDao.queryBannerList(query);
	}

	@Override
	public void addBanner(OrgMobilePageBanner orgMobilePageBanner) {
		super.add(orgMobilePageBanner);
	}

	@Override
	public void updateBannerByIdSelective(OrgMobilePageBanner orgMobilePageBanner) {
		super.updateByIdSelective(orgMobilePageBanner);
	}

	@Override
	public void deleteBannerById(Integer id) {
		super.deleteById(id);
	}
}