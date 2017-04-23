package com.kjj.mobile.web.controller.goods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;
import com.kjj.commserver.entity.goods.aide.OrgProductDetailAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkSalespecQuery;
import com.kjj.commserver.entity.order.OrgGoodsComment;
import com.kjj.commserver.entity.order.aide.OrgGoodsCommentConstant;
import com.kjj.commserver.entity.order.aide.OrgGoodsCommentQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.consult.OrgConsultAnswerService;
import com.kjj.commserver.service.consult.OrgConsultProblemService;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.commserver.service.discount.OrgLimitTimeGoodsService;
import com.kjj.commserver.service.discount.OrgReachService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.goods.OrgProductLinkSalespecService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.order.OrgGoodsCommentService;
import com.kjj.commserver.util.DateUtil;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Resource
	private OrgProductItemService orgProductItemService;
	
	@Resource
	private OrgCartService orgCartService;
	
	@Resource
	private OrgConsultProblemService orgConsultProblemService;
	
	@Resource
	private OrgConsultAnswerService orgConsultAnswerService;
	
	@Resource
	private OrgGoodsCommentService orgGoodsCommentService;
	
	@Resource
	private OrgProductLinkSalespecService orgProductLinkSalespecService;
	
	@Resource
	OrgLimitTimeGoodsService orgLimitTimeGoodsService;
	
	@Resource
	OrgReachService orgReachService;
	
	@Resource
	OrgDiscountAllowService orgDiscountAllowService;
	
	@RequestMapping(value="/{goodsId}",method={RequestMethod.GET,RequestMethod.POST})
	public String detail(Model model,HttpSession session,OrgProductLinkSalespecQuery query){
		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		OrgProductItem item = orgProductItemService.queryById(query.getGoodsId());
		if(item == null){
			return "redirect:/400";
		}
		//此sku已删除，则根据goodSn去获取最新的sku，若获取不到，则以下架形式展示
		if(item.getIsDelete()==OrgProductItemConstant.STAUTS_DELETE){
			OrgProductItemQuery orgProductItemQuery=new OrgProductItemQuery();
			orgProductItemQuery.setGoodsSn(item.getGoodsSn());
			orgProductItemQuery.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
			OrgProductItem itemNew = orgProductItemService.queryOne(orgProductItemQuery);
			if(itemNew!=null){
				query.setGoodsId(itemNew.getGoodsId());
			}
		}
		OrgProductItemAll orgProductItemAll = orgProductItemService.query4View(orgUsersSession,query.getGoodsId());
		OrgProductDetailAll orgProductDetailAll = orgProductItemService.queryDetail4View(query.getGoodsId());
		model.addAttribute("query", query);
		model.addAttribute("orgProductItemAll", orgProductItemAll);
		model.addAttribute("orgProductDetailAll", orgProductDetailAll);
		//限时折扣结束时长
		Long limitTimeEndiInterval = getLimitTimeEndiInterval(orgProductItemAll);
		model.addAttribute("limitTimeEndiInterval", limitTimeEndiInterval);
		//折扣开始倒计时
		Collection<Integer> goodsIds = new ArrayList<Integer>();
		goodsIds.add(query.getGoodsId());
		Map<Integer, List<OrgLimitTimeGoods>> map = orgLimitTimeGoodsService.getLimitTimeGoodsByGoodsIds(orgUsersSession, goodsIds);
		if(CollectionUtils.isNotEmpty(map.get(query.getGoodsId()))){
			Map<Integer, Long> countDownMap = orgLimitTimeGoodsService.getCountDownBeforeAcivity(goodsIds, map,orgProductItemAll.getOrgProductItemAide().getMarkLimitTimeDiscount());
			model.addAttribute("LimitTimeGood", map.get(query.getGoodsId()).get(0));
			model.addAttribute("countDown", countDownMap.get(query.getGoodsId()));			
		}
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
			List<OrgReach> orgReachList = orgReachService.queryList4Item(orgUsersSession,query.getGoodsId());
			model.addAttribute("orgReachList", orgReachList);
		}else{
			model.addAttribute("orgReachList", "");
		}
		return "/item/detail";
	}
	
	/**
	 * 限时折扣结束时长
	 * @param orgProductItemAll
	 * @return
	 */
	private Long getLimitTimeEndiInterval(OrgProductItemAll orgProductItemAll){
		Long interval = null;
		if(orgProductItemAll.getOrgProductItemAide().getMarkLimitTimeDiscount()){
			Date endTime = ((OrgLimitTimeGoodsVo)(orgProductItemAll.getOrgLimitTimeGoods())).getOrgLimitTimeDiscount().getEndTime();
			interval = DateUtil.getTimeInterval(DateUtil.getDateByTime(endTime),((OrgLimitTimeGoodsVo)(orgProductItemAll.getOrgLimitTimeGoods())).getDbDate());
		}
		return interval;
	}
	
	@RequestMapping(value="/introduce/{goodsId}",method={RequestMethod.GET,RequestMethod.POST})
	public String introduce(Model model, OrgProductLinkSalespecQuery query){
		OrgProductDetailAll orgProductDetailAll = orgProductItemService.queryDetail4View(query.getGoodsId());
		model.addAttribute("query", query);
		model.addAttribute("orgProductDetailAll", orgProductDetailAll);
		return "/item/introduce";
	}
	
	@RequestMapping(value="/comment/{goodsId}",method={RequestMethod.GET,RequestMethod.POST})
	public String comment(Model model, OrgGoodsCommentQuery query){
		Sort sort=new Sort(Direction.DESC,"t.create_time");
		query.setStatus(OrgGoodsCommentConstant.STATUS_SHOW);
		List<OrgGoodsComment> orgGoodsCommentList = orgGoodsCommentService.queryList(query,sort);
		List<OrgProductLinkSalespec> orgProductLinkItemSalespecList=new ArrayList<OrgProductLinkSalespec>();
		orgProductLinkItemSalespecList = orgProductLinkSalespecService.getSpecGroupByItemId(query.getGoodsId());
		orgProductItemService.initSaleSpecAll(orgProductLinkItemSalespecList);
		model.addAttribute("query", query);
		OrgProductItem orgProductItem = orgProductItemService.queryVoById(query.getGoodsId());
		model.addAttribute("orgProductItem", orgProductItem);	
		model.addAttribute("orgGoodsCommentList", orgGoodsCommentList);	
		model.addAttribute("orgProductLinkItemSalespecList", orgProductLinkItemSalespecList);	
		return "/item/comment";
	}
		
	@RequestMapping(value="/consult/{goodsId}",method={RequestMethod.GET,RequestMethod.POST})
	public String consult(Model model, OrgConsultProblemQuery query){
		Sort sort=new Sort(Direction.DESC,"t.create_time");
		//商品咨询
		query.setIsActive(OrgConsultProblemConstant.CONSULT_ACTIVE_YES);
		query.setIsDelete(OrgConsultProblemConstant.CONSULT_DELETE_NO);
		query.setConsultClassId(OrgConsultClassConstant.CONSULT_CLASS_ITEM);
		 List<OrgConsultProblem> orgConsultProblemList = orgConsultProblemService.queryList(query, sort);
		 for (OrgConsultProblem orgConsultProblem : orgConsultProblemList) {
			 OrgConsultProblemVo orgConsultProblemVo=(OrgConsultProblemVo) orgConsultProblem;
			 OrgConsultAnswerQuery orgConsultAnswerQuery=new OrgConsultAnswerQuery();
			 orgConsultAnswerQuery.setConsultProblemId(orgConsultProblem.getConsultProblemId());
			 List<OrgConsultAnswer> listOrgConsultAnswer = orgConsultAnswerService.queryList(orgConsultAnswerQuery);
			 orgConsultProblemVo.setListOrgConsultAnswer(listOrgConsultAnswer);
		}
		OrgProductItem orgProductItem = orgProductItemService.queryVoById(query.getGoodsId());
		model.addAttribute("orgProductItem", orgProductItem);	
		model.addAttribute("query", query);
		model.addAttribute("orgConsultProblemList", orgConsultProblemList);		
		return "/item/consult";
	}
}
