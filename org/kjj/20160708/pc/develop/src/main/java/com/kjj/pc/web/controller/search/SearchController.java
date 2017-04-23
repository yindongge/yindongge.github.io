package com.kjj.pc.web.controller.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgCouponService;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.goods.OrgProductLinkPropertyService;
import com.kjj.commserver.service.goods.OrgProductPropertyValueService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;


@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Resource
	OrgProductItemService orgProductItemService;
	
	@Resource
	OrgCouponService orgCouponService;
	
	@Resource
	OrgClassService orgClassService;
	
	@Resource
	OrgShopPageService orgShopPageService;
	
	@Resource
	OrgBrandService orgBrandService;
	
	@Resource
	OrgProductPropertyValueService orgProductPropertyValueService;
	
	@Resource
	OrgProductLinkPropertyService orgProductLinkPropertyService;
	
	
	@RequestMapping(value="/result", method = {RequestMethod.GET,RequestMethod.POST })
	public String result(Model model,HttpSession session,HttpServletRequest request,OrgProductItemQuery query,PageReq pagereq){
		
		//查询条件
		if(StringUtils.isNotEmpty(query.getKeyword())){
			query.setGoodsNameLike(query.getKeyword().replace(" ", ""));			
		}
		
		//分类信息
	    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    model.addAttribute("listClass", listClass);
	    
	    pagereq.setPageSize(20);
	    OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
	    query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		Sort sort=orgProductItemService.getSortFormQuery(query);
		pagereq.setSort(sort);
		query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		query.setIsShow(OrgProductItemConstant.IS_SHOW_ON);
		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		query.setIsShowZeroInventoryFlg(true);
		String url=request.getQueryString();
		Collection<Integer> goodsIds=orgProductLinkPropertyService.queryGoodsIdsByUrlParam(url);
		Collection<Integer> brandIds=orgProductLinkPropertyService.queryBrandsByUrlParam(url);
		query.setGoodsIds(goodsIds);
		query.setBrandIds(brandIds);
		Page<OrgProductItemAll> page = orgProductItemService.queryPageList4View(orgUsersSession,query, pagereq);
		
		model.addAttribute("query",query);
		model.addAttribute("page",page);
		
		//一级 只查第一个，二级都查
		List<OrgBrand> orgBrandList=new ArrayList<OrgBrand>();
		List<Map<String,Object>>  propertyList=new ArrayList<Map<String,Object>> ();
		if(query.getCatId()!=null){
			OrgClass orgClass = orgClassService.queryVoById(query.getCatId().intValue());
			model.addAttribute("orgClass",orgClass);
			if(orgClass.getClassLevel()==OrgClassConstant.LEVEL_ONE){
				orgBrandList = orgBrandService.queryVoByClassIdAndLevel(query.getCatId().intValue());
			}else if(orgClass.getClassLevel()==OrgClassConstant.LEVEL_TWO){
				Integer classParentId = orgClass.getClassParent();
				OrgClass classParent = orgClassService.queryVoById(classParentId);
				model.addAttribute("classParent",classParent);
				orgBrandList = orgBrandService.queryVoByClassIdAndLevel(query.getCatId().intValue());
				propertyList = orgProductPropertyValueService.queryListByClassId(query.getCatId().intValue());			
			}
			model.addAttribute("orgBrandList",orgBrandList);
			model.addAttribute("propertyList",propertyList);
		}
		
		return "/search/result"; 
	}
}
