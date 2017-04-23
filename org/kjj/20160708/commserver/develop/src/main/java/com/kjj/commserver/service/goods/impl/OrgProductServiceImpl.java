package com.kjj.commserver.service.goods.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.dao.goods.OrgProductDao;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProduct;
import com.kjj.commserver.entity.goods.OrgProductImg;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductLinkProperty;
import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;
import com.kjj.commserver.entity.goods.OrgProductLinkSubclass;
import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.OrgProductPropertyValue;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.commserver.entity.goods.OrgSaleSpec;
import com.kjj.commserver.entity.goods.OrgSaleSpecValue;
import com.kjj.commserver.entity.goods.OrgTradeSnapshoot;
import com.kjj.commserver.entity.goods.OrgTradeSnapshootProperty;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductForm;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemForm;
import com.kjj.commserver.entity.goods.aide.OrgProductItemVo;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkSalespecQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyValueVo;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyVo;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeVo;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecValueVo;
import com.kjj.commserver.entity.goods.aide.OrgSaleSpecVo;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductImgService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.goods.OrgProductLinkPropertyService;
import com.kjj.commserver.service.goods.OrgProductLinkSalespecService;
import com.kjj.commserver.service.goods.OrgProductLinkSubclassService;
import com.kjj.commserver.service.goods.OrgProductPropertyService;
import com.kjj.commserver.service.goods.OrgProductService;
import com.kjj.commserver.service.goods.OrgProductTypeService;
import com.kjj.commserver.service.goods.OrgSaleSpecValueService;
import com.kjj.commserver.service.goods.OrgTradeSnapshootPropertyService;
import com.kjj.commserver.service.goods.OrgTradeSnapshootService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgProductServiceImpl extends BaseServiceImpl<OrgProduct, Integer> implements OrgProductService {
    @Resource
    private OrgProductDao orgProductDao;
    
    @Resource
    private OrgProductItemService productItemService;
    
    @Resource
    private OrgSaleSpecValueService saleSpecValueService;
    
    @Resource
    private OrgProductLinkSalespecService productLinkSalespecService;
    
    @Resource
    private OrgProductImgService productImgService;
    
    @Resource
    private OrgProductLinkPropertyService productLinkPropertyService;
    
    @Resource
    private OrgClassService classService;
    
    @Resource
    private OrgProductPropertyService productPropertyService;
    
    @Resource
    private OrgProductTypeService productTypeService;
    
    @Resource
    private OrgProductLinkSubclassService productLinkSubclassService;
    
    @Resource
    private OrgTradeSnapshootService tradeSnapshootService;
    
    @Resource
    private OrgTradeSnapshootPropertyService tradeSnapshootPropertyService;

    @Override
    protected BaseDao<OrgProduct, Integer> getBaseDao() {
        return orgProductDao;
    }

	@Override
	public void addProductForm(OrgProduct product) {
		OrgProductForm productForm = (OrgProductForm)product;
		//添加spu
		product.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		product.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
		product.setOffSaleType(OrgProductConstant.OFF_SALE_TYPE_ADD);
		product.setIsShipping(OrgProductConstant.IS_SHIPPING_UNFINISHED);
		if(null != productForm.getGoodsImgs() && productForm.getGoodsImgs().size() > 0){
			product.setGoodsImg( productForm.getGoodsImgs().get(0));
		}else{
			product.setGoodsImg("");
		}
		this.add(product);
		//添加sku
		List<OrgProductLinkSalespec> productLinkSalespecList = new ArrayList<OrgProductLinkSalespec>();
		OrgProductLinkSalespec productLinkSalespec = null;
		List<OrgProductItem> productItemList = new ArrayList<OrgProductItem>();
		if(null != productForm.getGoodsSns()){
			for(int i = 0;i < productForm.getSkuIds().size(); i++){
				if(null != productForm.getGoodsSns().get(i) && !productForm.getGoodsSns().get(i).equals("")){
					OrgProductItem productItem = new OrgProductItem();
					productItem.setBrandId(product.getBrandId());
					productItem.setCatId(product.getCatId());
					productItem.setGoodsBrief(product.getGoodsBrief());
					productItem.setGoodsName(product.getGoodsName());
					productItem.setGoodsSn(productForm.getGoodsSns().get(i));
					productItem.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
					productItem.setParentGoodsId(product.getGoodsId());
					productItem.setMarketPrice(productForm.getMarketPrices().get(i));
					productItem.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
					productItem.setIsShow(OrgProductItemConstant.IS_SHOW_ON);
					productItem.setIsShowZeroInventory(OrgProductItemConstant.IS_SHOW_ZERO_INVENTORY_OFF);
					productItem.setIsDirect(OrgProductItemConstant.IS_DIRECT_YES);
					productItem.setGoodsDesc(product.getGoodsDesc());
					productItem.setMobileGoodsDesc(product.getMobileGoodsDesc());
					if(null != productForm.getGoodsImgs() && productForm.getGoodsImgs().size() > 0){
						productItem.setGoodsThumb( productForm.getGoodsImgs().get(0));
					}else{
						productItem.setGoodsThumb("");
					}
					productItemService.add(productItem);
					productItemList.add(productItem);
					String[] specValueIdArray = productForm.getSpecValueIds().get(i).split(OrgProductConstant.SEPARATOR);
					String[] specValuesArray = productForm.getSpecValues().get(i).split(OrgProductConstant.SEPARATOR);
					for(int j = 0; j < specValueIdArray.length; j++){
						OrgSaleSpecValue saleSpecValue = saleSpecValueService.queryById(Integer.valueOf(specValueIdArray[j]));
						productLinkSalespec = new OrgProductLinkSalespec();
						productLinkSalespec.setSpecTypeId(saleSpecValue.getSpecValueId().shortValue());
						productLinkSalespec.setGoodsId(productItem.getGoodsId());
						productLinkSalespec.setSpecId(saleSpecValue.getSpecId().shortValue());
						productLinkSalespec.setSpecValue(specValuesArray[j]);
						productLinkSalespecList.add(productLinkSalespec);
					}
				}
			}
			//添加商品关联销售规格
			productLinkSalespecService.addInBatch(productLinkSalespecList);
		}else{
			OrgProductItem productItem = new OrgProductItem();
			productItem.setBrandId(product.getBrandId());
			productItem.setCatId(product.getCatId());
			productItem.setGoodsBrief(product.getGoodsBrief());
			productItem.setGoodsName(product.getGoodsName());
			productItem.setGoodsSn(productForm.getGoodsSn());//取spu的 goodsSn作为sku的goodsSn
			productItem.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
			productItem.setParentGoodsId(product.getGoodsId());
			productItem.setMarketPrice(productForm.getMarketPrice());//取spu的MarketPrice作为sku的MarketPrice
			productItem.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
			productItem.setIsShow(OrgProductItemConstant.IS_SHOW_ON);
			productItem.setIsShowZeroInventory(OrgProductItemConstant.IS_SHOW_ZERO_INVENTORY_OFF);
			productItem.setIsDirect(OrgProductItemConstant.IS_DIRECT_YES);
			productItem.setGoodsDesc(product.getGoodsDesc());
			productItem.setMobileGoodsDesc(product.getMobileGoodsDesc());
			if(null != productForm.getGoodsImgs() && productForm.getGoodsImgs().size() > 0){
				productItem.setGoodsThumb( productForm.getGoodsImgs().get(0));
			}else{
				productItem.setGoodsThumb("");
			}
			productItemService.add(productItem);
			productItemList.add(productItem);
		}

		//添加图片
		if(null != productForm.getGoodsImgs()){
			List<OrgProductImg> productImgList = new ArrayList<OrgProductImg>();
			OrgProductImg productImg = null;
			//添加spu的图片
			for(String goodsImgUrl:productForm.getGoodsImgs()){
				productImg = new OrgProductImg();
				productImg.setGoodsId(product.getGoodsId());
				productImg.setImgUrl(goodsImgUrl);
				productImg.setProductClassId(product.getCatId().intValue());
				productImgList.add(productImg);
			}
			//添加sku图片
			for(OrgProductItem productItem:productItemList){
				for(String goodsImgUrl:productForm.getGoodsImgs()){
					productImg = new OrgProductImg();
					productImg.setItemGoodsId(productItem.getGoodsId());
					productImg.setImgUrl(goodsImgUrl);
					productImgList.add(productImg);
				}
			}
			
			productImgService.addInBatch(productImgList);
		}
		//添加spu关联属性
		List<OrgProductLinkProperty> productLinkPropertyList = new ArrayList<OrgProductLinkProperty>();
		OrgProductLinkProperty productLinkPropertyForAdd = null;
		for(OrgProductLinkProperty productLinkProperty:productForm.getProductLinkPropertyList()){
			productLinkPropertyForAdd = new OrgProductLinkProperty();
			productLinkPropertyForAdd.setGoodsId(product.getGoodsId());
			productLinkPropertyForAdd.setPropertyId(productLinkProperty.getPropertyId());
			productLinkPropertyForAdd.setPropertyInputType(productLinkProperty.getPropertyInputType());
			productLinkPropertyForAdd.setPropertyName(productLinkProperty.getPropertyName());
			productLinkPropertyForAdd.setPropertyValue(productLinkProperty.getPropertyValue());
			productLinkPropertyForAdd.setPropertyValueId(productLinkProperty.getPropertyValueId());
			productLinkPropertyList.add(productLinkPropertyForAdd);
		}
		//添加sku关联属性
		for(OrgProductItem productItem:productItemList){
			for(OrgProductLinkProperty productLinkProperty:productForm.getProductLinkPropertyList()){
				productLinkPropertyForAdd = new OrgProductLinkProperty();
				productLinkPropertyForAdd.setItemGoodsId(productItem.getGoodsId());
				productLinkPropertyForAdd.setPropertyId(productLinkProperty.getPropertyId());
				productLinkPropertyForAdd.setPropertyInputType(productLinkProperty.getPropertyInputType());
				productLinkPropertyForAdd.setPropertyName(productLinkProperty.getPropertyName());
				productLinkPropertyForAdd.setPropertyValue(productLinkProperty.getPropertyValue());
				productLinkPropertyForAdd.setPropertyValueId(productLinkProperty.getPropertyValueId());
				productLinkPropertyList.add(productLinkPropertyForAdd);
			}
		}
		productLinkPropertyService.addInBatch(productLinkPropertyList);
		
		//添加副分类
		if(null != productForm.getSubClassIds() && productForm.getSubClassIds().size() > 0){
			List<OrgProductLinkSubclass> productLinkSubclassForAdd = new ArrayList<OrgProductLinkSubclass>();
			OrgProductLinkSubclass productLinkSubclass = null;
			for(Integer subClassId:productForm.getSubClassIds()){
				productLinkSubclass = new OrgProductLinkSubclass();
				productLinkSubclass.setOrgProductId(product.getGoodsId());
				productLinkSubclass.setSubClassid(subClassId);
				productLinkSubclassForAdd.add(productLinkSubclass);
			}
			productLinkSubclassService.addInBatch(productLinkSubclassForAdd);
		}
	}

	@Override
	public List<OrgProductItem> queryProductItemsByParentId(
			Integer parentGoodsId) {
		OrgProductItem productItemQuery = new OrgProductItem();
		productItemQuery.setParentGoodsId(parentGoodsId);
		productItemQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		List<OrgProductItem> productItemList = productItemService.queryList(productItemQuery);
		OrgProductItemVo productItemVo = null;
		for(OrgProductItem productItem:productItemList){
			productItemVo = (OrgProductItemVo)productItem;
			//sku关联的销售规格
			OrgProductLinkSalespec productLinkSalespecQuery = new OrgProductLinkSalespec();
			productLinkSalespecQuery.setGoodsId(productItem.getGoodsId());
			productItemVo.setOrgProductItemLinkSalespecList(productLinkSalespecService.queryList(productLinkSalespecQuery));
			//sku关联的商品属性
			OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
			productLinkPropertyQuery.setItemGoodsId(productItem.getGoodsId());
			productItemVo.setOrgProductItemLinkPropertyList(productLinkPropertyService.queryList(productLinkPropertyQuery));
		}
		//生成销售规格字符串
		addSaleSpecStr(productItemList);
		return productItemList;
	}
	
	private void addSaleSpecStr(List<OrgProductItem> productItemList){
		OrgProductItemVo productItemVo = null;
		for(OrgProductItem productItem:productItemList){
			productItemVo = (OrgProductItemVo)productItem;
			StringBuffer buffer = new StringBuffer();
			for(OrgProductLinkSalespec productLinkSalespec:productItemVo.getOrgProductItemLinkSalespecList()){
				buffer.append(productLinkSalespec.getSpecValue());
			}
			productItemVo.setSaleSpecStr(buffer.toString());
		}
	}

	@Override
	public OrgProductItem queryProductItemById(Integer goodsId) {
		OrgProductItemVo productItemVo = (OrgProductItemVo)productItemService.queryVoById(goodsId);
		//sku关联的销售规格
		OrgProductLinkSalespec productLinkSalespecQuery = new OrgProductLinkSalespec();
		productLinkSalespecQuery.setGoodsId(productItemVo.getGoodsId());
		productItemVo.setOrgProductItemLinkSalespecList(productLinkSalespecService.queryList(productLinkSalespecQuery));
		//sku关联的商品属性
		OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
		productLinkPropertyQuery.setItemGoodsId(productItemVo.getGoodsId());
		productItemVo.setOrgProductItemLinkPropertyList(productLinkPropertyService.queryList(productLinkPropertyQuery));
		List<OrgProductItem> productItemList = new ArrayList<OrgProductItem>();
		addSaleSpecStr(productItemList);
		return productItemVo;
	}

	@Override
	public void updateSku(OrgProductItem productItem) {
		OrgProductItemForm productItemForm = (OrgProductItemForm)productItem;
		if(null != productItemForm.getGoodsImgs() && productItemForm.getGoodsImgs().size() > 0){
			String goodsImg = productItemForm.getGoodsImgs().get(0);
			goodsImg=goodsImg.replace(ImageConstant.IMAGE_BASE_URL, "");
			productItem.setGoodsThumb(goodsImg);
		}else{
			productItem.setGoodsThumb("");
		}
		OrgProductItem productItemOld = productItemService.queryById(productItem.getGoodsId());
		//如果是上架状态：则判断是重要属性否有修改，有修改的的话生成交易快照。
		if(this.queryById(productItemOld.getParentGoodsId()).getIsOnSale() == OrgProductConstant.IS_ON_SALE_ON){
			//标志位：是否已创建交易快照
			boolean isCreateTradeSnapshoot = false;
			//判断商品详情描述是否有修改，如果有修改则生成交易快照
			if(!productItemForm.getGoodsDesc().equals(productItemOld.getGoodsDesc()) || !productItemForm.getMobileGoodsDesc().equals(productItemOld.getMobileGoodsDesc())){
				if(!isCreateTradeSnapshoot){
					this.addTradeSnapshoot(productItem.getGoodsId());
					isCreateTradeSnapshoot = true;
				}
			}
			productItemService.updateByIdSelective(productItem);
			//判断图片是否有修改，如果有修改则先生成交易快照，再修改sku图片
			OrgProductImg productImgQuery = new OrgProductImg();
			productImgQuery.setItemGoodsId(productItem.getGoodsId());
			List<OrgProductImg> productImgOldList = productImgService.queryList(productImgQuery);
			List<String> imgUrlOldList = new ArrayList<String>();
			for(OrgProductImg item:productImgOldList){
				imgUrlOldList.add(item.getImgUrl());
			}
			if(!this.compareList(productItemForm.getGoodsImgs(), imgUrlOldList)){
				if(!isCreateTradeSnapshoot){
					this.addTradeSnapshoot(productItem.getGoodsId());
					isCreateTradeSnapshoot = true;
				}
				//删除sku图片
				productImgService.delete(productImgQuery);
				//重新添加sku图片
				if(productItemForm.getGoodsImgs() != null){
					List<OrgProductImg> productImgList = new ArrayList<OrgProductImg>();
					OrgProductImg productImg = new OrgProductImg();
					for(String goodsImgUrl:productItemForm.getGoodsImgs()){
						goodsImgUrl=goodsImgUrl.replace(ImageConstant.IMAGE_BASE_URL, "");
						productImg = new OrgProductImg();
						productImg.setItemGoodsId(productItem.getGoodsId());
						productImg.setImgUrl(goodsImgUrl);
						productImg.setProductClassId(productItemOld.getCatId().intValue());
						productImgList.add(productImg);
					}
					productImgService.addInBatch(productImgList);
				}
			}
			//判断属性是否修改，如果有修改则先生成交易快照，再修改关联属性
			List<String> propertyStrNewList = new ArrayList<String>();
			for(OrgProductLinkProperty item:productItemForm.getProductLinkPropertyList()){
				OrgProductProperty  productProperty  = productPropertyService.queryById(item.getPropertyId());
				if(productProperty.getPropertySelect() == OrgProductPropertyConstant.PROPERTY_SELECT_TRUE){
					propertyStrNewList.add((item.getPropertyName() != null?item.getPropertyName():"")  + (item.getPropertyValue() != null?item.getPropertyValue():""));
				}
			}
			List<String> propertyStrOldList = new ArrayList<String>();
			OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
			productLinkPropertyQuery.setItemGoodsId(productItem.getGoodsId());
			List<OrgProductLinkProperty> productLinkPropertyOldList = productLinkPropertyService.queryList(productLinkPropertyQuery);
			for(OrgProductLinkProperty item:productLinkPropertyOldList){
				OrgProductProperty  productProperty  = productPropertyService.queryById(item.getPropertyId());
				if(null == productProperty || productProperty.getPropertySelect() == OrgProductPropertyConstant.PROPERTY_SELECT_TRUE){
					propertyStrOldList.add((item.getPropertyName() != null?item.getPropertyName():"")  + (item.getPropertyValue() != null?item.getPropertyValue():""));
				}
				
			}
			if(!this.compareList(propertyStrNewList, propertyStrOldList)){
				if(!isCreateTradeSnapshoot){
					this.addTradeSnapshoot(productItem.getGoodsId());
					isCreateTradeSnapshoot = true;
				}
			}
			//删除已关联属性
			productLinkPropertyService.delete(productLinkPropertyQuery);
			//重新关联属性
			for(OrgProductLinkProperty productLinkProperty:productItemForm.getProductLinkPropertyList()){
				productLinkProperty.setItemGoodsId(productItem.getGoodsId());
			}
			productLinkPropertyService.addInBatch(productItemForm.getProductLinkPropertyList());
		}else{
			productItemService.updateByIdSelective(productItem);
			OrgProductImg productImgQuery = new OrgProductImg();
			productImgQuery.setItemGoodsId(productItem.getGoodsId());
			//删除sku图片
			productImgService.delete(productImgQuery);
			//重新添加sku图片
			if(productItemForm.getGoodsImgs() != null){
				List<OrgProductImg> productImgList = new ArrayList<OrgProductImg>();
				OrgProductImg productImg = new OrgProductImg();
				for(String goodsImgUrl:productItemForm.getGoodsImgs()){
					goodsImgUrl=goodsImgUrl.replace(ImageConstant.IMAGE_BASE_URL, "");
					productImg = new OrgProductImg();
					productImg.setItemGoodsId(productItem.getGoodsId());
					productImg.setImgUrl(goodsImgUrl);
					productImg.setProductClassId(productItemOld.getCatId().intValue());
					productImgList.add(productImg);
				}
				productImgService.addInBatch(productImgList);
			}
			//判断属性是否修改，如果有修改则先生成交易快照，再修改sku图片
			//删除已关联属性
			OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
			productLinkPropertyQuery.setItemGoodsId(productItem.getGoodsId());
			productLinkPropertyService.delete(productLinkPropertyQuery);
			//重新关联属性
			for(OrgProductLinkProperty productLinkProperty:productItemForm.getProductLinkPropertyList()){
				productLinkProperty.setItemGoodsId(productItem.getGoodsId());
			}
			productLinkPropertyService.addInBatch(productItemForm.getProductLinkPropertyList());
		}

	}
	
	private boolean compareList(List<String> listA, List<String> listB){
		if((null == listA || listA.size() == 0) && (null == listB || listB.size() == 0)){
			return true;
		}
		if(null != listA && null != listB){
			if(listA.size() == listB.size() && listA.containsAll(listB)){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<OrgProductProperty> queryProductPropertyBySkuId(Integer skuId) {
		//获取商品属性字典
		OrgProductItem productItem = productItemService.queryById(skuId);
		OrgClass productClass = classService.queryById(productItem.getCatId().intValue());
		List<OrgProductProperty> productPropertyList = productPropertyService.queryPropertyAndValuesByTypeId(productClass.getClassType());
		//获取sku已关联属性
		OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
		productLinkPropertyQuery.setItemGoodsId(skuId);
		Map<String,OrgProductLinkProperty> productLinkPropertyMap = productLinkPropertyService.queryMap(productLinkPropertyQuery, "propertyValueId");
		Set<String> propertyValueIdSet = productLinkPropertyMap.keySet();
		
		productLinkPropertyQuery.setPropertyInputType(OrgProductPropertyConstant.INPUT_TYPE_TEXT);
		Map<Integer,OrgProductLinkProperty> productLinkPropertyMap2 = productLinkPropertyService.queryMap(productLinkPropertyQuery, "propertyId");
		Set<Integer> propertyIdSet = productLinkPropertyMap2.keySet();
		//判断是否选中
		for(OrgProductProperty productProperty:productPropertyList){
			OrgProductPropertyVo productPropertyVo = (OrgProductPropertyVo)productProperty;
			if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_TEXT){
				if(propertyIdSet.contains(productPropertyVo.getPropertyId())){
					productPropertyVo.getPropertyValues().get(0).setPropertyValue(productLinkPropertyMap2.get(productProperty.getPropertyId()).getPropertyValue());
				}
			}else{
				for(OrgProductPropertyValue productPropertyValue:productPropertyVo.getPropertyValues()){
					if(propertyValueIdSet.contains(productPropertyValue.getPropertyValueId().toString())){
						OrgProductPropertyValueVo productPropertyValueVo = (OrgProductPropertyValueVo)productPropertyValue;
						productPropertyValueVo.setSelect(true);
					}
				}
			}
		}
		return productPropertyList;
	}

	@Override
	public OrgProductType queryProductTypeBySpuId(Integer spuId) {
		OrgProduct product = this.queryById(spuId);
		OrgClass productClass = classService.queryById(product.getCatId().intValue());
		if(null != productClass){
			OrgProductType productType = productTypeService.queryEntityAndLinkedById(productClass.getClassType());
			if(null != productType){
				OrgProductTypeVo productTypeVo = (OrgProductTypeVo)productType;
				//销售规格字典
				List<OrgSaleSpec> saleSpecList = productTypeVo.getSaleSpecList();
				//获取已关联销售规格
				OrgProductLinkSalespecQuery productLinkSalespecQuery = new OrgProductLinkSalespecQuery();
				productLinkSalespecQuery.setParentGoodsId(spuId);
				productLinkSalespecQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
				Map<Short, OrgProductLinkSalespec> productLinkSalespecMap = productLinkSalespecService.queryMap(productLinkSalespecQuery, "specTypeId");
				Set<Short> productLinkSalespecKeySet = productLinkSalespecMap.keySet();
				//判断销售规格选中状态并修改字典为自定义规格值
				for(OrgSaleSpec saleSpec:saleSpecList){
					OrgSaleSpecVo saleSpecVo = (OrgSaleSpecVo)saleSpec;
					List<OrgSaleSpecValue> saleSpecValueList = saleSpecVo.getValues();
					for(OrgSaleSpecValue saleSpecValue:saleSpecValueList){
						if(productLinkSalespecKeySet.contains(new Short(saleSpecValue.getSpecValueId().shortValue()))){
							saleSpecValue.setSpecValue(productLinkSalespecMap.get(new Short(saleSpecValue.getSpecValueId().shortValue())).getSpecValue());
							OrgSaleSpecValueVo saleSpecValueVo = (OrgSaleSpecValueVo)saleSpecValue;
							saleSpecValueVo.setIsSelect(true);
						}
					}
				}
				
				//商品属性字典
				List<OrgProductProperty> productPropertyList = productTypeVo.getProductProperty();
				//获取已关联销售规格
				OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
				productLinkPropertyQuery.setGoodsId(spuId);
				Map<String,OrgProductLinkProperty> productLinkPropertyMap = productLinkPropertyService.queryMap(productLinkPropertyQuery, "propertyValueId");
				Set<String> propertyValueIdSet = productLinkPropertyMap.keySet();
				
				productLinkPropertyQuery.setPropertyInputType(OrgProductPropertyConstant.INPUT_TYPE_TEXT);
				Map<Integer,OrgProductLinkProperty> productLinkPropertyMap2 = productLinkPropertyService.queryMap(productLinkPropertyQuery, "propertyId");
				Set<Integer> propertyIdSet = productLinkPropertyMap2.keySet();
				//判断是否选中
				for(OrgProductProperty productProperty:productPropertyList){
					OrgProductPropertyVo productPropertyVo = (OrgProductPropertyVo)productProperty;
					if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_TEXT){
						if(propertyIdSet.contains(productPropertyVo.getPropertyId())){
							productPropertyVo.getPropertyValues().get(0).setPropertyValue(productLinkPropertyMap2.get(productProperty.getPropertyId()).getPropertyValue());
						}
					}else{
						for(OrgProductPropertyValue productPropertyValue:productPropertyVo.getPropertyValues()){
							if(propertyValueIdSet.contains(productPropertyValue.getPropertyValueId().toString())){
								OrgProductPropertyValueVo productPropertyValueVo = (OrgProductPropertyValueVo)productPropertyValue;
								productPropertyValueVo.setSelect(true);
							}
						}
					}
				}
				return productType;
			}
		}
		return null;
	}

	@Override
	public List<OrgProductItem> queryProductItemBySpuId(Integer spuId) {
		OrgProductItem productItemQuery = new OrgProductItem();
		productItemQuery.setParentGoodsId(spuId);
		productItemQuery.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		Map<Integer, OrgProductItem> productItemMap = productItemService.queryMap(productItemQuery, "goodsId");
		//获取已关联销售规格
		OrgProductLinkSalespecQuery productLinkSalespecQuery = new OrgProductLinkSalespecQuery();
		productLinkSalespecQuery.setParentGoodsId(spuId);
		productLinkSalespecQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		List<OrgProductLinkSalespec> productLinkSalespecList = productLinkSalespecService.queryList(productLinkSalespecQuery);
		for(OrgProductLinkSalespec productLinkSalespec:productLinkSalespecList){
			OrgProductItem productItem = productItemMap.get(productLinkSalespec.getGoodsId());
				OrgProductItemVo productItemVo = (OrgProductItemVo)productItem;
				productItemVo.getOrgProductItemLinkSalespecList().add(productLinkSalespec);
		}
		return new ArrayList<OrgProductItem>(productItemMap.values());
	}

	@Override
	public void updateProductForm(OrgProduct product) {
		OrgProductForm productForm = (OrgProductForm)product;
		//修改spu
		OrgProduct productOld = this.queryById(product.getGoodsId());
		if(productOld.getIsOnSale() == OrgProductConstant.IS_ON_SALE_ON){
			product.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
			product.setOffsaletime(new Date());
			product.setOffSaleType(OrgProductConstant.OFF_SALE_TYPE_EDIT);
		}
		if(null != productForm.getGoodsImgs() && productForm.getGoodsImgs().size() > 0){
			product.setGoodsImg( productForm.getGoodsImgs().get(0));
		}else{
			product.setGoodsImg("");
		}
		this.updateByIdSelective(product);
		//修改or删除or添加sku
		OrgProductItem productItemQuery = new OrgProductItem();
		productItemQuery.setParentGoodsId(product.getGoodsId());
		productItemQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		Map<Integer, OrgProductItem> productItemMap = productItemService.queryMap(productItemQuery, "goodsId");
		List<OrgProductLinkSalespec> productLinkSalespecList = new ArrayList<OrgProductLinkSalespec>();
		OrgProductLinkSalespec productLinkSalespec = null;
		OrgProductItem productItem = null;
		List<OrgProductItem> productItemAddList = new ArrayList<OrgProductItem>(); 
		if(null != productForm.getGoodsSns()){
			for(int i = 0;i < productForm.getGoodsSns().size(); i++){
				if(null != productForm.getGoodsSns().get(i) && !productForm.getGoodsSns().get(i).equals("")){
					if(productItemMap.containsKey(productForm.getSkuIds().get(i))){
						//修改sku
						productItem = new OrgProductItem();
						productItem.setGoodsId(productForm.getSkuIds().get(i));
						productItem.setGoodsSn(productForm.getGoodsSns().get(i));
						productItem.setMarketPrice(productForm.getMarketPrices().get(i));
						productItem.setBrandId(productForm.getBrandId());
						productItemService.updateByIdSelective(productItem);	
						//从map中移除
						productItemMap.remove(productForm.getSkuIds().get(i));
					}else{
						//添加sku
						productItem = new OrgProductItem();
						productItem.setBrandId(product.getBrandId());
						productItem.setCatId(product.getCatId());
						productItem.setGoodsBrief(product.getGoodsBrief());
						productItem.setGoodsName(product.getGoodsName());
						productItem.setGoodsSn(productForm.getGoodsSns().get(i));
						productItem.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
						productItem.setParentGoodsId(product.getGoodsId());
						productItem.setMarketPrice(productForm.getMarketPrices().get(i));
						productItem.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
						productItem.setIsShow(OrgProductItemConstant.IS_SHOW_ON);
						productItem.setIsShowZeroInventory(OrgProductItemConstant.IS_SHOW_ZERO_INVENTORY_OFF);
						productItem.setIsDirect(OrgProductItemConstant.IS_DIRECT_YES);
						productItem.setGoodsDesc(productForm.getGoodsDesc());
						productItem.setMobileGoodsDesc(productForm.getMobileGoodsDesc());
						if(null != productForm.getGoodsImgs() && productForm.getGoodsImgs().size() > 0){
							productItem.setGoodsThumb( productForm.getGoodsImgs().get(0));
						}else{
							productItem.setGoodsThumb("");
						}
						productItemService.add(productItem);
						productItemAddList.add(productItem);
						}
					if(null != productForm.getSpecValueIds()){
						String[] specValueIdArray = productForm.getSpecValueIds().get(i).split(OrgProductConstant.SEPARATOR);
						String[] specValuesArray = productForm.getSpecValues().get(i).split(OrgProductConstant.SEPARATOR);
						for(int j = 0; j < specValueIdArray.length; j++){
							OrgSaleSpecValue saleSpecValue = saleSpecValueService.queryById(Integer.valueOf(specValueIdArray[j]));
							productLinkSalespec = new OrgProductLinkSalespec();
							productLinkSalespec.setSpecTypeId(saleSpecValue.getSpecValueId().shortValue());
							productLinkSalespec.setGoodsId(productItem.getGoodsId());
							productLinkSalespec.setSpecId(saleSpecValue.getSpecId().shortValue());
							productLinkSalespec.setSpecValue(specValuesArray[j]);
							productLinkSalespecList.add(productLinkSalespec);
						}	
					}
				}
			}
		}

		//逻辑删除sku
		OrgProductItem productItemForDelete = null;
		for(Map.Entry<Integer,OrgProductItem> entry:productItemMap.entrySet()){
			productItemForDelete = entry.getValue();
			productItemForDelete.setIsDelete(OrgProductConstant.IS_DELETE);
			productItemForDelete.setHistorytime(new Date());
			productItemForDelete.setGoodsThumb(null);
			productItemForDelete.setGoodsImg(null);
			productItemService.updateByIdSelective(productItemForDelete);
		}

		//删除商品已关联销售规格
		OrgProductLinkSalespecQuery productLinkSalespecQuery = new OrgProductLinkSalespecQuery();
		productLinkSalespecQuery.setParentGoodsId(productForm.getGoodsId());
		productLinkSalespecService.delete(productLinkSalespecQuery);
		//添加商品关联销售规格
		productLinkSalespecService.addInBatch(productLinkSalespecList);

		//如果sku数量为0则创建一个sku继承spu
		List<OrgProductItem> productItemList = productItemService.queryList(productItemQuery);
		if(productItemList.size() == 0){
			productItem = new OrgProductItem();
			productItem.setBrandId(product.getBrandId());
			productItem.setCatId(product.getCatId());
			productItem.setGoodsBrief(product.getGoodsBrief());
			productItem.setGoodsName(product.getGoodsName());
			productItem.setGoodsSn(productForm.getGoodsSn());//取spu的 goodsSn作为sku的goodsSn
			productItem.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
			productItem.setParentGoodsId(product.getGoodsId());
			productItem.setMarketPrice(productForm.getMarketPrice());//取spu的MarketPrice作为sku的MarketPrice
			productItem.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
			productItem.setIsShow(OrgProductItemConstant.IS_SHOW_ON);
			productItem.setIsShowZeroInventory(OrgProductItemConstant.IS_SHOW_ZERO_INVENTORY_OFF);
			productItem.setIsDirect(OrgProductItemConstant.IS_DIRECT_YES);
			productItem.setGoodsDesc(product.getGoodsDesc());
			productItem.setMobileGoodsDesc(product.getMobileGoodsDesc());
			if(null != productForm.getGoodsImgs() && productForm.getGoodsImgs().size() > 0){
				productItem.setGoodsThumb( productForm.getGoodsImgs().get(0));
			}else{
				productItem.setGoodsThumb("");
			}
			productItemService.add(productItem);
			productItemAddList.add(productItem);
		}else if(productItemList.size() == 1){
			//如果sku数量为1，并且无关联销售规格，则更新此sku继承spu
			productLinkSalespecQuery = new OrgProductLinkSalespecQuery();
			productLinkSalespecQuery.setGoodsId(productItemList.get(0).getGoodsId());
			if(productLinkSalespecService.queryCount(productLinkSalespecQuery) == 0){
				//修改sku继承spu
				productItem = new OrgProductItem();
				productItem.setGoodsId(productItemList.get(0).getGoodsId());
				productItem.setBrandId(product.getBrandId());
				productItem.setCatId(product.getCatId());
				productItem.setGoodsBrief(product.getGoodsBrief());
				productItem.setGoodsName(product.getGoodsName());
				productItem.setGoodsSn(productForm.getGoodsSn());//取spu的 goodsSn作为sku的goodsSn
				productItem.setMarketPrice(productForm.getMarketPrice());//取spu的MarketPrice作为sku的MarketPrice
				productItem.setGoodsDesc(product.getGoodsDesc());
				productItem.setMobileGoodsDesc(product.getMobileGoodsDesc());
				if(null != productForm.getGoodsImgs() && productForm.getGoodsImgs().size() > 0){
					productItem.setGoodsThumb( productForm.getGoodsImgs().get(0));
				}else{
					productItem.setGoodsThumb("");
				}
				productItemService.updateByIdSelective(productItem);
				//删除此sku已关联图片
				OrgProductImg productImgQuery = new OrgProductImg();
				productImgQuery.setItemGoodsId(productItemList.get(0).getGoodsId());
				productImgService.delete(productImgQuery);
				//删除此sku已关联属性
				OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
				productLinkPropertyQuery.setItemGoodsId(productItemList.get(0).getGoodsId());
				productLinkPropertyService.delete(productLinkPropertyQuery);
				
				productItemAddList.add(productItemList.get(0));
			}
		}
		
		//删除已关联图片
		OrgProductImg productImgQuery = new OrgProductImg();
		productImgQuery.setGoodsId(product.getGoodsId());
		productImgService.delete(productImgQuery);
		//添加图片
		if(null != productForm.getGoodsImgs()){
			List<OrgProductImg> productImgList = new ArrayList<OrgProductImg>();
			OrgProductImg productImg = null;
			//添加spu图片
			for(String goodsImgUrl:productForm.getGoodsImgs()){
				productImg = new OrgProductImg();
				productImg.setGoodsId(product.getGoodsId());
				productImg.setImgUrl(goodsImgUrl);
				productImg.setProductClassId(product.getCatId().intValue());
				productImgList.add(productImg);
			}
			//添加sku图片
			for(OrgProductItem productItemAdd:productItemAddList){
				for(String goodsImgUrl:productForm.getGoodsImgs()){
					productImg = new OrgProductImg();
					productImg.setItemGoodsId(productItemAdd.getGoodsId());
					productImg.setImgUrl(goodsImgUrl);
					productImgList.add(productImg);
				}
			}
			
			productImgService.addInBatch(productImgList);
		}
		//删除已关联属性
		OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
		productLinkPropertyQuery.setGoodsId(product.getGoodsId());
		productLinkPropertyService.delete(productLinkPropertyQuery);

		//添加spu关联属性
		List<OrgProductLinkProperty> productLinkPropertyList = new ArrayList<OrgProductLinkProperty>();
		OrgProductLinkProperty productLinkPropertyForAdd = null;
		for(OrgProductLinkProperty productLinkProperty:productForm.getProductLinkPropertyList()){
			productLinkPropertyForAdd = new OrgProductLinkProperty();
			productLinkPropertyForAdd.setGoodsId(product.getGoodsId());
			productLinkPropertyForAdd.setPropertyId(productLinkProperty.getPropertyId());
			productLinkPropertyForAdd.setPropertyInputType(productLinkProperty.getPropertyInputType());
			productLinkPropertyForAdd.setPropertyName(productLinkProperty.getPropertyName());
			productLinkPropertyForAdd.setPropertyValue(productLinkProperty.getPropertyValue());
			productLinkPropertyForAdd.setPropertyValueId(productLinkProperty.getPropertyValueId());
			productLinkPropertyList.add(productLinkPropertyForAdd);
		}
		//添加sku关联属性
		for(OrgProductItem productItemAdd:productItemAddList){
			for(OrgProductLinkProperty productLinkProperty:productForm.getProductLinkPropertyList()){
				productLinkPropertyForAdd = new OrgProductLinkProperty();
				productLinkPropertyForAdd.setItemGoodsId(productItemAdd.getGoodsId());
				productLinkPropertyForAdd.setPropertyId(productLinkProperty.getPropertyId());
				productLinkPropertyForAdd.setPropertyInputType(productLinkProperty.getPropertyInputType());
				productLinkPropertyForAdd.setPropertyName(productLinkProperty.getPropertyName());
				productLinkPropertyForAdd.setPropertyValue(productLinkProperty.getPropertyValue());
				productLinkPropertyForAdd.setPropertyValueId(productLinkProperty.getPropertyValueId());
				productLinkPropertyList.add(productLinkPropertyForAdd);
			}
		}
		productLinkPropertyService.addInBatch(productLinkPropertyList);
		
		//删除已关联副分类
		OrgProductLinkSubclass productLinkSubclassQuery = new OrgProductLinkSubclass();
		productLinkSubclassQuery.setOrgProductId(product.getGoodsId());
		productLinkSubclassService.delete(productLinkSubclassQuery);
		//添加关联副分类
		if(null != productForm.getSubClassIds() && productForm.getSubClassIds().size() > 0){
			List<OrgProductLinkSubclass> productLinkSubclassForAdd = new ArrayList<OrgProductLinkSubclass>();
			OrgProductLinkSubclass productLinkSubclass = null;
			for(Integer subClassId:productForm.getSubClassIds()){
				productLinkSubclass = new OrgProductLinkSubclass();
				productLinkSubclass.setOrgProductId(product.getGoodsId());
				productLinkSubclass.setSubClassid(subClassId);
				productLinkSubclassForAdd.add(productLinkSubclass);
			}
			productLinkSubclassService.addInBatch(productLinkSubclassForAdd);
		}
	}

	@Override
	public void updateOffSale(Integer spuId) {
		OrgProduct productQuery = new OrgProduct();
		productQuery.setGoodsId(spuId);
		productQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
		productQuery.setOffsaletime(new Date());
		productQuery.setOffSaleType(OrgProductConstant.OFF_SALE_TYPE_MANUAL);
		this.updateByIdSelective(productQuery);
	}

	@Override
	public void updateOnSale(Integer spuId) {
		OrgProduct productQuery = new OrgProduct();
		productQuery.setGoodsId(spuId);
		productQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		productQuery.setOnsaletime(new Date());
		this.updateByIdSelective(productQuery);
		//给sku创建交易快照
		OrgProductItem productItemQuery = new OrgProductItem();
		productItemQuery.setParentGoodsId(spuId);
		productItemQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		List<OrgProductItem> productItemList = productItemService.queryList(productItemQuery);
		for(OrgProductItem item:productItemList){
			this.addTradeSnapshoot(item.getGoodsId());
		}
		
	}

	@Override
	public void deleteSpuAndSku(Integer spuId) {
		OrgProduct productQuery = new OrgProduct();
		productQuery.setGoodsId(spuId);
		productQuery.setIsDelete(OrgProductConstant.IS_DELETE);
		productQuery.setHistorytime(new Date());
		this.updateByIdSelective(productQuery);
		OrgProductItem productItemQuery = new OrgProductItem();
		productItemQuery.setParentGoodsId(spuId);
		productItemQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		List<OrgProductItem> productItemList = productItemService.queryList(productItemQuery);
		for(OrgProductItem productItem:productItemList){
			productItem.setIsDelete(OrgProductConstant.IS_DELETE);
			productItem.setHistorytime(new Date());
			productItem.setGoodsThumb(null);
			productItem.setGoodsImg(null);
			productItem.setGoodsDesc(null);
			productItem.setMobileGoodsDesc(null);
		}
		productItemService.updateInBatch(productItemList);
	}

	@Override
	public void updateOffSaleInBatch(List<Integer> spuIds) {
		List<OrgProduct> productList = new ArrayList<OrgProduct>();
		OrgProduct productQuery = null;
		if(null != spuIds){
			for(Integer spuId:spuIds){
				productQuery = new OrgProduct();
				productQuery.setGoodsId(spuId);
				productQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
				productQuery.setOffsaletime(new Date());
				productQuery.setOffSaleType(OrgProductConstant.OFF_SALE_TYPE_MANUAL);
				productList.add(productQuery);
			}
		}
		this.updateInBatch(productList);
	}

	@Override
	public void updateOnSaleInBatch(List<Integer> spuIds) {
		List<OrgProduct> productList = new ArrayList<OrgProduct>();
		OrgProduct productQuery = null;
		if(null != spuIds){
			for(Integer spuId:spuIds){
				productQuery = new OrgProduct();
				productQuery.setGoodsId(spuId);
				productQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
				productQuery.setOnsaletime(new Date());
				productList.add(productQuery);
			}
		}
		this.updateInBatch(productList);
	}

	@Override
	public void deleteSpuAndSkuInBatch(List<Integer> spuIds) {
		List<OrgProduct> productListForUpdate = new ArrayList<OrgProduct>();
		List<OrgProductItem> productItemListForUpdate = new ArrayList<OrgProductItem>();
		OrgProduct productForUpdate = null;
		OrgProductItem productItemForUpdate = null;
		if(null != spuIds){
			for(Integer spuId:spuIds){
				productForUpdate = new OrgProduct();
				productForUpdate.setGoodsId(spuId);
				productForUpdate.setIsDelete(OrgProductConstant.IS_DELETE);
				productForUpdate.setHistorytime(new Date());
				productListForUpdate.add(productForUpdate);
				
				OrgProductItem productItemQuery = new OrgProductItem();
				productItemQuery.setParentGoodsId(spuId);
				productItemQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
				List<OrgProductItem> productItemList = productItemService.queryList(productItemQuery);
				for(OrgProductItem productItem:productItemList){
					productItemForUpdate = new OrgProductItem();
					productItemForUpdate.setGoodsId(productItem.getGoodsId());
					productItemForUpdate.setIsDelete(OrgProductConstant.IS_DELETE);
					productItemForUpdate.setHistorytime(new Date());
					productItemListForUpdate.add(productItemForUpdate);
				}
			}
		}
		this.updateInBatch(productListForUpdate);
		productItemService.updateInBatch(productItemListForUpdate);
	}

	@Override
	public void addTradeSnapshoot(Integer skuId) {
		//添加交易快照主表
		OrgProductItem productItem = productItemService.queryById(skuId);
		OrgTradeSnapshoot tradeSnapshoot = new OrgTradeSnapshoot();
		tradeSnapshoot.setCreateTime(new Date());
		tradeSnapshoot.setGoodsId(skuId);
		tradeSnapshoot.setGoodsName(productItem.getGoodsName());
		tradeSnapshoot.setGoodsSn(productItem.getGoodsSn());
		tradeSnapshoot.setImgUrl(productItem.getGoodsThumb());
		tradeSnapshoot.setMobileGoodsDesc(productItem.getMobileGoodsDesc());
		tradeSnapshoot.setPcGoodsDesc(productItem.getGoodsDesc());
		tradeSnapshootService.add(tradeSnapshoot);
		//添加交易快照属性
		OrgProductLinkProperty productLinkPropertyQuery = new OrgProductLinkProperty();
		productLinkPropertyQuery.setItemGoodsId(skuId);
		List<OrgProductLinkProperty> productLinkPropertyList = productLinkPropertyService.queryList(productLinkPropertyQuery);
		List<Integer> propertyIdList = new ArrayList<Integer>();//已添加商品属性id，去重使用
		List<OrgTradeSnapshootProperty> tradeSnapshootPropertyList = new ArrayList<OrgTradeSnapshootProperty>();
		OrgTradeSnapshootProperty tradeSnapshootProperty = null;
		for(OrgProductLinkProperty item:productLinkPropertyList){
			if(!propertyIdList.contains(item.getPropertyId())){
				tradeSnapshootProperty = new OrgTradeSnapshootProperty();
				tradeSnapshootProperty.setTradeSnapshootId(tradeSnapshoot.getTradeSnapshootId());
				tradeSnapshootProperty.setPropertyName(item.getPropertyName());
				if(item.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_CHECKBOX){
					boolean flag = false;
					StringBuffer buffer = new StringBuffer();
					for(OrgProductLinkProperty item2:productLinkPropertyList){
						if(item2.getPropertyId().equals(item.getPropertyId())){
							if(flag){
								buffer.append("、");
							}else{
								flag = true;
							}
							buffer.append(item2.getPropertyValue());
						}
					}
					tradeSnapshootProperty.setPropertyValue(buffer.toString());
				}else{
					tradeSnapshootProperty.setPropertyValue(item.getPropertyValue());
				}
				tradeSnapshootPropertyList.add(tradeSnapshootProperty);
				propertyIdList.add(item.getPropertyId());
			}
		}
		tradeSnapshootPropertyService.addInBatch(tradeSnapshootPropertyList);
		//更新sku表最近一次交易快照id
		productItem = new OrgProductItem();
		productItem.setGoodsId(skuId);
		productItem.setLastTradeSnapshootId(tradeSnapshoot.getTradeSnapshootId());
		productItemService.updateByIdSelective(productItem);
		
	}
		

}