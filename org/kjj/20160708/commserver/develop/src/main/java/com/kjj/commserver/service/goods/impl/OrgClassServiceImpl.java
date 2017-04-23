package com.kjj.commserver.service.goods.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgClassDao;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgClassQuery;
import com.kjj.commserver.entity.goods.aide.OrgClassVo;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgClassServiceImpl extends BaseServiceImpl<OrgClass, Integer> implements OrgClassService {
    @Resource
    private OrgClassDao orgClassDao;

    @Override
    protected BaseDao<OrgClass, Integer> getBaseDao() {
        return orgClassDao;
    }
	@Override
	public List<OrgClass> queryListByLevel(Byte level) {
		OrgClassQuery query = new OrgClassQuery();
		query.setClassActive((short) OrgClassConstant.CLASS_ACTIVE);
		query.setClassLevel(level);
		Sort sort = new Sort(Direction.ASC,"t.class_order");
		return queryList(query,sort);
	}

	@Override
	public List<OrgClass> queryListByParentId(Integer parentId) {
		OrgClassQuery query = new OrgClassQuery();
		query.setClassParent(parentId);
		query.setClassActive(OrgClassConstant.CLASS_ACTIVE);
		Sort sort = new Sort(Direction.ASC,"t.class_order");
		return queryList(query,sort);
	}

	@Override
	public List<OrgClass> queryListAcvtive() {
		OrgClassQuery query = new OrgClassQuery();
		query.setClassActive(OrgClassConstant.CLASS_ACTIVE);
		Sort sort = new Sort(Direction.ASC,"case when t.class_level=1 then t.class_id when t.class_level=2 then t.class_parent end,t.class_level,t.class_order");
		return queryList(query,sort);
	}

	@Override
	public OrgClass queryOrgClassById(Integer classId) {
		OrgClassQuery query = new OrgClassQuery();
		query.setClassId(classId);
		return queryOne(query);
	}
	
	@Override
	public List<OrgClass> queryListAllAsTree() {
		List<OrgClass> classesLevel1 = queryListByLevel(OrgClassConstant.LEVEL_ONE);
		//添加二级分类
		addChildrenClasses(classesLevel1);
		//添加三级分类
		List<OrgClass> classesLevel2 = new ArrayList<OrgClass>();
		OrgClassVo classVo = null;
		for(OrgClass item:classesLevel1){
			classVo = (OrgClassVo)item;
			classesLevel2.addAll(classVo.getChildrenList());
		}
		addChildrenClasses(classesLevel2);
		addSkuNum(classesLevel1);
		return classesLevel1;
	}
	
	/**
	 * 添加子分类
	 * @param classes
	 */
	private void addChildrenClasses(List<OrgClass> listParents){
		if(CollectionUtils.isNotEmpty(listParents)){
			Map<Integer, OrgClassVo> classMap = new HashMap<Integer, OrgClassVo>();
			OrgClassVo classVo = null;
			for(OrgClass parentClass : listParents){
				classVo = (OrgClassVo)parentClass; 
				classMap.put(classVo.getClassId(), classVo);
			}
			OrgClassQuery query = new OrgClassQuery();
			query.setClassActive(OrgClassConstant.CLASS_ACTIVE);
			query.setClassParentIds(classMap.keySet());
			List<OrgClass> listChildren = queryList(query, new Sort(Direction.ASC, "t.class_order"));
			for(OrgClass childrenClass:listChildren){
				classMap.get(childrenClass.getClassParent()).getChildrenList().add(childrenClass);
			}
		}		
	}
	
	@Override
	public List<OrgClass> queryListShowAsTree() {
		List<OrgClass> classesLevel1 = queryListByLevelShow(OrgClassConstant.LEVEL_ONE);
		//添加二级分类
		addChildrenClassesShow(classesLevel1);
		return classesLevel1;
	}
	
	private List<OrgClass> queryListByLevelShow(Byte level) {
		OrgClassQuery query = new OrgClassQuery();
		query.setClassActive((short) OrgClassConstant.CLASS_ACTIVE);
		query.setClassShowmenu(OrgClassConstant.IS_CLASS_SHOW_MENU);
		query.setClassLevel(level);
		Sort sort = new Sort(Direction.ASC,"t.class_order");
		return queryList(query,sort);
	}
	
	private void addChildrenClassesShow(List<OrgClass> listParents){
		if(CollectionUtils.isNotEmpty(listParents)){
			Map<Integer, OrgClassVo> classMap = new HashMap<Integer, OrgClassVo>();
			OrgClassVo classVo = null;
			for(OrgClass parentClass : listParents){
				classVo = (OrgClassVo)parentClass; 
				classMap.put(classVo.getClassId(), classVo);
			}
			OrgClassQuery query = new OrgClassQuery();
			query.setClassActive(OrgClassConstant.CLASS_ACTIVE);
			query.setClassShowmenu(OrgClassConstant.IS_CLASS_SHOW_MENU);
			query.setClassParentIds(classMap.keySet());
			List<OrgClass> listChildren = queryList(query, new Sort(Direction.ASC, "t.class_order"));
			for(OrgClass childrenClass:listChildren){
				classMap.get(childrenClass.getClassParent()).getChildrenList().add(childrenClass);
			}
		}		
	}
	
	@Override
	public void add(OrgClass entity){
		OrgClassQuery classQuery = (OrgClassQuery)entity;
		entity.setClassCommonUse(OrgClassConstant.CLASS_COMMON_USE);
		entity.setClassActive((short)OrgClassConstant.CLASS_ACTIVE);
		if(null == entity.getClassOrder()){
			entity.setClassOrder(Short.valueOf("255"));
		}
		if(classQuery.getClassLevel() == OrgClassConstant.LEVEL_ONE){
			entity.setClassParent(OrgClassConstant.PARENT_ID_FOR_LEVEL_ONE);
		}		
		if(classQuery.isClassShowmenuMark()){
			entity.setClassShowmenu(OrgClassConstant.IS_CLASS_SHOW_MENU);
		}else{
			entity.setClassShowmenu(OrgClassConstant.IS_NOT_CLASS_SHOW_MENU);
		}
		if(classQuery.isClassShowhighlightMark()){
			entity.setClassShowhighlight(OrgClassConstant.IS_CLASS_SHOW_HIGH_LIGHT);
		}else{
			entity.setClassShowhighlight(OrgClassConstant.IS_NOT_CLASS_SHOW_HIGH_LIGHT);
		}
		super.add(entity);
	}

	@Override
	public void update(OrgClassQuery query) {
		if(query.getClassLevel() == OrgClassConstant.LEVEL_ONE){
			query.setClassParent(OrgClassConstant.PARENT_ID_FOR_LEVEL_ONE);
		}		
		if(query.isClassShowmenuMark()){
			query.setClassShowmenu(OrgClassConstant.IS_CLASS_SHOW_MENU);
		}else{
			query.setClassShowmenu(OrgClassConstant.IS_NOT_CLASS_SHOW_MENU);
		}
		if(query.isClassShowhighlightMark()){
			query.setClassShowhighlight(OrgClassConstant.IS_CLASS_SHOW_HIGH_LIGHT);
		}else{
			query.setClassShowhighlight(OrgClassConstant.IS_NOT_CLASS_SHOW_HIGH_LIGHT);
		}
		
		//如果修改类型：此分类下已关联spu下架，逻辑删除spu下所有sku
		OrgClass classOld = this.queryById(query.getClassId());
		if(!query.getClassType().equals(classOld.getClassType())){
			List<Integer> classIds = new ArrayList<Integer>();
			classIds.add(classOld.getClassId());
			orgClassDao.offSaleLinkedSpuByClassIds(classIds);
			orgClassDao.deleteSkuLinkedSaleSpecByClassIds(classIds);
			orgClassDao.deleteLinkedSkuByClassIds(classIds);
		}
		updateByIdSelective(query);		
	}

	@Override
	public List<OrgClass> queryLinkedClassByBrandId(Integer id) {
		return orgClassDao.queryByBrandId(id);
	}
	@Override
	public void deleteClass(Integer id) {
		//1删除此分类；2此分类及子分类下的spu下架，删除spu下所有sku
		List<Integer> classIds = new ArrayList<Integer>();
		classIds.add(id);
		orgClassDao.offSaleLinkedSpuByClassIds2(classIds);
		orgClassDao.deleteSkuLinkedSaleSpecByClassIds(classIds);
		orgClassDao.deleteLinkedSkuByClassIds(classIds);
		this.deleteById(id);
	}
	
	/**
	 * 统计分类sku数量(按照三级分类统计)
	 * @param classList 分类树
	 */
	private void addSkuNum(List<OrgClass> classList){
		Map<Integer, Map<String, Object>> skuNumMap = orgClassDao.selectSkuNumByClassId();
		for(OrgClass classLevelOne:classList){
			OrgClassVo classLevelOneVo = (OrgClassVo)classLevelOne;
			Long skuNumForLevelOne = 0L;
			if(null != skuNumMap.get(classLevelOneVo.getClassId())){
				skuNumForLevelOne += Long.valueOf(skuNumMap.get(classLevelOneVo.getClassId()).get("skuNum").toString()); 
			}
			List<OrgClass> childrenLevelTwoList = classLevelOneVo.getChildrenList();
			for(OrgClass classLevelTwo:childrenLevelTwoList){
				Long skuNumForLevelTwo = 0L;
				OrgClassVo classLevelTwoVo = (OrgClassVo)classLevelTwo;
				if(null != skuNumMap.get(classLevelTwoVo.getClassId())){
					skuNumForLevelOne += Long.valueOf(skuNumMap.get(classLevelTwoVo.getClassId()).get("skuNum").toString()); 
					skuNumForLevelTwo += Long.valueOf(skuNumMap.get(classLevelTwoVo.getClassId()).get("skuNum").toString());
				}
				List<OrgClass> childrenLevelThreeList = classLevelTwoVo.getChildrenList();
				for(OrgClass classLevelThree:childrenLevelThreeList){
					OrgClassVo classLevelThreeVo = (OrgClassVo)classLevelThree;
					if(null != skuNumMap.get(classLevelThreeVo.getClassId())){
						classLevelThreeVo.setSkuNum(Long.valueOf(skuNumMap.get(classLevelThreeVo.getClassId()).get("skuNum").toString()));
						skuNumForLevelOne += Long.valueOf(skuNumMap.get(classLevelThreeVo.getClassId()).get("skuNum").toString()); 
						skuNumForLevelTwo += Long.valueOf(skuNumMap.get(classLevelThreeVo.getClassId()).get("skuNum").toString());
					}
				}
				classLevelTwoVo.setSkuNum(skuNumForLevelTwo);
			}
			classLevelOneVo.setSkuNum(skuNumForLevelOne);
		}
	}
	
}