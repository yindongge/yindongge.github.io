package com.kjj.commserver.service.goods.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgSaleSpecDao;
import com.kjj.commserver.entity.goods.OrgProduct;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.commserver.entity.goods.OrgSaleSpecValue;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecConstant;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecVo;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.goods.OrgProductService;
import com.kjj.commserver.service.goods.OrgSaleSpecService;
import com.kjj.commserver.service.goods.OrgSaleSpecValueService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgSaleSpecServiceImpl extends BaseServiceImpl<OrgSaleSpec, Integer> implements OrgSaleSpecService {
    @Resource
    private OrgSaleSpecDao orgSaleSpecDao;
    
    @Resource
    private OrgSaleSpecValueService orgSaleSpecValueService;
    
    @Resource
    private OrgProductItemService productItemService;
    
    @Resource
    private OrgProductService productService;
    
    @Override
    protected BaseDao<OrgSaleSpec, Integer> getBaseDao() {
        return orgSaleSpecDao;
    }

	@Override
	public Page<OrgSaleSpec> queryPageList(OrgSaleSpec query, Pageable pageable) {
		Page<OrgSaleSpec> page = super.queryPageList(query, pageable);
		addSaleSpecValues(page.getContent());
		addSaleSpecValuesStr(page.getContent());
		return page;
	}
	
    /**
     * 添加销售规格值
     * @param saleSpecList
     */
    public void addSaleSpecValues(List<OrgSaleSpec> saleSpecList){
    	if(CollectionUtils.isNotEmpty(saleSpecList)){
    		Map<Integer, OrgSaleSpecVo> saleSpecMap = new HashMap<Integer, OrgSaleSpecVo>();
    		OrgSaleSpecVo saleSpecVo = null;
    		for(OrgSaleSpec saleSpec:saleSpecList){
    			saleSpecVo = (OrgSaleSpecVo)saleSpec;
    			saleSpecMap.put(saleSpecVo.getSpecId(), saleSpecVo);
    		}
    		List<OrgSaleSpecValue> saleSpecValueList = orgSaleSpecValueService.queryBySaleSpecIds(saleSpecMap.keySet());
    		for(OrgSaleSpecValue saleSpecValue:saleSpecValueList){
    			saleSpecMap.get(saleSpecValue.getSpecId()).getValues().add(saleSpecValue);
    		}
    	}
    }
	
    /**
     * 添加销售规格值字符串
     * @param saleSpecList
     */
    @Override
	public void addSaleSpecValuesStr(List<OrgSaleSpec> saleSpecList){
		for(OrgSaleSpec saleSpec:saleSpecList){
			StringBuffer buffer = new StringBuffer();
			OrgSaleSpecVo saleSpecVo = (OrgSaleSpecVo)saleSpec;
			boolean flag = false;
			for(OrgSaleSpecValue saleSpecValue:saleSpecVo.getValues()){
				if(flag){
					buffer.append("、");
				}else{
					flag = true;
				}
				buffer.append(saleSpecValue.getSpecValue());
			}
			saleSpecVo.setValuesStr(buffer.toString());
		}
	}
	
	@Override
	public void add(OrgSaleSpec entity) {
		entity.setIsActive(OrgSaleSpecConstant.IS_ACTIVE);
		entity.setIsDelete(OrgSaleSpecConstant.IS_NOT_DELETE);
		super.add(entity);
	}

	@Override
	public void addSaleSpecAndValues(OrgSaleSpec orgSaleSpec,
			List<OrgSaleSpecValue> values) {
		add(orgSaleSpec);
		for(OrgSaleSpecValue value:values){
			value.setSpecId(orgSaleSpec.getSpecId());
			value.setIsActive(OrgSaleSpecConstant.IS_ACTIVE);
			value.setIsDelete(OrgSaleSpecConstant.IS_NOT_DELETE);
		}
		orgSaleSpecValueService.addInBatch(values);
	}

	@Override
	public void updateSaleSpecAndValues(OrgSaleSpec orgSaleSpec,
			List<OrgSaleSpecValue> values) {
		updateByIdSelective(orgSaleSpec);
		List<Short> specValueIds = new ArrayList<Short>();
		for(OrgSaleSpecValue value:values){
			value.setSpecId(orgSaleSpec.getSpecId());
			if(OrgSaleSpecConstant.IS_DELETE.equals(value.getIsDelete())){
				orgSaleSpecValueService.deleteById(value.getSpecValueId());
				specValueIds.add(value.getSpecValueId().shortValue());
			}else{
				orgSaleSpecValueService.saveOrUpdate(value);
			}			
		}
		//已关联的spu下架，删除已关联sku
		if(specValueIds.size() > 0){
			OrgProductItemQuery productItemQuery = new OrgProductItemQuery();
			productItemQuery.setSpecValueIds(specValueIds);
			productItemQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
			List<OrgProductItem> productItemList = productItemService.queryList(productItemQuery);
			if(null != productItemList && productItemList.size() > 0){
				List<OrgProduct> productListForUpdate = new ArrayList<OrgProduct>();
				List<OrgProductItem> productItemListForUpdate = new ArrayList<OrgProductItem>();
				OrgProduct product = null;
				OrgProductItem productItem = null;
				for(OrgProductItem item:productItemList){
					product = productService.queryById(item.getParentGoodsId());
					if(product.getIsOnSale() == OrgProductConstant.IS_ON_SALE_ON){
						product = new OrgProduct();
						product.setGoodsId(item.getParentGoodsId());
						product.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
						product.setOffsaletime(new Date());
						product.setOffSaleType(OrgProductConstant.OFF_SALE_TYPE_ILLEGAL);
					}
					productListForUpdate.add(product);
					
					productItem = new OrgProductItem();
					productItem.setGoodsId(item.getGoodsId());
					productItem.setIsDelete(OrgProductConstant.IS_DELETE);
					productItem.setHistorytime(new Date());
					productItemListForUpdate.add(productItem);
				}
				productService.updateInBatch(productListForUpdate);
				productItemService.updateInBatch(productItemListForUpdate);
			}
		}
		
		
	}

	@Override
	public void deleteSaleSpecAndValues(Integer id) {
		deleteById(id);
		OrgSaleSpecValue query = new OrgSaleSpecValue();
		query.setSpecId(id);
		orgSaleSpecValueService.delete(query);		
	}

	@Override
	public List<OrgSaleSpec> querySaleSpecAndValuesByProductTypeId(Integer typeId) {
		List<OrgSaleSpec> saleSpecList = orgSaleSpecDao.queryByProductTypeId(typeId);
		this.addSaleSpecValues(saleSpecList);
		return saleSpecList;
	}

}