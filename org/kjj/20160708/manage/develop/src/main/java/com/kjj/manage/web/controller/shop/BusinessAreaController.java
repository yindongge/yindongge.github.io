package com.kjj.manage.web.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgBusinessArea;
import com.kjj.commserver.entity.shop.aide.OrgBusinessAreaAll;
import com.kjj.commserver.entity.shop.aide.OrgBusinessAreaQuery;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgBusinessAreaService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/businessArea")
public class BusinessAreaController {
	
	@Resource
	private OrgAreaService orgAreaService;
	@Resource
	OrgBusinessAreaService orgBusinessAreaService;
	
	@ResponseBody
	@RequestMapping(value = "/getListBusinessArea", method = { RequestMethod.POST })
	public Map<String,Object> getBusinessArea(OrgBusinessAreaQuery query) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<OrgBusinessArea> listBusinessArea =  orgBusinessAreaService.queryList(query);
		result.put("list", listBusinessArea);
		result.put("code", HttpStatusCode.CODE_SUCCESS);	
		return result;	
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model, String pageNow,OrgBusinessAreaQuery query,PageReq pageReq){
			
		//省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		if(StringUtils.isNotEmpty(query.getProvinceCode()) && !"-1".equals(query.getProvinceCode())){
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(query.getProvinceCode());
			model.addAttribute("listCity",listCity);
			query.setAreaCodeLike(query.getProvinceCode());
		}
		
		//市
		if(StringUtils.isNotEmpty(query.getCityCode()) && !"-1".equals(query.getCityCode())){
			List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(query.getCityCode());
			model.addAttribute("listCounty",listCounty);
			query.setAreaCodeLike(query.getCityCode());
		}
		
		//县
		if(StringUtils.isNotEmpty(query.getCountyCode()) && !"-1".equals(query.getCountyCode())){
			query.setAreaCodeLike(query.getCountyCode());
		}
		pageReq.setPageSize(10);
		pageReq.setSort(new Sort(Direction.DESC,"t.id"));
		Page<OrgBusinessArea> page = orgBusinessAreaService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);

		return "businessArea/list";
	}
	
	@RequestMapping(value = "/addInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(Model model) {
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		return "businessArea/add";
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public String add(OrgBusinessAreaAll businessAreaAll){
	    
		if(!"-1".equals(businessAreaAll.getCountyCode())){
			//选择到县
			businessAreaAll.setAreaCode(businessAreaAll.getCountyCode());
		
		}else if(!"-1".equals(businessAreaAll.getCityCode())){
			//选择到市
			businessAreaAll.setAreaCode(businessAreaAll.getCityCode());
		}else{
			//选择到省
			businessAreaAll.setAreaCode(businessAreaAll.getProvinceCode());
		}
		
		orgBusinessAreaService.add(businessAreaAll);
		
		return "redirect:/businessArea/list";
	}
	
	@RequestMapping(value = "/editInit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editInit(@PathVariable Integer id, Model model) {
		
		OrgBusinessArea businessArea = orgBusinessAreaService.queryById(id);
		model.addAttribute("businessArea", businessArea);
		
		OrgArea area = orgAreaService.queryById(businessArea.getAreaCode());
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		if(area.getLevel() == 1){
			//省
			model.addAttribute("provinceCode",area.getCode());
			
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(area.getCode());
			model.addAttribute("listCity",listCity);
		}else if(area.getLevel() == 2){
			//市
			OrgArea province = orgAreaService.queryById(area.getParentCode());
			model.addAttribute("provinceCode",province.getCode());
			model.addAttribute("cityCode",area.getCode());
			
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
			model.addAttribute("listCity",listCity);
			
			List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(area.getCode());
			model.addAttribute("listCounty",listCounty);
		}else if(area.getLevel() == 3){
			//县
			OrgArea city = orgAreaService.queryById(area.getParentCode());
			OrgArea province = orgAreaService.queryById(city.getParentCode());
			model.addAttribute("provinceCode",province.getCode());
			model.addAttribute("cityCode",city.getCode());
			model.addAttribute("countyCode",area.getCode());
			
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
			model.addAttribute("listCity",listCity);
			
			List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(city.getCode());
			model.addAttribute("listCounty",listCounty);
		}
		
		return "businessArea/edit";
	}
	
	@RequestMapping(value = "/edit", method = { RequestMethod.POST })
	public String edit(OrgBusinessAreaAll businessAreaAll){
		
		if(!"-1".equals(businessAreaAll.getCountyCode())){
			//选择到县
			businessAreaAll.setAreaCode(businessAreaAll.getCountyCode());
		
		}else if(!"-1".equals(businessAreaAll.getCityCode())){
			//选择到市
			businessAreaAll.setAreaCode(businessAreaAll.getCityCode());
		}else{
			//选择到省
			businessAreaAll.setAreaCode(businessAreaAll.getProvinceCode());
		}
		
		orgBusinessAreaService.update(businessAreaAll);
		
		return "redirect:/businessArea/list";
	}
}
