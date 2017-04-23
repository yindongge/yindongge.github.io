package com.kjj.commserver.entity.shop.aide;

import java.util.Calendar;
import java.util.Date;

import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgShop;

public class OrgShopVo extends OrgShop {
	
	/** 区域 */
	private OrgArea orgArea;
	
	/** 区域数组  */
	private String[] area;
	
	/** 距离  */
	private Double distance;
	
	/** 最迟下单送货时间 */
	private Date latestSendTime;
	
	/** 对应热门搜索 */
    private String shopSearch;
    
    /** 店铺是否有送餐服务 */
    private Boolean hasMealService;

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

	public Date getLatestSendTime() {
		return latestSendTime;
	}

	public void setLatestSendTime(Date latestSendTime) {
		this.latestSendTime = latestSendTime;
	}
	
	@Override
    public void setSendTimeAmEnd(Date sendTimeAmEnd) {
    	super.setSendTimeAmEnd(sendTimeAmEnd);
    	if(sendTimeAmEnd != null){
	    	Date temp = getMarginTime(sendTimeAmEnd);
	    	if(getLatestSendTime() == null || getLatestSendTime().before(temp)){
	    		setLatestSendTime(temp);
	    	}
    	}
    	
    }
    
	@Override
    public void setSendTimeNoonEnd(Date sendTimeNoonEnd) {
    	super.setSendTimeNoonEnd(sendTimeNoonEnd);
    	if(sendTimeNoonEnd != null){
	    	Date temp = getMarginTime(sendTimeNoonEnd);
	    	if(getLatestSendTime() == null || getLatestSendTime().before(temp)){
	    		setLatestSendTime(temp);
	    	}
    	}
    }

	@Override
    public void setSendTimePmEnd(Date sendTimePmEnd) {
    	super.setSendTimePmEnd(sendTimePmEnd);
    	if(sendTimePmEnd != null){
	    	Date temp = getMarginTime(sendTimePmEnd);
	    	if(getLatestSendTime() == null || getLatestSendTime().before(temp)){
	    		setLatestSendTime(temp);
	    	}
    	}
    }
    
	@Override
    public void setSendTimeNightEnd(Date sendTimeNightEnd) {
    	super.setSendTimeNightEnd(sendTimeNightEnd);
    	if(sendTimeNightEnd != null){
	    	Date temp = getMarginTime(sendTimeNightEnd);
	    	if(getLatestSendTime() == null ||getLatestSendTime().before(temp)){
	    		setLatestSendTime(temp);
	    	}
    	}
    }
    
    /**
	 * 获取配送富余量时间
	 * @param endTime
	 * @return
	 */
	private Date getMarginTime(Date endTime){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endTime);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - OrgOrderConstant.SEND_MARGIN_TIME_MINUTE);
		return calendar.getTime();
	}

	public String getShopSearch() {
		return shopSearch;
	}

	public void setShopSearch(String shopSearch) {
		this.shopSearch = shopSearch;
	}

	public Boolean getHasMealService() {
		return hasMealService;
	}

	public void setHasMealService(Boolean hasMealService) {
		this.hasMealService = hasMealService;
	}
}