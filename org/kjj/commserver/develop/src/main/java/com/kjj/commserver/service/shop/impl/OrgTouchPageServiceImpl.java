package com.kjj.commserver.service.shop.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgTouchPageDao;
import com.kjj.commserver.entity.shop.OrgTouchPage;
import com.kjj.commserver.entity.shop.aide.OrgTouchPageQuery;
import com.kjj.commserver.service.shop.OrgTouchPageService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgTouchPageServiceImpl extends BaseServiceImpl<OrgTouchPage, Integer> implements OrgTouchPageService {
    @Resource
    private OrgTouchPageDao orgTouchPageDao;

    @Override
    protected BaseDao<OrgTouchPage, Integer> getBaseDao() {
        return orgTouchPageDao;
    }
    
    @Override
	public Page<OrgTouchPage> queryPageList(OrgTouchPage query,Pageable pageable){
		return orgTouchPageDao.queryPageList(query, pageable);
	}

	@Override
	public void addTouchPage(OrgTouchPage orgTouchPage) {
		 super.add(orgTouchPage);
	}

	@Override
	public void deleteTouchPageById(Integer id) {
		super.deleteById(id);
	}

	@Override
	public void updateTouchPageByIdSelective(OrgTouchPage orgTouchPage) {
		super.updateByIdSelective(orgTouchPage);
	}

	@Override
	public OrgTouchPage queryByAreaCodeShopId(OrgTouchPageQuery query) {
		return orgTouchPageDao.queryByAreaCodeShopId(query);
	}
}