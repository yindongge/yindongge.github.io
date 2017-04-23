package com.kjj.commserver.service.shop.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopPageDao;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgShopPage;
import com.kjj.commserver.entity.shop.aide.OrgShopPageConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopPageQuery;
import com.kjj.commserver.entity.shop.aide.OrgShopPageVo;
import com.kjj.commserver.service.shop.OrgShopBannerService;
import com.kjj.commserver.service.shop.OrgShopPageFloorService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.shop.OrgShopRecommandService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopPageServiceImpl extends BaseServiceImpl<OrgShopPage, Integer> implements OrgShopPageService {
	@Resource
	private OrgShopPageDao orgShopPageDao;
	@Resource
	private OrgShopBannerService orgShopBannerService;
	@Resource
	private OrgShopRecommandService orgShopRecommandService;
	@Resource
	private OrgShopPageFloorService orgShopPageFloorService;

	@Override
	protected BaseDao<OrgShopPage, Integer> getBaseDao() {
		return orgShopPageDao;
	}
	
	@Override
	public Page<OrgShopPage> queryPageList(OrgShopPage query,Pageable pageable){
		return orgShopPageDao.queryPageList(query, pageable);
	}

	@Override
	public OrgShopPage queryByShop(OrgShop orgShop) {
		OrgShopPageVo orgShopPage = null;
		// 店铺展示
		orgShopPage = (OrgShopPageVo)queryActiveByShopId(orgShop.getShopId());
		if (orgShopPage == null) {
			// 区域默认店铺展示
			orgShopPage = (OrgShopPageVo)queryActiveDefaultByAreaCode(orgShop.getAreaCode());
		}
		if(orgShopPage != null){
			//店铺轮播图
			orgShopPage.setListShopBanner(orgShopBannerService.queryByPageId(orgShopPage.getId()));
			//推荐商品
			orgShopPage.setListShopRecommand(orgShopRecommandService.queryByPageId(orgShopPage.getId()));
			//楼层
			orgShopPage.setListShopPageFloor(orgShopPageFloorService.queryActiveByPageId(orgShopPage.getId()));
		}
		return orgShopPage;
	}
	
	@Override
	public String queryShopSearchByShop(OrgShop orgShop) {
		OrgShopPageVo orgShopPage = null;
		// 店铺展示
		orgShopPage = (OrgShopPageVo)queryActiveByShopId(orgShop.getShopId());
		if (orgShopPage == null) {
			// 区域默认店铺展示
			orgShopPage = (OrgShopPageVo)queryActiveDefaultByAreaCode(orgShop.getAreaCode());
		}
		return orgShopPage == null ? null : orgShopPage.getShopSearch();
	}

	private OrgShopPage queryActiveByShopId(Integer shopId) {
		OrgShopPageQuery query = new OrgShopPageQuery();
		query.setShopId(shopId);
		query.setIsactive(OrgShopPageConstant.STATUS_ACTIVE);
		query.setIsdelete(OrgShopPageConstant.STATUS_DELETE_NO);
		query.setType(OrgShopPageConstant.TYPE_SHOP);
		return queryOne(query);
	}
	
	private OrgShopPage queryActiveByAreaCode(String areaCode) {
		OrgShopPageQuery query = new OrgShopPageQuery();
		query.setShopId(Integer.parseInt(areaCode));
		query.setIsactive(OrgShopPageConstant.STATUS_ACTIVE);
		query.setIsdelete(OrgShopPageConstant.STATUS_DELETE_NO);
		query.setType(OrgShopPageConstant.TYPE_AREA);
		return queryOne(query);
	}

	private OrgShopPage queryActiveDefaultByAreaCode(final String areaCode) {
		OrgShopPage orgShopPage = null;
		// 区县默认
		orgShopPage = queryActiveByAreaCode(areaCode);
		if (orgShopPage != null) {
			return orgShopPage;
		}
		// 市默认
		orgShopPage = queryActiveByAreaCode(areaCode.substring(0, 4)+"00");
		if (orgShopPage != null) {
			return orgShopPage;
		}
		// 省默认
		orgShopPage = queryActiveByAreaCode(areaCode.substring(0, 2)+"0000");
		if (orgShopPage != null) {
			return orgShopPage;
		}
		// 全部默认
		orgShopPage = queryActiveByAreaCode("-1");
		if (orgShopPage != null) {
			return orgShopPage;
		}
		return orgShopPage;
	}

	@Override
	public void deletePage(Integer pageId) {
		OrgShopPage orgShopPage = new OrgShopPage();
		orgShopPage.setId(pageId);
		orgShopPage.setIsdelete(OrgShopPageConstant.STATUS_DELETE_YES);
		orgShopPageDao.updateByIdSelective(orgShopPage);
	}
}