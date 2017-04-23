package com.kjj.mobile.web.controller.fastBuy;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductItemVo;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.PageReq;

@Controller
@RequestMapping("/fastBuy")
public class FastBuyController {
	
	@Resource
	private OrgClassService orgClassService;
	
	@Resource
	OrgProductItemService orgProductItemService;
	
	@Resource
	OrgCartService orgCartService;
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public String list(Model model,HttpSession session ,OrgProductItemQuery query, PageReq pageReq){
		//一级分类
		List<OrgClass> listClassLevelOne =  orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("listClassLevelOne",listClassLevelOne);
		return "/fastBuy/list";
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
	
	@ResponseBody
	@RequestMapping(value="/ajaxList", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> recommend(Model model,HttpSession session, PageReq pageReq,OrgProductItemQuery query) {
		Map<String,Object> result = new HashMap<String,Object>();
		Page<OrgProductItemAll> page = fastBuyInfo(session, pageReq, query);
		result.put("query",query);
		result.put("page",page);
		return result ;
	}

	private Page<OrgProductItemAll> fastBuyInfo(HttpSession session,
			PageReq pageReq, OrgProductItemQuery query) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		List<OrgCartAll> orgCartAllList = orgCartService.queryList4View(orgUsersSession);
		//自动修改购物车超量商品数量
		orgCartService.updateAmount4Over(orgUsersSession,orgCartAllList);
		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		query.setIsShowZeroInventoryFlg(true);
		Sort sort = new Sort(Direction.DESC,"t.sale_num");
		pageReq.setSort(sort);
		OrgProductItemVo itemVo = null;
		Page<OrgProductItemAll> page = orgProductItemService.queryPageList4View(orgUsersSession,query, pageReq);
		for (OrgCartAll orgCartAll : orgCartAllList) {
			for (OrgProductItemAll orgProductItemAll : page) {
				if(orgCartAll.getOrgCart().getGoodsId().equals(orgProductItemAll.getOrgProductItem().getGoodsId())){
					itemVo = (OrgProductItemVo) orgProductItemAll.getOrgProductItem();
					itemVo.setAmount(orgCartAll.getOrgCart().getAmount());
					orgProductItemAll.getOrgProductItemAide().setUserBuyMax(orgCartAll.getOrgProductItemAll().getOrgProductItemAide().getUserBuyMax());
					orgProductItemAll.getOrgProductInventory().setShopAmount(orgCartAll.getOrgProductItemAll().getOrgProductInventory().getShopAmount());
				}
			}
		}
		return page;
	}
	
}

