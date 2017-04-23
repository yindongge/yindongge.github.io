package com.kjj.commserver.service.shop;

import com.kjj.commserver.entity.shop.OrgMobilePageCustomize;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageCustomizeQuery;
import com.kjj.core.service.BaseService;

public interface OrgMobilePageCustomizeService extends BaseService<OrgMobilePageCustomize, Integer> {

	OrgMobilePageCustomize queryOnlyOne(OrgMobilePageCustomizeQuery query);

	OrgMobilePageCustomize queryForOne(OrgMobilePageCustomizeQuery customizeQuery);
}