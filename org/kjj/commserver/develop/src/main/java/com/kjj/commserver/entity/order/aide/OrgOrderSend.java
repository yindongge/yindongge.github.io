package com.kjj.commserver.entity.order.aide;

public class OrgOrderSend {
	private String[] date;
	private String[] week;
	private String[][] time;
	private Boolean[][] isSend;
	private Boolean[] isTake;
	private String defaultSendDate;
	private String defaultSendWeek;
	private String[] defaultSendTime;
	private String defaultTakeDate;
	private String defaultTakeWeek;
	private String openTime;
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public String[] getWeek() {
		return week;
	}
	public void setWeek(String[] week) {
		this.week = week;
	}
	public String[][] getTime() {
		return time;
	}
	public void setTime(String[][] time) {
		this.time = time;
	}
	public Boolean[][] getIsSend() {
		return isSend;
	}
	public void setIsSend(Boolean[][] isSend) {
		this.isSend = isSend;
	}
	public Boolean[] getIsTake() {
		return isTake;
	}
	public void setIsTake(Boolean[] isTake) {
		this.isTake = isTake;
	}
	public String getDefaultSendDate() {
		return defaultSendDate;
	}
	public void setDefaultSendDate(String defaultSendDate) {
		this.defaultSendDate = defaultSendDate;
	}
	public String getDefaultSendWeek() {
		return defaultSendWeek;
	}
	public void setDefaultSendWeek(String defaultSendWeek) {
		this.defaultSendWeek = defaultSendWeek;
	}
	public String[] getDefaultSendTime() {
		return defaultSendTime;
	}
	public void setDefaultSendTime(String[] defaultSendTime) {
		this.defaultSendTime = defaultSendTime;
	}
	public String getDefaultTakeDate() {
		return defaultTakeDate;
	}
	public void setDefaultTakeDate(String defaultTakeDate) {
		this.defaultTakeDate = defaultTakeDate;
	}
	public String getDefaultTakeWeek() {
		return defaultTakeWeek;
	}
	public void setDefaultTakeWeek(String defaultTakeWeek) {
		this.defaultTakeWeek = defaultTakeWeek;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	
}
