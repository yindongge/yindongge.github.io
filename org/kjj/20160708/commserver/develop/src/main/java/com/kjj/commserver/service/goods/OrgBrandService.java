package com.kjj.commserver.service.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgBrandLinkType;
import com.kjj.core.service.BaseService;

public interface OrgBrandService extends BaseService<OrgBrand, Integer> {


	/**
	 * 根据商品所属商品分类id获取品牌
	 * @param catId
	 * @return
	 */
	List<OrgBrand> queryAllBrandByClass(Integer classId);
	
	/**
	 * 添加品牌及关联的分类
	 * @param brand
	 * @param brandLinkTypeList
	 */
	void add(OrgBrand brand, List<OrgBrandLinkType> brandLinkTypeList);
	
	/**
	 * 删除品牌和关联的分类
	 * @param id
	 */
	void deleteBrandAndLinkedClassById(Integer id);
	
	/**
	 * 查询品牌和关联分类
	 * @param id 品牌id
	 * @return
	 */
	OrgBrand queryBrandAndLinkedClassById(Integer id);
	
	/**
	 * 修改品牌及关联分类
	 * @param brand
	 * @param brandLinkTypeList
	 */
	void update(OrgBrand brand, List<OrgBrandLinkType> brandLinkTypeList);
	
	/**
	 * 根据商品所属商品分类id获取品牌
	 * @param classParentId
	 * @return
	 */
	List<OrgBrand> queryAllBrandByClassParent(Integer classParentId);
	
	/**
	 * 根据 classLevel获取品牌
	 * @param classId
	 * @return
	 */
	List<OrgBrand> queryVoByClassIdAndLevel(Integer classId);
	
	/**
	 * 统计品牌下的sku数量
	 * @param brandList 品牌集合
	 */
	void addSkuNum(List<OrgBrand> brandList);
	
}