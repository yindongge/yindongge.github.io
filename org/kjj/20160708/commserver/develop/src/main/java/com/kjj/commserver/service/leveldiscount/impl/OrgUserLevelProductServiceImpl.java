package com.kjj.commserver.service.leveldiscount.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.leveldiscount.OrgUserLevelProductDao;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelProduct;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelProductQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelProductVo;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelProductService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgUserLevelProductServiceImpl extends BaseServiceImpl<OrgUserLevelProduct, Integer> implements OrgUserLevelProductService {
    @Resource
    private OrgUserLevelProductDao orgUserLevelProductDao;

    @Override
    protected BaseDao<OrgUserLevelProduct, Integer> getBaseDao() {
        return orgUserLevelProductDao;
    }

	@Override
	public Page<OrgUserLevelProductVo> selectPageLevelProduct(OrgUserLevelProductQuery query,Pageable pageable) {
		if((query.getGoodsSn() == null && query.getGoodsName() == null) || (query.getGoodsSn().trim().length() == 0 && query.getGoodsName().trim().length() == 0)) {
			return orgUserLevelProductDao.selectPageLevelProduct(query, pageable);
		} else {
			return orgUserLevelProductDao.selectPageProductLevel(query, pageable);
		}
		
	}
    
	@Override
	public Page<OrgUserLevelProductVo> selectPageProductLevel(OrgUserLevelProductQuery query,Pageable pageable) {
		return orgUserLevelProductDao.selectPageLevelProduct(query, pageable);
	}

	@Override
	public void updateActive(Integer goodsId) {
		OrgUserLevelProduct levelProduct = new OrgUserLevelProduct();
		levelProduct.setGoodsId(goodsId);
		orgUserLevelProductDao.insert(levelProduct);
	}

	@Override
	public void updateNoActive(Integer id) {
		orgUserLevelProductDao.deleteById(id);
	}
}