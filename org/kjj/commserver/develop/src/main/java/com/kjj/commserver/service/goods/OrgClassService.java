package com.kjj.commserver.service.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgClassQuery;
import com.kjj.core.service.BaseService;

public interface OrgClassService extends BaseService<OrgClass, Integer> {
	

	/**
	 * 根据等级获取分类
	 * @param level
	 * @return
	 */
	List<OrgClass> queryListByLevel(Byte level);

	/**
	 * 根据父类ID查询所有子分类
	 * @param classId
	 * @return
	 */
	List<OrgClass> queryListByParentId(Integer parentId);
	/**
	 * 获取所有分类
	 * @param 
	 * @return
	 */
	List<OrgClass> queryListAcvtive();
	/**
	 * 
	 * @param classId
	 * @return
	 */
	OrgClass queryOrgClassById(Integer classId);
	
	/**
	 * 按照级别获取所有分类树
	 * @param query
	 * @return
	 */
	List<OrgClass> queryListAllAsTree();
	
	/**
	 * 按照级别获取要显示的分类树
	 * @param query
	 * @return
	 */
	List<OrgClass> queryListShowAsTree();
	
	/**
	 * 修改
	 * @param query
	 */
	void update(OrgClassQuery query);
	
	/**
	 * 查询和品牌关联的分类
	 * @param id 品牌id
	 * @return
	 */
	List<OrgClass> queryLinkedClassByBrandId(Integer id);
	
	/**
	 * 删除分类；下架分类下的spu，逻辑删除sku
	 * @param id 分类id
	 */
	void deleteClass(Integer id);
}