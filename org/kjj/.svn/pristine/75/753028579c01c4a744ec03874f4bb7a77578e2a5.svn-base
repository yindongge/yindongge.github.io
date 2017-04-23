package com.kjj.mobile.util;

import java.io.InputStreamReader;
import java.util.Properties;

public class MobilePropertiesUtil {
	public static Properties serverProperties = new Properties();
	public static String FILE_NAME = "mobile.properties";

	public MobilePropertiesUtil() {
	}

	static {
		init();
	}

	private static void init() {
		try {
			if (serverProperties == null)
				serverProperties = new Properties();
			serverProperties.load(new InputStreamReader(MobilePropertiesUtil.class.getClassLoader().getResourceAsStream(FILE_NAME), "UTF-8"));
		} catch (Exception e) {
			System.out.println("初始化配置文件出错了!!!!!");
		}
	}

	public static String getProperty(String str) {
		if (serverProperties == null) {
			serverProperties = new Properties();
			init();
		}
		String property = serverProperties.getProperty(str) == null ? ""
				: serverProperties.getProperty(str);
		return property;
	}

	public static void reinit() {
		try {
			serverProperties.load(new InputStreamReader(MobilePropertiesUtil.class.getClassLoader().getResourceAsStream(FILE_NAME), "UTF-8"));
		} catch (Exception e) {
			System.out.println("初始化配置文件出错了!!!!!");
		}
	}

	public static void main(String[] args) {
		System.out.println(MobilePropertiesUtil.getProperty("template.mark"));
	}
}
