package com.kjj.commserver.constant;

import com.kjj.commserver.util.CommServerPropertiesUtil;

public class UploadConstant {
	
	public static final String KINDEDITOR_UPLOAD_BASE_PATH = CommServerPropertiesUtil.getProperty("kindEditor_upload_base_path");
	
	public static final String KINDEDITOR_UPLOAD_BASE_URL = CommServerPropertiesUtil.getProperty("kindEditor_upload_base_url");
	
	/** kindEditor编辑器的上传图片目录*/
	public static final String IMAGE = "/image/";
}

