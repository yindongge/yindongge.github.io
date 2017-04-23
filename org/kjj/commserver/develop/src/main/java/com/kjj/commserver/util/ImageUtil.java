package com.kjj.commserver.util;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;

/**
 * @Title: ImageUtil.java
 * @Package com.kjj.commserver.util
 * @Description:  图片相关处理方法(本项目将图片保存在项目外)
 * @author ZYLORG
 * @date 2016年7月13日 下午4:02:27
 * @copyright Beijing KJJ Electronic commerce Co., LTD
 * @version V1.0   
 */
public class ImageUtil {
	
	/**
	 * 设置图片读取路径
	 * @param imagePath 数据库中的路径
	 * @return
	 */
	public static String setReadPath(String imagePath){
		return setReadPath(ImageConstant.IMAGE_BASE_URL, imagePath);
	}
	
	/**
	 * 设置图片读取路径
	 * @param BasePath 绝对路径
	 * @param imagePath 数据库中的路径
	 * @return
	 */
	public static String setReadPath(String BasePath,String imagePath){
		if(StringUtils.isNotEmpty(imagePath)){
			if(!imagePath.contains(BasePath)){
				imagePath = BasePath + imagePath;			
			}
		}
		return imagePath;
	}
	
	/**
	 * 设置图片保存路径
	 * @param imagePath 数据库中的路径
	 * @return
	 */
	public static String setSavePath(String imagePath){
		return setSavePath(ImageConstant.IMAGE_BASE_URL, imagePath);
	}
	
	/**
	 * 设置图片保存路径
	 * @param BasePath 绝对路径
	 * @param imagePath 数据库中的路径
	 * @return
	 */
	public static String setSavePath(String BasePath,String imagePath){
		BasePath=BasePath.replace("\\:", ":");
		if(StringUtils.isNotEmpty(imagePath)){
			if(imagePath.contains(BasePath)){
				imagePath = imagePath.replace(BasePath, "");			
			}
		}
		return imagePath;
	}
	
	
	
}

