package com.kjj.pc.web.controller.goods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.goods.OrgProductLinkPropertyService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.shop.OrgShopSendRangeService;
import com.kjj.pc.constant.HttpStatusCode;
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
	@Resource
	private OrgShopSendRangeService orgShopSendRangeService;
	
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
		List<OrgProductItemAll> amountList = new ArrayList<OrgProductItemAll>();
		List<OrgProductItemAll> zeroList = new ArrayList<OrgProductItemAll>();
		for(OrgProductItemAll orgProductItemAll : productItemAllList){
			if(orgProductItemAll.getOrgProductInventory().getShopAmount()>0){
				amountList.add(orgProductItemAll);
			}else{
				zeroList.add(orgProductItemAll);
			}
		}
		amountList.addAll(zeroList);
		model.addAttribute("productItemAllList",amountList);
		model.addAttribute("cartAllList",orgCartAllList);
		
		//分类信息
	    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    model.addAttribute("listClass", listClass);
	    
	    // 每天11:00之前，午餐如果无货，前台"显示备货中"
	    DateFormat formartTime = new SimpleDateFormat("HH:mm:ss");
	    String timeStr = formartTime.format(new Date());
	    
	    if("11:00:00".compareTo(timeStr) > 0) {
	    	model.addAttribute("moonBefore", new Integer(1));
	    } else {
	    	model.addAttribute("moonBefore", new Integer(0));
	    }
		
		return "meal/show";
	}
	
	@ResponseBody
	@RequestMapping(value="/sendRange",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> sendRange(Model model,Integer shopId,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		List<OrgShopSendRange> sendRangeList = orgShopSendRangeService.queryListByShopId(shopId);
		map.put("sendRangeList", sendRangeList);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
}