package com.kjj.commserver.entity.order.aide;

import com.kjj.commserver.entity.order.OrgOrderLog;

public class OrgOrderLogQuery extends OrgOrderLog {
	
	/** 日志显示为不为空 */
	private Boolean typeShowNotNull;

	public Boolean getTypeShowNotNull() {
		return typeShowNotNull;
	}

	public void setTypeShowNotNull(Boolean typeShowNotNull) {
		this.typeShowNotNull = typeShowNotNull;
	}
	
}