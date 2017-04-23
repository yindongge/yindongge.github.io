package com.kjj.manage.util;

import javax.servlet.http.HttpServletRequest;

public class IpAddressUtil {
	
	/**
	 * 获取客户端IP地址。
	 * @param quest http请求
	 * @return IP地址
	 */
	public static String getIpAddress(HttpServletRequest quest){
		String ip = quest.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = quest.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = quest.getHeader("WL-Proxy-Client-IP");
		}
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = quest.getHeader("HTTP_CLIENT_IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = quest.getHeader("HTTP_X_FORWARDED_FOR");
	    }
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = quest.getRemoteAddr();
		}
		return ip;
	}
}
