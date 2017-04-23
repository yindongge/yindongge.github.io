package com.kjj.commserver.entity.goods.aide;

import com.kjj.commserver.entity.goods.OrgProductPropertyValue;

public class OrgProductPropertyValueVo extends OrgProductPropertyValue {
	/**是否选中*/
	private boolean isSelect = false;
	
	/** 属性名称 */
	private String propertyName;

	public boolean getIsSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	
}