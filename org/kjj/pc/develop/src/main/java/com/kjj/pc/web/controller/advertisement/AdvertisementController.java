package com.kjj.pc.web.controller.advertisement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.goods.OrgAdvertisementItem;
import com.kjj.commserver.entity.goods.aide.OrgAdvertisementItemQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgAdvertisementItemService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.pc.constant.CookieConstant;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.CookieUtil;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/advertisement")
public class AdvertisementController {
	
	@Resource
	OrgAdvertisementItemService orgAdvertisementItemService;
	
	@Resource
	OrgProductItemService orgProductItemService;
	
	@ResponseBody
	@RequestMapping(value="/list", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> list(HttpServletRequest request,HttpSession session,OrgProductItemQuery query,Integer typeId,Integer showNumber) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		List<Integer> itemIds = null;
		Map<String,Object> result = new HashMap<String,Object>();
		OrgProductItemAll orgProductItemAll = null;
		List<OrgProductItemAll> itemList = new ArrayList<OrgProductItemAll>();
		if(typeId!=0){ //0 最近浏览
			OrgAdvertisementItemQuery orgAdvertisementItemQuery = new OrgAdvertisementItemQuery();
			orgAdvertisementItemQuery.setTypeId(typeId);
			if(query.getCatId()!=null){
				orgAdvertisementItemQuery.setProductClassId(query.getCatId().intValue());								
			}else{
				orgAdvertisementItemQuery.setProductClassId(-1);												
			}
			List<OrgAdvertisementItem> list = orgAdvertisementItemService.queryList(orgAdvertisementItemQuery);
			itemIds=new ArrayList<Integer>();
			for (OrgAdvertisementItem orgAdvertisementItem : list) {
				itemIds.add(orgAdvertisementItem.getProductId());
			}	
			query.setProductIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
			query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
			query.setShopCode(orgUsersSession.getOrgShop().getShopCode());
			query.setIsShowZeroInventoryFlg(true);
			query.setGoodsIds(itemIds);
			PageReq pageReq=new PageReq();
			pageReq.setPageSize(showNumber);
			Page<OrgProductItemAll> page = orgProductItemService.queryPageList4View(orgUsersSession, query,pageReq);
			result.put("page",page);
			return result ;	
			
		}else{
			String recentItems = CookieUtil.getCookieValue(request, CookieConstant.COOKIE_USER_RECENT_ITEMS);
			if(StringUtils.isNotBlank(recentItems)){
				itemIds = new ArrayList<Integer>();
				String[] recentItemArr = recentItems.split(",");
				for (int i=0;i<recentItemArr.length-1;i++){
					int itemId = Integer.parseInt(recentItemArr[i]);
					itemIds.add(itemId);
				}
			}
			if(CollectionUtils.isEmpty(itemIds)){
				return result ;
			}else{
				if(itemIds.size()<showNumber){
					showNumber = itemIds.size();
				}
				for (int i = itemIds.size();showNumber>0;i--) {
					showNumber--;
					orgProductItemAll= orgProductItemService.query4View(orgUsersSession, itemIds.get(i-1));	
					itemList.add(orgProductItemAll);
				}
				result.put("itemList",itemList);
				return result ;			
			}
		}
	}
}

