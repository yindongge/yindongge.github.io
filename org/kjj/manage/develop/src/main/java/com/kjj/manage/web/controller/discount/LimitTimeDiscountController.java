package com.kjj.manage.web.controller.discount;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.discount.OrgDiscountAllow;
import com.kjj.commserver.entity.discount.OrgDiscountScope;
import com.kjj.commserver.entity.discount.OrgDiscountShop;
import com.kjj.commserver.entity.discount.OrgLimitTimeDiscount;
import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.commserver.entity.discount.aide.OrgDiscountAllowQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountScopeConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountScopeQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeDiscountForm;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeDiscountQuery;
import com.kjj.commserver.entity.goods.OrgBrand;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.commserver.service.discount.OrgDiscountScopeService;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.commserver.service.discount.OrgLimitTimeDiscountService;
import com.kjj.commserver.service.discount.OrgLimitTimeGoodsService;
import com.kjj.commserver.service.goods.OrgBrandService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/limitTimeDiscount")
public class LimitTimeDiscountController {
	

	@Resource
	private OrgLimitTimeDiscountService orgLimitTimeDiscountService;
	
	@Resource
	private OrgLimitTimeGoodsService orgLimitTimeGoodsService;
	
	@Resource
	private OrgDiscountShopService orgDiscountShopService;
	
	@Resource
	private OrgDiscountAllowService orgDiscountAllowService;
	
	@Resource
	private OrgDiscountScopeService orgDiscountScopeService;
	
	@Resource
	private OrgClassService orgClassService;
	
	@Resource
	private OrgProductItemService orgProductItemService;
	
	@Resource
	private OrgBrandService orgBrandService;

	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model, PageReq pageReq,OrgLimitTimeDiscountQuery query) {
		
		pageReq.setSort(new Sort(Direction.DESC,"t.id"));
		Page<OrgLimitTimeDiscount> page = orgLimitTimeDiscountService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "limitTimeDiscount/list";
	}
	
	@RequestMapping(value = "/addInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(Model model) {
		return "limitTimeDiscount/add";
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String add(HttpSession session,OrgLimitTimeDiscountForm orgLimitTimeDiscountForm) {
		
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		orgLimitTimeDiscountService.add(orgLimitTimeDiscountForm,admin);
		
		return "redirect:/limitTimeDiscount/list";
	}
	
	@RequestMapping(value = "/editInit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editInit(Model model,@PathVariable Integer id) {
		
		OrgLimitTimeDiscount  orgLimitTimeDiscount = orgLimitTimeDiscountService.queryById(id);
		model.addAttribute("orgLimitTimeDiscount", orgLimitTimeDiscount);
		
		if(orgLimitTimeDiscount.getShopType() == OrgDiscountShopConstant.SHOP_TYPE_CITY){
		}else if(orgLimitTimeDiscount.getShopType() == OrgDiscountShopConstant.SHOP_TYPE_SHOP){
			OrgDiscountShopQuery query  = new OrgDiscountShopQuery();
			query.setTypeId(OrgDiscountShopConstant.TYPE_LIMIT_TIME_DISCOUNT);
			query.setDiscountId(orgLimitTimeDiscount.getId());
			List<OrgDiscountShop> listDiscountShop = orgDiscountShopService.queryList(query);
			StringBuilder sb = new StringBuilder();
			int size = listDiscountShop.size();
			for(int i=0;i<size;i++){
				sb.append(listDiscountShop.get(i).getShopId());
				if(i != size-1){
					sb.append(",");
				}
			}
			model.addAttribute("listShop", sb);
		}
		
		OrgDiscountAllowQuery allowQuery = new OrgDiscountAllowQuery();
		allowQuery.setTypeId(OrgDiscountTypeConstant.TYPE_LIMIT_TIME_DISCOUNT);
		allowQuery.setDiscountId(orgLimitTimeDiscount.getId());
		Map<Byte,OrgDiscountAllow> mapDiscountAllow = orgDiscountAllowService.queryMapKeyAllowTypeId(allowQuery);
		
		boolean allow2 = mapDiscountAllow.containsKey(Byte.valueOf("2"));
		model.addAttribute("allow2", allow2);
		boolean allow3 = mapDiscountAllow.containsKey(Byte.valueOf("3"));
		model.addAttribute("allow3", allow3);
		boolean allow4 = mapDiscountAllow.containsKey(Byte.valueOf("4"));
		model.addAttribute("allow4", allow4);
		boolean allow5 = mapDiscountAllow.containsKey(Byte.valueOf("5"));
		model.addAttribute("allow5", allow5);
		
		OrgDiscountScopeQuery scopeQuery = new OrgDiscountScopeQuery();
		scopeQuery.setTypeId(OrgDiscountTypeConstant.TYPE_LIMIT_TIME_DISCOUNT);
		scopeQuery.setDiscountId(orgLimitTimeDiscount.getId());
		Map<Byte,OrgDiscountScope> mapDiscountScope = orgDiscountScopeService.queryMapKeyScope(scopeQuery);
		boolean scopePc = mapDiscountScope.containsKey(OrgDiscountScopeConstant.SCOPE_PC);
		model.addAttribute("scopePc", scopePc);
		boolean scopeMobile = mapDiscountScope.containsKey(OrgDiscountScopeConstant.SCOPE_MOBILE);
		model.addAttribute("scopeMobile", scopeMobile);
		return "limitTimeDiscount/edit";
	}
	
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,RequestMethod.POST })
	public String edit(OrgLimitTimeDiscountForm orgLimitTimeDiscountForm ) {
		
		orgLimitTimeDiscountService.update(orgLimitTimeDiscountForm);
		
		return "redirect:/limitTimeDiscount/list";
	}
	
	@RequestMapping(value = "/pause/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String pause(@PathVariable Integer id) {
		
		orgLimitTimeDiscountService.updatePause(id);
		
		return "redirect:/limitTimeDiscount/list";
	}
	
	@RequestMapping(value = "/itemList", method = { RequestMethod.GET,RequestMethod.POST })
	public String itemList(OrgProductItemQuery query,Model model, PageReq pageReq) {
		
		//获取分类
		List<OrgClass> listClass = orgClassService.queryListAcvtive();
		model.addAttribute("listClass", listClass);
		
		//获取品牌
		if(query.getCatId() != null && query.getCatId() > 0){
			List<OrgBrand> listBrand =  orgBrandService.queryAllBrandByClass((int)query.getCatId());
			model.addAttribute("listBrand",listBrand);
		}
		
		OrgLimitTimeDiscount  orgLimitTimeDiscount = orgLimitTimeDiscountService.queryById(query.getLtdId());
		model.addAttribute("discount", orgLimitTimeDiscount);
		
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		Page<OrgProductItem> page = orgProductItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);

		return "limitTimeDiscount/itemSelect";
	}
	
	@ResponseBody
	@RequestMapping(value = "/goodsAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> goodsAdd(OrgLimitTimeGoods orgLimitTimeGoods) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgLimitTimeGoodsService.add(orgLimitTimeGoods);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/goodsUpdate", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> goodsUpdate(OrgLimitTimeGoods orgLimitTimeGoods) {
		Map<String,Object> result = new HashMap<String, Object>();
		orgLimitTimeGoodsService.updateByGoodsIdAndLtdId(orgLimitTimeGoods);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/goodsDelete", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> goodsDelete(OrgLimitTimeGoods orgLimitTimeGoods) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		orgLimitTimeGoodsService.delete(orgLimitTimeGoods);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}
