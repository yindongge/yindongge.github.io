package com.kjj.commserver.entity.order.aide;

public class OrgOrderResult {
	
	/** 订单处理结果 */
	private Boolean result = false;
	
	/** 预付费返回码 */
	private Integer depositStatus;
	
	/** 失败说明 */
	private String failDesc;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Integer getDepositStatus() {
		return depositStatus;
	}

	public void setDepositStatus(Integer depositStatus) {
		this.depositStatus = depositStatus;
	}

	public String getFailDesc() {
		return failDesc;
	}

	public void setFailDesc(String failDesc) {
		this.failDesc = failDesc;
	}
	
}
