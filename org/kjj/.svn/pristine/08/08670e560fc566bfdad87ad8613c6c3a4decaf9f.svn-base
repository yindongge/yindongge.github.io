package com.kjj.commserver.dao.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.shop.OrgTouchPage;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageQuery;
import com.kjj.core.dao.BaseDao;

public interface OrgTouchPageDao extends BaseDao<OrgTouchPage, Integer> {

	Page<OrgTouchPage> queryPageList(OrgTouchPage query, Pageable pageable);

	OrgTouchPage queryByAreaCodeShopId(OrgTouchPageQuery query);
}