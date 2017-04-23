package com.kjj.commserver.entity.shop.aide;

import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgShopSendRange;

public class OrgShopSendRangeVo extends OrgShopSendRange {
	
	/** 区域 */
	private OrgArea orgArea;
	
	/** 区域数组  */
	private String[] area;
	
	/** 距离  */
	private Double distance;
	
	public OrgArea getOrgArea() {
		return orgArea;
	}

	public void setOrgArea(OrgArea orgArea) {
		this.orgArea = orgArea;
		String[] areaTemp = orgArea.getShow().split("-");
		area = new String[3];
		for(int i=0;i<areaTemp.length;i++){
			area[i] = areaTemp[i];
		}
	}

	public String[] getArea() {
		return area;
	}

	public void setArea(String[] area) {
		this.area = area;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
}