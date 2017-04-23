package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopBannerDao;
import com.kjj.commserver.entity.shop.OrgShopBanner;
import com.kjj.commserver.entity.shop.aide.OrgShopBannerQuery;
import com.kjj.commserver.service.shop.OrgShopBannerService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopBannerServiceImpl extends BaseServiceImpl<OrgShopBanner, Integer> implements OrgShopBannerService {
    @Resource
    private OrgShopBannerDao orgShopBannerDao;

    @Override
    protected BaseDao<OrgShopBanner, Integer> getBaseDao() {
        return orgShopBannerDao;
    }

	@Override
	public List<OrgShopBanner> queryByPageId(Integer pageId) {
		OrgShopBannerQuery query = new OrgShopBannerQuery();
		query.setPageid(pageId);
//		Sort sort = new Sort(Direction.ASC,"t.id");
		Sort sort = new Sort(Direction.ASC,"t.org_shop_banner_order");
		return queryList(query,sort);
	}

	@Override
	public void updateBanner(String oldpath, String url, String newpath,String bannerOrder) {
		orgShopBannerDao.updateBanner(oldpath, url, newpath,bannerOrder);
	}

	@Override
	public void updateBannerUrlByImg(String imgPath, String url) {
		orgShopBannerDao.updateBannerUrlByImg(imgPath, url);
		
	}

	@Override
	public void deleteBannerByImg(String imgPath) {
		orgShopBannerDao.deleteBannerByImg(imgPath);
	}

	@Override
	public void updateBanner(String oldpath, String bannerOrder) {
		orgShopBannerDao.updateBanner(oldpath, bannerOrder);
		
	}
}