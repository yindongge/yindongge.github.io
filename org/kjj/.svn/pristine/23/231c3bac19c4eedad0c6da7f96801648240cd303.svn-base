package com.kjj.commserver.entity.user.aide;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.util.CommServerPropertiesUtil;

public class OrgUserLevelConstant {
	
	public static String LEVEL_USER_TYPE_NORMAL_USER = "18";       // 会员等级-普通会员，为单人用户使用
	
	public static String LEVEL_USER_TYPE_SENIOR_USER = "19";       // 会员等级-vip会员，为单人用户使用
	
	public static String LEVEL_USER_TYPE_NORMAL_ENTERPRISE = "20"; // 会员等级-金牌会员,为关联企业会员（单人用户）使用
	
	public static String LEVEL_USER_TYPE_SENIOR_ENTERPRISE = "21"; // 会员等级-企业会员，为正常的企业会员的使用
	
	public static String LEVEL_USER_TYPE_SUPER_ENTERPRISE = "22"; //  会员等级-内部会员,为关联企业会员（单人用户）使用
	
	
	public static final byte LEVEL_TYPE_USER = 1;            // 会员类型-个人用户
	
	public static final byte LEVEL_TYPE_ENTERPRISE = 2;      // 会员类型-企业用户
	
	public static final byte LEVEL_TYPE_ENTERPRISE_USER = 3; // 会员类型-关联企业用户
	
	
	static {
		String configContent = CommServerPropertiesUtil.getProperty("userlevelprimary.normaluser");
		if(StringUtils.isNotBlank(configContent)) {
			LEVEL_USER_TYPE_NORMAL_USER = configContent;
		}
		
		configContent = CommServerPropertiesUtil.getProperty("userlevelprimary.senioruser");
		if(StringUtils.isNotBlank(configContent)) {
			LEVEL_USER_TYPE_SENIOR_USER = configContent;
		}
		
		configContent = CommServerPropertiesUtil.getProperty("userlevelprimary.normalenterprise");
		if(StringUtils.isNotBlank(configContent)) {
			LEVEL_USER_TYPE_NORMAL_ENTERPRISE = configContent;
		}
		
		configContent = CommServerPropertiesUtil.getProperty("userlevelprimary.seniorenterprise");
		if(StringUtils.isNotBlank(configContent)) {
			LEVEL_USER_TYPE_SENIOR_ENTERPRISE = configContent;
		}
		
	}
	
}
