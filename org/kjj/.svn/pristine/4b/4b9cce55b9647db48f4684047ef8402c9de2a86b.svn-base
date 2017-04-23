package com.kjj.commserver.service.goods.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgProductTypeDao;
import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.OrgProductPropertyValue;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.commserver.entity.goods.OrgProductTypeLinkProductProperty;
import com.kjj.commserver.entity.goods.OrgProductTypeLinkSaleSpec;
import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeForm;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeVo;
import com.kjj.commserver.service.goods.OrgProductPropertyService;
import com.kjj.commserver.service.goods.OrgProductPropertyValueService;
import com.kjj.commserver.service.goods.OrgProductTypeLinkProductPropertyService;
import com.kjj.commserver.service.goods.OrgProductTypeLinkSaleSpecService;
import com.kjj.commserver.service.goods.OrgProductTypeService;
import com.kjj.commserver.service.goods.OrgSaleSpecService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgProductTypeServiceImpl extends BaseServiceImpl<OrgProductType, Integer> implements OrgProductTypeService {
    @Resource
    private OrgProductTypeDao orgProductTypeDao;
    
    @Resource
    private OrgProductTypeLinkSaleSpecService productTypeLinkSaleSpecService;
    
    @Resource
    private OrgProductPropertyService productPropertyService;
    
    @Resource
    private OrgProductPropertyValueService productPropertyValueService;
    
    @Resource
    private OrgProductTypeLinkProductPropertyService productTypeLinkProductPropertyService;
    
    @Resource
    private OrgSaleSpecService saleSpecService;

    @Override
    protected BaseDao<OrgProductType, Integer> getBaseDao() {
        return orgProductTypeDao;
    }
    
    @Override
    public Page<OrgProductType> queryPageList(OrgProductType query, Pageable pageable){
    	query.setIsDelete(OrgProductTypeConstant.IS_NOT_DELETE);
    	Page<OrgProductType> productTypeList = super.queryPageList(query, pageable);
    	return productTypeList;
    }

	@Override
	public void addProductTypeAndPropery(OrgProductType productType) {
		//添加类型
		productType.setIsActive(OrgProductTypeConstant.IS_ACTIVE);
		productType.setIsDelete(OrgProductTypeConstant.IS_NOT_DELETE);
		super.add(productType);
		OrgProductTypeForm  productTypeForm = (OrgProductTypeForm)productType;
		//关联销售规格
		if(null != productTypeForm.getSpecId() && productTypeForm.getSpecId().size() > 0){
			List<OrgProductTypeLinkSaleSpec> productTypeLinkSaleSpecList = new ArrayList<OrgProductTypeLinkSaleSpec>();
			OrgProductTypeLinkSaleSpec productTypeLinkSaleSpec = null;
			for(Integer specId:productTypeForm.getSpecId()){
				productTypeLinkSaleSpec = new OrgProductTypeLinkSaleSpec();
				productTypeLinkSaleSpec.setSpecId(specId);
				productTypeLinkSaleSpec.setProductTypeId(productType.getTypeId());
				productTypeLinkSaleSpecList.add(productTypeLinkSaleSpec);
			}
			productTypeLinkSaleSpecService.addInBatch(productTypeLinkSaleSpecList);
		}
		//添加商品属性
		if(null != productTypeForm.getPropertyName() && productTypeForm.getPropertyName().size() > 0){
			List<OrgProductTypeLinkProductProperty> productTypeLinkProductPropertyList = new ArrayList<OrgProductTypeLinkProductProperty>();
			OrgProductTypeLinkProductProperty productTypeLinkProductProperty = null;
			for(int i = 0; i < productTypeForm.getPropertyName().size();i++){
				//添加属性
				OrgProductProperty productProperty = new OrgProductProperty();
				productProperty.setIsActive(OrgProductPropertyConstant.IS_ACTIVE);
				productProperty.setIsDelete(OrgProductPropertyConstant.IS_NOT_DELETE);
				productProperty.setPropertyInputType(productTypeForm.getPropertyInputType().get(i));
				productProperty.setPropertyName(productTypeForm.getPropertyName().get(i));
				productProperty.setPropertyOrder(productTypeForm.getPropertyOrder().get(i));
				productProperty.setPropertySelect(productTypeForm.getPropertySelect().get(i));
				productPropertyService.add(productProperty);
				//添加属性值
				OrgProductPropertyValue productPropertyValue = null;
				if(productTypeForm.getPropertyInputType().get(i) == OrgProductPropertyConstant.INPUT_TYPE_TEXT){
					productPropertyValue = new OrgProductPropertyValue();
					productPropertyValue.setPropertyId(productProperty.getPropertyId());
					productPropertyValue.setPropertyValue(productTypeForm.getPropertyValue().get(i));
					productPropertyValueService.add(productPropertyValue);
				}else{
					String[] productPropertyValueArr = productTypeForm.getPropertyValue().get(i).split("、");
					List<OrgProductPropertyValue>  productPropertyValueList = new ArrayList<OrgProductPropertyValue>();
					for(String productPropertyValueStr:productPropertyValueArr){
						productPropertyValue = new OrgProductPropertyValue();
						productPropertyValue.setPropertyId(productProperty.getPropertyId());
						productPropertyValue.setPropertyValue(productPropertyValueStr);
						productPropertyValueList.add(productPropertyValue);					
					}
					productPropertyValueService.addInBatch(productPropertyValueList);
				}
				productTypeLinkProductProperty = new OrgProductTypeLinkProductProperty();
				productTypeLinkProductProperty.setProductTypeId(productType.getTypeId());
				productTypeLinkProductProperty.setPropertyId(productProperty.getPropertyId());
				productTypeLinkProductPropertyList.add(productTypeLinkProductProperty);
			}
			//商品类型关联商品属性
			productTypeLinkProductPropertyService.addInBatch(productTypeLinkProductPropertyList);
		}
	}

	@Override
	public void addPropertyAndVluesAndLinkType(OrgProductProperty productProperty) {
		//添加属性
		productPropertyService.add(productProperty);
		//添加属性值
		OrgProductPropertyQuery productPropertyQuery = (OrgProductPropertyQuery)productProperty;
		List<OrgProductPropertyValue> productPropertyValueList = new ArrayList<OrgProductPropertyValue>();
		OrgProductPropertyValue productPropertyValue = null;
		for(String propertyValue:productPropertyQuery.getPropertyValues()){
			productPropertyValue = new OrgProductPropertyValue();
			productPropertyValue.setPropertyValue(propertyValue);
			productPropertyValue.setPropertyId(productProperty.getPropertyId());
			productPropertyValueList.add(productPropertyValue);
		}
		productPropertyValueService.addInBatch(productPropertyValueList);
		//商品类型关联商品属性
		OrgProductTypeLinkProductProperty productTypeLinkProductProperty = new OrgProductTypeLinkProductProperty();
		productTypeLinkProductProperty.setProductTypeId(productPropertyQuery.getTypeId());
		productTypeLinkProductProperty.setPropertyId(productProperty.getPropertyId());
		productTypeLinkProductPropertyService.add(productTypeLinkProductProperty);
	}

	@Override
	public void deletePropertyAndLinkType(Integer propertyId, Integer typeId) {
		//删除属性值
		OrgProductPropertyValue propertyValueQuery = new OrgProductPropertyValue();
		propertyValueQuery.setPropertyId(propertyId);
		productPropertyValueService.delete(propertyValueQuery);
		//删除属性
		productPropertyService.deleteById(propertyId);
		//删除关联类型
		OrgProductTypeLinkProductProperty productTypeLinkProductPropertyQuery = new OrgProductTypeLinkProductProperty();
		productTypeLinkProductPropertyQuery.setProductTypeId(typeId);
		productTypeLinkProductPropertyQuery.setPropertyId(propertyId);
		productTypeLinkProductPropertyService.delete(productTypeLinkProductPropertyQuery);
	}

	@Override
	public void updateProductType(OrgProductType productType) {
		this.updateByIdSelective(productType);
		//如果关联的销售规格项变动，修改关联的销售规格，已关联的spu下架，spu下所有sku 逻辑删除
		OrgProductTypeForm productTypeForm = (OrgProductTypeForm)productType;
		OrgProductTypeLinkSaleSpec productTypeLinkSaleSpecQuery = new OrgProductTypeLinkSaleSpec();
		productTypeLinkSaleSpecQuery.setProductTypeId(productType.getTypeId());
		
		Map<Integer, OrgProductTypeLinkSaleSpec> productTypeLinkSaleSpecMap = productTypeLinkSaleSpecService.queryMap(productTypeLinkSaleSpecQuery, "specId");
		Set<Integer> linkedSpecIdSet = productTypeLinkSaleSpecMap.keySet();
		List<Integer> linkedSpecIdListForAdd = productTypeForm.getSpecId();
		if(null == productTypeForm.getSpecId()){
			linkedSpecIdListForAdd = new ArrayList<Integer>();
		}
		if(linkedSpecIdSet.size() != linkedSpecIdListForAdd.size() || !linkedSpecIdSet.containsAll(linkedSpecIdListForAdd)){
			//修改关联的销售规格
			productTypeLinkSaleSpecService.delete(productTypeLinkSaleSpecQuery);
			if(linkedSpecIdListForAdd.size() > 0){
				List<OrgProductTypeLinkSaleSpec> productTypeLinkSaleSpecList = new ArrayList<OrgProductTypeLinkSaleSpec>();
				OrgProductTypeLinkSaleSpec productTypeLinkSaleSpec = null;
				for(Integer specId:productTypeForm.getSpecId()){
					productTypeLinkSaleSpec = new OrgProductTypeLinkSaleSpec();
					productTypeLinkSaleSpec.setProductTypeId(productType.getTypeId());
					productTypeLinkSaleSpec.setSpecId(specId);
					productTypeLinkSaleSpecList.add(productTypeLinkSaleSpec);
				}
				productTypeLinkSaleSpecService.addInBatch(productTypeLinkSaleSpecList);
			}
			//删除sku关联的销售规格
			this.deleteSkuLinkedSaleSpecByProductTypeId(productType.getTypeId());
			//已关联的spu下架，spu下所有sku 逻辑删除
			this.offSaleLinkedSpuByProductTypeId(productType.getTypeId());
			this.deleteLinkedSkuByProductTypeId(productType.getTypeId());
		}

	}

	@Override
	public void deleteType(Integer id) {
		OrgProductType productType = new OrgProductType();
		productType.setTypeId(id);
		productType.setIsDelete(OrgProductTypeConstant.IS_DELETE);
		this.updateByIdSelective(productType);
	}

	@Override
	public OrgProductType queryEntityAndLinkedById(Integer id) {
		OrgProductType productTypeQuery = new OrgProductType();
		productTypeQuery.setTypeId(id);
		OrgProductTypeVo  productTypeVo = this.queryOne(productTypeQuery);
		if(null != productTypeVo){
			List<OrgSaleSpec> saleSpecList = saleSpecService.querySaleSpecAndValuesByProductTypeId(id);
			if(null != saleSpecList){
				productTypeVo.setSaleSpecList(saleSpecList);
			}
			List<OrgProductProperty> productPropertyList = productPropertyService.queryPropertyAndValuesByTypeId(id);
			if(null != productPropertyList){
				productTypeVo.setProductProperty(productPropertyList);
			}
		}
		return productTypeVo;
	}

	@Override
	public void offSaleLinkedSpuByProductTypeId(Integer typeId) {
		orgProductTypeDao.offSaleLinkedSpuByProductTypeId(typeId);
	}

	@Override
	public void deleteLinkedSkuByProductTypeId(Integer typeId) {
		orgProductTypeDao.deleteLinkedSkuByProductTypeId(typeId);
	}

	@Override
	public void deleteSkuLinkedSaleSpecByProductTypeId(Integer typeId) {
		orgProductTypeDao.deleteSkuLinkedSaleSpecByProductTypeId(typeId);		
	}

	@Override
	public void addPropertyNum(List<OrgProductType> productTypeList) {
		for(OrgProductType productType:productTypeList){
			OrgProductTypeVo productTypeVo = (OrgProductTypeVo)productType;
			OrgProductTypeLinkProductProperty query= new OrgProductTypeLinkProductProperty();
			query.setProductTypeId(productType.getTypeId());
			productTypeVo.setPropertyNum(productTypeLinkProductPropertyService.queryCount(query));
		}
	}
    
    
}