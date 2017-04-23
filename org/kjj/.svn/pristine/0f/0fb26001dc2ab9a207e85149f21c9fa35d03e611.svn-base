package com.kjj.commserver.util;

import java.io.InputStreamReader;
import java.util.Properties;

public class CommServerPropertiesUtil {
	public static Properties serverProperties = new Properties();
	public static String FILE_NAME = "commserver.properties";

	public CommServerPropertiesUtil() {
	}

	static {
		init();
	}

	private static void init() {
		try {
			if (serverProperties == null)
				serverProperties = new Properties();
			serverProperties.load(new InputStreamReader(CommServerPropertiesUtil.class.getClassLoader().getResourceAsStream(FILE_NAME), "UTF-8"));
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
			serverProperties.load(new InputStreamReader(CommServerPropertiesUtil.class.getClassLoader().getResourceAsStream(FILE_NAME), "UTF-8"));
		} catch (Exception e) {
			System.out.println("初始化配置文件出错了!!!!!");
		}
	}

	public static void main(String[] args) {
		System.out.println(CommServerPropertiesUtil.getProperty("template.mark"));
	}
}
