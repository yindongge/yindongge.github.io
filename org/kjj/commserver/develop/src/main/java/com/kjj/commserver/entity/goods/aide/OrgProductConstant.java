package com.kjj.commserver.entity.goods.aide;

public class OrgProductConstant {
	/**上下架状态：下架*/
	public final static Byte IS_ON_SALE_OFF = 0;
	/**上下架状态：上架*/
	public final static Byte IS_ON_SALE_ON = 1;
	/**是否删除：是*/
	public final static Byte IS_DELETE = 1;
	/**是否删除：否*/
	public final static Byte IS_NOT_DELETE = 0;
	
	public final static String SEPARATOR = "&";
	
	/** 下架类型：1新增 */
	public final static Byte OFF_SALE_TYPE_ADD = 1;
	/** 下架类型：2手动下架 */
	public final static Byte OFF_SALE_TYPE_MANUAL = 2;
	/** 下架类型：3系统违规*/
	public final static Byte OFF_SALE_TYPE_ILLEGAL = 3;
	/** 下架类型：4编辑 */
	public final static Byte OFF_SALE_TYPE_EDIT = 4;
	
	/**完善状态：0未完成1完成2待补充3待修改*/
	public final static Byte IS_SHIPPING_UNFINISHED = 0 ;
}
