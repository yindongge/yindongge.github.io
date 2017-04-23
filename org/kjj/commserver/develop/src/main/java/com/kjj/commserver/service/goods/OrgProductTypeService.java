package com.kjj.commserver.service.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.core.service.BaseService;

public interface OrgProductTypeService extends BaseService<OrgProductType, Integer> {
	/**
	 * 添加类型、关联销售规格、商品属性
	 * @param productType
	 */
	void addProductTypeAndPropery(OrgProductType productType);
	/**
	 * 添加属性及属性值，并关联类型
	 * @param productPropertyQuery
	 */
	void addPropertyAndVluesAndLinkType(OrgProductProperty productProperty);
	/**
	 * 删除属性，属性值及关联类型
	 * @param propertyId
	 * @param typeId
	 */
	void deletePropertyAndLinkType(Integer propertyId, Integer typeId);
	/**
	 * 修改类型
	 * @param productType
	 */
	void updateProductType(OrgProductType productType);
	/**
	 * 删除类型
	 * @param id
	 */
	void deleteType(Integer id);
	/**
	 * 查询类型、关联的销售规格及商品属性
	 * @param id 类型id
	 * @return
	 */
	OrgProductType queryEntityAndLinkedById(Integer id);
	/**
	 * 下架关联此类型的spu
	 * @param typeId 类型id
	 */
	void offSaleLinkedSpuByProductTypeId(Integer typeId);
	/**
	 * 逻辑删除关联此类型的sku
	 * @param typeId 类型id
	 */
	void deleteLinkedSkuByProductTypeId(Integer typeId);
	
	/**
	 * 删除此类型下sku关联的销售规格
	 * @param typeId 类型id
	 */
	void deleteSkuLinkedSaleSpecByProductTypeId(Integer typeId);
	
	/**
	 * 添加属性数量
	 * @param productTypeList 类型集合
	 */
	void addPropertyNum(List<OrgProductType> productTypeList);
}