package com.kjj.manage.web.controller.discount;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjj.commserver.entity.discount.OrgCoupon;
import com.kjj.commserver.entity.discount.OrgDiscountProduct;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.OrgReachCondition;
import com.kjj.commserver.entity.discount.OrgReachCoupon;
import com.kjj.commserver.entity.discount.OrgReachGive;
import com.kjj.commserver.entity.discount.aide.OrgCouponConstant;
import com.kjj.commserver.entity.discount.aide.OrgCouponQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionQuery;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionVo;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountQuery;
import com.kjj.commserver.entity.discount.aide.OrgReachForm;
import com.kjj.commserver.entity.discount.aide.OrgReachQuery;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.discount.OrgCouponService;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.commserver.service.discount.OrgDiscountScopeService;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.commserver.service.discount.OrgReachConditionService;
import com.kjj.commserver.service.discount.OrgReachCouponService;
import com.kjj.commserver.service.discount.OrgReachDiscountService;
import com.kjj.commserver.service.discount.OrgReachGiveService;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

/**
 * @Title: ReachController.java
 * @Package com.kjj.manage.web.controller.reach
 * @Description: 满减满送
 * @author ZYLORG
 * @date 2016年6月7日 下午4:09:50
 * @copyright Beijing KJJ Electronic commerce Co., LTD
 * @version V1.0   
 */
@Controller
@RequestMapping("/reach")
public class ReachController {
	
	@Resource
	private OrgReachService orgReachService;
	
	@Resource
	private OrgDiscountShopService orgDiscountShopService;
	
	@Resource
	private OrgDiscountScopeService orgDiscountScopeService;
	
	@Resource
	private OrgDiscountAllowService orgDiscountAllowService;
	
	@Resource
	private OrgClassService orgClassService;
	
	@Resource
	private OrgDiscountProductService orgDiscountProductService;
	
	@Resource
	private OrgProductItemService orgProductItemService;
	
	@Resource
	private OrgBrandService orgBrandService;
	
	@Resource
	private OrgCouponService orgCouponService;
	
	@Resource
	private OrgReachConditionService orgReachConditionService;
	
	@Resource
	private OrgReachDiscountService orgReachDiscountService;
	
	@Resource
	private OrgReachCouponService orgReachCouponService;
	
