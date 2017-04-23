package com.kjj.mobile.web.controller.order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionVo;
import com.kjj.commserver.entity.discount.aide.OrgReachConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountVo;
import com.kjj.commserver.entity.discount.aide.OrgReachVo;
import com.kjj.commserver.entity.goods.OrgProductInventory;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemVo;
import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgCartConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.mobile.constant.BackUrlConstant;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.PathUtil;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Resource
	private OrgCartService orgCartService;
	
	@Resource
	private OrgReachService orgReachService;
	
	//选择数量
	int selectAmount = 0;
	
	BigDecimal selectMoney = BigDecimal.ZERO;
	
	//全选
	boolean isSelectAll ;
	
	//是否编辑1，编辑；0，完成；
	int editFlg=1;
	
	//是否有被勾选的条目
	Boolean selected;
	
	
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> add(HttpSession session,OrgCart orgCart) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> result = new HashMap<String,Object>();
		if(orgCart.getAmount() == null){
			orgCart.setAmount(1);
		}else if(orgCart.getAmount() < 1){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		//添加到购物车
		orgCartService.add(orgUsersSession,orgCart);
		//数量
		long cartCount = orgCartService.getCountByUser(orgUsersSession);
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,cartCount);
		//数量
		result.put("cartCount",cartCount);
		result.put("goodsId", orgCart.getGoodsId());
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.POST })
	public Map<String,Object> del(HttpSession session, @RequestParam(value="goodsIds",defaultValue="")List<Integer> goodsIds) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.deleteBatch(orgUsersSession,goodsIds);
		//数量
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));
		Map<String,Object> result = new HashMap<String,Object>();
		long cartCount = orgCartService.getCountByUser(orgUsersSession);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("cartCount",cartCount);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> edit(HttpSession session,OrgCart orgCart,HttpServletRequest request) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.update(orgUsersSession,orgCart);
		//数量
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));
		Map<String,Object> result = new HashMap<String,Object>();
		long cartCount = orgCartService.getCountByUser(orgUsersSession);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("cartCount",cartCount);
		result.put("showInfo", getShowInfo(session,request));
		result.put("bottomInfo",getBottomInfo(session,request));
		return result;
		
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/selectOn", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectOn(HttpSession session, HttpServletRequest request, OrgCart orgCart) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.updateSelectOn(orgUsersSession, orgCart);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		mapResult.put("bottomInfo",getBottomInfo(session,request));
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectOff", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectOff(HttpSession session, HttpServletRequest request, OrgCart orgCart) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.updateSelectOff(orgUsersSession, orgCart);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		mapResult.put("bottomInfo",getBottomInfo(session,request));
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectAllOn", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectAllOn(HttpSession session, HttpServletRequest request,int editFlg) {
		setEditFlg(editFlg);
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.updateSelectAllOn(orgUsersSession);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		mapResult.put("bottomInfo",getBottomInfo(session,request));
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectAllOff", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectAllOff(HttpSession session, HttpServletRequest request,int editFlg) {
		setEditFlg(editFlg);
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.updateSelectAllOff(orgUsersSession);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		mapResult.put("bottomInfo",getBottomInfo(session,request));
		return mapResult;
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session, HttpServletRequest request){
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		List<OrgCartAll> listCart = orgCartService.queryList4View(orgUsersSession);
		setEditFlg(1);
		//跳转页面
		session.setAttribute(SessionConstant.SESSION_BACK_URL,BackUrlConstant.URL_CART_LIST);
		if(CollectionUtils.isNotEmpty(listCart)){
			model.addAttribute("showInfo", getShowInfo(session,request));
			model.addAttribute("bottomInfo",getBottomInfo(session,request));
			return "cart/list";
		}else{
			return "cart/listEmpty";
		}
	}
	
	private String getShowInfo(HttpSession session,HttpServletRequest request){
		String basePath = PathUtil.getBasePath(request);
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		List<OrgCartAll> listCart = orgCartService.queryList4View(orgUsersSession);
		//自动修改购物车超量商品数量
		orgCartService.updateAmount4Over(orgUsersSession,listCart);
		//满减满送
		Map<Integer, OrgReach>  mapReach = orgReachService.updateMap4View(orgUsersSession, listCart);
		//数量
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));
		//前台显示
		StringBuilder strShowInfo = new StringBuilder();
		
		//全选
		isSelectAll=true;
		selectAmount = 0;
		selectMoney = BigDecimal.ZERO;
		selected=false;
		
		for(OrgCartAll orgCartAll : listCart){
			if(orgCartAll.getCanBuy()){
				if(orgCartAll.getOrgCart().getStatus() == OrgCartConstant.STATUS_SELECT_OFF){
					if(isSelectAll()){
						setSelectAll(false);
					}
				}
				if(orgCartAll.getOrgCart().getStatus() == OrgCartConstant.STATUS_SELECT_ON){
					setSelected(true);
					selectAmount += orgCartAll.getOrgCart().getAmount();
					selectMoney = selectMoney.add(BigDecimal.valueOf(orgCartAll.getOrgCart().getAmount()).multiply(orgCartAll.getOrgProductItemAll().getOrgProductItemAide().getRealPrice()));
				}
				
			}
		}
		//满减满送
		OrgReachVo orgReachVo = null;
		OrgReachConditionVo orgReachConditionVo = null;
		OrgReachDiscountVo orgReachDiscountVo = null;
		OrgCart orgCart = null;
		OrgProductItemAll orgProductItemAll = null;
		OrgProductItemVo orgProductItemVo = null;
		OrgProductItemAide orgProductItemAide = null;
		OrgProductInventory orgProductInventory = null;
		OrgLimitTimeGoods orgLimitTimeGoods = null;
		for(Map.Entry<Integer, OrgReach> entryReach : mapReach.entrySet()){
			orgReachVo = (OrgReachVo)entryReach.getValue();
			orgReachConditionVo = (OrgReachConditionVo)orgReachVo.getOrgReachCondition();
			strShowInfo.append("<div class=\"manjian_left\">");
			strShowInfo.append("<a href=\"#\" class=\"yellow_a\">满减</a>");
			strShowInfo.append("<span class=\"inline_span\">"+orgReachVo.getTitle()+"</span>");
			strShowInfo.append("<span class=\"yellow\">（已满");
			if(orgReachVo.getReachStyle() == OrgReachConstant.REACH_STYLE_MONEY){
			strShowInfo.append(orgReachVo.getSumMoney()+"元");
			}else if(orgReachVo.getReachStyle() == OrgReachConstant.REACH_STYLE_AMOUNT){
			strShowInfo.append(orgReachVo.getSumAmount()+"件");
			}
			if(orgReachConditionVo != null && orgReachConditionVo.getMapReachDiscount().containsKey(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY))){
				orgReachDiscountVo = (OrgReachDiscountVo)orgReachConditionVo.getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY));
				strShowInfo.append(",已减");
				strShowInfo.append(BigDecimal.valueOf(orgReachDiscountVo.getDiscountMultiple()).multiply(orgReachDiscountVo.getCommon()));
			}
			strShowInfo.append("）</span>");	
			strShowInfo.append("</div>");	
			for(OrgCartAll orgCartAll : listCart){
				orgCart = orgCartAll.getOrgCart();
				orgProductItemAll = orgCartAll.getOrgProductItemAll();
				orgProductItemVo = (OrgProductItemVo)orgProductItemAll.getOrgProductItem();
				orgProductItemAide = orgProductItemAll.getOrgProductItemAide();
				orgProductInventory=orgProductItemAll.getOrgProductInventory();
				orgLimitTimeGoods=orgProductItemAll.getOrgLimitTimeGoods();
				if(orgCartAll.getCanBuy() && orgCart.getDiscountId() == orgReachVo.getId()){
					//可买优惠商品
					strShowInfo.append("<div class=\"car-list margin-top\" >");	
					strShowInfo.append("<div class=\"car-item\">");	
					
					strShowInfo.append("<div class=\"car-checked\">");	
					if(orgCart.getStatus() == OrgCartConstant.STATUS_SELECT_ON){
						setSelected(true);
						strShowInfo.append("<span class=\"goodsSelect checkme checked\"  data-goods-id=\""+orgProductItemAide.getGoodsId()+"\"></span>");	
					}else{
						strShowInfo.append("<span class=\"goodsSelect checkme\"  data-goods-id=\""+orgProductItemAide.getGoodsId()+"\"></span>");	
					}
					strShowInfo.append("</div>");	
					
					strShowInfo.append("<div class=\"car-content\">");	
					strShowInfo.append("<div class=\"carlist-a\">");	
					
					strShowInfo.append("<div class=\"carlist-img\">");	
					strShowInfo.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\"><img src=\""+orgProductItemVo.getGoodsImg180()+"\"></a>");	
					strShowInfo.append("</div>");	
					
					strShowInfo.append("<div class=\"carlist-text\">");	
					strShowInfo.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\"><span class=\"title\" >"+orgProductItemVo.getGoodsName()+"</span></a>");	
					strShowInfo.append("<div class=\"price-list\">");	
					if(orgLimitTimeGoods!=null && orgProductItemAide.getMarkLimitTimeDiscount()==true){
						strShowInfo.append("<span class=\"a-zhekou\">"+orgLimitTimeGoods.getGoodsTitle()+"</span>");							
					}
					strShowInfo.append("</div>");
					
					strShowInfo.append("<div class=\"price-list\">");	
					if(orgProductItemAide.getShowPrice() != null){
						strShowInfo.append("<span class=\"red\"><i class=\"rmb\">￥</i>"+orgProductItemAide.getShowPrice()+"</span>");	
					}else{
						strShowInfo.append("<span class=\"red\">暂无报价</span>");	
					}
					strShowInfo.append("</div>");	
					strShowInfo.append("</div>");	
					strShowInfo.append("</div>");	
					strShowInfo.append("<div class=\"addlist\">");	
					if(orgProductItemAide.getUserBuy()>1){
						strShowInfo.append("<span class=\"quantity \" name=\"amountMinus\">-</span>");							
					}else{
						strShowInfo.append("<span class=\"quantity disabled\" name=\"amountMinus\">-</span>");							
					}
					strShowInfo.append("<input type=\"text\" class=\"quanityainput\" name=\"amount\" data-real-price=\""+orgProductItemAide.getRealPrice()+"\"  data-inventory-num=\""+orgProductInventory.getShopAmount()+"\" data-buy-max=\""+orgProductItemAide.getUserBuyMax()+"\" data-old=\""+orgProductItemAide.getUserBuy()+"\" value=\""+orgProductItemAide.getUserBuy()+"\"  >");	
					strShowInfo.append("<span class=\"quantity\" name=\"amountPlus\">+</span>");	
					strShowInfo.append("</div>");	
					strShowInfo.append("</div>");	
					strShowInfo.append("</div>");	
					
					if(MapUtils.isNotEmpty(orgCartAll.getMapDiscount())){
						strShowInfo.append("<div class=\"shengyuwrapper\" >");	
						strShowInfo.append("<p class=\"shengyu2\">");	
						if(orgProductItemAide.getUserBuyMax() != orgProductItemAll.getOrgProductInventory().getShopAmount()){
							strShowInfo.append("限购"+orgProductItemAide.getUserBuyMax()+"件");
						}else if(orgProductItemAide.getUserBuy() > orgProductItemAll.getOrgProductInventory().getShopAmount()){
							strShowInfo.append("剩余"+orgProductItemAll.getOrgProductInventory().getShopAmount()+"件");
						}else if(orgProductItemAll.getOrgProductInventory().getShopAmount() < 6){
							strShowInfo.append("剩余"+orgProductItemAll.getOrgProductInventory().getShopAmount()+"件");
						}
						//选择优惠，弹窗
						strShowInfo.append("</p>");	
						//弹窗开始
						strShowInfo.append("<div class=\"fixed_content\">");	
						strShowInfo.append("<a class=\"fixed_span\">促销优惠<i class=\"yellow_down_icon\"></i></a>");	
						strShowInfo.append("<div class=\"fixed_div \">");	
						strShowInfo.append("<div class=\"fixed_div_title\">");	
						strShowInfo.append("<h5>该商品优惠条件<span class=\"closeReach\">X</span></h5>");	
						strShowInfo.append("</div>");
						//满减满送活动下拉列表
						for(Map.Entry<Integer, String> entryDiscount : orgCartAll.getMapDiscount().entrySet()){
							strShowInfo.append("<div class=\"radio_list\" data-discountId=\""+entryDiscount.getKey()+"\" >");	
							strShowInfo.append("<div class=\"checkselect ");	
							if(entryDiscount.getKey().equals(orgReachVo.getId())){
								strShowInfo.append("on");
								}
							strShowInfo.append(" \" ></div>");	
							strShowInfo.append("<p>"+entryDiscount.getValue()+"</p>");	
							strShowInfo.append("</div>");
						}
						strShowInfo.append("<div class=\"radio_list\" data-discountId=\"0\" >");	
						strShowInfo.append("<div class=\"checkselect \"></div>");	
						strShowInfo.append("<p>不使用优惠</p>");	
						strShowInfo.append("</div>");
						strShowInfo.append("</div>");	
						strShowInfo.append("</div>");	
						//弹窗结束
						strShowInfo.append("</div>");	
					}
					strShowInfo.append("</div>");	
				}
			}
			
			//平衡价格
			if(orgReachConditionVo != null && orgReachConditionVo.getMapReachDiscount().containsKey(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY))){
				orgReachDiscountVo = (OrgReachDiscountVo)orgReachConditionVo.getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY));
				selectMoney = selectMoney.subtract(orgReachDiscountVo.getBalance());

			}
			if(orgReachConditionVo != null && orgReachConditionVo.getMapReachDiscount().containsKey(Long.valueOf(OrgReachDiscountConstant.TYPE_GIVE))){
				orgReachDiscountVo = (OrgReachDiscountVo)orgReachConditionVo.getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_GIVE));
				for(OrgProductItem itemGive : orgReachDiscountVo.getListReachGive()){
					orgProductItemVo = (OrgProductItemVo)itemGive;
					strShowInfo.append("<div class=\"gray_bg_zeng\"> <span>"+orgProductItemVo.getGoodsName()+"X"+orgProductItemVo.getGiveAmount()+"</span> </div>");
				}
			}
		}
		//商品
		StringBuilder strShowInfoNoReach = new StringBuilder();
		//可买普通商品
		int cannotBuyNum=0;
		
		for(OrgCartAll orgCartAll : listCart){
			orgCart = orgCartAll.getOrgCart();
			orgProductItemAll = orgCartAll.getOrgProductItemAll();
			orgProductItemVo = (OrgProductItemVo)orgProductItemAll.getOrgProductItem();
			orgProductItemAide = orgProductItemAll.getOrgProductItemAide();
			orgProductInventory = orgProductItemAll.getOrgProductInventory();
			orgLimitTimeGoods=orgProductItemAll.getOrgLimitTimeGoods();
				if(orgCartAll.getCanBuy() && (orgCart.getDiscountId() == null || orgCart.getDiscountId() == 0 || !mapReach.containsKey(orgCart.getDiscountId()))){
				 //可买普通商品
				strShowInfo.append("<div class=\"car-list margin-top\" >");	
				strShowInfo.append("<div class=\"car-item\">");	
				strShowInfo.append("<div class=\"car-checked\">");	
				if(orgCart.getStatus() == OrgCartConstant.STATUS_SELECT_ON){
					setSelected(true);
					strShowInfo.append("<span class=\"goodsSelect checkme checked\"  data-goods-id=\""+orgProductItemAide.getGoodsId()+"\"></span>");	
				}else{
					strShowInfo.append("<span class=\"goodsSelect checkme \"  data-goods-id=\""+orgProductItemAide.getGoodsId()+"\"></span>");		
				}
				strShowInfo.append("</div>");	
				strShowInfo.append("<div class=\"car-content\">");	
				strShowInfo.append("<div class=\"carlist-a\">");	
				strShowInfo.append("<div class=\"carlist-img\">");	
				strShowInfo.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\"><img src=\""+orgProductItemVo.getGoodsImg180()+"\"></a>");	
				strShowInfo.append("</div>");	
				strShowInfo.append("<div class=\"carlist-text\">");	
				strShowInfo.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\"><span class=\"title\" >"+orgProductItemVo.getGoodsName()+"</span></a>");	
				strShowInfo.append("<div class=\"price-list\">");	
				if(orgLimitTimeGoods!=null && orgProductItemAide.getMarkLimitTimeDiscount()==true){
					strShowInfo.append("<span class=\"a-zhekou\">"+orgLimitTimeGoods.getGoodsTitle()+"</span>");							
				}
				strShowInfo.append("</div>");	
				strShowInfo.append("<div class=\"price-list\">");	
				if(orgProductItemAide.getShowPrice() != null){
					strShowInfo.append("<span class=\"red\"><i class=\"rmb\">￥</i>"+orgProductItemAide.getShowPrice()+"</span>");	
				}else{
					strShowInfo.append("<span class=\"red\">暂无报价</span>");	
				}
				strShowInfo.append("</div>");	
				strShowInfo.append("</div>");	
				strShowInfo.append("</div>");	
				strShowInfo.append("<div class=\"addlist\">");	
				if(orgProductItemAide.getUserBuy()>1){
					strShowInfo.append("<span class=\"quantity \" name=\"amountMinus\">-</span>");							
				}else{
					strShowInfo.append("<span class=\"quantity disabled\" name=\"amountMinus\">-</span>");							
				}
				strShowInfo.append("<input type=\"text\" class=\"quanityainput\" name=\"amount\" data-real-price=\""+orgProductItemAide.getRealPrice()+"\"  data-inventory-num=\""+orgProductInventory.getShopAmount()+"\" data-buy-max=\""+orgProductItemAide.getUserBuyMax()+"\" data-old=\""+orgProductItemAide.getUserBuy()+"\" value=\""+orgProductItemAide.getUserBuy()+"\"  >");	
				strShowInfo.append("<span class=\"quantity\" name=\"amountPlus\">+</span>");	
				strShowInfo.append("</div>");	
				strShowInfo.append("</div>");	
				strShowInfo.append("</div>");	
				if(MapUtils.isNotEmpty(orgCartAll.getMapDiscount())){
					strShowInfo.append("<div class=\"shengyuwrapper\" >");
					strShowInfo.append("<p class=\"shengyu2\">");	
					if(orgProductItemAide.getUserBuyMax() != orgProductItemAll.getOrgProductInventory().getShopAmount()){
						strShowInfo.append("限购"+orgProductItemAide.getUserBuyMax()+"件");
					}else if(orgProductItemAide.getUserBuy() > orgProductItemAll.getOrgProductInventory().getShopAmount()){
						strShowInfo.append("剩余"+orgProductItemAll.getOrgProductInventory().getShopAmount()+"件");
					}else if(orgProductItemAll.getOrgProductInventory().getShopAmount() < 6){
						strShowInfo.append("剩余"+orgProductItemAll.getOrgProductInventory().getShopAmount()+"件");
					}
					strShowInfo.append("</p>");
					//弹窗开始
					strShowInfo.append("<div class=\"fixed_content\">");	
					strShowInfo.append("<a class=\"fixed_span\">促销优惠<i class=\"yellow_down_icon\"></i></a>");	
					strShowInfo.append("<div class=\"fixed_div \">");	
					strShowInfo.append("<div class=\"fixed_div_title\">");	
					strShowInfo.append("<h5>该商品优惠条件<span class=\"closeReach\">X</span></h5>");	
					strShowInfo.append("</div>");
					//满减满送活动下拉列表
					for(Map.Entry<Integer, String> entryDiscount : orgCartAll.getMapDiscount().entrySet()){
						strShowInfo.append("<div class=\"radio_list\" data-discountId=\""+entryDiscount.getKey()+"\" >");	
						strShowInfo.append("<div class=\"checkselect ");	
						strShowInfo.append(" \" ></div>");	
						strShowInfo.append("<p>"+entryDiscount.getValue()+"</p>");	
						strShowInfo.append("</div>");
					}
					strShowInfo.append("<div class=\"radio_list\" data-discountId=\"0\" >");	
					strShowInfo.append("<div class=\"checkselect on \"></div>");	
					strShowInfo.append("<p>不使用优惠</p>");	
					strShowInfo.append("</div>");
					strShowInfo.append("</div>");
					strShowInfo.append("</div>");			
					//弹窗结束
					strShowInfo.append("</div>");	
				}	
				strShowInfo.append("</div>");			
			}
			//不可买商品
			if(!orgCartAll.getCanBuy()){
				cannotBuyNum++;
				strShowInfoNoReach.append("<div class=\" car-list gray-bg\">");
				strShowInfoNoReach.append("<div class=\"diffent\">");
				strShowInfoNoReach.append("<div class=\"car-item\"  data-goods-id=\""+orgProductItemAide.getGoodsId()+"\"  >");
				strShowInfoNoReach.append("<div class=\"car-checked g_s_control\">");
				strShowInfoNoReach.append("<span class=\"gray_span\">失效</span>");
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("<div class=\"car-content\">");
				strShowInfoNoReach.append("<div class=\"carlist-a\">");
				strShowInfoNoReach.append("<div class=\"carlist-img\">");
				strShowInfoNoReach.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\"><img src=\""+orgProductItemVo.getGoodsImg180()+"\"></a>");	
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("<div class=\"carlist-text\">");
				strShowInfoNoReach.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\"><span class=\"title\" >"+orgProductItemVo.getGoodsName()+"</span></a>");	
				strShowInfoNoReach.append("<div class=\"price-list\">");
				strShowInfoNoReach.append("<span>对不起，宝贝已经卖光了！</span>");
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("<div class=\"shengyuwrapper\" >");
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("</div>");
				strShowInfoNoReach.append("</div>");
			}
		}
		if(cannotBuyNum>0){
			strShowInfoNoReach.append("<div class=\"cleargoods\">");
			strShowInfoNoReach.append("<a  class=\"clear-a\" id=\"delInvalid\" >清空失效宝贝</a>");
			strShowInfoNoReach.append("</div>");
		}
		strShowInfo.append(strShowInfoNoReach);
		
		setSelectAmount(selectAmount);
		setSelectMoney(selectMoney);
		return strShowInfo.toString();
	}
	
	private String getBottomInfo(HttpSession session,HttpServletRequest request ){
		StringBuffer strBottomInfo=new StringBuffer();
		//底栏
		
		strBottomInfo.append("<div class=\"priceall\">");
		if(isSelectAll()){
			strBottomInfo.append("<div id=\"selectAllDiv\" class=\"pa-l\"><span class=\"checkme checked\"  id=\"selectAll\"></span>全选</div>");
		}else{
			strBottomInfo.append("<div id=\"selectAllDiv\" class=\"pa-l\"><span class=\"checkme \"  id=\"selectAll\"></span>全选</div>");
		}
		strBottomInfo.append("<div class=\"pa-c\">");
		strBottomInfo.append("<p>总计<span class=\"red\" id=\"moneyTotal\">"+getSelectMoney()+"</span></p>");
		strBottomInfo.append("<p id=\"amountTotal\">总计"+getSelectAmount()+"件,不含配送费</p>");
		strBottomInfo.append("</div>");
		if(editFlg==1){
			strBottomInfo.append("<div class=\"pa-r ");
			if(getSelected()){
				strBottomInfo.append("deletep");
			}
			strBottomInfo.append("\" ");
			if(getSelected()){
				strBottomInfo.append("id=\"btnPay\" ");
			}
			strBottomInfo.append(" >");
			strBottomInfo.append("<a href=\"javascript:void(0);\">结算</a>");
			strBottomInfo.append("<i  id=\"iPay\"></i>");
			strBottomInfo.append("</div>");
		}
		if(editFlg==0){
			strBottomInfo.append("<div class=\"pa-r ");
			if(getSelected()){
				strBottomInfo.append("deletep");
			}
			strBottomInfo.append("\" ");
			if(getSelected()){
				strBottomInfo.append("id=\"btnDelete\" ");
			}
			strBottomInfo.append(" >");
			strBottomInfo.append("<a href=\"javascript:void(0);\">删除</a>");
			strBottomInfo.append("</div>");
		}
		strBottomInfo.append("</div>");
		return strBottomInfo.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/selectDiscount", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectDiscount(HttpSession session, HttpServletRequest request,OrgCart orgCart){
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.update(orgUsersSession,orgCart);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		mapResult.put("bottomInfo",getBottomInfo(session,request));
		return mapResult;
	}


	public int getSelectAmount() {
		return selectAmount;
	}


	public void setSelectAmount(int selectAmount) {
		this.selectAmount = selectAmount;
	}


	public BigDecimal getSelectMoney() {
		return selectMoney;
	}


	public void setSelectMoney(BigDecimal selectMoney) {
		this.selectMoney = selectMoney;
	}


	public boolean isSelectAll() {
		return isSelectAll;
	}


	public void setSelectAll(boolean isSelectAll) {
		this.isSelectAll = isSelectAll;
	}


	public int isEditFlg() {
		return editFlg;
	}


	public void setEditFlg(int editFlg) {
		this.editFlg = editFlg;
	}


	public Boolean getSelected() {
		return selected;
	}


	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	
}
