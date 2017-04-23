package com.kjj.commserver.service.system.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.system.OrgModelDao;
import com.kjj.commserver.entity.system.OrgModel;
import com.kjj.commserver.entity.system.aide.OrgModelConstant;
import com.kjj.commserver.entity.system.aide.OrgModelQuery;
import com.kjj.commserver.entity.system.aide.OrgModelVo;
import com.kjj.commserver.service.system.OrgAdminAuthorityService;
import com.kjj.commserver.service.system.OrgModelService;
import com.kjj.commserver.service.system.OrgRoleRightService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgModelServiceImpl extends BaseServiceImpl<OrgModel, Integer> implements OrgModelService {
    @Resource
    private OrgModelDao orgModelDao;
    @Resource
    private OrgAdminAuthorityService orgAdminAuthorityService;
    @Resource
    private OrgRoleRightService orgRoleRightService;
    
    @Override
    protected BaseDao<OrgModel, Integer> getBaseDao() {
        return orgModelDao;
    }

	
	public List<OrgModel> queryListByParentId(Integer parentId) {
		OrgModelQuery query = new OrgModelQuery();
		query.setModelparent(parentId);
		return queryList(query);
	}
	
	@Override
	public Map<Integer,OrgModel> queryMapByUserId(Short userId) {
		OrgModelQuery query = new OrgModelQuery();
		query.setUserId(userId);
		query.setIsactive(OrgModelConstant.STATUS_ACTIVE);
		Sort sort = new Sort(Direction.ASC,"t.modelId");
		List<OrgModel> list = queryList(query,sort);
		Map<Integer,OrgModel> mapUser = new LinkedHashMap<Integer,OrgModel>();
		//一级菜单
		for(OrgModel model:list){
			if(model.getModelparent() == 0){
				mapUser.put(model.getModelid(),model);
			}
		}
		//二级菜单
		for(OrgModel model:list){
			if(model.getModelparent() != 0){
				((OrgModelVo)mapUser.get(model.getModelparent())).getModelList().add(model);
			}
		}
		return mapUser;
	}
	
	@Override
	public List<OrgModel> queryTreeByParentId(Integer parentId) {
		//只支持二级菜单
		//获取一级菜单
		List<OrgModel> list = queryListByParentId(parentId);
		//获取二级菜单
		for(OrgModel orgModel : list){			
			((OrgModelVo)orgModel).setModelList(queryListByParentId(orgModel.getModelid()));
		}
		return list;
	}
	
	@Override
	public int deleteById(Integer modelid){
		//用户菜单删除
		orgAdminAuthorityService.deleteByAuthorityId(modelid);
		//角色菜单删除
		orgRoleRightService.deleteByModelId(modelid);
		return super.deleteById(modelid);
	}
}