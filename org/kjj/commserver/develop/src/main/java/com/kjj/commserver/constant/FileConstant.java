package com.kjj.commserver.constant;

import com.kjj.commserver.util.CommServerPropertiesUtil;

public class FileConstant {
	
	public static final String FILE_BASE_PATH = CommServerPropertiesUtil.getProperty("file_base_path");
	
	public static final String FILE_BASE_URL = CommServerPropertiesUtil.getProperty("file_base_url");
	
	/** 订单统计 */
	public static final String ORDER_REPORT = "/orderReport/";
	
	/** 商品统计 */
	public static final String GOODS_REPORT = "/goodsReport/";

}
