package com.kjj.commserver.constant;

import com.kjj.commserver.util.CommServerPropertiesUtil;


public class ImageConstant {
	
	public static final String IMAGE_BASE_PATH = CommServerPropertiesUtil.getProperty("image_base_path");
	
	public static final String IMAGE_BASE_URL = CommServerPropertiesUtil.getProperty("image_base_url");
	
	/** 各门店首页相关图片 */
	public static final String SHOP_PAGE = "/shopPage/";
	
	/** 企业的组织机构和营业执照 */
	public static final String ENTERPRISE = "/enterprise/";
	
	/** 退货商品 */
	public static final String RETURN_GOODS = "/return/";
	
	/** 商品 */
	public static final String GOODS = "/goods/";
	
	/** 品牌 */
	public static final String BRAND = "/brand/";
	
	/** 文章 */
	public static final String ARTICLE = "/article/";
	
	/** 专题 */
	public static final String SPECIAL = "/special/";
	
	/** 富文本 */
	public static final String UPLOAD = "/upload/";
	
	/** 活动 */
	public static final String ACTIVITY = "/activity/";
	
	
	
	
}
