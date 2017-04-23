package com.kjj.commserver.service.swap.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.swap.Org_RX_Product;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.swap.RxProductService;
import com.kjj.commserver.util.CommServerPropertiesUtil;
import com.kjj.commserver.util.HttpClientUtil;

@Service
public class RxProductServiceImpl implements RxProductService {
	
	
	/**
	 * 获取瑞星库存
	 * @param orgUsersSession
	 * @param mapItemAide
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Org_RX_Product> getRxInventoryMap(OrgUsersSession orgUsersSession,Map<Integer,OrgProductItemAide> mapItemAide) {
		Map<String, Org_RX_Product> mapProduct = new HashMap<String, Org_RX_Product>();
		StringBuilder goods_sns = new StringBuilder();
		for(OrgProductItemAide itemAide:mapItemAide.values()){
			goods_sns.append(itemAide.getGoodsSn()+",");
		}
		HttpClientUtil util = HttpClientUtil.getInstance("UTF-8");
		Map params = new HashMap();
		params.put("shop_code",orgUsersSession.getOrgShop().getShopCode());
		params.put("goods_sns",goods_sns.substring(0, goods_sns.length()-1));
		String strResult = null;
		try {
			strResult = util.getResponseBodyAsString(CommServerPropertiesUtil.getProperty("rxservice.url")+"/order/getRealMap", params);
		} catch (Exception e) {
		}
		if(strResult!=null){
			Gson gson = new  Gson();
			mapProduct = gson.fromJson(strResult, new TypeToken<HashMap<String, Org_RX_Product>>(){}.getType()); 
		}
		return mapProduct;
	}
}
