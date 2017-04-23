package com.kjj.commserver.service.swap;

import java.util.Map;

import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.swap.Org_RX_Product;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;

public interface RxProductService {
	
	/**
	 * 获取瑞星库存
	 * @param orgUsersSession
	 * @param mapItemAide
	 * @return
	 */
	Map<String, Org_RX_Product> getRxInventoryMap(OrgUsersSession orgUsersSession,Map<Integer,OrgProductItemAide> mapItemAide);
}
