package com.kjj.commserver.entity.discount.aide;

import com.kjj.commserver.entity.discount.OrgDiscountProduct;

public class OrgDiscountProductVo extends OrgDiscountProduct {
	
	/** 分类名称 */
    private String className;
    /** 父分类id */
    private Integer classParent;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getClassParent() {
		return classParent;
	}

	public void setClassParent(Integer classParent) {
		this.classParent = classParent;
	}


    
}