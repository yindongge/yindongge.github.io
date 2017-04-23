package com.kjj.pc.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUTF8Util extends CookieUtil{
	
	/**
	 * 设置cookie转码
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 */
	public static void addCookieDefaultAge(HttpServletResponse response, String name,String value) {
		try {
			CookieUtil.addCookieDefaultAge(response, name, URLEncoder.encode(value,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	/**
	 * 根据名字获取cookie值
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request, String name) {
		String cookieValue = CookieUtil.getCookieValue(request,name);
		if(cookieValue != null){
			try {
				cookieValue = URLDecoder.decode(cookieValue,"UTF-8");
			} catch (UnsupportedEncodingException e) {
			}
		}
		return cookieValue;
	}
}
