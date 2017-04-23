package com.kjj.commserver.entity.order.aide;

public class OrgOrderUserCount {
	
	public static final OrgOrderUserCount ORDER_COUNT_NULL = new OrgOrderUserCount(0,0,0,0);
	/** 用户ID */
	private Integer userId;
	/** 待付款订单数量 */
	private Integer waitPaidCount;
	/** 待收货订单数量 */
	private Integer waitSendCount;
	/** 待自提订单数量 */
	private Integer waitTakeCount;
	/** 待评价订单数量 */
	private Integer waitCommentCount;
	
	public OrgOrderUserCount() {
		super();
	}
	public OrgOrderUserCount(Integer waitPaidCount, Integer waitSendCount,
			Integer waitTakeCount, Integer waitCommentCount) {
		super();
		this.waitPaidCount = waitPaidCount;
		this.waitSendCount = waitSendCount;
		this.waitTakeCount = waitTakeCount;
		this.waitCommentCount = waitCommentCount;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getWaitPaidCount() {
		return waitPaidCount;
	}
	public void setWaitPaidCount(Integer waitPaidCount) {
		this.waitPaidCount = waitPaidCount;
	}
	public Integer getWaitSendCount() {
		return waitSendCount;
	}
	public void setWaitSendCount(Integer waitSendCount) {
		this.waitSendCount = waitSendCount;
	}
	public Integer getWaitTakeCount() {
		return waitTakeCount;
	}
	public void setWaitTakeCount(Integer waitTakeCount) {
		this.waitTakeCount = waitTakeCount;
	}
	public Integer getWaitCommentCount() {
		return waitCommentCount;
	}
	public void setWaitCommentCount(Integer waitCommentCount) {
		this.waitCommentCount = waitCommentCount;
	}
}

