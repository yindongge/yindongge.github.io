package com.kjj.commserver.entity.order.aide;

public class OrgOrderLogConstant {
	
	public static final byte SOURCE_USER = 0;
	
	public static final byte SOURCE_SYSTEM = 1;
	
	public static final byte SOURCE_ADMIN = 2;
	
	
	public static final byte TYPE_USER_CREATE = 1;
	
	public static final byte TYPE_USER_ONLINE_PAY = 2;
	
	public static final byte TYPE_USER_ONLINE_PAY_SUCCESS = 3;
	
	public static final byte TYPE_SYSTEM_SELF_NOTICE = 4;
	
	public static final byte TYPE_ADMIN_CONFIRE = 5;
	
	public static final byte TYPE_SYSTEM_CONFIRE = 6;
	
	public static final byte TYPE_ADMIN_SEND = 7;
	
	public static final byte TYPE_USER_FINISH = 8;
	
	public static final byte TYPE_ADMIN_FINISH = 9;
	
	public static final byte TYPE_USER_CANCEL = 10;
	
	public static final byte TYPE_ADMIN_CANCEL = 11;
	
	public static final byte TYPE_SYSTEM_TIMEOUT_COLSE = 12;
	
	public static final byte TYPE_ADMIN_RETURN_COLSE = 13;
	
	public static final byte TYPE_ADMIN_TAKE = 14;
	
	public static final byte TYPE_ADMIN_TO_SERVER = 15;
	
	public static final byte TYPE_ADMIN_TO_SHOP = 16;
	
	public static final byte TYPE_ADMIN_REMARK = 126;
	
	public static final byte TYPE_SYSTEM_REMARK = 127;
	
}
