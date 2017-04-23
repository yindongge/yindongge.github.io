package com.kjj.commserver.dao.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.shop.OrgMobilePage;
import com.kjj.commserver.entity.shop.aide.OrgMobilePageQuery;
import com.kjj.core.dao.BaseDao;

public interface OrgMobilePageDao extends BaseDao<OrgMobilePage, Integer> {

	Page<OrgMobilePage> queryPageList(OrgMobilePage query, Pageable pageable);

	OrgMobilePage queryByAreaCodeShopId(OrgMobilePageQuery query);
}