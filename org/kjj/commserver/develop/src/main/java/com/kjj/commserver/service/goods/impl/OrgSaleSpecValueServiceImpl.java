package com.kjj.commserver.service.goods.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgSaleSpecValueDao;
import com.kjj.commserver.entity.goods.OrgSaleSpecValue;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecValueQuery;
import com.kjj.commserver.service.goods.OrgSaleSpecValueService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgSaleSpecValueServiceImpl extends BaseServiceImpl<OrgSaleSpecValue, Integer> implements OrgSaleSpecValueService {
    @Resource
    private OrgSaleSpecValueDao orgSaleSpecValueDao;

    @Override
    protected BaseDao<OrgSaleSpecValue, Integer> getBaseDao() {
        return orgSaleSpecValueDao;
    }

	@Override
	public List<OrgSaleSpecValue> queryBySaleSpecIds(
			Collection<Integer> saleSpecIds) {
		OrgSaleSpecValueQuery query = new OrgSaleSpecValueQuery();
		query.setSaleSpecIds(saleSpecIds);
		return orgSaleSpecValueDao.selectList(query);
	}

	@Override
	public List<OrgSaleSpecValue> queryBySaleSpecId(Integer saleSpecId) {
		OrgSaleSpecValueQuery query = new OrgSaleSpecValueQuery();
		query.setSpecId(saleSpecId);
		return orgSaleSpecValueDao.selectList(query);
	}

	@Override
	public void saveOrUpdate(OrgSaleSpecValue saleSpecValue) {
		if(null == saleSpecValue.getSpecValueId()){			
			orgSaleSpecValueDao.insert(saleSpecValue);
		}else{
			orgSaleSpecValueDao.updateByIdSelective(saleSpecValue);
		}
		
	}

}