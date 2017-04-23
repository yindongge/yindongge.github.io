package com.kjj.manage.web.controller.goods;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.constant.UploadConstant;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProduct;
import com.kjj.commserver.entity.goods.OrgProductImg;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductLinkProperty;
import com.kjj.commserver.entity.goods.OrgProductLinkSubclass;
import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.OrgProductPropertyValue;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductForm;
import com.kjj.commserver.entity.goods.aide.OrgProductImgQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductItemForm;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductItemVo;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductTypeVo;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductImgService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.goods.OrgProductLinkPropertyService;
import com.kjj.commserver.service.goods.OrgProductLinkSubclassService;
import com.kjj.commserver.service.goods.OrgProductPropertyService;
import com.kjj.commserver.service.goods.OrgProductPropertyValueService;
import com.kjj.commserver.service.goods.OrgProductService;
import com.kjj.commserver.service.goods.OrgProductTypeService;
import com.kjj.commserver.service.goods.OrgSaleSpecService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.ManagePropertiesUtil;
import com.kjj.manage.util.PageReq;
import com.kjj.manage.util.PictureZoom;


@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource
	private OrgProductService productService;
	
	@Resource
	private OrgBrandService brandService;
	
	@Resource
	private OrgSaleSpecService saleSpecService;
	
	@Resource
	private OrgClassService classService;
	
	@Resource
	private OrgProductTypeService productTypeService;
	
	@Resource
	private OrgProductPropertyService productPropertyService;
	
	@Resource
	private OrgProductPropertyValueService productPropertyValueService;
	
	@Resource
	private OrgProductImgService productImgService;
	
	@Resource
	private OrgProductItemService productItemService;
	
	@Resource
	private OrgProductLinkPropertyService productLinkPropertyService;
	
	@Resource
	private OrgProductLinkSubclassService productLinkSubclassService;
	
	@RequestMapping(value = "/onSaleList", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, OrgProductQuery query, PageReq pageReq){
		query.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		query.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		pageReq.setPageSize(20);
		pageReq.setSort(new Sort(Direction.DESC,"t.goods_id"));
		Page<OrgProduct> page = productService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("brandList", brandService.queryList(new OrgBrand()));
		model.addAttribute("classLevel1List", classService.queryListByLevel(OrgClassConstant.LEVEL_ONE));
		if(null != query.getClassLevel1()){
			model.addAttribute("classLevel2List", classService.queryListByParentId(query.getClassLevel1().intValue()));
		}
		model.addAttribute("query", query);
		OrgProduct productQuery = new OrgProduct();
		productQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		productQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		long onSaleNum = productService.queryCount(productQuery);
		model.addAttribute("onSaleNum", onSaleNum);
		productQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
		long offSaleNum = productService.queryCount(productQuery);
		model.addAttribute("offSaleNum", offSaleNum);
		model.addAttribute("frontPath", ManagePropertiesUtil.getProperty("front.path"));
		return "product/onSaleList";
	}
	
	@RequestMapping(value = "/offSaleList", method = {RequestMethod.GET, RequestMethod.POST})
	public String offSaleList(Model model, OrgProductQuery query, PageReq pageReq){
		query.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
		query.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		pageReq.setPageSize(20);
		pageReq.setSort(new Sort(Direction.DESC,"t.goods_id"));
		Page<OrgProduct> page = productService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("brandList", brandService.queryList(new OrgBrand()));
		model.addAttribute("classLevel1List", classService.queryListByLevel(OrgClassConstant.LEVEL_ONE));
		if(null != query.getClassLevel1()){
			model.addAttribute("classLevel2List", classService.queryListByParentId(query.getClassLevel1().intValue()));
		}
		model.addAttribute("query", query);
		OrgProduct productQuery = new OrgProduct();
		productQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		productQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		long onSaleNum = productService.queryCount(productQuery);
		model.addAttribute("onSaleNum", onSaleNum);
		productQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_OFF);
		long offSaleNum = productService.queryCount(productQuery);
		model.addAttribute("offSaleNum", offSaleNum);
		return "product/offSaleList";
	}
	
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(Model model){
		return "product/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getBrandAndSpecAndPropertyByClassId/{classId}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> getBrandAndSpecByClassId(@PathVariable Integer classId){
		Map<String, Object> result = new HashMap<String, Object>();
		List<OrgBrand> brandList = brandService.queryAllBrandByClass(classId);
		result.put("brandList", brandList);
		//获取类型及关联的销售规格及商品属性
		OrgClass productClass = classService.queryById(classId);
		OrgProductType productType = productTypeService.queryEntityAndLinkedById(productClass.getClassType());
		result.put("productType", productType);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> save(OrgProductForm productForm, HttpServletRequest request){
		
		//动态取出商品属性
		OrgClass productClass = classService.queryById(productForm.getCatId().intValue());
		OrgProductTypeVo productTypeVo = (OrgProductTypeVo)productTypeService.queryEntityAndLinkedById(productClass.getClassType());
		List<OrgProductLinkProperty> productLinkPropertyList = productForm.getProductLinkPropertyList();
		OrgProductLinkProperty productLinkProperty = null;
		for(OrgProductProperty productProperty:productTypeVo.getProductProperty()){
			if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_CHECKBOX){
				String[] propertyValueArray = request.getParameterValues("prop_" + productProperty.getPropertyId());
				if(null != propertyValueArray){
					for(String propertyValueId:propertyValueArray){
						OrgProductPropertyValue OrgProductPropertyValue = productPropertyValueService.queryById(Integer.valueOf(propertyValueId));
						productLinkProperty = new OrgProductLinkProperty();
						productLinkProperty.setPropertyId(productProperty.getPropertyId());
						productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
						productLinkProperty.setPropertyName(productProperty.getPropertyName());
						productLinkProperty.setPropertyValue(OrgProductPropertyValue.getPropertyValue());
						productLinkProperty.setPropertyValueId(OrgProductPropertyValue.getPropertyValueId().toString());
						productLinkPropertyList.add(productLinkProperty);
					}
				}
			}else if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_RADIO || productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_SELECT){
				String propertyValueIdStr = request.getParameter("prop_" + productProperty.getPropertyId());
				if(null != propertyValueIdStr){
					OrgProductPropertyValue OrgProductPropertyValue = productPropertyValueService.queryById(Integer.valueOf(propertyValueIdStr));
					productLinkProperty = new OrgProductLinkProperty();
					productLinkProperty.setPropertyId(productProperty.getPropertyId());
					productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
					productLinkProperty.setPropertyName(productProperty.getPropertyName());
					productLinkProperty.setPropertyValue(OrgProductPropertyValue.getPropertyValue());
					productLinkProperty.setPropertyValueId(OrgProductPropertyValue.getPropertyValueId().toString());
					productLinkPropertyList.add(productLinkProperty);
				}
			}else if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_TEXT){
				String propertyValueStr = request.getParameter("prop_" + productProperty.getPropertyId());
				productLinkProperty = new OrgProductLinkProperty();
				productLinkProperty.setPropertyId(productProperty.getPropertyId());
				productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
				productLinkProperty.setPropertyName(productProperty.getPropertyName());
				productLinkProperty.setPropertyValue(propertyValueStr);
				productLinkPropertyList.add(productLinkProperty);
			}
		}
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		if(!StringUtils.isEmpty(productForm.getGoodsDesc())){
			productForm.setGoodsDesc(productForm.getGoodsDesc().replace(basePath, ""));
			productForm.setGoodsDesc(productForm.getGoodsDesc().replace("src=\"", "src=\""+basePath));
			productForm.setGoodsDesc(productForm.getGoodsDesc().replace(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL, ""));			
		}
		if(!StringUtils.isEmpty(productForm.getMobileGoodsDesc())){
			productForm.setMobileGoodsDesc(productForm.getMobileGoodsDesc().replace(basePath, ""));
			productForm.setMobileGoodsDesc(productForm.getMobileGoodsDesc().replace("src=\"", "src=\""+basePath));
			productForm.setMobileGoodsDesc(productForm.getMobileGoodsDesc().replace(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL, ""));
		}
		List<String> goodsImgs = productForm.getGoodsImgs();
		for (int i = 0; i < goodsImgs.size(); i++) {
			if(StringUtils.isNotEmpty(goodsImgs.get(i))){
				goodsImgs.set(i, goodsImgs.get(i).replace(ImageConstant.IMAGE_BASE_URL, ""));
			}
		}
		productForm.setGoodsImgs(goodsImgs);
		productService.addProductForm(productForm);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("spuId", productForm.getGoodsId());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadPicture", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> uploadPicture(MultipartFile file, Integer classId){
		String path = ImageConstant.IMAGE_BASE_PATH + "/" + ImageConstant.GOODS;
		String fileName = System.currentTimeMillis() + "_.jpg";
		File targetFile = new File(path, fileName);
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        try {
			file.transferTo(targetFile);
			PictureZoom.zoomImage(targetFile.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
        Map<String, Object> result = new HashMap<String, Object>();
        //保存到数据库的图片路径
        String visitPrictureUrlForSave = ImageConstant.GOODS + fileName;
        //前台访问图片路径
        String visitPrictureUrl = ImageConstant.IMAGE_BASE_URL + ImageConstant.GOODS + fileName;
        result.put("visitPrictureUrlForSave", visitPrictureUrlForSave);
        result.put("visitPrictureUrl", visitPrictureUrl);
		return result;
	}
	
	@RequestMapping(value = "/editSku/{skuId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editSku(Model model,@PathVariable Integer skuId){
		//获取sku及spu下的sku列表
		OrgProductItemVo productItem = productItemService.queryVoById(skuId);
		List<OrgProductItem> productItemList = productService.queryProductItemsByParentId(productItem.getParentGoodsId());
		model.addAttribute("productItemList", productItemList);
		model.addAttribute("productItem", productItem);
		OrgProductImg productImgQuery = new OrgProductImg();
		productImgQuery.setItemGoodsId(skuId);
		List<OrgProductImg>  productImgList = productImgService.queryList(productImgQuery);
		model.addAttribute("productImgList", productImgList);
		model.addAttribute("productPropertyList",productService.queryProductPropertyBySkuId(skuId));
		return "product/editSku";
	}
	
	@RequestMapping(value = "/skuInfo/{spuId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String skuInfo(@PathVariable Integer spuId){
		//如果sku数量为1，并且此sku没有关联销售规格，则不跳转；否则跳转到sku编辑页面
		List<OrgProductItem> productItemList = productService.queryProductItemsByParentId(spuId);
		if(productItemList.size() > 0){
			if(productItemList.size() == 1 && ((OrgProductItemVo)productItemList.get(0)).getOrgProductItemLinkSalespecList().size() == 0){
				return "redirect:/product/edit/" + spuId;
			}else{
				return "redirect:/product/editSku/" + productItemList.get(0).getGoodsId();
			}
		}
		return "redirect:/product/edit/" + spuId;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateSku", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> updateSku(OrgProductItemForm productItemForm, HttpServletRequest request){
		//动态取出商品属性
		OrgProductItem productItem = productItemService.queryVoById(productItemForm.getGoodsId());
		OrgClass productClass = classService.queryById(productItem.getCatId().intValue());
		List<OrgProductProperty> productPropertyList = productPropertyService.queryPropertyAndValuesByTypeId(productClass.getClassType());
		List<OrgProductLinkProperty> productLinkPropertyList = productItemForm.getProductLinkPropertyList();
		OrgProductLinkProperty productLinkProperty = null;
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		if(!StringUtils.isEmpty(productItemForm.getGoodsDesc())){
			productItemForm.setGoodsDesc(productItemForm.getGoodsDesc().replace(basePath, ""));
			productItemForm.setGoodsDesc(productItemForm.getGoodsDesc().replace("src=\"", "src=\""+basePath));
			productItemForm.setGoodsDesc(productItemForm.getGoodsDesc().replace(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL, ""));			
		}
		if(!StringUtils.isEmpty(productItemForm.getMobileGoodsDesc())){
			
			productItemForm.setMobileGoodsDesc(productItemForm.getMobileGoodsDesc().replace(basePath, ""));
			productItemForm.setMobileGoodsDesc(productItemForm.getMobileGoodsDesc().replace("src=\"", "src=\""+basePath));
			productItemForm.setMobileGoodsDesc(productItemForm.getMobileGoodsDesc().replace(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL, ""));
		}
		for(OrgProductProperty productProperty:productPropertyList){
			if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_CHECKBOX){
				String[] propertyValueArray = request.getParameterValues("prop_" + productProperty.getPropertyId());
				if(null != propertyValueArray){
					for(String propertyValueId:propertyValueArray){
						OrgProductPropertyValue OrgProductPropertyValue = productPropertyValueService.queryById(Integer.valueOf(propertyValueId));
						productLinkProperty = new OrgProductLinkProperty();
						productLinkProperty.setPropertyId(productProperty.getPropertyId());
						productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
						productLinkProperty.setPropertyName(productProperty.getPropertyName());
						productLinkProperty.setPropertyValue(OrgProductPropertyValue.getPropertyValue());
						productLinkProperty.setPropertyValueId(OrgProductPropertyValue.getPropertyValueId().toString());
						productLinkPropertyList.add(productLinkProperty);
					}
				}	
			}else if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_RADIO || productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_SELECT){
				String propertyValueIdStr = request.getParameter("prop_" + productProperty.getPropertyId());
				if(null != propertyValueIdStr){
					OrgProductPropertyValue OrgProductPropertyValue = productPropertyValueService.queryById(Integer.valueOf(propertyValueIdStr));
					productLinkProperty = new OrgProductLinkProperty();
					productLinkProperty.setPropertyId(productProperty.getPropertyId());
					productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
					productLinkProperty.setPropertyName(productProperty.getPropertyName());
					productLinkProperty.setPropertyValue(OrgProductPropertyValue.getPropertyValue());
					productLinkProperty.setPropertyValueId(OrgProductPropertyValue.getPropertyValueId().toString());
					productLinkPropertyList.add(productLinkProperty);
				}
			}else if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_TEXT){
				String propertyValueStr = request.getParameter("prop_" + productProperty.getPropertyId());
				productLinkProperty = new OrgProductLinkProperty();
				productLinkProperty.setPropertyId(productProperty.getPropertyId());
				productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
				productLinkProperty.setPropertyName(productProperty.getPropertyName());
				productLinkProperty.setPropertyValue(propertyValueStr);
				productLinkPropertyList.add(productLinkProperty);
			}
		}
		List<String> goodsImgs = productItemForm.getGoodsImgs();
		for (int i = 0; i < goodsImgs.size(); i++) {
			if(StringUtils.isNotEmpty(goodsImgs.get(i))){
				goodsImgs.set(i, goodsImgs.get(i).replace(ImageConstant.IMAGE_BASE_URL, ""));
			}
		}
		productItemForm.setGoodsImgs(goodsImgs);
		productService.updateSku(productItemForm);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}

	@RequestMapping(value = "/addRelative", method = {RequestMethod.GET, RequestMethod.POST})
	public String addRelative(Model model){
		
		return "product/relative";
	}
	
	@RequestMapping(value = "/otherInfo/{spuId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String otherInfo(Model model,@PathVariable Integer spuId){
		model.addAttribute("product", productService.queryVoById(spuId));
		return "product/otherInfo";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOtherInfo", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> saveOtherInfo(OrgProduct product){
		productService.updateByIdSelective(product);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value = "/edit/{spuId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(Model model, @PathVariable Integer spuId){
		OrgProduct product = productService.queryVoById(spuId);
		model.addAttribute("product", product);
		OrgProductImg productImg = new OrgProductImg();
		productImg.setGoodsId(spuId);
		List<OrgProductImg> productImgList = productImgService.queryList(productImg);
		model.addAttribute("productImgList", productImgList);
		List<OrgProductItem> productItemList = productService.queryProductItemBySpuId(spuId);
		model.addAttribute("productItemList", productItemList);
		//富文本内容设置为空，防止前台json解析出错
		for(OrgProductItem productItem:productItemList){
			productItem.setGoodsDesc("");
			productItem.setMobileGoodsDesc("");
		}
		Gson gson = new Gson();
		model.addAttribute("productItemListJson", gson.toJson(productItemList));
		List<OrgBrand> brandList = brandService.queryAllBrandByClass(product.getCatId().intValue());
		model.addAttribute("brandList", brandList);
		OrgClass productClass = classService.queryById(product.getCatId().intValue());
		model.addAttribute("productClass", productClass);
		OrgProductType productType = productService.queryProductTypeBySpuId(spuId);
		model.addAttribute("productType", productType);
		model.addAttribute("productTypeJson", gson.toJson(productType));
		OrgProductLinkSubclass productLinkSubclassQuery = new OrgProductLinkSubclass();
		productLinkSubclassQuery.setOrgProductId(spuId);
		model.addAttribute("productLinkSubclassList", productLinkSubclassService.queryList(productLinkSubclassQuery));
		return "product/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> update(OrgProductForm productForm, HttpServletRequest request){
		//动态取出商品属性
		OrgClass productClass = classService.queryById(productForm.getCatId().intValue());
		OrgProductTypeVo productTypeVo = (OrgProductTypeVo)productTypeService.queryEntityAndLinkedById(productClass.getClassType());
		if(null != productTypeVo){
			List<OrgProductLinkProperty> productLinkPropertyList = productForm.getProductLinkPropertyList();
			OrgProductLinkProperty productLinkProperty = null;
			for(OrgProductProperty productProperty:productTypeVo.getProductProperty()){
				if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_CHECKBOX){
					String[] propertyValueArray = request.getParameterValues("prop_" + productProperty.getPropertyId());
					if(null != propertyValueArray){
						for(String propertyValueId:propertyValueArray){
							OrgProductPropertyValue OrgProductPropertyValue = productPropertyValueService.queryById(Integer.valueOf(propertyValueId));
							productLinkProperty = new OrgProductLinkProperty();
							productLinkProperty.setPropertyId(productProperty.getPropertyId());
							productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
							productLinkProperty.setPropertyName(productProperty.getPropertyName());
							productLinkProperty.setPropertyValue(OrgProductPropertyValue.getPropertyValue());
							productLinkProperty.setPropertyValueId(OrgProductPropertyValue.getPropertyValueId().toString());
							productLinkPropertyList.add(productLinkProperty);
						}
					}	
				}else if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_RADIO || productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_SELECT){
					String propertyValueIdStr = request.getParameter("prop_" + productProperty.getPropertyId());
					if(null != propertyValueIdStr){
						OrgProductPropertyValue OrgProductPropertyValue = productPropertyValueService.queryById(Integer.valueOf(propertyValueIdStr));
						productLinkProperty = new OrgProductLinkProperty();
						productLinkProperty.setPropertyId(productProperty.getPropertyId());
						productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
						productLinkProperty.setPropertyName(productProperty.getPropertyName());
						productLinkProperty.setPropertyValue(OrgProductPropertyValue.getPropertyValue());
						productLinkProperty.setPropertyValueId(OrgProductPropertyValue.getPropertyValueId().toString());
						productLinkPropertyList.add(productLinkProperty);
					}
				}else if(productProperty.getPropertyInputType() == OrgProductPropertyConstant.INPUT_TYPE_TEXT){
					String propertyValueStr = request.getParameter("prop_" + productProperty.getPropertyId());
					productLinkProperty = new OrgProductLinkProperty();
					productLinkProperty.setPropertyId(productProperty.getPropertyId());
					productLinkProperty.setPropertyInputType(productProperty.getPropertyInputType());
					productLinkProperty.setPropertyName(productProperty.getPropertyName());
					productLinkProperty.setPropertyValue(propertyValueStr);
					productLinkPropertyList.add(productLinkProperty);
				}
			}
		}
		List<String> goodsImgs = productForm.getGoodsImgs();
		for (int i = 0; i < goodsImgs.size(); i++) {
			if(StringUtils.isNotEmpty(goodsImgs.get(i))){
				goodsImgs.set(i, goodsImgs.get(i).replace(ImageConstant.IMAGE_BASE_URL, ""));
			}
		}
		productForm.setGoodsImgs(goodsImgs);
		productService.updateProductForm(productForm);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("spuId", productForm.getGoodsId());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/isSpuGoodsSnExist", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> isSpuGoodsSnExist(String spuGoodsSn, Integer spuGoodsId){
		OrgProductQuery productQuery = new OrgProductQuery();
		productQuery.setGoodsSn(spuGoodsSn);
		productQuery.setGoodsIdForGoodsSnValidate(spuGoodsId);
		productQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		List<OrgProduct> productList = productService.queryList(productQuery);
		Map<String, Object> result = new HashMap<String, Object>();
		if(productList.size() > 0){
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			result.put("message", "商品货号:" + spuGoodsSn + "已存在");
		}else{
			OrgProductItemQuery productItemQuery = new OrgProductItemQuery();
			productItemQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
			productItemQuery.setGoodsSn(spuGoodsSn);
			productItemQuery.setParentGoodsIdForGoodsSnValidate(spuGoodsId);
			List<OrgProductItem> productItemList = productItemService.queryList(productItemQuery);
			if(productItemList.size() > 0){
				result.put("code", HttpStatusCode.CODE_SUCCESS);
				result.put("message", "商品货号:" + spuGoodsSn + "已存在");
			}else{
				result.put("code", HttpStatusCode.CODE_ERROR);
			}
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/isSkuGoodsSnExist", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> isSkuGoodsSnExist(String skuGoodsSns, Integer spuGoodsId){
		Map<String, Object> result = new HashMap<String, Object>();
		if(null != skuGoodsSns){
			String[] skuGoodsSnArr = skuGoodsSns.split("&");
			List<String> skuGoodsSnList = Arrays.asList(skuGoodsSnArr);
			Set<String> skuGoodsSnSet = new HashSet<String>(skuGoodsSnList);
			
			if(skuGoodsSnSet.size() < skuGoodsSnList.size()){
				result.put("code", HttpStatusCode.CODE_SUCCESS);
				result.put("message", "商品货号不能重复");
				return result;
			}
			skuGoodsSnSet.remove("");
			for(String skuGoodsSn:skuGoodsSnSet){
				OrgProductItemQuery productItemQuery = new OrgProductItemQuery();
				productItemQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
				productItemQuery.setGoodsSn(skuGoodsSn);
				productItemQuery.setParentGoodsIdForGoodsSnValidate(spuGoodsId);
				List<OrgProductItem> productItemList = productItemService.queryList(productItemQuery);
				if(productItemList.size() > 0){
					result.put("code", HttpStatusCode.CODE_SUCCESS);
					result.put("message", "商品货号:" + skuGoodsSn + "已存在");
					break;
				}
			}
		}else{
			result.put("code", HttpStatusCode.CODE_ERROR);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/offSale/{spuId}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> offSale(@PathVariable Integer spuId){
		productService.updateOffSale(spuId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/onSale/{spuId}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> onSale(@PathVariable Integer spuId){
		productService.updateOnSale(spuId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{spuId}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> delete(@PathVariable Integer spuId){
		productService.deleteSpuAndSku(spuId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/batchOffSale", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> batchOffSale(@RequestParam(value = "goodsIds") List<Integer> spuIds){
		productService.updateOffSaleInBatch(spuIds);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/batchOnSale", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> batchOnSale(@RequestParam(value = "goodsIds") List<Integer> spuIds){
		productService.updateOnSaleInBatch(spuIds);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/batchDelete", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> batchDelete(@RequestParam(value = "goodsIds") List<Integer> spuIds){
		productService.deleteSpuAndSkuInBatch(spuIds);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/albumList", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> albumList(OrgProductImgQuery query, PageReq pageReq){
		query.setIsAlbumQuery(true);
		pageReq.setPageSize(20);
		Map<String, Object> result = new HashMap<String, Object>();
		Page<OrgProductImg> page = productImgService.queryPageList(query, pageReq);
		result.put("page", page);
		return result;
	}
	
	
	@RequestMapping(value = "/getItemByParentId/{parentGoodsId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String getItemByParentId(Model model,@PathVariable Integer parentGoodsId){
		List<OrgProductItem> orgProductItemList = productService.queryProductItemsByParentId(parentGoodsId);
		return "redirect:"+ManagePropertiesUtil.getProperty("front.path")+"/item/"+orgProductItemList.get(0).getGoodsId();
	}
	
}
