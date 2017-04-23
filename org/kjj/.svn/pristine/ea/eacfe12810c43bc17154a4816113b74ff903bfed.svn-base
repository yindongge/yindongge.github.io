package com.kjj.pc.web.controller.order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeGoodsVo;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionVo;
import com.kjj.commserver.entity.discount.aide.OrgReachConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountConstant;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountVo;
import com.kjj.commserver.entity.discount.aide.OrgReachVo;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductInventoryVo;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemVo;
import com.kjj.commserver.entity.goods.aide.OrgProductShopSaleConstant;
import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgCartConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PathUtil;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Resource
	private OrgCartService orgCartService;
	@Resource
	private OrgClassService orgClassService;
	@Resource
	private OrgReachService orgReachService;
	
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String add(Model model,HttpSession session,OrgCart orgCart) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		if(orgCart.getAmount() == null){
			orgCart.setAmount(1);
		}else if(orgCart.getAmount() < 1){
			return "error/error";
		}
		//添加到购物车
		orgCartService.add(orgUsersSession,orgCart);
		//数量
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));
		
		model.addAttribute("goodsId", orgCart.getGoodsId());
		return "redirect:/cart/addShow";
	}
	
	@ResponseBody
	@RequestMapping(value = "/addCartAjax", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> addCartAjax(Model model,HttpSession session,OrgCart orgCart) {
		Map<String,Object> map = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		if(orgCart.getAmount() == null){
			orgCart.setAmount(1);
		}else if(orgCart.getAmount() < 1){
			map.put("code", HttpStatusCode.CODE_ERROR);
			return map;
		}
		//添加到购物车
		orgCartService.add(orgUsersSession,orgCart);
		//数量
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));
		
		model.addAttribute("goodsId", orgCart.getGoodsId());
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
	
	@RequestMapping(value = "/addShow", method = { RequestMethod.GET,RequestMethod.POST })
	public String addShow(Model model,HttpSession session,OrgCart orgCart) {
		
		//分类信息
	    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    
	    model.addAttribute("listClass", listClass);
		model.addAttribute("goodsId", orgCart.getGoodsId());
		return "cart/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.POST })
	public Map<String,Object> del(HttpSession session,HttpServletRequest request, @RequestParam(value="goodsIds",defaultValue="")List<Integer> goodsIds) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.deleteBatch(orgUsersSession,goodsIds);
		//数量
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));	
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> edit(HttpSession session,HttpServletRequest request,OrgCart orgCart) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.update(orgUsersSession,orgCart);
		//数量
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectOn", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectOn(HttpSession session, HttpServletRequest request, OrgCart orgCart) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.updateSelectOn(orgUsersSession, orgCart);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
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
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectAllOn", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectAllOn(HttpSession session, HttpServletRequest request) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.updateSelectAllOn(orgUsersSession);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectAllOff", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectAllOff(HttpSession session, HttpServletRequest request) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.updateSelectAllOff(orgUsersSession);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		return mapResult;
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session, HttpServletRequest request){
		model.addAttribute("showInfo",getShowInfo(session,request));
		return "cart/list";
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
		if(CollectionUtils.isEmpty(listCart)){
			strShowInfo.append("<div class=\"car-empty\">");
			strShowInfo.append("<div class=\"empty-text\">");
			strShowInfo.append("<p>购物车还是空的哦~，选选喜欢的商品吧~</p>");
			strShowInfo.append("<p class=\"empty-control\">");
			if(!orgUsersSession.isLogin()){
			strShowInfo.append("<a href=\""+basePath+"/loginInit\" role=\"button\" class=\"btn btn-warning btn-sm\">登录</a>");
			}
			strShowInfo.append("<a href=\""+basePath+"\">去购物 </a>");
			strShowInfo.append("</p>");
			strShowInfo.append("</div>");
			strShowInfo.append("</div>");
		}else{
			//全选
			boolean isSelectAll = true;
			//选择数量
			int selectAmount = 0;
			BigDecimal selectMoney = BigDecimal.ZERO;
			for(OrgCartAll orgCartAll : listCart){
				if(orgCartAll.getCanBuy()){
					if(orgCartAll.getOrgCart().getStatus() == OrgCartConstant.STATUS_SELECT_OFF){
						if(isSelectAll){
							isSelectAll = false;
						}
					}
					if(orgCartAll.getOrgCart().getStatus() == OrgCartConstant.STATUS_SELECT_ON){
						selectAmount += orgCartAll.getOrgCart().getAmount();
						selectMoney = selectMoney.add(BigDecimal.valueOf(orgCartAll.getOrgCart().getAmount()).multiply(orgCartAll.getOrgProductItemAll().getOrgProductItemAide().getRealPrice()));
					}
					
				}
			}
			
			strShowInfo.append("<div class=\"kjj-car\">");
			strShowInfo.append("<div class=\"car-top\">");
			strShowInfo.append("<button type=\"button\" id=\"amountAll\" class=\"btn btn-default\">全部商品["+selectAmount+"]</button>");
			strShowInfo.append("</div>");
			strShowInfo.append("<div class=\"car-thead\">");
			strShowInfo.append("<div class=\"left c-checkbox\">");
			strShowInfo.append("<input type=\"checkbox\" data-name=\"checkAll\"");
			if(isSelectAll){
				strShowInfo.append(" checked=\"checked\" onclick=\"selectAllOff();\"");
			}else{
				strShowInfo.append(" onclick=\"selectAllOn();\"");
			}
			strShowInfo.append("/>全选");
			strShowInfo.append("</div>");
			strShowInfo.append("<div class=\"left c-goods\">商品</div>");
			strShowInfo.append("<div class=\"left c-price\">单价(元)</div>");
			strShowInfo.append("<div class=\"left c-quantity\">数量</div>");
			strShowInfo.append("<div class=\"left c-youhui\">优惠</div>");
			strShowInfo.append("<div class=\"left c-sum\">小计(元)</div>");
			strShowInfo.append("<div class=\"left c-action\">操作</div>");
			strShowInfo.append("</div>");
			//满减满送
			OrgReachVo orgReachVo = null;
			OrgReachConditionVo orgReachConditionVo = null;
			OrgReachDiscountVo orgReachDiscountVo = null;
			OrgCart orgCart = null;
			OrgProductItemAll orgProductItemAll = null;
			OrgProductItemVo orgProductItemVo = null;
			OrgProductItemAide orgProductItemAide = null;
			for(Map.Entry<Integer, OrgReach> entryReach : mapReach.entrySet()){
				orgReachVo = (OrgReachVo)entryReach.getValue();
				orgReachConditionVo = (OrgReachConditionVo)orgReachVo.getOrgReachCondition();
				strShowInfo.append("<div class=\"car-list\">");
				strShowInfo.append("<div class=\"manjian_box\">");
				strShowInfo.append("<div class=\"manjian_left\">");
				strShowInfo.append("<a href=\"javascript:void(0);\" class=\"yellow_a\">"+orgReachVo.getLabel()+"</a>");
				strShowInfo.append("<span class=\"inline_span\">"+orgReachVo.getTitle()+"</span>");
				strShowInfo.append("</div>");
				strShowInfo.append("<div class=\"manjian_right\">");
				strShowInfo.append("活动商品已购满");
				if(orgReachVo.getReachStyle() == OrgReachConstant.REACH_STYLE_MONEY){
				strShowInfo.append(orgReachVo.getSumMoney()+"元");
				}else if(orgReachVo.getReachStyle() == OrgReachConstant.REACH_STYLE_AMOUNT){
				strShowInfo.append(orgReachVo.getSumAmount()+"件");
				}
				if(orgReachConditionVo != null && orgReachConditionVo.getMapReachDiscount().containsKey(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY))){
					orgReachDiscountVo = (OrgReachDiscountVo)orgReachConditionVo.getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY));
					strShowInfo.append("（<span class=\"yellow\">已减");
					strShowInfo.append(BigDecimal.valueOf(orgReachDiscountVo.getDiscountMultiple()).multiply(orgReachDiscountVo.getCommon()));
					strShowInfo.append("</span>）");
				}
				strShowInfo.append("</div>");
				strShowInfo.append("</div>");
				//满减商品
				for(OrgCartAll orgCartAll : listCart){
					orgCart = orgCartAll.getOrgCart();
					orgProductItemAll = orgCartAll.getOrgProductItemAll();
					orgProductItemVo = (OrgProductItemVo)orgProductItemAll.getOrgProductItem();
					orgProductItemAide = orgProductItemAll.getOrgProductItemAide();
					if(orgCartAll.getCanBuy() && orgCart.getDiscountId() == orgReachVo.getId()){
						strShowInfo.append("<div class=\"list list-have\">");
						
						strShowInfo.append("<div class=\"list-cell list-checkbox\">");
						strShowInfo.append("<input type=\"checkbox\" name=\"goodsIds\" value=\""+orgProductItemAide.getGoodsId()+"\"");
						if(orgCart.getStatus() == OrgCartConstant.STATUS_SELECT_ON){
							strShowInfo.append(" checked=\"checked\" onclick=\"selectOff('"+orgProductItemAide.getGoodsId()+"');\"");
						}else{
							strShowInfo.append(" onclick=\"selectOn('"+orgProductItemAide.getGoodsId()+"');\"");
						}
						strShowInfo.append("/>");
						strShowInfo.append("</div>");
						
						strShowInfo.append("<div class=\"list-right\">");
						
						strShowInfo.append("<div class=\"list-cell list-goods\">");
						strShowInfo.append("<div class=\"list-img\">");
						strShowInfo.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\" target=\"_blank\"><img src=\""+orgProductItemVo.getGoodsImg180()+"\"/></a>");
						strShowInfo.append("</div>");
						strShowInfo.append("<div class=\"list-name\">");
						strShowInfo.append("<a>"+orgProductItemVo.getGoodsName()+"</a>");
						strShowInfo.append("</div>");
						strShowInfo.append("</div>");
						
						strShowInfo.append("<div class=\"list-cell list-price\">");
						if(orgProductItemAide.getShowPrice() == null){
							strShowInfo.append("<p class=\"yellow\">暂无报价</p>");
						}else{
							strShowInfo.append("<p class=\"line-through\">"+orgProductItemAide.getSourcePrice()+"</p>");
							strShowInfo.append("<p class=\"yellow\">"+orgProductItemAide.getShowPrice()+"</p>");
						}
						//选择优惠
						if(MapUtils.isNotEmpty(orgCartAll.getMapDiscount())){
							strShowInfo.append("<div class=\"fixed_content\">");
							strShowInfo.append("<a class=\"shopcar_fixed_span\">促销优惠<i class=\"glyphicon glyphicon-menu-down\"></i></a>");
							strShowInfo.append("<div class=\"fixed_div\">");
							for(Map.Entry<Integer, String> entryDiscount : orgCartAll.getMapDiscount().entrySet()){
								strShowInfo.append("<div class=\"radio_list\">");
								strShowInfo.append("<input type=\"radio\" name=\"discount_"+orgProductItemAide.getGoodsId()+"\" value=\""+entryDiscount.getKey()+"\"");
								if(entryDiscount.getKey().equals(orgReachVo.getId())){
								strShowInfo.append(" class=\"oldSelect\" checked=\"checked\" ");
								}
								strShowInfo.append("/>");
								strShowInfo.append("<p>"+entryDiscount.getValue()+"</p>");
								strShowInfo.append("</div>");
							}
							//不使用优惠
							strShowInfo.append("<div class=\"radio_list\">");
							strShowInfo.append("<input type=\"radio\" name=\"discount_"+orgProductItemAide.getGoodsId()+"\" value=\"0\"");
							strShowInfo.append("/>");
							strShowInfo.append("<p>不使用优惠</p>");
							strShowInfo.append("</div>");
							
							strShowInfo.append("<div class=\"radio_confirm\">");
							strShowInfo.append("<a href=\"javascript:void(0);\" class=\"yellow_a confirm\">确定</a>");
							strShowInfo.append("<a href=\"javascript:void(0);\" class=\"cancel\">取消</a>");
							strShowInfo.append("</div>");
							
							strShowInfo.append("</div>");
							strShowInfo.append("</div>");
						}
						strShowInfo.append("</div>");
						
						strShowInfo.append("<div class=\"list-cell list-quantity\">");
						strShowInfo.append("<div class=\"qu-form\">");
						strShowInfo.append("<a class=\"a1 ");
						if(orgProductItemAide.getUserBuy() == 1){
						strShowInfo.append("remove");
						}
						strShowInfo.append("\" href=\"javascript:void(0);\" name=\"amountMinus\">-</a>");
						strShowInfo.append("<input type=\"text\" name=\"amount\" value=\""+orgProductItemAide.getUserBuy()+"\" data-old=\""+orgProductItemAide.getUserBuy()+"\" data-buy-max=\""+orgProductItemAide.getUserBuyMax()+"\" data-inventory-num=\""+orgProductItemAll.getOrgProductInventory().getShopAmount()+"\"/>");
						strShowInfo.append("<a class=\"a2\" href=\"javascript:void(0);\" name=\"amountPlus\">+</a>");
						strShowInfo.append("</div>");
						strShowInfo.append("<div class=\"quantity-text\">");
						if(orgProductItemAide.getUserBuyMax() != orgProductItemAll.getOrgProductInventory().getShopAmount()){
							strShowInfo.append("限购"+orgProductItemAide.getUserBuyMax()+"件");
						}else if(orgProductItemAide.getUserBuy() > orgProductItemAll.getOrgProductInventory().getShopAmount()){
							strShowInfo.append("剩余"+orgProductItemAll.getOrgProductInventory().getShopAmount()+"件");
						}else if(orgProductItemAll.getOrgProductInventory().getShopAmount() < 6){
							strShowInfo.append("剩余"+orgProductItemAll.getOrgProductInventory().getShopAmount()+"件");
						}
						strShowInfo.append("</div>");
						strShowInfo.append("</div>");
						
						strShowInfo.append("<div class=\"list-cell list-youhui\">");
						if(!orgProductItemAide.getMarkLimitTimeDiscount()){
							strShowInfo.append("<p>-</p>");
						}else if(orgProductItemAide.getMarkLimitTimeDiscount()){
							strShowInfo.append("<p><span class=\"price1\">"+((OrgLimitTimeGoodsVo)orgProductItemAll.getOrgLimitTimeGoods()).getGoodsTitle()+"</span></p>");
						}else if(((OrgLimitTimeGoodsVo)orgProductItemAll.getOrgLimitTimeGoods()).getOrgLimitTimeDiscount().getCheckPhone() == 1 && orgUsersSession.isLogin() && StringUtils.isBlank(orgUsersSession.getOrgUsers().getMobilePhone())){
							strShowInfo.append("<p><span class='red'>手机会员专享</span></p>");
						}
						strShowInfo.append("</div>");
						
						strShowInfo.append("<div class=\"list-cell list-sum\">");
						if(orgProductItemAide.getShowPrice() == null){
							strShowInfo.append("<p class=\"yellow\">-</p>");
						}else{
							strShowInfo.append("<p>"+orgProductItemAide.getShowPrice().multiply(BigDecimal.valueOf(orgProductItemAide.getUserBuy()))+"</p>");
						}
						strShowInfo.append("</div>");
						
						strShowInfo.append("<div class=\"list-cell list-action\">");
						strShowInfo.append("<a href=\"javascript:del('"+orgProductItemAide.getGoodsId()+"');\" name=\"del\">删除</a>");
						strShowInfo.append("</div>");
						
						strShowInfo.append("</div>");
						strShowInfo.append("<div class=\"clear\"></div>");
						
						strShowInfo.append("</div>");
					}
				}
				
				if(orgReachConditionVo != null && orgReachConditionVo.getMapReachDiscount().containsKey(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY))){
					orgReachDiscountVo = (OrgReachDiscountVo)orgReachConditionVo.getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_MONEY));
					selectMoney = selectMoney.subtract(orgReachDiscountVo.getBalance());
				}
				
				if(orgReachConditionVo != null && orgReachConditionVo.getMapReachDiscount().containsKey(Long.valueOf(OrgReachDiscountConstant.TYPE_GIVE))){
					orgReachDiscountVo = (OrgReachDiscountVo)orgReachConditionVo.getMapReachDiscount().get(Long.valueOf(OrgReachDiscountConstant.TYPE_GIVE));
					for(OrgProductItem itemGive : orgReachDiscountVo.getListReachGive()){
						orgProductItemVo = (OrgProductItemVo)itemGive;
						strShowInfo.append("<div class=\"list_bottom\">");
						strShowInfo.append("<div class=\"l_bottom_left\">赠品："+orgProductItemVo.getGoodsName()+"</div>");
						strShowInfo.append("<div class=\"l_bottom_right\"><span>X"+orgProductItemVo.getGiveAmount()+"</span></div>");
						strShowInfo.append("</div>");
					}
				}
				strShowInfo.append("</div>");
			}
			
			//商品
			StringBuilder strShowInfoNoReach = new StringBuilder();
			//可买商品
			for(OrgCartAll orgCartAll : listCart){
				orgCart = orgCartAll.getOrgCart();
				orgProductItemAll = orgCartAll.getOrgProductItemAll();
				orgProductItemVo = (OrgProductItemVo)orgProductItemAll.getOrgProductItem();
				orgProductItemAide = orgProductItemAll.getOrgProductItemAide();
				if(orgCartAll.getCanBuy() && (orgCart.getDiscountId() == null || orgCart.getDiscountId() == 0 || !mapReach.containsKey(orgCart.getDiscountId()))){
					strShowInfoNoReach.append("<div class=\"list list-have\">");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-checkbox\">");
					strShowInfoNoReach.append("<input type=\"checkbox\" name=\"goodsIds\" value=\""+orgProductItemAide.getGoodsId()+"\"");
					if(orgCart.getStatus() == OrgCartConstant.STATUS_SELECT_ON){
						strShowInfoNoReach.append(" checked=\"checked\" onclick=\"selectOff('"+orgProductItemAide.getGoodsId()+"');\"");
					}else{
						strShowInfoNoReach.append(" onclick=\"selectOn('"+orgProductItemAide.getGoodsId()+"');\"");
					}
					strShowInfoNoReach.append("/>");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-right\">");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-goods\">");
					strShowInfoNoReach.append("<div class=\"list-img\">");
					strShowInfoNoReach.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\" target=\"_blank\"><img src=\""+orgProductItemVo.getGoodsImg180()+"\"/></a>");
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("<div class=\"list-name\">");
					strShowInfoNoReach.append("<a>"+orgProductItemVo.getGoodsName()+"</a>");
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-price\">");
					if(orgProductItemAide.getShowPrice() == null){
						strShowInfoNoReach.append("<p class=\"yellow\">暂无报价</p>");
					}else{
						strShowInfoNoReach.append("<p class=\"line-through\">"+orgProductItemAide.getSourcePrice()+"</p>");
						strShowInfoNoReach.append("<p class=\"yellow\">"+orgProductItemAide.getShowPrice()+"</p>");
					}
					//选择优惠
					if(MapUtils.isNotEmpty(orgCartAll.getMapDiscount())){
						strShowInfoNoReach.append("<div class=\"fixed_content\">");
						strShowInfoNoReach.append("<a class=\"shopcar_fixed_span\">促销优惠<i class=\"glyphicon glyphicon-menu-down\"></i></a>");
						strShowInfoNoReach.append("<div class=\"fixed_div\">");
						
						//不使用优惠
						strShowInfoNoReach.append("<div class=\"radio_list\">");
						strShowInfoNoReach.append("<input type=\"radio\" name=\"discount_"+orgProductItemAide.getGoodsId()+"\" value=\"0\" class=\"oldSelect\" checked=\"checked\"");
						strShowInfoNoReach.append("/>");
						strShowInfoNoReach.append("<p>不使用优惠</p>");
						strShowInfoNoReach.append("</div>");
						
						for(Map.Entry<Integer, String> entryDiscount : orgCartAll.getMapDiscount().entrySet()){
							strShowInfoNoReach.append("<div class=\"radio_list\">");
							strShowInfoNoReach.append("<input type=\"radio\" name=\"discount_"+orgProductItemAide.getGoodsId()+"\" value=\""+entryDiscount.getKey()+"\"");
							strShowInfoNoReach.append("/>");
							strShowInfoNoReach.append("<p>"+entryDiscount.getValue()+"</p>");
							strShowInfoNoReach.append("</div>");
						}
						
						strShowInfoNoReach.append("<div class=\"radio_confirm\">");
						strShowInfoNoReach.append("<a href=\"javascript:void(0);\" class=\"yellow_a confirm\">确定</a>");
						strShowInfoNoReach.append("<a href=\"javascript:void(0);\" class=\"cancel\">取消</a>");
						strShowInfoNoReach.append("</div>");
						
						strShowInfoNoReach.append("</div>");
						strShowInfoNoReach.append("</div>");
					}
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-quantity\">");
					strShowInfoNoReach.append("<div class=\"qu-form\">");
					strShowInfoNoReach.append("<a class=\"a1 ");
					if(orgProductItemAide.getUserBuy() == 1){
					strShowInfoNoReach.append("remove");
					}
					strShowInfoNoReach.append("\" href=\"javascript:void(0);\" name=\"amountMinus\">-</a>");
					strShowInfoNoReach.append("<input type=\"text\" name=\"amount\" value=\""+orgProductItemAide.getUserBuy()+"\" data-old=\""+orgProductItemAide.getUserBuy()+"\" data-buy-max=\""+orgProductItemAide.getUserBuyMax()+"\" data-inventory-num=\""+orgProductItemAll.getOrgProductInventory().getShopAmount()+"\"/>");
					strShowInfoNoReach.append("<a class=\"a2\" href=\"javascript:void(0);\" name=\"amountPlus\">+</a>");
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("<div class=\"quantity-text\">");
					if(orgProductItemAide.getUserBuyMax() != orgProductItemAll.getOrgProductInventory().getShopAmount()){
						strShowInfoNoReach.append("限购"+orgProductItemAide.getUserBuyMax()+"件");
					}else if(orgProductItemAide.getUserBuy() > orgProductItemAll.getOrgProductInventory().getShopAmount()){
						strShowInfoNoReach.append("剩余"+orgProductItemAll.getOrgProductInventory().getShopAmount()+"件");
					}else if(orgProductItemAll.getOrgProductInventory().getShopAmount() < 6){
						strShowInfoNoReach.append("剩余"+orgProductItemAll.getOrgProductInventory().getShopAmount()+"件");
					}
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-youhui\">");
					if(!orgProductItemAide.getMarkLimitTimeDiscount()){
						strShowInfoNoReach.append("<p>-</p>");
					}else if(orgProductItemAide.getMarkLimitTimeDiscount()){
						strShowInfoNoReach.append("<p><span class=\"price1\">"+((OrgLimitTimeGoodsVo)orgProductItemAll.getOrgLimitTimeGoods()).getGoodsTitle()+"</span></p>");
					}else if(((OrgLimitTimeGoodsVo)orgProductItemAll.getOrgLimitTimeGoods()).getOrgLimitTimeDiscount().getCheckPhone() == 1 && orgUsersSession.isLogin() && StringUtils.isBlank(orgUsersSession.getOrgUsers().getMobilePhone())){
						strShowInfoNoReach.append("<p><span class='red'>手机会员专享</span></p>");
					}
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-sum\">");
					if(orgProductItemAide.getShowPrice() == null){
						strShowInfoNoReach.append("<p class=\"yellow\">-</p>");
					}else{
						strShowInfoNoReach.append("<p>"+orgProductItemAide.getShowPrice().multiply(BigDecimal.valueOf(orgProductItemAide.getUserBuy()))+"</p>");
					}
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-action\">");
					strShowInfoNoReach.append("<a href=\"javascript:del('"+orgProductItemAide.getGoodsId()+"');\" name=\"del\">删除</a>");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("<div class=\"clear\"></div>");
					
					strShowInfoNoReach.append("</div>");
				}
			}
			//不可买商品
			for(OrgCartAll orgCartAll : listCart){
				orgCart = orgCartAll.getOrgCart();
				orgProductItemAll = orgCartAll.getOrgProductItemAll();
				orgProductItemVo = (OrgProductItemVo)orgProductItemAll.getOrgProductItem();
				orgProductItemAide = orgProductItemAll.getOrgProductItemAide();
				if(!orgCartAll.getCanBuy()){
					strShowInfoNoReach.append("<div class=\"list\">");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-checkbox\">");
					strShowInfoNoReach.append("<input type=\"checkbox\" name=\"goodsIds\" disabled=\"disabled\" value=\""+orgProductItemAide.getGoodsId()+"\"");
					strShowInfoNoReach.append("/>");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-right\">");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-goods\">");
					strShowInfoNoReach.append("<div class=\"list-img\">");
					strShowInfoNoReach.append("<a href=\""+basePath+"/item/"+orgProductItemAide.getGoodsId()+"\" target=\"_blank\"><img src=\""+orgProductItemVo.getGoodsImg180()+"\"/></a>");
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("<div class=\"list-name\">");
					strShowInfoNoReach.append("<a>"+orgProductItemVo.getGoodsName()+"</a>");
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-price\">");
					if(orgProductItemAide.getShowPrice() == null){
						strShowInfoNoReach.append("<p class=\"yellow\">暂无报价</p>");
					}else{
						strShowInfoNoReach.append("<p class=\"line-through\">"+orgProductItemAide.getSourcePrice()+"</p>");
						strShowInfoNoReach.append("<p class=\"yellow\">"+orgProductItemAide.getShowPrice()+"</p>");
					}
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-quantity\">");
					strShowInfoNoReach.append("<div class=\"quantity-text\">");
					OrgProductInventoryVo inventoryVo=(OrgProductInventoryVo) orgProductItemAll.getOrgProductInventory();
					if(orgProductItemVo.getIsDelete() == OrgProductItemConstant.STAUTS_DELETE){
						strShowInfoNoReach.append("对不起，此商品已移除");
					}else if(orgProductItemVo.getProductIsOnSale() == OrgProductConstant.IS_ON_SALE_OFF){
						strShowInfoNoReach.append("对不起，此商品已下架");
					}else if(orgProductItemAide.getUserBuyMax() != orgProductItemAll.getOrgProductInventory().getShopAmount()){
						strShowInfoNoReach.append("对不起，此商品限购");
					}else if(orgProductItemAll.getOrgProductInventory().getShopAmount() == 0){
						strShowInfoNoReach.append("对不起，此商品已无货");
					}else if(inventoryVo.getStatus()==null || inventoryVo.getStatus()==OrgProductShopSaleConstant.OFF_SALE){
						strShowInfoNoReach.append("对不起，此商品已下架");
					}
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-youhui\">");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-sum\">");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("<div class=\"list-cell list-action\">");
					strShowInfoNoReach.append("<a href=\"javascript:del('"+orgProductItemAide.getGoodsId()+"');\" name=\"del\">删除</a>");
					strShowInfoNoReach.append("</div>");
					
					strShowInfoNoReach.append("</div>");
					strShowInfoNoReach.append("<div class=\"clear\"></div>");
					
					strShowInfoNoReach.append("</div>");
				}
			}
			
			//判断是否有单独商品
			if(strShowInfoNoReach.length() > 0){
				strShowInfo.append("<div class=\"car-list\">");
				strShowInfo.append(strShowInfoNoReach);
				strShowInfo.append("</div>");
			}
			
			strShowInfo.append("</div>");
			
			//底栏
			strShowInfo.append("<div  class=\"car-footer\">");
			
			strShowInfo.append("<div class=\"c-checkbox left\">");
			strShowInfo.append("<input type=\"checkbox\" data-name=\"checkAll\"");
			if(isSelectAll){
				strShowInfo.append(" checked=\"checked\" onclick=\"selectAllOff();\"");
			}else{
				strShowInfo.append(" onclick=\"selectAllOn();\"");
			}
			strShowInfo.append("/>全选");
			strShowInfo.append("</div>");
			
			strShowInfo.append("<div class=\"car-option left\">");
			strShowInfo.append("<a href=\"javascript:delSelect();\">批量删除</a>");
			strShowInfo.append("</div>");
			
			strShowInfo.append("<div class=\"car-footer-right\">");
			strShowInfo.append("<div class=\"priceall\">");
			strShowInfo.append("<p>您选择了 <span class='yellow'>"+selectAmount+"</span> 件商品，费用总计：<span class='yellow'>￥"+selectMoney+"</span></p>");
			strShowInfo.append("</div> ");
			if(selectAmount == 0){
				strShowInfo.append("<button type=\"submit\" class=\"btn btn-disabled\" id=\"buttonPay\" disabled=\"disabled\">去结算</button>");
			}else{
				strShowInfo.append("<button type=\"submit\" class=\"btn btn-danger\" id=\"buttonPay\">去结算</button>");
			}
			strShowInfo.append("</div>");
			
			strShowInfo.append("</div>");
		}
		return strShowInfo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxList", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> ajaxList(HttpSession session){
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		List<OrgCartAll> listCart = orgCartService.queryList4View(orgUsersSession);
		
		//自动修改购物车超量商品数量
		orgCartService.updateAmount4Over(orgUsersSession,listCart);
		
		//数量
		session.setAttribute(SessionConstant.SESSION_CART_COUNT,orgCartService.getCountByUser(orgUsersSession));
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("listCart", listCart);
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectDiscount", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> selectDiscount(HttpSession session, HttpServletRequest request,OrgCart orgCart){
		Map<String,Object> mapResult = new HashMap<String,Object>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgCartService.update(orgUsersSession,orgCart);
		mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
		mapResult.put("showInfo", getShowInfo(session,request));
		return mapResult;
	}
}
