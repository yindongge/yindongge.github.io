package com.kjj.ruixing.service.goods.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import com.kjj.ruixing.dao.goods.BasplustockDao;
import com.kjj.ruixing.entity.goods.Basplustock;
import com.kjj.ruixing.entity.goods.aide.BasplustockQuery;
import com.kjj.ruixing.service.goods.BasplustockService;

@Service
public class BasplustockServiceImpl extends BaseServiceImpl<Basplustock, Short> implements BasplustockService {
    @Resource
    private BasplustockDao basplustockDao;

    @Override
    protected BaseDao<Basplustock, Short> getBaseDao() {
        return basplustockDao;
    }

	@Override
	public List<Basplustock> queryListByLastUpdateTime(Date lastUpdateTime) {
		BasplustockQuery query = new BasplustockQuery();
		query.setLastUpdateTime(lastUpdateTime);
		return queryList(query);
	}
}