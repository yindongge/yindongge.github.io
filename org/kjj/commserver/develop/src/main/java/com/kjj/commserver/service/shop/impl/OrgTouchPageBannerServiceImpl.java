package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgTouchPageBannerDao;
import com.kjj.commserver.entity.shop.OrgTouchPageBanner;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageBannerQuery;
import com.kjj.commserver.service.shop.OrgTouchPageBannerService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgTouchPageBannerServiceImpl extends BaseServiceImpl<OrgTouchPageBanner, Integer> implements OrgTouchPageBannerService {
    @Resource
    private OrgTouchPageBannerDao orgTouchPageBannerDao;

    @Override
    protected BaseDao<OrgTouchPageBanner, Integer> getBaseDao() {
        return orgTouchPageBannerDao;
    }

	@Override
	public List<OrgTouchPageBanner> queryByPageId(Integer pageId) {
		OrgTouchPageBannerQuery query = new OrgTouchPageBannerQuery();
		query.setPageId(pageId);
		Sort sort = new Sort(Direction.ASC,"t.image_order");
		return queryList(query,sort);
	}

	@Override
	public Integer selectMaxOrder(Integer pageId) {
		return orgTouchPageBannerDao.selectMaxOrder(pageId);
	}

	@Override
	public void save(OrgTouchPageBanner orgTouchPageBanner) {
		if(orgTouchPageBanner.getPageId() != null){
			if(orgTouchPageBanner.getId() != null){
				updateByIdSelective(orgTouchPageBanner);
			}else{
				add(orgTouchPageBanner);
			}
		}
	}

	@Override
	public List<OrgTouchPageBanner> queryBannerList(OrgTouchPageBannerQuery query) {
		return orgTouchPageBannerDao.queryBannerList(query);
	}
}