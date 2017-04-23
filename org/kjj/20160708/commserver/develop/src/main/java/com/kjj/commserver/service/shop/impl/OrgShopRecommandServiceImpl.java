package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopRecommandDao;
import com.kjj.commserver.entity.shop.OrgShopRecommand;
import com.kjj.commserver.entity.shop.aide.OrgShopRecommandQuery;
import com.kjj.commserver.service.shop.OrgShopRecommandService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopRecommandServiceImpl extends BaseServiceImpl<OrgShopRecommand, Integer> implements OrgShopRecommandService {
    @Resource
    private OrgShopRecommandDao orgShopRecommandDao;

    @Override
    protected BaseDao<OrgShopRecommand, Integer> getBaseDao() {
        return orgShopRecommandDao;
    }

	@Override
	public List<OrgShopRecommand> queryByPageId(Integer pageId) {
		OrgShopRecommandQuery query = new OrgShopRecommandQuery();
		query.setPageid(pageId);
		Sort sort = new Sort(Direction.ASC,"t.id");
		return queryList(query,sort);
	}

	@Override
	public void updateRecommandImg1(String oldPath, String newPath, String url) {
		orgShopRecommandDao.updateRecommandImg1(oldPath, newPath, url);
	}

	@Override
	public void updateRecommandImg2(String oldPath, String newPath, String url) {
		orgShopRecommandDao.updateRecommandImg2(oldPath, newPath, url);
	}

	@Override
	public void updateUrlByImg1(String imgPath1, String url) {
		orgShopRecommandDao.updateUrlByImg1(imgPath1, url);
		
	}

	@Override
	public void deleteRecommandByImg1(String imgPath1) {
		orgShopRecommandDao.deleteRecommandByImg1(imgPath1);
		
	}
	
	
}