	@Resource
	private OrgReachGiveService orgReachGiveService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(HttpSession session, HttpServletResponse response, Model model,OrgReachQuery query,PageReq  pageReq) {
		Sort sort = new Sort(Direction.DESC,"t.id");
		pageReq.setSort(sort);
		Page<OrgReach> page = orgReachService.queryPageList(query,pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "reach/list";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/updateStatus", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer updateStatus(Model model,OrgReachQuery query) {
		orgReachService.updateByIdSelective(query);
		return HttpStatusCode.CODE_SUCCESS;
	}
	 
	
	@RequestMapping(value = "/addInfo", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInfo(HttpSession session, HttpServletResponse response,Model model) {
		return "reach/addInfo";
	}
	
	@RequestMapping(value = "/editItem", method = { RequestMethod.GET,RequestMethod.POST })
	public String editItem(HttpSession session, HttpServletResponse response,Model model , Integer id) {
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		List<OrgClass> listClassSelected = new ArrayList<OrgClass>();
		model.addAttribute("listClass", listClass);
		if(id!=null){
			OrgReach orgReach = orgReachService.queryVoById(id);
			model.addAttribute("orgReach", orgReach);
			OrgDiscountProductQuery query=new OrgDiscountProductQuery();
			query.setTypeId(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT);
			query.setDiscountId(id);
			List<OrgDiscountProduct> orgDiscountProductList = orgDiscountProductService.queryList(query);
			OrgClass OrgClassSelected=null;
			for (OrgDiscountProduct orgDiscountProduct:orgDiscountProductList) {
				if(orgDiscountProduct.getClassId()!=null){
					OrgClassSelected = orgClassService.queryById(orgDiscountProduct.getClassId());
					listClassSelected.add(OrgClassSelected);
				}
			}
			model.addAttribute("listClassSelected", listClassSelected);
			model.addAttribute("id", id);
		}
		
		return "reach/editItem";
	}
	
	@RequestMapping(value = "/editSet", method = { RequestMethod.GET,RequestMethod.POST })
	public String editSet(HttpSession session, HttpServletResponse response,Model model,Integer id) {
		if(id!=null){
			OrgReach orgReach = orgReachService.queryVoById(id);
			OrgReachConditionQuery query=new OrgReachConditionQuery();
			query.setReachId(id);
			OrgReachConditionVo orgReachConditionVo=null;
			List<OrgReachCondition> orgReachConditionList = orgReachConditionService.queryList(query);
			OrgReachDiscountQuery orgReachDiscountQuery=new OrgReachDiscountQuery();
			for (OrgReachCondition orgReachCondition : orgReachConditionList) {
				orgReachConditionVo=(OrgReachConditionVo) orgReachCondition;
				orgReachDiscountQuery.setRcId(orgReachCondition.getId());
				orgReachConditionVo.setOrgReachDiscountList(orgReachDiscountService.queryList(orgReachDiscountQuery,new Sort(Direction.ASC,"t.type_id")));
			}
			model.addAttribute("orgReach", orgReach);
			model.addAttribute("orgReachConditionList", orgReachConditionList);
			
		}
		return "reach/editSet";
	}
	
	@RequestMapping(value = "/editInfo/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editInfo(HttpSession session, HttpServletResponse response,Model model,@PathVariable Integer id) {
		if(id !=null){
			OrgReach orgReach = orgReachService.queryVoById(id);
			//适用店铺范围 
			 Map<String, String> orgDiscountShopMap = orgDiscountShopService.queryInfo(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT, id);
			//适用终端范围
			String orgDiscountScopeStr=orgDiscountScopeService.queryInfo(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT, id);
			//允许同时优惠
			String orgDiscountAllowStr = orgDiscountAllowService.queryInfo(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT, id);
			model.addAttribute("orgReach",orgReach);
			model.addAttribute("orgDiscountShopMap",orgDiscountShopMap);
			model.addAttribute("orgDiscountScopeStr",orgDiscountScopeStr);
			model.addAttribute("orgDiscountAllowStr",orgDiscountAllowStr);
		}
		return "reach/editInfo";
	}
	
	
	@RequestMapping(value = "/addInfoData", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInfoData(HttpSession session, HttpServletResponse response,Model model,OrgReachForm orgReachForm,RedirectAttributes redirectAttributes) {
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		orgReachService.addInfo(orgReachForm,admin);
		redirectAttributes.addAttribute("id", orgReachForm.getId());
		return "redirect:/reach/editItem";
	}
	
	@RequestMapping(value = "/editInfoData", method = { RequestMethod.GET,RequestMethod.POST })
	public String editInfoData(HttpSession session, HttpServletResponse response,Model model,OrgReachForm orgReachForm,RedirectAttributes redirectAttributes) {
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		orgReachService.updateInfo(orgReachForm,admin);
		redirectAttributes.addAttribute("id", orgReachForm.getId());
		return "redirect:/reach/editItem";
	}
	
	@RequestMapping(value = "/editItemData", method = { RequestMethod.GET,RequestMethod.POST })
	public String editItemData(HttpSession session, HttpServletResponse response,Model model,OrgReachForm orgReachForm,RedirectAttributes redirectAttributes) {
		if(orgReachForm.getId()!=null){
			orgReachService.updateItem(orgReachForm.getTypeId(),orgReachForm.getId(),orgReachForm.getProductType(),orgReachForm.getListClass(),orgReachForm.getListGoods());			
		}
		redirectAttributes.addAttribute("id", orgReachForm.getId());
		return "redirect:/reach/editSet";
	}
	
	@ResponseBody
	@RequestMapping(value = "/editSetData", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer editSetData(HttpSession session, HttpServletResponse response,Model model,String jsonStr) {
		Integer newconditionId=orgReachConditionService.updateSet(jsonStr);
		return newconditionId;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteSetData", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer deleteSetData(HttpSession session, HttpServletResponse response,Model model,Integer conditionId) {
		orgReachConditionService.deleteSet(conditionId);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	
	@RequestMapping(value = "/discountList", method = { RequestMethod.GET,RequestMethod.POST })
	public String discountList(OrgProductItemQuery query,Model model,PageReq pageReq) {
		//获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);
		//获取品牌
		if(query.getSuperClassId()!= null){
			List<OrgBrand> listBrand =  orgBrandService.queryAllBrandByClass(query.getSuperClassId());
			model.addAttribute("listBrand",listBrand);
		}
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		Page<OrgProductItem> page = orgProductItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "reach/itemDiscountSelect";
	}
	
	//优惠卷选择框
	@RequestMapping(value = "/reachCouponList", method = { RequestMethod.GET,RequestMethod.POST })
	public String reachCouponList(Model model, PageReq pageReq,OrgCouponQuery query) {
		pageReq.setSort(new Sort(Direction.DESC,"t.coupon_id"));
		pageReq.setPageSize(5);
		query.setStatus(OrgCouponConstant.STATUS_VALID);
		Page<OrgCoupon> page = orgCouponService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "reach/reachCouponList";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/couponSelect", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> couponSelect(OrgReachCoupon orgReachCoupon) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgReachCouponService.add(orgReachCoupon);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/couponCancel", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> couponCancel(OrgReachCoupon orgReachCoupon) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgReachCouponService.delete(orgReachCoupon);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	//赠品选择框
	@RequestMapping(value = "/reachItemList", method = { RequestMethod.GET,RequestMethod.POST })
	public String reachItemList(OrgProductItemQuery query,Model model,PageReq pageReq) {
		//获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);
		//获取品牌
		if(query.getSuperClassId()!= null){
			List<OrgBrand> listBrand =  orgBrandService.queryAllBrandByClass(query.getSuperClassId());
			model.addAttribute("listBrand",listBrand);
		}
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		Page<OrgProductItem> page = orgProductItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "reach/reachItemList";
	}
		
	@ResponseBody
	@RequestMapping(value = "/itemSelect", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> itemSelect(OrgReachGive orgReachGive) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgReachGiveService.add(orgReachGive);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/itemCancel", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> itemCancel(OrgReachGive orgReachGive) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgReachGiveService.delete(orgReachGive);
		result.put("code",HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dbTime", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> dbTime(Model model) {
		Map<String, Object> result = new HashMap<String, Object>();
		Date dbTime = orgReachService.getDbTime();
		result.put("dbTime", dbTime.getTime());
		return result;
	}
	
	
	
}

