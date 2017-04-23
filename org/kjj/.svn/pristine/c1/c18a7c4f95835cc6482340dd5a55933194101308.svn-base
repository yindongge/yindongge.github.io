package com.kjj.manage.web.controller.discount;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.discount.OrgCoupon;
import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.OrgDiscountProduct;
import com.kjj.commserver.entity.discount.OrgDiscountScope;
import com.kjj.commserver.entity.discount.OrgDiscountShop;
import com.kjj.commserver.entity.discount.OrgDiscountTrigger;
import com.kjj.commserver.entity.discount.aide.OrgCouponForm;
import com.kjj.commserver.entity.discount.aide.OrgCouponQuery;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountScopeConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountScopeQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTriggerQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.discount.OrgCouponService;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.commserver.service.discount.OrgDiscountScopeService;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.commserver.service.discount.OrgDiscountTriggerService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/coupon")
public class CouponController {

	@Resource
	private OrgCouponService orgCouponService;
	
	@Resource
	private OrgClassService orgClassService;
	
	@Resource
	private OrgCouponRecordService orgCouponRecordService;
	
	@Resource
	private OrgDiscountTriggerService orgDiscountTriggerService;
	
	@Resource
	private OrgDiscountShopService orgDiscountShopService;
	
	@Resource
	private OrgDiscountProductService orgDiscountProductService;
	
	@Resource
	private OrgDiscountScopeService orgDiscountScopeService;
	
