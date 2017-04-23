package com.kjj.commserver.service.shop.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgBusinessAreaDao;
import com.kjj.commserver.entity.shop.OrgBusinessArea;
import com.kjj.commserver.entity.shop.aide.OrgBusinessAreaConstant;
import com.kjj.commserver.entity.shop.aide.OrgBusinessAreaQuery;
import com.kjj.commserver.service.shop.OrgBusinessAreaService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgBusinessAreaServiceImpl extends BaseServiceImpl<OrgBusinessArea, Integer> implements OrgBusinessAreaService {
    @Resource
    private OrgBusinessAreaDao orgBusinessAreaDao;

    @Override
    protected BaseDao<OrgBusinessArea, Integer> getBaseDao() {
        return orgBusinessAreaDao;
    }

	@Override
	public List<OrgBusinessArea> queryListByAreaCodeLike(String areaCode) {
		OrgBusinessAreaQuery query = new OrgBusinessAreaQuery();
		query.setAreaCodeLike(areaCode);
		return queryList(query);
	}

	@Override
	public void add(OrgBusinessArea businessArea) {
		//添加商圈
		businessArea.setStatus(OrgBusinessAreaConstant.STATUS_EFFECTIVE);
		businessArea.setCreateTime(new Date());
		businessArea.setUpdateTime(new Date());
		super.add(businessArea);
	}

	@Override
	public void update(OrgBusinessArea businessArea) {
		businessArea.setUpdateTime(new Date());
		super.updateByIdSelective(businessArea);
	}
}