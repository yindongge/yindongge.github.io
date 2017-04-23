package com.kjj.commserver.entity.goods.aide;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrgProductInventoryClearConstant {
	public static Map<String,String> timeTypeMap = new LinkedHashMap<String,String>(); // 时间类型
	
	static {
	
		timeTypeMap.put("1", "11:00");
		timeTypeMap.put("2", "11:10");
		timeTypeMap.put("3", "11:20");
		timeTypeMap.put("4", "11:30");
		timeTypeMap.put("5", "11:40");
		timeTypeMap.put("6", "11:50");
		timeTypeMap.put("7", "12:00");
		timeTypeMap.put("8", "12:10");
		timeTypeMap.put("9", "12:20");
		timeTypeMap.put("10", "12:30");
		timeTypeMap.put("11", "12:40");
		timeTypeMap.put("12", "12:50");
		timeTypeMap.put("13", "13:00");
		
	}
}