	//优惠卷
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model, PageReq pageReq,OrgCouponQuery query) {
		
		pageReq.setSort(new Sort(Direction.DESC,"t.coupon_id"));
		Page<OrgCoupon> page = orgCouponService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "coupon/list";
	}
	
	@RequestMapping(value = "/addInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(Model model) {
		//获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);
		
		return "coupon/add";
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String add(HttpSession session,OrgCouponForm orgCouponForm) {
		
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		orgCouponService.add(orgCouponForm,admin);
		
		return "redirect:/coupon/list";
	}
	
	@RequestMapping(value = "/editInit/{couponId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editInit(Model model,@PathVariable Integer couponId) {
		
		OrgCoupon orgCoupon = orgCouponService.queryById(couponId);
		model.addAttribute("coupon", orgCoupon);
		
		//获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);
		
		if(orgCoupon.getShopType() == OrgDiscountShopConstant.SHOP_TYPE_CITY){
			// TODO
		}else if(orgCoupon.getShopType() == OrgDiscountShopConstant.SHOP_TYPE_SHOP){
			OrgDiscountShop orgDiscountShop = new OrgDiscountShop();
			orgDiscountShop.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
			orgDiscountShop.setDiscountId(orgCoupon.getCouponId());
			List<OrgDiscountShop> listDiscountShop = orgDiscountShopService.queryList(orgDiscountShop);
			StringBuilder build = new StringBuilder();
			int size = listDiscountShop.size();
			for(int i=0;i<size;i++){
				build.append(listDiscountShop.get(i).getShopId());
				if(i != size-1){
					build.append(",");
				}
			}
			model.addAttribute("listShop", build);
		}
		
		if(orgCoupon.getProductType() == OrgDiscountProductConstant.PRODUCT_TYPE_CLASS){
			OrgDiscountProductQuery query = new OrgDiscountProductQuery();
			query.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
			query.setDiscountId(orgCoupon.getCouponId());
			Map<Integer,OrgDiscountProduct> mapDiscountProduct = orgDiscountProductService.queryMapKeyClassId(query);
			model.addAttribute("mapDiscountProduct", mapDiscountProduct);
		}
		
		OrgDiscountScopeQuery query = new OrgDiscountScopeQuery();
		query.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
		query.setDiscountId(orgCoupon.getCouponId());
		Map<Byte,OrgDiscountScope> mapDiscountScope = orgDiscountScopeService.queryMapKeyScope(query);
		model.addAttribute("mapDiscountScope", mapDiscountScope);
		boolean scopePc = mapDiscountScope.containsKey(OrgDiscountScopeConstant.SCOPE_PC);
		model.addAttribute("scopePc", scopePc);
		boolean scopeMobile = mapDiscountScope.containsKey(OrgDiscountScopeConstant.SCOPE_MOBILE);
		model.addAttribute("scopeMobile", scopeMobile);
		
		return "coupon/edit";
	}
	
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,RequestMethod.POST })
	public String edit(OrgCouponForm orgCouponForm) {
		
		orgCouponService.update(orgCouponForm);
		
		return "redirect:/coupon/list";
	}
	
	@RequestMapping(value = "/listRecord", method = { RequestMethod.GET,RequestMethod.POST })
	public String listRecord(Model model, PageReq pageReq,OrgCouponRecordQuery query) {
		
		pageReq.setSort(new Sort(Direction.DESC,"t.record_id"));
		pageReq.setPageSize(20);
		Page<OrgCouponRecord> page = orgCouponRecordService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "coupon/recordList";
	}
	
	@RequestMapping(value = "/triggerList", method = { RequestMethod.GET,RequestMethod.POST })
	public String  triggerList(Model model,PageReq pageReq,OrgDiscountTriggerQuery query) {
		
		//设置为优惠券类型
		query.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
		pageReq.setSort(new Sort(Direction.DESC,"t.id"));
		Page<OrgDiscountTrigger> page = orgDiscountTriggerService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "coupon/triggerList";
		
	}
	
	@RequestMapping(value = "/triggerInit/{couponId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String triggerInit(Model model,@PathVariable Integer couponId) {
		
		OrgCoupon orgCoupon = orgCouponService.queryById(couponId);
		model.addAttribute("orgCoupon", orgCoupon);
		
		return "coupon/triggerAdd";
	}
	
	@RequestMapping(value = "/triggerAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public String triggerAdd(Model model,HttpSession session,OrgDiscountTrigger orgDiscountTrigger) {
		
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		orgDiscountTriggerService.add(orgDiscountTrigger, admin);
		
		return "redirect:/coupon/triggerList";
	}
	
	@RequestMapping(value = "/pause/{couponId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String pause(@PathVariable Integer couponId) {
		
		orgCouponService.updatePause(couponId);
		
		return "redirect:/coupon/list";
	}
	
	@RequestMapping(value = "/giveInit/{couponId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String giveInit(Model model,@PathVariable Integer couponId) {
		
		OrgCoupon orgcoupon = orgCouponService.queryById(couponId);
		model.addAttribute("coupon", orgcoupon);
		
		return "coupon/give";
	}
	
	@RequestMapping(value = "/give", method = { RequestMethod.GET,RequestMethod.POST })
	public String give(Model model,HttpSession session,OrgCouponForm orgCouponForm) {
		
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		orgCouponRecordService.updateGive(orgCouponForm, admin);
		
		return "redirect:/coupon/listRecord";
	}
	
	@RequestMapping(value = "/triggerPause/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String triggerPause(@PathVariable Integer id) {
		
		orgDiscountTriggerService.updatePause(id);
		
		return "redirect:/coupon/triggerList";
	}
	
	@RequestMapping(value = "/triggerDelete/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String triggerDelete(@PathVariable Integer id) {
		
		orgDiscountTriggerService.deleteById(id);
		
		return "redirect:/coupon/triggerList";
	}
	
	@RequestMapping(value = "/triggerEditInit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String triggerEditInit(Model model,@PathVariable Integer id) {
		OrgDiscountTrigger orgDiscountTrigger = orgDiscountTriggerService.queryById(id);
		model.addAttribute("orgDiscountTrigger", orgDiscountTrigger);
		
		OrgCoupon orgCoupon = orgCouponService.queryById(orgDiscountTrigger.getDiscountId());
		model.addAttribute("coupon", orgCoupon);
		
		return "coupon/triggerEdit";
	}
	
	@RequestMapping(value = "/triggerEdit", method = { RequestMethod.GET,RequestMethod.POST })
	public String triggerEdit(Model model,OrgDiscountTrigger orgDiscountTrigger) {
		
		orgDiscountTriggerService.updateByIdSelective(orgDiscountTrigger);
		
		return "redirect:/coupon/triggerList";
	}
}
