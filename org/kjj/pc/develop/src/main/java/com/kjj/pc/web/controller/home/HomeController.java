package com.kjj.pc.web.controller.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.shop.OrgShopPage;
import com.kjj.commserver.entity.shop.OrgShopPageFloor;
import com.kjj.commserver.entity.shop.OrgShopPageFloorProduct;
import com.kjj.commserver.entity.shop.OrgShopService;
import com.kjj.commserver.entity.shop.aide.OrgShopVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.shop.OrgShopPageFloorProductService;
import com.kjj.commserver.service.shop.OrgShopPageFloorService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.shop.OrgShopServiceService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;

@Controller
public class HomeController {
	
	@Resource
	private OrgShopPageService orgShopPageService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgShopServiceService orgShopServiceService;
	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgShopPageFloorProductService orgShopPageFloorProductService;
	@Resource
	private OrgShopPageFloorService orgShopPageFloorService;
	@Resource
	private OrgProductItemService orgProductItemService;
	
	@RequestMapping(value="/")
	public String home(Model model, HttpSession session) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);

		// 获取该商店信息
		if (orgUsersSession != null && orgUsersSession.getOrgShop() != null) {
			// 初始化门店信息
		    OrgShopPage shopPage = orgShopPageService.queryByShop(orgUsersSession.getOrgShop());
		    //店铺热搜加入session
		    ((OrgShopVo)(orgUsersSession.getOrgShop())).setShopSearch(shopPage == null ? null : shopPage.getShopSearch());
		    model.addAttribute("shopPage", shopPage);
		    //服务
		    List<OrgShopService> listShopService = orgShopServiceService.queryListByShopId(orgUsersSession.getOrgShop().getShopId());
		    model.addAttribute("listShopService", listShopService);
		    //分类信息
		    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
		    model.addAttribute("listClass", listClass);
		}
		return "home/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/loadFloor")
	public Map<String,Object> loadFloor(Integer floorid,HttpSession session) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgShopPageFloor orgShopPageFloor = orgShopPageFloorService.queryVoById(floorid);
		//获取楼层对应的推荐商品
		List<OrgShopPageFloorProduct> listRecommand =  orgShopPageFloorProductService.queryListRecommandByFloorid(floorid);
		//获取楼层对应的普通商品明细
		List<OrgShopPageFloorProduct> listCommon =  orgShopPageFloorProductService.queryListCommonByFloorid(floorid);
		List<OrgProductItemAll> listItemCommon = null;
		if(CollectionUtils.isNotEmpty(listCommon)){
			List<Integer> goodsIds = new ArrayList<Integer>();
			for(OrgShopPageFloorProduct shopPageFloorProduct : listCommon){
				goodsIds.add(shopPageFloorProduct.getProductid());
			}
			OrgProductItemQuery query =new OrgProductItemQuery();
			query.setGoodsIds(goodsIds);
			//query.setIsShowZeroInventoryFlg(true);
			query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
			query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
			//query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
			listItemCommon = orgProductItemService.queryList4View(orgUsersSession,query);
		}else{
			listItemCommon = new ArrayList<OrgProductItemAll>();
		}
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS );
		mapResult.put("pageFloor",orgShopPageFloor);
		mapResult.put("listRecommand",listRecommand);
		mapResult.put("listItemCommon",listItemCommon);
		return mapResult;
	}
}
