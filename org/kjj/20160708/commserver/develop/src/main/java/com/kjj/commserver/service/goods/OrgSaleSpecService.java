package com.kjj.commserver.service.goods;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.commserver.entity.goods.OrgSaleSpecValue;
import com.kjj.core.service.BaseService;

public interface OrgSaleSpecService extends BaseService<OrgSaleSpec, Integer> {
	/**
	 * 分页查询销售规格（包含规格值集合）
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgSaleSpec> queryPageList(OrgSaleSpec query, Pageable pageable);
	
	/**
	 * 添加销售规格及规格值
	 * @param orgSaleSpec
	 * @param values
	 */
	void addSaleSpecAndValues(OrgSaleSpec orgSaleSpec, List<OrgSaleSpecValue> values);
	
	/**
	 * 更新销售规格及规格值
	 * @param orgSaleSpec
	 * @param values
	 */
	void updateSaleSpecAndValues(OrgSaleSpec orgSaleSpec, List<OrgSaleSpecValue> values);
	
	/**
	 * 删除销售规格及规格值
	 * @param id 销售规格id
	 */
	void deleteSaleSpecAndValues(Integer id);
	
	/**
	 * 添加销售规格值
	 * @param saleSpecList
	 */
	void addSaleSpecValues(List<OrgSaleSpec> saleSpecList);
	
	/**
	 * 添加销售规格值字符串
	 * @param saleSpecList
	 */
	void addSaleSpecValuesStr(List<OrgSaleSpec> saleSpecList);
	
	/**
	 * 根据类型id获取关联的销售规格及规格值
	 * @param typeId 类型id
	 * @return
	 */
	List<OrgSaleSpec> querySaleSpecAndValuesByProductTypeId(Integer typeId);
	
}