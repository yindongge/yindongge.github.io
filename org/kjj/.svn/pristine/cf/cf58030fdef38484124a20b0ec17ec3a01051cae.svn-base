package com.kjj.commserver.service.discount.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.discount.OrgDiscountScopeDao;
import com.kjj.commserver.entity.discount.OrgDiscountScope;
import com.kjj.commserver.service.discount.OrgDiscountScopeService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgDiscountScopeServiceImpl extends BaseServiceImpl<OrgDiscountScope, Integer> implements OrgDiscountScopeService {
    @Resource
    private OrgDiscountScopeDao orgDiscountScopeDao;

    @Override
    protected BaseDao<OrgDiscountScope, Integer> getBaseDao() {
        return orgDiscountScopeDao;
    }

	@Override
	public void addByDiscount(Byte typeId, Integer discountId,Collection<Byte> listScope) {
		if (CollectionUtils.isNotEmpty(listScope)) {
			OrgDiscountScope orgDiscountScope = null;
			for(Byte scope:listScope){
				orgDiscountScope = new OrgDiscountScope(typeId,discountId);
				orgDiscountScope.setScope(scope);
				add(orgDiscountScope);
			}
		}
		
	}

	@Override
	public Map<Byte, OrgDiscountScope> queryMapKeyScope(OrgDiscountScope orgDiscountScope) {
		return queryMap(orgDiscountScope, "scope");
	}

	@Override
	public void updateByDiscount(Byte typeId, Integer discountId,Collection<Byte> listScope) {
		OrgDiscountScope orgDiscountScope = new OrgDiscountScope();
		orgDiscountScope.setTypeId(typeId);
		orgDiscountScope.setDiscountId(discountId);
		delete(orgDiscountScope);
		addByDiscount(typeId, discountId, listScope);
	}

	@Override
	public String queryInfo(Byte typeId, Integer discountId) {
		return orgDiscountScopeDao.selectInfo(typeId, discountId);
	}
}