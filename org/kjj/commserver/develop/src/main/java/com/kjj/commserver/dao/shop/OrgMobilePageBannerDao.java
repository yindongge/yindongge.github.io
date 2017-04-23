package com.kjj.commserver.dao.shop;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgMobilePageBanner;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageBannerQuery;
import com.kjj.core.dao.BaseDao;

public interface OrgMobilePageBannerDao extends BaseDao<OrgMobilePageBanner, Integer> {

	int updateId(OrgMobilePageBanner orgClickBanner);

	List<OrgMobilePageBanner> queryBannerList(OrgMobilePageBannerQuery query);
}