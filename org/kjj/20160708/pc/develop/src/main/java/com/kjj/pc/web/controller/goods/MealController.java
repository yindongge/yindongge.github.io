package com.kjj.pc.web.controller.goods;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
import com.kjj.commserver.service.goods.OrgProductLinkPropertyService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.pc.constant.SessionConstant;

@Controller
@RequestMapping(value="/meal")
public class MealController {
	
	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgProductItemService orgProductItemService;
	@Resource
	private OrgCartService orgCartService;
	@Resource
	private OrgProductLinkPropertyService orgProductLinkPropertyService;
	
	@RequestMapping(value="/show",method={RequestMethod.GET,RequestMethod.POST})
	public String show(Model model, HttpSession session,HttpServletRequest request,HttpServletResponse response,OrgProductItemQuery query) {
		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		List<OrgCartAll> orgCartAllList = orgCartService.queryList4View(orgUsersSession);
		//自动修改购物车超量商品数量
		orgCartService.updateAmount4Over(orgUsersSession,orgCartAllList);
		query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
		query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
		query.setIsShowZeroInventoryFlg(true);
		query.setCatId((short)OrgClassConstant.MEAL_CLASS_ID);
		OrgProductItemVo itemVo=null;
		List<OrgProductItemAll> productItemAllList = orgProductItemService.queryList4View(orgUsersSession, query);
		for(OrgCartAll orgCartAll : orgCartAllList){
		for(OrgProductItemAll orgProductItemAll : productItemAllList){
				if(orgCartAll.getOrgCart().getGoodsId().equals(orgProductItemAll.getOrgProductItem().getGoodsId())){
					itemVo = (OrgProductItemVo) orgProductItemAll.getOrgProductItem();
					itemVo.setAmount(orgCartAll.getOrgCart().getAmount());
					orgProductItemAll.getOrgProductItemAide().setUserBuyMax(orgCartAll.getOrgProductItemAll().getOrgProductItemAide().getUserBuyMax());//可购买的最大数量
					orgProductItemAll.getOrgProductInventory().setShopAmount(orgCartAll.getOrgProductItemAll().getOrgProductInventory().getShopAmount());//库存量
				}
			}
		}
		model.addAttribute("productItemAllList",productItemAllList);
		model.addAttribute("cartAllList",orgCartAllList);
		
		//分类信息
	    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    model.addAttribute("listClass", listClass);
		
		return "meal/show";
	}
}