package com.kjj.commserver.service.goods.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgProductPropertyDao;
import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.OrgProductPropertyValue;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyValueQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyVo;
import com.kjj.commserver.service.goods.OrgProductPropertyService;
import com.kjj.commserver.service.goods.OrgProductPropertyValueService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgProductPropertyServiceImpl extends BaseServiceImpl<OrgProductProperty, Integer> implements OrgProductPropertyService {
    @Resource
    private OrgProductPropertyDao orgProductPropertyDao;
    
    @Resource
    private OrgProductPropertyValueService productPropertyValueService;

    @Override
    protected BaseDao<OrgProductProperty, Integer> getBaseDao() {
        return orgProductPropertyDao;
    }

	@Override
	public List<OrgProductProperty> queryPropertyAndValuesByTypeId(
			Integer typeId) {
		List<OrgProductProperty> productPropertyList = orgProductPropertyDao.queryByProductTypeId(typeId);
		addPropertyValues(productPropertyList);
		addPropertyValuesStr(productPropertyList);
		return productPropertyList;
	}
	/**
	 * 添加属性值
	 * @param productPropertyList
	 */
	private void addPropertyValues(List<OrgProductProperty> productPropertyList){
		if(CollectionUtils.isNotEmpty(productPropertyList)){
			Map<Integer, OrgProductPropertyVo> productPropertyMap = new HashMap<Integer, OrgProductPropertyVo>();
			OrgProductPropertyVo productPropertyVo = null;
			for(OrgProductProperty productProperty:productPropertyList){
				productPropertyVo = (OrgProductPropertyVo)productProperty;
				productPropertyMap.put(productProperty.getPropertyId(), productPropertyVo);
			}
			OrgProductPropertyValueQuery productPropertyValueQuery = new OrgProductPropertyValueQuery();
			productPropertyValueQuery.setPropertyIds(productPropertyMap.keySet());
			List<OrgProductPropertyValue> productPropertyValueList = productPropertyValueService.queryList(productPropertyValueQuery);
			for(OrgProductPropertyValue productPropertyValue:productPropertyValueList){
				productPropertyMap.get(productPropertyValue.getPropertyId()).getPropertyValues().add(productPropertyValue);
			}
		}
	}
	
	/**
	 * 添加属性值字符串
	 * @param productPropertyList
	 */
	private void addPropertyValuesStr(List<OrgProductProperty> productPropertyList){
		OrgProductPropertyVo productPropertyVo = null;
		for(OrgProductProperty productProperty:productPropertyList){
			productPropertyVo = (OrgProductPropertyVo)productProperty;
			StringBuffer buffer = new StringBuffer();
			boolean flag = false;
			for(OrgProductPropertyValue productPropertyValue:productPropertyVo.getPropertyValues()){
				if(flag){
					buffer.append("、");
				}else{
					flag = true;
				}
				buffer.append(productPropertyValue.getPropertyValue());
			}
			productPropertyVo.setPropertyValuesStr(buffer.toString());
		}
	}

	@Override
	public void updatePropertyAndValues(OrgProductPropertyQuery query) {
		orgProductPropertyDao.updateByIdSelective(query);
		OrgProductPropertyValue propertyValue = null;
		for(int i=0;i<query.getPropertyValueIds().size();i++){
			if(query.getPropertyValueIds().get(i) == -1){
				propertyValue = new OrgProductPropertyValue();
				propertyValue.setPropertyId(query.getPropertyId());
				propertyValue.setPropertyValue(query.getPropertyValues().get(i));
				productPropertyValueService.add(propertyValue);
			}else if(null != query.getIsDeletes() && query.getIsDeletes().get(i) == true){
				productPropertyValueService.deleteById(query.getPropertyValueIds().get(i));
			}else{
				propertyValue = new OrgProductPropertyValue();
				propertyValue.setPropertyValueId(query.getPropertyValueIds().get(i));
				propertyValue.setPropertyId(query.getPropertyId());
				propertyValue.setPropertyValue(query.getPropertyValues().get(i));
				productPropertyValueService.updateByIdSelective(propertyValue);
			}
		}
		
	}
}