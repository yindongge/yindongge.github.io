package com.kjj.commserver.entity.order.aide;

public class OrgOrderGoodsConstant {
	
	/** 评价状态 0：未评价 1：已评价 */
	public static final byte COMMENT_STATUS_UNCOMMENT = 0;
	/** 评价状态 0：未评价 1：已评价 */
	public static final byte COMMENT_STATUS_COMMENTED = 1;
	
	
	public static final byte REPLY_STATUS_WAIT = 0;
	
	public static final byte REPLY_STATUS_REPLIED = 1;
	
	public static final byte STATUS_SHOW = 0;
	
	public static final byte STATUS_HIDE = 1;
	
	/** 支付状态 0:未支付 1:已支付 */
	public static final byte PAY_STATUS_UNPAID =0;
	/** 支付状态 0:未支付 1:已支付 */
	public static final byte PAY_STATUS_PAID =1;
	
	
	/** 支付方式 0：在线支付 1：货到付款 */
	public static final byte PAY_STYLE_ONLINE=0;
	/** 支付方式 0：在线支付 1：货到付款 */
	public static final byte PAY_STYLE_COD=1;
	
	
	/** 配送方式 0：送货上门 1：到店自取 */
	public static final byte SEND_STYLE_SENDGOODS=0;
	/** 配送方式 0：送货上门 1：到店自取 */
	public static final byte SEND_STYLE_TAKEGOODS=1;
	
	
}
