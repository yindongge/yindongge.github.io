package com.kjj.manage.web.controller.goods;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgBrandLinkType;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgClassLevel;
import com.kjj.commserver.entity.goods.aide.OrgBrandConstant;
import com.kjj.commserver.entity.goods.aide.OrgBrandQuery;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.service.goods.OrgBrandLinkTypeService;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassLevelService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Resource
	private OrgBrandService orgBrandService;
	
	@Resource
	private OrgClassLevelService classLevelService;
	
	@Resource
	private OrgClassService classService;
	
	@Resource
	private OrgBrandLinkTypeService brandLinkTypeService;
	
	@ResponseBody
	@RequestMapping(value = "/getgrandbyclass", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> getbrandByClass(Model model,Integer classId) {		
		Map<String,Object> result=new HashMap<String, Object>();
		//更改状态 上架下架
		List<OrgBrand> orgBrand =  orgBrandService.queryAllBrandByClass(classId);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		result.put("orgBrand", orgBrand);		
		return result;		
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model, OrgBrandQuery query, PageReq pageReq){
		query.setIsActive(OrgBrandConstant.IS_ACTIVE);
		pageReq.setSort(new Sort(Direction.ASC, "t.brand_order"));
		Page<OrgBrand> page = orgBrandService.queryPageList(query, pageReq);
		orgBrandService.addSkuNum(page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		List<OrgClassLevel> classLevelList = classLevelService.queryList(new OrgClassLevel());
		model.addAttribute("classLevelList", classLevelList);
		if(null != query.getClassLevel()){
			List<OrgClass> classList = classService.queryListByLevel(query.getClassLevel());
			model.addAttribute("classList", classList);
		}
		return "brand/list";
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String add(Model model){		
		return "brand/add";
	}
	
	@RequestMapping(value = "/selectClass", method = { RequestMethod.GET,RequestMethod.POST })
	public String selectClass(Model model){
		List<OrgClass> classLevelOne = classService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("classLevelOne", classLevelOne);
		return "brand/selectClass";
	}
	
	@RequestMapping(value = "/selectClassForDeputy", method = { RequestMethod.GET,RequestMethod.POST })
	public String selectClassForDeputy(Model model){
		List<OrgClass> classLevelOne = classService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("classLevelOne", classLevelOne);
		return "brand/selectClassForDeputy";
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadPicture", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> uploadPicture(MultipartFile file){
		String path = ImageConstant.IMAGE_BASE_PATH + "/" + ImageConstant.BRAND;
		String fileName = System.currentTimeMillis() + "_brand.jpg";
		File targetFile = new File(path, fileName);
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
        Map<String, Object> result = new HashMap<String, Object>();
        //保存到数据库的图片路径
        String visitPrictureUrlForSave =ImageConstant.BRAND + fileName;
        //前台访问图片路径
        String visitPrictureUrl = ImageConstant.IMAGE_BASE_URL + ImageConstant.BRAND + fileName;
        result.put("visitPrictureUrlForSave", visitPrictureUrlForSave);
        result.put("visitPrictureUrl", visitPrictureUrl);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> save(OrgBrandQuery query){
		Map<String, Object> result = new HashMap<String, Object>();
		OrgBrand brandQuery = new OrgBrand();
		brandQuery.setProductBrandName(query.getProductBrandName());
		long count = orgBrandService.queryCount(brandQuery);
		if(count > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
			result.put("message", "已有此品牌，不能重复添加");
		}else{
			String classIdsStr = query.getClassIds();
			classIdsStr = classIdsStr.replaceFirst("p_", "");
			String[] classIdsArr = classIdsStr.split("p_");
			List<OrgBrandLinkType> brandLinkTypeList = new ArrayList<OrgBrandLinkType>();
			OrgBrandLinkType brandLinkType = null;
			for(String classId:classIdsArr){
				brandLinkType = new OrgBrandLinkType();
				brandLinkType.setTypeId(Integer.valueOf(classId));
				brandLinkTypeList.add(brandLinkType);
			}
			orgBrandService.add(query, brandLinkTypeList);
			result.put("code", HttpStatusCode.CODE_SUCCESS);
			result.put("message", "添加成功");
		}

		return result;
	}
	
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(Model model,@PathVariable Integer id){
		OrgBrand brand = orgBrandService.queryBrandAndLinkedClassById(id);
		model.addAttribute("brand", brand);
		return "brand/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> update(OrgBrandQuery query){
		String classIdsStr = query.getClassIds();
		classIdsStr = classIdsStr.replaceFirst("p_", "");
		String[] classIdsArr = classIdsStr.split("p_");
		List<OrgBrandLinkType> brandLinkTypeList = new ArrayList<OrgBrandLinkType>();
		OrgBrandLinkType brandLinkType = null;
		for(String classId:classIdsArr){
			brandLinkType = new OrgBrandLinkType();
			brandLinkType.setTypeId(Integer.valueOf(classId));
			brandLinkTypeList.add(brandLinkType);
		}
		orgBrandService.update(query, brandLinkTypeList);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> delete(@PathVariable Integer id){
		orgBrandService.deleteBrandAndLinkedClassById(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
}
