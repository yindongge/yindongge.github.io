package com.kjj.commserver.entity.shop.aide;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgShop;

public class OrgAreaVo extends OrgArea {
	
	/*  **/
	private  List<OrgShop> listShop;

	public List<OrgShop> getListShop() {
		return listShop;
	}

	public void setListShop(List<OrgShop> listShop) {
		this.listShop = listShop;
	}
	
	
}