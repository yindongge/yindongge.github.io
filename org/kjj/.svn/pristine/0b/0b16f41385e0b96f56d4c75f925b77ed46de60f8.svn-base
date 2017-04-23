package com.kjj.commserver.service.goods.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgProductPropertyValueDao;
import com.kjj.commserver.entity.goods.OrgProductPropertyValue;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyValueQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyValueVo;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductPropertyValueService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgProductPropertyValueServiceImpl extends BaseServiceImpl<OrgProductPropertyValue, Integer> implements OrgProductPropertyValueService {
    @Resource
    private OrgProductPropertyValueDao orgProductPropertyValueDao;
    
    @Resource
    OrgClassService orgClassService;

    @Override
    protected BaseDao<OrgProductPropertyValue, Integer> getBaseDao() {
        return orgProductPropertyValueDao;
    }

	@Override
	public List<OrgProductPropertyValueVo> queryVoByClassId(Integer classId) {
		OrgProductPropertyValueQuery orgProductPropertyValueQuery=new OrgProductPropertyValueQuery();
		orgProductPropertyValueQuery.setClassId(classId);
		return orgProductPropertyValueDao.selectList(orgProductPropertyValueQuery, "selectVoByClassId");
	}
	
	@Override
	public List<Map<String,Object>> queryListByClassId(Integer classId){
		List<OrgProductPropertyValueVo> OrgProductPropertyValueList = queryVoByClassId(classId);
		Set<Integer> keySet=new HashSet<Integer>();
		for (OrgProductPropertyValueVo orgProductPropertyValueVo : OrgProductPropertyValueList) {
			keySet.add(orgProductPropertyValueVo.getPropertyId());
		}
		List<Map<String,Object>> ListAll=new ArrayList<Map<String,Object>>();
		Map<String,Object> mapAll=null;
		for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			mapAll=new HashMap<String,Object>();
			Set<Map<String,Object>> keyMapSet=new HashSet<Map<String,Object>>();
			List<Map<String, Object>> valueList=new ArrayList<Map<String, Object>>();
			for (OrgProductPropertyValueVo orgProductPropertyValueVo : OrgProductPropertyValueList) {
				Integer propertyId= orgProductPropertyValueVo.getPropertyId();
				if(propertyId.equals(key)){
					Map<String,Object> keyMap=new HashMap<String,Object>();
					keyMap.put("propertyId", propertyId);
					keyMap.put("propertyName", orgProductPropertyValueVo.getPropertyName());
					keyMapSet.add(keyMap);
					Map<String,Object> valueMap=new HashMap<String,Object>();
					valueMap.put("propertyValueId", orgProductPropertyValueVo.getPropertyValueId());
					valueMap.put("propertyValue", orgProductPropertyValueVo.getPropertyValue());
					valueList.add(valueMap);
				}
			}
			mapAll.put("key", keyMapSet);
			mapAll.put("value", valueList);
			ListAll.add(mapAll);
		}		
		return ListAll;
	}	
}





//list 3个
//map （key  map  value list<map>）