package com.kjj.commserver.service.goods.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgBrandDao;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgBrandLinkType;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgBrandConstant;
import com.kjj.commserver.entity.goods.aide.OrgBrandLinkTypeQuery;
import com.kjj.commserver.entity.goods.aide.OrgBrandQuery;
import com.kjj.commserver.entity.goods.aide.OrgBrandVo;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.service.goods.OrgBrandLinkTypeService;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgBrandServiceImpl extends BaseServiceImpl<OrgBrand, Integer> implements OrgBrandService {
    @Resource
    private OrgBrandDao orgBrandDao;
    
    @Resource
    private OrgBrandLinkTypeService brandLinkTypeService;
    
    @Resource
    private OrgClassService classService;
    
    @Resource
    private OrgProductItemService productItemService;

    @Override
    protected BaseDao<OrgBrand, Integer> getBaseDao() {
        return orgBrandDao;
    }

	@Override
	public List<OrgBrand> queryAllBrandByClass(Integer classId) {
		OrgBrandQuery query = new OrgBrandQuery();
		query.setClassId(classId);
		query.setIsActive(OrgBrandConstant.IS_ACTIVE);
		return queryList(query);
	}

	@Override
	public void add(OrgBrand brand, List<OrgBrandLinkType> brandLinkTypeList) {
		brand.setIsActive(OrgBrandConstant.IS_ACTIVE);
		super.add(brand);
		for(OrgBrandLinkType brandLinkType:brandLinkTypeList){
			brandLinkType.setBrandId(brand.getProductBrandId());
		}
		brandLinkTypeService.addInBatch(brandLinkTypeList);
	}

	@Override
	public void deleteBrandAndLinkedClassById(Integer id) {
		super.deleteById(id);
		OrgBrandLinkTypeQuery query = new OrgBrandLinkTypeQuery();
		query.setBrandId(id);
		brandLinkTypeService.delete(query);
	}

	@Override
	public OrgBrand queryBrandAndLinkedClassById(Integer id) {
		OrgBrand brand = super.queryVoById(id);
		OrgBrandVo brandVo = (OrgBrandVo)brand;
		//查询关联分类
		List<OrgClass> linkedClasses = classService.queryLinkedClassByBrandId(id);
		brandVo.setClasses(linkedClasses);
		return brand;
	}

	@Override
	public void update(OrgBrand brand, List<OrgBrandLinkType> brandLinkTypeList) {
		super.updateByIdSelective(brand);
		OrgBrandLinkTypeQuery brandLinkTypeQuery = new OrgBrandLinkTypeQuery();
		brandLinkTypeQuery.setBrandId(brand.getProductBrandId());
		brandLinkTypeService.delete(brandLinkTypeQuery);
		for(OrgBrandLinkType brandLinkType:brandLinkTypeList){
			brandLinkType.setBrandId(brand.getProductBrandId());
		}
		brandLinkTypeService.addInBatch(brandLinkTypeList);
	}

	@Override
	public List<OrgBrand> queryAllBrandByClassParent(Integer classParentId) {
		OrgBrandQuery query = new OrgBrandQuery();
		query.setClassParentId(classParentId);
		query.setIsActive(OrgBrandConstant.IS_ACTIVE);
		return orgBrandDao.selectList(query, "selectVoByClassParentId");
	}

	public List<OrgBrand> queryVoByClassIdAndLevel(Integer classId) {
		//查询商品分类等级
		OrgClass orgClass = classService.queryVoById(classId);
		Byte classLevel = orgClass.getClassLevel();
		if(classLevel.equals(OrgClassConstant.LEVEL_ONE)){
			//如果是第一级,查询品牌
			return queryAllBrandByClassParent(classId);
			
		}else if(classLevel.equals(OrgClassConstant.LEVEL_TWO)){
			//如果是第二级,查询品牌
			return queryAllBrandByClass(classId);
		}
		return null;
	}

	@Override
	public void addSkuNum(List<OrgBrand> brandList) {
		List<Integer> brandIdList = new ArrayList<Integer>();
		for(OrgBrand brand:brandList){
			brandIdList.add(brand.getProductBrandId());
		}
		Map<Integer, Map<String, Object>> skuNumMap = orgBrandDao.selectSkuNumByBrandId(brandIdList);
		for(OrgBrand brand:brandList){
			Map<String, Object> skuNum = skuNumMap.get(brand.getProductBrandId());
			if(null != skuNum){
				brand.setBrandProductCount(Integer.valueOf(skuNum.get("skuNum").toString()));
			}else{
				brand.setBrandProductCount(0);
			}
		}
	}
	
}