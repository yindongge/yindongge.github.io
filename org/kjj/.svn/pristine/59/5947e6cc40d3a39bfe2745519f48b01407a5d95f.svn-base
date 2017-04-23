package com.kjj.commserver.service.special.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.special.OrgSpecialRuleDao;
import com.kjj.commserver.entity.special.OrgSpecialRule;
import com.kjj.commserver.entity.special.aide.OrgSpecialRuleQuery;
import com.kjj.commserver.service.special.OrgSpecialRuleService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgSpecialRuleServiceImpl extends BaseServiceImpl<OrgSpecialRule, Integer> implements OrgSpecialRuleService {
    @Resource
    private OrgSpecialRuleDao orgSpecialRuleDao;

    @Override
    protected BaseDao<OrgSpecialRule, Integer> getBaseDao() {
        return orgSpecialRuleDao;
    }

	@Override
	public void updateBySpecialId(OrgSpecialRule orgSpecialRule) {
		if(orgSpecialRule.getSpecialId()!=null){
			OrgSpecialRuleQuery orgSpecialRuleQuery = new OrgSpecialRuleQuery();
			orgSpecialRuleQuery.setSpecialId(orgSpecialRule.getSpecialId());
			OrgSpecialRule orgSpecialRuleTmp = queryOne(orgSpecialRuleQuery);
			if(orgSpecialRuleTmp!=null){
				Integer id = orgSpecialRuleTmp.getId();
				orgSpecialRule.setId(id);
				updateByIdSelective(orgSpecialRule);
			}
		}
	}
}