package com.kjj.commserver.service.special.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.special.OrgSpecialLinkDao;
import com.kjj.commserver.entity.special.OrgSpecialLink;
import com.kjj.commserver.entity.special.aide.OrgSpecialLinkConstant;
import com.kjj.commserver.entity.special.aide.OrgSpecialLinkQuery;
import com.kjj.commserver.service.special.OrgSpecialLinkService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgSpecialLinkServiceImpl extends BaseServiceImpl<OrgSpecialLink, Integer> implements OrgSpecialLinkService {
    @Resource
    private OrgSpecialLinkDao orgSpecialLinkDao;

    @Override
    protected BaseDao<OrgSpecialLink, Integer> getBaseDao() {
        return orgSpecialLinkDao;
    }

	@Override
	public void save(OrgSpecialLink orgSpecialLink) {
		if(orgSpecialLink.getSpecialId()!=null){
			if(orgSpecialLink.getId()!=null){
				updateByIdSelective(orgSpecialLink);
			}else{
				add(orgSpecialLink);
			}
		}
	}

	@Override
	public Integer selectMaxOrder(Integer specialId) {
		return orgSpecialLinkDao.selectMaxOrder(specialId);
	}

	@Override
	public void saveAllAnchor(Integer specialId,List<OrgSpecialLink> orgSpecialLinkList) {
		if(specialId!=null){
			OrgSpecialLinkQuery orgSpecialLinkQuery = new OrgSpecialLinkQuery();
			orgSpecialLinkQuery.setSpecialId(specialId);
			orgSpecialLinkQuery.setType(OrgSpecialLinkConstant.LINK_TYPE_ANCHOR);
			delete(orgSpecialLinkQuery);
			for (OrgSpecialLink orgSpecialLink : orgSpecialLinkList) {
				orgSpecialLink.setSpecialId(specialId);
				orgSpecialLink.setType(OrgSpecialLinkConstant.LINK_TYPE_ANCHOR);
			}
			addInBatch(orgSpecialLinkList);
		}
		
	}

}

