package com.kjj.pc.web.controller.goods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.consult.OrgConsultAnswer;
import com.kjj.commserver.entity.consult.OrgConsultProblem;
import com.kjj.commserver.entity.consult.aide.OrgConsultAnswerQuery;
import com.kjj.commserver.entity.consult.aide.OrgConsultClassConstant;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemConstant;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemQuery;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemVo;
import com.kjj.commserver.entity.discount.OrgDiscountAllow;
import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.discount.aide.OrgDiscountAllowQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.discount.aide.OrgLimitTimeGoodsVo;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductDetailAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkSalespecQuery;
import com.kjj.commserver.entity.order.OrgGoodsComment;
import com.kjj.commserver.entity.order.aide.OrgGoodsCommentConstant;
import com.kjj.commserver.entity.order.aide.OrgGoodsCommentQuery;
import com.kjj.commserver.entity.shop.OrgShopService;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.consult.OrgConsultAnswerService;
import com.kjj.commserver.service.consult.OrgConsultProblemService;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.commserver.service.discount.OrgLimitTimeGoodsService;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.order.OrgGoodsCommentService;
import com.kjj.commserver.service.shop.OrgShopServiceService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.DateUtil;
import com.kjj.pc.constant.CookieConstant;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.CookieUtil;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Resource
	OrgProductItemService orgProductItemService;
	
	@Resource
	OrgUsersService orgUsersService;
	
	@Resource
	OrgConsultProblemService orgConsultProblemService;
	
	@Resource
	OrgConsultAnswerService orgConsultAnswerService;

	@Resource
	OrgShopServiceService orgShopServiceService;
	
	@Resource
	OrgClassService orgClassService;
	
	@Resource
	OrgGoodsCommentService orgGoodsCommentService;
	
	@Resource
	OrgLimitTimeGoodsService orgLimitTimeGoodsService;
	
	@Resource
	OrgReachService orgReachService;
	
	@Resource
	OrgDiscountAllowService orgDiscountAllowService;
	
	@RequestMapping(value="/{goodsId}",method={RequestMethod.GET,RequestMethod.POST})
	public String detail(Model model,HttpSession session,HttpServletRequest request, HttpServletResponse response,
			OrgProductLinkSalespecQuery orgProductLinkSalespecQuery,
			OrgConsultProblemQuery orgConsultProblemquery, OrgGoodsCommentQuery orgGoodsCommentQuery ,PageReq pageReq){
		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		//此sku已删除，则根据goodSn去获取最新的sku，若获取不到，则以下架形式展示
		OrgProductItem orgProductItem = orgProductItemService.queryVoById(orgProductLinkSalespecQuery.getGoodsId());
		if(orgProductItem.getIsDelete()==OrgProductItemConstant.STAUTS_DELETE){
			OrgProductItemQuery query=new OrgProductItemQuery();
			query.setGoodsSn(orgProductItem.getGoodsSn());
			query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
			OrgProductItem itemNew = orgProductItemService.queryOne(query);
			if(itemNew!=null){
				orgProductLinkSalespecQuery.setGoodsId(itemNew.getGoodsId());
				orgConsultProblemquery.setGoodsId(itemNew.getGoodsId());
				orgGoodsCommentQuery.setGoodsId(itemNew.getGoodsId());
			}
		}
		
		addRecentItems(request, response, orgProductLinkSalespecQuery.getGoodsId());
		
		// 获取该商店信息
		if (orgUsersSession != null && orgUsersSession.getOrgShop() != null) {
		    //服务
		    List<OrgShopService> listShopService = orgShopServiceService.queryListByShopId(orgUsersSession.getOrgShop().getShopId());
		    model.addAttribute("listShopService", listShopService);
		}
		//分类信息
	    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    model.addAttribute("listClass", listClass);
		//商品信息
		OrgProductItemAll orgProductItemAll = orgProductItemService.query4View(orgUsersSession,orgProductLinkSalespecQuery.getGoodsId());
		OrgProductDetailAll orgProductDetailAll = orgProductItemService.queryDetail4View(orgProductLinkSalespecQuery.getGoodsId());
		model.addAttribute("orgProductLinkSalespecQuery", orgProductLinkSalespecQuery);
		model.addAttribute("orgProductItemAll", orgProductItemAll);
		model.addAttribute("orgProductDetailAll", orgProductDetailAll);
		//限时折扣结束时长
		Long limitTimeEndiInterval = getLimitTimeEndiInterval(orgProductItemAll);
		model.addAttribute("limitTimeEndiInterval", limitTimeEndiInterval);
		//折扣开始倒计时
		Collection<Integer> goodsIds = new ArrayList<Integer>();
		goodsIds.add(orgProductLinkSalespecQuery.getGoodsId());
		Map<Integer, List<OrgLimitTimeGoods>> map = orgLimitTimeGoodsService.getLimitTimeGoodsByGoodsIds(orgUsersSession, goodsIds);
		if(CollectionUtils.isNotEmpty(map.get(orgProductLinkSalespecQuery.getGoodsId()))){
			Map<Integer, Long> countDownMap = orgLimitTimeGoodsService.getCountDownBeforeAcivity(goodsIds, map,orgProductItemAll.getOrgProductItemAide().getMarkLimitTimeDiscount());
			model.addAttribute("LimitTimeGood", map.get(orgProductLinkSalespecQuery.getGoodsId()).get(0));
			model.addAttribute("countDown", countDownMap.get(orgProductLinkSalespecQuery.getGoodsId()));			
		}
		
		//商品咨询
		Sort sort=new Sort(Direction.DESC,"t.create_time");
		PageReq consultPageReq=new PageReq();
		consultPageReq.setSort(sort);
		orgConsultProblemquery.setIsActive(OrgConsultProblemConstant.CONSULT_ACTIVE_YES);
		orgConsultProblemquery.setIsDelete(OrgConsultProblemConstant.CONSULT_DELETE_NO);
		orgConsultProblemquery.setConsultClassId(OrgConsultClassConstant.CONSULT_CLASS_ITEM);
		Page<OrgConsultProblem> orgConsultProblemPage = orgConsultProblemService.queryPageList(orgConsultProblemquery, consultPageReq);
		 for (OrgConsultProblem orgConsultProblem : orgConsultProblemPage) {
			 OrgConsultProblemVo orgConsultProblemVo=(OrgConsultProblemVo) orgConsultProblem;
			 OrgConsultAnswerQuery orgConsultAnswerQuery=new OrgConsultAnswerQuery();
			 orgConsultAnswerQuery.setConsultProblemId(orgConsultProblem.getConsultProblemId());
			 List<OrgConsultAnswer> listOrgConsultAnswer = orgConsultAnswerService.queryList(orgConsultAnswerQuery);
			 orgConsultProblemVo.setListOrgConsultAnswer(listOrgConsultAnswer);
			 OrgUsers createUser = orgUsersService.queryById(orgConsultProblem.getCreateUser());
			 orgConsultProblemVo.setCreateUserName(createUser==null? "":createUser.getUserName());
		}
		model.addAttribute("orgConsultProblemPage", orgConsultProblemPage);	
		pageReq.setSort(sort);
		//商品评价
		orgGoodsCommentQuery.setStatus(OrgGoodsCommentConstant.STATUS_SHOW);//已隐藏的评价不显示
		Page<OrgGoodsComment> orgGoodsCommentPage = orgGoodsCommentService.queryPageList(orgGoodsCommentQuery, pageReq);
		double averageStarScore = orgGoodsCommentService.queryAverageStarScore(orgGoodsCommentQuery);
		model.addAttribute("orgGoodsCommentQuery", orgGoodsCommentQuery);
		model.addAttribute("orgGoodsCommentPage", orgGoodsCommentPage);	
		model.addAttribute("averageStarScore", averageStarScore);
		//满减满送
		Boolean reachFlg=false;
		OrgDiscountAllowQuery orgDiscountAllowQuery = new OrgDiscountAllowQuery();
		if(orgProductItemAll.getOrgLimitTimeGoods()!=null){
			orgDiscountAllowQuery.setDiscountId(orgProductItemAll.getOrgLimitTimeGoods().getLtdId());
			List<OrgDiscountAllow> OrgDiscountAllowList = orgDiscountAllowService.queryList(orgDiscountAllowQuery);
			for (OrgDiscountAllow orgDiscountAllow : OrgDiscountAllowList) {
				if( orgDiscountAllow.getAllowTypeId().equals(OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT)){
					reachFlg=true;
				}
			}
		}else{
			reachFlg=true;			
		}
		if(reachFlg){
			List<OrgReach> orgReachList = orgReachService.queryList4Item(orgUsersSession,orgProductLinkSalespecQuery.getGoodsId());
			model.addAttribute("orgReachList", orgReachList);
		}else{
			model.addAttribute("orgReachList", "");
		}
		return "/item/detail";
	}
	
	//商品评价分页显示
	@ResponseBody
	@RequestMapping(value="/commentAjax", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> recommend(OrgGoodsCommentQuery orgGoodsCommentQuery,PageReq pageReq) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		Sort sort=new Sort(Direction.DESC,"t.create_time");
		pageReq.setSort(sort);
		orgGoodsCommentQuery.setStatus(OrgGoodsCommentConstant.STATUS_SHOW);//已隐藏的评价不显示
		Page<OrgGoodsComment> orgGoodsCommentPage = orgGoodsCommentService.queryPageList(orgGoodsCommentQuery, pageReq);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("page",orgGoodsCommentPage);
		return result ;
	}
	
	//限时折扣(距离活动结束还有多少毫秒)
	private Long getLimitTimeEndiInterval(OrgProductItemAll orgProductItemAll){
		Long interval = null;
		if(orgProductItemAll.getOrgProductItemAide().getMarkLimitTimeDiscount()){
			Date endTime = ((OrgLimitTimeGoodsVo)(orgProductItemAll.getOrgLimitTimeGoods())).getOrgLimitTimeDiscount().getEndTime();
			interval = DateUtil.getTimeInterval(DateUtil.getDateByTime(endTime),((OrgLimitTimeGoodsVo)(orgProductItemAll.getOrgLimitTimeGoods())).getDbDate());
		}
		return interval;
	}
	
	//将最近浏览的商品Id添加到cookie
	private void addRecentItems(HttpServletRequest request, HttpServletResponse response,Integer goodsId){
		Set<String> set = null;
		StringBuffer sb = new StringBuffer();
		String str = "";
		if(goodsId != null){
			String recentItems = CookieUtil.getCookieValue(request, CookieConstant.COOKIE_USER_RECENT_ITEMS);
			 if(StringUtils.isNotEmpty(recentItems)){
				 String[] recentItemArr = recentItems.split(","); 
				 set = new LinkedHashSet<String>(Arrays.asList(recentItemArr));   			
			 }else{
				 set = new LinkedHashSet<String>();
			 }
			 set.add(goodsId+"");
			 String[] array = set.toArray(new String[] {});  
			 for(String arr : array){
				 sb.append(arr+",");
			 }
			 str=sb.toString().substring(0, sb.length()-1);
			 CookieUtil.addCookie(response, CookieConstant.COOKIE_USER_RECENT_ITEMS ,str, 86400);
		}
	}
	
}

