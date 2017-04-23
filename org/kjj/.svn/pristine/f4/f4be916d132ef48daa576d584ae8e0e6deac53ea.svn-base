package com.kjj.manage.web.controller.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgAdvertisement;
import com.kjj.commserver.entity.goods.OrgAdvertisementItem;
import com.kjj.commserver.entity.goods.OrgAdvertisementType;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgAdvertisementQuery;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.service.goods.OrgAdvertisementItemService;
import com.kjj.commserver.service.goods.OrgAdvertisementService;
import com.kjj.commserver.service.goods.OrgAdvertisementTypeService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/advertisement")
public class AdvertisementController {
	
	@Resource
	private OrgAdvertisementService advertisementService;
	
	@Resource
	private OrgProductItemService productItemService;
	
	@Resource
	private OrgClassService classService;
	
	@Resource
	private OrgAdvertisementTypeService advertisementTypeService;
	
	@Resource
	private OrgAdvertisementItemService advertisementItemService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, OrgAdvertisementQuery query, PageReq pageReq){
		pageReq.setPageSize(20);
		Page<OrgAdvertisement> page = advertisementService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		List<OrgClass> classLevle1List = classService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("classLevle1List", classLevle1List);
		if(null != query.getClassLevel1() && query.getClassLevel1() > 0){
			model.addAttribute("classLevle2List", classService.queryListByParentId(query.getClassLevel1()));
		}
		return "advertisement/list";
	}
	
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(Model model,OrgAdvertisementQuery advertisementQuery, OrgProductItemQuery query, PageReq pageReq){
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		Page<OrgProductItem> page = productItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		model.addAttribute("advertisementQuery", advertisementQuery);
		List<OrgClass> classLevle1List = classService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("classLevle1List", classLevle1List);
		List<OrgAdvertisementType> advertisementTypeList = advertisementTypeService.queryList(new OrgAdvertisementType());
		model.addAttribute("advertisementTypeList", advertisementTypeList);
		Integer classLevle1 = advertisementQuery.getClassLevel1();
		if(null != classLevle1 && classLevle1 > 0){
			model.addAttribute("classLevle2List", classService.queryListByParentId(classLevle1));
		}
		return "advertisement/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/validate", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> validate(OrgAdvertisementQuery advertisementQuery){
		Map<String, Object> result = new HashMap<String, Object>();
		Integer classLevel1 = advertisementQuery.getClassLevel1();
		Integer classLevel2 = advertisementQuery.getClassLevel2();
		if(classLevel2 < 0){
			advertisementQuery.setProductClassId(classLevel1);
		}else{
			advertisementQuery.setProductClassId(classLevel2);
		}
		long count = advertisementService.queryCount(advertisementQuery);
		if(count > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("message", "此分类及类型已添加！请重新选择分类或类型");
		}else{
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> save(OrgAdvertisementQuery advertisementQuery){
		Map<String, Object> result = new HashMap<String, Object>();
		Integer classLevel1 = advertisementQuery.getClassLevel1();
		Integer classLevel2 = advertisementQuery.getClassLevel2();
		if(classLevel2 < 0){
			advertisementQuery.setProductClassId(classLevel1);
			advertisementQuery.setProductClassLevel(Integer.valueOf(OrgClassConstant.LEVEL_ONE));
		}else{
			advertisementQuery.setProductClassId(classLevel2);
			advertisementQuery.setProductClassLevel(Integer.valueOf(OrgClassConstant.LEVEL_TWO));
		}
		long count = advertisementService.queryCount(advertisementQuery);
		if(count > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("message", "此分类及类型已添加！请重新选择分类或类型");
		}else{
			advertisementService.addAdvertisementAndItem(advertisementQuery);
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			result.put("id", advertisementQuery.getAdvertisementId());
		}
		return result;
	}
	
	@RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(Model model,Integer advertisementId,
			OrgProductItemQuery query, PageReq pageReq, Integer listPageNum, Integer classLevel1, Integer classLevel2){
		model.addAttribute("listPageNum", listPageNum);
		model.addAttribute("classLevel1", classLevel1);
		model.addAttribute("classLevel2", classLevel2);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		Page<OrgProductItem> page = productItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		List<OrgClass> classLevle1List = classService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("classLevle1List", classLevle1List);
		OrgAdvertisement advertisement = advertisementService.queryById(advertisementId);
		OrgAdvertisementQuery advertisementQuery = new OrgAdvertisementQuery();
		advertisementQuery.setAdvertisementId(advertisement.getAdvertisementId());
		advertisementQuery.setTypeId(advertisement.getTypeId());
		if(advertisement.getProductClassLevel() == OrgClassConstant.LEVEL_ONE){
			advertisementQuery.setClassLevel1(advertisement.getProductClassId());
		}else if(advertisement.getProductClassLevel() == OrgClassConstant.LEVEL_TWO){
			advertisementQuery.setClassLevel1(classService.queryById(advertisement.getProductClassId()).getClassParent());
			advertisementQuery.setClassLevel2(advertisement.getProductClassId());
			model.addAttribute("classLevle2List", classService.queryListByParentId(advertisementQuery.getClassLevel1()));
		}
		model.addAttribute("advertisementQuery", advertisementQuery);
		List<OrgAdvertisementType> advertisementTypeList = advertisementTypeService.queryList(new OrgAdvertisementType());
		model.addAttribute("advertisementTypeList", advertisementTypeList);
		OrgAdvertisementItem advertisementItemQuery = new OrgAdvertisementItem();
		advertisementItemQuery.setAdvertisementId(advertisementId);
		model.addAttribute("advertisementItemList", advertisementItemService.queryList(advertisementItemQuery));
		return "advertisement/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> update(Integer advertisementId, Integer productId){
		OrgAdvertisementItem advertisementItem = new OrgAdvertisementItem();
		advertisementItem.setAdvertisementId(advertisementId);
		advertisementItem.setProductId(productId);
		long count = advertisementItemService.queryCount(advertisementItem);
		if(count == 0){
			advertisementItemService.add(advertisementItem);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/cancel", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> cancel(Integer advertisementItemId){
		advertisementItemService.deleteById(advertisementItemId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> delete(@PathVariable Integer id){
		advertisementService.deleteAdvertisementAndItem(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}

}
