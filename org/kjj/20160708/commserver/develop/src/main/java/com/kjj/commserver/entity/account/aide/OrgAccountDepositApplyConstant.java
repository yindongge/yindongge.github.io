package com.kjj.commserver.entity.account.aide;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrgAccountDepositApplyConstant {
	
	/** 申请编码前缀-商城 */
	public static final String APPLY_CODE_PREFIX_SHOP = "SC";
	
	/** 申请编码前缀-车帮 */
	public static final String APPLY_CODE_PREFIX_CHEBANG = "CB";
	
	
	/** 状态-待处理 */
	public static final byte STATUS_DEAL_WAIT = 1;
	
	/** 状态-处理成功 */
	public static final byte STATUS_DEAL_SUCCESS = 2;
	
	/** 状态-处理失败 */
	public static final byte STATUS_DEAL_FAIL = 3;
	
	/** 状态-关闭 */
	public static final byte STATUS_DEAL_CLOSE = 4;
	
	
	/**  类型-消费 */
	public static final byte TYPE_CONSUME = 1;
	
	/** 类型-充值 */
	public static final byte TYPE_RECHARGE = 2;
	
	/** 类型-提现 */
	public static final byte TYPE_CASHED = 3;
	
	/** 类型-退款 */
	public static final byte TYPE_REFOUND = 4;
	
	/** 类型-手动增加 */
	public static final byte TYPE_MANUAL_ADD = 5; 
	
	/** 类型-手动减少 */
	public static final byte TYPE_MANUAL_DEC = 6; 
	
	/** 类型-手动解冻 */
	public static final byte TYPE_MANUAL_UNFROZEN = 7; 
	
	/** 类型-手动冻结 */
	public static final byte TYPE_MANUAL_FROZEN = 8;
	
	/** 类型-系统冻结 */
	public static final byte TYPE_SYSTEM_FROZEN = 9;
	
	/** 类型-系统解冻 */
	public static final byte TYPE_SYSTEM_UNFROZEN = 10; 
	
	/** 类型-转账 */
	public static final byte TYPE_MANUAL_TRANSFER = 11;
	
	
	/** 支付方式-支付宝 */
	public static final byte ONLINE_PAY_STYLE_ALIPAY = 1;
	
	/** 支付方式-微信支付 */
	public static final byte ONLINE_PAY_STYLE_WXPAY = 2;
	
	/** 支付方式-财付通 */
	public static final byte ONLINE_PAY_STYLE_TENPAY = 3;
	
	/** 支付方式-银联支付 */
	public static final byte ONLINE_PAY_STYLE_UNIONPAY = 4;
	
	/** 支付方式-手机微信支付 */
	public static final byte ONLINE_PAY_STYLE_MOBILE_WXPAY = 5;
	
	/** 支付方式-手机支付宝*/
	public static final byte ONLINE_PAY_STYLE_MOBILE_ALIPAY = 6;
	
	/** 支付方式-银行转账 */
	public static final byte ONLINE_PAY_STYLE_BANK_TRANSFERS = 7;
	
	
	
	/** 来源-商城PC版后台 */
	public static final byte SOURCE_SHOP_PC_MANAGE = 1;
	
	/** 来源-商城PC版 */
	public static final byte SOURCE_SHOP_PC = 2;
	
	/** 来源-商城移动版 */
	public static final byte SOURCE_SHOP_MOBILE = 3;
	
	/** 来源-车帮App */
	public static final byte SOURCE_CHEBANGAPP = 4;
	
	
	/** 原因-单条充值 */
	public static final byte REASON_RECHARGE = 1;
	
	/** 原因-奖励 */
	public static final byte REASON_REWARD = 2;
	
	/** 原因-补偿 */
	public static final byte REASON_COMPENSATE = 3;
	
	/** 原因-调账 */
	public static final byte REASON_ADJUSTMENT = 4;
	
	/** 原因-保证金 */
	public static final byte REASON_DEPOSIT = 5;
	
	/** 原因-押金 */
	public static final byte REASON_FOREGIFT = 6;
	
	/** 原因-其他 */
	public static final byte REASON_OTHER = 7;
	
	
	/** 状态 */
	public static Map<String,String> statusMap = new LinkedHashMap<String,String>();
	
	/** 支付方式 */
	public static Map<String,String> payStyleMap = new LinkedHashMap<String,String>();
	
	/** 类型 */
	public static Map<String,String> typeMap = new LinkedHashMap<String,String>();
	
	/** 来源 */
	public static Map<String,String> sourceMap = new LinkedHashMap<String,String>();
	
	/** 原因 */
	public static Map<String,String> reasonMap = new LinkedHashMap<String,String>();
	
	
	
	static {
		statusMap.put("1", "待处理");
		statusMap.put("2", "处理成功");
		statusMap.put("3", "处理失败");
		statusMap.put("4", "关闭");
		
		typeMap.put("1", "消费");
		typeMap.put("2", "充值");
		typeMap.put("3", "提现");
		typeMap.put("4", "退款");
		typeMap.put("5", "手动增加");
		typeMap.put("6", "手动减少");
		typeMap.put("7", "手动解冻");
		typeMap.put("8", "手动冻结");
		typeMap.put("9", "系统冻结");
		typeMap.put("10", "系统解冻");
		
		payStyleMap.put("1", "支付宝");
		payStyleMap.put("2", "微信支付");
		payStyleMap.put("3", "财付通");
		payStyleMap.put("4", "银联支付");
		payStyleMap.put("5", "手机微信支付");
		payStyleMap.put("6", "手机支付宝");
		payStyleMap.put("7", "银行转账");
		
		sourceMap.put("1", "商城PC版后台");
		sourceMap.put("2", "商城PC版");
		sourceMap.put("3", "商城移动版");
		sourceMap.put("4", "车帮App");
		
		reasonMap.put("1", "单条充值");
		reasonMap.put("2", "奖励");
		reasonMap.put("3", "补偿");
		reasonMap.put("4", "调账");
		reasonMap.put("5", "保证金");
		reasonMap.put("6", "押金");
		reasonMap.put("7", "其他");
		
	}
	
	
	
}
