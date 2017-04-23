package com.kjj.mobile.web.controller.search;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.kjj.mobile.constant.CookieConstant;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.CookieUTF8Util;
import com.kjj.mobile.util.PageReq;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Resource
	OrgProductItemService orgProductItemService;
	@Resource
	OrgBrandService orgBrandService;
	@Resource
	OrgClassService orgClassService;
	@Resource
	OrgCouponService orgCouponService;
	
	@RequestMapping(value="/search", method = {RequestMethod.GET,RequestMethod.POST })
	public String search(Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		Set<String> set = null;
		String searchKeys = CookieUTF8Util.getCookieValue(request, CookieConstant.COOKIE_SEARCH_KEY);
		 if(searchKeys != null){
			 if(StringUtils.isNotEmpty(searchKeys)){
				 String[] searchKeyArr = searchKeys.split(","); 
				 set = new HashSet<String>(Arrays.asList(searchKeyArr));   			
			 }
			 model.addAttribute("searchKey",set);
		 }
		return "/search/searchPage" ;
	}
	
	@RequestMapping(value="/result", method = {RequestMethod.GET,RequestMethod.POST })
	public String result(Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response,
			OrgProductItemQuery query, PageReq pagereq,Integer parentId) throws UnsupportedEncodingException{
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		queryInfo(query, pagereq, orgUsersSession);
		//将查询关键词保存到cookie
		setSearchKeys(request, response, query);
		Page<OrgProductItemAll> page = orgProductItemService.queryPageList4View(orgUsersSession,query, pagereq);
		model.addAttribute("query",query);
		model.addAttribute("page",page);
		int totalPages = page.getTotalPages();
		model.addAttribute("totalPages",totalPages);
		List<OrgClass> listClassLevelOne =  orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("listClassLevelOne",listClassLevelOne);
		model.addAttribute("parentId",parentId);
		return "/search/result"; 
	}

	private void priceQueryInfo(OrgProductItemQuery query,OrgUsersSession orgUsersSession) {
		//根据条件查询
    	String realPrice = query.getRealPrice();
    	if(StringUtils.isNotEmpty(realPrice)){
    		String[] realPriceArr = realPrice.split("-");
    		//在库存表里查询价格在此区间，且在此Id组的新Id组 
    		query.setMinPrice(realPriceArr[0]);
    		query.setMaxPrice(realPriceArr[1]);
    		query.setShopId(orgUsersSession.getOrgShop().getShopId());
    		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
    	}
	}
	
	@ResponseBody
	@RequestMapping(value="/resultAjax", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> resultAjax(HttpSession session,OrgProductItemQuery query ,PageReq pagereq) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> result = new HashMap<String,Object>();
		queryInfo(query, pagereq, orgUsersSession);
		Page<OrgProductItemAll> page = orgProductItemService.queryPageList4View(orgUsersSession,query, pagereq);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("query",query);
		result.put("page",page);
		return result;
	}

	private void queryInfo(OrgProductItemQuery query, PageReq pagereq, OrgUsersSession orgUsersSession) {
		if(StringUtils.isNotBlank(query.getKeyword())){
			query.setGoodsNameLike(query.getKeyword().trim());			
		}
		if(query.getCatIds()!=null && query.getCatIds().size()==0){
			query.setCatIds(null);
		}
		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		Sort sort = orgProductItemService.getSortFormQuery(query);
		pagereq.setSort(sort);
		query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		query.setIsShow(OrgProductItemConstant.IS_SHOW_ON);
		query.setIsShowZeroInventoryFlg(true);
		priceQueryInfo(query,orgUsersSession);
	}
	
	private void setSearchKeys(HttpServletRequest request, HttpServletResponse response,OrgProductItemQuery query) throws UnsupportedEncodingException{
		Set<String> set = null;
		StringBuffer sb = new StringBuffer();
		String newSearchKey = query.getGoodsNameLike();		
		if(StringUtils.isNotBlank(newSearchKey)){
			String searchKeys = CookieUTF8Util.getCookieValue(request, "searchKey");
			 if(searchKeys != null){
				 if(StringUtils.isNotEmpty(searchKeys)){
					 String[] searchKeyArr = searchKeys.split(","); 
					 set = new HashSet<String>(Arrays.asList(searchKeyArr));   			
				 }else{
					 set = new HashSet<String>();
				 }
				 set.add(newSearchKey);
				 for (String key : set) {
					 sb.append(key+",");					
				 }
				 newSearchKey = sb.toString().substring(0,sb.length()-1);
			 }
			 CookieUTF8Util.addCookieDefaultAge(response, "searchKey", newSearchKey);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getClassByParentId", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> getClassByParentId(Integer parentId) {
		Map<String, Object> result = new HashMap<String, Object>();
		//二级分类
		List<OrgClass> listClassLevelTwo = orgClassService.queryListByParentId(parentId);
		result.put("listClassLevelTwo", listClassLevelTwo);
		return result;
	}
}
