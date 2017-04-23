package com.kjj.mobile.web.controller.discount;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordQuery;
import com.kjj.commserver.entity.discount.aide.OrgCouponRecordVo;
import com.kjj.commserver.entity.discount.aide.OrgCouponVo;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountProductVo;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopConstant;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopQuery;
import com.kjj.commserver.entity.discount.aide.OrgDiscountShopVo;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTypeConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderForm;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgCouponRecordService;
import com.kjj.commserver.service.discount.OrgDiscountProductService;
import com.kjj.commserver.service.discount.OrgDiscountShopService;
import com.kjj.mobile.constant.SessionConstant;


@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	@Resource
	private OrgCouponRecordService orgCouponRecordService;
	@Resource
	private OrgDiscountShopService orgDiscountShopService;
	@Resource
	private OrgDiscountProductService orgDiscountProductService;
	
	@RequestMapping(value = "/select", method = { RequestMethod.GET,RequestMethod.POST })
	public String selectCouponRecord(HttpSession session,OrgOrderForm orgOrderForm){
		OrgOrderForm orderFormSession  = (OrgOrderForm)session.getAttribute(SessionConstant.SESSION_ORDER_FORM);
		//session失效
		if(orderFormSession == null ){
			return "redirect:/cart/list";
		}
		if(orgOrderForm != null){
			orderFormSession.setTakeDate(orgOrderForm.getTakeDate());
			orderFormSession.setSendDate(orgOrderForm.getSendDate());
			orderFormSession.setSendTimeStart(orgOrderForm.getSendTimeStart());
			orderFormSession.setSendTimeEnd(orgOrderForm.getSendTimeEnd());
			orderFormSession.setConsigneeMobile(orgOrderForm.getConsigneeMobile());
			orderFormSession.setPayStyle(orgOrderForm.getPayStyle());
			orderFormSession.setUseDeposit(orgOrderForm.getUseDeposit());
			orderFormSession.setRemark(orgOrderForm.getRemark());
			
			// 填充优惠券信息
			List<OrgCouponRecord> list = orderFormSession.getListCouponRecord();

			OrgDiscountShopQuery orgDiscountShopQuery = new OrgDiscountShopQuery();
			orgDiscountShopQuery.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
			
			OrgDiscountProductQuery orgDiscountProductQuery = new OrgDiscountProductQuery();
			orgDiscountProductQuery.setTypeId(OrgDiscountTypeConstant.TYPE_COUPON);
			Byte shopType = null;
			Byte productType = null;
			for (OrgCouponRecord orgCouponRecord : list) {
				List<String> shopNames = new ArrayList<String>();
				List<String> classNames = new ArrayList<String>();
				OrgCouponRecordVo orgCouponRecordVo = (OrgCouponRecordVo) orgCouponRecord;
				OrgCouponVo orgCouponVo = (OrgCouponVo) orgCouponRecordVo.getOrgCoupon();
				if(orgCouponVo != null){
					shopType = orgCouponVo.getShopType();
					if(shopType.equals(OrgDiscountShopConstant.SHOP_TYPE_SHOP)){
						orgDiscountShopQuery.setDiscountId(orgCouponRecord.getCouponId());
						List<OrgDiscountShopVo> OrgDiscountShopVoList = orgDiscountShopService.queryList(orgDiscountShopQuery);
						for (OrgDiscountShopVo orgDiscountShopVo : OrgDiscountShopVoList) {
							shopNames.add(orgDiscountShopVo.getShopName());
						}
						orgCouponVo.setShopNames(shopNames);
					}
					productType = orgCouponVo.getProductType();
					if(productType.equals(OrgDiscountShopConstant.PRODUCT_TYPE_CLASS)){
						orgDiscountProductQuery.setDiscountId(orgCouponRecord.getCouponId());
						List<OrgDiscountProductVo> orgDiscountProductVoList = orgDiscountProductService.queryList(orgDiscountProductQuery);
						for(OrgDiscountProductVo orgDiscountProductVo : orgDiscountProductVoList){
							classNames.add(orgDiscountProductVo.getClassName());
						}
						orgCouponVo.setClassNames(classNames);
					}
				}
			}
		}
		
		
		session.setAttribute(SessionConstant.SESSION_ORDER_FORM,orderFormSession);
		return "coupon/select";
	}
	
	@RequestMapping(value = {"/list","/welist"}, method = { RequestMethod.GET,RequestMethod.POST })
	public String selectCouponRecordList(Model model,HttpSession session,OrgCouponRecordQuery query){
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		query.setUserId(user.getOrgUsers().getUserId());
		if(query.getStatusCanUse() == null){
			query.setStatusCanUse(true); 
		}
		long countCanUse = orgCouponRecordService.queryCountCanUseByUserId(user.getOrgUsers().getUserId());
		long countCanNotUse = orgCouponRecordService.queryCountCanNotUseByUserId(user.getOrgUsers().getUserId());
		List<OrgCouponRecord> list = orgCouponRecordService.queryListWithShop(query);
		model.addAttribute("list", list);
		model.addAttribute("countCanUse", countCanUse);
		model.addAttribute("countCanNotUse", countCanNotUse);
		model.addAttribute("query", query);
		return "coupon/list";		
	}
	
	
}
