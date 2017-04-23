package com.kjj.commserver.entity.user.aide;

import java.util.List;

import com.kjj.commserver.entity.shop.OrgShopSendRange;
import com.kjj.commserver.entity.user.OrgUserAddress;

public class OrgUserAddressVo extends OrgUserAddress {
	
	/** 配送范围名称 */
	private String sendRangeName;
	
	/** 区域显示 */
	private String areaShow;
	
	/** 店铺名称 */
    private String shopName;
    
    /** 区域数组  */
	private String[] area;
	
	/** 配送范围 */
	List<OrgShopSendRange> listSendRange;

	public List<OrgShopSendRange> getListSendRange() {
		return listSendRange;
	}

	public void setListSendRange(List<OrgShopSendRange> listSendRange) {
		this.listSendRange = listSendRange;
	}

	public String[] getArea() {
		return area;
	}

	public void setArea(String[] area) {
		this.area = area;
	}
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getSendRangeName() {
		return sendRangeName;
	}

	public void setSendRangeName(String sendRangeName) {
		this.sendRangeName = sendRangeName;
	}

	public String getAreaShow() {
		return areaShow;
	}

	public void setAreaShow(String areaShow) {
		this.areaShow = areaShow;
		String[] areaTemp = areaShow.split("-");
		area = new String[3];
		for(int i=0;i<areaTemp.length;i++){
			area[i] = areaTemp[i];
		}
	}
	
}